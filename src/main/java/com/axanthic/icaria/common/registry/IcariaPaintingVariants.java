package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingVariants {
	public static final ResourceKey<PaintingVariant> BRIDGE = IcariaPaintingVariants.createKey("bridge");
	public static final ResourceKey<PaintingVariant> CACTUS = IcariaPaintingVariants.createKey("cactus");
	public static final ResourceKey<PaintingVariant> MOONS = IcariaPaintingVariants.createKey("moons");
	public static final ResourceKey<PaintingVariant> PERFECTION = IcariaPaintingVariants.createKey("perfection");
	public static final ResourceKey<PaintingVariant> PORTAL = IcariaPaintingVariants.createKey("portal");
	public static final ResourceKey<PaintingVariant> PYRO = IcariaPaintingVariants.createKey("pyro");

	public static void bootstrap(BootstrapContext<PaintingVariant> pContext) {
		pContext.register(IcariaPaintingVariants.BRIDGE, new PaintingVariant(2, 2, IcariaPaintingVariants.BRIDGE.location()));
		pContext.register(IcariaPaintingVariants.CACTUS, new PaintingVariant(1, 1, IcariaPaintingVariants.CACTUS.location()));
		pContext.register(IcariaPaintingVariants.MOONS, new PaintingVariant(2, 1, IcariaPaintingVariants.MOONS.location()));
		pContext.register(IcariaPaintingVariants.PERFECTION, new PaintingVariant(2, 2, IcariaPaintingVariants.PERFECTION.location()));
		pContext.register(IcariaPaintingVariants.PORTAL, new PaintingVariant(2, 2, IcariaPaintingVariants.PORTAL.location()));
		pContext.register(IcariaPaintingVariants.PYRO, new PaintingVariant(1, 2, IcariaPaintingVariants.PYRO.location()));
	}

	public static ResourceKey<PaintingVariant> createKey(String pName) {
		return ResourceKey.create(Registries.PAINTING_VARIANT, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
