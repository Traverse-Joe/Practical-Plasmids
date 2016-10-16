package kiba.plasmids.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeRegistry {
    public static void register(FMLPreInitializationEvent event) {
        //CRAFTING RECIPES
        //Recipe - Eve Hypo
GameRegistry.addRecipe(new ItemStack(ModItems.itemEveHypo,4), new Object[] {" X ", "XSX"," X ", 'X', ModItems.itemEveShard, 'S', ModItems.itemSyringe});
        //Recipe - Eve Reader
 GameRegistry.addRecipe(new ItemStack(ModItems.itemEveReader), new Object[]{"IBI","XDX","S S", 'I', Items.IRON_INGOT, 'B',Items.BLAZE_POWDER,'X',ModItems.itemEveShard,'D',Items.DIAMOND, 'S',ModItems.itemSyringe});
}
}
