package kiba.plasmids.handlers;

import kiba.plasmids.items.ItemBasePlasmid;
import kiba.plasmids.plasmids.PlasmidFreeze;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static sun.audio.AudioPlayer.player;

public class PlasmidsEventHandler {

    @SubscribeEvent
    public void onPlasmidEquip(RenderSpecificHandEvent event) {
        if (event.getHand().equals(EnumHand.OFF_HAND) && event.getItemStack() != null && event.getItemStack().getItem() instanceof ItemBasePlasmid)
            event.setCanceled(true);
    }
}

