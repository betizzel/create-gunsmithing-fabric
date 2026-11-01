
package com.nukateam.cgs.common.faundation.registry.items;

import com.nukateam.cgs.Gunsmithing;
import com.nukateam.cgs.common.faundation.item.guns.*;
import com.nukateam.cgs.common.ntgl.modifiers.HammerModifier;
import com.nukateam.ntgl.common.foundation.item.WeaponItem;
import net.minecraft.world.item.Item;


import java.util.function.Function;

public class CgsWeapons {
    public static final java.util.List<Item> ITEMS = new java.util.ArrayList<>();
    //GUNS
    public static final WeaponItem FLINTLOCK = registerGun("flintlock", FlintlockItem::new);
    public static final WeaponItem REVOLVER = registerGun("revolver", RevolverItem::new);
    public static final WeaponItem SHOTGUN = registerGun("shotgun", ShotgunItem::new);
    public static final WeaponItem NAILGUN = registerGun("nailgun", WeaponItem::new);
    public static final WeaponItem GATLING = registerGun("gatling", GatlingItem::new);
    public static final WeaponItem BLAZEGUN = registerGun("blazegun", BlazegunItem::new);
    public static final WeaponItem LAUNCHER = registerGun("launcher", LauncherItem::new);
    public static final WeaponItem HAMMER = registerGun("hammer", properties ->
            new HammerItem(properties,  new HammerModifier()));

    //GRENADES
    public static final WeaponItem GRENADE = registerGrenade("frag_grenade", WeaponItem::new);

    private static WeaponItem registerGun(String name, Function<Item.Properties, WeaponItem> item) {
        return register(name, item.apply(new Item.Properties().stacksTo(1)));
    }

    private static WeaponItem registerGrenade(String name, Function<Item.Properties, WeaponItem> item) {
        return register(name, item.apply(new Item.Properties().stacksTo(16)));
    }

    public static WeaponItem registerGun(String name) {
        return register(name, new CgsGunItem(new Item.Properties().stacksTo(1)));
    }

    public static WeaponItem registerGun(String name, int durability) {
        return register(name, new CgsGunItem(new Item.Properties().durability(durability)));
    }

    private static <T extends Item> T register(String name, T item) { net.minecraft.core.Registry.register(net.minecraft.core.registries.BuiltInRegistries.ITEM, Gunsmithing.cgsResource(name), item); ITEMS.add(item); return item; } public static void init() {}
}