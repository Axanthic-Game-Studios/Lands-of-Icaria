package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import net.neoforged.neoforge.client.model.generators.template.FaceRotation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CalciteCrystalModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(7.0F, 0.0F, 7.0F).to(9.0F, 10.0F, 9.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0F, 0.0F, 6.0F, 5.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0F, 0.0F, 7.0F, 5.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 8.0F, 5.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 0.0F, 9.0F, 5.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0F, 0.0F, 10.0F, 1.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(9.0F, 0.0F, 10.0F, 1.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(8.0F, 0.5F, 3.0F).to(10.0F, 12.5F, 5.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0F, 0.0F, 11.0F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(11.0F, 0.0F, 12.0F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(12.0F, 0.0F, 13.0F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0F, 0.0F, 14.0F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0F, 0.0F, 15.0F, 1.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0F, 0.0F, 15.0F, 1.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 2.5F, 0.0F).to(8.0F, 10.5F, 2.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 1.0F, 4.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 0.0F, 2.0F, 4.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0F, 0.0F, 3.0F, 4.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0F, 0.0F, 4.0F, 4.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0F, 0.0F, 5.0F, 1.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0F, 0.0F, 5.0F, 1.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 0.5F, 11.0F).to(8.0F, 8.5F, 13.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0F, 7.0F, 11.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(11.0F, 7.0F, 12.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(12.0F, 7.0F, 13.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0F, 7.0F, 14.0F, 11.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0F, 7.0F, 15.0F, 8.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0F, 7.0F, 15.0F, 8.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(9.0F, 1.5F, 13.0F).to(11.0F, 9.5F, 15.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0F, 6.0F, 6.0F, 9.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0F, 6.0F, 7.0F, 9.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0F, 6.0F, 8.0F, 9.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 6.0F, 9.0F, 9.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0F, 6.0F, 10.0F, 7.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(9.0F, 6.0F, 10.0F, 7.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(1.5F, 0.0F, 7.0F).to(7.5F, 2.0F, 9.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 5.0F, 1.0F, 8.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(4.0F, 5.0F, 5.0F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0F, 5.0F, 3.0F, 8.0F).rotation(FaceRotation.COUNTERCLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0F, 5.0F, 5.0F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0F, 5.0F, 2.0F, 8.0F).rotation(FaceRotation.COUNTERCLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0F, 5.0F, 4.0F, 8.0F).rotation(FaceRotation.COUNTERCLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(1.0F, 1.5F, 5.5F).to(3.0F, 11.5F, 7.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 9.0F, 1.0F, 14.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 9.0F, 2.0F, 14.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0F, 9.0F, 3.0F, 14.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0F, 9.0F, 4.0F, 14.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0F, 9.0F, 5.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0F, 9.0F, 5.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(11.0F, 0.5F, 8.0F).to(13.0F, 10.5F, 10.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0F, 11.0F, 6.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0F, 11.0F, 7.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0F, 11.0F, 8.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 11.0F, 9.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0F, 11.0F, 10.0F, 12.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(9.0F, 11.0F, 10.0F, 12.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 0.0F, 6.0F).to(12.0F, 2.0F, 8.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0F, 12.0F, 11.0F, 16.0F).rotation(FaceRotation.COUNTERCLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 12.0F, 15.0F, 13.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(11.0F, 12.0F, 12.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 12.0F, 15.0F, 13.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(12.0F, 12.0F, 13.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0F, 12.0F, 14.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.build();
	}
}
