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

public class JasperCrystalModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(1.0F, -2.0F, 3.5F).to(10.0F, 5.0F, 12.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 8.5F, 4.5F, 12.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 16.0F, 4.5F, 12.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(8.0F, 12.5F, 12.5F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 8.5F, 12.5F, 12.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(11.5F, 0.0F, 16.0F, 4.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(11.5F, 0.0F, 16.0F, 4.5F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(11.9F, -0.7F, 4.0F).to(13.9F, 3.3F, 8.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0F, 8.0F, 8.0F, 9.0F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 16.0F, 16.0F, 14.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0F, 12.0F, 8.0F, 13.0F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 14.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 8.0F, 11.0F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0F, 14.0F, 8.0F, 15.0F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(2.0F, 0.4F, 0.2F).to(4.0F, 4.4F, 4.2F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0F, 8.0F, 6.0F, 10.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 12.0F, 16.0F, 14.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 6.0F, 12.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 12.0F, 16.0F, 14.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0F, 12.0F, 6.0F, 14.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(5.0F, 14.0F, 6.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(5.1F, 0.0F, 2.7F).to(11.1F, 4.0F, 8.7F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 6.0F, 3.0F, 8.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0F, 6.0F, 6.0F, 8.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0F, 6.0F, 8.0F, 8.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(9.0F, 6.0F, 12.0F, 8.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0F, 9.0F, 16.0F, 12.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0F, 9.0F, 16.0F, 12.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(5.0F, 1.9F, 12.4F).to(10.0F, 4.9F, 15.4F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 4.5F, 2.5F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.5F, 6.5F, 16.0F, 8.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(3.0F, 4.5F, 5.5F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.5F, 6.5F, 16.0F, 8.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 4.5F, 8.5F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(9.0F, 4.5F, 11.5F, 6.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(6.8F, 3.8F, 7.0F).to(10.8F, 4.8F, 11.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 3.5F, 2.0F, 4.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0F, 3.5F, 4.0F, 4.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(4.0F, 3.5F, 6.0F, 4.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(6.0F, 3.5F, 8.0F, 4.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(8.0F, 2.0F, 10.0F, 4.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(8.0F, 2.0F, 10.0F, 4.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.element(elementBuilder -> elementBuilder.from(7.6F, 1.2F, 4.7F).to(11.6F, 5.2F, 8.7F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 2.0F, 2.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(4.0F, 0.0F, 2.0F, 2.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(8.0F, 0.0F, 10.0F, 2.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(6.0F, 0.0F, 8.0F, 2.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(8.0F, 0.0F, 10.0F, 2.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0F, 0.0F, 6.0F, 2.0F).texture(IcariaTextureSlots.TEXTURE).emissivity(15, 15)))
			.build();
	}
}
