package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.math.Quadrant;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChimneySlabModel {

	public static ExtendedModelTemplate bottom() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 8.0000F, 3.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.ALL).rotation(Quadrant.R180)))
			.element(elementBuilder -> elementBuilder.from(13.0000F, 0.0000F, 3.0000F).to(16.0000F, 8.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 8.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 3.0000F).texture(IcariaTextureSlots.ALL).rotation(Quadrant.R90))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 12.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.ALL).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 13.0000F).to(16.0000F, 8.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.ALL)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 3.0000F).to(3.0000F, 8.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 8.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 3.0000F).texture(IcariaTextureSlots.ALL).rotation(Quadrant.R90))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 12.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.ALL).rotation(Quadrant.R270)))
			.build();
	}

	public static ExtendedModelTemplate top() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 8.0000F, 0.0000F).to(16.0000F, 16.0000F, 3.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 0.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(16.0000F, 0.0000F, 0.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.ALL).rotation(Quadrant.R180)))
			.element(elementBuilder -> elementBuilder.from(13.0000F, 8.0000F, 3.0000F).to(16.0000F, 16.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 0.0000F, 3.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 3.0000F).texture(IcariaTextureSlots.ALL).rotation(Quadrant.R90))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 12.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.ALL).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 8.0000F, 13.0000F).to(16.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(16.0000F, 0.0000F, 0.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 0.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.ALL)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 8.0000F, 3.0000F).to(3.0000F, 16.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 0.0000F, 3.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 8.0000F).texture(IcariaTextureSlots.ALL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 3.0000F).texture(IcariaTextureSlots.ALL).rotation(Quadrant.R90))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 12.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.ALL).rotation(Quadrant.R270)))
			.build();
	}
}
