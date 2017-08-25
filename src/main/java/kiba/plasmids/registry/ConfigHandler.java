package kiba.plasmids.registry;

import kiba.plasmids.Globals;
import net.minecraftforge.common.config.Config;

/**
 * @author UpcraftLP
 */
@Config(modid = Globals.MODID, category = "options")
@Config.LangKey(Globals.MODID + ".config.title")
public class ConfigHandler {

	@Config.Comment("How much EVE to consume per use of the Incinerate Plasmid")
    public static int eveUsagePerIncinerate = 10;
	@Config.Comment("How much EVE to consume per use of the Freeze Plasmid")
    public static int eveUsagePerFreeze = 20;
	@Config.Comment("How much EVE to consume per use of the Cyclone Trap Plasmid")
    public static int eveUsagePerCycloneTrap = 30;
	@Config.Comment("How much EVE to consume per use of the Orion Sun Plasmid")
    public static int eveUsagePerOrionSun = 5;
	@Config.Comment("How much EVE to consume per use of the Sonic Boom Plasmid")
    public static int eveUsagePerSonicBoom = 10;
	@Config.Comment("The MAX amount of EVE a player can have on them")
    public static int eveMaxLevel = 10000;
	@Config.Comment("The Amount of Items Recieved for the Crafting of Consumbables")
    public static int quantityCount = 8;

}
