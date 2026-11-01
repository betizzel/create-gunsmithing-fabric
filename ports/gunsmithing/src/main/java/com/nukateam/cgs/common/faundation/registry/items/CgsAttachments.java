package com.nukateam.cgs.common.faundation.registry.items;

import com.nukateam.cgs.Gunsmithing;
import com.nukateam.cgs.common.datagen.annotations.ItemModelGen;
import com.nukateam.cgs.common.faundation.item.attachments.HammerHeadItem;
import com.nukateam.cgs.common.ntgl.AttachmentMods;
import com.nukateam.cgs.common.ntgl.CgsAttachmentTypes;
import com.nukateam.ntgl.common.data.holders.AttachmentType;
import com.nukateam.ntgl.common.data.attachment.impl.Barrel;
import com.nukateam.ntgl.common.data.attachment.impl.GenericAttachment;
import com.nukateam.ntgl.common.foundation.item.attachment.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;





import static com.nukateam.cgs.common.ntgl.AttachmentMods.*;
import static com.nukateam.cgs.common.ntgl.CgsAttachmentTypes.ENGINE;

public class CgsAttachments {
    public static final java.util.List<Item> ITEMS = new java.util.ArrayList<>();
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().stacksTo(1);

    //GENERIC
    @ItemModelGen(path = "attachments")
    public static final Item SCOPE = register("scope", new ScopeItem(LONG_SCOPE, ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item STOCK = register("stock", new AttachmentItem<>(AttachmentType.STOCK, GenericAttachment.create(AttachmentMods.STOCK), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item BAYONET = register("bayonet", new AttachmentItem<>(AttachmentType.MUZZLE,
            GenericAttachment.create(AttachmentMods.BAYONET_MODIFIERS), ITEM_PROPERTIES));

    //FLINTLOCK
    @ItemModelGen(path = "attachments")
    public static final Item FLINTLOCK_LONG_BARREL = register("flintlock_long_barrel", new BarrelItem(Barrel.create(11f, AttachmentMods.LONG_BARREL), ITEM_PROPERTIES));

//    @ItemModelGen(path = "attachments")
//    public static final RegistryObject<Item> FLINTLOCK_MORTAR_BARREL = ITEMS.register("flintlock_mortar_barrel",
//            () -> new BarrelItem(Barrel.create(5f, AttachmentMods.MORTAR_BARREL), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item BLUNDERBUSS_BARREL = register("blunderbuss_barrel", new BarrelItem(Barrel.create(5f, AttachmentMods.BLUNDERBUSS_BARREL), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item LONG_BLUNDERBUSS_BARREL = register("blunderbuss_barrel_long", new BarrelItem(Barrel.create(10f, AttachmentMods.LONG_BLUNDERBUSS_BARREL), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item REVOLVING_CHAMBERS = register("flintlock_chambers", new AttachmentItem<>(AttachmentType.MAGAZINE, GenericAttachment.create(AttachmentMods.REVOLVING_CHAMBERS), ITEM_PROPERTIES));

    //REVOLVER
    @ItemModelGen(path = "attachments")
    public static final Item REVOLVER_LONG_BARREL = register("long_barrel", new BarrelItem(Barrel.create(11f, AttachmentMods.LONG_BARREL), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item REVOLVER_BELT = register("round_belt", new AttachmentItem<>(CgsAttachmentTypes.CHAMBER,
            GenericAttachment.create(BELT_MODIFIERS), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item REVOLVER_AUTO = register("auto_fire", new AttachmentItem<>(CgsAttachmentTypes.FRAME,
            GenericAttachment.create(AUTO_FIRE), ITEM_PROPERTIES));

    //SHOTGUN
    @ItemModelGen(path = "attachments")
    public static final Item SHOTGUN_DRUM = register("shotgun_drum", new AttachmentItem<>(AttachmentType.MAGAZINE,
            GenericAttachment.create(SHOTGUN_DRUM_MODIFIER, SHOTGUN_MODIFIER), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item SHOTGUN_PUMP = register("shotgun_pump", new AttachmentItem<>(AttachmentType.MAGAZINE,
            GenericAttachment.create(SHOTGUN_PUMP_MODIFIER, SHOTGUN_MODIFIER), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item SHOTGUN_LONG_BARREL = register("shotgun_long_barrel", new BarrelItem(Barrel.create(11f, AttachmentMods.SHOTGUN_LONG_BARREL), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item SHOTGUN_SPREAD_BARREL = register("shotgun_spread_barrel", new BarrelItem(Barrel.create(1f, AttachmentMods.SHOTGUN_SPREAD_BARREL), ITEM_PROPERTIES));

    //GATLING
    @ItemModelGen(path = "attachments")
    public static final Item STEAM_ENGINE = register("steam_engine", new AttachmentItem<>(ENGINE, GenericAttachment.create(STEAM_ENGINE_MODIFIERS), ITEM_PROPERTIES));

//    @ItemModelGen(path = "attachments")
//    public static final RegistryObject<Item> IRON_SIGHT = ITEMS.register("iron_sight",
//            () -> new ScopeItem(SHORT_SCOPE, ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item GATLING_DRUM = register("gatling_drum", new AttachmentItem<>(AttachmentType.MAGAZINE,
            GenericAttachment.create(GATLING_DRUM_MODIFIERS), ITEM_PROPERTIES));

    //NAILGUN
    @ItemModelGen(path = "attachments")
    public static final Item NAILGUN_SPLITTER = register("nailgun_splitter", new BarrelItem(Barrel.create(1f, AttachmentMods.NAILGUN_SPLIT_BARREL), ITEM_PROPERTIES));

//    //BLAZEGUN
//    @ItemModelGen(path = "attachments")
//    public static final RegistryObject<Item> POTION_TANK = ITEMS.register("potion_tank",
//            () -> new AttachmentItem<>(CgsAttachmentTypes.FRAME,
//                    GenericAttachment.create(), ITEM_PROPERTIES));

    //LAUNCHER
//    @ItemModelGen(path = "attachments")
//    public static final RegistryObject<Item> ROCKET_CONTAINER = ITEMS.register("rocket_container",
//            () -> new AttachmentItem<>(AttachmentType.MAGAZINE,
//                    GenericAttachment.create(), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item AUTO_LAUNCHER = register("launcher_auto", new AttachmentItem<>(AttachmentType.MAGAZINE,
            GenericAttachment.create(AttachmentMods.AUTO_LAUNCHER), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item BALLISTAZOOKA = register("ballistazooka", new AttachmentItem<>(AttachmentType.MAGAZINE,
            GenericAttachment.create(AttachmentMods.BALLISTAZOOKA), ITEM_PROPERTIES));

//    @ItemModelGen(path = "attachments")
//    public static final RegistryObject<Item> HOOK_LAUNCHER = ITEMS.register("launcher_hook",
//            () -> new AttachmentItem<>(AttachmentType.MAGAZINE,
//                    GenericAttachment.create(), ITEM_PROPERTIES));

//    @ItemModelGen(path = "attachments")
//    public static final RegistryObject<Item> ITEM_LAUNCHER = ITEMS.register("item_launcher",
//            () -> new AttachmentItem<>(AttachmentType.MAGAZINE,
//                    GenericAttachment.create(), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item LAUNCHER_BAYONET = register("big_bayonet", new AttachmentItem<>(AttachmentType.MUZZLE,
            GenericAttachment.create(AttachmentMods.BIG_BAYONET), ITEM_PROPERTIES));

    //HAMMER
    @ItemModelGen(path = "attachments")
    public static final Item HAMMER_CHAMBER = register("hammer_chamber", new AttachmentItem<>(AttachmentType.MAGAZINE, GenericAttachment.create(RECIEVER), ITEM_PROPERTIES));

    @ItemModelGen(path = "attachments")
    public static final Item HAMMER_STONE = register("hammer_stone", new HammerHeadItem(Tiers.STONE, HammerHeadItem.Type.HAMMER, GenericAttachment.create(HAMMER_HEAD), new Item.Properties()));

    @ItemModelGen(path = "attachments")
    public static final Item HAMMER_IRON = register("hammer_iron", new HammerHeadItem(Tiers.IRON, HammerHeadItem.Type.HAMMER, GenericAttachment.create(HAMMER_HEAD), new Item.Properties()));

    @ItemModelGen(path = "attachments")
    public static final Item HAMMER_DIAMOND = register("hammer_diamond", new HammerHeadItem(Tiers.DIAMOND, HammerHeadItem.Type.HAMMER, GenericAttachment.create(HAMMER_HEAD), new Item.Properties()));

    @ItemModelGen(path = "attachments")
    public static final Item HAMMER_NETHERITE = register("hammer_netherite", new HammerHeadItem(Tiers.NETHERITE, HammerHeadItem.Type.HAMMER, GenericAttachment.create(HAMMER_HEAD), new Item.Properties()));
    //
    @ItemModelGen(path = "attachments")
    public static final Item AXE_STONE = register("axe_stone", new HammerHeadItem(Tiers.STONE, HammerHeadItem.Type.AXE, GenericAttachment.create(AXE_HEAD), new Item.Properties()));

    @ItemModelGen(path = "attachments")
    public static final Item AXE_IRON = register("axe_iron", new HammerHeadItem(Tiers.IRON, HammerHeadItem.Type.AXE, GenericAttachment.create(AXE_HEAD), new Item.Properties()));

    @ItemModelGen(path = "attachments")
    public static final Item AXE_DIAMOND = register("axe_diamond", new HammerHeadItem(Tiers.DIAMOND, HammerHeadItem.Type.AXE, GenericAttachment.create(AXE_HEAD), new Item.Properties()));

    @ItemModelGen(path = "attachments")
    public static final Item AXE_NETHERITE = register("axe_netherite", new HammerHeadItem(Tiers.NETHERITE, HammerHeadItem.Type.AXE, GenericAttachment.create(AXE_HEAD), new Item.Properties()));

    private static <T extends Item> T register(String name, T item) { net.minecraft.core.Registry.register(net.minecraft.core.registries.BuiltInRegistries.ITEM, Gunsmithing.cgsResource(name), item); ITEMS.add(item); return item; } public static void init() {}
}
