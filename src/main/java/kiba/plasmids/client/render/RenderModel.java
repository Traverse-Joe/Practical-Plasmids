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
package kiba.plasmids.client.render;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author p455w0rd
 *
 */
@SideOnly(Side.CLIENT)
public class RenderModel {
	public static void render(IBakedModel model, ItemStack stack) {
		render(model, -1, stack);
	}

	public static void render(IBakedModel model, int color) {
		render(model, color, (ItemStack) null);
	}

	public static void render(IBakedModel model, int color, ItemStack stack) {
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer vertexbuffer = tessellator.getBuffer();
		vertexbuffer.begin(7, DefaultVertexFormats.ITEM);
		for (EnumFacing enumfacing : EnumFacing.values()) {
			renderQuads(vertexbuffer, model.getQuads((IBlockState) null, enumfacing, 0L), color, stack);
		}
		renderQuads(vertexbuffer, model.getQuads((IBlockState) null, (EnumFacing) null, 0L), color, stack);
		tessellator.draw();
	}

	public static void renderQuads(VertexBuffer renderer, List<BakedQuad> quads, int color, ItemStack stack) {
		boolean flag = (color == -1) && (stack != null);
		int i = 0;
		for (int j = quads.size(); i < j; i++) {
			BakedQuad bakedquad = quads.get(i);
			int k = color;
			if ((flag) && (bakedquad.hasTintIndex())) {
				ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
				k = itemColors.getColorFromItemstack(stack, bakedquad.getTintIndex());
				if (EntityRenderer.anaglyphEnable) {
					k = TextureUtil.anaglyphColor(k);
				}
				k |= 0xFF000000;
			}
			LightUtil.renderQuadColor(renderer, bakedquad, k);
		}
	}

	// =========

	public static void render(ModelPlayer model, int color, EntityPlayer player, float partialTicks, boolean multiPass) {
		RenderManager rm = Minecraft.getMinecraft().getRenderManager();
		rm.doRenderEntity(player, player.posX, player.posY, player.posZ, player.cameraYaw, partialTicks, multiPass);
	}

}