package com.nukateam.cgs.mixin;

import com.nukateam.cgs.common.handlers.GuanoAccumulationHandler;
import net.minecraft.world.entity.ambient.Bat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bat.class)
abstract class BatMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void cgs$accumulateGuano(CallbackInfo ci) {
        GuanoAccumulationHandler.onBatUpdate((Bat) (Object) this);
    }
}
