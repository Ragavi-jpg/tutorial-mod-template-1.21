package net.lango.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lango.tutorialmod.TutorialMod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //blocks
    public static final Block AMBER_BLOCK = registerBlock("amber_block",
            new IceBlock(AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.CANDLE)
                    .nonOpaque()
                    .solidBlock(Blocks::never)
                    .mapColor(MapColor.GOLD)
            ));

    public static final Block AMBER_ORE = registerBlock("amber_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ));

    //============================================================================
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
           entries.add(ModBlocks.AMBER_BLOCK);
           entries.add(ModBlocks.AMBER_ORE);
        });
    }
}
