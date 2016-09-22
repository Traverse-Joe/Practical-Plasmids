package kiba.plasmids.plasmids;

import kiba.plasmids.items.ItemBasePlasmid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class PlasmidIncinerate extends ItemBasePlasmid {
    public PlasmidIncinerate() {
        super("plasmid_incinerate");

    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) {
        if (hand == EnumHand.OFF_HAND) {
            target.setFire(20);



        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}







