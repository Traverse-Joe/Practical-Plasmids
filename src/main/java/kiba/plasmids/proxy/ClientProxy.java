package kiba.plasmids.proxy;

import kiba.plasmids.PracticalPlasmids;
import kiba.plasmids.registry.ModItems;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy{
    @Override
    public void init(FMLPostInitializationEvent event){
        super.init(event);
    }
    @Override
    public void registerRenderers(PracticalPlasmids plasmids){
        ModItems.initModels();
    }

}


