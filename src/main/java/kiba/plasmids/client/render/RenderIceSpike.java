package kiba.plasmids.client.render;

import kiba.plasmids.Globals;
import kiba.plasmids.entities.projectiles.ProjectileIceSpike;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;

/**
 * @author p455w0rd
 *
 */
public class RenderIceSpike extends Render<ProjectileIceSpike> {

	public RenderIceSpike(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(ProjectileIceSpike entity) {
		return new ResourceLocation(Globals.MODID, "textures/items/ice_Spike.png");
	}

}