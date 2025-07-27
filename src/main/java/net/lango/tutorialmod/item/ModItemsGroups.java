package net.lango.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lango.tutorialmod.TutorialMod;
import net.lango.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {
    public static final ItemGroup IDK_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "idk_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.AMBER))
                    .displayName(Text.translatable("itemgroup.tutorialmod.idk_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.AMBER);
                        entries.add(ModItems.ROCK);
                        entries.add(ModItems.ROCK_POWDER);

                        entries.add(ModItems.CHISEL);

                        entries.add(ModItems.GOLDEN_BANANA);

                        entries.add(ModItems.WOOD_DUST);
                    }).build());

    public static final ItemGroup IDK_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "idk_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.AMBER_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.idk_blocks"))
                    .entries((displayContext, entries) -> {
                        //=====AMBER VARIATIONS======================
                        entries.add(ModBlocks.AMBER_BLOCK);

                        entries.add(ModBlocks.AMBER_SLAB);
                        entries.add(ModBlocks.AMBER_STAIRS);
                        entries.add(ModBlocks.AMBER_WALL);
                        entries.add(ModBlocks.AMBER_FENCE);

                        entries.add(ModBlocks.AMBER_TRAPDOOR);
                        entries.add(ModBlocks.AMBER_DOOR);
                        entries.add(ModBlocks.AMBER_FENCE_GATE);

                        entries.add(ModBlocks.AMBER_PRESSURE_PLATE);
                        entries.add(ModBlocks.AMBER_BUTOON);
                        //============================================

                        entries.add(ModBlocks.AMBER_ORE);
                        entries.add(ModBlocks.DEEPSLATE_AMBER_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).build());


    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item GRoups for " + TutorialMod.MOD_ID);
    }
}
