package kiba.plasmids.plasmids;

import kiba.plasmids.Globals;
import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.energy.IEveHolder;
import kiba.plasmids.energy.implementation.EveContainer;
import kiba.plasmids.energy.implementation.EveContainerProvider;
import kiba.plasmids.items.ItemBasePlasmid;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
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
        if (hand == EnumHand.OFF_HAND && playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) == null) {
            IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
            if (holder.getStoredPower() >= Globals.EVE_USAGE_PER_INCINERATE) {
                target.setFire(10);
                target.attackEntityFrom(DamageSource.magic, 10.0F);
                playerIn.worldObj.playSound((EntityPlayer) null, playerIn.getPosition(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.PLAYERS, 5.0F, this.itemRand.nextFloat() * 0.4F + 0.8F);
                holder.takePower(Globals.EVE_USAGE_PER_INCINERATE, false);
            }


        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}







