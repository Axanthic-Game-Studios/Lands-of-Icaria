package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderStoneModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(6.0F, 5.0F, 6.0F).to(9.0F, 15.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.SOUTH).uvs(6.0F, 0.0F, 9.0F, 10.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(6.0F, 6.0F, 9.0F, 7.0F).texture("#voidshale").end()
			.end()
		.element().from(9.0F, 5.0F, 6.0F).to(10.0F, 15.0F, 9.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.WEST).uvs(7.0F, 0.0F, 10.0F, 10.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(9.0F, 6.0F, 10.0F, 9.0F).texture("#voidshale").end()
			.end()
		.element().from(6.0F, 5.0F, 7.0F).to(7.0F, 15.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(7.0F, 0.0F, 10.0F, 10.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(6.0F, 7.0F, 7.0F, 10.0F).texture("#voidshale").end()
			.end()
		.element().from(7.0F, 5.0F, 9.0F).to(10.0F, 15.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(7.0F, 0.0F, 10.0F, 10.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(7.0F, 9.0F, 10.0F, 10.0F).texture("#voidshale").end()
			.end()
		.element().from(6.0F, 5.0F, 11.0F).to(10.0F, 16.0F, 12.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(4.0F, 0.0F, 5.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.SOUTH).uvs(6.0F, 0.0F, 10.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.WEST).uvs(11.0F, 0.0F, 12.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(6.0F, 11.0F, 10.0F, 12.0F).texture("#voidshale").end()
			.end()
		.element().from(4.0F, 5.0F, 6.0F).to(5.0F, 16.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(11.0F, 0.0F, 12.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 5.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 10.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(4.0F, 6.0F, 5.0F, 10.0F).texture("#voidshale").end()
			.end()
		.element().from(11.0F, 5.0F, 6.0F).to(12.0F, 16.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(4.0F, 0.0F, 5.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.EAST).uvs(6.0F, 0.0F, 10.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.SOUTH).uvs(11.0F, 0.0F, 12.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(11.0F, 6.0F, 12.0F, 10.0F).texture("#voidshale").end()
			.end()
		.element().from(6.0F, 5.0F, 4.0F).to(10.0F, 16.0F, 5.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 0.0F, 10.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.EAST).uvs(11.0F, 0.0F, 12.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.WEST).uvs(4.0F, 0.0F, 5.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(6.0F, 4.0F, 10.0F, 5.0F).texture("#voidshale").end()
			.end()
		.element().from(5.0F, 5.0F, 6.0F).to(6.0F, 16.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(6.0F, 0.0F, 11.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.SOUTH).uvs(5.0F, 0.0F, 6.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 11.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(5.0F, 6.0F, 6.0F, 11.0F).texture("#voidshale").end()
			.end()
		.element().from(6.0F, 5.0F, 10.0F).to(11.0F, 16.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 0.0F, 11.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.EAST).uvs(5.0F, 0.0F, 6.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.SOUTH).uvs(6.0F, 0.0F, 11.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(6.0F, 10.0F, 11.0F, 11.0F).texture("#voidshale").end()
			.end()
		.element().from(10.0F, 5.0F, 5.0F).to(11.0F, 16.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 0.0F, 6.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.EAST).uvs(6.0F, 0.0F, 11.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 11.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(10.0F, 5.0F, 11.0F, 10.0F).texture("#voidshale").end()
			.end()
		.element().from(5.0F, 5.0F, 5.0F).to(10.0F, 16.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 0.0F, 10.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.SOUTH).uvs(5.0F, 0.0F, 10.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.WEST).uvs(5.0F, 0.0F, 6.0F, 11.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(5.0F, 5.0F, 10.0F, 6.0F).texture("#voidshale").end()
			.end()
		.element().from(7.0F, 13.0F, 7.0F).to(9.0F, 14.0F, 9.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.UP).uvs(7.0F, 7.0F, 9.0F, 9.0F).texture("#grinder_stone").end()
			.end();
	}
}
