package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCakeModel {

	public static void template0(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(1.0F, 0.0F, 1.0F).to(15.0F, 8.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 8.0F, 15.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.EAST).uvs(1.0F, 8.0F, 15.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.SOUTH).uvs(1.0F, 8.0F, 15.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.WEST).uvs(1.0F, 8.0F, 15.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.UP).uvs(1.0F, 1.0F, 15.0F, 15.0F).texture("#cake_top").end()
			.face(Direction.DOWN).uvs(1.0F, 1.0F, 15.0F, 15.0F).texture("#cake_bottom").end()
			.end();
	}

	public static void template1(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(5.0F, 0.0F, 5.0F).to(6.0F, 1.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.end()
		.element().from(8.0F, 0.0F, 1.0F).to(15.0F, 8.0F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 8.0F, 8.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.EAST).uvs(8.0F, 8.0F, 15.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.WEST).uvs(1.0F, 8.0F, 8.0F, 16.0F).texture("#cake_inside").end()
			.face(Direction.UP).uvs(8.0F, 1.0F, 15.0F, 8.0F).texture("#cake_top").end()
			.face(Direction.DOWN).uvs(8.0F, 8.0F, 15.0F, 15.0F).texture("#cake_bottom").end()
			.end()
		.element().from(1.0F, 0.0F, 8.0F).to(15.0F, 8.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(-7.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 8.0F, 15.0F, 16.0F).texture("#cake_inside").end()
			.face(Direction.EAST).uvs(1.0F, 8.0F, 8.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.SOUTH).uvs(1.0F, 8.0F, 15.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.WEST).uvs(8.0F, 8.0F, 15.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.UP).uvs(1.0F, 8.0F, 15.0F, 15.0F).texture("#cake_top").end()
			.face(Direction.DOWN).uvs(1.0F, 1.0F, 15.0F, 8.0F).texture("#cake_bottom").end()
			.end()
		.element().from(6.0F, 0.0F, 2.0F).to(7.0F, 1.0F, 3.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.end()
		.element().from(3.0F, 0.0F, 6.0F).to(4.0F, 1.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.end();
	}

	public static void template2(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(5.0F, 0.0F, 4.0F).to(6.0F, 1.0F, 5.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.end()
		.element().from(1.0F, 0.0F, 8.0F).to(15.0F, 8.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(-7.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 8.0F, 15.0F, 16.0F).texture("#cake_inside").end()
			.face(Direction.EAST).uvs(1.0F, 8.0F, 8.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.SOUTH).uvs(1.0F, 8.0F, 15.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.WEST).uvs(8.0F, 8.0F, 15.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.UP).uvs(1.0F, 8.0F, 15.0F, 15.0F).texture("#cake_top").end()
			.face(Direction.DOWN).uvs(1.0F, 1.0F, 15.0F, 8.0F).texture("#cake_bottom").end()
			.end()
		.element().from(13.0F, 0.0F, 6.0F).to(14.0F, 1.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.end()
		.element().from(3.0F, 0.0F, 5.0F).to(4.0F, 1.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.end()
		.element().from(9.0F, 0.0F, 5.0F).to(10.0F, 1.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.end();
	}

	public static void template3(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(6.0F, 0.0F, 5.0F).to(7.0F, 1.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(14.0F, 1.0F, 15.0F, 2.0F).texture("#cake_bottom").end()
			.end()
		.element().from(1.0F, 0.0F, 8.0F).to(8.0F, 8.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 8.0F, 15.0F, 16.0F).texture("#cake_inside").end()
			.face(Direction.EAST).uvs(1.0F, 8.0F, 8.0F, 16.0F).texture("#cake_inside").end()
			.face(Direction.SOUTH).uvs(1.0F, 8.0F, 8.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.WEST).uvs(8.0F, 8.0F, 15.0F, 16.0F).texture("#cake_side").end()
			.face(Direction.UP).uvs(1.0F, 8.0F, 8.0F, 15.0F).texture("#cake_top").end()
			.face(Direction.DOWN).uvs(1.0F, 1.0F, 8.0F, 8.0F).texture("#cake_bottom").end()
			.end()
		.element().from(10.0F, 0.0F, 12.0F).to(11.0F, 1.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 1.0F, 14.0F, 2.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.end()
		.element().from(2.0F, 0.0F, 6.0F).to(3.0F, 1.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 15.0F, 3.0F).texture("#cake_bottom").end()
			.end()
		.element().from(9.0F, 0.0F, 10.0F).to(10.0F, 1.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 1.0F, 14.0F, 2.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#cake_bottom").end()
			.face(Direction.EAST).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.SOUTH).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.WEST).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.UP).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.face(Direction.DOWN).uvs(13.0F, 1.0F, 14.0F, 2.0F).texture("#cake_bottom").end()
			.end();
	}
}
