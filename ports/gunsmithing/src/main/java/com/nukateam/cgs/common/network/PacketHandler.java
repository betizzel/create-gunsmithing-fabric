package com.nukateam.cgs.common.network;

import com.nukateam.cgs.Gunsmithing;
import com.nukateam.cgs.common.network.packets.C2SMessageFuel;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.resources.ResourceLocation;

public final class PacketHandler {
    public static final ResourceLocation FUEL_REQUEST = new ResourceLocation(Gunsmithing.MOD_ID, "fuel_request");

    private PacketHandler() {}

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(FUEL_REQUEST, (server, player, handler, buf, responseSender) ->
                server.execute(() -> C2SMessageFuel.handle(player)));
    }
}
