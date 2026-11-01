package com.nukateam.cgs.common.network.packets;

import com.nukateam.ntgl.common.util.util.WeaponModifierHelper;
import net.minecraft.server.level.ServerPlayer;

import static com.nukateam.cgs.common.utils.GunUtils.fillFuel;

public final class C2SMessageFuel {
    private C2SMessageFuel() {}

    public static void handle(ServerPlayer player) {
        if (player.isSpectator()) return;
        var mainHandItem = player.getMainHandItem();
        var offhandItem = player.getOffhandItem();
        if (WeaponModifierHelper.isGun(mainHandItem)) {
            fillFuel(mainHandItem, player, offhandItem);
        } else if (WeaponModifierHelper.isGun(offhandItem)) {
            fillFuel(offhandItem, player, mainHandItem);
        }
    }
}
