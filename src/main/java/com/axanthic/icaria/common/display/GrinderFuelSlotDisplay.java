package com.axanthic.icaria.common.display;

import com.axanthic.icaria.common.registry.IcariaDataMapTypes;
import com.axanthic.icaria.common.registry.IcariaSlotDisplayTypes;

import com.mojang.serialization.MapCodec;

import java.util.stream.Stream;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.display.DisplayContentsFactory;
import net.minecraft.world.item.crafting.display.SlotDisplay;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record GrinderFuelSlotDisplay() implements SlotDisplay {
	public static final GrinderFuelSlotDisplay INSTANCE = new GrinderFuelSlotDisplay();
	public static final MapCodec<GrinderFuelSlotDisplay> MAP_CODEC = MapCodec.unit(GrinderFuelSlotDisplay.INSTANCE);
	public static final StreamCodec<RegistryFriendlyByteBuf, GrinderFuelSlotDisplay> STREAM_CODEC = StreamCodec.unit(GrinderFuelSlotDisplay.INSTANCE);

	@Override
	public SlotDisplay.Type<? extends SlotDisplay> type() {
		return IcariaSlotDisplayTypes.GRINDER_FUEL.get();
	}

	@Override
	public <T> Stream<T> resolve(ContextMap pContextMap, DisplayContentsFactory<T> pDisplayContentsFactory) {
		if (pDisplayContentsFactory instanceof DisplayContentsFactory.ForStacks<T> displayContentsFactory) {
			return BuiltInRegistries.ITEM.listElements().filter(reference -> reference.getData(IcariaDataMapTypes.GRINDER_FUELS) != null).map(reference -> displayContentsFactory.forStack(new ItemStack(reference)));
		} else {
			return Stream.empty();
		}
	}
}
