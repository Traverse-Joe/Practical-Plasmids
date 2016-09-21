package kiba.plasmids;

import kiba.plasmids.proxy.CommonProxy;
import kiba.plasmids.registry.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PracticalPlasmids.MODID, version = PracticalPlasmids.VERSION, name = PracticalPlasmids.MODNAME)
public class PracticalPlasmids
{
    public static final String MODID = "plasmids";
    public static final String VERSION = "0.0.1";
    public static final String MODNAME = "Practical Plasmids";
    public static final String CLIENTPROXY = "kiba.plasmids.proxy.ClientProxy";
    public static final String COMMONPROXY = "kiba.plasmids.proxy.CommonProxy";

    @SidedProxy(clientSide = PracticalPlasmids.CLIENTPROXY, serverSide = PracticalPlasmids.COMMONPROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ModItems.init();
        proxy.registerRenderers(this);
        proxy.preInit(event);

    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

}
}
