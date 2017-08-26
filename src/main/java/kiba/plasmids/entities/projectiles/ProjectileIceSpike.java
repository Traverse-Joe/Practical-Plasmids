/*
 * This file is part of p455w0rd's Things.
 * Copyright (c) 2016, p455w0rd (aka TheRealp455w0rd), All rights reserved
 * unless
 * otherwise stated.
 *
 * p455w0rd's Things is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License.
 *
 * p455w0rd's Things is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * MIT License for more details.
 *
 * You should have received a copy of the MIT License
 * along with p455w0rd's Things. If not, see
 * <https://opensource.org/licenses/MIT>.
 */
package kiba.plasmids.entities.projectiles;

import kiba.plasmids.util.Utils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * @author p455w0rd
 *
 */
public class ProjectileIceSpike extends EntityThrowable {

	public ProjectileIceSpike(World world) {
		/*
		 * DO NOT REMVOE THIS CONSTRUCTOR
		 * vanilla mc requires all entities to have a constructor that takes a net.minecraft.world.World as only parameter.
		 */
		super(world);
	}

	public ProjectileIceSpike(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public static void registerFixesIceSpike(DataFixer p_189662_0_) {
		EntityThrowable.registerFixesThrowable(p_189662_0_, "ice_spike");
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(RayTraceResult result) {
		if(!world.isRemote) return;
		if (result.entityHit != null) {
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 0);
			if (result.entityHit instanceof EntityMob) {
				((EntityMob) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 260, 30, false, false));
			}
		}
		Utils.spawnParticles(this, EnumParticleTypes.SMOKE_LARGE, 8, posX, posY, posZ, 0.0D, 0.0D, 0.0D, 0.05D);
		setDead();
	}
}
