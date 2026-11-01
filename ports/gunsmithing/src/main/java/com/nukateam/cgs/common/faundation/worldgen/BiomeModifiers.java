package com.nukateam.cgs.common.faundation.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;

public final class BiomeModifiers {
    private BiomeModifiers() {}

    public static void register() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Decoration.UNDERGROUND_ORES, PlacedFeatures.LEAD_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_NETHER),
                GenerationStep.Decoration.UNDERGROUND_ORES, PlacedFeatures.ORE_SULFUR_NETHER_PLACED);
    }
}
