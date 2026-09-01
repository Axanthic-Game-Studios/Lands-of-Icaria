package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CardonCactusInventoryModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(4.0000F, 0.0000F, 4.0000F).to(12.0000F, 12.0000F, 12.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.SIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.SIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 12.0000F, 12.0000F).texture(IcariaTextureSlots.SIDE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 12.0000F, 12.0000F).texture(IcariaTextureSlots.BOTTOM)))
			.build();
	}
}
