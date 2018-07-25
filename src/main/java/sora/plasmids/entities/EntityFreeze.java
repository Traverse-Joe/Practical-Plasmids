package sora.plasmids.entities;

import sora.plasmids.util.Utils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFreeze extends EntitySnowball {

	public EntityFreeze(World worldIn) {
		super(worldIn);
	}

	public EntityFreeze(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityFreeze(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public static void registerFixesFreeze(DataFixer p_189662_0_) {
		EntityThrowable.registerFixesThrowable(p_189662_0_, "entity_freeze");
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(RayTraceResult result) {
		if (result.entityHit != null) {
			if(!world.isRemote) {
				result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.5F);
				if (result.entityHit instanceof EntityMob) {
					((EntityMob) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 260, 30, false, false));
				}
			}
		}
		Utils.spawnParticles(this, EnumParticleTypes.SMOKE_LARGE, 8, this.posX, this.posY, this.posZ,0.0D, 0.0D, 0.0D, 0.05D);
		this.setDead();
	}
}