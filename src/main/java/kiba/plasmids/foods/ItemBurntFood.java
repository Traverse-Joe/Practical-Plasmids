package kiba.plasmids.foods;

import kiba.plasmids.items.base.BaseFoodItem;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.IFuelHandler;

public class ItemBurntFood extends BaseFoodItem {
	public ItemBurntFood() {
		super("burnt_food", 1, 0.1F, false);
		this.setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F);
	}

}