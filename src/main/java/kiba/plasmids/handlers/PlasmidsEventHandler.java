package kiba.plasmids.handlers;

import kiba.plasmids.Globals;
import kiba.plasmids.api.IPlasmid;
import kiba.plasmids.client.render.HandRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.*;

public class PlasmidsEventHandler {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onPlasmidEquip(RenderSpecificHandEvent event) {
		if (event.getHand().equals(EnumHand.OFF_HAND) && event.getItemStack() != null && event.getItemStack().getItem() instanceof IPlasmid) {
			event.setCanceled(true);
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onModelBake(ModelBakeEvent event) {
		event.getModelRegistry().putObject(new ModelResourceLocation(new ResourceLocation(Globals.MODID, "DummyModel"), "inventory"), new HandRenderer());
	}
}
