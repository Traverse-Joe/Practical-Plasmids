package kiba.plasmids.registry;

import kiba.plasmids.Globals;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigHandler {
	public static Configuration CONFIG;
	private static String DEF_CAT = "Options";
	public static long eveUsagePerIncinerate;
	public static long eveUsagePerFreeze;
	public static long eveUsagePerCycloneTrap;
	public static long eveUsagePerOrionSun;
	public static long eveUsagePerSonicBoom;
	public static long eveMaxLevel;



	@SubscribeEvent
	public void onConfigChange(ConfigChangedEvent.OnConfigChangedEvent e) {
		if (e.getModID().equals(Globals.MODID)) {
			init();
		}

	}

	public static void init() {
		if (CONFIG == null) {
			CONFIG = new Configuration(new File(Globals.CONFIG_FILE));
			MinecraftForge.EVENT_BUS.register(new ConfigHandler());

		}
		eveUsagePerIncinerate = CONFIG.getInt("EveUsagePerIncinerate", DEF_CAT, 10, 1, 10000, "How much EVE to consume per use of the Incinerate Plasmid");
		Globals.EVE_USAGE_PER_INCINERATE = (long) eveUsagePerIncinerate;

		eveUsagePerFreeze = CONFIG.getInt("EveUsagePerFreeze", DEF_CAT, 20, 1, 10000, "How much EVE to consume per use of the Freeze Plasmid");
		Globals.EVE_USAGE_PER_FREEZE = (long) eveUsagePerFreeze;

		eveUsagePerCycloneTrap = CONFIG.getInt("EveUsagePerCycloneTrap", DEF_CAT, 30, 1, 10000, "How much EVE to consume per use of the Cyclone Trap Plasmid");
		Globals.EVE_USAGE_PER_CYCLONE_TRAP = (long) eveUsagePerCycloneTrap;

		eveUsagePerOrionSun = CONFIG.getInt("EveUsagePerOrionSun", DEF_CAT, 5, 1, 10000, "How much EVE to consume per use of the Orion Sun Plasmid");
		Globals.EVE_USAGE_PER_ORION_SUN = (long) eveUsagePerOrionSun;

		eveUsagePerSonicBoom = CONFIG.getInt("EveUsagePerSonicBoom", DEF_CAT, 10, 1, 10000, "How much EVE to consume per use of the Sonic Boom Plasmid");
		Globals.EVE_USAGE_PER_SONIC_BOOM = (long) eveUsagePerSonicBoom;

		eveMaxLevel = CONFIG.getInt("EveMaxLevel", DEF_CAT, 10000, 1, 1000000, "The MAX amount of EVE a player can have on them");
		Globals.EVE_MAX_LEVEL = (long) eveMaxLevel;

		Globals.QUANTITY_COUNT = CONFIG.getInt("QuantityCount",DEF_CAT,8,1,64,"The Amount of Items Recieved for the Crafting of Consumbables");

		if (CONFIG.hasChanged()) {
			CONFIG.save();
		}

	}
}
