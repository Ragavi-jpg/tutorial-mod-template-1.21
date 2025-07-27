package net.lango.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lango.tutorialmod.block.ModBlocks;
import net.lango.tutorialmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMBER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMBER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_AMBER_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.AMBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCK_POWDER, Models.GENERATED);

        itemModelGenerator.register(ModItems.WOOD_DUST, Models.GENERATED);

        itemModelGenerator.register(ModItems.GOLDEN_BANANA, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
    }
}
