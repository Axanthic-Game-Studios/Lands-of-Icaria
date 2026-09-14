package com.axanthic.icaria.client.modifier;

import com.axanthic.icaria.common.registry.IcariaAttachmentTypes;
import com.axanthic.icaria.common.registry.IcariaContextKeys;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.ClientAvatarEntity;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;

import net.neoforged.neoforge.client.renderstate.AvatarRenderStateModifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LootVaseAvatarRenderStateModifier extends AvatarRenderStateModifier {

	@Override
	public <T extends Avatar & ClientAvatarEntity> void accept(T pAvatar, AvatarRenderState pAvatarRenderState) {
		pAvatarRenderState.setRenderData(IcariaContextKeys.LOOT_VASE, pAvatar.getData(IcariaAttachmentTypes.LOOT_VASE));
		pAvatarRenderState.setRenderData(IcariaContextKeys.LOOT_VASE_BLOCK_MODEL_RENDER_STATE, new BlockModelRenderState());
		Minecraft.getInstance().getBlockModelResolver().update(pAvatarRenderState.getRenderDataOrThrow(IcariaContextKeys.LOOT_VASE_BLOCK_MODEL_RENDER_STATE), pAvatar.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE), BlockDisplayContext.create());
	}
}
