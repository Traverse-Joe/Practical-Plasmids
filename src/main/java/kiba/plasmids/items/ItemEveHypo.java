package kiba.plasmids.items;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import kiba.plasmids.items.base.BaseItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemEveHypo extends BaseItem {
	public ItemEveHypo() {
		super("eve_hypo");
		this.setMaxStackSize(16);

	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 30;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.setActiveHand(hand);
		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			IEveHolder holder = player.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
			holder.givePower(100, false);
			player.attackEntityFrom(DamageSource.GENERIC, 0.1F);
			stack.shrink(1);

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
