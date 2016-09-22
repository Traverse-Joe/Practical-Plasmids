package kiba.plasmids.items;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.energy.IEveHolder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemEveHypo extends BaseItem {
    public ItemEveHypo() {
        super("eve_Hypo");
        this.setMaxStackSize(16);


    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
        holder.givePower(100, false);
        playerIn.attackEntityFrom(DamageSource.generic, 0.1F);
        --itemStackIn.stackSize;
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
         }

}

