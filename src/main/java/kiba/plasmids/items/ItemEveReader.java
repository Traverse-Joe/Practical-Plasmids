package kiba.plasmids.items;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemEveReader extends BaseItem {

    public ItemEveReader() {
        super("eve_Reader");
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
        if (holder == null || playerIn == null) { return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn); }
        if(!worldIn.isRemote){
            playerIn.addChatMessage(new TextComponentString(String.format("%s: %d","Capacity",holder.getCapacity())));
            playerIn.addChatMessage(new TextComponentString(String.format("%s: %d","Stored",holder.getStoredPower())));

        }
        playerIn.attackEntityFrom(DamageSource.generic, 0.1F);

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }

}
