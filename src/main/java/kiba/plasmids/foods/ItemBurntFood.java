package kiba.plasmids.foods;

import kiba.plasmids.items.BaseFoodItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBurntFood extends BaseFoodItem {
    public ItemBurntFood() {
        super("burnt_Food", 1, 0.1F, false);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA,20,1,true,true));
    }
}