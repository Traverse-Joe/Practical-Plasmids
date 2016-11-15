package kiba.plasmids.handlers;

import codechicken.lib.model.DummyBakedModel;
import kiba.plasmids.Globals;
import kiba.plasmids.items.ItemBasePlasmid;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlasmidsEventHandler {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPlasmidEquip(RenderSpecificHandEvent event) {
        if (event.getHand().equals(EnumHand.OFF_HAND) && event.getItemStack() != null && event.getItemStack().getItem() instanceof ItemBasePlasmid)
            event.setCanceled(true);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onModelBake(ModelBakeEvent event) {
        event.getModelRegistry().putObject(new ResourceLocation(Globals.MODID, "DummyModel"), new DummyModel());
    }
}


