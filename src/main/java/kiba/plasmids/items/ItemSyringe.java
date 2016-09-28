package kiba.plasmids.items;

public class ItemSyringe extends BaseItem {
    public ItemSyringe(){
        super("syringe");
        this.setMaxStackSize(1);


    }

   /* @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        playerIn.attackEntityFrom(DamageSource.generic, 0.1F);
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }*/
}
