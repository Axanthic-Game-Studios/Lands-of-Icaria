package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MondanosModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(6.5F, 0.0F, 7.5F).to(9.5F, 1.0F, 10.5F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 3.0F, 3.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 3.0F, 3.0F).texture("#texture").end()
			.end()
		.element().from(7.0F, 0.4F, 8.0F).to(9.0F, 8.4F, 10.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 1.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 8.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 2.0F, 8.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 2.0F, 8.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 2.0F, 8.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 2.0F, 2.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 2.0F, 2.0F).texture("#texture").end()
			.end()
		.element().from(9.3F, 5.0F, 6.7F).to(13.3F, 6.5F, 8.2F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 4.0F, 1.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 4.0F, 1.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 4.0F, 1.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 4.0F, 1.5F).texture("#texture").end()
			.end()
		.element().from(3.3F, 4.0F, 7.3F).to(9.3F, 5.5F, 8.8F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 6.0F, 1.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 6.0F, 1.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 6.0F, 1.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 6.0F, 1.5F).texture("#texture").end()
			.end()
		.element().from(3.5F, 6.1F, 5.9F).to(7.5F, 7.6F, 7.4F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 4.0F, 1.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 4.0F, 1.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 4.0F, 1.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 4.0F, 1.5F).texture("#texture").end()
			.end()
		.element().from(6.5F, 4.5F, 7.0F).to(11.5F, 6.0F, 8.5F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 5.0F, 1.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 5.0F, 1.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 5.0F, 1.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 5.0F, 1.5F).texture("#texture").end()
			.end()
		.element().from(8.8F, 3.0F, 5.1F).to(10.8F, 4.0F, 6.1F).rotation().angle(45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 1.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 2.0F, 1.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 2.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 2.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(3.9F, 3.5F, 7.9F).to(4.9F, 4.5F, 10.9F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 3.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 3.0F).texture("#texture").end()
			.end()
		.element().from(4.1F, 4.6F, 4.7F).to(7.1F, 5.6F, 5.7F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(10.3F, 4.8F, 7.3F).to(11.3F, 5.8F, 9.8F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 2.5F, 1.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 2.5F, 1.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 2.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 2.5F).texture("#texture").end()
			.end()
		.element().from(7.25F, 7.4F, 11.0F).to(8.75F, 10.4F, 12.5F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 1.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.5F, 3.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 1.5F, 3.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 1.5F, 3.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.5F, 3.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").end()
			.end()
		.element().from(7.5F, 10.3F, 7.5F).to(8.5F, 12.3F, 8.5F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 1.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.0F, 2.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 1.0F, 2.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 1.0F, 2.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.0F, 2.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#texture").end()
			.end()
		.element().from(10.8F, 2.5F, 4.6F).to(11.8F, 4.5F, 6.6F).rotation().angle(45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 0.0F, 9.0F, 2.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(8.0F, 2.0F, 10.0F, 4.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(8.0F, 2.0F, 9.0F, 4.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 0.0F, 10.0F, 2.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 4.0F, 9.0F, 6.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 6.0F, 9.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(11.8F, 2.25F, 4.35F).to(14.3F, 4.75F, 6.85F).rotation().angle(45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 8.0F, 2.5F, 10.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 10.5F, 2.5F, 13.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 13.0F, 2.5F, 15.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(2.5F, 8.0F, 5.0F, 10.5F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 2.5F, 10.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 8.0F, 2.5F, 10.5F).texture("#texture").end()
			.end()
		.element().from(3.15F, 2.75F, 10.9F).to(5.65F, 5.25F, 12.4F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 8.0F, 2.5F, 10.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 8.0F, 1.5F, 10.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 8.0F, 2.5F, 10.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 10.5F, 1.5F, 13.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 13.0F, 2.5F, 14.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(2.5F, 8.0F, 5.0F, 9.5F).texture("#texture").end()
			.end()
		.element().from(2.9F, 2.5F, 12.4F).to(5.9F, 5.5F, 15.4F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 0.0F, 13.0F, 3.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(13.0F, 0.0F, 16.0F, 3.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 3.0F, 13.0F, 6.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(13.0F, 3.5F, 16.0F, 6.5F).texture("#texture").end()
			.face(Direction.UP).uvs(10.0F, 0.0F, 13.0F, 3.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(10.5F, 0.0F, 13.5F, 3.0F).texture("#texture").end()
			.end()
		.element().from(3.1F, 4.1F, 4.2F).to(4.1F, 6.1F, 6.2F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 8.0F, 7.0F, 10.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(6.0F, 8.0F, 8.0F, 10.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 10.0F, 7.0F, 12.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 8.0F, 8.0F, 10.0F).texture("#texture").end()
			.face(Direction.UP).uvs(6.0F, 12.0F, 7.0F, 14.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(6.0F, 14.0F, 7.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(0.6F, 3.85F, 3.949F).to(3.1F, 6.35F, 6.449F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 6.0F, 15.5F, 8.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(13.0F, 8.5F, 15.5F, 11.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(13.0F, 11.0F, 15.5F, 13.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(13.0F, 13.5F, 15.5F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(13.0F, 6.0F, 15.5F, 8.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 8.0F, 2.5F, 10.5F).texture("#texture").end()
			.end()
		.element().from(9.8F, 4.3F, 9.8F).to(11.8F, 6.3F, 11.3F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 14.0F, 8.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(6.5F, 8.0F, 8.0F, 10.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(6.0F, 8.0F, 8.0F, 10.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(8.0F, 2.0F, 9.5F, 4.0F).texture("#texture").end()
			.face(Direction.UP).uvs(8.0F, 4.0F, 10.0F, 5.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(8.0F, 6.5F, 10.0F, 8.0F).texture("#texture").end()
			.end()
		.element().from(9.55F, 4.051F, 11.3F).to(12.05F, 6.551F, 13.8F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 10.0F, 2.5F, 12.5F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 8.0F, 2.5F, 10.5F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 13.0F, 2.5F, 15.5F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 13.0F, 2.5F, 15.5F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 2.5F, 10.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 10.5F, 2.5F, 13.0F).texture("#texture").end()
			.end()
		.element().from(6.75F, 12.3F, 6.75F).to(9.25F, 14.3F, 9.25F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 1.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 9.0F, 15.5F, 11.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 11.0F, 2.5F, 13.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(13.0F, 9.0F, 15.5F, 11.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 11.0F, 2.5F, 13.0F).texture("#texture").end()
			.face(Direction.UP).uvs(13.0F, 6.0F, 15.5F, 8.5F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 11.0F, 15.5F, 13.5F).texture("#texture").end()
			.end()
		.element().from(6.5F, 14.3F, 6.5F).to(9.5F, 17.3F, 9.5F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 1.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 0.0F, 13.0F, 3.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(13.0F, 0.0F, 16.0F, 3.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(10.0F, 3.0F, 13.0F, 6.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(13.0F, 3.0F, 16.0F, 6.0F).texture("#texture").end()
			.face(Direction.UP).uvs(10.0F, 3.0F, 13.0F, 6.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(13.0F, 0.0F, 16.0F, 3.0F).texture("#texture").end()
			.end();
	}
}
