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

public class CakeModel {

	public static ExtendedModelTemplate template0() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 0.0000F, 1.0000F).to(15.0000F, 8.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.CAKE_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.build();
	}

	public static ExtendedModelTemplate template1() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(5.0000F, 0.0000F, 5.0000F).to(6.0000F, 1.0000F, 6.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0000F, 1.0000F).to(15.0000F, 8.0000F, 8.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 8.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 8.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_INSIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(8.0000F, 1.0000F, 15.0000F, 8.0000F).texture(IcariaTextureSlots.CAKE_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 0.0000F, 8.0000F).to(15.0000F, 8.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(-7.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_INSIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 8.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.CAKE_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 8.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.0000F, 2.0000F).to(7.0000F, 1.0000F, 3.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(3.0000F, 0.0000F, 6.0000F).to(4.0000F, 1.0000F, 7.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.build();
	}

	public static ExtendedModelTemplate template2() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(5.0000F, 0.0000F, 4.0000F).to(6.0000F, 1.0000F, 5.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 0.0000F, 8.0000F).to(15.0000F, 8.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(-7.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_INSIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 8.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.CAKE_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 8.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(13.0000F, 0.0000F, 6.0000F).to(14.0000F, 1.0000F, 7.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(3.0000F, 0.0000F, 5.0000F).to(4.0000F, 1.0000F, 6.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(9.0000F, 0.0000F, 5.0000F).to(10.0000F, 1.0000F, 6.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.build();
	}

	public static ExtendedModelTemplate template3() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.0000F, 5.0000F).to(7.0000F, 1.0000F, 6.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 1.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 0.0000F, 8.0000F).to(8.0000F, 8.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_INSIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 8.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_INSIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 8.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 8.0000F, 15.0000F).texture(IcariaTextureSlots.CAKE_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 8.0000F, 8.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(10.0000F, 0.0000F, 12.0000F).to(11.0000F, 1.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).rotation(Quadrant.R270).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 0.0000F, 6.0000F).to(3.0000F, 1.0000F, 7.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 2.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(9.0000F, 0.0000F, 10.0000F).to(10.0000F, 1.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).rotation(Quadrant.R270).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0000F, 1.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.build();
	}
}
