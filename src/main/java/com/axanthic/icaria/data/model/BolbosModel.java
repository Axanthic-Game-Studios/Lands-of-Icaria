package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BolbosModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(10.0F, 0.0F, 8.5F).to(10.5F, 8.0F, 9.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 0.5F, 8.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 1.5F, 8.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 2.5F, 8.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(3.0F, 0.0F, 3.5F, 8.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 0.5F, 0.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 0.5F, 0.5F).texture("#texture").end()
			.end()
		.element().from(10.0F, 8.0F, 8.5F).to(10.5F, 14.0F, 9.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 0.5F, 6.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 1.5F, 6.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 2.5F, 6.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(3.0F, 0.0F, 3.5F, 6.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 0.5F, 0.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 0.5F, 0.5F).texture("#texture").end()
			.end()
		.element().from(7.0F, 0.1F, 11.0F).to(7.5F, 8.1F, 11.5F).rotation().angle(22.5F).axis(Direction.Axis.Z).origin(8.0F, 0.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 0.0F, 1.5F, 8.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 2.5F, 8.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 4.5F, 8.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 6.5F, 8.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 0.5F, 0.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 0.5F, 0.5F).texture("#texture").end()
			.end()
		.element().from(5.0F, 0.0F, 7.4F).to(5.5F, 8.0F, 7.9F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 0.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(7.0F, 0.0F, 7.5F, 8.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(4.0F, 0.0F, 4.5F, 8.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(5.0F, 0.0F, 5.5F, 8.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(1.0F, 0.0F, 1.5F, 8.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 0.5F, 0.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 0.5F, 0.5F).texture("#texture").end()
			.end()
		.element().from(5.0F, 8.0F, 7.4F).to(5.5F, 12.0F, 7.9F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 0.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 0.5F, 4.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 1.5F, 4.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 2.5F, 4.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(3.0F, 0.0F, 3.5F, 4.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 0.5F, 0.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 0.5F, 0.5F).texture("#texture").end()
			.end()
		.element().from(9.25F, 8.0F, 7.75F).to(11.25F, 8.0F, 9.75F).rotation().angle(22.5F).axis(Direction.Axis.X).origin(10.25F, 8.0F, 8.75F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 0.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 3.0F, 0.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 4.0F, 0.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(3.0F, 0.0F, 5.0F, 0.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 2.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 2.0F, 2.0F).texture("#texture").end()
			.end()
		.element().from(3.94F, 6.0F, 10.5F).to(5.44F, 6.0F, 12.0F).rotation().angle(45.0F).axis(Direction.Axis.Z).origin(4.75F, 6.0F, 11.25F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.5F, 0.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 2.5F, 0.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 3.5F, 0.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(3.0F, 0.0F, 4.5F, 0.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.end()
		.element().from(4.25F, 6.0F, 4.1F).to(6.25F, 6.0F, 6.1F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(5.25F, 6.0F, 5.1F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 0.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 3.0F, 0.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 4.0F, 0.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(3.0F, 0.0F, 5.0F, 0.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 2.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 2.0F, 2.0F).texture("#texture").end()
			.end()
		.element().from(8.75F, 13.5F, 7.25F).to(11.75F, 14.5F, 10.25F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(10.25F, 14.0F, 8.75F).end()
			.face(Direction.NORTH).uvs(8.0F, 8.0F, 11.0F, 9.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 9.0F, 11.0F, 10.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 10.0F, 11.0F, 11.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 11.0F, 12.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 8.0F, 11.0F, 11.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 8.0F, 11.0F, 11.0F).texture("#texture").end()
			.end()
		.element().from(9.75F, 12.5F, 7.25F).to(10.75F, 15.5F, 10.25F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(10.25F, 14.0F, 8.75F).end()
			.face(Direction.NORTH).uvs(8.0F, 8.0F, 9.0F, 11.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 9.0F, 11.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 10.0F, 9.0F, 13.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 11.0F, 14.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 8.0F, 9.0F, 11.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 8.0F, 9.0F, 11.0F).texture("#texture").end()
			.end()
		.element().from(8.75F, 12.5F, 8.25F).to(11.75F, 15.5F, 9.25F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(10.25F, 14.0F, 8.75F).end()
			.face(Direction.NORTH).uvs(8.0F, 8.0F, 11.0F, 11.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 9.0F, 9.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 10.0F, 11.0F, 13.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 9.0F, 14.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 8.0F, 11.0F, 9.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 8.0F, 11.0F, 9.0F).texture("#texture").end()
			.end()
		.element().from(9.25F, 13.0F, 7.75F).to(11.25F, 15.0F, 9.75F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 8.0F, 2.0F, 10.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 10.0F, 2.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 12.0F, 2.0F, 14.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 14.0F, 2.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(2.0F, 8.0F, 4.0F, 10.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(2.0F, 10.0F, 4.0F, 12.0F).texture("#texture").end()
			.end()
		.element().from(2.5F, 8.5F, 9.75F).to(5.5F, 9.5F, 12.75F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(4.0F, 9.0F, 11.25F).end()
			.face(Direction.NORTH).uvs(8.0F, 8.0F, 11.0F, 9.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 9.0F, 11.0F, 10.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 10.0F, 11.0F, 11.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 11.0F, 12.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 8.0F, 11.0F, 11.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 8.0F, 11.0F, 11.0F).texture("#texture").end()
			.end()
		.element().from(3.5F, 7.5F, 9.75F).to(4.5F, 10.5F, 12.75F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(4.0F, 9.0F, 11.25F).end()
			.face(Direction.NORTH).uvs(8.0F, 8.0F, 9.0F, 11.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 9.0F, 11.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 10.0F, 9.0F, 13.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 11.0F, 14.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 8.0F, 9.0F, 11.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 8.0F, 9.0F, 11.0F).texture("#texture").end()
			.end()
		.element().from(2.5F, 7.5F, 10.75F).to(5.5F, 10.5F, 11.75F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(4.0F, 9.0F, 11.25F).end()
			.face(Direction.NORTH).uvs(8.0F, 8.0F, 11.0F, 11.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 9.0F, 9.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 10.0F, 11.0F, 13.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 9.0F, 14.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 8.0F, 11.0F, 9.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 8.0F, 11.0F, 9.0F).texture("#texture").end()
			.end()
		.element().from(3.0F, 8.0F, 10.25F).to(5.0F, 10.0F, 12.25F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(2.0F, 12.0F, 4.0F, 14.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(2.0F, 14.0F, 4.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(4.0F, 8.0F, 6.0F, 10.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(4.0F, 10.0F, 6.0F, 12.0F).texture("#texture").end()
			.face(Direction.UP).uvs(4.0F, 12.0F, 6.0F, 14.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(4.0F, 14.0F, 6.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(3.75F, 12.0F, 1.6F).to(6.75F, 13.0F, 4.6F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(5.25F, 12.5F, 3.1F).end()
			.face(Direction.NORTH).uvs(8.0F, 8.0F, 11.0F, 9.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 9.0F, 11.0F, 10.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 10.0F, 11.0F, 11.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 11.0F, 12.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 8.0F, 11.0F, 11.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 8.0F, 11.0F, 11.0F).texture("#texture").end()
			.end()
		.element().from(4.75F, 11.0F, 1.6F).to(5.75F, 14.0F, 4.6F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(5.25F, 12.5F, 3.1F).end()
			.face(Direction.NORTH).uvs(8.0F, 8.0F, 9.0F, 11.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 9.0F, 11.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 10.0F, 9.0F, 13.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 11.0F, 14.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 8.0F, 9.0F, 11.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 8.0F, 9.0F, 11.0F).texture("#texture").end()
			.end()
		.element().from(3.75F, 11.0F, 2.6F).to(6.75F, 14.0F, 3.6F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(5.25F, 12.5F, 3.1F).end()
			.face(Direction.NORTH).uvs(8.0F, 8.0F, 11.0F, 11.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 9.0F, 9.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 10.0F, 11.0F, 13.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 9.0F, 14.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 8.0F, 11.0F, 9.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 8.0F, 11.0F, 9.0F).texture("#texture").end()
			.end()
		.element().from(4.25F, 11.5F, 2.1F).to(6.25F, 13.5F, 4.1F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 8.0F, 8.0F, 10.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(6.0F, 10.0F, 8.0F, 12.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 12.0F, 8.0F, 14.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 14.0F, 8.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 2.0F, 10.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 10.0F, 2.0F, 12.0F).texture("#texture").end()
			.end();
	}
}
