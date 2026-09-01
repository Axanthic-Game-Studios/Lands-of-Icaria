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

public class PottedBromeliaModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(5.0000F, 0.0000F, 5.0000F).to(6.0000F, 6.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0000F, 10.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 6.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0000F, 5.0000F, 6.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(5.0000F, 5.0000F, 6.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(10.0000F, 0.0000F, 5.0000F).to(11.0000F, 6.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 6.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0000F, 10.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(10.0000F, 5.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(10.0000F, 5.0000F, 11.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.0000F, 5.0000F).to(10.0000F, 6.0000F, 6.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 5.0000F, 10.0000F, 6.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.0000F, 10.0000F).to(10.0000F, 6.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0000F, 5.0000F, 10.0000F, 6.0000F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.0000F, 6.0000F).to(10.0000F, 6.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 8.0000F, 0.0000F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0000F, 0.0000F, 9.0000F, 4.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(12.0000F, 6.0000F, 16.0000F, 10.0000F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(7.5000F, 15.0000F, 7.5000F).to(8.5000F, 16.0000F, 8.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 2.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 4.0000F, 2.0000F, 5.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 4.0000F, 2.0000F, 5.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 4.0000F, 2.0000F, 5.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 4.0000F, 2.0000F, 5.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 4.0000F, 2.0000F, 5.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.element(elementBuilder -> elementBuilder.from(6.5000F, 11.0000F, 6.5000F).to(9.5000F, 15.0000F, 9.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 2.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 4.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 4.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 4.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 4.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 6.0000F, 3.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 6.0000F, 6.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.element(elementBuilder -> elementBuilder.from(7.5000F, 6.0000F, 7.5000F).to(8.5000F, 11.0000F, 8.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 4.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 9.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 9.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 9.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 9.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.element(elementBuilder -> elementBuilder.from(6.5000F, 6.0000F, 9.0000F).to(9.5000F, 11.0000F, 9.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(22.5000F, 0.0000F, 0.0000F).origin(8.0000F, 6.0000F, 9.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(6.5000F, 6.0000F, 7.0000F).to(9.5000F, 11.0000F, 7.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(-22.5000F, 0.0000F, 0.0000F).origin(8.0000F, 6.0000F, 7.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(9.0000F, 6.0000F, 6.5000F).to(9.0000F, 11.0000F, 9.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, -22.5000F).origin(9.0000F, 6.0000F, 8.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(7.0000F, 6.0000F, 6.5000F).to(7.0000F, 11.0000F, 9.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 22.5000F).origin(7.0000F, 6.0000F, 8.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(5.5000F, 10.2500F, 10.1250F).to(10.5000F, 14.2500F, 10.1250F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(45.0000F, 0.0000F, 0.0000F).origin(8.0000F, 8.2500F, 10.1250F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 5.0000F, 8.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 5.0000F, 8.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(5.5000F, 6.0000F, 10.0000F).to(10.5000F, 10.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(22.5000F, 0.0000F, 0.0000F).origin(8.0000F, 6.0000F, 10.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 4.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 4.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(5.5000F, 10.8750F, 7.2500F).to(10.5000F, 14.8750F, 7.2500F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(-45.0000F, 0.0000F, 0.0000F).origin(8.0000F, 6.8750F, 7.2500F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 5.0000F, 8.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 5.0000F, 8.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(5.5000F, 6.0000F, 6.0000F).to(10.5000F, 10.0000F, 6.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(-22.5000F, 0.0000F, 0.0000F).origin(8.0000F, 6.0000F, 6.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 4.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 4.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(8.7500F, 10.8750F, 5.5000F).to(8.7500F, 14.8750F, 10.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, -45.0000F).origin(8.7500F, 6.8750F, 8.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 5.0000F, 8.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 5.0000F, 8.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(10.0000F, 6.0000F, 5.5000F).to(10.0000F, 10.0000F, 10.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, -22.5000F).origin(10.0000F, 6.0000F, 8.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 4.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 4.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(7.2500F, 10.8750F, 5.5000F).to(7.2500F, 14.8750F, 10.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 45.0000F).origin(7.2500F, 6.8750F, 8.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 5.0000F, 8.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 5.0000F, 8.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 6.0000F, 5.5000F).to(6.0000F, 10.0000F, 10.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 22.5000F).origin(6.0000F, 6.0000F, 8.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 4.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 5.0000F, 4.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.build();
	}
}
