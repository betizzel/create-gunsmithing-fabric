package com.nukateam.cgs.client;

import com.nukateam.cgs.client.handlers.ClientEventHandler;
import net.fabricmc.api.ClientModInitializer;

public class GunsmithingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientEventHandler.register();
    }
}
