package com.axanthic.icaria.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.axanthic.icaria.client.proxy.ClientProxy;
import com.axanthic.icaria.common.util.mixininterfaces.IIcariaEntityMixin;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.entity.Entity;

@Mixin(value = ScreenEffectRenderer.class)
public class IcariaScreenEffectRendererMixin {

	@Redirect(method = "Lnet/minecraft/client/renderer/ScreenEffectRenderer;renderFire(Lnet/minecraft/client/Minecraft;Lcom/mojang/blaze3d/vertex/PoseStack;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/Material;sprite()Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;"))
	private static TextureAtlasSprite icaria$renderFire(Material material, Minecraft pMinecraft, PoseStack pPosestack) {
		return pMinecraft.getInstance( ).player instanceof Entity entity && ((IIcariaEntityMixin)(Object)(entity)).icaria$getGreekFireDuration( ) > 0 ? ClientProxy.GREEK_FIRE_1.sprite( ) : material.sprite();
	}
	
}
