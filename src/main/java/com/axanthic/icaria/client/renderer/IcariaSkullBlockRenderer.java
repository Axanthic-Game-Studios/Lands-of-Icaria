package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.ArganHoundSkullModel;
import com.axanthic.icaria.client.model.CatoblepasSkullModel;
import com.axanthic.icaria.client.model.CerverSkullModel;
import com.axanthic.icaria.client.model.SowSkullModel;
import com.axanthic.icaria.common.block.IcariaAbstractSkullBlock;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;
import com.axanthic.icaria.common.util.IcariaSkullBlockTypes;
import com.axanthic.icaria.common.block.IcariaWallSkullBlock;
import com.axanthic.icaria.common.entity.IcariaSkullBlockEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

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
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSkullBlockRenderer implements BlockEntityRenderer<IcariaSkullBlockEntity> {
    public Map<IcariaSkullBlockType, SkullModel> modelByType;

    public static Map<IcariaSkullBlockType, ResourceLocation> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), (map) -> {
        map.put(IcariaSkullBlockTypes.ARGAN_HOUND, new ResourceLocation(IcariaInfo.MODID, "textures/entity/argan_hound.png"));
        map.put(IcariaSkullBlockTypes.CATOBLEPAS, new ResourceLocation(IcariaInfo.MODID, "textures/entity/catoblepas.png"));
        map.put(IcariaSkullBlockTypes.CERVER, new ResourceLocation(IcariaInfo.MODID, "textures/entity/cerver.png"));
        map.put(IcariaSkullBlockTypes.SOW, new ResourceLocation(IcariaInfo.MODID, "textures/entity/sow.png"));
    });

    public IcariaSkullBlockRenderer(BlockEntityRendererProvider.Context pContext) {
        modelByType = createSkullRenderers(pContext.getModelSet());
    }

    @Override
    public void render(IcariaSkullBlockEntity pBlockEntity, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pCombinedLight, int pCombinedOverlay) {
        BlockState blockState = pBlockEntity.getBlockState();
        boolean wall = blockState.getBlock() instanceof IcariaWallSkullBlock;
        Direction direction = wall ? blockState.getValue(IcariaWallSkullBlock.FACING) : null;
        float rotation = wall ? (float) (2 + direction.get2DDataValue()) * 4 : blockState.getValue(SkullBlock.ROTATION);

        renderSkull(direction, 22.5F * rotation, pPoseStack, pBufferSource, pCombinedLight, modelByType, blockState.getBlock());
    }

    public static void renderSkull(@Nullable Direction pDirection, float pRotation, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pCombinedLight, Map<IcariaSkullBlockType, SkullModel> pMap, Block pBlock) {
        pPoseStack.pushPose();

        float offset = ((IcariaAbstractSkullBlock)pBlock).getOffset();
        IcariaSkullBlockType blockType = ((IcariaAbstractSkullBlock)pBlock).getType();
        ResourceLocation resourceLocation = SKIN_BY_TYPE.get(blockType);
        SkullModel skullModel = pMap.get(blockType);

        if (pDirection == null) {
            pPoseStack.translate(0.5D, 0.0D, 0.5D);
        } else {
            pPoseStack.translate(0.5F - (float) pDirection.getStepX() * (0.25F + offset), 0.25D, 0.5F - (float) pDirection.getStepZ() * (0.25F + offset));
        }

        pPoseStack.scale(-1.0F, -1.0F, 1.0F);

        VertexConsumer vertexConsumer = pBufferSource.getBuffer(RenderType.entityCutoutNoCullZOffset(resourceLocation));

        skullModel.setupAnim(0.0F, pRotation, 0.0F);
        skullModel.renderToBuffer(pPoseStack, vertexConsumer, pCombinedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        pPoseStack.popPose();
    }

    public static Map<IcariaSkullBlockType, SkullModel> createSkullRenderers(EntityModelSet pSet) {
        ImmutableMap.Builder<IcariaSkullBlockType, SkullModel> builder = ImmutableMap.builder();

        builder.put(IcariaSkullBlockTypes.ARGAN_HOUND, new ArganHoundSkullModel(pSet.bakeLayer(ArganHoundSkullModel.LAYER_LOCATION)));
        builder.put(IcariaSkullBlockTypes.CATOBLEPAS, new CatoblepasSkullModel(pSet.bakeLayer(CatoblepasSkullModel.LAYER_LOCATION)));
        builder.put(IcariaSkullBlockTypes.CERVER, new CerverSkullModel(pSet.bakeLayer(CerverSkullModel.LAYER_LOCATION)));
        builder.put(IcariaSkullBlockTypes.SOW, new SowSkullModel(pSet.bakeLayer(SowSkullModel.LAYER_LOCATION)));

        return builder.build();
    }
}
