package com.axanthic.icaria.data;

import com.axanthic.icaria.common.util.IcariaInfo;
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
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings({"unchecked", "rawtypes"})
@ParametersAreNonnullByDefault

public class IcariaItemModels extends ItemModelProvider {
	public IcariaItemModels(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, IcariaInfo.MODID, helper);
	}

	public void bucketModel(RegistryObject<? extends BucketItem> registryObject) {
		ModelBuilder<ItemModelBuilder> builder = getBuilder(registryObject.getId().getPath()).parent(getExistingFile(new ResourceLocation(IcariaInfo.MODID, "item/bucket_fluid")));

		//I'm not sure how this works but it works
		builder.customLoader((t, u) -> new CustomLoaderBuilder(t.getLocation(), t, u) {
			@Override
			public JsonObject toJson(JsonObject jsonObject) {
				jsonObject.addProperty("loader", "forge:bucket");
				jsonObject.addProperty("fluid", Objects.requireNonNull(ForgeRegistries.FLUIDS.getKey(registryObject.get().getFluid())).toString());
				return jsonObject;
			}
		});
	}

	@Override
	public void registerModels() {
		for (RegistryObject<? extends Item> registryObject : IcariaItems.BASIC_ITEMS) {
			itemWithModel(registryObject, "item/generated");
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

	public ItemModelBuilder itemWithModel(RegistryObject<? extends Item> registryObject, ResourceLocation resourceLocation) {
		ResourceLocation id = registryObject.getId();
		ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
		return singleTexture(id.getPath(), resourceLocation, "layer0", textureLocation);
	}

	public void itemWithModel(RegistryObject<? extends Item> registryObject, String model) {
		itemWithModel(registryObject, new ResourceLocation(model));
	}
}
