package com.axanthic.icaria.client.render;

import com.axanthic.icaria.common.entities.CrystalBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

@OnlyIn(Dist.CLIENT)
public class CrystalBlockRenderer implements BlockEntityRenderer<CrystalBlockEntity> {
	public static final ResourceLocation BEAM_LOCATION = new ResourceLocation("textures/entity/beacon_beam.png");
	public CrystalBlockRenderer(BlockEntityRendererProvider.Context pContext) {

	}

	public void render(CrystalBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {

	}
}
