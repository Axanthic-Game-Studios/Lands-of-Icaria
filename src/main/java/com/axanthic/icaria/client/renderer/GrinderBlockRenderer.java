package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.GrinderBlockRenderState;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.properties.Side;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record GrinderBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<GrinderBlockEntity, GrinderBlockRenderState> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_GRINDER_GEARS.get();
	}

	@Override
	public void extractRenderState(GrinderBlockEntity pBlockEntity, GrinderBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.tickClient = pBlockEntity.tickClient;
		pRenderState.blockState = pBlockEntity.getBlockState();
		pRenderState.gear = new ItemStackRenderState();
		pRenderState.shaft = new ItemStackRenderState();
		pRenderState.stone = new ItemStackRenderState();
		pRenderState.leftChain = new ItemStackRenderState();
		pRenderState.rightChain = new ItemStackRenderState();
		pRenderState.staticLeftChain = new ItemStackRenderState();
		pRenderState.staticRightChain = new ItemStackRenderState();
		pRenderState.level = pBlockEntity.getLevel();
		this.context().itemModelResolver().updateForTopItem(pRenderState.gear, pBlockEntity.getGear(), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.shaft, new ItemStack(IcariaItems.GRINDER_SHAFT.get()), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.stone, new ItemStack(IcariaItems.GRINDER_STONE.get()), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.leftChain, new ItemStack(IcariaItems.LEFT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.rightChain, new ItemStack(IcariaItems.RIGHT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.staticLeftChain, new ItemStack(IcariaItems.STATIC_LEFT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.staticRightChain, new ItemStack(IcariaItems.STATIC_RIGHT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
	}

	@Override
	public void submit(GrinderBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var blockState = pRenderState.blockState;
		var level = pRenderState.level;

		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var grinding = blockState.getValue(IcariaBlockStateProperties.GRINDER_GRINDING);
		var side = blockState.getValue(IcariaBlockStateProperties.SIDE);

		if (level != null && side == Side.LEFT) {
			var flag = grinding && pRenderState.tickClient;
			var rotation = flag ? level.getGameTime() * 16.0F : 0.0F;
			IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.gear, direction, pRenderState.lightCoords, 1.5F, -0.5F, 0.34375F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot() + rotation, 0.625F, 1.0F, 0.625F);
			IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.shaft, direction, pRenderState.lightCoords, 1.5F, -0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 180.0F + direction.toYRot() - rotation, 0.0F, 2.0F, 2.0F, 2.0F);
			IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.stone, direction, pRenderState.lightCoords, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 180.0F + direction.toYRot() - rotation, 0.0F, 2.0F, 2.0F, 2.0F);
			IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, flag ? pRenderState.leftChain : pRenderState.staticLeftChain, direction, pRenderState.lightCoords, 0.5F, 0.5F, 0.40625F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 1.0F, 1.0F, 1.0F);
			IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, flag ? pRenderState.rightChain : pRenderState.staticRightChain, direction, pRenderState.lightCoords, 1.5F, -0.5F, 0.40625F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 1.0F, 1.0F, 1.0F);
		}
	}

	@Override
	public AABB getRenderBoundingBox(GrinderBlockEntity pBlockEntity) {
		return AABB.INFINITE;
	}

	@Override
	public GrinderBlockRenderState createRenderState() {
		return new GrinderBlockRenderState();
	}
}
