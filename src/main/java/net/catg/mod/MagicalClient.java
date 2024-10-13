package net.catg.mod;

import net.catg.mod.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;


public class MagicalClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.BOMB_PROJECTILE, (context) ->
                new FlyingItemEntityRenderer(context));
    }
}
