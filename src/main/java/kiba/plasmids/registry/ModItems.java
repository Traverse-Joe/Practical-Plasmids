package kiba.plasmids.registry;

import kiba.plasmids.items.ItemSyringe;
import kiba.plasmids.items.ItemWrench;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    public static ItemSyringe itemSyringe;
    public static ItemWrench itemWrench;


    public static void init() {

        itemSyringe = new ItemSyringe();
        itemWrench = new ItemWrench();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemSyringe.initModel();
        itemWrench.initModel();
    }
}
