package kiba.plasmids.items.base;

import kiba.plasmids.Globals;
import kiba.plasmids.PracticalPlasmids;
import net.minecraft.item.Item;

public class BaseItem extends Item {
	public BaseItem(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(Globals.MODID + "." + name);
		this.setCreativeTab(PracticalPlasmids.TAB_PRACTICAL_PLASIMDS);
	}
}
