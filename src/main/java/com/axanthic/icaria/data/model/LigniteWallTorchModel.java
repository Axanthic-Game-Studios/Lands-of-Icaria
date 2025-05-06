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

public class LigniteWallTorchModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(7.0F, 0.0F, 11.5F).to(9.0F, 1.0F, 14.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(4.0F, 15.0F, 2.0F, 16.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(12.0F, 15.0F, 9.0F, 16.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(9.0F, 15.0F, 7.0F, 16.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0F, 15.0F, 4.0F, 16.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 3.0F, 2.0F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 3.0F, 2.0F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE)))
			.element(elementBuilder -> elementBuilder.from(6.5F, 0.0F, 12.0F).to(7.0F, 1.0F, 14.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(3.5F, 15.0F, 3.0F, 16.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.5F, 15.0F, 7.0F, 16.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(6.0F, 15.0F, 4.0F, 16.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 0.5F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 0.5F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE)))
			.element(elementBuilder -> elementBuilder.from(9.0F, 0.0F, 12.0F).to(9.5F, 1.0F, 14.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(3.5F, 15.0F, 3.0F, 16.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 15.0F, 12.0F, 16.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.5F, 15.0F, 5.0F, 16.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 0.5F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 0.5F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE)))
			.element(elementBuilder -> elementBuilder.from(7.0F, 1.0F, 12.0F).to(9.0F, 8.0F, 14.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(11.0F, 8.0F, 9.0F, 15.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(9.0F, 8.0F, 7.0F, 15.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0F, 8.0F, 5.0F, 15.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0F, 8.0F, 11.0F, 15.0F).texture(IcariaTextureSlots.TORCH_BONE)))
			.element(elementBuilder -> elementBuilder.from(7.0F, 8.0F, 11.5F).to(9.0F, 9.0F, 14.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(4.0F, 7.0F, 2.0F, 8.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(12.0F, 7.0F, 9.0F, 8.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(9.0F, 7.0F, 7.0F, 8.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0F, 7.0F, 4.0F, 8.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0F, 16.0F, 5.0F, 13.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 3.0F, 2.0F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE)))
			.element(elementBuilder -> elementBuilder.from(6.5F, 8.0F, 12.0F).to(7.0F, 9.0F, 14.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(3.5F, 7.0F, 3.0F, 8.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.5F, 7.0F, 7.0F, 8.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(6.0F, 7.0F, 4.0F, 8.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 0.5F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 0.5F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE)))
			.element(elementBuilder -> elementBuilder.from(9.0F, 8.0F, 12.0F).to(9.5F, 9.0F, 14.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(3.5F, 7.0F, 3.0F, 8.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 7.0F, 12.0F, 8.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.5F, 7.0F, 5.0F, 8.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 0.5F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 0.5F, 0.0F).texture(IcariaTextureSlots.TORCH_BONE)))
			.element(elementBuilder -> elementBuilder.from(7.0F, 9.0F, 12.0F).to(9.0F, 10.0F, 14.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0F, 4.0F, 12.0F, 5.0F).texture(IcariaTextureSlots.TORCH_COAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 12.0F, 3.0F).texture(IcariaTextureSlots.TORCH_COAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0F, 0.0F, 12.0F, 1.0F).texture(IcariaTextureSlots.TORCH_COAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 6.0F, 12.0F, 7.0F).texture(IcariaTextureSlots.TORCH_COAL)))
			.element(elementBuilder -> elementBuilder.from(7.0F, 10.0F, 12.0F).to(9.0F, 11.0F, 14.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0F, 12.0F, 5.0F, 13.0F).texture(IcariaTextureSlots.TORCH_COAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(7.0F, 10.0F, 5.0F, 11.0F).texture(IcariaTextureSlots.TORCH_COAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0F, 8.0F, 5.0F, 9.0F).texture(IcariaTextureSlots.TORCH_COAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0F, 14.0F, 5.0F, 15.0F).texture(IcariaTextureSlots.TORCH_COAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0F, 11.0F, 3.0F, 9.0F).texture(IcariaTextureSlots.TORCH_COAL)))
			.element(elementBuilder -> elementBuilder.from(6.0F, -1.0F, 11.0F).to(10.0F, 0.0F, 14.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0F, 15.0F, 2.0F, 16.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(12.0F, 15.0F, 9.0F, 16.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(11.0F, 15.0F, 7.0F, 16.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0F, 15.0F, 4.0F, 16.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 3.0F, 4.0F, 0.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 3.0F, 4.0F, 0.0F).texture(IcariaTextureSlots.TORCH_METAL)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 8.0F, 11.0F).to(10.0F, 9.0F, 12.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 16.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(9.0F, 13.0F, 5.0F, 14.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0F, 10.0F, 12.0F, 11.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(11.0F, 3.0F, 7.0F, 4.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0F, 11.0F, 6.0F, 12.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 3.0F, 10.0F, 2.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0F, 3.0F, 10.0F, 2.0F).texture(IcariaTextureSlots.TORCH_METAL)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 8.0F, 12.0F).to(7.0F, 9.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 16.0F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0F, 13.0F, 9.0F, 14.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(8.0F, 13.0F, 7.0F, 14.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 13.0F, 4.0F, 14.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0F, 5.0F, 4.0F, 1.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0F, 7.0F, 5.0F, 3.0F).texture(IcariaTextureSlots.TORCH_METAL)))
			.element(elementBuilder -> elementBuilder.from(9.0F, 8.0F, 12.0F).to(10.0F, 9.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 16.0F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(7.0F, 11.0F, 3.0F, 12.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0F, 14.0F, 9.0F, 15.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0F, 11.0F, 1.0F, 12.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(7.0F, 8.0F, 8.0F, 4.0F).texture(IcariaTextureSlots.TORCH_METAL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(8.0F, 5.0F, 9.0F, 1.0F).texture(IcariaTextureSlots.TORCH_METAL)))
			.build();
	}
}
