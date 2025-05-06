package com.axanthic.icaria.common.registry;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAttachmentTypes {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, IcariaIdents.ID);

	public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> LOOT_VASE = IcariaAttachmentTypes.ATTACHMENT_TYPES.register("loot_vase", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build());
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<BlockPos>> LOOT_VASE_BLOCK_POS = IcariaAttachmentTypes.ATTACHMENT_TYPES.register("loot_vase_block_pos", () -> AttachmentType.builder(() -> BlockPos.ZERO).serialize(BlockPos.CODEC).build());
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<BlockState>> LOOT_VASE_BLOCK_STATE = IcariaAttachmentTypes.ATTACHMENT_TYPES.register("loot_vase_block_state", () -> AttachmentType.builder(Blocks.AIR::defaultBlockState).serialize(BlockState.CODEC).build());
}
