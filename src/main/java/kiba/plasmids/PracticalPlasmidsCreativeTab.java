package kiba.plasmids;

import java.util.List;

import kiba.plasmids.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PracticalPlasmidsCreativeTab extends CreativeTabs {

	public PracticalPlasmidsCreativeTab() {
		super(PracticalPlasmids.MODID);
	}
	
	public void displayAllRelevantItems(List<ItemStack> items) {
		items.add(new ItemStack(ModItems.creativeItemEve));
		items.add(new ItemStack(ModItems.foodPepBar));
		items.add(new ItemStack(ModItems.itemBeer));
		items.add(new ItemStack(ModItems.itemEveHypo));
		items.add(new ItemStack(ModItems.itemEveReader));
		items.add(new ItemStack(ModItems.itemEveShard));
		items.add(new ItemStack(ModItems.itemMedKit));
		items.add(new ItemStack(ModItems.itemSyringe));
		items.add(new ItemStack(ModItems.itemWrench));
		items.add(new ItemStack(ModItems.plasmidCycloneTrap));
		items.add(new ItemStack(ModItems.plasmidIncinerate));
		items.add(new ItemStack(ModItems.plasmidSonicBoom));
		items.add(new ItemStack(ModItems.itemEveTrashCan));
		items.add(new ItemStack(ModItems.itemCoffee));
		items.add(new ItemStack(ModItems.itemCigarette));
		items.add(new ItemStack(ModItems.plasmidOrionSun));
		items.add(new ItemStack(ModItems.plasmidFreeze));
		items.add(new ItemStack(ModItems.itemPlasmidCore));
		items.add(new ItemStack(ModItems.itemEveSolution));
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.itemEveHypo;
	}

}
