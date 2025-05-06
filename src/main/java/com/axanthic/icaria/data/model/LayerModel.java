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

public class LayerModel {

	public static ExtendedModelTemplate template1() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 0.0F).to(16.0F, 2.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 14.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 14.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 14.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 14.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template2() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 0.0F).to(16.0F, 4.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 12.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 12.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 12.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 12.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template3() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 0.0F).to(16.0F, 6.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 10.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 10.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 10.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 10.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template4() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 0.0F).to(16.0F, 8.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template5() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 0.0F).to(16.0F, 10.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 6.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 6.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 6.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 6.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template6() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 0.0F).to(16.0F, 12.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 4.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 4.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 4.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 4.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template7() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 0.0F).to(16.0F, 14.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 2.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template8() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}
}
