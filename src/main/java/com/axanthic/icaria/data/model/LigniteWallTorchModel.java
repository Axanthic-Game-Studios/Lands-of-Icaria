package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LigniteWallTorchModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(7.0F, 0.0F, 11.5F).to(9.0F, 1.0F, 14.5F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(4.0F, 15.0F, 2.0F, 16.0F).texture("#torch_bone").end()
			.face(Direction.EAST).uvs(12.0F, 15.0F, 9.0F, 16.0F).texture("#torch_bone").end()
			.face(Direction.SOUTH).uvs(9.0F, 15.0F, 7.0F, 16.0F).texture("#torch_bone").end()
			.face(Direction.WEST).uvs(7.0F, 15.0F, 4.0F, 16.0F).texture("#torch_bone").end()
			.face(Direction.UP).uvs(0.0F, 3.0F, 2.0F, 0.0F).texture("#torch_bone").end()
			.face(Direction.DOWN).uvs(0.0F, 3.0F, 2.0F, 0.0F).texture("#torch_bone").end()
			.end()
		.element().from(6.5F, 0.0F, 12.0F).to(7.0F, 1.0F, 14.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(3.5F, 15.0F, 3.0F, 16.0F).texture("#torch_bone").end()
			.face(Direction.SOUTH).uvs(7.5F, 15.0F, 7.0F, 16.0F).texture("#torch_bone").end()
			.face(Direction.WEST).uvs(6.0F, 15.0F, 4.0F, 16.0F).texture("#torch_bone").end()
			.face(Direction.UP).uvs(0.0F, 2.0F, 0.5F, 0.0F).texture("#torch_bone").end()
			.face(Direction.DOWN).uvs(0.0F, 2.0F, 0.5F, 0.0F).texture("#torch_bone").end()
			.end()
		.element().from(9.0F, 0.0F, 12.0F).to(9.5F, 1.0F, 14.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(3.5F, 15.0F, 3.0F, 16.0F).texture("#torch_bone").end()
			.face(Direction.EAST).uvs(14.0F, 15.0F, 12.0F, 16.0F).texture("#torch_bone").end()
			.face(Direction.SOUTH).uvs(5.5F, 15.0F, 5.0F, 16.0F).texture("#torch_bone").end()
			.face(Direction.UP).uvs(0.0F, 2.0F, 0.5F, 0.0F).texture("#torch_bone").end()
			.face(Direction.DOWN).uvs(0.0F, 2.0F, 0.5F, 0.0F).texture("#torch_bone").end()
			.end()
		.element().from(7.0F, 1.0F, 12.0F).to(9.0F, 8.0F, 14.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(11.0F, 8.0F, 9.0F, 15.0F).texture("#torch_bone").end()
			.face(Direction.EAST).uvs(9.0F, 8.0F, 7.0F, 15.0F).texture("#torch_bone").end()
			.face(Direction.SOUTH).uvs(7.0F, 8.0F, 5.0F, 15.0F).texture("#torch_bone").end()
			.face(Direction.WEST).uvs(13.0F, 8.0F, 11.0F, 15.0F).texture("#torch_bone").end()
			.end()
		.element().from(7.0F, 8.0F, 11.5F).to(9.0F, 9.0F, 14.5F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(4.0F, 7.0F, 2.0F, 8.0F).texture("#torch_bone").end()
			.face(Direction.EAST).uvs(12.0F, 7.0F, 9.0F, 8.0F).texture("#torch_bone").end()
			.face(Direction.SOUTH).uvs(9.0F, 7.0F, 7.0F, 8.0F).texture("#torch_bone").end()
			.face(Direction.WEST).uvs(7.0F, 7.0F, 4.0F, 8.0F).texture("#torch_bone").end()
			.face(Direction.UP).uvs(3.0F, 16.0F, 5.0F, 13.0F).texture("#torch_bone").end()
			.face(Direction.DOWN).uvs(0.0F, 3.0F, 2.0F, 0.0F).texture("#torch_bone").end()
			.end()
		.element().from(6.5F, 8.0F, 12.0F).to(7.0F, 9.0F, 14.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(3.5F, 7.0F, 3.0F, 8.0F).texture("#torch_bone").end()
			.face(Direction.SOUTH).uvs(7.5F, 7.0F, 7.0F, 8.0F).texture("#torch_bone").end()
			.face(Direction.WEST).uvs(6.0F, 7.0F, 4.0F, 8.0F).texture("#torch_bone").end()
			.face(Direction.UP).uvs(0.0F, 2.0F, 0.5F, 0.0F).texture("#torch_bone").end()
			.face(Direction.DOWN).uvs(0.0F, 2.0F, 0.5F, 0.0F).texture("#torch_bone").end()
			.end()
		.element().from(9.0F, 8.0F, 12.0F).to(9.5F, 9.0F, 14.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(3.5F, 7.0F, 3.0F, 8.0F).texture("#torch_bone").end()
			.face(Direction.EAST).uvs(14.0F, 7.0F, 12.0F, 8.0F).texture("#torch_bone").end()
			.face(Direction.SOUTH).uvs(5.5F, 7.0F, 5.0F, 8.0F).texture("#torch_bone").end()
			.face(Direction.UP).uvs(0.0F, 2.0F, 0.5F, 0.0F).texture("#torch_bone").end()
			.face(Direction.DOWN).uvs(0.0F, 2.0F, 0.5F, 0.0F).texture("#torch_bone").end()
			.end()
		.element().from(7.0F, 9.0F, 12.0F).to(9.0F, 10.0F, 14.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 4.0F, 12.0F, 5.0F).texture("#torch_coal").end()
			.face(Direction.EAST).uvs(14.0F, 2.0F, 12.0F, 3.0F).texture("#torch_coal").end()
			.face(Direction.SOUTH).uvs(14.0F, 0.0F, 12.0F, 1.0F).texture("#torch_coal").end()
			.face(Direction.WEST).uvs(14.0F, 6.0F, 12.0F, 7.0F).texture("#torch_coal").end()
			.end()
		.element().from(7.0F, 10.0F, 12.0F).to(9.0F, 11.0F, 14.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(7.0F, 12.0F, 5.0F, 13.0F).texture("#torch_coal").end()
			.face(Direction.EAST).uvs(7.0F, 10.0F, 5.0F, 11.0F).texture("#torch_coal").end()
			.face(Direction.SOUTH).uvs(7.0F, 8.0F, 5.0F, 9.0F).texture("#torch_coal").end()
			.face(Direction.WEST).uvs(7.0F, 14.0F, 5.0F, 15.0F).texture("#torch_coal").end()
			.face(Direction.UP).uvs(1.0F, 11.0F, 3.0F, 9.0F).texture("#torch_coal").end()
			.end()
		.element().from(6.0F, -1.0F, 11.0F).to(10.0F, 0.0F, 14.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 15.0F, 2.0F, 16.0F).texture("#torch_metal").end()
			.face(Direction.EAST).uvs(12.0F, 15.0F, 9.0F, 16.0F).texture("#torch_metal").end()
			.face(Direction.SOUTH).uvs(11.0F, 15.0F, 7.0F, 16.0F).texture("#torch_metal").end()
			.face(Direction.WEST).uvs(7.0F, 15.0F, 4.0F, 16.0F).texture("#torch_metal").end()
			.face(Direction.UP).uvs(0.0F, 3.0F, 4.0F, 0.0F).texture("#torch_metal").end()
			.face(Direction.DOWN).uvs(0.0F, 3.0F, 4.0F, 0.0F).texture("#torch_metal").end()
			.end()
		.element().from(6.0F, 8.0F, 11.0F).to(10.0F, 9.0F, 12.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 16.0F).end()
			.face(Direction.NORTH).uvs(9.0F, 13.0F, 5.0F, 14.0F).texture("#torch_metal").end()
			.face(Direction.EAST).uvs(13.0F, 10.0F, 12.0F, 11.0F).texture("#torch_metal").end()
			.face(Direction.SOUTH).uvs(11.0F, 3.0F, 7.0F, 4.0F).texture("#torch_metal").end()
			.face(Direction.WEST).uvs(7.0F, 11.0F, 6.0F, 12.0F).texture("#torch_metal").end()
			.face(Direction.UP).uvs(6.0F, 3.0F, 10.0F, 2.0F).texture("#torch_metal").end()
			.face(Direction.DOWN).uvs(6.0F, 3.0F, 10.0F, 2.0F).texture("#torch_metal").end()
			.end()
		.element().from(6.0F, 8.0F, 12.0F).to(7.0F, 9.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 16.0F).end()
			.face(Direction.EAST).uvs(13.0F, 13.0F, 9.0F, 14.0F).texture("#torch_metal").end()
			.face(Direction.SOUTH).uvs(8.0F, 13.0F, 7.0F, 14.0F).texture("#torch_metal").end()
			.face(Direction.WEST).uvs(8.0F, 13.0F, 4.0F, 14.0F).texture("#torch_metal").end()
			.face(Direction.UP).uvs(3.0F, 5.0F, 4.0F, 1.0F).texture("#torch_metal").end()
			.face(Direction.DOWN).uvs(4.0F, 7.0F, 5.0F, 3.0F).texture("#torch_metal").end()
			.end()
		.element().from(9.0F, 8.0F, 12.0F).to(10.0F, 9.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 16.0F).end()
			.face(Direction.EAST).uvs(7.0F, 11.0F, 3.0F, 12.0F).texture("#torch_metal").end()
			.face(Direction.SOUTH).uvs(10.0F, 14.0F, 9.0F, 15.0F).texture("#torch_metal").end()
			.face(Direction.WEST).uvs(5.0F, 11.0F, 1.0F, 12.0F).texture("#torch_metal").end()
			.face(Direction.UP).uvs(7.0F, 8.0F, 8.0F, 4.0F).texture("#torch_metal").end()
			.face(Direction.DOWN).uvs(8.0F, 5.0F, 9.0F, 1.0F).texture("#torch_metal").end()
			.end();
	}
}
