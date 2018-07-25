package sora.plasmids.items.base;

import sora.plasmids.Globals;
import sora.plasmids.PracticalPlasmids;
import net.minecraft.item.Item;

public class BaseItem extends Item {
	public BaseItem(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(Globals.MODID + "." + name);
		this.setCreativeTab(PracticalPlasmids.TAB_PRACTICAL_PLASIMDS);
	}
}
