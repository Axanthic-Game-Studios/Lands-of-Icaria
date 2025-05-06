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

public class ZirconCrystalModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(2.0F, 0.0F, 7.0F).to(5.0F, 6.0F, 10.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 1.5F, 3.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 0.0F, 2.5F, 3.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0F, 0.0F, 3.5F, 3.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0F, 0.0F, 4.5F, 3.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 1.5F, 1.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 1.5F, 1.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(2.0F, 0.0F, 5.0F).to(4.0F, 5.0F, 7.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 4.0F, 1.0F, 6.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 4.0F, 2.0F, 6.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0F, 4.0F, 3.0F, 6.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0F, 4.0F, 4.0F, 6.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 15.0F, 1.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 15.0F, 1.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(3.5F, 0.0F, 10.5F).to(5.5F, 4.0F, 12.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 1.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 2.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0F, 8.0F, 3.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0F, 8.0F, 4.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(2.0F, 15.0F, 3.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0F, 15.0F, 2.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(5.0F, 0.0F, 6.5F).to(9.0F, 5.0F, 10.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 16.0F, 4.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(12.0F, 2.0F, 14.0F, 4.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0F, 2.0F, 12.0F, 4.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 2.0F, 10.0F, 4.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0F, 0.0F, 6.0F, 2.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0F, 0.0F, 8.0F, 2.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(9.5F, 0.0F, 11.0F).to(11.5F, 6.0F, 13.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(4.0F, 8.0F, 5.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0F, 8.0F, 6.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0F, 8.0F, 7.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0F, 8.0F, 8.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0F, 15.0F, 5.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0F, 15.0F, 4.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(11.0F, 0.0F, 6.0F).to(14.0F, 4.0F, 9.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0F, 8.0F, 15.5F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(12.0F, 8.0F, 13.5F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0F, 8.0F, 11.5F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 8.0F, 9.5F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0F, 1.0F, 10.5F, 2.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(7.0F, 2.0F, 8.5F, 3.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(12.0F, 0.0F, 7.0F).to(14.0F, 7.0F, 9.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 6.5F, 1.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 6.5F, 2.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0F, 6.5F, 3.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0F, 6.5F, 4.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0F, 15.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(10.0F, 15.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(5.7F, 0.0F, 2.0F).to(9.7F, 3.0F, 6.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0F, 7.0F, 16.0F, 8.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 9.0F, 16.0F, 10.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0F, 11.0F, 16.0F, 12.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 13.0F, 16.0F, 14.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 9.0F, 8.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0F, 9.0F, 6.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(2.5F, 0.0F, 9.5F).to(4.5F, 2.0F, 11.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 10.0F, 1.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 10.0F, 2.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0F, 10.0F, 3.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0F, 10.0F, 4.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(11.0F, 15.0F, 12.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(12.0F, 15.0F, 13.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(12.0F, 0.0F, 2.5F).to(14.0F, 2.0F, 4.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(8.0F, 5.0F, 9.0F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(9.0F, 5.0F, 10.0F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0F, 5.0F, 11.0F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(11.0F, 5.0F, 12.0F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0F, 6.0F, 10.0F, 7.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(10.0F, 6.0F, 11.0F, 7.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.build();
	}
}
