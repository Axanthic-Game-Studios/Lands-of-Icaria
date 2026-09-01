package com.axanthic.icaria.common.registry;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAttachmentTypes {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, IcariaKeys.ID);

	public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> BARREL = IcariaAttachmentTypes.ATTACHMENT_TYPES.register("barrel", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL.fieldOf("barrel")).build());
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<BlockState>> BARREL_BLOCK_STATE = IcariaAttachmentTypes.ATTACHMENT_TYPES.register("barrel_block_state", () -> AttachmentType.builder(Blocks.AIR::defaultBlockState).serialize(BlockState.CODEC.fieldOf("barrel_block_state")).build());
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> LOOT_VASE = IcariaAttachmentTypes.ATTACHMENT_TYPES.register("loot_vase", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL.fieldOf("loot_vase")).build());
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<BlockState>> LOOT_VASE_BLOCK_STATE = IcariaAttachmentTypes.ATTACHMENT_TYPES.register("loot_vase_block_state", () -> AttachmentType.builder(Blocks.AIR::defaultBlockState).serialize(BlockState.CODEC.fieldOf("loot_vase_block_state")).build());
}
