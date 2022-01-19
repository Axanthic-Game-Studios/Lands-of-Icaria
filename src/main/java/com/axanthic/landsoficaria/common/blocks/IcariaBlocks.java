package com.axanthic.landsoficaria.common.blocks;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.LandsOfIcariaTabs;
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

    public static final RegistryObject<Block> MARL = register("marl", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).explosionResistance(0.5F).strength(0.5F)), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeBlocks)));
    public static final RegistryObject<Block> MARL_COARSE = register("marl_coarse", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).explosionResistance(0.5F).strength(0.5F)), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeBlocks)));
    public static final RegistryObject<Block> LOAM = register("loam", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).explosionResistance(0.5F).strength(0.5F)), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LandsOfIcariaTabs.creativeBlocks)));

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }
}
