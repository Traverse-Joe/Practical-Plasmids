package sora.plasmids.plasmids;

import sora.plasmids.PlasmidsCapabilities;
import sora.plasmids.api.IEveHolder;
import sora.plasmids.energy.implementation.EveContainer;
import sora.plasmids.energy.implementation.EveContainerProvider;
import sora.plasmids.items.base.ItemBasePlasmid;
import sora.plasmids.registry.ConfigHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class PlasmidIncinerate extends ItemBasePlasmid {
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
		return new EveContainerProvider(new EveContainer());
	}

	public PlasmidIncinerate() {
		super("plasmid_incinerate");

	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) {
		if (hand == EnumHand.OFF_HAND && playerIn.getHeldItemMainhand().isEmpty()) {
			IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
			if (holder.getStoredPower() >= ConfigHandler.eveUsagePerIncinerate) {
				target.setFire(10);
				target.attackEntityFrom(DamageSource.ON_FIRE, 10.0F);
				playerIn.world.playSound(null, playerIn.getPosition(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.PLAYERS, 2.0F + itemRand.nextFloat() * 3.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				holder.takePower(ConfigHandler.eveUsagePerIncinerate, false);
			}
		}
		return super.itemInteractionForEntity(stack, playerIn, target, hand);
	}
}
