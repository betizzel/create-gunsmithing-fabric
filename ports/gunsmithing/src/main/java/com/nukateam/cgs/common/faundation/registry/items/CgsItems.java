
package com.nukateam.cgs.common.faundation.registry.items;

import com.nukateam.cgs.Gunsmithing;
import com.nukateam.cgs.common.datagen.annotations.ItemModelGen;
import com.nukateam.cgs.common.faundation.item.FluidContainerItem;
import com.nukateam.cgs.common.faundation.registry.CgsBlocks;
import com.nukateam.ntgl.common.foundation.item.AmmoItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;





import java.util.Map;
import java.util.function.Function;

public class CgsItems {
    public static final java.util.List<Item> ITEMS = new java.util.ArrayList<>();

    @ItemModelGen
    public static final Item EMPTY_CONTAINER = register("tank_empty", new FluidContainerItem(() -> Fluids.EMPTY,
            new Item.Properties().stacksTo(16)));

    @ItemModelGen
    public static final Item WATER_CONTAINER = register("tank_water", new FluidContainerItem(() -> Fluids.WATER,
            new Item.Properties().stacksTo(16).craftRemainder(EMPTY_CONTAINER)));

    @ItemModelGen
    public static final Item LAVA_CONTAINER = register("tank_lava", new FluidContainerItem(() -> Fluids.LAVA,
            new Item.Properties().stacksTo(16).craftRemainder(EMPTY_CONTAINER)));

    public static Map<Fluid, Item> CONTAINERS = Map.of(
            Fluids.WATER, WATER_CONTAINER,
            Fluids.LAVA, LAVA_CONTAINER
    );

    @ItemModelGen
    public static final Item PRESS_FORM_GATLING = registerItem("press_form_gatling");

    @ItemModelGen
    public static final Item PRESS_FORM_REVOLVER = registerItem("press_form_revolver");

    @ItemModelGen
    public static final Item PRESS_FORM_SHOTGUN = registerItem("press_form_shotgun");

    @ItemModelGen
    public static final Item LEAD_INGOT = registerItem ("lead_ingot");

    @ItemModelGen
    public static final Item STEEL_INGOT = registerItem ("steel_ingot");

    @ItemModelGen
    public static final Item LEAD_NUGGET = registerItem("lead_nugget");

    @ItemModelGen
    public static final Item STEEL_NUGGET = registerItem ("steel_nugget");

    @ItemModelGen
    public static final Item STEEL_SHEET = registerItem ("steel_sheet");

    @ItemModelGen
    public static final Item RAW_LEAD = registerItem("raw_lead");

    @ItemModelGen
    public static final Item NITER = registerItem ("niter");

    @ItemModelGen
    public static final Item SULFUR = registerItem ("sulfur");

    @ItemModelGen
    public static final Item CHARCOAL_DUST = registerItem ("charcoal_dust");

    @ItemModelGen
    public static final Item GUANO = register("guano", new ItemNameBlockItem(CgsBlocks.GUANO_BLOCK, new Item.Properties()));


    public static Item registerItem(String name, Item.Properties properties) {
        return register(name, new Item(properties));
    }

    public static Item registerItem(String name) {
        return registerItem(name, new Item.Properties());
    }

    private static <T extends Item> T register(String name, T item) { net.minecraft.core.Registry.register(net.minecraft.core.registries.BuiltInRegistries.ITEM, Gunsmithing.cgsResource(name), item); ITEMS.add(item); return item; } public static void init() {}
}
