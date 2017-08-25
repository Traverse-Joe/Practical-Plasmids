package kiba.plasmids.items;

import kiba.plasmids.items.base.BaseItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemMedKit extends BaseItem {
	public ItemMedKit() {
		super("med_kit");
		this.setMaxDamage(10);
		this.setNoRepair();
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemStackIn = playerIn.getHeldItem(hand);
		playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 3, false, false));
		itemStackIn.damageItem(1, playerIn);
		return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
	}
}
