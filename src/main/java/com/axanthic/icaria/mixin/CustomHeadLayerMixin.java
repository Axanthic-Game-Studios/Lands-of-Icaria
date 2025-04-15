package com.axanthic.icaria.mixin;

import com.axanthic.icaria.client.renderer.IcariaSkullBlockRenderer;
import com.axanthic.icaria.common.item.IcariaSkullItem;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@Mixin(CustomHeadLayer.class)
public class CustomHeadLayerMixin<S extends LivingEntityRenderState, M extends EntityModel<S> & HeadedModel> {
	private EntityModelSet entityModelSet;

	@Inject(at = @At(value = "TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/RenderLayerParent;Lnet/minecraft/client/model/geom/EntityModelSet;Lnet/minecraft/client/renderer/entity/ItemRenderer;)V")
	private void initMixin(RenderLayerParent<S, M> pRenderLayerParent, EntityModelSet pEntityModelSet, ItemRenderer pItemRenderer, CallbackInfo pCallbackInfo) {
		this.entityModelSet = pEntityModelSet;
	}

	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/layers/CustomHeadLayer;translateToHead(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/entity/layers/CustomHeadLayer$Transforms;)V", shift = At.Shift.BEFORE), method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;FF)V", cancellable = true)
	private void renderHeadMixin(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, S pRenderState, float pYRot, float pXRot, CallbackInfo pCallbackInfo) {
		if (pRenderState.headItem.getItem() instanceof IcariaSkullItem icariaSkullItem) {
			pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
			pPoseStack.scale(1.1875F, 1.1875F, 1.1875F);
			pPoseStack.translate(-0.5D, 0.0D, -0.5D);
			IcariaSkullBlockRenderer.renderSkull(icariaSkullItem.getBlock(), null, IcariaSkullBlockRenderer.createRenderers(this.entityModelSet), pMultiBufferSource, pPoseStack, 180.0F, pPackedLight);
			pPoseStack.popPose();
			pCallbackInfo.cancel();
		}
	}
}
