package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CobwebModel {

	public static ExtendedModelTemplate cobweb() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorth() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0250F, 0.0250F, 15.9750F, 15.9750F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0250F, 0.0250F, 15.9750F, 15.9750F).texture(IcariaTextureSlots.COBWEB)))
			.build();
	}

	public static ExtendedModelTemplate cobwebUp() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_UP))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_UP)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_UP))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_UP)))
			.build();
	}

	public static ExtendedModelTemplate cobwebDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEast() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthSouth() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 15.9750F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthUp() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_UP_EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_UP_EAST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN)))
			.build();
	}

	public static ExtendedModelTemplate cobwebUpDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN_UP))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN_UP)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN_UP))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN_UP)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastWest() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(0.0250F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastUp() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthSouthUp() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 15.9750F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthSouthDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 15.9750F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthUpDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_UP_EAST_DOWN))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN_WEST_UP)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN_WEST_UP))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_UP_EAST_DOWN)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastSouthWest() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 15.9750F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(0.0250F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_WEST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastWestUp() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(0.0250F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastWestDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(0.0250F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastUpDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_DOWN_WEST_UP))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_UP_EAST_DOWN)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthSouthUpDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 15.9750F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastSouthWestUp() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 15.9750F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(0.0250F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_WEST_UP_EAST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastSouthWestDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 15.9750F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(0.0250F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_EAST_DOWN_WEST)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastWestUpDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(0.0250F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.build();
	}

	public static ExtendedModelTemplate cobwebNorthEastSouthWestUpDown() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 0.0250F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(15.9750F, 0.0250F, 0.0250F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 15.9750F).to(15.9750F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 0.0250F).to(0.0250F, 15.9750F, 15.9750F)
				.shade(false)
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0250F, 0.0250F).to(8.0000F, 15.9750F, 15.9750F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.element(elementBuilder -> elementBuilder.from(0.0250F, 0.0250F, 8.0000F).to(15.9750F, 15.9750F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB)))
			.build();
	}
}
