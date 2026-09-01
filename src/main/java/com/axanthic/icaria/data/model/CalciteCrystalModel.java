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

public class CalciteCrystalModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(7.0000F, 0.0000F, 7.0000F).to(9.0000F, 10.0000F, 9.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0000F, 0.0000F, 6.0000F, 5.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 7.0000F, 5.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 8.0000F, 5.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 0.0000F, 9.0000F, 5.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0000F, 0.0000F, 10.0000F, 1.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(9.0000F, 0.0000F, 10.0000F, 1.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.5000F, 3.0000F).to(10.0000F, 12.5000F, 5.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(-22.5000F, 0.0000F, 0.0000F).origin(8.0000F, 8.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0000F, 0.0000F, 11.0000F, 6.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(11.0000F, 0.0000F, 12.0000F, 6.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(12.0000F, 0.0000F, 13.0000F, 6.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 0.0000F, 14.0000F, 6.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0000F, 0.0000F, 15.0000F, 1.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 0.0000F, 15.0000F, 1.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 2.5000F, 0.0000F).to(8.0000F, 10.5000F, 2.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(-45.0000F, 0.0000F, 0.0000F).origin(8.0000F, 8.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 4.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 2.0000F, 4.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 3.0000F, 4.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0000F, 0.0000F, 5.0000F, 1.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0000F, 0.0000F, 5.0000F, 1.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.5000F, 11.0000F).to(8.0000F, 8.5000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(22.5000F, 0.0000F, 0.0000F).origin(8.0000F, 8.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0000F, 7.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(11.0000F, 7.0000F, 12.0000F, 11.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(12.0000F, 7.0000F, 13.0000F, 11.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 7.0000F, 14.0000F, 11.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0000F, 7.0000F, 15.0000F, 8.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 7.0000F, 15.0000F, 8.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15)))
			.element(elementBuilder -> elementBuilder.from(9.0000F, 1.5000F, 13.0000F).to(11.0000F, 9.5000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(45.0000F, 0.0000F, 0.0000F).origin(8.0000F, 8.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0000F, 6.0000F, 6.0000F, 9.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0000F, 6.0000F, 7.0000F, 9.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0000F, 6.0000F, 8.0000F, 9.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 6.0000F, 9.0000F, 9.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0000F, 6.0000F, 10.0000F, 7.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(9.0000F, 6.0000F, 10.0000F, 7.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15)))
			.element(elementBuilder -> elementBuilder.from(1.5000F, 0.0000F, 7.0000F).to(7.5000F, 2.0000F, 9.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 22.5000F, 0.0000F).origin(8.0000F, 8.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 8.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(4.0000F, 5.0000F, 5.0000F, 6.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 5.0000F, 3.0000F, 8.0000F).rotation(Quadrant.R270).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 5.0000F, 5.0000F, 6.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 5.0000F, 2.0000F, 8.0000F).rotation(Quadrant.R270).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 5.0000F, 4.0000F, 8.0000F).rotation(Quadrant.R270).texture(IcariaTextureSlots.TEXTURE).lightEmission(15)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 1.5000F, 5.5000F).to(3.0000F, 11.5000F, 7.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 45.0000F).origin(8.0000F, 8.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 9.0000F, 1.0000F, 14.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 9.0000F, 2.0000F, 14.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 9.0000F, 3.0000F, 14.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 9.0000F, 4.0000F, 14.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0000F, 9.0000F, 5.0000F, 10.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0000F, 9.0000F, 5.0000F, 10.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15)))
			.element(elementBuilder -> elementBuilder.from(11.0000F, 0.5000F, 8.0000F).to(13.0000F, 10.5000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, -22.5000F).origin(8.0000F, 8.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0000F, 11.0000F, 6.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0000F, 11.0000F, 7.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0000F, 11.0000F, 8.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 11.0000F, 9.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0000F, 11.0000F, 10.0000F, 12.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(9.0000F, 11.0000F, 10.0000F, 12.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.0000F, 6.0000F).to(12.0000F, 2.0000F, 8.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 22.5000F).origin(8.0000F, 8.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0000F, 12.0000F, 11.0000F, 16.0000F).rotation(Quadrant.R270).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 12.0000F, 15.0000F, 13.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(11.0000F, 12.0000F, 12.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 12.0000F, 15.0000F, 13.0000F).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(12.0000F, 12.0000F, 13.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).lightEmission(15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0000F, 12.0000F, 14.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).lightEmission(15)))
			.build();
	}
}
