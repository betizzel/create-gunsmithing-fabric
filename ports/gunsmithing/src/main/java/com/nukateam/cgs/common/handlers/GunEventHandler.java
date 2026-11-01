package com.nukateam.cgs.common.handlers;

import com.nukateam.cgs.common.faundation.registry.items.CgsAttachments;
import com.nukateam.cgs.common.faundation.registry.items.CgsWeapons;
import com.nukateam.cgs.common.ntgl.CgsAmmoHolders;
import com.nukateam.cgs.common.utils.GunUtils;
import com.nukateam.ntgl.common.data.holders.AmmoHolder;
import com.nukateam.ntgl.common.data.holders.AttachmentType;
import com.nukateam.ntgl.common.util.helpers.context.AmmoContext;
import com.nukateam.ntgl.common.util.helpers.context.IAmmoContext;
import com.nukateam.ntgl.common.util.util.FuelUtils;
import com.nukateam.ntgl.common.data.WeaponData;
import com.nukateam.ntgl.common.util.util.InventoryUtil;
import com.nukateam.ntgl.common.util.util.WeaponModifierHelper;
import com.nukateam.ntgl.common.util.util.WeaponStateHelper;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.equipment.armor.BacktankBlockEntity;
import com.simibubi.create.content.equipment.armor.BacktankUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import com.nukateam.ntgl.common.foundation.entity.ProjectileEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;

import static com.nukateam.cgs.common.utils.GunUtils.fillFuel;
import static net.minecraft.world.phys.HitResult.Type.BLOCK;

public class GunEventHandler {
    public static boolean preShoot(LivingEntity shooter, ItemStack stack, InteractionHand hand) {
        var gun = shooter.getItemInHand(hand);
        var gunData = new WeaponData(gun, shooter);
        var hasExtendoGrip = shooter.getOffhandItem().getItem() == AllItems.EXTENDO_GRIP.get();

        if(hasExtendoGrip && !WeaponModifierHelper.isOneHanded(gunData)){
            return true;
        }

        if(gun.getItem() == CgsWeapons.LAUNCHER &&
                WeaponStateHelper.getAttachmentItem(AttachmentType.MAGAZINE, gun).getItem() == CgsAttachments.BALLISTAZOOKA) {
            return false;
        }

//        if(gun.getItem() == CgsWeapons.NAILGUN.get()) {
            if (isUsesFuel(gunData, CgsAmmoHolders.AIR) && !GunUtils.hasAir(gunData) ) {
                return true;
            }
//        }
        return false;
    }

    public static void postShoot(LivingEntity shooter, ItemStack gun, InteractionHand hand) {
        var data = new WeaponData(gun, shooter);
        var fuels = WeaponModifierHelper.getAllFuel(data);
        if (fuels.contains(CgsAmmoHolders.BURNABLE)) {
            FuelUtils.addFuel(data, CgsAmmoHolders.BURNABLE, -1);
        }
        if (fuels.contains(CgsAmmoHolders.WATER)) {
            FuelUtils.addFuel(data, CgsAmmoHolders.WATER, -5);
        }
        if (fuels.contains(CgsAmmoHolders.AIR)) {
            consumeAir(data);
        }
        var grenade = AmmoHolder.getType(BuiltInRegistries.ITEM.getKey(CgsWeapons.GRENADE));
        if (fuels.contains(grenade)) {
            FuelUtils.addFuel(data, grenade, -1);
        }

        if (gun.getItem() == CgsWeapons.SHOTGUN) {
            checkCock(data);
        }
}

