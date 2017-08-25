package kiba.plasmids.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static kiba.plasmids.registry.ConfigHandler.quantityCount;

public class RecipeRegistry {

    public static void init() {

        //TODO UpcraftLP: ore dictionary recipes

        //CRAFTING RECIPES
        GameRegistry.addRecipe(new ItemStack(ModItems.EVE_HYPO, quantityCount), " X ", "XSX", " X ", 'X', ModItems.EVE_SHARD, 'S', ModItems.SYRINGE);
        GameRegistry.addRecipe(new ItemStack(ModItems.EVE_READER), "IBI", "XDX", "S S", 'I', Items.IRON_INGOT, 'B', Items.BLAZE_POWDER, 'X', ModItems.EVE_SHARD, 'D', Items.DIAMOND, 'S', ModItems.SYRINGE);
        GameRegistry.addRecipe(new ItemStack(ModItems.SYRINGE), "GEG", "GBG", "GFG", 'G', Blocks.GLASS, 'E', ModItems.EVE_SHARD, 'B', Items.BLAZE_ROD, 'F', Items.FLINT);
        GameRegistry.addRecipe(new ItemStack(ModItems.PLASMID_CORE), "DED", "ENE", "DED", 'D', Items.DIAMOND, 'E', ModItems.EVE_SHARD, 'N', Items.NETHER_STAR);
        GameRegistry.addRecipe(new ItemStack(ModItems.EVE_SOLUTION, quantityCount), " E ", "EBE", " E ", 'E', ModItems.EVE_SHARD, 'B', Items.POTIONITEM);
        GameRegistry.addRecipe(new ItemStack(ModItems.WRENCH), " B ", " I ", " R ", 'B', Blocks.IRON_BLOCK, 'I', Items.IRON_INGOT, 'R', Items.REDSTONE);

        //SHAPELESS
        GameRegistry.addRecipe(new ItemStack(ModItems.MED_KIT), "III", "SGE", "III", 'I', Items.IRON_INGOT, 'S', ModItems.SYRINGE, 'G', Items.GOLDEN_APPLE, 'E', ModItems.EVE_SOLUTION);

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.EVE_LIGHTER), Items.IRON_INGOT, ModItems.EVE_SHARD);

        //CONSUMABLES RECIPES
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PEP_BAR, quantityCount), Items.SUGAR, Items.PAPER, ModItems.EVE_SOLUTION);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.BEER, quantityCount), Items.ROTTEN_FLESH, ModItems.EVE_SOLUTION, Items.WHEAT);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ITEM_COFFEE), new ItemStack(Items.DYE, 0, EnumDyeColor.BROWN.getDyeDamage()), Items.SUGAR, ModItems.EVE_SOLUTION);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ITEM_CIGARETTE), ModItems.EVE_SOLUTION, Items.PAPER, Items.GUNPOWDER, new ItemStack(ModItems.EVE_LIGHTER, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FOOD_VIAL, quantityCount), ModItems.BURNT_FOOD, Items.POTIONITEM, Items.SUGAR, ModItems.SYRINGE);
        GameRegistry.addRecipe(new ItemStack(ModItems.TEST_NEEDLE, quantityCount), "S", "G", "F", 'S', ModItems.EVE_SHARD, 'G', Blocks.GLASS, 'F', Items.FLINT);

        //PLASMID RECIPES
        GameRegistry.addRecipe(new ItemStack(ModItems.PLASMID_INCINERATE), "FCF", "EPE", "FCF", 'F', new ItemStack(Items.FLINT_AND_STEEL), 'C', Items.FIRE_CHARGE, 'E', ModItems.EVE_SHARD, 'P', ModItems.PLASMID_CORE);
        GameRegistry.addRecipe(new ItemStack(ModItems.PLASMID_CYCLONE_TRAP), "FGF", "ECE", "FPF", 'F', Items.FEATHER, 'G', Items.GHAST_TEAR, 'E', ModItems.EVE_SHARD, 'P', Blocks.PISTON, 'C', ModItems.PLASMID_CORE);
        GameRegistry.addRecipe(new ItemStack(ModItems.PLASMID_ORION_SUN), "GTG", "TCT", "GTG", 'G', Blocks.GLOWSTONE, 'T', Blocks.TORCH, 'C', ModItems.PLASMID_CORE);
        GameRegistry.addRecipe(new ItemStack(ModItems.PLASMID_FREEZE), "SPS", "BCB", "SPS", 'S', Blocks.SNOW, 'P', Blocks.PACKED_ICE, 'B', Items.SNOWBALL, 'C', ModItems.PLASMID_CORE);
        GameRegistry.addRecipe(new ItemStack(ModItems.PLASMID_SONIC_BOOM), "EPE", "PCP", "EPE", 'E', ModItems.EVE_SHARD, 'P', Blocks.PISTON, 'C', ModItems.PLASMID_CORE);

        //MISC UTIL RECIPES
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PACKED_ICE, 2), Blocks.SNOW, Blocks.SNOW, ModItems.EVE_SOLUTION);
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SNOW), Items.WATER_BUCKET.setContainerItem(Items.BUCKET), ModItems.PLASMID_FREEZE);
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.NETHER_BRICK), Blocks.BRICK_BLOCK, ModItems.PLASMID_INCINERATE.setContainerItem(ModItems.PLASMID_INCINERATE));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.BRICK_BLOCK), Blocks.NETHER_BRICK, ModItems.PLASMID_FREEZE.setContainerItem(ModItems.PLASMID_FREEZE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.CHEST, 4), "LLL", "L L", "LLL", 'L', "logWood"));

        //SMELTING RECIPES
        GameRegistry.addSmelting(Items.COOKED_BEEF, new ItemStack(ModItems.BURNT_FOOD), 0.1F);
        GameRegistry.addSmelting(Items.COOKED_CHICKEN, new ItemStack(ModItems.BURNT_FOOD), 0.1F);
        GameRegistry.addSmelting(Items.COOKED_FISH, new ItemStack(ModItems.BURNT_FOOD), 0.1F);
        GameRegistry.addSmelting(Items.COOKED_MUTTON, new ItemStack(ModItems.BURNT_FOOD), 0.1F);
        GameRegistry.addSmelting(Items.COOKED_PORKCHOP, new ItemStack(ModItems.BURNT_FOOD), 0.1F);
        GameRegistry.addSmelting(Items.COOKED_RABBIT, new ItemStack(ModItems.BURNT_FOOD), 0.1F);
        GameRegistry.addSmelting(Items.BAKED_POTATO, new ItemStack(ModItems.BURNT_FOOD), 0.1F);

        //FUEL HANDLERS
        GameRegistry.registerFuelHandler(ModFuelHandler.INSTANCE);
    }

}
