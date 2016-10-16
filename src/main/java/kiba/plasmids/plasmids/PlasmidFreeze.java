package kiba.plasmids.plasmids;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.energy.IEveHolder;
import kiba.plasmids.entities.EntityCyclone;
import kiba.plasmids.items.ItemBasePlasmid;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
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
        if (hand == EnumHand.OFF_HAND && playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) == null)
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
        return null;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 30;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {

        if (entityLiving instanceof EntityPlayer) {
            EntityMob mob = (EntityMob) entityLiving;
            EntityPlayer player = (EntityPlayer) entityLiving;
            IEveHolder holder = player.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
            if (holder.getStoredPower() >= 20) {
                if (!player.worldObj.isRemote) {
                    EntityCyclone cyclone = new EntityCyclone(player.worldObj, player) {
                        @Override
                        protected void onImpact(RayTraceResult result) {
                            if (result.entityHit != null)
                            entityLiving.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,60,6,false,false));
                        }
                    };
                    cyclone.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
                    player.worldObj.spawnEntityInWorld(cyclone);
                    holder.takePower(20, false);


                }


            }
        }

        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}

