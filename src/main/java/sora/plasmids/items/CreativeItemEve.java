package sora.plasmids.items;

import sora.plasmids.PlasmidsCapabilities;
import sora.plasmids.api.IEveHolder;
import sora.plasmids.items.base.BaseItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class CreativeItemEve extends BaseItem {
	public CreativeItemEve() {
		super("creative_eve_hypo");
		this.setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!worldIn.isRemote) {
			IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
			holder.givePower(holder.getCapacity() - holder.getStoredPower(), false);
			playerIn.attackEntityFrom(DamageSource.GENERIC, 0.1F);
			ItemStack stack = playerIn.getHeldItem(handIn);
			if(!playerIn.isCreative()) stack.shrink(1);
			return new ActionResult<>(EnumActionResult.SUCCESS, stack);
		}
		return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
	}
}
