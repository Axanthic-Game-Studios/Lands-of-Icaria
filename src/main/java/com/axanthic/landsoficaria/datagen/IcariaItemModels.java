package com.axanthic.landsoficaria.datagen;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.google.gson.JsonObject;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class IcariaItemModels extends ItemModelProvider {

	public IcariaItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, LandsOfIcariaInfo.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {

	}

	public void itemWithModel(RegistryObject<? extends Item> registryObject, String model) {
		ResourceLocation id = registryObject.getId();
		ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
		singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void bucketModel(RegistryObject<? extends BucketItem> registryObject) {
		ModelBuilder builder = getBuilder(registryObject.getId().getPath()).parent(getExistingFile(new ResourceLocation(LandsOfIcariaInfo.MODID, "item/bucket_fluid")));

		//I'm not sure how this works but it works
		builder.customLoader((t, u) ->  new CustomLoaderBuilder(((ModelBuilder) t).getLocation(), (ModelBuilder) t, (ExistingFileHelper) u) {
			public JsonObject toJson(JsonObject json) {
				json.addProperty("loader", "forge:bucket");
				json.addProperty("fluid", registryObject.get().getFluid().getRegistryName().toString());
				return json;
			}
		});
	}
}
