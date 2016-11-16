package kiba.plasmids.items;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class CreativeItemEve extends BaseItem {
	public CreativeItemEve() {
		super("creative_eveHypo");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (!worldIn.isRemote) {
			IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
			while (holder.getStoredPower() < 1000L) {
				holder.givePower(10000L, false);
			}

			playerIn.attackEntityFrom(DamageSource.generic, 0.1F);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
	}

}
