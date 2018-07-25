package sora.plasmids.foods;

import sora.plasmids.PlasmidsCapabilities;
import sora.plasmids.api.IEveHolder;
import sora.plasmids.items.base.BaseFoodItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FoodPepBar extends BaseFoodItem {
	public FoodPepBar() {
		super("pep_bar", 1, 1.0F, false);
		this.setAlwaysEdible();

	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		IEveHolder holder = player.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
		holder.givePower(1, false);
		super.onFoodEaten(stack, worldIn, player);
	}
}
