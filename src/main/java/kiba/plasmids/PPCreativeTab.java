package kiba.plasmids;

import java.util.List;

import kiba.plasmids.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PPCreativeTab extends CreativeTabs {

	public PPCreativeTab() {
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
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.plasmidSonicBoom;
	}

}
