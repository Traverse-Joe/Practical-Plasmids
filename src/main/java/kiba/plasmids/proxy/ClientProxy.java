package kiba.plasmids.proxy;

import kiba.plasmids.registry.ModItems;
import net.minecraftforge.fml.common.event.*;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		ModItems.initModels();

	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

}
