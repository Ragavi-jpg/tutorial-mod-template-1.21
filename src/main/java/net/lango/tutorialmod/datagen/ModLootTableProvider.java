package net.lango.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lango.tutorialmod.block.ModBlocks;
import net.lango.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.AMBER_BLOCK);
        addDrop(ModBlocks.AMBER_ORE, oreDrops(ModBlocks.AMBER_ORE, ModItems.AMBER));
        addDrop(ModBlocks.DEEPSLATE_AMBER_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_AMBER_ORE, ModItems.AMBER, 1, 3));

        addDrop(ModBlocks.AMBER_STAIRS);
        addDrop(ModBlocks.AMBER_SLAB, slabDrops(ModBlocks.AMBER_SLAB));
        addDrop(ModBlocks.AMBER_FENCE);
        addDrop(ModBlocks.AMBER_WALL);

        addDrop(ModBlocks.AMBER_FENCE_GATE);
        addDrop(ModBlocks.AMBER_DOOR, doorDrops(ModBlocks.AMBER_DOOR));
        addDrop(ModBlocks.AMBER_TRAPDOOR);

        addDrop(ModBlocks.AMBER_PRESSURE_PLATE);
        addDrop(ModBlocks.AMBER_BUTOON);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
