package kiba.plasmids.foods;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.api.IEveHolder;
import kiba.plasmids.items.BaseFoodItem;
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
