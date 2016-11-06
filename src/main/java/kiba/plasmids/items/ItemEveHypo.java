package kiba.plasmids.items;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemEveHypo extends BaseItem {
    public ItemEveHypo() {
        super("eve_Hypo");
        this.setMaxStackSize(16);


    }
    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    @Override
    public int getMaxItemUseDuration (ItemStack stack) {

        return 30;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
       playerIn.setActiveHand(hand);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }
    @Override
    public ItemStack onItemUseFinish (ItemStack stack, World worldIn, EntityLivingBase entityLiving) {

        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)entityLiving;
            IEveHolder holder = player.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
            holder.givePower(100, false);
            player.attackEntityFrom(DamageSource.generic, 0.1F);
            --stack.stackSize;

        }

        return stack;
    }

}
/*
 IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
        holder.givePower(100, false);
        playerIn.attackEntityFrom(DamageSource.generic, 0.1F);
        --itemStackIn.stackSize;
 */

