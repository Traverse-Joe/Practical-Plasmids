package kiba.plasmids.registry;

import kiba.plasmids.items.ItemCoffee;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeRegistry {
    public static void register(FMLPreInitializationEvent event) {


        //CRAFTING RECIPES

        GameRegistry.addRecipe(new ItemStack(ModItems.itemEveHypo, 4), new Object[]{" X ", "XSX", " X ", 'X', ModItems.itemEveShard, 'S', ModItems.itemSyringe});

        GameRegistry.addRecipe(new ItemStack(ModItems.itemEveReader), new Object[]{"IBI", "XDX", "S S", 'I', Items.IRON_INGOT, 'B', Items.BLAZE_POWDER, 'X', ModItems.itemEveShard, 'D', Items.DIAMOND, 'S', ModItems.itemSyringe});

        GameRegistry.addRecipe(new ItemStack(ModItems.itemSyringe), new Object[]{"GEG", "GBG", "GFG", 'G', Blocks.GLASS, 'E', ModItems.itemEveShard, 'B', Items.BLAZE_ROD, 'F', Items.FLINT});

        GameRegistry.addRecipe(new ItemStack(ModItems.itemPlasmidCore), new Object[]{"DED", "ENE", "DED", 'D', Items.DIAMOND, 'E', ModItems.itemEveShard, 'N', Items.NETHER_STAR});
        GameRegistry.addRecipe(new ItemStack(ModItems.itemEveSolution), new Object[]{" E ", "EBE", " E ", 'E', ModItems.itemEveShard, 'B', Items.POTIONITEM});
        GameRegistry.addRecipe(new ItemStack(ModItems.itemWrench), new Object[]{" B ", " I ", " R ", 'B',Blocks.IRON_BLOCK,'I',Items.IRON_INGOT,'R',Items.REDSTONE});
        GameRegistry.addRecipe(new ItemStack(ModItems.itemMedKit), new Object[]{"III","SGE","III",'I',Items.IRON_INGOT,'S',ModItems.itemSyringe,'G',Items.GOLDEN_APPLE,'E',ModItems.itemEveSolution});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemEveLighter), new Object[]{Items.IRON_INGOT,ModItems.itemEveShard});

        //CONSUMABLES RECIPES

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.foodPepBar,8), new Object[]{Items.SUGAR,Items.PAPER,ModItems.itemEveSolution});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemBeer,2), new Object[]{Items.ROTTEN_FLESH,ModItems.itemEveSolution,Items.WHEAT,});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCoffee), new Object[]{new ItemStack(Items.DYE,0,3),Items.SUGAR,ModItems.itemEveSolution});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCigarette), new Object[]{ModItems.itemEveSolution,Items.PAPER,Items.GUNPOWDER,new ItemStack(ModItems.itemEveLighter,1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemFoodVial,4), new Object[]{ModItems.itemBurntFood,Items.POTIONITEM,Items.SUGAR,ModItems.itemSyringe});



        //PLASMID RECIPES
        GameRegistry.addRecipe(new ItemStack(ModItems.plasmidIncinerate), new Object[]{"FCF", "EPE", "FCF", 'F', new ItemStack(Items.FLINT_AND_STEEL), 'C', Items.FIRE_CHARGE, 'E', ModItems.itemEveShard, 'P', ModItems.itemPlasmidCore.setContainerItem(ModItems.itemPlasmidCore)});
        GameRegistry.addRecipe(new ItemStack(ModItems.plasmidCycloneTrap), new Object[]{"FGF","ECE","FPF", 'F',Items.FEATHER,'G',Items.GHAST_TEAR,'E',ModItems.itemEveShard,'P', Blocks.PISTON,'C',ModItems.itemPlasmidCore.setContainerItem(ModItems.itemPlasmidCore) });
        GameRegistry.addRecipe(new ItemStack(ModItems.plasmidOrionSun),new Object[]{"GTG","TCT","GTG",'G',Blocks.GLOWSTONE,'T',Blocks.TORCH,'C',ModItems.itemPlasmidCore.setContainerItem(ModItems.itemPlasmidCore)});
        GameRegistry.addRecipe(new ItemStack(ModItems.plasmidFreeze), new Object[]{"SPS","BCB","SPS",'S',Blocks.SNOW,'P',Blocks.PACKED_ICE,'B',Items.SNOWBALL,'C',ModItems.itemPlasmidCore.setContainerItem(ModItems.itemPlasmidCore)});
        GameRegistry.addRecipe(new ItemStack(ModItems.plasmidSonicBoom), new Object[]{"EPE","PCP","EPE",'E',ModItems.itemEveShard,'P',Blocks.PISTON,'C',ModItems.itemPlasmidCore.setContainerItem(ModItems.itemPlasmidCore)});

        //MISC UTIL RECIPES
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PACKED_ICE,2),new Object[]{Blocks.SNOW,Blocks.SNOW,ModItems.itemEveSolution});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SNOW),new Object[]{Items.WATER_BUCKET.setContainerItem(Items.BUCKET),ModItems.plasmidFreeze.setContainerItem(ModItems.plasmidFreeze)});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.NETHER_BRICK), new Object[]{Blocks.BRICK_BLOCK,ModItems.plasmidIncinerate.setContainerItem(ModItems.plasmidIncinerate)});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.BRICK_BLOCK), new Object[]{Blocks.NETHER_BRICK,ModItems.plasmidFreeze.setContainerItem(ModItems.plasmidFreeze)});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.CHEST,4),"LLL","L L","LLL",'L',"logWood"));

        //SMELTING RECIPES
        GameRegistry.addSmelting(Items.COOKED_BEEF, new ItemStack(ModItems.itemBurntFood),0.1F);
        GameRegistry.addSmelting(Items.COOKED_CHICKEN, new ItemStack(ModItems.itemBurntFood),0.1F);
        GameRegistry.addSmelting(Items.COOKED_FISH, new ItemStack(ModItems.itemBurntFood),0.1F);
        GameRegistry.addSmelting(Items.COOKED_MUTTON, new ItemStack(ModItems.itemBurntFood),0.1F);
        GameRegistry.addSmelting(Items.COOKED_PORKCHOP, new ItemStack(ModItems.itemBurntFood),0.1F);
        GameRegistry.addSmelting(Items.COOKED_RABBIT, new ItemStack(ModItems.itemBurntFood),0.1F);
        GameRegistry.addSmelting(Items.BAKED_POTATO, new ItemStack(ModItems.itemBurntFood),0.1F);



    }
}
