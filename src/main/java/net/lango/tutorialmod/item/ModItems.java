package net.lango.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lango.tutorialmod.TutorialMod;
import net.lango.tutorialmod.item.custom.ChiselItem;
import net.lango.tutorialmod.item.custom.HammerItem;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    //items
    public static final Item ROCK = registerItem("rock", new Item(new Item.Settings()));
    public static final Item ROCK_POWDER = registerItem("rock_powder", new Item(new Item.Settings()));
    public static final Item AMBER = registerItem("amber", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(42)));

    public static final Item GOLDEN_BANANA = registerItem("golden_banana", new Item(new Item.Settings().food(ModFoodComponents.GOLDEN_BANANA)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.golden_banana"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item WOOD_DUST = registerItem("wood_dust", new Item(new Item.Settings()));

    public static final Item AMBER_SWORD = registerItem("amber_sword",
            new SwordItem(ModToolMaterials.AMBER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMBER, 3, -2.4f))));

    public static final Item AMBER_PICKAXE = registerItem("amber_pickaxe",
            new PickaxeItem(ModToolMaterials.AMBER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.AMBER, 1, -2.0f))));

    public static final Item AMBER_SHOVEL = registerItem("amber_shovel",
            new ShovelItem(ModToolMaterials.AMBER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.AMBER, 1.5f, -3.0f))));

    public static final Item AMBER_AXE = registerItem("amber_axe",
            new AxeItem(ModToolMaterials.AMBER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.AMBER, 5, -3.2f))));

    public static final Item AMBER_HOE = registerItem("amber_hoe",
            new HoeItem(ModToolMaterials.AMBER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.AMBER, 0, -1))));

    public static final Item AMBER_HAMMER = registerItem("amber_hammer",
            new HammerItem(ModToolMaterials.AMBER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.AMBER, 7, -3.4f))));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        /*ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(ROCK);
            entries.add(ROCK_POWDER);
            entries.add(AMBER);
        } );*/
    }
}
