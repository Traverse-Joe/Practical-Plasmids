package kiba.plasmids.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSyringe extends BaseItem {
    public ItemSyringe(){
        super("syringe");
        this.setMaxStackSize(1);
        this.hasSubtypes = true;

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        playerIn.attackEntityFrom(DamageSource.generic, 0.1F);
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}
