package kiba.plasmids.proxy;

import kiba.plasmids.registry.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ConfigHandler.init();
		MinecraftForge.EVENT_BUS.register(new MobDrops());
	}

	public void init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent event) {

	}

}
