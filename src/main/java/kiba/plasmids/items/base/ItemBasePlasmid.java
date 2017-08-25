package kiba.plasmids.items.base;

import kiba.plasmids.api.IPlasmid;
import kiba.plasmids.items.base.BaseItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
