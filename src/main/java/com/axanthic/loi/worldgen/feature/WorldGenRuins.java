package com.axanthic.loi.worldgen.feature;

import java.util.Random;

import com.axanthic.loi.ModInformation;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.BlockRotationProcessor;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.gen.structure.template.TemplatePublic;

public class WorldGenRuins extends WorldGenStructureBase {

	BlockPos zero = new BlockPos(0, 0, 0);

	public final TemplatePublic[] ruins = new TemplatePublic[] {
			readTemplateFromJar(new ResourceLocation(ModInformation.ID, "temple"))
	};

	public WorldGenRuins(float integrity) {
		super(integrity);
	}

	public boolean generate(World worldIn, Random rand, BlockPos position) {
		TemplateManager templatemanager = ((WorldServer) worldIn).getStructureTemplateManager();
		TemplatePublic template = ruins[rand.nextInt(ruins.length)];
		//placementsettings.setMirror(Mirror.values()[rand.nextInt(Mirror.values().length)]);
		placementsettings.setRotation(Rotation.values()[rand.nextInt(Rotation.values().length)]);

		for (BlockPos basePos : BlockPos.getAllInBox(zero, zero.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1))) {
			BlockPos pos = template.transformedBlockPos(placementsettings, basePos).add(position);
			if (!worldIn.isBlockFullCube(pos))
				return false;
		}
		for (BlockPos basePos : BlockPos.getAllInBox(zero.up(), zero.add(template.getSize().getX() - 1, template.getSize().getY(), template.getSize().getZ() - 1))) {
			BlockPos pos = template.transformedBlockPos(placementsettings, basePos).add(position);
			if (worldIn.isBlockFullCube(pos))
				return false;
		}
		rand = new Random(rand.nextLong());
		addBlocksToWorldSilently(template, worldIn, position.up(), new BlockRotationProcessor(position.up(), placementsettings), placementsettings, rand, 2);
		return true;
	}
}