package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TwigsModel {

	public static void template0(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(7.5F, 0.0F, 3.0F).to(8.5F, 1.0F, 11.0F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 8.0F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 1.0F, 8.0F, 2.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 1.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(1.0F, 8.0F, 2.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 0.0F, 4.0F).to(8.5F, 0.5F, 8.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 12.5F, 11.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 2.0F, 4.0F, 2.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 11.5F, 11.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 3.0F, 4.0F, 3.5F).texture("#texture").end()
			.face(Direction.UP).uvs(2.0F, 8.0F, 2.5F, 12.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(3.0F, 8.0F, 3.5F, 12.0F).texture("#texture").end()
			.end()
		.element().from(6.7F, 0.0F, 5.0F).to(7.2F, 0.5F, 10.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 12.5F, 11.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 3.0F, 5.0F, 3.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 11.5F, 11.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 5.0F, 5.0F, 5.5F).texture("#texture").end()
			.face(Direction.UP).uvs(4.0F, 8.0F, 4.5F, 13.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(5.0F, 8.0F, 5.5F, 13.0F).texture("#texture").end()
			.end()
		.element().from(7.5F, 0.0F, 11.0F).to(8.5F, 1.0F, 13.0F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 2.0F, 2.0F, 3.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 3.0F, 2.0F, 4.0F).texture("#texture").end()
			.face(Direction.UP).uvs(2.0F, 8.0F, 3.0F, 10.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(3.0F, 8.0F, 4.0F, 10.0F).texture("#texture").end()
			.end();
	}

	public static void template1(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(8.5F, 0.0F, 3.0F).to(9.5F, 1.0F, 11.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 8.0F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 1.0F, 8.0F, 2.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 1.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(1.0F, 8.0F, 2.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(2.5F, 0.0F, 5.0F).to(3.5F, 1.0F, 9.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 2.0F, 4.0F, 3.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 3.0F, 4.0F, 4.0F).texture("#texture").end()
			.face(Direction.UP).uvs(2.0F, 8.0F, 3.0F, 12.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(3.0F, 8.0F, 4.0F, 12.0F).texture("#texture").end()
			.end()
		.element().from(2.5F, 0.0F, 11.0F).to(7.5F, 0.5F, 11.5F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 15.0F, 8.0F, 15.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(12.0F, 12.0F, 12.5F, 12.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(3.0F, 14.0F, 8.0F, 14.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 12.0F, 11.5F, 12.5F).texture("#texture").end()
			.face(Direction.UP).uvs(3.0F, 13.0F, 8.0F, 13.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(3.0F, 12.0F, 8.0F, 12.5F).texture("#texture").end()
			.end()
		.element().from(8.5F, 0.0F, 11.0F).to(9.5F, 1.0F, 15.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(4.0F, 2.0F, 8.0F, 3.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(4.0F, 3.0F, 8.0F, 4.0F).texture("#texture").end()
			.face(Direction.UP).uvs(7.0F, 8.0F, 8.0F, 12.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 8.0F, 7.0F, 12.0F).texture("#texture").end()
			.end()
		.element().from(5.0F, 0.0F, 10.5F).to(6.5F, 1.0F, 11.0F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 12.0F, 4.5F, 13.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 13.0F, 7.5F, 14.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(3.0F, 11.0F, 4.5F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(7.0F, 12.0F, 7.5F, 13.0F).texture("#texture").end()
			.face(Direction.UP).uvs(3.0F, 10.0F, 4.5F, 10.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(3.0F, 9.0F, 4.5F, 9.5F).texture("#texture").end()
			.end()
		.element().from(9.5F, 0.0F, 5.5F).to(10.0F, 0.5F, 7.5F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 1.0F, 8.5F, 1.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 1.0F, 11.0F, 1.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 1.0F, 10.5F, 1.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 1.0F, 13.0F, 1.5F).texture("#texture").end()
			.face(Direction.UP).uvs(12.0F, 1.0F, 12.5F, 3.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 1.0F, 13.5F, 3.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 0.0F, 11.0F).to(8.5F, 0.5F, 13.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 0.0F, 8.5F, 0.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 0.0F, 11.0F, 0.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 0.0F, 10.5F, 0.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 0.0F, 13.0F, 0.5F).texture("#texture").end()
			.face(Direction.UP).uvs(12.0F, 0.0F, 12.5F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 0.0F, 13.5F, 2.0F).texture("#texture").end()
			.end()
		.element().from(3.5F, 0.0F, 12.0F).to(4.5F, 0.5F, 12.5F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 2.0F, 9.0F, 2.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 2.0F, 9.5F, 2.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 2.0F, 11.0F, 2.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 2.0F, 11.5F, 2.5F).texture("#texture").end()
			.face(Direction.UP).uvs(12.0F, 2.0F, 13.0F, 2.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 2.0F, 14.0F, 2.5F).texture("#texture").end()
			.end()
		.element().from(3.5F, 0.0F, 5.5F).to(4.0F, 0.5F, 7.5F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 3.0F, 8.5F, 3.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 3.0F, 11.0F, 3.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 3.0F, 10.5F, 3.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 3.0F, 13.0F, 3.5F).texture("#texture").end()
			.face(Direction.UP).uvs(12.0F, 3.0F, 12.5F, 5.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 3.0F, 13.5F, 5.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, 0.0F, 6.0F).to(4.5F, 0.5F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 3.0F, 8.5F, 3.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 3.0F, 10.0F, 3.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 3.0F, 10.5F, 3.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 3.0F, 12.0F, 3.5F).texture("#texture").end()
			.face(Direction.UP).uvs(12.0F, 3.0F, 12.5F, 4.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 3.0F, 13.5F, 4.0F).texture("#texture").end()
			.end()
		.element().from(3.0F, 0.0F, 11.5F).to(5.0F, 0.5F, 12.0F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 2.0F, 10.0F, 2.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 2.0F, 9.5F, 2.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 2.0F, 12.0F, 2.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 2.0F, 11.5F, 2.5F).texture("#texture").end()
			.face(Direction.UP).uvs(12.0F, 2.0F, 14.0F, 2.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 2.0F, 15.0F, 2.5F).texture("#texture").end()
			.end()
		.element().from(7.5F, 0.0F, 11.5F).to(8.0F, 0.5F, 12.5F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 0.0F, 8.5F, 0.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 0.0F, 10.0F, 0.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 0.0F, 10.5F, 0.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 0.0F, 12.0F, 0.5F).texture("#texture").end()
			.face(Direction.UP).uvs(12.0F, 0.0F, 12.5F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 0.0F, 13.5F, 1.0F).texture("#texture").end()
			.end()
		.element().from(10.0F, 0.0F, 6.0F).to(10.5F, 0.5F, 7.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 1.0F, 8.5F, 1.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 1.0F, 10.0F, 1.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 1.0F, 10.5F, 1.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 1.0F, 12.0F, 1.5F).texture("#texture").end()
			.face(Direction.UP).uvs(12.0F, 1.0F, 12.5F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 1.0F, 13.5F, 2.0F).texture("#texture").end()
			.end();
	}

	public static void template2(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(5.0F, 0.0F, 3.0F).to(6.0F, 1.0F, 11.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 8.0F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 1.0F, 8.0F, 2.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 1.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(1.0F, 8.0F, 2.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(7.7F, 0.0F, 4.0F).to(12.7F, 1.0F, 5.0F).rotation().angle(-22.5F).axis(Direction.Axis.Z).origin(11.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 2.0F, 8.0F, 3.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(3.0F, 3.0F, 8.0F, 4.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.UP).uvs(3.0F, 4.0F, 8.0F, 5.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(3.0F, 5.0F, 8.0F, 6.0F).texture("#texture").end()
			.end()
		.element().from(7.0F, 0.0F, 5.0F).to(7.5F, 0.5F, 9.0F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 12.5F, 11.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 4.0F, 0.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 11.5F, 11.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 1.0F, 4.0F, 1.5F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 0.5F, 12.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(1.0F, 8.0F, 1.5F, 12.0F).texture("#texture").end()
			.end()
		.element().from(12.0F, 0.0F, 10.0F).to(13.0F, 1.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 1.0F, 3.0F, 2.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 1.0F, 11.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(1.0F, 8.0F, 2.0F, 11.0F).texture("#texture").end()
			.end()
		.element().from(4.5F, 0.0F, 4.0F).to(5.0F, 0.5F, 6.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 0.0F, 14.5F, 0.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 0.0F, 10.0F, 0.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(15.0F, 0.0F, 15.5F, 0.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(10.0F, 0.0F, 12.0F, 0.5F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 2.0F, 8.5F, 4.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 4.0F, 8.5F, 6.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, 0.0F, 4.5F).to(4.5F, 0.5F, 5.5F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 0.0F, 14.5F, 0.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 0.0F, 9.0F, 0.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(15.0F, 0.0F, 15.5F, 0.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(10.0F, 0.0F, 11.0F, 0.5F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 2.0F, 8.5F, 3.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 4.0F, 8.5F, 5.0F).texture("#texture").end()
			.end()
		.element().from(13.0F, 0.0F, 10.5F).to(13.5F, 0.5F, 12.5F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(9.0F, 0.0F, 9.5F, 0.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 1.0F, 10.0F, 1.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 0.0F, 8.5F, 0.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(10.0F, 1.0F, 12.0F, 1.5F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 6.0F, 8.5F, 8.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(9.0F, 6.0F, 9.5F, 8.0F).texture("#texture").end()
			.end()
		.element().from(13.5F, 0.0F, 11.0F).to(14.0F, 0.5F, 12.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(9.0F, 0.0F, 9.5F, 0.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 1.0F, 9.0F, 1.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 0.0F, 8.5F, 0.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(10.0F, 1.0F, 11.0F, 1.5F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 6.0F, 8.5F, 7.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(9.0F, 6.0F, 9.5F, 7.0F).texture("#texture").end()
			.end()
		.element().from(6.5F, 0.0F, 9.0F).to(8.0F, 0.5F, 9.5F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(11.0F, 7.0F, 12.5F, 7.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 2.0F, 9.5F, 2.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 6.0F, 12.5F, 6.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 2.0F, 8.5F, 2.5F).texture("#texture").end()
			.face(Direction.UP).uvs(11.0F, 5.0F, 12.5F, 5.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(11.0F, 4.0F, 12.5F, 4.5F).texture("#texture").end()
			.end()
		.element().from(7.0F, 0.0F, 9.5F).to(7.5F, 0.5F, 10.0F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(11.0F, 7.0F, 11.5F, 7.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 2.0F, 9.5F, 2.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 6.0F, 11.5F, 6.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 2.0F, 8.5F, 2.5F).texture("#texture").end()
			.face(Direction.UP).uvs(11.0F, 5.0F, 11.5F, 5.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(11.0F, 4.0F, 11.5F, 4.5F).texture("#texture").end()
			.end()
		.element().from(7.0F, 0.5F, 9.0F).to(7.5F, 1.0F, 9.5F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 7.0F, 13.5F, 7.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(11.0F, 2.0F, 11.5F, 2.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(13.0F, 6.0F, 13.5F, 6.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(10.0F, 2.0F, 10.5F, 2.5F).texture("#texture").end()
			.face(Direction.UP).uvs(13.0F, 5.0F, 13.5F, 5.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 4.0F, 13.5F, 4.5F).texture("#texture").end()
			.end();
	}

	public static void template3(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(7.5F, 0.0F, 3.0F).to(8.5F, 1.0F, 9.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 6.0F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 1.0F, 6.0F, 2.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 1.0F, 14.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(1.0F, 8.0F, 2.0F, 14.0F).texture("#texture").end()
			.end()
		.element().from(7.2F, 0.0F, 8.7F).to(8.2F, 1.0F, 13.7F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 2.0F, 5.0F, 3.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 3.0F, 5.0F, 4.0F).texture("#texture").end()
			.face(Direction.UP).uvs(2.0F, 8.0F, 3.0F, 13.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(3.0F, 8.0F, 4.0F, 13.0F).texture("#texture").end()
			.end()
		.element().from(7.0F, 1.4F, 8.3F).to(14.5F, 2.4F, 9.3F).rotation().angle(-22.5F).axis(Direction.Axis.Z).origin(7.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 11.0F, 7.5F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(11.0F, 10.0F, 12.0F, 11.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 11.0F, 7.5F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(10.0F, 10.0F, 11.0F, 11.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 7.5F, 9.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 8.0F, 7.5F, 9.0F).texture("#texture").end()
			.end()
		.element().from(6.5F, 0.0F, 6.0F).to(7.0F, 0.5F, 10.0F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 12.5F, 11.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 4.0F, 4.0F, 4.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 11.5F, 11.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 5.0F, 4.0F, 5.5F).texture("#texture").end()
			.face(Direction.UP).uvs(4.0F, 8.0F, 4.5F, 12.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(5.0F, 8.0F, 5.5F, 12.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 0.0F, 4.0F).to(8.5F, 0.5F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 12.5F, 11.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 2.0F, 3.0F, 2.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 11.5F, 11.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 3.0F, 3.0F, 3.5F).texture("#texture").end()
			.face(Direction.UP).uvs(2.0F, 8.0F, 2.5F, 11.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(3.0F, 8.0F, 3.5F, 11.0F).texture("#texture").end()
			.end()
		.element().from(4.0F, 0.0F, 7.0F).to(4.5F, 0.5F, 11.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 12.5F, 11.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 5.0F, 4.0F, 5.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 11.5F, 11.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 6.0F, 4.0F, 6.5F).texture("#texture").end()
			.face(Direction.UP).uvs(5.0F, 8.0F, 5.5F, 12.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 8.0F, 6.5F, 12.0F).texture("#texture").end()
			.end()
		.element().from(9.5F, 0.0F, 9.5F).to(10.0F, 0.5F, 12.5F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 12.5F, 11.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 5.0F, 3.0F, 5.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 11.5F, 11.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 6.0F, 3.0F, 6.5F).texture("#texture").end()
			.face(Direction.UP).uvs(5.0F, 9.0F, 5.5F, 12.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 9.0F, 6.5F, 12.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 1.4F, 7.8F).to(10.0F, 1.9F, 8.3F).rotation().angle(-22.5F).axis(Direction.Axis.Z).origin(7.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 7.0F, 10.0F, 7.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(12.0F, 3.0F, 12.5F, 3.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 7.0F, 12.0F, 7.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 4.0F, 11.5F, 4.5F).texture("#texture").end()
			.face(Direction.UP).uvs(12.0F, 7.0F, 14.0F, 7.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 7.0F, 15.0F, 7.5F).texture("#texture").end()
			.end()
		.element().from(8.5F, 1.4F, 7.3F).to(9.5F, 1.9F, 7.8F).rotation().angle(-22.5F).axis(Direction.Axis.Z).origin(7.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 3.0F, 9.0F, 3.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(12.0F, 6.0F, 12.5F, 6.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 6.0F, 11.0F, 6.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 3.0F, 11.5F, 3.5F).texture("#texture").end()
			.face(Direction.UP).uvs(12.0F, 6.0F, 13.0F, 6.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(14.0F, 3.0F, 15.0F, 3.5F).texture("#texture").end()
			.end();
	}

	public static void template4(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(12.5F, 0.0F, 5.0F).to(13.5F, 1.0F, 9.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 4.0F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 1.0F, 4.0F, 2.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 1.0F, 12.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(1.0F, 8.0F, 2.0F, 12.0F).texture("#texture").end()
			.end()
		.element().from(2.5F, 0.0F, 4.0F).to(3.5F, 1.0F, 10.0F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 11.0F, 13.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 2.0F, 6.0F, 3.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 11.0F, 12.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 3.0F, 6.0F, 4.0F).texture("#texture").end()
			.face(Direction.UP).uvs(2.0F, 8.0F, 3.0F, 14.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(3.0F, 8.0F, 4.0F, 14.0F).texture("#texture").end()
			.end()
		.element().from(7.5F, 0.0F, 11.0F).to(15.0F, 1.0F, 12.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 7.0F, 7.5F, 8.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(12.0F, 12.0F, 13.0F, 13.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 6.0F, 7.5F, 7.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 12.0F, 12.0F, 13.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 7.5F, 9.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 9.0F, 7.5F, 10.0F).texture("#texture").end()
			.end()
		.element().from(9.5F, 0.0F, 9.0F).to(10.0F, 0.5F, 12.5F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 14.0F, 12.5F, 14.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 3.0F, 3.5F, 3.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 15.0F, 11.5F, 15.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 4.0F, 3.5F, 4.5F).texture("#texture").end()
			.face(Direction.UP).uvs(4.0F, 8.0F, 4.5F, 11.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 9.0F, 6.5F, 12.5F).texture("#texture").end()
			.end()
		.element().from(5.5F, 0.0F, 3.0F).to(6.0F, 0.5F, 8.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 13.0F, 12.5F, 13.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 4.0F, 5.0F, 4.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 15.0F, 11.5F, 15.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 7.0F, 5.0F, 7.5F).texture("#texture").end()
			.face(Direction.UP).uvs(5.0F, 8.0F, 5.5F, 13.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(7.0F, 9.0F, 7.5F, 14.0F).texture("#texture").end()
			.end()
		.element().from(5.5F, 0.0F, 10.0F).to(9.0F, 0.5F, 10.5F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 13.0F, 3.5F, 13.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(12.0F, 12.0F, 12.5F, 12.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 11.0F, 3.5F, 11.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 12.0F, 11.5F, 12.5F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 12.0F, 3.5F, 12.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 13.0F, 3.5F, 13.5F).texture("#texture").end()
			.end()
		.element().from(7.7F, 0.0F, 12.9F).to(12.2F, 0.5F, 13.4F).rotation().angle(22.5F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 7.0F, 4.5F, 7.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(12.0F, 12.0F, 12.5F, 12.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 6.0F, 4.5F, 6.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(11.0F, 12.0F, 11.5F, 12.5F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 4.5F, 8.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 9.0F, 4.5F, 9.5F).texture("#texture").end()
			.end()
		.element().from(2.0F, 0.0F, 7.0F).to(2.5F, 0.5F, 9.0F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 4.0F, 12.5F, 4.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(9.0F, 5.0F, 11.0F, 5.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(11.0F, 5.0F, 11.5F, 5.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(10.0F, 5.0F, 12.0F, 5.5F).texture("#texture").end()
			.face(Direction.UP).uvs(11.0F, 5.0F, 11.5F, 7.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 14.5F, 4.0F).texture("#texture").end()
			.end()
		.element().from(1.5F, 0.0F, 7.5F).to(2.0F, 0.5F, 8.5F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 4.0F, 14.5F, 4.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(11.0F, 5.0F, 12.0F, 5.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(14.0F, 5.0F, 14.5F, 5.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(12.0F, 5.0F, 13.0F, 5.5F).texture("#texture").end()
			.face(Direction.UP).uvs(13.0F, 5.0F, 13.5F, 6.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(15.0F, 2.0F, 15.5F, 3.0F).texture("#texture").end()
			.end();
	}
}
