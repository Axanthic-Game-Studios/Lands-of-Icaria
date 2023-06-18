package com.axanthic.icaria.data;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaItems;

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
		for (RegistryObject<? extends Item> basicItems : IcariaItems.BASIC_ITEMS) {
			this.itemWithModel(basicItems, "item/generated");
		}

		for (IcariaItems.ToolSet tools : IcariaItems.TOOLS) {
			var name = tools.bident.getId();
			var model = this.singleTexture(name.getPath() + "_throwing", new ResourceLocation(IcariaInfo.ID, "item/bident_throwing"), "layer0", new ResourceLocation(name.getNamespace(), "item/" + name.getPath()));
			this.itemWithModel(tools.sword, "item/handheld");
			this.itemWithModel(tools.dagger, "item/handheld");
			this.itemWithModel(tools.shovel, "item/handheld");
			this.itemWithModel(tools.pickaxe, "item/handheld");
			this.itemWithModel(tools.axe, "item/handheld");
			this.itemWithModel(tools.scythe, "item/handheld");
			this.itemWithModel(tools.bident, new ResourceLocation(IcariaInfo.ID, "item/bident")).override().predicate(new ResourceLocation(IcariaInfo.ID, "throwing"), 1.0F).model(model).end();
		}

		for (IcariaItems.ArmorSet armor : IcariaItems.ARMOR) {
			this.itemWithModel(armor.helmet, "item/generated");
			this.itemWithModel(armor.chestplate, "item/generated");
			this.itemWithModel(armor.leggings, "item/generated");
			this.itemWithModel(armor.boots, "item/generated");
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
