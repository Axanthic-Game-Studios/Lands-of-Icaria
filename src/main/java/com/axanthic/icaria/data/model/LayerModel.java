package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LayerModel {

	public static void template0(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 2.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 14.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 14.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 14.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 14.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end();
	}

	public static void template1(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 4.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 12.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 12.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 12.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 12.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end();
	}

	public static void template2(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 6.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 10.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 10.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 10.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 10.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end();
	}

	public static void template3(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 8.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 8.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 8.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 8.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 8.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end();
	}

	public static void template4(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 10.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 6.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 6.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 6.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 6.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end();
	}

	public static void template5(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 12.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 4.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 4.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 4.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 4.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end();
	}

	public static void template6(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 14.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 2.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 2.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 2.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 2.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end();
	}

	public static void template7(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end();
	}
}
