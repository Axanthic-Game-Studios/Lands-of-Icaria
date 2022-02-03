package com.axanthic.landsoficaria.common.registry;

import com.axanthic.landsoficaria.common.blocks.*;
import com.axanthic.landsoficaria.common.blocks.MossBlock;
import com.axanthic.landsoficaria.LandsOfIcariaInfo;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class LandsOfIcariaBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LandsOfIcariaInfo.MODID);

    public static final RegistryObject<Block> MARL_GRASS = register("marl_grass", MarlGrassBlock::new);
    public static final RegistryObject<Block> MARL = register("marl", MarlBlock::new);
    public static final RegistryObject<Block> MARL_ADOBE = register("marl_adobe", () -> new Block(propertiesMarlAdobe()));
    public static final RegistryObject<Block> MARL_ADOBE_SLAB = register("marl_adobe_slab", () -> new SlabBlock(propertiesMarlAdobe()));
    public static final RegistryObject<Block> MARL_ADOBE_STAIRS = register("marl_adobe_stairs", () -> new StairBlock(MARL_ADOBE.get().defaultBlockState(), propertiesMarlAdobe()));
    public static final RegistryObject<Block> MARL_ADOBE_WALL = register("marl_adobe_wall", () -> new WallBlock(propertiesMarlAdobe()));
    public static final RegistryObject<Block> MARL_COARSE = register("marl_coarse", MarlCoarseBlock::new);

    public static final RegistryObject<Block> FARMLAND = register("farmland", FarmlandBlock::new);
    public static final RegistryObject<Block> FARMLAND_FERTILIZED = register("farmland_fertilized", FarmlandFertilizedBlock::new);

    public static final RegistryObject<Block> LOAM = register("loam", LoamBlock::new);
    public static final RegistryObject<Block> LOAM_BRICKS = register("loam_bricks", () -> new Block(propertiesLoamBricks()));
    public static final RegistryObject<Block> LOAM_BRICKS_SLAB = register("loam_bricks_slab", () -> new SlabBlock(propertiesLoamBricks()));
    public static final RegistryObject<Block> LOAM_BRICKS_STAIRS = register("loam_bricks_stairs", () -> new StairBlock(LOAM_BRICKS.get().defaultBlockState(), propertiesLoamBricks()));
    public static final RegistryObject<Block> LOAM_BRICKS_WALL = register("loam_bricks_wall", () -> new WallBlock(propertiesLoamBricks()));

    public static final RegistryObject<Block> GRAINEL = register("grainel", () -> new Block(propertiesGrainel()));
    public static final RegistryObject<Block> GRAINITE_ADOBE = register("grainite_adobe", () -> new Block(propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_ADOBE_SLAB = register("grainite_adobe_slab", () -> new SlabBlock(propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_ADOBE_STAIRS = register("grainite_adobe_stairs", () -> new StairBlock(GRAINITE_ADOBE.get().defaultBlockState(), propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_ADOBE_WALL = register("grainite_adobe_wall", () -> new WallBlock(propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE = register("grainite", () -> new Block(propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_SLAB = register("grainite_slab", () -> new SlabBlock(propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_STAIRS = register("grainite_stairs", () -> new StairBlock(GRAINITE.get().defaultBlockState(), propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_WALL = register("grainite_wall", () -> new WallBlock(propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_BRICKS = register("grainite_bricks", () -> new Block(propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_BRICKS_SLAB = register("grainite_bricks_slab", () -> new SlabBlock(propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_BRICKS_STAIRS = register("grainite_bricks_stairs", () -> new StairBlock(GRAINITE_BRICKS.get().defaultBlockState(), propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_BRICKS_WALL = register("grainite_bricks_wall", () -> new WallBlock(propertiesGrainite()));
    public static final RegistryObject<Block> GRAINITE_CHISELED = register("grainite_chiseled", () -> new Block(propertiesGrainite()));

    public static final RegistryObject<Block> YELLOWSTONE_ADOBE = register("yellowstone_adobe", () -> new Block(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_ADOBE_SLAB = register("yellowstone_adobe_slab", () -> new SlabBlock(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_ADOBE_STAIRS = register("yellowstone_adobe_stairs", () -> new StairBlock(YELLOWSTONE_ADOBE.get().defaultBlockState(), propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_ADOBE_WALL = register("yellowstone_adobe_wall", () -> new WallBlock(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_COBBLE = register("yellowstone_cobble", () -> new Block(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_COBBLE_SLAB = register("yellowstone_cobble_slab", () -> new SlabBlock(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_COBBLE_STAIRS = register("yellowstone_cobble_stairs", () -> new StairBlock(YELLOWSTONE_COBBLE.get().defaultBlockState(), propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_COBBLE_WALL = register("yellowstone_cobble_wall", () -> new WallBlock(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE = register("yellowstone", () -> new Block(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_SLAB = register("yellowstone_slab", () -> new SlabBlock(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_STAIRS = register("yellowstone_stairs", () -> new StairBlock(YELLOWSTONE.get().defaultBlockState(), propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_WALL = register("yellowstone_wall", () -> new WallBlock(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_BRICKS = register("yellowstone_bricks", () -> new Block(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_BRICKS_SLAB = register("yellowstone_bricks_slab", () -> new SlabBlock(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_BRICKS_STAIRS = register("yellowstone_bricks_stairs", () -> new StairBlock(YELLOWSTONE_BRICKS.get().defaultBlockState(), propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_BRICKS_WALL = register("yellowstone_bricks_wall", () -> new WallBlock(propertiesYellowstone()));
    public static final RegistryObject<Block> YELLOWSTONE_CHISELED = register("yellowstone_chiseled", () -> new Block(propertiesYellowstone()));

    public static final RegistryObject<Block> SILKSTONE_ADOBE = register("silkstone_adobe", () -> new Block(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_ADOBE_SLAB = register("silkstone_adobe_slab", () -> new SlabBlock(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_ADOBE_STAIRS = register("silkstone_adobe_stairs", () -> new StairBlock(SILKSTONE_ADOBE.get().defaultBlockState(), propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_ADOBE_WALL = register("silkstone_adobe_wall", () -> new WallBlock(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_COBBLE = register("silkstone_cobble", () -> new Block(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_COBBLE_SLAB = register("silkstone_cobble_slab", () -> new SlabBlock(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_COBBLE_STAIRS = register("silkstone_cobble_stairs", () -> new StairBlock(SILKSTONE_COBBLE.get().defaultBlockState(), propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_COBBLE_WALL = register("silkstone_cobble_wall", () -> new WallBlock(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE = register("silkstone", () -> new Block(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_SLAB = register("silkstone_slab", () -> new SlabBlock(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_STAIRS = register("silkstone_stairs", () -> new StairBlock(SILKSTONE.get().defaultBlockState(), propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_WALL = register("silkstone_wall", () -> new WallBlock(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_BRICKS = register("silkstone_bricks", () -> new Block(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_BRICKS_SLAB = register("silkstone_bricks_slab", () -> new SlabBlock(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_BRICKS_STAIRS = register("silkstone_bricks_stairs", () -> new StairBlock(SILKSTONE_BRICKS.get().defaultBlockState(), propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_BRICKS_WALL = register("silkstone_bricks_wall", () -> new WallBlock(propertiesSilkstone()));
    public static final RegistryObject<Block> SILKSTONE_CHISELED = register("silkstone_chiseled", () -> new Block(propertiesSilkstone()));

    public static final RegistryObject<Block> SUNSTONE_ADOBE = register("sunstone_adobe", () -> new Block(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_ADOBE_SLAB = register("sunstone_adobe_slab", () -> new SlabBlock(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_ADOBE_STAIRS = register("sunstone_adobe_stairs", () -> new StairBlock(SUNSTONE_ADOBE.get().defaultBlockState(), propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_ADOBE_WALL = register("sunstone_adobe_wall", () -> new WallBlock(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_COBBLE = register("sunstone_cobble", () -> new Block(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_COBBLE_SLAB = register("sunstone_cobble_slab", () -> new SlabBlock(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_COBBLE_STAIRS = register("sunstone_cobble_stairs", () -> new StairBlock(SUNSTONE_COBBLE.get().defaultBlockState(), propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_COBBLE_WALL = register("sunstone_cobble_wall", () -> new WallBlock(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE = register("sunstone", () -> new Block(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_SLAB = register("sunstone_slab", () -> new SlabBlock(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_STAIRS = register("sunstone_stairs", () -> new StairBlock(SUNSTONE.get().defaultBlockState(), propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_WALL = register("sunstone_wall", () -> new WallBlock(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_BRICKS = register("sunstone_bricks", () -> new Block(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_BRICKS_SLAB = register("sunstone_bricks_slab", () -> new SlabBlock(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_BRICKS_STAIRS = register("sunstone_bricks_stairs", () -> new StairBlock(SUNSTONE_BRICKS.get().defaultBlockState(), propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_BRICKS_WALL = register("sunstone_bricks_wall", () -> new WallBlock(propertiesSunstone()));
    public static final RegistryObject<Block> SUNSTONE_CHISELED = register("sunstone_chiseled", () -> new Block(propertiesSunstone()));

    public static final RegistryObject<Block> VOIDSHALE_ADOBE = register("voidshale_adobe", () -> new Block(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_ADOBE_SLAB = register("voidshale_adobe_slab", () -> new SlabBlock(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_ADOBE_STAIRS = register("voidshale_adobe_stairs", () -> new StairBlock(VOIDSHALE_ADOBE.get().defaultBlockState(), propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_ADOBE_WALL = register("voidshale_adobe_wall", () -> new WallBlock(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_COBBLE = register("voidshale_cobble", () -> new Block(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_COBBLE_SLAB = register("voidshale_cobble_slab", () -> new SlabBlock(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_COBBLE_STAIRS = register("voidshale_cobble_stairs", () -> new StairBlock(VOIDSHALE_COBBLE.get().defaultBlockState(), propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_COBBLE_WALL = register("voidshale_cobble_wall", () -> new WallBlock(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE = register("voidshale", () -> new Block(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_SLAB = register("voidshale_slab", () -> new SlabBlock(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_STAIRS = register("voidshale_stairs", () -> new StairBlock(VOIDSHALE.get().defaultBlockState(), propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_WALL = register("voidshale_wall", () -> new WallBlock(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_BRICKS = register("voidshale_bricks", () -> new Block(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_BRICKS_SLAB = register("voidshale_bricks_slab", () -> new SlabBlock(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_BRICKS_STAIRS = register("voidshale_bricks_stairs", () -> new StairBlock(VOIDSHALE_BRICKS.get().defaultBlockState(), propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_BRICKS_WALL = register("voidshale_bricks_wall", () -> new WallBlock(propertiesVoidshale()));
    public static final RegistryObject<Block> VOIDSHALE_CHISELED = register("voidshale_chiseled", () -> new Block(propertiesVoidshale()));

    public static final RegistryObject<Block> BAETYL_ADOBE = register("baetyl_adobe", () -> new Block(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_ADOBE_SLAB = register("baetyl_adobe_slab", () -> new SlabBlock(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_ADOBE_STAIRS = register("baetyl_adobe_stairs", () -> new StairBlock(BAETYL_ADOBE.get().defaultBlockState(), propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_ADOBE_WALL = register("baetyl_adobe_wall", () -> new WallBlock(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_COBBLE = register("baetyl_cobble", () -> new Block(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_COBBLE_SLAB = register("baetyl_cobble_slab", () -> new SlabBlock(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_COBBLE_STAIRS = register("baetyl_cobble_stairs", () -> new StairBlock(BAETYL_COBBLE.get().defaultBlockState(), propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_COBBLE_WALL = register("baetyl_cobble_wall", () -> new WallBlock(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL = register("baetyl", () -> new Block(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_SLAB = register("baetyl_slab", () -> new SlabBlock(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_STAIRS = register("baetyl_stairs", () -> new StairBlock(BAETYL.get().defaultBlockState(), propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_WALL = register("baetyl_wall", () -> new WallBlock(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_BRICKS = register("baetyl_bricks", () -> new Block(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_BRICKS_SLAB = register("baetyl_bricks_slab", () -> new SlabBlock(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_BRICKS_STAIRS = register("baetyl_bricks_stairs", () -> new StairBlock(BAETYL_BRICKS.get().defaultBlockState(), propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_BRICKS_WALL = register("baetyl_bricks_wall", () -> new WallBlock(propertiesBaetyl()));
    public static final RegistryObject<Block> BAETYL_CHISELED = register("baetyl_chiseled", () -> new Block(propertiesBaetyl()));

    public static final RegistryObject<Block> MOSS_0 = register("moss_0", MossBlock::new);
    public static final RegistryObject<Block> MOSS_1 = register("moss_1", MossBlock::new);
    public static final RegistryObject<Block> MOSS_2 = register("moss_2", MossBlock::new);

    private static Properties propertiesMarlAdobe() {
        return Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
    }

    private static Properties propertiesLoamBricks() {
        return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
    }

    private static Properties propertiesGrainel() {
        return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.SAND).explosionResistance(0.5F).strength(0.5F);
    }

    private static Properties propertiesGrainite() {
        return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
    }

    private static Properties propertiesYellowstone() {
        return Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
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

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }
}
