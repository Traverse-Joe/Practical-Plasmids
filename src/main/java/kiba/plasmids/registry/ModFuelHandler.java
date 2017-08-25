package kiba.plasmids.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

/**
 * @author UpcraftLP
 */
public class ModFuelHandler implements IFuelHandler {

    public static final ModFuelHandler INSTANCE = new ModFuelHandler();

    @Override
    public int getBurnTime(ItemStack fuel) {
        if(fuel.isEmpty()) return 0;
        Item item = fuel.getItem();
        return item == ModItems.BURNT_FOOD ? 1600 : 0;
    }
}
