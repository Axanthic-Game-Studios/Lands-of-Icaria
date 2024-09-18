package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPortalModel {

	public static void x(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0000F, 0.0000F, 6.0000F).to(16.0000F, 16.0000F, 10.0000F).rotation().angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).end()
			.face(Direction.NORTH).uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture("#texture").end()
			.face(Direction.EAST).uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture("#texture").cullface(Direction.EAST).end()
			.face(Direction.SOUTH).uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture("#texture").cullface(Direction.WEST).end()
			.face(Direction.UP).uvs(0.0000F, 6.0000F, 16.0000F, 10.0000F).texture("#texture").cullface(Direction.UP).end()
			.face(Direction.DOWN).uvs(0.0000F, 6.0000F, 16.0000F, 10.0000F).texture("#texture").cullface(Direction.DOWN).end()
			.end();
	}

	public static void z(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(6.0000F, 0.0000F, 0.0000F).to(10.0000F, 16.0000F, 16.0000F).rotation().angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F).end()
			.face(Direction.NORTH).uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture("#texture").cullface(Direction.NORTH).end()
			.face(Direction.EAST).uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture("#texture").cullface(Direction.SOUTH).end()
			.face(Direction.WEST).uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture("#texture").cullface(Direction.UP).end()
			.face(Direction.DOWN).uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture("#texture").cullface(Direction.DOWN).end()
			.end();
	}
}
