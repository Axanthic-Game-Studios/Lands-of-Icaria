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

public class FlowerPotCountertopModel {

	public static ExtendedModelTemplate template0() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 3.0000F, 5.0000F).to(3.0000F, 4.0000F, 9.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 1.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R90))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R270))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R180)))
			.element(elementBuilder -> elementBuilder.from(2.2500F, 3.3750F, 8.0000F).to(3.2500F, 3.6250F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0000F, 5.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.CHERT_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.CHERT_BLOCK).rotation(Quadrant.R270))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CHERT_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.CHERT_BLOCK).rotation(Quadrant.R90))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.CHERT_BLOCK).rotation(Quadrant.R180))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.CHERT_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 3.0000F, 5.0000F).to(10.0000F, 6.0000F, 6.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 5.0000F, 10.0000F, 6.0000F).texture(IcariaTextureSlots.FLOWER_POT)))
			.element(elementBuilder -> elementBuilder.from(10.0000F, 3.0000F, 5.0000F).to(11.0000F, 6.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 6.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0000F, 10.0000F, 11.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(10.0000F, 5.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 3.0000F, 10.0000F).to(10.0000F, 6.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT)))
			.element(elementBuilder -> elementBuilder.from(5.0000F, 3.0000F, 5.0000F).to(6.0000F, 6.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0000F, 10.0000F, 11.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 6.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 13.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0000F, 5.0000F, 6.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 4.0000F, 6.0000F).to(10.0000F, 4.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 6.0000F, 10.0000F, 10.0000F).texture(IcariaTextureSlots.DIRT)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 3.0000F).to(16.0000F, 3.0000F, 4.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 13.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 13.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 13.0000F, 2.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 4.0000F).to(16.0000F, 3.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 12.0000F, 11.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 11.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 8.0000F, 16.0000F, 11.0000F).texture(IcariaTextureSlots.PLANKS))
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

	public static ExtendedModelTemplate template1() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 3.0000F, 5.0000F).to(3.0000F, 4.0000F, 9.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.X).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 1.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R90))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R270))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TRAPDOOR))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TRAPDOOR).rotation(Quadrant.R180)))
			.element(elementBuilder -> elementBuilder.from(2.2500F, 3.3750F, 8.0000F).to(3.2500F, 3.6250F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0000F, 5.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.CHERT_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.CHERT_BLOCK).rotation(Quadrant.R270))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CHERT_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.CHERT_BLOCK).rotation(Quadrant.R90))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.CHERT_BLOCK).rotation(Quadrant.R180))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.CHERT_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 3.0000F).to(16.0000F, 3.0000F, 4.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 13.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 13.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 13.0000F, 2.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 4.0000F).to(16.0000F, 3.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 12.0000F, 11.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 11.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 8.0000F, 16.0000F, 11.0000F).texture(IcariaTextureSlots.PLANKS))
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
