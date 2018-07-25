package sora.plasmids.client.render;

import sora.plasmids.Globals;
import sora.plasmids.entities.projectiles.ProjectileIceSpike;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author p455w0rd, UpcraftLP
 *
 */
@SideOnly(Side.CLIENT)
public class RenderIceSpike extends Render<ProjectileIceSpike> {

	public static Factory FACTORY = new Factory();

	public RenderIceSpike(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(ProjectileIceSpike entity) {
		return new ResourceLocation(Globals.MODID, "textures/items/ice_spike.png");
	}

	public static class Factory implements IRenderFactory<ProjectileIceSpike>{

		@Override
		public Render<? super ProjectileIceSpike> createRenderFor(RenderManager manager) {
			return new RenderIceSpike(manager);
		}
	}
}