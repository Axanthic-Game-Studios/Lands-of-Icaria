package com.axanthic.icaria.datagen;

import com.axanthic.icaria.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.ToolCombination;

import com.google.gson.JsonObject;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;

import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaItemModels extends ItemModelProvider {
	public IcariaItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, IcariaInfo.MODID, existingFileHelper);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void bucketModel(RegistryObject<? extends BucketItem> registryObject) {
		ModelBuilder builder = getBuilder(registryObject.getId().getPath()).parent(getExistingFile(new ResourceLocation(IcariaInfo.MODID, "item/bucket_fluid")));

		//I'm not sure how this works but it works
		builder.customLoader((t, u) -> new CustomLoaderBuilder(((ModelBuilder) t).getLocation(), (ModelBuilder) t, (ExistingFileHelper) u) {
			@Override
			public JsonObject toJson(JsonObject json) {
				json.addProperty("loader", "forge:bucket");
				json.addProperty("fluid", Objects.requireNonNull(registryObject.get().getFluid().getRegistryName()).toString());
				return json;
			}
		});
	}

	@Override
	public void registerModels() {
		for (RegistryObject<? extends Item> item : IcariaItems.BASIC_ITEMS) {
			itemWithModel(item, "item/generated");
		}
		for (ToolCombination tools : IcariaItems.TOOLS) {
			itemWithModel(tools.SWORD, "item/handheld");
			itemWithModel(tools.SHOVEL, "item/handheld");
			itemWithModel(tools.PICKAXE, "item/handheld");
			itemWithModel(tools.AXE, "item/handheld");
			itemWithModel(tools.SCYTHE, "item/handheld");
			ResourceLocation id = tools.BIDENT.getId();
			ItemModelBuilder throwingModel = singleTexture(id.getPath() + "_throwing", new ResourceLocation(IcariaInfo.MODID, "item/bident_throwing"), "layer0", new ResourceLocation(id.getNamespace(), "item/" + id.getPath()));
			itemWithModel(tools.BIDENT, new ResourceLocation(IcariaInfo.MODID, "item/bident")).override().predicate(new ResourceLocation(IcariaInfo.MODID, "throwing"), 1.0F).model(throwingModel).end();
		}
	}

	public ItemModelBuilder itemWithModel(RegistryObject<? extends Item> registryObject, ResourceLocation model) {
		ResourceLocation id = registryObject.getId();
		ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
		return singleTexture(id.getPath(), model, "layer0", textureLocation);
	}

	public ItemModelBuilder itemWithModel(RegistryObject<? extends Item> registryObject, String model) {
		return itemWithModel(registryObject, new ResourceLocation(model));
	}
}
