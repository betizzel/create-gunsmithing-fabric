package com.nukateam.cgs.common.faundation.registry;

import com.nukateam.cgs.Gunsmithing;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

public class CgsParticles {
    public static final SimpleParticleType BLUE_FLAME = Registry.register(
            BuiltInRegistries.PARTICLE_TYPE, Gunsmithing.cgsResource("blue_flame"), FabricParticleTypes.simple(false));

    public static void init() {}
}
