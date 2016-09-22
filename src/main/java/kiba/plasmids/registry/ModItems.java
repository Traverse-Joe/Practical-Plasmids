package kiba.plasmids.registry;

import kiba.plasmids.foods.FoodPepBar;
import kiba.plasmids.items.*;
import kiba.plasmids.plasmids.PlasmidCycloneTrap;
import kiba.plasmids.plasmids.PlasmidIncinerate;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    public static ItemSyringe itemSyringe;
    public static ItemWrench itemWrench;
    public static PlasmidIncinerate plasmidIncinerate;
    public static CreativeItemEve creativeItemEve;
    public static ItemEveReader itemEveReader;
    public static PlasmidCycloneTrap plasmidCycloneTrap;
    public static ItemEveHypo itemEveHypo;
    public static FoodPepBar foodPepBar;

    public static void init() {
        //Items
        itemSyringe = new ItemSyringe();
        itemWrench = new ItemWrench();
        creativeItemEve = new CreativeItemEve();
        itemEveReader = new ItemEveReader();
        itemEveHypo = new ItemEveHypo();
        //Plasmids
        plasmidIncinerate = new PlasmidIncinerate();
        plasmidCycloneTrap = new PlasmidCycloneTrap();
        //Food
        foodPepBar =  new FoodPepBar();


    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemSyringe.initModel();
        itemWrench.initModel();
        plasmidIncinerate.initModel();
        creativeItemEve.initModel();
        itemEveReader.initModel();
        plasmidCycloneTrap.initModel();
        itemEveHypo.initModel();
        foodPepBar.initModel();
    }
}
