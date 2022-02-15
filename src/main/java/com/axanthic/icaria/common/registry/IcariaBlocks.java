package com.axanthic.icaria.common.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.axanthic.icaria.IcariaInfo;
import com.axanthic.icaria.client.util.IcariaSounds;
import com.axanthic.icaria.common.blocks.*;
import com.axanthic.icaria.common.blocks.MossBlock;
import com.axanthic.icaria.common.blocks.SandBlock;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IcariaInfo.MODID);

	public static final List<RegistryObject<? extends Block>> BASIC_BLOCKS = new ArrayList<RegistryObject<? extends Block>>();

	public static final RegistryObject<Block> MARL_GRASS = register("marl_grass", () -> new MarlGrassBlock(propertiesMarlGrass()));
	public static final RegistryObject<Block> MARL = registerBasic("marl", () -> new MarlBlock(propertiesMarl()));
	public static final RegistryObject<Block> MARL_CHERT = register("marl_chert", () -> new Block(propertiesMarlOre()));
	public static final RegistryObject<Block> MARL_ROTTEN_BONES = register("marl_rotten_bones", () -> new Block(propertiesMarlOre()));
	public static final RegistryObject<Block> MARL_LIGNITE = register("marl_lignite", () -> new Block(propertiesMarlOre()));
	public static final RegistryObject<Block> MARL_COARSE = registerBasic("marl_coarse", () -> new MarlCoarseBlock(propertiesMarl()));

	public static final RegistryObject<Block> FARMLAND = register("farmland", () -> new FarmlandBlock(propertiesFarmland()));
	public static final RegistryObject<Block> FARMLAND_FERTILIZED = register("farmland_fertilized", () -> new FarmlandFertilizedBlock(propertiesFarmland()));

	public static final RegistryObject<Block> MARL_ADOBE = registerBasic("marl_adobe", () -> new Block(propertiesMarlAdobe()));
	public static final DecoBlockCombination MARL_ADOBE_DECO = new DecoBlockCombination("marl_adobe", MARL_ADOBE, propertiesMarlAdobe());

	public static final RegistryObject<Block> LOAM = register("loam", () -> new SandBlock(propertiesLoam()));
	public static final RegistryObject<Block> LOAM_BRICKS = registerBasic("loam_bricks", () -> new Block(propertiesLoamBricks()));
	public static final DecoBlockCombination LOAM_BRICKS_DECO = new DecoBlockCombination("loam_bricks", LOAM_BRICKS, propertiesLoamBricks());

	public static final RegistryObject<Block> DOLOMITE_ADOBE = registerBasic("dolomite_adobe", () -> new Block(propertiesDolomite()));
	public static final DecoBlockCombination DOLOMITE_ADOBE_DECO = new DecoBlockCombination("dolomite_adobe", DOLOMITE_ADOBE, propertiesDolomite());
	public static final RegistryObject<Block> DOLOMITE_SMOOTH = registerBasic("dolomite_smooth", () -> new Block(propertiesDolomite()));
	public static final DecoBlockCombination DOLOMITE_SMOOTH_DECO = new DecoBlockCombination("dolomite_smooth", DOLOMITE_SMOOTH, propertiesDolomite());
	public static final RegistryObject<Block> DOLOMITE_BRICKS = registerBasic("dolomite_bricks", () -> new Block(propertiesDolomite()));
	public static final RegistryObject<RotatedPillarBlock> DOLOMITE_PILLAR = register("dolomite_pillar", () -> new RotatedPillarBlock(propertiesDolomite()));
	public static final RegistryObject<FacingBlock> DOLOMITE_PILLAR_HEAD = register("dolomite_pillar_head", () -> new FacingBlock(propertiesDolomite()));

	public static final RegistryObject<Block> GRAINEL = registerBasic("grainel", () -> new SandBlock(propertiesGrainel()));
	public static final RegistryObject<Block> GRAINEL_CHERT = register("grainel_chert", () -> new Block(propertiesGrainelOre()));
	public static final RegistryObject<Block> GRAINGLASS = register("grainglass", () -> new GlassBlock(propertiesGlass()));
	public static final RegistryObject<IronBarsBlock> GRAINGLASS_PANE = register("grainglass_pane", () -> new IronBarsBlock(propertiesGlass()));
	public static final RegistryObject<Block> GRAINGLASS_PANE_HORIZONTAL = register("grainglass_pane_horizontal", () -> new HorizontalPaneBlock(propertiesGlass()));
	public static final RegistryObject<Block> GRAINITE_ADOBE = registerBasic("grainite_adobe", () -> new Block(propertiesGrainite()));
	public static final DecoBlockCombination GRAINITE_ADOBE_DECO = new DecoBlockCombination("grainite_adobe", GRAINITE_ADOBE, propertiesGrainite());
	public static final RegistryObject<Block> GRAINITE = registerBasic("grainite", () -> new Block(propertiesGrainite()));
	public static final DecoBlockCombination GRAINITE_DECO = new DecoBlockCombination("grainite", GRAINITE, propertiesGrainite());
	public static final RegistryObject<Block> GRAINITE_BRICKS = registerBasic("grainite_bricks", () -> new Block(propertiesGrainite()));
	public static final DecoBlockCombination GRAINITE_BRICKS_DECO = new DecoBlockCombination("grainite_bricks", GRAINITE_BRICKS, propertiesGrainite());
	public static final RegistryObject<Block> GRAINITE_CHISELED = registerBasic("grainite_chiseled", () -> new Block(propertiesGrainite()));

	public static final RegistryObject<Block> YELLOWSTONE_ADOBE = registerBasic("yellowstone_adobe", () -> new Block(propertiesYellowstone()));
	public static final DecoBlockCombination YELLOWSTONE_ADOBE_DECO = new DecoBlockCombination("yellowstone_adobe", YELLOWSTONE_ADOBE, propertiesYellowstone());
	public static final RegistryObject<Block> YELLOWSTONE_COBBLE = registerBasic("yellowstone_cobble", () -> new Block(propertiesYellowstone()));
	public static final DecoBlockCombination YELLOWSTONE_COBBLE_DECO = new DecoBlockCombination("yellowstone_cobble", YELLOWSTONE_COBBLE, propertiesYellowstone());
	public static final RegistryObject<Block> YELLOWSTONE = register("yellowstone", () -> new Block(propertiesYellowstone()));
	public static final DecoBlockCombination YELLOWSTONE_DECO = new DecoBlockCombination("yellowstone", YELLOWSTONE, propertiesYellowstone());
	public static final RegistryObject<Block> YELLOWSTONE_BRICKS = registerBasic("yellowstone_bricks", () -> new Block(propertiesYellowstone()));
	public static final DecoBlockCombination YELLOWSTONE_BRICKS_DECO = new DecoBlockCombination("yellowstone_bricks", YELLOWSTONE_BRICKS, propertiesYellowstone());
	public static final RegistryObject<Block> YELLOWSTONE_CHISELED = registerBasic("yellowstone_chiseled", () -> new Block(propertiesYellowstone()));

	public static final RegistryObject<Block> SILKSAND = registerBasic("silksand", () -> new SandBlock(propertiesSilksand()));
	public static final RegistryObject<Block> SILKGLASS = register("silkglass", () -> new GlassBlock(propertiesGlass()));
	public static final RegistryObject<IronBarsBlock> SILKGLASS_PANE = register("silkglass_pane", () -> new IronBarsBlock(propertiesGlass()));
	public static final RegistryObject<Block> SILKGLASS_PANE_HORIZONTAL = register("silkglass_pane_horizontal", () -> new HorizontalPaneBlock(propertiesGlass()));
	public static final RegistryObject<Block> SILKSTONE_ADOBE = registerBasic("silkstone_adobe", () -> new Block(propertiesSilkstone()));
	public static final DecoBlockCombination SILKSTONE_ADOBE_DECO = new DecoBlockCombination("silkstone_adobe", SILKSTONE_ADOBE, propertiesSilkstone());
	public static final RegistryObject<Block> SILKSTONE_COBBLE = registerBasic("silkstone_cobble", () -> new Block(propertiesSilkstone()));
	public static final DecoBlockCombination SILKSTONE_COBBLE_DECO = new DecoBlockCombination("silkstone_cobble", SILKSTONE_COBBLE, propertiesSilkstone());
	public static final RegistryObject<Block> SILKSTONE = register("silkstone", () -> new Block(propertiesSilkstone()));
	public static final DecoBlockCombination SILKSTONE_DECO = new DecoBlockCombination("silkstone", SILKSTONE, propertiesSilkstone());
	public static final RegistryObject<Block> SILKSTONE_BRICKS = registerBasic("silkstone_bricks", () -> new Block(propertiesSilkstone()));
	public static final DecoBlockCombination SILKSTONE_BRICKS_DECO = new DecoBlockCombination("silkstone_bricks", SILKSTONE_BRICKS, propertiesSilkstone());
	public static final RegistryObject<Block> SILKSTONE_CHISELED = registerBasic("silkstone_chiseled", () -> new Block(propertiesSilkstone()));

	public static final RegistryObject<Block> SUNSTONE_ADOBE = registerBasic("sunstone_adobe", () -> new Block(propertiesSunstone()));
	public static final DecoBlockCombination SUNSTONE_ADOBE_DECO = new DecoBlockCombination("sunstone_adobe", SUNSTONE_ADOBE, propertiesSunstone());
	public static final RegistryObject<Block> SUNSTONE_COBBLE = registerBasic("sunstone_cobble", () -> new Block(propertiesSunstone()));
	public static final DecoBlockCombination SUNSTONE_COBBLE_DECO = new DecoBlockCombination("sunstone_cobble", SUNSTONE_COBBLE, propertiesSunstone());
	public static final RegistryObject<Block> SUNSTONE = register("sunstone", () -> new Block(propertiesSunstone()));
	public static final DecoBlockCombination SUNSTONE_DECO = new DecoBlockCombination("sunstone", SUNSTONE, propertiesSunstone());
	public static final RegistryObject<Block> SUNSTONE_BRICKS = registerBasic("sunstone_bricks", () -> new Block(propertiesSunstone()));
	public static final DecoBlockCombination SUNSTONE_BRICKS_DECO = new DecoBlockCombination("sunstone_bricks", SUNSTONE_BRICKS, propertiesSunstone());
	public static final RegistryObject<Block> SUNSTONE_CHISELED = registerBasic("sunstone_chiseled", () -> new Block(propertiesSunstone()));

	public static final RegistryObject<Block> VOIDSHALE_ADOBE = registerBasic("voidshale_adobe", () -> new Block(propertiesVoidshale()));
	public static final DecoBlockCombination VOIDSHALE_ADOBE_DECO = new DecoBlockCombination("voidshale_adobe", VOIDSHALE_ADOBE, propertiesVoidshale());
	public static final RegistryObject<Block> VOIDSHALE_COBBLE = registerBasic("voidshale_cobble", () -> new Block(propertiesVoidshale()));
	public static final DecoBlockCombination VOIDSHALE_COBBLE_DECO = new DecoBlockCombination("voidshale_cobble", VOIDSHALE_COBBLE, propertiesVoidshale());
	public static final RegistryObject<Block> VOIDSHALE = register("voidshale", () -> new Block(propertiesVoidshale()));
	public static final DecoBlockCombination VOIDSHALE_DECO = new DecoBlockCombination("voidshale", VOIDSHALE, propertiesVoidshale());
	public static final RegistryObject<Block> VOIDSHALE_BRICKS = registerBasic("voidshale_bricks", () -> new Block(propertiesVoidshale()));
	public static final DecoBlockCombination VOIDSHALE_BRICKS_DECO = new DecoBlockCombination("voidshale_bricks", VOIDSHALE_BRICKS, propertiesVoidshale());
	public static final RegistryObject<Block> VOIDSHALE_CHISELED = registerBasic("voidshale_chiseled", () -> new Block(propertiesVoidshale()));

	public static final RegistryObject<Block> BAETYL_ADOBE = registerBasic("baetyl_adobe", () -> new Block(propertiesBaetyl()));
	public static final DecoBlockCombination BAETYL_ADOBE_DECO = new DecoBlockCombination("baetyl_adobe", BAETYL_ADOBE, propertiesBaetyl());
	public static final RegistryObject<Block> BAETYL_COBBLE = registerBasic("baetyl_cobble", () -> new Block(propertiesBaetyl()));
	public static final DecoBlockCombination BAETYL_COBBLE_DECO = new DecoBlockCombination("baetyl_cobble", BAETYL_COBBLE, propertiesBaetyl());
	public static final RegistryObject<Block> BAETYL = register("baetyl", () -> new Block(propertiesBaetyl()));
	public static final DecoBlockCombination BAETYL_DECO = new DecoBlockCombination("baetyl", BAETYL, propertiesBaetyl());
	public static final RegistryObject<Block> BAETYL_BRICKS = registerBasic("baetyl_bricks", () -> new Block(propertiesBaetyl()));
	public static final DecoBlockCombination BAETYL_BRICKS_DECO = new DecoBlockCombination("baetyl_bricks", BAETYL_BRICKS, propertiesBaetyl());
	public static final RegistryObject<Block> BAETYL_CHISELED = registerBasic("baetyl_chiseled", () -> new Block(propertiesBaetyl()));

	public static final RegistryObject<Block> RELICSTONE = registerBasic("relicstone", () -> new Block(propertiesRelicstone()));
	public static final DecoBlockCombination RELICSTONE_DECO = new DecoBlockCombination("relicstone", RELICSTONE, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_SMOOTH = register("relicstone_smooth", () -> new Block(propertiesRelicstone()));
	public static final DecoBlockCombination RELICSTONE_SMOOTH_DECO = new DecoBlockCombination("relicstone_smooth", RELICSTONE_SMOOTH, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_BRICKS = registerBasic("relicstone_bricks", () -> new Block(propertiesRelicstone()));
	public static final DecoBlockCombination RELICSTONE_BRICKS_DECO = new DecoBlockCombination("relicstone_bricks", RELICSTONE_BRICKS, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_BRICKS_CRACKED = registerBasic("relicstone_bricks_cracked", () -> new Block(propertiesRelicstone()));
	public static final DecoBlockCombination RELICSTONE_BRICKS_CRACKED_DECO = new DecoBlockCombination("relicstone_bricks_cracked", RELICSTONE_BRICKS_CRACKED, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_BRICKS_MOSSY = registerBasic("relicstone_bricks_mossy", () -> new Block(propertiesRelicstone()));
	public static final DecoBlockCombination RELICSTONE_BRICKS_MOSSY_DECO = new DecoBlockCombination("relicstone_bricks_mossy", RELICSTONE_BRICKS_MOSSY, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_TILES = registerBasic("relicstone_tiles", () -> new Block(propertiesRelicstone()));
	public static final DecoBlockCombination RELICSTONE_TILES_DECO = new DecoBlockCombination("relicstone_tiles", RELICSTONE_TILES, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_TILES_CRACKED = registerBasic("relicstone_tiles_cracked", () -> new Block(propertiesRelicstone()));
	public static final DecoBlockCombination RELICSTONE_TILES_CRACKED_DECO = new DecoBlockCombination("relicstone_tiles_cracked", RELICSTONE_TILES_CRACKED, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_TILES_MOSSY = registerBasic("relicstone_tiles_mossy", () -> new Block(propertiesRelicstone()));
	public static final DecoBlockCombination RELICSTONE_TILES_MOSSY_DECO = new DecoBlockCombination("relicstone_tiles_mossy", RELICSTONE_TILES_MOSSY, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_CHISELED = registerBasic("relicstone_chiseled", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<RotatedPillarBlock> RELICSTONE_PILLAR = register("relicstone_pillar", () -> new RotatedPillarBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_PILLAR_HEAD = register("relicstone_pillar_head", () -> new FacingBlock(propertiesRelicstone()));

	public static final RegistryObject<Block> ARISTONE = registerBasic("aristone", () -> new GlassBlock(propertiesAristone()));
	public static final RegistryObject<Block> ARISTONE_PACKED = registerBasic("aristone_packed", () -> new Block(propertiesAristone()));

	public static final RegistryObject<Block> QUARTZ_PILLAR_HEAD = register("quartz_pillar_head", () -> new FacingBlock(propertiesQuartz()));

	public static final RegistryObject<Block> JELLYFISH_JELLY_BLOCK = registerBasic("jellyfish_jelly_block", () -> new SlimeBlock(propertiesJellyBlock()));
	public static final RegistryObject<Block> ARACHNE_STRING_BLOCK = registerBasic("arachne_string_block", () -> new Block(propertiesArachneStringBlock()));
	public static final RegistryObject<RotatedPillarBlock> SPELT_BALE_BLOCK = register("spelt_bale_block", () -> new SpeltBaleBlock(propertiesSpeltBlock()));
	public static final RegistryObject<Block> VINE_REED_BLOCK = registerBasic("vine_reed_block", () -> new Block(propertiesVineBlock()));
	public static final RegistryObject<Block> VINE_SPROUT_BLOCK = registerBasic("vine_sprout_block", () -> new Block(propertiesVineBlock()));
	public static final RegistryObject<Block> ROTTEN_BONES_BLOCK = registerBasic("rotten_bones_block", () -> new Block(propertiesRottenBonesBlock()));
	public static final RegistryObject<Block> LIGNITE_BLOCK = registerBasic("lignite_block", () -> new Block(propertiesLigniteBlock()));
	public static final RegistryObject<Block> ANTHRACITE_BLOCK = registerBasic("anthracite_block", () -> new Block(propertiesAnthraciteBlock()));
	public static final RegistryObject<Block> CHERT_BLOCK = registerBasic("chert_block", () -> new Block(propertiesChertBlock()));

	public static final RegistryObject<Block> MOSS_0 = register("moss_0", () -> new MossBlock(propertiesMoss()));
	public static final RegistryObject<Block> MOSS_1 = register("moss_1", () -> new MossBlock(propertiesMoss()));
	public static final RegistryObject<Block> MOSS_2 = register("moss_2", () -> new MossBlock(propertiesMoss()));

	private static Properties propertiesMarlGrass() {
		return Properties.of(Material.GRASS, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).explosionResistance(0.6F).strength(0.6F).randomTicks();
	}

	private static Properties propertiesMarl() {
		return Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).explosionResistance(0.5F).strength(0.5F);
	}

	private static Properties propertiesMarlOre() {
		return Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).explosionResistance(0.5F).strength(0.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesFarmland() {
		return Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).explosionResistance(0.6F).strength(0.6F).randomTicks();
	}

	private static Properties propertiesMarlAdobe() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesLoam() {
		return Properties.of(Material.DIRT, MaterialColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.GRAVEL).explosionResistance(0.6F).strength(0.6F);
	}

	private static Properties propertiesLoamBricks() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesDolomite() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesGrainel() {
		return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.SAND).explosionResistance(0.5F).strength(0.5F);
	}

	private static Properties propertiesGrainelOre() {
		return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.SAND).explosionResistance(0.5F).strength(0.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesGlass() {
		return Properties.of(Material.GLASS, MaterialColor.NONE).sound(SoundType.GLASS).explosionResistance(0.3F).strength(0.3F).noOcclusion();
	}

	private static Properties propertiesGrainite() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesYellowstone() {
		return Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesSilksand() {
		return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.SAND).explosionResistance(0.5F).strength(0.5F);
	}

	private static Properties propertiesSilkstone() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesSunstone() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesVoidshale() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesBaetyl() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesRelicstone() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesAristone() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN).sound(IcariaSounds.ARISTONE).explosionResistance(0.5F).strength(0.5F).friction(0.98F).noOcclusion();
	}

	private static Properties propertiesQuartz() {
		return Properties.of(Material.STONE, MaterialColor.QUARTZ).sound(SoundType.STONE).explosionResistance(0.8F).strength(0.8F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesJellyBlock() {
		return Properties.of(Material.CLAY, MaterialColor.COLOR_RED).sound(SoundType.SLIME_BLOCK).explosionResistance(0.5F).strength(0.5F).friction(0.8F).noOcclusion().instabreak();
	}

	private static Properties propertiesArachneStringBlock() {
		return Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOL).explosionResistance(0.8F).strength(0.8F);
	}

	private static Properties propertiesSpeltBlock() {
		return Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.GRASS).explosionResistance(0.5F).strength(0.5F);
	}

	private static Properties propertiesVineBlock() {
		return Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).explosionResistance(2.5F).strength(0.5F);
	}

	private static Properties propertiesRottenBonesBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).sound(SoundType.BONE_BLOCK).explosionResistance(2.0F).strength(2.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesLigniteBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.STONE).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesAnthraciteBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesChertBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).sound(SoundType.STONE).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesMoss() {
		return Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).explosionResistance(0.1F).strength(0.1F);
	}

	private static <T extends Block> RegistryObject<T> registerBasic(final String name, final Supplier<? extends T> block) {
		RegistryObject<T> registeredBlock = register(name, block);
		BASIC_BLOCKS.add(registeredBlock);
		return registeredBlock;
	}

	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}

	public static class DecoBlockCombination {

		public final String name;
		public final RegistryObject<Block> original;
		public final RegistryObject<SlabBlock> SLAB;
		public final RegistryObject<StairBlock> STAIRS;
		public final RegistryObject<WallBlock> WALL;

		public DecoBlockCombination(String name, RegistryObject<Block> original, Properties prop, boolean slab, boolean stairs, boolean wall) {
			this.name = name;
			this.original = original;
			if (slab)
				SLAB = register(name + "_slab", () -> new SlabBlock(prop));
			else
				SLAB = null;
			if (stairs)
				STAIRS = register(name + "_stairs", () -> new StairBlock(() -> original.get().defaultBlockState(), prop));
			else
				STAIRS = null;
			if (wall)
				WALL = register(name + "_wall", () -> new WallBlock(prop));
			else
				WALL = null;
		}

		public DecoBlockCombination(String name, RegistryObject<Block> original, Properties prop) {
			this(name, original, prop, true, true, true);
		}
	}
}