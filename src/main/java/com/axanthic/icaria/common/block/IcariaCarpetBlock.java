package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.properties.Carpet;

import net.minecraft.world.level.block.CarpetBlock;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCarpetBlock extends CarpetBlock {
	public Carpet carpet;

	public IcariaCarpetBlock(Carpet pCarpet, Properties pProperties) {
		super(pProperties);
		this.carpet = pCarpet;
	}

	public Carpet getCarpet() {
		return this.carpet;
	}
}
