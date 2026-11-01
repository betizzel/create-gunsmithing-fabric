package com.nukateam.cgs.common.faundation.registry;

import com.nukateam.cgs.Gunsmithing;
import com.nukateam.cgs.common.faundation.registry.items.CgsAmmo;
import com.nukateam.cgs.common.faundation.registry.items.CgsAttachments;
import com.nukateam.cgs.common.faundation.registry.items.CgsItems;
import com.nukateam.cgs.common.faundation.registry.items.CgsWeapons;
import com.nukateam.ntgl.common.util.helpers.RegistrationHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CgsItemTabs {
    public static final CreativeModeTab CGS = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Gunsmithing.cgsResource("mod_items"), FabricItemGroup.builder()
                    .icon(() -> new ItemStack(CgsAmmo.GATLING_ROUND))
                    .title(Component.translatable("itemGroup.mod_items"))
                    .displayItems((parameters, output) -> {
                        CgsWeapons.ITEMS.forEach(item -> RegistrationHelper.registerGunOrDefault(output, item));
                        CgsAttachments.ITEMS.forEach(output::accept);
                        CgsAmmo.ITEMS.forEach(output::accept);
                        CgsItems.ITEMS.forEach(output::accept);
                        CgsBlocks.BLOCK_ITEMS.forEach(output::accept);
                    }).build());

    public static void init() {}
}
