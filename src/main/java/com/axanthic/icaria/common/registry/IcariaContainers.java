package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.menu.StorageVaseMenu;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.world.inventory.MenuType;

import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaContainers {
	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, IcariaInfo.MODID);

	public static final RegistryObject<MenuType<StorageVaseMenu>> STORAGE_VASE = CONTAINERS.register("storage_vase", () -> IForgeMenuType.create(((windowId, inv, data) -> new StorageVaseMenu(windowId, data.readBlockPos(), inv, inv.player))));
}
