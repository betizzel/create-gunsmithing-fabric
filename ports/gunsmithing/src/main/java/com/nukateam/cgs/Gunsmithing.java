package com.nukateam.cgs;

import com.mojang.logging.LogUtils;
import com.nukateam.cgs.common.faundation.registry.*;
import com.nukateam.cgs.common.faundation.registry.items.*;
import com.nukateam.cgs.common.handlers.CommonHandler;
import com.nukateam.cgs.common.network.PacketHandler;
import com.nukateam.cgs.common.faundation.worldgen.BiomeModifiers;
import com.nukateam.cgs.common.ntgl.CgsAmmoHolders;
import com.nukateam.cgs.common.ntgl.CgsAmmoType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public class Gunsmithing implements ModInitializer {
    public static final String MOD_ID = "cgs";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        CgsWeapons.init();
        CgsBlocks.init();
        CgsItems.init();
        CgsAmmo.init();
        CgsAttachments.init();
        CgsItemTabs.init();
        CgsSounds.init();
        CgsProjectiles.init();
        BiomeModifiers.register();
        CgsParticles.init();
        CgsAmmoType.register();
        CgsAmmoHolders.register();
        PacketHandler.init();
        CommonHandler.init();
    }

    public static @NotNull ResourceLocation cgsResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static boolean isDebugging() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
