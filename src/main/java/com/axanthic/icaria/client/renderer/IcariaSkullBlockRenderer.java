package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.*;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.block.IcariaAbstractSkullBlock;
import com.axanthic.icaria.common.block.IcariaWallSkullBlock;
import com.axanthic.icaria.common.entity.IcariaSkullBlockEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;
import com.axanthic.icaria.common.util.IcariaSkullBlockTypes;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSkullBlockRenderer implements BlockEntityRenderer<IcariaSkullBlockEntity> {
	public Map<IcariaSkullBlockType, SkullModel> map;

	public static final Map<IcariaSkullBlockType, ResourceLocation> MAP = Util.make(
		Maps.newHashMap(), (hashMap) -> {
			hashMap.put(IcariaSkullBlockTypes.AETERNAE, IcariaResourceLocations.AETERNAE);
			hashMap.put(IcariaSkullBlockTypes.ARGAN_HOUND, IcariaResourceLocations.ARGAN_HOUND);
			hashMap.put(IcariaSkullBlockTypes.CAPELLA, IcariaResourceLocations.CAPELLA);
			hashMap.put(IcariaSkullBlockTypes.CATOBLEPAS, IcariaResourceLocations.CATOBLEPAS);
			hashMap.put(IcariaSkullBlockTypes.CERVER, IcariaResourceLocations.CERVER);
			hashMap.put(IcariaSkullBlockTypes.CROCOTTA, IcariaResourceLocations.CROCOTTA);
			hashMap.put(IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, IcariaResourceLocations.CYPRESS_FOREST_HAG);
			hashMap.put(IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, IcariaResourceLocations.DROUGHTROOT_FOREST_HAG);
			hashMap.put(IcariaSkullBlockTypes.FIR_FOREST_HAG, IcariaResourceLocations.FIR_FOREST_HAG);
			hashMap.put(IcariaSkullBlockTypes.LAUREL_FOREST_HAG, IcariaResourceLocations.LAUREL_FOREST_HAG);
			hashMap.put(IcariaSkullBlockTypes.OLIVE_FOREST_HAG, IcariaResourceLocations.OLIVE_FOREST_HAG);
			hashMap.put(IcariaSkullBlockTypes.PLANE_FOREST_HAG, IcariaResourceLocations.PLANE_FOREST_HAG);
			hashMap.put(IcariaSkullBlockTypes.POPULUS_FOREST_HAG, IcariaResourceLocations.POPULUS_FOREST_HAG);
			hashMap.put(IcariaSkullBlockTypes.REVENANT, IcariaResourceLocations.CAPTAIN_REVENANT);
			hashMap.put(IcariaSkullBlockTypes.SOW, IcariaResourceLocations.SOW);
		}
	);

	public IcariaSkullBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		this.map = IcariaSkullBlockRenderer.createRenderers(pContext.getModelSet());
	}

	@Override
	public void render(IcariaSkullBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay) {
		var blockState = pBlockEntity.getBlockState();
		var flag = blockState.getBlock() instanceof IcariaWallSkullBlock;
		var direction = flag ? blockState.getValue(BlockStateProperties.HORIZONTAL_FACING) : null;
		var f = flag ? (direction.get2DDataValue() + 2.0F) * 4.0F : blockState.getValue(BlockStateProperties.ROTATION_16);
		IcariaSkullBlockRenderer.renderSkull(blockState.getBlock(), direction, this.map, pMultiBufferSource, pPoseStack, f * 22.5F, pPackedLight);
	}

	public static void renderSkull(Block pBlock, @Nullable Direction pDirection, Map<IcariaSkullBlockType, SkullModel> pMap, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, float pRotation, int pPackedLight) {
		if (pBlock instanceof IcariaAbstractSkullBlock icariaAbstractSkullBlock) {
			var icariaSkullBlockType = icariaAbstractSkullBlock.getType();
			var resourceLocation = IcariaSkullBlockRenderer.MAP.get(icariaSkullBlockType);
			var skullModel = pMap.get(icariaSkullBlockType);
			var vertexConsumer = pMultiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation));

			pPoseStack.pushPose();

			IcariaSkullBlockRenderer.translate(pDirection, pPoseStack, icariaAbstractSkullBlock.getOffset());

			pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
			pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));

			skullModel.setupAnim(0.0F, pRotation, 0.0F);
			skullModel.renderToBuffer(pPoseStack, vertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY);

			pPoseStack.popPose();
		}
	}

	public static void translate(@Nullable Direction pDirection, PoseStack pPoseStack, float pOffset) {
		if (pDirection == null) {
			pPoseStack.translate(0.5D, 0.0D, 0.5D);
		} else {
			pPoseStack.translate(0.5D - pDirection.getStepX() * (0.25D + pOffset), 0.25D, 0.5D - pDirection.getStepZ() * (0.25D + pOffset));
		}
	}

	public static Map<IcariaSkullBlockType, SkullModel> createRenderers(EntityModelSet pEntityModelSet) {
		var builder = ImmutableMap.<IcariaSkullBlockType, SkullModel>builder();

		builder.put(IcariaSkullBlockTypes.AETERNAE, new AeternaeSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.AETERNAE_SKULL)));
		builder.put(IcariaSkullBlockTypes.ARGAN_HOUND, new ArganHoundSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.ARGAN_HOUND_SKULL)));
		builder.put(IcariaSkullBlockTypes.CAPELLA, new ArganHoundSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.CAPELLA_SKULL)));
		builder.put(IcariaSkullBlockTypes.CATOBLEPAS, new CatoblepasSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.CATOBLEPAS_SKULL)));
		builder.put(IcariaSkullBlockTypes.CERVER, new CerverSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.CERVER_SKULL)));
		builder.put(IcariaSkullBlockTypes.CROCOTTA, new ArganHoundSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.CROCOTTA_SKULL)));
		builder.put(IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, new CypressForestHagSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.CYPRESS_FOREST_HAG_SKULL)));
		builder.put(IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, new DroughtrootForestHagSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.DROUGHTROOT_FOREST_HAG_SKULL)));
		builder.put(IcariaSkullBlockTypes.FIR_FOREST_HAG, new FirForestHagSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.FIR_FOREST_HAG_SKULL)));
		builder.put(IcariaSkullBlockTypes.LAUREL_FOREST_HAG, new LaurelForestHagSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.LAUREL_FOREST_HAG_SKULL)));
		builder.put(IcariaSkullBlockTypes.OLIVE_FOREST_HAG, new OliveForestHagSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.OLIVE_FOREST_HAG_SKULL)));
		builder.put(IcariaSkullBlockTypes.PLANE_FOREST_HAG, new PlaneForestHagSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.PLANE_FOREST_HAG_SKULL)));
		builder.put(IcariaSkullBlockTypes.POPULUS_FOREST_HAG, new PopulusForestHagSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.POPULUS_FOREST_HAG_SKULL)));
		builder.put(IcariaSkullBlockTypes.REVENANT, new RevenantSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.REVENANT_SKULL)));
		builder.put(IcariaSkullBlockTypes.SOW, new SowSkullModel(pEntityModelSet.bakeLayer(IcariaLayerLocations.SOW_SKULL)));

		return builder.build();
	}
}
