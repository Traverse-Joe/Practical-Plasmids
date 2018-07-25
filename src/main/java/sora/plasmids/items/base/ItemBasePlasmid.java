package sora.plasmids.items.base;

import sora.plasmids.api.IPlasmid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBasePlasmid extends BaseItem implements IPlasmid<Item> {
	public ItemBasePlasmid(String name) {
		super(name);
		this.setMaxStackSize(1);
		this.setContainerItem(this);
		this.setHasSubtypes(true);
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) { //TODO check this
		ItemStack ret = itemStack.copy();
		ret.setCount(1);
		return ret;
	}
}
