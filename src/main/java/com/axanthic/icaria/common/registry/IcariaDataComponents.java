package com.axanthic.icaria.common.registry;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDataComponents {
	public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, IcariaIdents.ID);

	public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> COLOR = IcariaDataComponents.DATA_COMPONENT_TYPES.register("color", () -> DataComponentType.<Integer>builder().persistent(ExtraCodecs.NON_NEGATIVE_INT).networkSynchronized(ByteBufCodecs.VAR_INT).cacheEncoding().build());
	public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> LABEL = IcariaDataComponents.DATA_COMPONENT_TYPES.register("label", () -> DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).cacheEncoding().build());
	public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> STYLE = IcariaDataComponents.DATA_COMPONENT_TYPES.register("style", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).cacheEncoding().build());
}
