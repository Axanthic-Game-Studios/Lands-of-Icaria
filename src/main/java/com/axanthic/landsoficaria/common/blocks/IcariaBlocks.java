package com.axanthic.landsoficaria.common.blocks;

import com.axanthic.landsoficaria.util.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.util.LandsOfIcariaTabs;
import com.axanthic.landsoficaria.common.items.IcariaItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class IcariaBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LandsOfIcariaInfo.MODID);
    public static final DeferredRegister<Item> ITEMS = IcariaItems.ITEMS;

    public static final RegistryObject<Block> MARL = register("marl", () -> new MarlBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).sound(SoundType.GRAVEL).explosionResistance(0.5F).strength(0.5F)), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeBlocks)));
    public static final RegistryObject<Block> MARL_COARSE = register("marl_coarse", () -> new MarlCoarseBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).sound(SoundType.GRAVEL).explosionResistance(0.5F).strength(0.5F)), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeBlocks)));
    public static final RegistryObject<Block> LOAM = register("loam", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).sound(SoundType.GRAVEL).explosionResistance(0.6F).strength(0.6F)), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeBlocks)));
    public static final RegistryObject<Block> MARL_GRASS = register("marl_grass", () -> new MarlGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).sound(SoundType.GRASS).explosionResistance(0.6F).strength(0.6F).randomTicks()), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeBlocks)));
    public static final RegistryObject<Block> FARMLAND = register("farmland", () -> new FarmlandBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).sound(SoundType.GRAVEL).explosionResistance(0.6F).strength(0.6F).randomTicks()), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeBlocks)));
    public static final RegistryObject<Block> FARMLAND_FERTILIZED = register("farmland_fertilized", () -> new FarmlandFertilizedBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).sound(SoundType.GRAVEL).explosionResistance(0.6F).strength(0.6F).randomTicks()), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeBlocks)));
    public static final RegistryObject<Block> MOSS_0 = register("moss_0", () -> new MossBlock(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.PLANT).sound(SoundType.MOSS).explosionResistance(0.15F).strength(0.15F)), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeFlora)));
    public static final RegistryObject<Block> MOSS_1 = register("moss_1", () -> new MossBlock(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.PLANT).sound(SoundType.MOSS).explosionResistance(0.15F).strength(0.15F)), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeFlora)));
    public static final RegistryObject<Block> MOSS_2 = register("moss_2", () -> new MossBlock(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.PLANT).sound(SoundType.MOSS).explosionResistance(0.15F).strength(0.15F)), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeFlora)));

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }
}
