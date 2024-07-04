package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IcariaIdents.ID);

    public static final Supplier<CreativeModeTab> BLOCKS = IcariaCreativeModeTabs.CREATIVE_MODE_TABS.register("blocks", () -> CreativeModeTab.builder().icon(() -> new ItemStack(IcariaItems.GRASSY_MARL.get())).title(Component.translatable("itemgroup" + "." + IcariaIdents.ID + "." + "blocks")).withTabsBefore(CreativeModeTabs.SPAWN_EGGS).build());
    public static final Supplier<CreativeModeTab> FLORA = IcariaCreativeModeTabs.CREATIVE_MODE_TABS.register("flora", () -> CreativeModeTab.builder().icon(() -> new ItemStack(IcariaItems.OLIVE_LEAVES.get())).title(Component.translatable("itemgroup" + "." + IcariaIdents.ID + "." + "flora")).withTabsBefore(BuiltInRegistries.CREATIVE_MODE_TAB.getKey(IcariaCreativeModeTabs.BLOCKS.get())).build());
    public static final Supplier<CreativeModeTab> ITEMS = IcariaCreativeModeTabs.CREATIVE_MODE_TABS.register("items", () -> CreativeModeTab.builder().icon(() -> new ItemStack(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get())).title(Component.translatable("itemgroup" + "." + IcariaIdents.ID + "." + "items")).withTabsBefore(BuiltInRegistries.CREATIVE_MODE_TAB.getKey(IcariaCreativeModeTabs.FLORA.get())).build());
}
