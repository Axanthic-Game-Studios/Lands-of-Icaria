package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.variant.FeeshVariant;
import com.axanthic.icaria.common.variant.FicheVariant;
import com.axanthic.icaria.common.variant.FisshhVariant;
import com.axanthic.icaria.common.variant.FyshVariant;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataSerializer;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEntityDataSerializers {
	public static final DeferredRegister<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.ENTITY_DATA_SERIALIZERS, IcariaKeys.ID);

	public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<Holder<FeeshVariant>>> FEESH_VARIANT = IcariaEntityDataSerializers.ENTITY_DATA_SERIALIZERS.register("feesh_variant", () -> EntityDataSerializer.forValueType(FeeshVariant.STREAM_CODEC));
	public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<Holder<FicheVariant>>> FICHE_VARIANT = IcariaEntityDataSerializers.ENTITY_DATA_SERIALIZERS.register("fiche_variant", () -> EntityDataSerializer.forValueType(FicheVariant.STREAM_CODEC));
	public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<Holder<FisshhVariant>>> FISSHH_VARIANT = IcariaEntityDataSerializers.ENTITY_DATA_SERIALIZERS.register("fisshh_variant", () -> EntityDataSerializer.forValueType(FisshhVariant.STREAM_CODEC));
	public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<Holder<FyshVariant>>> FYSH_VARIANT = IcariaEntityDataSerializers.ENTITY_DATA_SERIALIZERS.register("fysh_variant", () -> EntityDataSerializer.forValueType(FyshVariant.STREAM_CODEC));
}
