package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.IcariaShelfBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record IcariaShelfBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<IcariaShelfBlockEntity> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_SHELF_ITEMS.get();
	}

	@Override
	public void render(IcariaShelfBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		this.render(pPoseStack, pMultiBufferSource, pBlockEntity.getBottomLeftItem(), pBlockEntity, pPackedLight, 0.25F, 0.75F, 0.34375F, pBlockEntity.getBottomLeftAngle());
		this.render(pPoseStack, pMultiBufferSource, pBlockEntity.getBottomRightItem(), pBlockEntity, pPackedLight, 0.75F, 0.25F, 0.34375F, pBlockEntity.getBottomRightAngle());
		this.render(pPoseStack, pMultiBufferSource, pBlockEntity.getTopLeftItem(), pBlockEntity, pPackedLight, 0.25F, 0.75F, 0.84375F, pBlockEntity.getTopLeftAngle());
		this.render(pPoseStack, pMultiBufferSource, pBlockEntity.getTopRightItem(), pBlockEntity, pPackedLight, 0.75F, 0.25F, 0.84375F, pBlockEntity.getTopRightAngle());
	}

	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, @Nullable Item pItem, BlockEntity pBlockEntity, int pPackedLight, float pXMin, float pXMax, float pY, double pYRot) {
		var level = pBlockEntity.getLevel();
		if (level != null && pItem != null) {
			var direction = pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, new ItemStack(pItem), direction, pBlockEntity, pPackedLight, pXMin, pXMax, pY, 0.75F, 0.25F, 0.0F, (180.0F - direction.toYRot() - Mth.sin((float) (level.getGameTime() * 0.025F - pYRot * 90.0F)) * 45.0F), 0.0F, 0.25F, 0.25F, 0.25F);
		}
	}
}
