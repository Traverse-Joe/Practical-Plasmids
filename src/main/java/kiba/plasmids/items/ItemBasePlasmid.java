package kiba.plasmids.items;

import kiba.plasmids.api.IPlasmid;
import kiba.plasmids.client.render.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.*;

public class ItemBasePlasmid extends BaseItem implements IPlasmid<Item> {
	public ItemBasePlasmid(String name) {
		super(name);
		hasSubtypes = true;
		maxStackSize = 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 1, new ModelResourceLocation(getRegistryName(), "inventory"));
		PModelRegistryHelper.registerMetaRenderer(this, new HandRenderer(), 0);
	}

}
