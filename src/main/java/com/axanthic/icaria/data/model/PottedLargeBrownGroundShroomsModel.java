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

public class PottedLargeBrownGroundShroomsModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(5.0000F, 0.0000F, 5.0000F).to(6.0000F, 6.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0000F, 10.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 6.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0000F, 5.0000F, 6.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(5.0000F, 5.0000F, 6.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(10.0000F, 0.0000F, 5.0000F).to(11.0000F, 6.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 6.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0000F, 10.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(10.0000F, 5.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(10.0000F, 5.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.0000F, 5.0000F).to(10.0000F, 6.0000F, 6.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 5.0000F, 10.0000F, 6.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.0000F, 10.0000F).to(10.0000F, 6.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0000F, 5.0000F, 10.0000F, 6.0000F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.0000F, 6.0000F).to(10.0000F, 4.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 6.0000F, 10.0000F, 10.0000F).texture(IcariaTextureSlots.DIRT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0000F, 12.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.5000F, 9.0000F, 6.5000F).to(11.5000F, 10.0000F, 11.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 22.5000F, 0.0000F).origin(9.0000F, 9.5000F, 9.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 1.0000F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 1.0000F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 1.0000F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 1.0000F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 5.0000F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 5.0000F).texture(IcariaTextureSlots.SHROOM)))
			.element(elementBuilder -> elementBuilder.from(8.5000F, 4.0000F, 8.5000F).to(9.5000F, 9.0000F, 9.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 22.5000F, 0.0000F).origin(9.0000F, 6.5000F, 9.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 5.0000F).texture(IcariaTextureSlots.STEM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 2.0000F, 5.0000F).texture(IcariaTextureSlots.STEM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 3.0000F, 5.0000F).texture(IcariaTextureSlots.STEM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 4.0000F, 5.0000F).texture(IcariaTextureSlots.STEM)))
			.element(elementBuilder -> elementBuilder.from(5.5000F, 7.0000F, 5.5000F).to(8.5000F, 8.0000F, 8.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -22.5000F, 0.0000F).origin(7.0000F, 6.5000F, 7.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 1.0000F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 1.0000F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 1.0000F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 1.0000F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 3.0000F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 3.0000F).texture(IcariaTextureSlots.SHROOM)))
			.element(elementBuilder -> elementBuilder.from(6.5000F, 4.0000F, 6.5000F).to(7.5000F, 7.0000F, 7.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -22.5000F, 0.0000F).origin(7.0000F, 6.5000F, 7.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 3.0000F).texture(IcariaTextureSlots.STEM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 2.0000F, 3.0000F).texture(IcariaTextureSlots.STEM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 3.0000F, 3.0000F).texture(IcariaTextureSlots.STEM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 4.0000F, 3.0000F).texture(IcariaTextureSlots.STEM)))
			.build();
	}
}