    public static boolean preReload(WeaponData eventData, InteractionHand hand) {
        var gun = eventData.weapon;
        var shooter = eventData.wielder;
        var data = new WeaponData(gun, shooter);

        if(!shooter.level().isClientSide && shooter instanceof Player player) {
            var fuels = WeaponModifierHelper.getAllFuel(data);
            fuels.forEach((fuel) -> {
                var foundFuel = (IAmmoContext)AmmoContext.NONE;
//                do {
                    var fuelCount = FuelUtils.getFuel(gun, fuel);
                    var maxFuel = WeaponModifierHelper.getMaxFuel(fuel.getId(), data);
                    if (fuelCount < maxFuel){
                        foundFuel = InventoryUtil.findPlayerAmmo(player, fuel);
                        if(foundFuel != AmmoContext.NONE){
                            if(fuelCount <= Math.min(0, maxFuel - fuel.getValue(foundFuel.stack()))){
                                fillFuel(gun, player, foundFuel.stack());
                            }
                        }
                    }
//                }
//                while (foundFuel != AmmoContext.NONE && fuelCount <= Math.min(0, maxFuel - fuel.getValue(foundFuel.stack())));
            });
        }
        return false;
    }
    public static void postReload(WeaponData eventData, InteractionHand hand) {
        var gun = eventData.weapon;
        var shooter = eventData.wielder;
        var data = new WeaponData(gun, shooter);

        if(!shooter.level().isClientSide) {
            if (gun.getItem() == CgsWeapons.SHOTGUN) {
                checkCock(data);
            }
            if (gun.getItem() == CgsWeapons.LAUNCHER) {
                consumeAir(data);
            }
        }
    }

    private static void checkCock(WeaponData data) {
        var ammoCount = WeaponStateHelper.getAmmoCount(data);
        var isEven = WeaponStateHelper.getAmmoCount(data) % 2 == 0;
        var id = 0;

        if (ammoCount != 0) {
            id = isEven ? 2 : 1;
        }

        GunUtils.setCock(data.weapon, id);
    }

    public static boolean consumeAir(WeaponData data) {
        var amount = WeaponModifierHelper.getFuelAmountPerUse(CgsAmmoHolders.AIR.getId(), data);

        if (amount == 0) return false;

        if (data.wielder instanceof Player player && player.isCreative())
            return true;

        var backtanks = BacktankUtil.getAllWithAir(data.wielder);

        if (!backtanks.isEmpty()) {
            BacktankUtil.consumeAir(data.wielder, backtanks.get(0), amount);
        } else {
            FuelUtils.consumeFuel(CgsAmmoHolders.AIR, data); //.addFuel(data, CgsAmmo.AIR, -5);
        }
        return true;
    }

    public static boolean isUsesFuel(WeaponData data, AmmoHolder ammo) {
        return WeaponModifierHelper.getAllFuel(data).stream().anyMatch((i) -> i.getId().equals(ammo.getId()));
    }

    public static boolean hasAirInTank(WeaponData data) {
        if (data.wielder instanceof Player player && player.isCreative())
            return true;

        var backtanks = BacktankUtil.getAllWithAir(data.wielder);

        if (backtanks.isEmpty())
            return false;

        var cost = WeaponModifierHelper.getFuelAmountPerUse(CgsAmmoHolders.AIR.getId(), data);
        return BacktankUtil.getAir(backtanks.get(0)) >= cost;
    }

    public static boolean onHit(HitResult hitResult, ProjectileEntity projectile) {
        var shooter = projectile.getShooter();
        if(shooter == null) return false;
        var level = shooter.level();
        var pos = hitResult.getLocation();
        var type = hitResult.getType();

        if(type == BLOCK){
            var blockPos = new BlockPos((int)pos.x, (int)pos.y, (int)pos.z);
            var blockState = level.getBlockState(blockPos);
            var blockEntity = level.getBlockEntity(blockPos);

            if(blockState.getBlock() == AllBlocks.COPPER_BACKTANK.get()
                    && blockEntity instanceof BacktankBlockEntity tankEntity){
                var airLevel = tankEntity.getAirLevel();
                int max = BacktankUtil.maxAir(0);
                 if(airLevel >= max / 3){
                     explodeOnHit(level, blockPos);
                 }
            }
        }
        return false;
    }

    public static void explodeOnHit(Level level, BlockPos pos) {
        if (!level.isClientSide) {
            level.destroyBlock(pos, false);
            level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 6.0f, Level.ExplosionInteraction.NONE);
        }
    }
}