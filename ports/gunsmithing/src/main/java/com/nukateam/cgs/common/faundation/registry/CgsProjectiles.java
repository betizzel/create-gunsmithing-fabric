package com.nukateam.cgs.common.faundation.registry;

import com.nukateam.cgs.Gunsmithing;
import com.nukateam.cgs.common.faundation.entity.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;





import java.util.function.BiFunction;

public class CgsProjectiles {

    public static final EntityType<BlazeProjectile> FIREBALL =
            registerProjectile("fireball", BlazeProjectile::new);

    public static final EntityType<RocketProjectile> ROCKET =
            registerProjectile("rocket", RocketProjectile::new);

    public static final EntityType<RocketProjectile> SMALL_ROCKET =
            registerProjectile("small_rocket", RocketProjectile::new);

    public static final EntityType<NailProjectile> NAIL =
            registerProjectile("nail", NailProjectile::new);

    public static final EntityType<SpearProjectile> SPEAR =
            registerProjectile("spear", SpearProjectile::new);

    public static final EntityType<IncendiaryProjectile> INCENDIARY =
            registerProjectile("incendiary", IncendiaryProjectile::new);

    private static <T extends Entity> EntityType<T> registerProjectile(
            String id, BiFunction<EntityType<T>, Level, T> function) {
        return net.minecraft.core.Registry.register(net.minecraft.core.registries.BuiltInRegistries.ENTITY_TYPE,
                Gunsmithing.cgsResource(id),
                net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder
                        .<T>create(MobCategory.MISC, function::apply)
                        .dimensions(net.minecraft.world.entity.EntityDimensions.fixed(0.25F, 0.25F))
                        .trackRangeChunks(100)
                        .trackedUpdateRate(1)
                        .disableSummon()
                        .fireImmune()
                        .forceTrackedVelocityUpdates(true)
                        .build());
    }

    public static void init() {}
}
