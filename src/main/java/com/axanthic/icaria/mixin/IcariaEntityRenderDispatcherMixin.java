package com.axanthic.icaria.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.axanthic.icaria.client.proxy.ClientProxy;
import com.axanthic.icaria.common.util.mixininterfaces.IIcariaEntityMixin;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.entity.Entity;

@Mixin(value = EntityRenderDispatcher.class)
public class IcariaEntityRenderDispatcherMixin {

	@Redirect(method = "Lnet/minecraft/client/renderer/entity/EntityRenderDispatcher;renderFlame(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/entity/Entity;)V", 
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/Material;sprite()Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;"))
	private TextureAtlasSprite icaria$renderFlame0(Material material, PoseStack pPosestack, MultiBufferSource pBufferSource, Entity entity) {
		return ((IIcariaEntityMixin)(Object)entity).icaria$getGreekFireDuration( ) > 0 ? ClientProxy.GREEK_FIRE_0.sprite( ) : material.sprite();
	}
	
	@Redirect(method = "Lnet/minecraft/client/renderer/entity/EntityRenderDispatcher;renderFlame(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/entity/Entity;)V", 
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/Material;sprite()Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;", ordinal = 1))
	private TextureAtlasSprite icaria$renderFlame1(Material material, PoseStack pPosestack, MultiBufferSource pBufferSource, Entity entity) {
		return ((IIcariaEntityMixin)(Object)entity).icaria$getGreekFireDuration( ) > 0 ? ClientProxy.GREEK_FIRE_1.sprite( ) : material.sprite();
	}
}
