package com.axanthic.icaria.mixin;

import com.axanthic.icaria.client.renderer.IcariaSkullBlockRenderer;
import com.axanthic.icaria.common.item.IcariaSkullItem;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")

@Mixin(CustomHeadLayer.class)
public class CustomHeadLayerMixin<T extends LivingEntity, M extends EntityModel<T> & HeadedModel> {
    private EntityModelSet set;

    private Map<IcariaSkullBlockType, SkullModel> map;

    @Inject(at = @At(value = "TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/RenderLayerParent;Lnet/minecraft/client/model/geom/EntityModelSet;FFFLnet/minecraft/client/renderer/ItemInHandRenderer;)V")
    private void initMixin(RenderLayerParent<T, M> pRenderer, EntityModelSet pModelSet, float pScaleX, float pScaleY, float pScaleZ, ItemInHandRenderer pItemInHandRenderer, CallbackInfo pCallbackInfo) {
        this.set = pModelSet;
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/layers/CustomHeadLayer;translateToHead(Lcom/mojang/blaze3d/vertex/PoseStack;Z)V", shift = At.Shift.BEFORE), method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V", cancellable = true)
    private void renderHeadMixin(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, @Nonnull T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch, CallbackInfo pCallbackInfo) {
        if (this.map == null) {
            this.map = IcariaSkullBlockRenderer.createRenderers(this.set);
        }

        if (pLivingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof IcariaSkullItem skullItem) {
            pMatrixStack.scale(1.1875F, -1.1875F, -1.1875F);
            pMatrixStack.translate(-0.5D, 0.0D, -0.5D);
            IcariaSkullBlockRenderer.renderSkull(null, 180.0F, pMatrixStack, pBuffer, pPackedLight, this.map, skullItem.getBlock());
            pMatrixStack.popPose();
            pCallbackInfo.cancel();
        }
    }
}
