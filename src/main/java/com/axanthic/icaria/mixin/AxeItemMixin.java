package com.axanthic.icaria.mixin;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@SuppressWarnings("unused")

@Mixin(AxeItem.class)
public interface AxeItemMixin {
	@Accessor("STRIPPABLES")
	static Map<Block, Block> getIcariaStrippables() {
		throw new Error("Mixin did not apply.");
	}

	@Mutable
	@Accessor("STRIPPABLES")
	static void setIcariaStrippables(Map<Block, Block> pMap) {
		throw new Error("Mixin did not apply.");
	}
}
