package com.axanthic.icaria.integration;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@JeiPlugin
public class JeiIntegration implements IModPlugin {
    private final ResourceLocation ID = new ResourceLocation(IcariaInfo.MODID, "main");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        anvilRecipes(registration, IcariaItems.CHERT_TOOLS.SWORD.get(), IcariaItems.CHERT.get());
        anvilRecipes(registration, IcariaItems.CHERT_TOOLS.DAGGER.get(), IcariaItems.CHERT.get());
        anvilRecipes(registration, IcariaItems.CHERT_TOOLS.SHOVEL.get(), IcariaItems.CHERT.get());
        anvilRecipes(registration, IcariaItems.CHERT_TOOLS.PICKAXE.get(), IcariaItems.CHERT.get());
        anvilRecipes(registration, IcariaItems.CHERT_TOOLS.AXE.get(), IcariaItems.CHERT.get());
        anvilRecipes(registration, IcariaItems.CHERT_TOOLS.SCYTHE.get(), IcariaItems.CHERT.get());
        anvilRecipes(registration, IcariaItems.CHERT_TOOLS.BIDENT.get(), IcariaItems.CHERT.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.SWORD.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.DAGGER.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.SHOVEL.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.PICKAXE.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.AXE.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.SCYTHE.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.BIDENT.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.SWORD.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.DAGGER.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.SHOVEL.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.PICKAXE.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.AXE.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.SCYTHE.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.BIDENT.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.SWORD.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.DAGGER.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.SHOVEL.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.PICKAXE.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.AXE.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.SCYTHE.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.BIDENT.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.SWORD.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.DAGGER.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.SHOVEL.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.PICKAXE.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.AXE.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.SCYTHE.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.BIDENT.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.SWORD.get(), IcariaItems.SIDEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.DAGGER.get(), IcariaItems.SIDEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.SHOVEL.get(), IcariaItems.SIDEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.PICKAXE.get(), IcariaItems.SIDEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.AXE.get(), IcariaItems.SIDEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.SCYTHE.get(), IcariaItems.SIDEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.BIDENT.get(), IcariaItems.SIDEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.SWORD.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.DAGGER.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.SHOVEL.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.PICKAXE.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.AXE.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.SCYTHE.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.BIDENT.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.AETERNAE_HIDE_ARMOR.HELMET.get(), IcariaItems.AETERNAE_HIDE.get());
        anvilRecipes(registration, IcariaItems.AETERNAE_HIDE_ARMOR.CHESTPLATE.get(), IcariaItems.AETERNAE_HIDE.get());
        anvilRecipes(registration, IcariaItems.AETERNAE_HIDE_ARMOR.LEGGINGS.get(), IcariaItems.AETERNAE_HIDE.get());
        anvilRecipes(registration, IcariaItems.AETERNAE_HIDE_ARMOR.BOOTS.get(), IcariaItems.AETERNAE_HIDE.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_ARMOR.HELMET.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_ARMOR.CHESTPLATE.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_ARMOR.LEGGINGS.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.CHALKOS_ARMOR.BOOTS.get(), IcariaItems.CHALKOS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_ARMOR.HELMET.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_ARMOR.CHESTPLATE.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_ARMOR.LEGGINGS.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.KASSITEROS_ARMOR.BOOTS.get(), IcariaItems.KASSITEROS_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_HELMET.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_CHESTPLATE.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_LEGGINGS.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.ORICHALCUM_BOOTS.get(), IcariaItems.ORICHALCUM_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_ARMOR.HELMET.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_ARMOR.CHESTPLATE.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_ARMOR.LEGGINGS.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_ARMOR.BOOTS.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        anvilRecipes(registration, IcariaItems.TOTEM_OF_PREVENTATION.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        anvilRecipes(registration, IcariaItems.TOTEM_OF_STUFFING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        anvilRecipes(registration, IcariaItems.TOTEM_OF_UNBLINDING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        anvilRecipes(registration, IcariaItems.TOTEM_OF_UNDROWNING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        anvilRecipes(registration, IcariaItems.TOTEM_OF_UNDYING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        anvilRecipes(registration, IcariaItems.TOTEM_OF_UNSHATTERING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        anvilRecipes(registration, IcariaItems.TOTEM_OF_UNSINKING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
    }

    public void anvilRecipes(IRecipeRegistration registration, Item itemDamaged, Item itemRepair) {
        IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();

        ItemStack damagedThreeQuarter = new ItemStack(itemDamaged);
        ItemStack damagedHalf = new ItemStack(itemDamaged);
        ItemStack damaged = new ItemStack(itemDamaged);

        ItemStack repair = new ItemStack(itemRepair);

        damagedThreeQuarter.setDamageValue(damagedThreeQuarter.getMaxDamage() / 4 * 3);
        damagedHalf.setDamageValue(damagedHalf.getMaxDamage() / 4 * 2);
        damaged.setDamageValue(damaged.getMaxDamage());

        registration.addRecipes(RecipeTypes.ANVIL, List.of(factory.createAnvilRecipe(List.of(damagedThreeQuarter), List.of(damagedThreeQuarter), List.of(damagedHalf))));
        registration.addRecipes(RecipeTypes.ANVIL, List.of(factory.createAnvilRecipe(List.of(damaged), List.of(repair), List.of(damagedThreeQuarter))));
    }
}
