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

public class StoolModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 0.0000F, 2.0000F).to(4.0000F, 2.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 12.0000F, 4.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 12.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 12.0000F, 4.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 12.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 4.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 4.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(12.0000F, 0.0000F, 2.0000F).to(14.0000F, 2.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(12.0000F, 12.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 12.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(12.0000F, 12.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 12.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(12.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(12.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(7.5000F, -1.0000F, 11.0000F).to(8.5000F, 13.0000F, 12.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Z).origin(8.0000F, 6.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(7.5000F, -1.0000F, 12.0000F).to(8.5000F, 13.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-45.0000F).axis(Direction.Axis.Z).origin(8.0000F, 6.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(15.0000F, 2.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(15.0000F, 2.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(15.0000F, 2.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(15.0000F, 2.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(7.5000F, -1.0000F, 4.0000F).to(8.5000F, 13.0000F, 5.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Z).origin(8.0000F, 6.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(7.5000F, -1.0000F, 3.0000F).to(8.5000F, 13.0000F, 4.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-45.0000F).axis(Direction.Axis.Z).origin(8.0000F, 6.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 10.0000F, 2.0000F).to(4.0000F, 12.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 4.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 4.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 4.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 4.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(12.0000F, 10.0000F, 2.0000F).to(14.0000F, 12.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(12.0000F, 2.0000F, 14.0000F, 4.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 4.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(12.0000F, 2.0000F, 14.0000F, 4.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 2.0000F, 14.0000F, 4.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(12.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(12.0000F, 2.0000F, 14.0000F, 14.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(4.0000F, 11.7500F, 3.0000F).to(12.0000F, 12.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(12.0000F, 3.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(4.0000F, 12.0000F, 12.0000F, 13.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0000F, 3.0000F, 12.0000F, 13.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0000F, 13.0000F, 12.0000F, 3.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(1.7500F, 9.7500F, 2.7500F).to(4.2500F, 12.2500F, 13.2500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 5.0000F, 5.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 13.0000F, 5.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 5.0000F, 5.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 13.0000F, 5.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 5.0000F, 13.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 5.0000F, 13.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(11.7500F, 9.7500F, 2.7500F).to(14.2500F, 12.2500F, 13.2500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(11.0000F, 3.0000F, 13.0000F, 5.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 13.0000F, 5.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(11.0000F, 3.0000F, 13.0000F, 5.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 13.0000F, 5.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(11.0000F, 3.0000F, 13.0000F, 13.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(11.0000F, 3.0000F, 13.0000F, 13.0000F).texture(IcariaTextureSlots.ARACHNE_STRING_BLOCK)))
			.build();
	}
}
