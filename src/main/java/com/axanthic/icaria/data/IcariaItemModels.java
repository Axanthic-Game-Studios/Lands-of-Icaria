package com.axanthic.icaria.data;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.ToolCombination;

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
			itemWithModel(registryObject, "item/generated");
		}

		for (ToolCombination tools : IcariaItems.TOOLS) {
			itemWithModel(tools.SWORD, "item/handheld");
			itemWithModel(tools.DAGGER, "item/handheld");
			itemWithModel(tools.SHOVEL, "item/handheld");
			itemWithModel(tools.PICKAXE, "item/handheld");
			itemWithModel(tools.AXE, "item/handheld");
			itemWithModel(tools.SCYTHE, "item/handheld");
			ResourceLocation id = tools.BIDENT.getId();
			ItemModelBuilder throwingModel = singleTexture(id.getPath() + "_throwing", new ResourceLocation(IcariaInfo.MODID, "item/bident_throwing"), "layer0", new ResourceLocation(id.getNamespace(), "item/" + id.getPath()));
			itemWithModel(tools.BIDENT, new ResourceLocation(IcariaInfo.MODID, "item/bident")).override().predicate(new ResourceLocation(IcariaInfo.MODID, "throwing"), 1.0F).model(throwingModel).end();
		}
	}

	public ItemModelBuilder itemWithModel(RegistryObject<? extends Item> registryObject, ResourceLocation resourceLocation) {
		ResourceLocation id = registryObject.getId();
		ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
		return singleTexture(id.getPath(), resourceLocation, "layer0", textureLocation);
	}

	public void itemWithModel(RegistryObject<? extends Item> registryObject, String model) {
		itemWithModel(registryObject, new ResourceLocation(model));
	}
}
