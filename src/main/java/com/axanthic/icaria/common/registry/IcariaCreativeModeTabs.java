package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IcariaInfo.ID);

    public static final RegistryObject<CreativeModeTab> BLOCKS = IcariaCreativeModeTabs.CREATIVE_MODE_TABS.register("blocks", () -> CreativeModeTab.builder().icon(() -> new ItemStack(IcariaItems.GRASSY_MARL.get())).title(Component.translatable("itemgroup." + IcariaInfo.ID + ".blocks")).withTabsBefore(CreativeModeTabs.SPAWN_EGGS).build());
    public static final RegistryObject<CreativeModeTab> FLORA = IcariaCreativeModeTabs.CREATIVE_MODE_TABS.register("flora", () -> CreativeModeTab.builder().icon(() -> new ItemStack(IcariaItems.OLIVE_LEAVES.get())).title(Component.translatable("itemgroup." + IcariaInfo.ID + ".flora")).withTabsBefore(IcariaCreativeModeTabs.BLOCKS.getId()).build());
    public static final RegistryObject<CreativeModeTab> ITEMS = IcariaCreativeModeTabs.CREATIVE_MODE_TABS.register("items", () -> CreativeModeTab.builder().icon(() -> new ItemStack(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get())).title(Component.translatable("itemgroup." + IcariaInfo.ID + ".items")).withTabsBefore(IcariaCreativeModeTabs.FLORA.getId()).build());
}
