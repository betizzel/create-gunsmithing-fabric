
package com.nukateam.cgs.client.handlers;

import com.nukateam.cgs.common.network.PacketHandler;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import com.nukateam.ntgl.common.util.util.FuelUtils;
import com.nukateam.ntgl.common.data.WeaponData;
import com.nukateam.ntgl.common.util.util.WeaponModifierHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.glfw.GLFW;

public class InputEventHandler {
    public static void onMouseInput(int button, int action) {
        if(isInGame() && Minecraft.getInstance().player != null) {
            var mc = Minecraft.getInstance();
            var player = mc.player;
            var mainHandItem = player.getMainHandItem();
            var offhandItem = player.getOffhandItem();

            if (action == GLFW.GLFW_RELEASE && mc.options.keyUse.matchesMouse(button)) {
                if (WeaponModifierHelper.isGun(mainHandItem)) {
                    fillEngine(mainHandItem, offhandItem);
                } else if (WeaponModifierHelper.isGun(offhandItem)) {
                    fillEngine(offhandItem, mainHandItem);
                }
            }
        }
    }

    private static void fillEngine(ItemStack gun, ItemStack fuelStack) {
        var mc = Minecraft.getInstance();
        if(canAcceptFuel(gun, fuelStack)){
            ClientPlayNetworking.send(PacketHandler.FUEL_REQUEST, PacketByteBufs.create());
            mc.options.keyUse.setDown(false);
        }
    }

    private static boolean canAcceptFuel(ItemStack gun, ItemStack fuelStack) {
        var mc = Minecraft.getInstance();
        var gunData = new WeaponData(gun, mc.player);
        var allFuel = WeaponModifierHelper.getAllFuel(gunData);
        for (var fuelType: allFuel){
            if (fuelType.isAcceptable(fuelStack) && !FuelUtils.isFull(gunData, fuelType))
                return true;
        }
        return false;
    }

    public static boolean isInGame() {
        var mc = Minecraft.getInstance();
        if (mc.getOverlay() != null)
            return false;
        if (mc.screen != null)
            return false;
        if (!mc.mouseHandler.isMouseGrabbed())
            return false;
        return mc.isWindowActive();
    }
}
