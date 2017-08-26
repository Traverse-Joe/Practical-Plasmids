package kiba.plasmids.items;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import kiba.plasmids.items.base.BaseItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemEveLighter extends BaseItem {
	public ItemEveLighter() {
		super("eve_lighter");
		this.setMaxDamage(64);
		this.setMaxStackSize(1);
		this.setNoRepair();
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
			if (holder.getStoredPower() >= 5) {

				pos = pos.offset(facing);

				if (!playerIn.canPlayerEdit(pos, facing, playerIn.getHeldItem(hand))) {
					return EnumActionResult.FAIL;
				}
				else {
					if (worldIn.isAirBlock(pos)) {
						worldIn.playSound(playerIn, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 0.6F + itemRand.nextFloat() * 0.4F, itemRand.nextFloat() * 0.4F + 0.8F);
						worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState(), 11);
						holder.takePower(5, false);
					}
				}

			}
		}
		return EnumActionResult.SUCCESS;
	}

	public boolean hasContainerItem(ItemStack itemStack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		ItemStack stack = itemStack.copy();
		stack.setItemDamage(stack.getItemDamage() + 1);
		stack.setCount(1);
		return stack;
	}

}
