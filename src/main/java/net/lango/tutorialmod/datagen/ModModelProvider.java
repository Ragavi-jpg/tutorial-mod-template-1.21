package net.lango.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lango.tutorialmod.block.ModBlocks;
import net.lango.tutorialmod.block.custom.AmberLanternBlock;
import net.lango.tutorialmod.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //=============================AMBER BLOCKS=======================================================
        BlockStateModelGenerator.BlockTexturePool amberPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AMBER_BLOCK);
        amberPool.stairs(ModBlocks.AMBER_STAIRS);
        amberPool.slab(ModBlocks.AMBER_SLAB);
        amberPool.wall(ModBlocks.AMBER_WALL);
        amberPool.fence(ModBlocks.AMBER_FENCE);

        amberPool.button(ModBlocks.AMBER_BUTTON);
        amberPool.pressurePlate(ModBlocks.AMBER_PRESSURE_PLATE);

        amberPool.fenceGate(ModBlocks.AMBER_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.AMBER_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.AMBER_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.AMBER_LANTERN, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.AMBER_LANTERN, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.AMBER_LANTERN)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(AmberLanternBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
        //=================================================================================================

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

        itemModelGenerator.register(ModItems.CHISEL, Models.HANDHELD);

        itemModelGenerator.register(ModItems.AMBER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMBER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMBER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMBER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMBER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMBER_HAMMER, Models.HANDHELD);
    }
}
