package com.axanthic.icaria.integration;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@JeiPlugin
public class JeiIntegration implements IModPlugin {
    public static final ResourceLocation ID = new ResourceLocation(IcariaInfo.MODID, "main");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        this.anvilRecipes(registration, IcariaItems.CHERT_TOOLS.sword.get(), IcariaItems.CHERT.get());
        this.anvilRecipes(registration, IcariaItems.CHERT_TOOLS.dagger.get(), IcariaItems.CHERT.get());
        this.anvilRecipes(registration, IcariaItems.CHERT_TOOLS.shovel.get(), IcariaItems.CHERT.get());
        this.anvilRecipes(registration, IcariaItems.CHERT_TOOLS.pickaxe.get(), IcariaItems.CHERT.get());
        this.anvilRecipes(registration, IcariaItems.CHERT_TOOLS.axe.get(), IcariaItems.CHERT.get());
        this.anvilRecipes(registration, IcariaItems.CHERT_TOOLS.scythe.get(), IcariaItems.CHERT.get());
        this.anvilRecipes(registration, IcariaItems.CHERT_TOOLS.bident.get(), IcariaItems.CHERT.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.sword.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.dagger.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.shovel.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.pickaxe.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.axe.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.scythe.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_TOOLS.bident.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.sword.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.dagger.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.shovel.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.pickaxe.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.axe.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.scythe.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_TOOLS.bident.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.sword.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.dagger.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.shovel.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.pickaxe.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.axe.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.scythe.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_TOOLS.bident.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.sword.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.shovel.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.axe.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_TOOLS.bident.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.sword.get(), IcariaItems.SIDEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.dagger.get(), IcariaItems.SIDEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.shovel.get(), IcariaItems.SIDEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.pickaxe.get(), IcariaItems.SIDEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.axe.get(), IcariaItems.SIDEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.scythe.get(), IcariaItems.SIDEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.SIDEROS_TOOLS.bident.get(), IcariaItems.SIDEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.shovel.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get(), IcariaItems.AETERNAE_HIDE.get());
        this.anvilRecipes(registration, IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get(), IcariaItems.AETERNAE_HIDE.get());
        this.anvilRecipes(registration, IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get(), IcariaItems.AETERNAE_HIDE.get());
        this.anvilRecipes(registration, IcariaItems.AETERNAE_HIDE_ARMOR.boots.get(), IcariaItems.AETERNAE_HIDE.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_ARMOR.helmet.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_ARMOR.chestplate.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_ARMOR.leggings.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.CHALKOS_ARMOR.boots.get(), IcariaItems.CHALKOS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_ARMOR.helmet.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_ARMOR.chestplate.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_ARMOR.leggings.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.KASSITEROS_ARMOR.boots.get(), IcariaItems.KASSITEROS_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_HELMET.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_CHESTPLATE.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_LEGGINGS.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.ORICHALCUM_BOOTS.get(), IcariaItems.ORICHALCUM_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.VANADIUMSTEEL_ARMOR.boots.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
        this.anvilRecipes(registration, IcariaItems.TOTEM_OF_PREVENTATION.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        this.anvilRecipes(registration, IcariaItems.TOTEM_OF_STUFFING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        this.anvilRecipes(registration, IcariaItems.TOTEM_OF_UNBLINDING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        this.anvilRecipes(registration, IcariaItems.TOTEM_OF_UNDROWNING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        this.anvilRecipes(registration, IcariaItems.TOTEM_OF_UNDYING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        this.anvilRecipes(registration, IcariaItems.TOTEM_OF_UNSHATTERING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
        this.anvilRecipes(registration, IcariaItems.TOTEM_OF_UNSINKING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
    }
    
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    	IModPlugin.super.registerRecipeCatalysts(registration);
    	registration.addRecipeCatalyst(new ItemStack(IcariaItems.LAUREL_CRAFTING_TABLE.get()), RecipeTypes.CRAFTING);
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
