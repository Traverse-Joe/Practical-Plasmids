package kiba.plasmids.plasmids;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.energy.IEveHolder;
import kiba.plasmids.items.ItemBasePlasmid;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
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
            if (holder.getStoredPower() >= 10) {
                IBlockState iblockstate = worldIn.getBlockState(pos);
                Block block = iblockstate.getBlock();
 /*               if ((block.isReplaceable(worldIn, pos)) && (block == Blocks.SNOW_LAYER)) {
                    facing = EnumFacing.UP;
                } else if (!block.isReplaceable(worldIn, pos)) {
      */              pos = pos.offset(facing);






            //        }
                }
           // if (playerIn.canPlayerEdit(pos, facing, stack)) {
            //    pos = pos.offset(facing.getOpposite());
                EnumActionResult result = new ItemStack(Blocks.TORCH).onItemUse(playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
                holder.takePower(10,false);
            //}
          }

        return null;
    }
    }




