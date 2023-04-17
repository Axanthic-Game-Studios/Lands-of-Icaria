package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.menu.StorageVaseMenu;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.world.inventory.MenuType;

import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaMenuTypes {
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, IcariaInfo.ID);

	public static final RegistryObject<MenuType<GrinderMenu>> GRINDER = MENU_TYPES.register("grinder", () -> IForgeMenuType.create((pId, pInventory, pBuffer) -> new GrinderMenu(pId, pBuffer.readBlockPos(), pInventory, pInventory.player)));
	public static final RegistryObject<MenuType<StorageVaseMenu>> STORAGE_VASE = MENU_TYPES.register("storage_vase", () -> IForgeMenuType.create(((pId, pInventory, pBuffer) -> new StorageVaseMenu(pId, pBuffer.readBlockPos(), pInventory, pInventory.player))));
}
