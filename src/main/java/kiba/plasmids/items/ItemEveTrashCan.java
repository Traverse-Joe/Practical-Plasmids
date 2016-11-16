package kiba.plasmids.items;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemEveTrashCan extends BaseItem {
	public ItemEveTrashCan() {
		super("eve_trashCan");
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {

		return 60;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {

		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			IEveHolder holder = player.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
			while (holder.getStoredPower() > 0L) {
				holder.takePower(10000L, false);
			}

			player.attackEntityFrom(DamageSource.generic, 0.1F);

		}

		return stack;
	}

}