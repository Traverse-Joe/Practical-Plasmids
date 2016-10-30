package kiba.plasmids.proxy;

import kiba.plasmids.PracticalPlasmids;
import kiba.plasmids.registry.ConfigHandler;
import kiba.plasmids.registry.RecipeRegistry;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
    public void preInit(FMLPreInitializationEvent event){
        RecipeRegistry.register(event);
        ConfigHandler.init();

    }
    public void init(FMLPostInitializationEvent event){


    }
    public void postInit(FMLPostInitializationEvent event){

    }
    public void registerRenderers(PracticalPlasmids plasmids){

    }

}
