package kiba.plasmids.registry;

import kiba.plasmids.Globals;
import kiba.plasmids.foods.FoodPepBar;
import kiba.plasmids.foods.ItemBurntFood;
import kiba.plasmids.items.*;
import kiba.plasmids.plasmids.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Globals.MODID)
@GameRegistry.ObjectHolder(Globals.MODID)
public class ModItems {

	//Items
	public static final Item SYRINGE = null;
	public static final Item WRENCH = null;
	public static final Item CREATIVE_EVE_HYPO = null;
	public static final Item EVE_READER = null;
	public static final Item EVE_SHARD = null;
	public static final Item EVE_TRASH_CAN = null;
	public static final Item PLASMID_CORE = null;
	public static final Item EVE_SOLUTION = null;
	public static final Item EVE_LIGHTER = null;

	//Plasmids
	public static final Item PLASMID_INCINERATE = null;
	public static final Item PLASMID_SONIC_BOOM = null;
	public static final Item PLASMID_CYCLONE_TRAP = null;
	public static final Item PLASMID_ORION_SUN = null;
	public static final Item PLASMID_FREEZE = null;

	//Consumables
	public static final Item PEP_BAR = null;
	public static final Item EVE_HYPO = null;
	public static final Item MED_KIT = null;
	public static final Item BEER = null;
	public static final Item ITEM_COFFEE = null;
	public static final Item ITEM_CIGARETTE = null;
	public static final Item FOOD_VIAL = null;

	public static final Item BURNT_FOOD = null;
	public static final Item TEST_NEEDLE = null;

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				new ItemSyringe(),
				new ItemWrench(),
				new CreativeItemEve(),
				new ItemEveReader(),
				new ItemEveShard(),
				new ItemEveTrashCan(),
				new ItemPlasmidCore(),
				new ItemEveSolution(),
				new ItemEveLighter(),

				new PlasmidIncinerate(),
				new PlasmidSonicBoom(),
				new PlasmidCycloneTrap(),
				new PlasmidOrionSun(),
				new PlasmidFreeze(),

				new FoodPepBar(),
				new ItemEveHypo(),
				new ItemMedKit(),
				new ItemBeer(),
				new ItemCoffee(),
				new ItemCigarette(),
				new ItemFoodVial(),
				new ItemBurntFood(),
				new ItemTestNeedle()
		);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void initModels(ModelRegistryEvent event) {
		registerRender(
				SYRINGE,
				WRENCH,
				CREATIVE_EVE_HYPO,
				EVE_READER,
				EVE_SHARD,
				EVE_TRASH_CAN,
				PLASMID_CORE,
				EVE_SOLUTION,
				EVE_LIGHTER,

				PLASMID_INCINERATE,
				PLASMID_SONIC_BOOM,
				PLASMID_CYCLONE_TRAP,
				PLASMID_ORION_SUN,
				PLASMID_FREEZE,

				PEP_BAR,
				EVE_HYPO,
				MED_KIT,
				BEER,
				ITEM_COFFEE,
				ITEM_CIGARETTE,
				FOOD_VIAL,
				BURNT_FOOD,
				TEST_NEEDLE);
	}

	@SideOnly(Side.CLIENT)
	public static void registerRender(Item... items) {
		for(Item item : items) ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	@SideOnly(Side.CLIENT)
	public static void registerRender(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + "_" + meta, "inventory"));
	}
}
