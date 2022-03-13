package com.axanthic.icaria.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Mixin(HoeItem.class)
public interface HoeItemAccess {
	@Accessor("TILLABLES")
	static Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> getIcariaTillables() {
		throw new Error("Mixin did not apply.");
	}

	@Mutable
	@Accessor("TILLABLES")
	static void setIcariaTillables(Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> newMap) {
		throw new Error("Mixin did not apply.");
	}
}
