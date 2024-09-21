package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class NamdrakeModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(7.25F, 0.0F, 7.25F).to(8.75F, 16.0F, 8.75F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.5F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 3.5F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 5.5F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 7.5F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.end()
		.element().from(7.5F, 4.0F, 11.5F).to(8.5F, 10.0F, 12.5F).rotation().angle(45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.0F, 6.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 3.0F, 6.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 5.0F, 6.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 7.0F, 6.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(7.5F, 7.0F, 8.5F).to(8.5F, 16.0F, 9.5F).rotation().angle(45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 7.0F, 1.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(2.0F, 7.0F, 3.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(4.0F, 7.0F, 5.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 7.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(7.5F, 9.5F, 6.0F).to(8.5F, 16.5F, 7.0F).rotation().angle(45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 4.0F, 1.0F, 11.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(2.0F, 5.0F, 3.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(4.0F, 5.0F, 5.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 5.0F, 7.0F, 12.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(7.5F, 3.5F, 3.0F).to(8.5F, 10.5F, 4.0F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(7.0F, 0.0F, 8.0F, 7.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(6.0F, 0.0F, 7.0F, 7.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(5.0F, 0.0F, 6.0F, 7.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(4.0F, 0.0F, 5.0F, 7.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(7.5F, 6.0F, 5.5F).to(8.5F, 15.0F, 6.5F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 0.0F, 4.0F, 9.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 3.0F, 9.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(1.0F, 0.0F, 2.0F, 9.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.0F, 9.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(7.5F, 10.5F, 10.0F).to(8.5F, 15.5F, 11.0F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 11.0F, 1.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(1.0F, 11.0F, 2.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 11.0F, 3.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(3.0F, 11.0F, 4.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(12.5F, 3.5F, 7.5F).to(13.5F, 8.5F, 8.5F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.0F, 5.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(7.0F, 0.0F, 8.0F, 5.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(7.0F, 11.0F, 8.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 11.0F, 1.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(10.0F, 6.0F, 7.5F).to(11.0F, 13.0F, 8.5F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 0.0F, 7.0F, 7.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(6.0F, 9.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(1.0F, 9.0F, 2.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(1.0F, 0.0F, 2.0F, 7.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 8.0F, 7.5F).to(9.0F, 16.0F, 8.5F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 8.0F, 6.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(2.0F, 8.0F, 3.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 3.0F, 8.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(5.0F, 0.0F, 6.0F, 8.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(4.5F, 11.5F, 7.5F).to(5.5F, 15.5F, 8.5F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 12.0F, 4.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(3.0F, 0.0F, 4.0F, 4.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 5.0F, 4.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(4.0F, 12.0F, 5.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(3.0F, 3.5F, 7.5F).to(4.0F, 11.5F, 8.5F).rotation().angle(45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 4.0F, 4.0F, 12.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(2.0F, 4.0F, 3.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(1.0F, 4.0F, 2.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 4.0F, 1.0F, 12.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(5.5F, 6.5F, 7.5F).to(6.5F, 12.5F, 8.5F).rotation().angle(45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(7.0F, 4.0F, 8.0F, 10.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(6.0F, 4.0F, 7.0F, 10.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(5.0F, 4.0F, 6.0F, 10.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(4.0F, 4.0F, 5.0F, 10.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(8.5F, 9.0F, 7.5F).to(9.5F, 16.0F, 8.5F).rotation().angle(45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(4.0F, 0.0F, 5.0F, 7.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(4.0F, 9.0F, 5.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(5.0F, 9.0F, 6.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(5.0F, 0.0F, 6.0F, 7.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end();
	}
}