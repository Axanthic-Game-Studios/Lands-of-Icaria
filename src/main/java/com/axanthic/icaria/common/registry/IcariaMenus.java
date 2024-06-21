package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.menu.ForgeMenu;
import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.menu.KilnMenu;
import com.axanthic.icaria.common.menu.StorageVaseMenu;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class IcariaMenus {
	public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, IcariaInfo.ID);

	public static final Supplier<MenuType<ForgeMenu>> FORGE = IcariaMenus.MENUS.register("forge", () -> IMenuTypeExtension.create((pId, pInventory, pBuffer) -> new ForgeMenu(pId, pBuffer.readBlockPos(), pInventory, pInventory.player)));
	public static final Supplier<MenuType<GrinderMenu>> GRINDER = IcariaMenus.MENUS.register("grinder", () -> IMenuTypeExtension.create((pId, pInventory, pBuffer) -> new GrinderMenu(pId, pBuffer.readBlockPos(), pInventory, pInventory.player)));
	public static final Supplier<MenuType<KilnMenu>> KILN = IcariaMenus.MENUS.register("kiln", () -> IMenuTypeExtension.create((pId, pInventory, pBuffer) -> new KilnMenu(pId, pBuffer.readBlockPos(), pInventory, pInventory.player)));
	public static final Supplier<MenuType<StorageVaseMenu>> STORAGE_VASE = IcariaMenus.MENUS.register("storage_vase", () -> new MenuType<>(StorageVaseMenu::menu, FeatureFlags.REGISTRY.allFlags()));
}
