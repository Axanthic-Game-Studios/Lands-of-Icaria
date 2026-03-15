package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record GrinderBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<GrinderBlockEntity> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_GRINDER_GEARS.get();
	}

	@Override
	public void render(GrinderBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		var blockState = pBlockEntity.getBlockState();
		var level = pBlockEntity.getLevel();

		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var grinding = blockState.getValue(IcariaBlockStateProperties.GRINDER_GRINDING);

		if (level != null) {
			var flag = grinding && pBlockEntity.tickClient;
			var rotation = flag ? level.getGameTime() * 16.0F : 0.0F;
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, pBlockEntity.getGear(), direction, pBlockEntity, pPackedLight, 1.5F, -0.5F, 0.34375F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot() + rotation, 0.625F, 1.0F, 0.625F);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, new ItemStack(IcariaItems.GRINDER_SHAFT.get()), direction, pBlockEntity, pPackedLight, 1.5F, -0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 180.0F + direction.toYRot() - rotation, 0.0F, 2.0F, 2.0F, 2.0F);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, new ItemStack(IcariaItems.GRINDER_STONE.get()), direction, pBlockEntity, pPackedLight, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 180.0F + direction.toYRot() - rotation, 0.0F, 2.0F, 2.0F, 2.0F);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, flag ? new ItemStack(IcariaItems.LEFT_GRINDER_CHAIN.get()) : new ItemStack(IcariaItems.STATIC_LEFT_GRINDER_CHAIN.get()), direction, pBlockEntity, pPackedLight, 0.5F, 0.5F, 0.40625F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 1.0F, 1.0F, 1.0F);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, flag ? new ItemStack(IcariaItems.RIGHT_GRINDER_CHAIN.get()) : new ItemStack(IcariaItems.STATIC_RIGHT_GRINDER_CHAIN.get()), direction, pBlockEntity, pPackedLight, 1.5F, -0.5F, 0.40625F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 1.0F, 1.0F, 1.0F);
		}
	}

	@Override
	public AABB getRenderBoundingBox(GrinderBlockEntity pBlockEntity) {
		return AABB.INFINITE;
	}
}
