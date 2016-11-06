package kiba.plasmids.plasmids;

import kiba.plasmids.Globals;
import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import kiba.plasmids.items.ItemBasePlasmid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlasmidOrionSun extends ItemBasePlasmid {
	public PlasmidOrionSun() {
		super("plasmid_orionSun");

	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (hand == EnumHand.OFF_HAND && playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) == null) {
			IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
			if (holder.getStoredPower() >= Globals.EVE_USAGE_PER_ORION_SUN) {
				if (Blocks.TORCH.canPlaceBlockOnSide(worldIn, pos, facing)) {
					new ItemStack(Blocks.TORCH).onItemUse(playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
					holder.takePower(Globals.EVE_USAGE_PER_ORION_SUN, false);
				}
			}
		}
		return null;
	}
}
