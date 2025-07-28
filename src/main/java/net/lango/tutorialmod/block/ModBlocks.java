package net.lango.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lango.tutorialmod.TutorialMod;
import net.lango.tutorialmod.block.custom.MagicBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    //================AMBER BLOCKS===============================================================================
    public static final Block AMBER_BLOCK = registerBlock("amber_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.CANDLE)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
            ));

    //amber Building Blocks variations
    public static final Block AMBER_STAIRS = registerBlock("amber_stairs",
            new StairsBlock(ModBlocks.AMBER_BLOCK.getDefaultState(), AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.CANDLE)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
            ));

    public static final Block AMBER_SLAB = registerBlock("amber_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.CANDLE)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
            ));

    public static final Block AMBER_BUTOON = registerBlock("amber_button",
            new ButtonBlock(BlockSetType.IRON, 7, AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.CANDLE)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
            ));

    public static final Block AMBER_PRESSURE_PLATE = registerBlock("amber_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.CANDLE)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
            ));

    public static final Block AMBER_FENCE = registerBlock("amber_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.CANDLE)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
            ));

    public static final Block AMBER_FENCE_GATE = registerBlock("amber_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.CANDLE)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
            ));

    public static final Block AMBER_WALL = registerBlock("amber_wall",
            new WallBlock(AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.CANDLE)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
            ));

    public static final Block AMBER_DOOR = registerBlock("amber_door",
            new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.CANDLE)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
            ));

    public static final Block AMBER_TRAPDOOR = registerBlock("amber_trapdoor",
            new TrapdoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.CANDLE)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
            ));

    //==================================================================================================

    public static final Block AMBER_ORE = registerBlock("amber_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
                    .mapColor(MapColor.ORANGE)
            ));

    public static final Block DEEPSLATE_AMBER_ORE = registerBlock("deepslate_amber_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .mapColor(MapColor.ORANGE)
            ));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.HEAVY_CORE)
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
        /*ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
           entries.add(ModBlocks.AMBER_BLOCK);
           entries.add(ModBlocks.AMBER_ORE);
        }); */
    }
}
