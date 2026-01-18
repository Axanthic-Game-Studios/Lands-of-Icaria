package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import com.mojang.math.Quadrant;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChimneyBrickCrownModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 8.0000F, 0.0000F).to(16.0000F, 12.0000F, 3.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 4.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(16.0000F, 4.0000F, 0.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 3.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS).rotation(Quadrant.R180)))
			.element(elementBuilder -> elementBuilder.from(13.0000F, 8.0000F, 3.0000F).to(16.0000F, 12.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 4.0000F, 13.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 4.0000F, 3.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS).rotation(Quadrant.R270)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 8.0000F, 13.0000F).to(16.0000F, 12.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(16.0000F, 4.0000F, 0.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 3.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 4.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 8.0000F, 3.0000F).to(3.0000F, 12.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 4.0000F, 3.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 4.0000F, 13.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 8.0000F, 3.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.CHIMNEY).rotation(Quadrant.R180)))
			.element(elementBuilder -> elementBuilder.from(13.0000F, 0.0000F, 3.0000F).to(16.0000F, 8.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 8.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 12.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.CHIMNEY).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 13.0000F).to(16.0000F, 8.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.CHIMNEY)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 3.0000F).to(3.0000F, 8.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 8.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 12.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.CHIMNEY).rotation(Quadrant.R270)))
			.build();
	}
}
