package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DeadVineModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.8F).to(16.0F, 16.0F, 0.8F).shade(false).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(16.0F, 0.0F, 0.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(0.0F, 0.0F, 0.8F).to(16.0F, 16.0F, 0.8F).shade(false).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(16.0F, 0.0F, 0.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end();
	}
}
