package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.NetherPyromancerRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.NetherPyromancerRevenantItemLayer;
import com.axanthic.icaria.client.model.NetherPyromancerRevenantModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.NetherPyromancerRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class NetherPyromancerRevenantRenderer extends MobRenderer<NetherPyromancerRevenantEntity, NetherPyromancerRevenantModel> {
    public NetherPyromancerRevenantRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new NetherPyromancerRevenantModel(pContext.bakeLayer(IcariaLayerLocations.NETHER_PYROMANCER_REVENANT_BODY)), 0.5F);
        this.addLayer(new NetherPyromancerRevenantEmissiveLayer(this));
        this.addLayer(new NetherPyromancerRevenantItemLayer(this));
    }

    @Override
    public void scale(NetherPyromancerRevenantEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        pMatrixStack.scale(0.875F, 0.875F, 0.875F);
    }

    @Override
    public ResourceLocation getTextureLocation(NetherPyromancerRevenantEntity pEntity) {
        return IcariaResourceLocations.NETHER_PYROMANCER_REVENANT;
    }
}
