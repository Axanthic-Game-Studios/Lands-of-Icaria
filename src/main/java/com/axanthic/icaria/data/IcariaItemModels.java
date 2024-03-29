package com.axanthic.icaria.data;

import com.axanthic.icaria.common.registry.IcariaArmorItems;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaToolItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaItemModels extends ItemModelProvider {
	public IcariaItemModels(PackOutput pOutput, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pId, pHelper);
	}

	@Override
	public void registerModels() {
		for (var items : IcariaItems.SIMPLE_ITEMS) {
			this.itemWithModel(items, "item/generated");
		}

		for (var items : IcariaToolItems.TOOL_ITEMS) {
			var name = items.bident.getId();
			var model = this.singleTexture(name.getPath() + "_throwing", new ResourceLocation(IcariaInfo.ID, "item/bident_throwing"), "layer0", new ResourceLocation(name.getNamespace(), "item/" + name.getPath()));
			this.itemWithModel(items.sword, "item/handheld");
			this.itemWithModel(items.dagger, "item/handheld");
			this.itemWithModel(items.shovel, "item/handheld");
			this.itemWithModel(items.pickaxe, "item/handheld");
			this.itemWithModel(items.axe, "item/handheld");
			this.itemWithModel(items.scythe, "item/handheld");
			this.itemWithModel(items.bident, new ResourceLocation(IcariaInfo.ID, "item/bident")).override().predicate(new ResourceLocation(IcariaInfo.ID, "throwing"), 1.0F).model(model).end();
		}

		for (var items : IcariaArmorItems.ARMOR_ITEMS) {
			this.itemWithModel(items.helmet, "item/generated");
			this.itemWithModel(items.chestplate, "item/generated");
			this.itemWithModel(items.leggings, "item/generated");
			this.itemWithModel(items.boots, "item/generated");
		}
	}

	public void itemWithModel(RegistryObject<? extends Item> pItem, String pModel) {
		this.itemWithModel(pItem, new ResourceLocation(pModel));
	}

	public ItemModelBuilder itemWithModel(RegistryObject<? extends Item> pItem, ResourceLocation pModel) {
		var name = pItem.getId();
		var texture = new ResourceLocation(name.getNamespace(), "item/" + name.getPath());
		return this.singleTexture(name.getPath(), pModel, "layer0", texture);
	}
}
