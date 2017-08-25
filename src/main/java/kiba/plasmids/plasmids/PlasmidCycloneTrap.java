package kiba.plasmids.plasmids;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import kiba.plasmids.entities.EntityCycloneTrap;
import kiba.plasmids.items.base.ItemBasePlasmid;
import kiba.plasmids.registry.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class PlasmidCycloneTrap extends ItemBasePlasmid {

	public PlasmidCycloneTrap() {
		super("plasmid_cyclone_trap");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(!worldIn.isRemote) {
			if(handIn == EnumHand.OFF_HAND && playerIn.getHeldItemMainhand().isEmpty()) {
				IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
				if (holder.getStoredPower() >= ConfigHandler.eveUsagePerCycloneTrap) {
					EntityCycloneTrap cyclone = new EntityCycloneTrap(worldIn, playerIn);
					cyclone.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
					worldIn.spawnEntity(cyclone);
					holder.takePower(ConfigHandler.eveUsagePerCycloneTrap, false);
				}
				return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
