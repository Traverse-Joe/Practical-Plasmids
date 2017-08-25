package kiba.plasmids.plasmids;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import kiba.plasmids.entities.EntityFreeze;
import kiba.plasmids.items.base.ItemBasePlasmid;
import kiba.plasmids.registry.ConfigHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class PlasmidFreeze extends ItemBasePlasmid {
	public PlasmidFreeze() {
		super("plasmid_freeze");
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (hand == EnumHand.OFF_HAND && playerIn.getHeldItemMainhand().isEmpty()) {
			playerIn.setActiveHand(hand);
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItemOffhand());
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 30;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		if(!worldIn.isRemote) {
			if (entityLiving instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entityLiving;
				IEveHolder holder = player.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
				if (holder.getStoredPower() >= ConfigHandler.eveUsagePerFreeze) {
					EntityFreeze freeze = new EntityFreeze(worldIn, player);
					freeze.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
					worldIn.spawnEntity(freeze);
					holder.takePower(ConfigHandler.eveUsagePerFreeze, false);
				}
			}
		}
		return stack;
	}
}
