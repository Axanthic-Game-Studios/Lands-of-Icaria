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

public class CakeModel {

	public static ExtendedModelTemplate template0() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(1.0F, 0.0F, 1.0F).to(15.0F, 8.0F, 15.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0F, 1.0F, 15.0F, 15.0F).texture(IcariaTextureSlots.CAKE_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0F, 1.0F, 15.0F, 15.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.build();
	}

	public static ExtendedModelTemplate template1() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(5.0F, 0.0F, 5.0F).to(6.0F, 1.0F, 6.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(8.0F, 0.0F, 1.0F).to(15.0F, 8.0F, 8.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 8.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(8.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 8.0F, 16.0F).texture(IcariaTextureSlots.CAKE_INSIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(8.0F, 1.0F, 15.0F, 8.0F).texture(IcariaTextureSlots.CAKE_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(8.0F, 8.0F, 15.0F, 15.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(1.0F, 0.0F, 8.0F).to(15.0F, 8.0F, 15.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(-7.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_INSIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 8.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 15.0F).texture(IcariaTextureSlots.CAKE_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0F, 1.0F, 15.0F, 8.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 0.0F, 2.0F).to(7.0F, 1.0F, 3.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(3.0F, 0.0F, 6.0F).to(4.0F, 1.0F, 7.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.build();
	}

	public static ExtendedModelTemplate template2() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(5.0F, 0.0F, 4.0F).to(6.0F, 1.0F, 5.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(1.0F, 0.0F, 8.0F).to(15.0F, 8.0F, 15.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(-7.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_INSIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 8.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 15.0F).texture(IcariaTextureSlots.CAKE_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0F, 1.0F, 15.0F, 8.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(13.0F, 0.0F, 6.0F).to(14.0F, 1.0F, 7.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(3.0F, 0.0F, 5.0F).to(4.0F, 1.0F, 6.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(9.0F, 0.0F, 5.0F).to(10.0F, 1.0F, 6.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.build();
	}

	public static ExtendedModelTemplate template3() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(6.0F, 0.0F, 5.0F).to(7.0F, 1.0F, 6.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0F, 1.0F, 15.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(1.0F, 0.0F, 8.0F).to(8.0F, 8.0F, 15.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(8.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_INSIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 8.0F, 16.0F).texture(IcariaTextureSlots.CAKE_INSIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 8.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 8.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.CAKE_SIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 8.0F, 15.0F).texture(IcariaTextureSlots.CAKE_TOP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0F, 1.0F, 8.0F, 8.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(10.0F, 0.0F, 12.0F).to(11.0F, 1.0F, 13.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).rotation(FaceRotation.COUNTERCLOCKWISE_90).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(2.0F, 0.0F, 6.0F).to(3.0F, 1.0F, 7.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0F, 2.0F, 15.0F, 3.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.element(elementBuilder -> elementBuilder.from(9.0F, 0.0F, 10.0F).to(10.0F, 1.0F, 11.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).rotation(FaceRotation.COUNTERCLOCKWISE_90).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0F, 1.0F, 14.0F, 2.0F).texture(IcariaTextureSlots.CAKE_BOTTOM)))
			.build();
	}
}
