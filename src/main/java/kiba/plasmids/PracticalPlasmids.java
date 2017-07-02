package kiba.plasmids;

import kiba.plasmids.api.IEveHolder;
import kiba.plasmids.energy.implementation.EveContainer;
import kiba.plasmids.energy.implementation.EveContainerProvider;
import kiba.plasmids.proxy.CommonProxy;
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

@Mod(modid = Globals.MODID, version = Globals.VERSION, name = Globals.MODNAME)
public class PracticalPlasmids {

	@SidedProxy(clientSide = Globals.CLIENTPROXY, serverSide = Globals.COMMONPROXY)
	public static CommonProxy proxy;

	@SuppressWarnings({
			"unchecked", "rawtypes"
	})
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		CapabilityManager.INSTANCE.register(IEveHolder.class, new PlasmidsCapabilities.CapabilityEveHolder(), EveContainer.class);

		MinecraftForge.EVENT_BUS.register(this);

		proxy.preInit(event);

	}

	@SubscribeEvent
	public void caps(AttachCapabilitiesEvent event) {
		if (event.getObject() instanceof EntityPlayer) {
			event.addCapability(new ResourceLocation(Globals.MODID, "eve"), new EveContainerProvider(EveContainer.create(Globals.EVE_MAX_LEVEL, Long.MAX_VALUE, Long.MAX_VALUE)));
		}
	}

	@SubscribeEvent
	public void clone(PlayerEvent.Clone event) {
		if (event.isWasDeath()) {
			EntityPlayer dead = event.getOriginal();
			EntityPlayer alive = event.getEntityPlayer();

			if (dead.hasCapability(PlasmidsCapabilities.EVE_HOLDER, null) && alive.hasCapability(PlasmidsCapabilities.EVE_HOLDER, null)) alive.getCapability(PlasmidsCapabilities.EVE_HOLDER, null).deserializeNBT(dead.getCapability(PlasmidsCapabilities.EVE_HOLDER, null).serializeNBT());
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);

	}
}
