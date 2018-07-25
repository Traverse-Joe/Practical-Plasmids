package sora.plasmids.entities;

import sora.plasmids.util.Utils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityCycloneTrap extends EntitySnowball {

	public EntityCycloneTrap(World worldIn) {
		super(worldIn);
	}

	public EntityCycloneTrap(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityCycloneTrap(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public static void registerFixesCyclone(DataFixer p_189662_0_) {
		EntityThrowable.registerFixesThrowable(p_189662_0_, "entity_cyclone");
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(RayTraceResult result) {
		if(this.world.isRemote) return;
		if (result.entityHit != null) {
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 0.1F);
			result.entityHit.addVelocity(0, 2.0D, 0);
		}
		Utils.spawnParticles(this, EnumParticleTypes.SMOKE_LARGE, 8, this.posX, this.posY, this.posZ,0.0D, 0.0D, 0.0D, 0.05D);
		this.setDead();
	}
}