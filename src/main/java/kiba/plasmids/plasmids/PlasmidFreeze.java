package kiba.plasmids.plasmids;

import kiba.plasmids.Globals;
import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import kiba.plasmids.entities.EntityFreeze;
import kiba.plasmids.items.ItemBasePlasmid;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class PlasmidFreeze extends ItemBasePlasmid {
	public PlasmidFreeze() {
		super("plasmid_Freeze");
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.setActiveHand(hand);
		if (hand == EnumHand.OFF_HAND && playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) == null) {

		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 30;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {

		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			IEveHolder holder = player.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
			if (holder.getStoredPower() >= Globals.EVE_USAGE_PER_FREEZE) {
				if (!player.worldObj.isRemote) {
					EntityFreeze freeze = new EntityFreeze(player.worldObj, player);
					freeze.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
					worldIn.spawnEntityInWorld(freeze);
					holder.takePower(Globals.EVE_USAGE_PER_FREEZE, false);
				}
			}
		}

		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
}
