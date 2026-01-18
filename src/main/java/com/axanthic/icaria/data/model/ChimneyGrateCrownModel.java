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

public class ChimneyGrateCrownModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 11.0000F, 0.0000F).to(16.0000F, 12.0000F, 3.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 1.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK).rotation(Quadrant.R180))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK).rotation(Quadrant.R90))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK).rotation(Quadrant.R270))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 16.0000F, 0.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(13.0000F, 11.0000F, 3.0000F).to(16.0000F, 12.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(-1.0000F, 0.0000F, 1.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(15.0000F, 13.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK).rotation(Quadrant.R90))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 3.0000F, 14.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK).rotation(Quadrant.R90))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0000F, 13.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0000F, 3.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 11.0000F, 13.0000F).to(16.0000F, 12.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(-0.5000F, -1.0000F, -0.5000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 13.0000F, 16.0000F, 14.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK).rotation(Quadrant.R180))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(15.0000F, 13.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK).rotation(Quadrant.R90))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 13.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK).rotation(Quadrant.R270))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 13.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 16.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 11.0000F, 3.0000F).to(3.0000F, 12.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 1.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 3.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK).rotation(Quadrant.R270))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 1.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK).rotation(Quadrant.R90))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 13.0000F, 3.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(3.0000F, 11.5000F, 3.0000F).to(13.0000F, 11.5000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(1.0000F, 0.0000F, 1.0000F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 13.0000F, 13.0000F).texture(IcariaTextureSlots.CHALKOS_MESH_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 13.0000F, 13.0000F, 3.0000F).texture(IcariaTextureSlots.CHALKOS_MESH_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 8.0000F, 3.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.CHIMNEY).rotation(Quadrant.R180)))
			.element(elementBuilder -> elementBuilder.from(13.0000F, 0.0000F, 3.0000F).to(16.0000F, 8.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 8.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 3.0000F).texture(IcariaTextureSlots.CHIMNEY).rotation(Quadrant.R90))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 12.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.CHIMNEY).rotation(Quadrant.R90)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 13.0000F).to(16.0000F, 8.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.CHIMNEY)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 3.0000F).to(3.0000F, 8.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 8.0000F, 3.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 8.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.CHIMNEY))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 3.0000F).texture(IcariaTextureSlots.CHIMNEY).rotation(Quadrant.R90))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 12.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.CHIMNEY).rotation(Quadrant.R270)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 8.0000F, 1.0000F).to(2.0000F, 11.0000F, 2.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(14.0000F, 8.0000F, 1.0000F).to(15.0000F, 11.0000F, 2.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(14.0000F, 8.0000F, 14.0000F).to(15.0000F, 11.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 8.0000F, 14.0000F).to(2.0000F, 11.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK)))
			.build();
	}
}
