package kiba.plasmids.registry;

import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class MobDrops {
    Random random = new Random();


    @SubscribeEvent
    public void playerKilledEntity(LivingDropsEvent event) {
        if (event.getEntity() instanceof EntityMob) {
            if(random.nextInt(5) == 0)
                event.getEntityLiving().dropItem(ModItems.itemEveShard, 1);
        }
    }


}
