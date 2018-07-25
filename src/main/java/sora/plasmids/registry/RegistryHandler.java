package sora.plasmids.registry;

import sora.plasmids.Globals;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = Globals.MODID)
public class RegistryHandler {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register <Item> event){
        //Items
        event.getRegistry().register(ModItems.SYRINGE);
        event.getRegistry().register(ModItems.WRENCH);
        event.getRegistry().register(ModItems.CREATIVE_EVE_HYPO);
        event.getRegistry().register(ModItems.EVE_READER);
        event.getRegistry().register(ModItems.EVE_SHARD);
        event.getRegistry().register(ModItems.EVE_TRASH_CAN);
        event.getRegistry().register(ModItems.PLASMID_CORE);
        event.getRegistry().register(ModItems.EVE_SOLUTION);
        event.getRegistry().register(ModItems.EVE_LIGHTER);
        //Plasmids
        event.getRegistry().register(ModItems.PLASMID_INCINERATE);
        event.getRegistry().register(ModItems.PLASMID_SONIC_BOOM);
        event.getRegistry().register(ModItems.PLASMID_CYCLONE_TRAP);
        event.getRegistry().register(ModItems.PLASMID_ORION_SUN);
        event.getRegistry().register(ModItems.PLASMID_FREEZE);
        //Consumables
        event.getRegistry().register(ModItems.PEP_BAR);
        event.getRegistry().register(ModItems.EVE_HYPO);
        event.getRegistry().register(ModItems.MED_KIT);
        event.getRegistry().register(ModItems.BEER);
        event.getRegistry().register(ModItems.ITEM_COFFEE);
        event.getRegistry().register(ModItems.ITEM_CIGARETTE);
        event.getRegistry().register(ModItems.FOOD_VIAL);
        event.getRegistry().register(ModItems.TEST_NEEDLE);
        event.getRegistry().register(ModItems.BURNT_FOOD);
    }
}
