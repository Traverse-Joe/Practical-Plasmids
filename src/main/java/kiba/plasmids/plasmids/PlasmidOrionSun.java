package kiba.plasmids.plasmids;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import kiba.plasmids.items.base.ItemBasePlasmid;
import kiba.plasmids.registry.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlasmidOrionSun extends ItemBasePlasmid {
	public PlasmidOrionSun() {
		super("plasmid_orion_sun");

	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(hand == EnumHand.OFF_HAND && player.getHeldItemMainhand().isEmpty()) {
			IEveHolder holder = player.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
			if (holder.getStoredPower() >= ConfigHandler.eveUsagePerOrionSun) {
				if (Blocks.TORCH.canPlaceBlockOnSide(worldIn, pos, facing)) {
					new ItemStack(Blocks.TORCH).onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
					holder.takePower(ConfigHandler.eveUsagePerOrionSun, false);
				}
			}
			return EnumActionResult.SUCCESS;
		}
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
}
