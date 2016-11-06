package kiba.plasmids.foods;

import kiba.plasmids.items.BaseFoodItem;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.IFuelHandler;

public class ItemBurntFood extends BaseFoodItem implements IFuelHandler {
    public ItemBurntFood() {
        super("burnt_Food", 1, 0.1F, false);
        this.setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F);
    }


    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem() == this){
            return 1600;
        }
        return 0;
    }
}