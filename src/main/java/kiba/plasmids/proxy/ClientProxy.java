package kiba.plasmids.proxy;

import kiba.plasmids.PracticalPlasmidsCreativeTab;
import kiba.plasmids.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.*;

public class ClientProxy extends CommonProxy {

	public static CreativeTabs CREATIVE_TAB;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		CREATIVE_TAB = new PracticalPlasmidsCreativeTab();
		ModItems.initModels();

	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

}
