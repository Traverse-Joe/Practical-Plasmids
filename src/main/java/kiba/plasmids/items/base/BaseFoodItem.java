package kiba.plasmids.items.base;

import kiba.plasmids.Globals;
import kiba.plasmids.PracticalPlasmids;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaseFoodItem extends ItemFood {
	public BaseFoodItem(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setRegistryName(name);
		this.setUnlocalizedName(Globals.MODID + "." + name);
		this.setCreativeTab(PracticalPlasmids.TAB_PRACTICAL_PLASIMDS);
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
