package kiba.plasmids.items;

import kiba.plasmids.PracticalPlasmids;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaseItem extends Item {
    public BaseItem(String name){
        this.setRegistryName(name);
        this.setUnlocalizedName(PracticalPlasmids.MODID + "." + name);
        GameRegistry.register(this);

    }
    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(this , 0, new ModelResourceLocation(getRegistryName(),"inventory"));

    }

}

