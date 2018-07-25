package sora.plasmids.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import sora.plasmids.foods.FoodPepBar;
import sora.plasmids.foods.ItemBurntFood;
import sora.plasmids.items.*;
import sora.plasmids.plasmids.*;

public class ModItems {

	//Items
	public static  Item SYRINGE = new ItemSyringe();
	public static  Item WRENCH = new ItemWrench();
	public static  Item CREATIVE_EVE_HYPO = new CreativeItemEve();
	public static  Item EVE_READER = new ItemEveReader();
	public static  Item EVE_SHARD = new ItemEveShard();
	public static  Item EVE_TRASH_CAN = new ItemEveTrashCan();
	public static  Item PLASMID_CORE = new ItemPlasmidCore();
	public static  Item EVE_SOLUTION = new ItemEveSolution();
	public static  Item EVE_LIGHTER = new ItemEveLighter();

	//Plasmids
	public static  Item PLASMID_INCINERATE = new PlasmidIncinerate();
	public static  Item PLASMID_SONIC_BOOM = new PlasmidSonicBoom();
	public static  Item PLASMID_CYCLONE_TRAP = new PlasmidCycloneTrap();
	public static  Item PLASMID_ORION_SUN = new PlasmidOrionSun();
	public static  Item PLASMID_FREEZE = new PlasmidFreeze();

	//Consumables
	public static  ItemFood PEP_BAR = new FoodPepBar();
	public static  Item EVE_HYPO = new ItemEveHypo();
	public static  Item MED_KIT = new ItemMedKit();
	public static  Item BEER = new ItemBeer();
	public static  Item ITEM_COFFEE = new ItemCoffee();
	public static  Item ITEM_CIGARETTE = new ItemCigarette();
	public static  Item FOOD_VIAL = new ItemFoodVial();

	public static  ItemFood BURNT_FOOD = new ItemBurntFood();
	public static  Item TEST_NEEDLE = new ItemTestNeedle();


}
