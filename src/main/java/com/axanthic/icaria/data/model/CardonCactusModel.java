package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CardonCactusModel {

	public static void cube(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(4.0F, 4.0F, 4.0F).to(12.0F, 12.0F, 12.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(4.0F, 4.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(4.0F, 4.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(4.0F, 4.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(4.0F, 4.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.UP).uvs(4.0F, 4.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(4.0F, 4.0F, 12.0F, 12.0F).texture("#texture").end()
			.end();
	}

	public static void stem(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(4.0F, 4.0F, 0.0F).to(12.0F, 12.0F, 4.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(12.0F, 4.0F, 16.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 4.0F, 4.0F, 12.0F).texture("#texture").end()
			.face(Direction.UP).uvs(4.0F, 0.0F, 12.0F, 4.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(4.0F, 12.0F, 12.0F, 16.0F).texture("#texture").end()
			.end();
	}
}
