package kiba.plasmids.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
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

    public EntityFreeze(World worldIn)
    {
        super(worldIn);
    }

    public EntityFreeze(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityFreeze(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }


    public static void func_189662_a(DataFixer p_189662_0_)
    {
        EntityThrowable.func_189661_a(p_189662_0_, "entity_cyclone");
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)0);
            if (result.entityHit instanceof EntityMob) {
            	((EntityMob) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,260,30,false,false));
            }
        }

        for (int j = 0; j < 8; ++j)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}