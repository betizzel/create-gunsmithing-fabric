
package com.nukateam.cgs.common.faundation.registry;

import com.nukateam.cgs.Gunsmithing;
import com.nukateam.cgs.common.datagen.annotations.BlockStateGen;
import com.nukateam.cgs.common.faundation.block.GuanoPileBlock;
import com.nukateam.cgs.common.faundation.registry.items.CgsItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;





import java.util.function.Supplier;

public class CgsBlocks {
    public static final java.util.List<Item> BLOCK_ITEMS = new java.util.ArrayList<>();

    @BlockStateGen
    public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
            () -> new DropExperienceBlock(Block.Properties.of()
                    .sound(SoundType.NETHERRACK)
                    .mapColor(MapColor.NETHER)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(0.4F)));

    @BlockStateGen
    public static final Block LEAD_ORE = registerBlock("lead_ore",
            () -> new DropExperienceBlock(Block.Properties.of()
                    .sound(SoundType.STONE)
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)));

    @BlockStateGen
    public static final Block DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            () -> new DropExperienceBlock(Block.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)));

    @BlockStateGen
    public static final Block RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
            () -> new Block(Block.Properties.of()
                    .mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)));

    @BlockStateGen
    public static final Block LEAD_BLOCK = registerBlock("lead_block",
            () -> new Block(Block.Properties.of()
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 6.0F)
                    .sound(SoundType.METAL)));


    @BlockStateGen
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(Block.Properties.of()
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 6.0F)
                    .sound(SoundType.METAL)));

//    @BlockStateGen
    public static final Block GUANO_BLOCK = registerBlockWithoutItem("guano_block",
            () -> new GuanoPileBlock(BlockBehaviour.Properties.copy(Blocks.SNOW)
                    .strength(0.5f)
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .randomTicks()
                    .noOcclusion()));

    private static <T extends Block> T registerBlock(String name, Supplier<T> factory) {
        T block = registerBlockWithoutItem(name, factory);
        Item item = net.minecraft.core.Registry.register(net.minecraft.core.registries.BuiltInRegistries.ITEM,
                Gunsmithing.cgsResource(name), new BlockItem(block, new Item.Properties()));
        BLOCK_ITEMS.add(item);
        return block;
    }

    private static <T extends Block> T registerBlockWithoutItem(String name, Supplier<T> factory) {
        return net.minecraft.core.Registry.register(net.minecraft.core.registries.BuiltInRegistries.BLOCK,
                Gunsmithing.cgsResource(name), factory.get());
    }

    public static void init() {}
}
