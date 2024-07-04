package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.*;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.block.IcariaAbstractSkullBlock;
import com.axanthic.icaria.common.block.IcariaWallSkullBlock;
import com.axanthic.icaria.common.block.entity.IcariaSkullBlockEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;
import com.axanthic.icaria.common.util.IcariaSkullBlockTypes;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import com.mojang.blaze3d.vertex.PoseStack;

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

import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSkullBlockRenderer implements BlockEntityRenderer<IcariaSkullBlockEntity> {
    public Map<IcariaSkullBlockType, SkullModel> map;

    public static final Map<IcariaSkullBlockType, ResourceLocation> RL_BY_TYPE = Util.make(
        Maps.newHashMap(), (pMap) -> {
            pMap.put(IcariaSkullBlockTypes.AETERNAE, IcariaResourceLocations.AETERNAE);
            pMap.put(IcariaSkullBlockTypes.ARGAN_HOUND, IcariaResourceLocations.ARGAN_HOUND);
            pMap.put(IcariaSkullBlockTypes.CATOBLEPAS, IcariaResourceLocations.CATOBLEPAS);
            pMap.put(IcariaSkullBlockTypes.CERVER, IcariaResourceLocations.CERVER);
            pMap.put(IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, IcariaResourceLocations.CYPRESS_FOREST_HAG);
            pMap.put(IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, IcariaResourceLocations.DROUGHTROOT_FOREST_HAG);
            pMap.put(IcariaSkullBlockTypes.FIR_FOREST_HAG, IcariaResourceLocations.FIR_FOREST_HAG);
            pMap.put(IcariaSkullBlockTypes.LAUREL_FOREST_HAG, IcariaResourceLocations.LAUREL_FOREST_HAG);
            pMap.put(IcariaSkullBlockTypes.OLIVE_FOREST_HAG, IcariaResourceLocations.OLIVE_FOREST_HAG);
            pMap.put(IcariaSkullBlockTypes.PLANE_FOREST_HAG, IcariaResourceLocations.PLANE_FOREST_HAG);
            pMap.put(IcariaSkullBlockTypes.POPULUS_FOREST_HAG, IcariaResourceLocations.POPULUS_FOREST_HAG);
            pMap.put(IcariaSkullBlockTypes.REVENANT, IcariaResourceLocations.CAPTAIN_REVENANT);
            pMap.put(IcariaSkullBlockTypes.SOW, IcariaResourceLocations.SOW);
        }
    );

    public IcariaSkullBlockRenderer(BlockEntityRendererProvider.Context pContext) {
        this.map = IcariaSkullBlockRenderer.createRenderers(pContext.getModelSet());
    }

    @Override
    public void render(IcariaSkullBlockEntity pBlockEntity, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pCombinedLight, int pCombinedOverlay) {
        var blockState = pBlockEntity.getBlockState();
        boolean wall = blockState.getBlock() instanceof IcariaWallSkullBlock;
        var direction = wall ? blockState.getValue(BlockStateProperties.HORIZONTAL_FACING) : null;
        float rotation = wall ? (direction.get2DDataValue() + 2.0F) * 4.0F : blockState.getValue(BlockStateProperties.ROTATION_16);

        IcariaSkullBlockRenderer.renderSkull(direction, rotation * 22.5F, pPoseStack, pBufferSource, pCombinedLight, this.map, blockState.getBlock());
    }

    public static void renderSkull(@Nullable Direction pDirection, float pRotation, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pCombinedLight, Map<IcariaSkullBlockType, SkullModel> pMap, Block pBlock) {
        if (pBlock instanceof IcariaAbstractSkullBlock icariaAbstractSkullBlock) {
            float offset = icariaAbstractSkullBlock.getOffset();

            var block = icariaAbstractSkullBlock.getType();
            var model = pMap.get(block);
            var resourceLocation = IcariaSkullBlockRenderer.RL_BY_TYPE.get(block);
            var vertexConsumer = pBufferSource.getBuffer(RenderType.entityCutoutNoCullZOffset(resourceLocation));

            pPoseStack.pushPose();

            if (pDirection == null) {
                pPoseStack.translate(0.5D, 0.0D, 0.5D);
            } else {
                pPoseStack.translate(0.5D - pDirection.getStepX() * (0.25D + offset), 0.25D, 0.5D - pDirection.getStepZ() * (0.25D + offset));
            }

            pPoseStack.scale(-1.0F, -1.0F, 1.0F);

            model.setupAnim(0.0F, pRotation, 0.0F);
            model.renderToBuffer(pPoseStack, vertexConsumer, pCombinedLight, OverlayTexture.NO_OVERLAY);

            pPoseStack.popPose();
        }
    }

    public static Map<IcariaSkullBlockType, SkullModel> createRenderers(EntityModelSet pSet) {
        ImmutableMap.Builder<IcariaSkullBlockType, SkullModel> builder = ImmutableMap.builder();

        builder.put(IcariaSkullBlockTypes.AETERNAE, new AeternaeSkullModel(pSet.bakeLayer(IcariaLayerLocations.AETERNAE_SKULL)));
        builder.put(IcariaSkullBlockTypes.ARGAN_HOUND, new ArganHoundSkullModel(pSet.bakeLayer(IcariaLayerLocations.ARGAN_HOUND_SKULL)));
        builder.put(IcariaSkullBlockTypes.CATOBLEPAS, new CatoblepasSkullModel(pSet.bakeLayer(IcariaLayerLocations.CATOBLEPAS_SKULL)));
        builder.put(IcariaSkullBlockTypes.CERVER, new CerverSkullModel(pSet.bakeLayer(IcariaLayerLocations.CERVER_SKULL)));
        builder.put(IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, new CypressForestHagSkullModel(pSet.bakeLayer(IcariaLayerLocations.CYPRESS_FOREST_HAG_SKULL)));
        builder.put(IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, new DroughtrootForestHagSkullModel(pSet.bakeLayer(IcariaLayerLocations.DROUGHTROOT_FOREST_HAG_SKULL)));
        builder.put(IcariaSkullBlockTypes.FIR_FOREST_HAG, new FirForestHagSkullModel(pSet.bakeLayer(IcariaLayerLocations.FIR_FOREST_HAG_SKULL)));
        builder.put(IcariaSkullBlockTypes.LAUREL_FOREST_HAG, new LaurelForestHagSkullModel(pSet.bakeLayer(IcariaLayerLocations.LAUREL_FOREST_HAG_SKULL)));
        builder.put(IcariaSkullBlockTypes.OLIVE_FOREST_HAG, new OliveForestHagSkullModel(pSet.bakeLayer(IcariaLayerLocations.OLIVE_FOREST_HAG_SKULL)));
        builder.put(IcariaSkullBlockTypes.PLANE_FOREST_HAG, new PlaneForestHagSkullModel(pSet.bakeLayer(IcariaLayerLocations.PLANE_FOREST_HAG_SKULL)));
        builder.put(IcariaSkullBlockTypes.POPULUS_FOREST_HAG, new PopulusForestHagSkullModel(pSet.bakeLayer(IcariaLayerLocations.POPULUS_FOREST_HAG_SKULL)));
        builder.put(IcariaSkullBlockTypes.REVENANT, new RevenantSkullModel(pSet.bakeLayer(IcariaLayerLocations.REVENANT_SKULL)));
        builder.put(IcariaSkullBlockTypes.SOW, new SowSkullModel(pSet.bakeLayer(IcariaLayerLocations.SOW_SKULL)));

        return builder.build();
    }
}
