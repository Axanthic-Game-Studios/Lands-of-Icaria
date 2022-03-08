package com.axanthic.icaria.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(FireBlock.class)
public interface FireBlockAccess {
	@Invoker("setFlammable")
	void accessableFlammable(Block block, int flameOdds, int burnOdds);
}
