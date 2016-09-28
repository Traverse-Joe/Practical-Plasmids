package kiba.plasmids.plasmids;

import kiba.plasmids.items.ItemBasePlasmid;
import kiba.plasmids.registry.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

public class PlasmidSonicBoom extends ItemBasePlasmid {
	
	public PlasmidSonicBoom() {
		super("plasmid_sonicBoom");
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onItemUse(PlayerInteractEvent.EntityInteractSpecific event) {
		if (event.getSide() == Side.SERVER && event.getHand() == EnumHand.OFF_HAND) {
			ItemStack stack = event.getItemStack();
			if (stack != null) {
				Item item = stack.getItem();
				if (item.equals(ModItems.plasmidSonicBoom)) {
					EntityPlayer player = event.getEntityPlayer();
					Vec3d lookVec = player.getLookVec();
					Entity target = event.getTarget();
					double multiplier = 2;
					multiplier *= player.getAIMoveSpeed() * 10;
					lookVec = lookVec.scale(multiplier);
					target.motionX += lookVec.xCoord;
					double yToAdd = lookVec.yCoord;
					if (yToAdd < 0) {
						yToAdd = -yToAdd / 2d;
					}
					target.motionY += yToAdd + 0.5;
					target.motionZ += lookVec.zCoord * 4;
				}
			}
		}
	}
	
}
