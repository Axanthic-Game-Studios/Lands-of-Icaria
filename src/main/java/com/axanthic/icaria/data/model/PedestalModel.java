package com.axanthic.icaria.data.model;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PedestalModel {

	public static ExtendedModelTemplate single() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIds.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 11.0000F, 1.0000F).to(15.0000F, 16.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_TOP)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 10.0000F, 2.0000F).to(14.0000F, 11.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 5.0000F, 14.0000F, 6.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 5.0000F, 14.0000F, 6.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 5.0000F, 14.0000F, 6.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 5.0000F, 14.0000F, 6.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR)))
			.element(elementBuilder -> elementBuilder.from(3.0000F, 6.0000F, 3.0000F).to(13.0000F, 10.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(3.0000F, 6.0000F, 13.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 6.0000F, 13.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(3.0000F, 6.0000F, 13.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 6.0000F, 13.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 5.0000F, 2.0000F).to(14.0000F, 6.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR_TOP)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 0.0000F, 1.0000F).to(15.0000F, 5.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_TOP)))
			.build();
	}

	public static ExtendedModelTemplate bottom() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIds.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 15.0000F, 2.0000F).to(14.0000F, 16.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 6.0000F, 14.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 6.0000F, 14.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 6.0000F, 14.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 6.0000F, 14.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR)))
			.element(elementBuilder -> elementBuilder.from(3.0000F, 6.0000F, 3.0000F).to(13.0000F, 15.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(3.0000F, 1.0000F, 13.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 1.0000F, 13.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(3.0000F, 1.0000F, 13.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 1.0000F, 13.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 5.0000F, 2.0000F).to(14.0000F, 6.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR_TOP)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 0.0000F, 1.0000F).to(15.0000F, 5.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_TOP)))
			.build();
	}

	public static ExtendedModelTemplate center() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIds.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 15.0000F, 2.0000F).to(14.0000F, 16.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 5.0000F, 14.0000F, 6.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 5.0000F, 14.0000F, 6.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 5.0000F, 14.0000F, 6.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 5.0000F, 14.0000F, 6.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR)))
			.element(elementBuilder -> elementBuilder.from(3.0000F, 1.0000F, 3.0000F).to(13.0000F, 15.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(3.0000F, 1.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 1.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(3.0000F, 1.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 1.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 0.0000F, 2.0000F).to(14.0000F, 1.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 10.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR_TOP)))
			.build();
	}

	public static ExtendedModelTemplate top() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIds.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 11.0000F, 1.0000F).to(15.0000F, 16.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_TOP)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 10.0000F, 2.0000F).to(14.0000F, 11.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 6.0000F, 14.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 6.0000F, 14.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 6.0000F, 14.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 6.0000F, 14.0000F, 5.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR)))
			.element(elementBuilder -> elementBuilder.from(3.0000F, 1.0000F, 3.0000F).to(13.0000F, 10.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(3.0000F, 6.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 6.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(3.0000F, 6.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 6.0000F, 13.0000F, 15.0000F).texture(IcariaTextureSlots.PEDESTAL_SIDE)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 0.0000F, 2.0000F).to(14.0000F, 1.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 11.0000F, 14.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 11.0000F, 14.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 11.0000F, 14.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 11.0000F, 14.0000F, 10.0000F).texture(IcariaTextureSlots.PEDESTAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.PEDESTAL_COLLAR_TOP)))
			.build();
	}
}
