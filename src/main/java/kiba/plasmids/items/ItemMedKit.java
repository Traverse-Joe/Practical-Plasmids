package kiba.plasmids.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemMedKit extends BaseItem {
    public ItemMedKit() {
        super("med_kit");
        this.setMaxDamage(4);

    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if (itemStackIn.getItemDamage() == 4) {
            playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 3, false, false));
            --itemStackIn.stackSize;
        } else
            playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 3, false, false));
        itemStackIn.damageItem(+1, playerIn);

        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}



