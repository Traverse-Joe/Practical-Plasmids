package kiba.plasmids.plasmids;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import kiba.plasmids.items.base.ItemBasePlasmid;
import kiba.plasmids.registry.ConfigHandler;
import kiba.plasmids.registry.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;

public class PlasmidSonicBoom extends ItemBasePlasmid {

	public PlasmidSonicBoom() {
		super("plasmid_sonic_boom");
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) {
		if (hand == EnumHand.OFF_HAND && playerIn.getHeldItemMainhand().isEmpty() && !playerIn.world.isRemote) {
			if (stack != null) {
				Item item = stack.getItem();
				if (item.equals(ModItems.PLASMID_SONIC_BOOM)) {
					IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
					if (holder.getStoredPower() >= ConfigHandler.eveUsagePerSonicBoom) {
						holder.takePower(ConfigHandler.eveUsagePerSonicBoom, false);
						Vec3d lookVec = playerIn.getLookVec();
						double multiplier = 2;
						multiplier *= playerIn.getAIMoveSpeed() * 10;
						lookVec = lookVec.scale(multiplier);
						target.motionX += lookVec.x;
						double yToAdd = lookVec.y;
						if (yToAdd < 0) {
							yToAdd = -yToAdd / 2d;
						}
						target.motionY += yToAdd + 0.5;
						target.motionZ += lookVec.z * 4;

					}
				}
			}
		}
		return super.itemInteractionForEntity(stack, playerIn, target, hand);
	}

}
