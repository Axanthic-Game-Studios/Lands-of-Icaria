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

public class TowelHolderModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 8.0000F, 15.0000F).to(16.0000F, 12.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 1.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(15.0000F, 8.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 9.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(16.0000F, 11.0000F, 0.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS)))
			.element(elementBuilder -> elementBuilder.from(12.0000F, 9.0000F, 12.0000F).to(14.0000F, 11.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0000F, 7.0000F, 9.0000F, 9.0000F).texture(IcariaTextureSlots.LOG_TOP))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 3.0000F, 0.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 2.0000F, 0.0000F, 0.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 3.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 3.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 9.0000F, 12.0000F).to(4.0000F, 11.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(-10.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0000F, 7.0000F, 9.0000F, 9.0000F).texture(IcariaTextureSlots.LOG_TOP))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 3.0000F, 0.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 2.0000F, 0.0000F, 0.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 3.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 3.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(4.0000F, 9.5000F, 12.5000F).to(12.0000F, 10.5000F, 13.5000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 8.0000F, 1.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 8.0000F, 1.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 8.0000F, 1.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 8.0000F, 1.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(4.5000F, 10.5000F, 12.2500F).to(11.5000F, 10.7500F, 13.7500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(4.0000F, 2.0000F, 11.0000F, 3.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(10.0000F, 2.0000F, 11.0000F, 3.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(4.0000F, 2.0000F, 11.0000F, 3.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 2.0000F, 5.0000F, 3.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0000F, 2.0000F, 11.0000F, 3.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(4.5000F, 4.7500F, 12.2500F).to(11.5000F, 10.5000F, 12.5000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(4.0000F, 2.2500F, 11.0000F, 8.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(4.0000F, 2.2500F, 5.0000F, 8.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(11.0000F, 2.2500F, 4.0000F, 8.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(10.0000F, 2.2500F, 11.0000F, 8.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(11.0000F, 7.0000F, 4.0000F, 8.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(4.5000F, 1.7500F, 13.5000F).to(11.5000F, 10.5000F, 13.7500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(11.0000F, 2.2500F, 4.0000F, 11.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(10.0000F, 2.2500F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(4.0000F, 2.2500F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 2.2500F, 5.0000F, 11.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0000F, 10.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK)))
			.build();
	}
}
