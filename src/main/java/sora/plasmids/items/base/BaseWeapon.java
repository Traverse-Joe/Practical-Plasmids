package sora.plasmids.items.base;

import sora.plasmids.Globals;
import sora.plasmids.PracticalPlasmids;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaseWeapon extends ItemSword {
	public BaseWeapon(ToolMaterial material, String name) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(Globals.MODID + "." + name);
		this.setCreativeTab(PracticalPlasmids.TAB_PRACTICAL_PLASIMDS);
	}


}
