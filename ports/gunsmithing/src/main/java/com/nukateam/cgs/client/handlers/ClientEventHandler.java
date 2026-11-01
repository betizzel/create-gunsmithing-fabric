package com.nukateam.cgs.client.handlers;

import com.nukateam.cgs.client.renderers.projectile.CgsProjectileRenderer;
import com.nukateam.cgs.client.renderers.projectile.FireballRenderer;
import com.nukateam.cgs.common.faundation.registry.CgsParticles;
import com.nukateam.cgs.common.faundation.registry.CgsProjectiles;
import com.nukateam.ntgl.client.render.renderers.projectiles.ProjectileRenderer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.particle.FlameParticle;

public class ClientEventHandler {
    public static void register() {
        EntityRendererRegistry.register(CgsProjectiles.FIREBALL, FireballRenderer::new);
        EntityRendererRegistry.register(CgsProjectiles.ROCKET, CgsProjectileRenderer::new);
        EntityRendererRegistry.register(CgsProjectiles.SMALL_ROCKET, CgsProjectileRenderer::new);
        EntityRendererRegistry.register(CgsProjectiles.NAIL, CgsProjectileRenderer::new);
        EntityRendererRegistry.register(CgsProjectiles.SPEAR, CgsProjectileRenderer::new);
        EntityRendererRegistry.register(CgsProjectiles.INCENDIARY, ProjectileRenderer::new);
        ParticleFactoryRegistry.getInstance().register(CgsParticles.BLUE_FLAME, FlameParticle.Provider::new);
    }
}
