package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.menu.StorageVaseMenu;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;

import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaMenus {
	public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, IcariaInfo.ID);

	public static final RegistryObject<MenuType<GrinderMenu>> GRINDER = IcariaMenus.MENUS.register("grinder", () -> IForgeMenuType.create((pId, pInventory, pBuffer) -> new GrinderMenu(pId, pBuffer.readBlockPos(), pInventory, pInventory.player)));
	public static final RegistryObject<MenuType<StorageVaseMenu>> STORAGE_VASE = IcariaMenus.MENUS.register("storage_vase", () -> IForgeMenuType.create(((pId, pInventory, pBuffer) -> new StorageVaseMenu(pId, pBuffer.readBlockPos(), pInventory, pInventory.player))));
}
