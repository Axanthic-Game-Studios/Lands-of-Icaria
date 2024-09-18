package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ZirconCrystalModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(2.0F, 0.0F, 7.0F).to(5.0F, 6.0F, 10.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.5F, 3.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 2.5F, 3.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 3.5F, 3.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(3.0F, 0.0F, 4.5F, 3.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.5F, 1.5F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(2.0F, 0.0F, 5.0F).to(4.0F, 5.0F, 7.0F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 4.0F, 1.0F, 6.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(1.0F, 4.0F, 2.0F, 6.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(2.0F, 4.0F, 3.0F, 6.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(3.0F, 4.0F, 4.0F, 6.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(0.0F, 15.0F, 1.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(0.0F, 15.0F, 1.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(3.5F, 0.0F, 10.5F).to(5.5F, 4.0F, 12.5F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 8.0F, 1.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(1.0F, 8.0F, 2.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(2.0F, 8.0F, 3.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(3.0F, 8.0F, 4.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(2.0F, 15.0F, 3.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(1.0F, 15.0F, 2.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(5.0F, 0.0F, 6.5F).to(9.0F, 5.0F, 10.5F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 2.0F, 16.0F, 4.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(12.0F, 2.0F, 14.0F, 4.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(10.0F, 2.0F, 12.0F, 4.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(8.0F, 2.0F, 10.0F, 4.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(4.0F, 0.0F, 6.0F, 2.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(6.0F, 0.0F, 8.0F, 2.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(9.5F, 0.0F, 11.0F).to(11.5F, 6.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(4.0F, 8.0F, 5.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(5.0F, 8.0F, 6.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(6.0F, 8.0F, 7.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(7.0F, 8.0F, 8.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(4.0F, 15.0F, 5.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(3.0F, 15.0F, 4.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(11.0F, 0.0F, 6.0F).to(14.0F, 4.0F, 9.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 8.0F, 15.5F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(12.0F, 8.0F, 13.5F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(10.0F, 8.0F, 11.5F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(8.0F, 8.0F, 9.5F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(9.0F, 1.0F, 10.5F, 2.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(7.0F, 2.0F, 8.5F, 3.5F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(12.0F, 0.0F, 7.0F).to(14.0F, 7.0F, 9.0F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 6.5F, 1.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(1.0F, 6.5F, 2.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(2.0F, 6.5F, 3.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(3.0F, 6.5F, 4.0F, 10.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(9.0F, 15.0F, 10.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(10.0F, 15.0F, 11.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(5.7F, 0.0F, 2.0F).to(9.7F, 3.0F, 6.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(14.0F, 7.0F, 16.0F, 8.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(14.0F, 9.0F, 16.0F, 10.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(14.0F, 11.0F, 16.0F, 12.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(14.0F, 13.0F, 16.0F, 14.5F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(6.0F, 9.0F, 8.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(4.0F, 9.0F, 6.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(2.5F, 0.0F, 9.5F).to(4.5F, 2.0F, 11.5F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 10.0F, 1.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(1.0F, 10.0F, 2.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(2.0F, 10.0F, 3.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(3.0F, 10.0F, 4.0F, 11.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(11.0F, 15.0F, 12.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(12.0F, 15.0F, 13.0F, 16.0F).texture("#texture").emissivity(15, 15).end()
			.end()
		.element().from(12.0F, 0.0F, 2.5F).to(14.0F, 2.0F, 4.5F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(8.0F, 5.0F, 9.0F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(9.0F, 5.0F, 10.0F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(10.0F, 5.0F, 11.0F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(11.0F, 5.0F, 12.0F, 6.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.UP).uvs(9.0F, 6.0F, 10.0F, 7.0F).texture("#texture").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(10.0F, 6.0F, 11.0F, 7.0F).texture("#texture").emissivity(15, 15).end()
			.end();
	}
}
