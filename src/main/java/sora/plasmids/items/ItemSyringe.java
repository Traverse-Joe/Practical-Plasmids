package sora.plasmids.items;

import sora.plasmids.items.base.BaseItem;

public class ItemSyringe extends BaseItem {
	public ItemSyringe() {
		super("syringe");
		this.setMaxStackSize(16);

	}

	/* @Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
	    playerIn.attackEntityFrom(DamageSource.generic, 0.1F);
	    return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}*/
}
