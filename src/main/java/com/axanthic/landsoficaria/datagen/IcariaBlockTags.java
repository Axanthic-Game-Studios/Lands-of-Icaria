package com.axanthic.landsoficaria.datagen;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IcariaBlockTags extends BlockTagsProvider {

	public static final Tag.Named<Block> ICARIA_TIER = BlockTags.bind(LandsOfIcariaInfo.MODID + ":icaria_tier");
	public static final Tag.Named<Block> NEEDS_CHERT_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_chert_tool");
	public static final Tag.Named<Block> NEEDS_CHALKOS_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_chalkos_tool");
	public static final Tag.Named<Block> NEEDS_KASSITEROS_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_kassiteros_tool");
	public static final Tag.Named<Block> NEEDS_ORICHALCUM_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_orichalcum_tool");
	public static final Tag.Named<Block> NEEDS_VANADIUMSTEEL_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_vanadiumsteel_tool");
	public static final Tag.Named<Block> NEEDS_SIDEROS_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_sideros_tool");
	public static final Tag.Named<Block> NEEDS_MOLYBDENUMSTEEL_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_molybdenumsteel_tool");

	public static final Tag.Named<Block> MINEABLE_WITH_SCYTHE = BlockTags.bind(LandsOfIcariaInfo.MODID + ":mineable/scythe");

	public IcariaBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper) {
		super(gen, LandsOfIcariaInfo.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		tag(ICARIA_TIER).addTag(NEEDS_CHERT_TOOL).addTag(NEEDS_CHALKOS_TOOL).addTag(NEEDS_KASSITEROS_TOOL).addTag(NEEDS_ORICHALCUM_TOOL).addTag(NEEDS_VANADIUMSTEEL_TOOL).addTag(NEEDS_SIDEROS_TOOL).addTag(NEEDS_MOLYBDENUMSTEEL_TOOL);
		tag(NEEDS_CHERT_TOOL).add(LandsOfIcariaBlocks.YELLOWSTONE.get());
		tag(NEEDS_CHALKOS_TOOL).add(LandsOfIcariaBlocks.SILKSTONE.get());
		tag(NEEDS_KASSITEROS_TOOL);
		tag(NEEDS_ORICHALCUM_TOOL).add(LandsOfIcariaBlocks.SUNSTONE.get());
		tag(NEEDS_VANADIUMSTEEL_TOOL).add(LandsOfIcariaBlocks.VOIDSHALE.get());
		tag(NEEDS_SIDEROS_TOOL).add(LandsOfIcariaBlocks.BAETYL.get());
		tag(NEEDS_MOLYBDENUMSTEEL_TOOL);

		tag(MINEABLE_WITH_SCYTHE).addTag(BlockTags.MINEABLE_WITH_HOE).addTag(BlockTags.LEAVES).addTag(BlockTags.CROPS).addTag(BlockTags.REPLACEABLE_PLANTS);
	}
}
