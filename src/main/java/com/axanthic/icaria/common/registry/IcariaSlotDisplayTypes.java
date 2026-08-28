package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.display.GrinderFuelSlotDisplay;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.display.SlotDisplay;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSlotDisplayTypes {
	public static final DeferredRegister<SlotDisplay.Type<?>> SLOT_DISPLAY_TYPES = DeferredRegister.create(Registries.SLOT_DISPLAY, IcariaIdents.ID);

	public static final DeferredHolder<SlotDisplay.Type<?>, SlotDisplay.Type<GrinderFuelSlotDisplay>> GRINDER_FUEL = IcariaSlotDisplayTypes.SLOT_DISPLAY_TYPES.register("grinder_fuel", () -> new SlotDisplay.Type<>(GrinderFuelSlotDisplay.MAP_CODEC, GrinderFuelSlotDisplay.STREAM_CODEC));
}
