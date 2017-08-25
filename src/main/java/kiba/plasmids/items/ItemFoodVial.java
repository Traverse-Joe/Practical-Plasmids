package kiba.plasmids.items;

import kiba.plasmids.items.base.BaseItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemFoodVial extends BaseItem {
	public ItemFoodVial() {
		super("food_vial");
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
			player.attackEntityFrom(DamageSource.GENERIC, 0.1F);
			player.getFoodStats().setFoodLevel(20);
			player.getFoodStats().addStats(20, 5f);
			worldIn.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, worldIn.rand.nextFloat() * 0.6F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
			stack.shrink(1);
		}

		return stack;
	}

}
