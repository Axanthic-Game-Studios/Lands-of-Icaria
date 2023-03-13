package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.*;
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

@ParametersAreNonnullByDefault

public class IcariaSkullBlockRenderer implements BlockEntityRenderer<IcariaSkullBlockEntity> {
    public Map<IcariaSkullBlockType, SkullModel> map;

    public static final Map<IcariaSkullBlockType, ResourceLocation> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), (pMap) -> {
        pMap.put(IcariaSkullBlockTypes.AETERNAE, new ResourceLocation(IcariaInfo.MODID, "textures/entity/aeternae.png"));
        pMap.put(IcariaSkullBlockTypes.ARGAN_HOUND, new ResourceLocation(IcariaInfo.MODID, "textures/entity/argan_hound.png"));
        pMap.put(IcariaSkullBlockTypes.CATOBLEPAS, new ResourceLocation(IcariaInfo.MODID, "textures/entity/catoblepas.png"));
        pMap.put(IcariaSkullBlockTypes.CERVER, new ResourceLocation(IcariaInfo.MODID, "textures/entity/cerver.png"));
        pMap.put(IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, new ResourceLocation(IcariaInfo.MODID, "textures/entity/cypress_forest_hag.png"));
        pMap.put(IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, new ResourceLocation(IcariaInfo.MODID, "textures/entity/droughtroot_forest_hag.png"));
        pMap.put(IcariaSkullBlockTypes.SOW, new ResourceLocation(IcariaInfo.MODID, "textures/entity/sow.png"));
    });

    public IcariaSkullBlockRenderer(BlockEntityRendererProvider.Context pContext) {
        this.map = createRenderers(pContext.getModelSet());
    }

    @Override
    public void render(IcariaSkullBlockEntity pBlockEntity, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pCombinedLight, int pCombinedOverlay) {
        BlockState blockState = pBlockEntity.getBlockState();
        boolean wall = blockState.getBlock() instanceof IcariaWallSkullBlock;
        Direction direction = wall ? blockState.getValue(IcariaWallSkullBlock.FACING) : null;
        float rotation = wall ? (2 + direction.get2DDataValue()) * 4 : blockState.getValue(SkullBlock.ROTATION);

        renderSkull(direction, 22.5F * rotation, pPoseStack, pBufferSource, pCombinedLight, this.map, blockState.getBlock());
    }

    public static void renderSkull(@Nullable Direction pDirection, float pRotation, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pCombinedLight, Map<IcariaSkullBlockType, SkullModel> pMap, Block pBlock) {
        float offset = ((IcariaAbstractSkullBlock) pBlock).getOffset();

        IcariaSkullBlockType blockType = ((IcariaAbstractSkullBlock) pBlock).getType();
        ResourceLocation resourceLocation = SKIN_BY_TYPE.get(blockType);
        SkullModel skullModel = pMap.get(blockType);

        pPoseStack.pushPose();

        if (pDirection == null) {
            pPoseStack.translate(0.5D, 0.0D, 0.5D);
        } else {
            pPoseStack.translate(0.5F - pDirection.getStepX() * (0.25F + offset), 0.25D, 0.5F - pDirection.getStepZ() * (0.25F + offset));
        }

        pPoseStack.scale(-1.0F, -1.0F, 1.0F);

        VertexConsumer vertexConsumer = pBufferSource.getBuffer(RenderType.entityCutoutNoCullZOffset(resourceLocation));

        skullModel.setupAnim(0.0F, pRotation, 0.0F);
        skullModel.renderToBuffer(pPoseStack, vertexConsumer, pCombinedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        pPoseStack.popPose();
    }

    public static Map<IcariaSkullBlockType, SkullModel> createRenderers(EntityModelSet pSet) {
        ImmutableMap.Builder<IcariaSkullBlockType, SkullModel> builder = ImmutableMap.builder();

        builder.put(IcariaSkullBlockTypes.AETERNAE, new AeternaeSkullModel(pSet.bakeLayer(AeternaeSkullModel.LAYER_LOCATION)));
        builder.put(IcariaSkullBlockTypes.ARGAN_HOUND, new ArganHoundSkullModel(pSet.bakeLayer(ArganHoundSkullModel.LAYER_LOCATION)));
        builder.put(IcariaSkullBlockTypes.CATOBLEPAS, new CatoblepasSkullModel(pSet.bakeLayer(CatoblepasSkullModel.LAYER_LOCATION)));
        builder.put(IcariaSkullBlockTypes.CERVER, new CerverSkullModel(pSet.bakeLayer(CerverSkullModel.LAYER_LOCATION)));
        builder.put(IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, new CypressForestHagSkullModel(pSet.bakeLayer(CypressForestHagSkullModel.LAYER_LOCATION)));
        builder.put(IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, new DroughtrootForestHagSkullModel(pSet.bakeLayer(DroughtrootForestHagSkullModel.LAYER_LOCATION)));
        builder.put(IcariaSkullBlockTypes.SOW, new SowSkullModel(pSet.bakeLayer(SowSkullModel.LAYER_LOCATION)));

        return builder.build();
    }
}
