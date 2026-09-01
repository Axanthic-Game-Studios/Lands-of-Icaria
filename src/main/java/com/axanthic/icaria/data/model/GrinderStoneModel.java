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

public class GrinderStoneModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 5.0000F, 6.0000F).to(9.0000F, 15.0000F, 7.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 9.0000F, 10.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 6.0000F, 9.0000F, 7.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(9.0000F, 5.0000F, 6.0000F).to(10.0000F, 15.0000F, 9.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 10.0000F, 10.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0000F, 6.0000F, 10.0000F, 9.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 5.0000F, 7.0000F).to(7.0000F, 15.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 10.0000F, 10.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 7.0000F, 7.0000F, 10.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(7.0000F, 5.0000F, 9.0000F).to(10.0000F, 15.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 10.0000F, 10.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(7.0000F, 9.0000F, 10.0000F, 10.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 5.0000F, 11.0000F).to(10.0000F, 16.0000F, 12.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(4.0000F, 0.0000F, 5.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(11.0000F, 0.0000F, 12.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 11.0000F, 10.0000F, 12.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(4.0000F, 5.0000F, 6.0000F).to(5.0000F, 16.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(11.0000F, 0.0000F, 12.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(4.0000F, 0.0000F, 5.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0000F, 6.0000F, 5.0000F, 10.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(11.0000F, 5.0000F, 6.0000F).to(12.0000F, 16.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(4.0000F, 0.0000F, 5.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(11.0000F, 0.0000F, 12.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(11.0000F, 6.0000F, 12.0000F, 10.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 5.0000F, 4.0000F).to(10.0000F, 16.0000F, 5.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(11.0000F, 0.0000F, 12.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 0.0000F, 5.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 4.0000F, 10.0000F, 5.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(5.0000F, 5.0000F, 6.0000F).to(6.0000F, 16.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0000F, 0.0000F, 6.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0000F, 6.0000F, 6.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 5.0000F, 10.0000F).to(11.0000F, 16.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0000F, 0.0000F, 6.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(10.0000F, 5.0000F, 5.0000F).to(11.0000F, 16.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0000F, 0.0000F, 6.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(10.0000F, 5.0000F, 11.0000F, 10.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(5.0000F, 5.0000F, 5.0000F).to(10.0000F, 16.0000F, 6.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0000F, 0.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0000F, 0.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0000F, 0.0000F, 6.0000F, 11.0000F).texture(IcariaTextureSlots.VOIDSHALE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0000F, 5.0000F, 10.0000F, 6.0000F).texture(IcariaTextureSlots.VOIDSHALE)))
			.element(elementBuilder -> elementBuilder.from(7.0000F, 13.0000F, 7.0000F).to(9.0000F, 14.0000F, 9.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(7.0000F, 7.0000F, 9.0000F, 9.0000F).texture(IcariaTextureSlots.GRINDER_STONE)))
			.build();
	}
}
