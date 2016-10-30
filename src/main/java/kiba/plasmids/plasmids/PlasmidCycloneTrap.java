package kiba.plasmids.plasmids;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.energy.IEveHolder;
import kiba.plasmids.entities.EntityFreeze;
import kiba.plasmids.items.ItemBasePlasmid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class PlasmidCycloneTrap extends ItemBasePlasmid {

	public PlasmidCycloneTrap() {
		super("plasmid_cycloneTrap");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (hand == EnumHand.OFF_HAND && playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) == null) {
			IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
			if (holder.getStoredPower() >= 30) {
				if (!playerIn.worldObj.isRemote) {
					EntitySnowball snowball = new EntityFreeze(playerIn.worldObj, playerIn) {
						@Override
						protected void onImpact(RayTraceResult result) {
							if (result.entityHit != null) result.entityHit.motionY = 2;
						}
					};
					snowball.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
					playerIn.worldObj.spawnEntityInWorld(snowball);
					holder.takePower(30, false);
				}
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}
}
