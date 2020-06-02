package com.axanthic.loi.worldgen.feature;

import java.util.Random;

import com.axanthic.loi.ModInformation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.BlockRotationProcessor;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenPillars extends WorldGenStructureBase {

	BlockPos zero = new BlockPos(0, 0, 0);

	public final String[] pillars = new String[] {
			//"pillar/pillar2",
			"pillar/pillar3",
			"pillar/pillar4",
			"pillar/pillar5",
			"pillar/pillar6",
			"pillar/pillar3",
			"pillar/pillar4",
			"pillar/pillar5",
			"pillar/pillar6",
			"pillar/pillarv2",
			"pillar/pillarv3",
			"pillar/pillarv4"
	};

	public WorldGenPillars(float integrity) {
		super(integrity);
	}

	public boolean generate(World worldIn, Random rand, BlockPos position) {
		TemplateManager templatemanager = ((WorldServer) worldIn).getStructureTemplateManager();
		Template template = templatemanager.get(worldIn.getMinecraftServer(), new ResourceLocation(ModInformation.ID, pillars[rand.nextInt(pillars.length)]));
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