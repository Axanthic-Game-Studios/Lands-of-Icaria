package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CalciteCrystalModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(7.0F, 0.0F, 7.0F).to(9.0F, 10.0F, 9.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 0.0F, 6.0F, 5.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(6.0F, 0.0F, 7.0F, 5.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(7.0F, 0.0F, 8.0F, 5.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(8.0F, 0.0F, 9.0F, 5.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(9.0F, 0.0F, 10.0F, 1.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(9.0F, 0.0F, 10.0F, 1.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(8.0F, 0.5F, 3.0F).to(10.0F, 12.5F, 5.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 0.0F, 11.0F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(11.0F, 0.0F, 12.0F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(12.0F, 0.0F, 13.0F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(13.0F, 0.0F, 14.0F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(14.0F, 0.0F, 15.0F, 1.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(14.0F, 0.0F, 15.0F, 1.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(6.0F, 2.5F, 0.0F).to(8.0F, 10.5F, 2.0F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.0F, 4.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 2.0F, 4.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 3.0F, 4.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(3.0F, 0.0F, 4.0F, 4.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(4.0F, 0.0F, 5.0F, 1.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(4.0F, 0.0F, 5.0F, 1.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(6.0F, 0.5F, 11.0F).to(8.0F, 8.5F, 13.0F).rotation().angle(22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 7.0F, 11.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(11.0F, 7.0F, 12.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(12.0F, 7.0F, 13.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(13.0F, 7.0F, 14.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(14.0F, 7.0F, 15.0F, 8.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(14.0F, 7.0F, 15.0F, 8.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(9.0F, 1.5F, 13.0F).to(11.0F, 9.5F, 15.0F).rotation().angle(45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 6.0F, 6.0F, 9.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(6.0F, 6.0F, 7.0F, 9.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(7.0F, 6.0F, 8.0F, 9.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(8.0F, 6.0F, 9.0F, 9.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(9.0F, 6.0F, 10.0F, 7.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(9.0F, 6.0F, 10.0F, 7.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(1.5F, 0.0F, 7.0F).to(7.5F, 2.0F, 9.0F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 5.0F, 1.0F, 8.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(4.0F, 5.0F, 5.0F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(2.0F, 5.0F, 3.0F, 8.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(4.0F, 5.0F, 5.0F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(1.0F, 5.0F, 2.0F, 8.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(3.0F, 5.0F, 4.0F, 8.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(1.0F, 1.5F, 5.5F).to(3.0F, 11.5F, 7.5F).rotation().angle(45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 9.0F, 1.0F, 14.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(1.0F, 9.0F, 2.0F, 14.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(2.0F, 9.0F, 3.0F, 14.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(3.0F, 9.0F, 4.0F, 14.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(4.0F, 9.0F, 5.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(4.0F, 9.0F, 5.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(11.0F, 0.5F, 8.0F).to(13.0F, 10.5F, 10.0F).rotation().angle(-22.5F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 11.0F, 6.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(6.0F, 11.0F, 7.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(7.0F, 11.0F, 8.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 9.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(9.0F, 11.0F, 10.0F, 12.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(9.0F, 11.0F, 10.0F, 12.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(6.0F, 0.0F, 6.0F).to(12.0F, 2.0F, 8.0F).rotation().angle(22.5F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 12.0F, 11.0F, 16.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(14.0F, 12.0F, 15.0F, 13.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(11.0F, 12.0F, 12.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(14.0F, 12.0F, 15.0F, 13.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(12.0F, 12.0F, 13.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(13.0F, 12.0F, 14.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.end();
	}
}
