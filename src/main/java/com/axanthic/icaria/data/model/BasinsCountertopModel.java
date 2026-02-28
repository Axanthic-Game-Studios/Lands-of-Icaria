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

public class BasinsCountertopModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(7.0000F, 3.0000F, 11.5000F).to(13.0000F, 3.5000F, 12.5000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 1.0000F, 0.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R90))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 1.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 6.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R90))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 6.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 3.0000F, 11.0000F).to(7.0000F, 3.5000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 1.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 0.0000F, 1.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 2.0000F, 1.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 1.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(5.0000F, 3.0000F, 11.0000F).to(6.0000F, 3.5000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 15.0000F, 2.0000F, 16.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 2.0000F, 16.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 2.0000F, 16.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 1.0000F, 5.0000F).to(7.0000F, 2.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 5.0000F).texture(IcariaTextureSlots.LEAVES)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 3.0000F).to(16.0000F, 3.0000F, 4.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 13.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 13.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 13.0000F, 2.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(14.0000F, 1.0000F, 4.0000F).to(16.0000F, 3.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 12.0000F, 10.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 8.0000F, 16.0000F, 10.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 13.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 12.0000F, 2.0000F).texture(IcariaTextureSlots.STRIPPED_LOG).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 1.0000F, 4.0000F).to(14.0000F, 3.0000F, 5.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 13.0000F, 14.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 1.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(7.0000F, 1.0000F, 5.0000F).to(9.0000F, 3.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(10.0000F, 1.0000F, 12.0000F, 6.0000F).texture(IcariaTextureSlots.STRIPPED_LOG).rotation(Quadrant.R90))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(11.0000F, 10.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG).rotation(Quadrant.R90))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 7.0000F, 6.0000F, 9.0000F).texture(IcariaTextureSlots.STRIPPED_LOG).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 1.0000F, 10.0000F).to(14.0000F, 3.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 13.0000F, 14.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 8.0000F, 14.0000F, 10.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 2.0000F, 12.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 1.0000F, 4.0000F).to(2.0000F, 3.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 13.0000F, 12.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 2.0000F, 10.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 8.0000F, 16.0000F, 10.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 4.0000F).to(16.0000F, 1.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 10.0000F, 12.0000F, 11.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 10.0000F, 16.0000F, 11.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 10.0000F, 16.0000F, 11.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG).rotation(Quadrant.R90))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG).rotation(Quadrant.R270)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 3.0000F, 15.0000F).to(16.0000F, 6.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 10.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 10.0000F, 15.0000F, 13.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 10.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 10.0000F, 2.0000F, 13.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 11.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.LOG)))
			.build();
	}
}
