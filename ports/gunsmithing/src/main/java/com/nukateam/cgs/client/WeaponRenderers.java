package com.nukateam.cgs.client;

import com.google.common.base.Suppliers;
import com.nukateam.cgs.client.renderers.weapon.GatlingRenderer;
import com.nukateam.cgs.client.renderers.weapon.HammerRenderer;
import java.util.function.Supplier;

public class WeaponRenderers {
    public static final Supplier<HammerRenderer> HAMMER_RENDERER = Suppliers.memoize(HammerRenderer::new);
    public static final Supplier<GatlingRenderer> GATLING_RENDERER = Suppliers.memoize(GatlingRenderer::new);
}
