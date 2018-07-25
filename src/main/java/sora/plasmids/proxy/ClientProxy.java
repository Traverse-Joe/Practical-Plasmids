package sora.plasmids.proxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sora.plasmids.registry.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(Side.CLIENT)
@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);

    }
     @Override
    public void init(FMLInitializationEvent event){
        super.init(event);

     }
     @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);

     }
     @SubscribeEvent
    public static void rendModels(ModelRegistryEvent event){
        //Items
         regModel(ModItems.SYRINGE);
         regModel(ModItems.WRENCH);
         regModel(ModItems.CREATIVE_EVE_HYPO);
         regModel(ModItems.EVE_READER);
         regModel(ModItems.EVE_SHARD);
         regModel(ModItems.EVE_TRASH_CAN);
         regModel(ModItems.PLASMID_CORE);
         regModel(ModItems.EVE_SOLUTION);
         regModel(ModItems.EVE_LIGHTER);
         //Plasmids
         regModel(ModItems.PLASMID_INCINERATE);
         regModel(ModItems.PLASMID_SONIC_BOOM);
         regModel(ModItems.PLASMID_CYCLONE_TRAP);
         regModel(ModItems.PLASMID_ORION_SUN);
         regModel(ModItems.PLASMID_FREEZE);
         //Consumables
         regModel(ModItems.PEP_BAR);
         regModel(ModItems.EVE_HYPO);
         regModel(ModItems.MED_KIT);
         regModel(ModItems.BEER);
         regModel(ModItems.ITEM_COFFEE);
         regModel(ModItems.ITEM_CIGARETTE);
         regModel(ModItems.FOOD_VIAL);
         regModel(ModItems.TEST_NEEDLE);
         regModel(ModItems.BURNT_FOOD);


     }
     public  static void regModel(Item item){
         ModelLoader.setCustomModelResourceLocation(item,0,new ModelResourceLocation(item.getRegistryName(), "inventory"));
     }

}
