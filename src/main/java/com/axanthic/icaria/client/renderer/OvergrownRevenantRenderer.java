package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.OvergrownRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.OvergrownRevenantItemLayer;
import com.axanthic.icaria.client.layer.OvergrownRevenantRaysLayer;
import com.axanthic.icaria.client.model.OvergrownRevenantModel;
import com.axanthic.icaria.common.entity.OvergrownRevenantEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OvergrownRevenantRenderer extends MobRenderer<OvergrownRevenantEntity, OvergrownRevenantModel> {
    public OvergrownRevenantRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new OvergrownRevenantModel(pContext.bakeLayer(IcariaLayerLocations.OVERGROWN_REVENANT_BODY)), 0.5F);
        this.addLayer(new OvergrownRevenantEmissiveLayer(this));
        this.addLayer(new OvergrownRevenantItemLayer(this));
        this.addLayer(new OvergrownRevenantRaysLayer(this));
    }

    @Override
    public void scale(OvergrownRevenantEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        pMatrixStack.scale(0.875F, 0.875F, 0.875F);
    }

    @Override
    public ResourceLocation getTextureLocation(OvergrownRevenantEntity pEntity) {
        return IcariaResourceLocations.OVERGROWN_REVENANT;
    }
}
