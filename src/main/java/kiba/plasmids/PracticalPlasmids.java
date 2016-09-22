package kiba.plasmids;

import kiba.plasmids.energy.IEveConsumer;
import kiba.plasmids.energy.IEveHolder;
import kiba.plasmids.energy.IEveProducer;
import kiba.plasmids.energy.implementation.EveContainer;
import kiba.plasmids.energy.implementation.EveContainerProvider;
import kiba.plasmids.proxy.CommonProxy;
import kiba.plasmids.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

        CapabilityManager.INSTANCE.register(IEveConsumer.class, new PlasmidsCapabilities.CapabilityEveConsumer<>(), EveContainer.class);
        CapabilityManager.INSTANCE.register(IEveProducer.class, new PlasmidsCapabilities.CapabilityEveProducer<>(), EveContainer.class);
        CapabilityManager.INSTANCE.register(IEveHolder.class, new PlasmidsCapabilities.CapabilityEveHolder<>(), EveContainer.class);

        MinecraftForge.EVENT_BUS.register(this);

        ModItems.init();
        proxy.registerRenderers(this);
        proxy.preInit(event);

    }

    @SubscribeEvent
    public void caps(AttachCapabilitiesEvent event) {
        if(event.getObject() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation(MODID,"eve"), new EveContainerProvider(new EveContainer()));
        }
    }


    @SubscribeEvent
    public void clone(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) {
            EntityPlayer dead = event.getOriginal();
            EntityPlayer alive = event.getEntityPlayer();
            if (dead.hasCapability(PlasmidsCapabilities.EVE_HOLDER, null) && alive.hasCapability(PlasmidsCapabilities.EVE_HOLDER, null))
                alive.getCapability(PlasmidsCapabilities.EVE_HOLDER, null).deserializeNBT(dead.getCapability(PlasmidsCapabilities.EVE_HOLDER, null).serializeNBT());
        }
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

}
}
