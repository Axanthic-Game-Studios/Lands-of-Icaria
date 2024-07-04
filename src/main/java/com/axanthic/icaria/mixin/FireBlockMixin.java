package com.axanthic.icaria.mixin;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FireBlock;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@Mixin(FireBlock.class)
public interface FireBlockMixin {

	@Invoker("setFlammable")
	void setIcariaFlammables(Block pBlock, int pEncouragement, int pFlammability);
}
