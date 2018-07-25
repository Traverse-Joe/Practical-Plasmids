package sora.plasmids;

import sora.plasmids.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class PracticalPlasmidsCreativeTab extends CreativeTabs {

	public PracticalPlasmidsCreativeTab() {
		super(Globals.MODID + ".name");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.EVE_HYPO);
	}
}
