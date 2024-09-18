package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class JasperCrystalModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(1.0F, -2.0F, 3.5F).to(10.0F, 5.0F, 12.5F).rotation().angle(22.5F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 8.5F, 4.5F, 12.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(0.0F, 16.0F, 4.5F, 12.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(8.0F, 12.5F, 12.5F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(8.0F, 8.5F, 12.5F, 12.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(11.5F, 0.0F, 16.0F, 4.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(11.5F, 0.0F, 16.0F, 4.5F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(11.9F, -0.7F, 4.0F).to(13.9F, 3.3F, 8.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 8.0F, 8.0F, 9.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(14.0F, 16.0F, 16.0F, 14.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(6.0F, 12.0F, 8.0F, 13.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(14.0F, 14.0F, 16.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(6.0F, 10.0F, 8.0F, 11.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(6.0F, 14.0F, 8.0F, 15.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(2.0F, 0.4F, 0.2F).to(4.0F, 4.4F, 4.2F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 8.0F, 6.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(14.0F, 12.0F, 16.0F, 14.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(5.0F, 10.0F, 6.0F, 12.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(14.0F, 12.0F, 16.0F, 14.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(5.0F, 12.0F, 6.0F, 14.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(5.0F, 14.0F, 6.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(5.1F, 0.0F, 2.7F).to(11.1F, 4.0F, 8.7F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 6.0F, 3.0F, 8.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(3.0F, 6.0F, 6.0F, 8.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(5.0F, 6.0F, 8.0F, 8.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(9.0F, 6.0F, 12.0F, 8.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(13.0F, 9.0F, 16.0F, 12.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(13.0F, 9.0F, 16.0F, 12.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(5.0F, 1.9F, 12.4F).to(10.0F, 4.9F, 15.4F).rotation().angle(22.5F).axis(Direction.Axis.X).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 4.5F, 2.5F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(14.5F, 6.5F, 16.0F, 8.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(3.0F, 4.5F, 5.5F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(14.5F, 6.5F, 16.0F, 8.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(6.0F, 4.5F, 8.5F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(9.0F, 4.5F, 11.5F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(6.8F, 3.8F, 7.0F).to(10.8F, 4.8F, 11.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 3.5F, 2.0F, 4.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(2.0F, 3.5F, 4.0F, 4.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(4.0F, 3.5F, 6.0F, 4.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(6.0F, 3.5F, 8.0F, 4.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(8.0F, 2.0F, 10.0F, 4.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(8.0F, 2.0F, 10.0F, 4.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(7.6F, 1.2F, 4.7F).to(11.6F, 5.2F, 8.7F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 2.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(4.0F, 0.0F, 2.0F, 2.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(8.0F, 0.0F, 10.0F, 2.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(8.0F, 0.0F, 10.0F, 2.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(4.0F, 0.0F, 6.0F, 2.0F).texture("#texture").emissivity(15, 15).end()
			.end();
	}
}
