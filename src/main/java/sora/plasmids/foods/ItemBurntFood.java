package sora.plasmids.foods;

import sora.plasmids.items.base.BaseFoodItem;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public class ItemBurntFood extends BaseFoodItem {
	public ItemBurntFood() {
		super("burnt_food", 1, 0.1F, false);
		this.setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8F);
	}

}