package net.lango.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lango.tutorialmod.block.ModBlocks;
import net.lango.tutorialmod.item.ModItems;
import net.lango.tutorialmod.item.ModItemsGroups;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		//traslucent amber block
		List<Block> amberBlocks = List.of(ModBlocks.AMBER_BLOCK, ModBlocks.AMBER_STAIRS, ModBlocks.AMBER_SLAB, ModBlocks.AMBER_FENCE, ModBlocks.AMBER_WALL,
				ModBlocks.AMBER_DOOR, ModBlocks.AMBER_TRAPDOOR, ModBlocks.AMBER_FENCE_GATE, ModBlocks.AMBER_BUTOON, ModBlocks.AMBER_PRESSURE_PLATE);
		for(Block block :amberBlocks) {
			BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
		}

		ModItemsGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.WOOD_DUST, 50);
	}
}