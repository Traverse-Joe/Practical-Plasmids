package sora.plasmids.registry;

import sora.plasmids.Globals;
import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Globals.MODID)
public class MobDrops {

	@SubscribeEvent
	public static void playerKilledEntity(LivingDropsEvent event) {
		if (event.getEntity() instanceof EntityMob) {
			if (((EntityMob) event.getEntity()).getRNG().nextInt(5) == 0) event.getEntityLiving().dropItem(ModItems.EVE_SHARD, 1);
		}
	}

}
