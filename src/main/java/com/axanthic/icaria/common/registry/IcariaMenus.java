package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.menu.ForgeMenu;
import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.menu.KilnMenu;
import com.axanthic.icaria.common.menu.StorageVaseMenu;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaMenus {
	public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, IcariaIdents.ID);

	public static final DeferredHolder<MenuType<?>, MenuType<ForgeMenu>> FORGE = IcariaMenus.MENUS.register("forge", () -> new MenuType<>(ForgeMenu::new, FeatureFlags.REGISTRY.allFlags()));
	public static final DeferredHolder<MenuType<?>, MenuType<GrinderMenu>> GRINDER = IcariaMenus.MENUS.register("grinder", () -> new MenuType<>(GrinderMenu::new, FeatureFlags.REGISTRY.allFlags()));
	public static final DeferredHolder<MenuType<?>, MenuType<KilnMenu>> KILN = IcariaMenus.MENUS.register("kiln", () -> new MenuType<>(KilnMenu::new, FeatureFlags.REGISTRY.allFlags()));
	public static final DeferredHolder<MenuType<?>, MenuType<StorageVaseMenu>> STORAGE_VASE = IcariaMenus.MENUS.register("storage_vase", () -> new MenuType<>(StorageVaseMenu::menu, FeatureFlags.REGISTRY.allFlags()));
}
