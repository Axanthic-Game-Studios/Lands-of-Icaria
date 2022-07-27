package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import com.google.common.collect.ImmutableSet;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class IcariaPOIs {
    public static DeferredRegister<PoiType> POIS = DeferredRegister.create(ForgeRegistries.POI_TYPES, IcariaInfo.MODID);

    public static RegistryObject<PoiType> ICARIA_PORTAL = POIS.register("icaria_portal", () -> new PoiType(getBlockStates(IcariaBlocks.ICARIA_PORTAL.get()), 0, 1));

    public static Set<BlockState> getBlockStates(Block block) {
        return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
    }
}
