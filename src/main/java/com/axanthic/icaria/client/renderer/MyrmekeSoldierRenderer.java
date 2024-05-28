package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.MyrmekeSoldierEmissiveLayer;
import com.axanthic.icaria.client.model.MyrmekeSoldierModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeSoldierRenderer extends MobRenderer<MyrmekeSoldierEntity, MyrmekeSoldierModel> {
    public MyrmekeSoldierRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MyrmekeSoldierModel(pContext.bakeLayer(IcariaLayerLocations.MYRMEKE_SOLDIER)), 0.75F);
        this.addLayer(new MyrmekeSoldierEmissiveLayer(this));
    }

    @Override
    public void render(MyrmekeSoldierEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowStrength = pEntity.getShadowStrength();
    }

    @Override
    public ResourceLocation getTextureLocation(MyrmekeSoldierEntity pEntity) {
        return IcariaResourceLocations.MYRMEKE_SOLDIER;
    }
}
