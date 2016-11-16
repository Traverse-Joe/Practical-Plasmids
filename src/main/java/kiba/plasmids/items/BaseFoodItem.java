package kiba.plasmids.items;

import kiba.plasmids.Globals;
import kiba.plasmids.PracticalPlasmids;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaseFoodItem extends ItemFood {
	public BaseFoodItem(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setRegistryName(name);
		this.setUnlocalizedName(Globals.MODID + "." + name);
		GameRegistry.register(this);
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
