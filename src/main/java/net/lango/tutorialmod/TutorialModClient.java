package net.lango.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.lango.tutorialmod.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //traslucent amber block
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMBER_BLOCK, RenderLayer.getTranslucent());
    }
}
