package kiba.plasmids.plasmids;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.energy.IEveHolder;
import kiba.plasmids.energy.implementation.EveContainer;
import kiba.plasmids.energy.implementation.EveContainerProvider;
import kiba.plasmids.items.ItemBasePlasmid;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
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
        if (hand == EnumHand.OFF_HAND && playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) ==null) {
            IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
            if (holder.getStoredPower()>=10){
                target.setFire(10);
                holder.takePower(10 , false);
            }



        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}







