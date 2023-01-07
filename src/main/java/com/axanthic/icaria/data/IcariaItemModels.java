package com.axanthic.icaria.data;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaItemModels extends ItemModelProvider {
	public IcariaItemModels(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, IcariaInfo.MODID, helper);
	}

	@Override
	public void registerModels() {
		for (RegistryObject<? extends Item> registryObject : IcariaItems.BASIC_ITEMS) {
			this.itemWithModel(registryObject, "item/generated");
		}

		for (IcariaItems.ToolSet tools : IcariaItems.TOOLS) {
			this.itemWithModel(tools.sword, "item/handheld");
			this.itemWithModel(tools.dagger, "item/handheld");
			this.itemWithModel(tools.shovel, "item/handheld");
			this.itemWithModel(tools.pickaxe, "item/handheld");
			this.itemWithModel(tools.axe, "item/handheld");
			this.itemWithModel(tools.scythe, "item/handheld");

			ResourceLocation id = tools.bident.getId();
			ItemModelBuilder throwingModel = this.singleTexture(id.getPath() + "_throwing", new ResourceLocation(IcariaInfo.MODID, "item/bident_throwing"), "layer0", new ResourceLocation(id.getNamespace(), "item/" + id.getPath()));

			this.itemWithModel(tools.bident, new ResourceLocation(IcariaInfo.MODID, "item/bident")).override().predicate(new ResourceLocation(IcariaInfo.MODID, "throwing"), 1.0F).model(throwingModel).end();
		}

		for (IcariaItems.ArmorSet armor : IcariaItems.ARMOR) {
			this.itemWithModel(armor.helmet, "item/generated");
			this.itemWithModel(armor.chestplate, "item/generated");
			this.itemWithModel(armor.leggings, "item/generated");
			this.itemWithModel(armor.boots, "item/generated");
		}
	}

	public ItemModelBuilder itemWithModel(RegistryObject<? extends Item> registryObject, ResourceLocation resourceLocation) {
		ResourceLocation id = registryObject.getId();
		ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());

		return this.singleTexture(id.getPath(), resourceLocation, "layer0", textureLocation);
	}

	public void itemWithModel(RegistryObject<? extends Item> registryObject, String model) {
		this.itemWithModel(registryObject, new ResourceLocation(model));
	}
}
