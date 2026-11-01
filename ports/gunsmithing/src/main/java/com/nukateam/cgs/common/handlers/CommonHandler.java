package com.nukateam.cgs.common.handlers;

import com.nukateam.cgs.common.ntgl.CgsProjectileRegistry;
import com.nukateam.ntgl.common.event.WeaponEvents;
import com.nukateam.ntgl.common.event.FuelBurnTime;
import com.nukateam.cgs.common.faundation.registry.items.CgsItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.EmptyItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.FullItemFluidStorage;
import net.minecraft.world.level.material.Fluids;

public final class CommonHandler {
    private CommonHandler() {}

    public static void init() {
        FuelRegistry.INSTANCE.add(CgsItems.LAVA_CONTAINER, 20000);
        FuelBurnTime.EVENT.register(stack -> stack.is(CgsItems.LAVA_CONTAINER) ? 20000 : FuelBurnTime.PASS);
        FluidStorage.combinedItemApiProvider(CgsItems.EMPTY_CONTAINER).register(context ->
                new EmptyItemFluidStorage(context, CgsItems.WATER_CONTAINER, Fluids.WATER, FluidConstants.BUCKET));
        FluidStorage.combinedItemApiProvider(CgsItems.EMPTY_CONTAINER).register(context ->
                new EmptyItemFluidStorage(context, CgsItems.LAVA_CONTAINER, Fluids.LAVA, FluidConstants.BUCKET));
        FluidStorage.ITEM.registerForItems((stack, context) ->
                new FullItemFluidStorage(context, CgsItems.EMPTY_CONTAINER, FluidVariant.of(Fluids.WATER), FluidConstants.BUCKET),
                CgsItems.WATER_CONTAINER);
        FluidStorage.ITEM.registerForItems((stack, context) ->
                new FullItemFluidStorage(context, CgsItems.EMPTY_CONTAINER, FluidVariant.of(Fluids.LAVA), FluidConstants.BUCKET),
                CgsItems.LAVA_CONTAINER);
        CgsProjectileRegistry.registerProjectiles();
        WeaponEvents.FIRE_PRE.register(GunEventHandler::preShoot);
        WeaponEvents.FIRE_POST.register(GunEventHandler::postShoot);
        WeaponEvents.RELOAD_PRE.register(GunEventHandler::preReload);
        WeaponEvents.RELOAD_POST.register(GunEventHandler::postReload);
        WeaponEvents.PROJECTILE_HIT.register(GunEventHandler::onHit);
        WeaponEvents.MELEE_PRE.register(MeleeHandler::onMelee);
    }
}
