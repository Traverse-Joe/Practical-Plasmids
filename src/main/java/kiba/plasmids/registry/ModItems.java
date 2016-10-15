package kiba.plasmids.registry;

import kiba.plasmids.foods.FoodPepBar;
import kiba.plasmids.items.*;
import kiba.plasmids.plasmids.PlasmidCycloneTrap;
import kiba.plasmids.plasmids.PlasmidIncinerate;
import kiba.plasmids.plasmids.PlasmidOrionSun;
import kiba.plasmids.plasmids.PlasmidSonicBoom;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    public static ItemSyringe itemSyringe;
    public static ItemWrench itemWrench;
    public static PlasmidIncinerate plasmidIncinerate;
    public static PlasmidSonicBoom plasmidSonicBoom;
    public static CreativeItemEve creativeItemEve;
    public static ItemEveReader itemEveReader;
    public static PlasmidCycloneTrap plasmidCycloneTrap;
    public static ItemEveHypo itemEveHypo;
    public static FoodPepBar foodPepBar;
    public static ItemEveShard itemEveShard;
    public static ItemMedKit itemMedKit;
    public static ItemBeer itemBeer;
    public static ItemEveTrashCan itemEveTrashCan;
    public static ItemCoffee itemCoffee;
    public static ItemCigarette itemCigarette;
    public static PlasmidOrionSun plasmidOrionSun;


    public static void init() {
        //Items
        itemSyringe = new ItemSyringe();
        itemWrench = new ItemWrench();
        creativeItemEve = new CreativeItemEve();
        itemEveReader = new ItemEveReader();
        itemEveShard = new ItemEveShard();
        itemEveTrashCan = new ItemEveTrashCan();



        //Plasmids
        plasmidIncinerate = new PlasmidIncinerate();
        plasmidCycloneTrap = new PlasmidCycloneTrap();
        plasmidSonicBoom = new PlasmidSonicBoom();
        plasmidOrionSun = new PlasmidOrionSun();



        //Consumables
        foodPepBar =  new FoodPepBar();
        itemEveHypo = new ItemEveHypo();
        itemMedKit = new ItemMedKit();
        itemBeer = new ItemBeer();
        itemCoffee = new ItemCoffee();
        itemCigarette = new ItemCigarette();


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
        itemEveShard.initModel();
        itemMedKit.initModel();
        itemBeer.initModel();
        plasmidSonicBoom.initModel();
        itemEveTrashCan.initModel();
        itemCoffee.initModel();
        itemCigarette.initModel();
        plasmidOrionSun.initModel();

    }
}
