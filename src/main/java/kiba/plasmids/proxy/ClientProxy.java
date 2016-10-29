package kiba.plasmids.proxy;

import kiba.plasmids.PracticalPlasmidsCreativeTab;
import kiba.plasmids.PracticalPlasmids;
import kiba.plasmids.registry.ModItems;
import kiba.plasmids.registry.RecipeRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	public static CreativeTabs CREATIVE_TAB;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		CREATIVE_TAB = new PracticalPlasmidsCreativeTab();

	}
	
    @Override
    public void init(FMLPostInitializationEvent event){
        super.init(event);
    }
    @Override
    public void registerRenderers(PracticalPlasmids plasmids){
        ModItems.initModels();
    }

}


