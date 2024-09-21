package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PhysalisCropModel {

	public static void template0(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(4.0F, -1.0F, 8.0F).to(12.0F, 15.0F, 8.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 7.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 0.0F, 14.0F, 8.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 6.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, -1.0F, 8.0F).to(12.0F, 15.0F, 8.0F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 7.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 8.0F, 14.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 8.0F, 6.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 2.0F, 4.0F).to(12.0F, 2.0F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 2.0F, 8.0F, 4.0F).texture("#texture").end()
			.end();
	}

	public static void template1(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(4.0F, -1.0F, 8.0F).to(12.0F, 15.0F, 8.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 7.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 0.0F, 14.0F, 8.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 6.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, -1.0F, 8.0F).to(12.0F, 15.0F, 8.0F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 7.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 8.0F, 14.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 8.0F, 6.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, 3.0F, 4.0F).to(8.0F, 3.0F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(8.0F, 0.0F, 10.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 2.0F, 10.0F, 4.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 2.0F, 4.0F).to(12.0F, 2.0F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 2.0F, 8.0F, 4.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 6.0F, 8.0F).to(12.0F, 6.0F, 12.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(6.0F, 2.0F, 8.0F, 4.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").end()
			.end();
	}

	public static void template2(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(4.0F, -1.0F, 8.0F).to(12.0F, 15.0F, 8.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 7.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 0.0F, 14.0F, 8.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 6.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, -1.0F, 8.0F).to(12.0F, 15.0F, 8.0F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 7.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 8.0F, 14.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 8.0F, 6.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, 4.0F, 4.0F).to(8.0F, 4.0F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(8.0F, 0.0F, 10.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 2.0F, 10.0F, 4.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 2.0F, 4.0F).to(12.0F, 2.0F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 2.0F, 8.0F, 4.0F).texture("#texture").end()
			.end()
		.element().from(9.0F, 7.0F, 9.0F).to(13.0F, 7.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(6.0F, 2.0F, 8.0F, 4.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").end()
			.end()
		.element().from(6.0F, 2.0F, 9.0F).to(7.0F, 3.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 14.0F, 6.5F, 14.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 14.0F, 7.5F, 14.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 15.0F, 6.5F, 15.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 14.0F, 6.5F, 14.5F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0F, 15.0F, 6.5F, 15.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 7.0F, 6.5F, 7.5F).texture("#texture").end()
			.end()
		.element().from(9.0F, 4.0F, 6.0F).to(10.0F, 5.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 14.0F, 6.5F, 14.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 14.0F, 7.5F, 14.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 15.0F, 6.5F, 15.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 14.0F, 6.5F, 14.5F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0F, 15.0F, 6.5F, 15.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 7.0F, 6.5F, 7.5F).texture("#texture").end()
			.end()
		.element().from(6.33F, 8.0F, 6.33F).to(7.33F, 9.0F, 7.33F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 14.0F, 6.5F, 14.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 14.0F, 7.5F, 14.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 15.0F, 6.5F, 15.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 14.0F, 6.5F, 14.5F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0F, 15.0F, 6.5F, 15.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 7.0F, 6.5F, 7.5F).texture("#texture").end()
			.end();
	}

	public static void template3(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(4.0F, -1.0F, 8.0F).to(12.0F, 15.0F, 8.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 7.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 0.0F, 14.0F, 8.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 6.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, -1.0F, 8.0F).to(12.0F, 15.0F, 8.0F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 7.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 8.0F, 14.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 8.0F, 6.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, 5.0F, 4.0F).to(8.0F, 5.0F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(8.0F, 0.0F, 10.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 2.0F, 10.0F, 4.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 3.0F, 4.0F).to(12.0F, 3.0F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 2.0F, 8.0F, 4.0F).texture("#texture").end()
			.end()
		.element().from(9.0F, 7.0F, 9.0F).to(13.0F, 7.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(6.0F, 2.0F, 8.0F, 4.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").end()
			.end()
		.element().from(9.0F, 7.0F, 5.0F).to(11.0F, 7.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(7.0F, 0.0F, 8.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(7.0F, 3.0F, 8.0F, 4.0F).texture("#texture").end()
			.end()
		.element().from(5.0F, 2.0F, 9.0F).to(7.0F, 4.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 14.0F, 8.0F, 15.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 7.0F, 7.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(9.0F, 4.0F, 5.0F).to(11.0F, 6.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 14.0F, 8.0F, 15.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 7.0F, 7.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(5.33F, 9.0F, 5.33F).to(7.33F, 11.0F, 7.33F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 14.0F, 8.0F, 15.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 7.0F, 7.0F, 8.0F).texture("#texture").end()
			.end();
	}

	public static void template4(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(4.0F, -1.0F, 8.0F).to(12.0F, 15.0F, 8.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 7.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 0.0F, 14.0F, 8.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 6.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, -1.0F, 8.0F).to(12.0F, 15.0F, 8.0F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 7.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 8.0F, 14.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 8.0F, 6.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, 5.0F, 4.0F).to(8.0F, 5.0F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(8.0F, 0.0F, 10.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 2.0F, 10.0F, 4.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 3.0F, 4.0F).to(12.0F, 3.0F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 2.0F, 8.0F, 4.0F).texture("#texture").end()
			.end()
		.element().from(5.0F, 9.0F, 9.0F).to(7.0F, 9.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(7.0F, 0.0F, 8.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(7.0F, 4.0F, 8.0F, 5.0F).texture("#texture").end()
			.end()
		.element().from(9.0F, 7.0F, 9.0F).to(13.0F, 7.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(6.0F, 2.0F, 8.0F, 4.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").end()
			.end()
		.element().from(9.0F, 8.0F, 5.0F).to(11.0F, 8.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.UP).uvs(7.0F, 0.0F, 8.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(7.0F, 3.0F, 8.0F, 4.0F).texture("#texture").end()
			.end()
		.element().from(5.0F, 2.0F, 9.0F).to(7.0F, 4.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 14.0F, 8.0F, 15.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 7.0F, 7.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(9.0F, 5.0F, 5.0F).to(11.0F, 7.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 14.0F, 8.0F, 15.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 7.0F, 7.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(5.33F, 9.0F, 5.33F).to(7.33F, 11.0F, 7.33F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, -1.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 14.0F, 8.0F, 15.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 14.0F, 7.0F, 15.0F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0F, 15.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 7.0F, 7.0F, 8.0F).texture("#texture").end()
			.end();
	}
}