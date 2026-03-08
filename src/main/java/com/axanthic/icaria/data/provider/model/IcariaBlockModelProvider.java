package com.axanthic.icaria.data.provider.model;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.model.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockModelProvider {

	public static void register(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.provider(pBlockModelGenerators);
		IcariaBlockModelProvider.template(pBlockModelGenerators);
	}

	public static void provider(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.amphora(pBlockModelGenerators);
		IcariaBlockModelProvider.anthraciteTorch(pBlockModelGenerators);
		IcariaBlockModelProvider.anthraciteWallTorch(pBlockModelGenerators);
		IcariaBlockModelProvider.axis(pBlockModelGenerators);
		IcariaBlockModelProvider.barrel(pBlockModelGenerators);
		IcariaBlockModelProvider.bars(pBlockModelGenerators);
		IcariaBlockModelProvider.basinsCountertop(pBlockModelGenerators);
		IcariaBlockModelProvider.bathtub(pBlockModelGenerators);
		IcariaBlockModelProvider.block(pBlockModelGenerators);
		IcariaBlockModelProvider.blockCutout(pBlockModelGenerators);
		IcariaBlockModelProvider.blockTranslucent(pBlockModelGenerators);
		IcariaBlockModelProvider.bloomyVine(pBlockModelGenerators);
		IcariaBlockModelProvider.bolbos(pBlockModelGenerators);
		IcariaBlockModelProvider.bromelia(pBlockModelGenerators);
		IcariaBlockModelProvider.brownGroundShrooms(pBlockModelGenerators);
		IcariaBlockModelProvider.brushyVine(pBlockModelGenerators);
		IcariaBlockModelProvider.button(pBlockModelGenerators);
		IcariaBlockModelProvider.cake(pBlockModelGenerators);
		IcariaBlockModelProvider.calciteCrystal(pBlockModelGenerators);
		IcariaBlockModelProvider.cardonCactus(pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(pBlockModelGenerators);
		IcariaBlockModelProvider.chain(pBlockModelGenerators);
		IcariaBlockModelProvider.checkers(pBlockModelGenerators);
		IcariaBlockModelProvider.chess(pBlockModelGenerators);
		IcariaBlockModelProvider.chimney(pBlockModelGenerators);
		IcariaBlockModelProvider.chimneyBrickCrown(pBlockModelGenerators);
		IcariaBlockModelProvider.chimneyGrateCrown(pBlockModelGenerators);
		IcariaBlockModelProvider.chimneySlab(pBlockModelGenerators);
		IcariaBlockModelProvider.countertop(pBlockModelGenerators);
		IcariaBlockModelProvider.craftingTable(pBlockModelGenerators);
		IcariaBlockModelProvider.crop(pBlockModelGenerators);
		IcariaBlockModelProvider.cross(pBlockModelGenerators);
		IcariaBlockModelProvider.cupboard(pBlockModelGenerators);
		IcariaBlockModelProvider.cuttingBoard(pBlockModelGenerators);
		IcariaBlockModelProvider.dathulla(pBlockModelGenerators);
		IcariaBlockModelProvider.deadDroughtrootLog(pBlockModelGenerators);
		IcariaBlockModelProvider.deadLog(pBlockModelGenerators);
		IcariaBlockModelProvider.dishesCupboard(pBlockModelGenerators);
		IcariaBlockModelProvider.dolomitePillarHead(pBlockModelGenerators);
		IcariaBlockModelProvider.door(pBlockModelGenerators);
		IcariaBlockModelProvider.fallenLeaves(pBlockModelGenerators);
		IcariaBlockModelProvider.farmland(pBlockModelGenerators);
		IcariaBlockModelProvider.fence(pBlockModelGenerators);
		IcariaBlockModelProvider.fenceGate(pBlockModelGenerators);
		IcariaBlockModelProvider.fertilizedFarmland(pBlockModelGenerators);
		IcariaBlockModelProvider.fire(pBlockModelGenerators);
		IcariaBlockModelProvider.firewood(pBlockModelGenerators);
		IcariaBlockModelProvider.firewoodWedge(pBlockModelGenerators);
		IcariaBlockModelProvider.flasksCupboard(pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCountertop(pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCross(pBlockModelGenerators);
		IcariaBlockModelProvider.forge(pBlockModelGenerators);
		IcariaBlockModelProvider.grassyMarl(pBlockModelGenerators);
		IcariaBlockModelProvider.grateFireplace(pBlockModelGenerators);
		IcariaBlockModelProvider.greenGroundShrooms(pBlockModelGenerators);
		IcariaBlockModelProvider.grinder(pBlockModelGenerators);
		IcariaBlockModelProvider.grinderShaft(pBlockModelGenerators);
		IcariaBlockModelProvider.grinderStone(pBlockModelGenerators);
		IcariaBlockModelProvider.groundFlowers(pBlockModelGenerators);
		IcariaBlockModelProvider.haliteCrystal(pBlockModelGenerators);
		IcariaBlockModelProvider.herbHolder(pBlockModelGenerators);
		IcariaBlockModelProvider.horizontalBars(pBlockModelGenerators);
		IcariaBlockModelProvider.horizontalPane(pBlockModelGenerators);
		IcariaBlockModelProvider.jasperCrystal(pBlockModelGenerators);
		IcariaBlockModelProvider.kettle(pBlockModelGenerators);
		IcariaBlockModelProvider.kiln(pBlockModelGenerators);
		IcariaBlockModelProvider.kitchenTable(pBlockModelGenerators);
		IcariaBlockModelProvider.kline(pBlockModelGenerators);
		IcariaBlockModelProvider.ladder(pBlockModelGenerators);
		IcariaBlockModelProvider.largeBowls(pBlockModelGenerators);
		IcariaBlockModelProvider.largeBrownGroundShrooms(pBlockModelGenerators);
		IcariaBlockModelProvider.ligniteTorch(pBlockModelGenerators);
		IcariaBlockModelProvider.ligniteWallTorch(pBlockModelGenerators);
		IcariaBlockModelProvider.loadedBarrel(pBlockModelGenerators);
		IcariaBlockModelProvider.lootVase(pBlockModelGenerators);
		IcariaBlockModelProvider.mondanos(pBlockModelGenerators);
		IcariaBlockModelProvider.mortarCountertop(pBlockModelGenerators);
		IcariaBlockModelProvider.moss(pBlockModelGenerators);
		IcariaBlockModelProvider.mothAgaric(pBlockModelGenerators);
		IcariaBlockModelProvider.namdrake(pBlockModelGenerators);
		IcariaBlockModelProvider.oliveLeaves(pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureBlock(pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureVine(pBlockModelGenerators);
		IcariaBlockModelProvider.palmFern(pBlockModelGenerators);
		IcariaBlockModelProvider.panHolder(pBlockModelGenerators);
		IcariaBlockModelProvider.pane(pBlockModelGenerators);
		IcariaBlockModelProvider.path(pBlockModelGenerators);
		IcariaBlockModelProvider.particle(pBlockModelGenerators);
		IcariaBlockModelProvider.physalisCrop(pBlockModelGenerators);
		IcariaBlockModelProvider.plates(pBlockModelGenerators);
		IcariaBlockModelProvider.portal(pBlockModelGenerators);
		IcariaBlockModelProvider.pot(pBlockModelGenerators);
		IcariaBlockModelProvider.potCountertop(pBlockModelGenerators);
		IcariaBlockModelProvider.potFireplace(pBlockModelGenerators);
		IcariaBlockModelProvider.potHolder(pBlockModelGenerators);
		IcariaBlockModelProvider.potsCupboard(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedBromelia(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedBrownGroundShrooms(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedCardonCactus(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedGreenGroundShrooms(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedLargeBrownGroundShrooms(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedPalmFern(pBlockModelGenerators);
		IcariaBlockModelProvider.pressurePlate(pBlockModelGenerators);
		IcariaBlockModelProvider.psilocybos(pBlockModelGenerators);
		IcariaBlockModelProvider.quartzPillarHead(pBlockModelGenerators);
		IcariaBlockModelProvider.quartzWall(pBlockModelGenerators);
		IcariaBlockModelProvider.rack(pBlockModelGenerators);
		IcariaBlockModelProvider.raisedBasinsCountertop(pBlockModelGenerators);
		IcariaBlockModelProvider.relicstonePillarHead(pBlockModelGenerators);
		IcariaBlockModelProvider.rottenBoneLadder(pBlockModelGenerators);
		IcariaBlockModelProvider.rowan(pBlockModelGenerators);
		IcariaBlockModelProvider.rubble(pBlockModelGenerators);
		IcariaBlockModelProvider.scrollshelf(pBlockModelGenerators);
		IcariaBlockModelProvider.simpleRack(pBlockModelGenerators);
		IcariaBlockModelProvider.slab(pBlockModelGenerators);
		IcariaBlockModelProvider.smallBowls(pBlockModelGenerators);
		IcariaBlockModelProvider.spoonHolder(pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(pBlockModelGenerators);
		IcariaBlockModelProvider.stool(pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(pBlockModelGenerators);
		IcariaBlockModelProvider.strawberryBush(pBlockModelGenerators);
		IcariaBlockModelProvider.strawberryCrop(pBlockModelGenerators);
		IcariaBlockModelProvider.strippedDeadLog(pBlockModelGenerators);
		IcariaBlockModelProvider.surfaceBones(pBlockModelGenerators);
		IcariaBlockModelProvider.surfaceChert(pBlockModelGenerators);
		IcariaBlockModelProvider.suspiciousSand(pBlockModelGenerators);
		IcariaBlockModelProvider.suspiciousSubstance(pBlockModelGenerators);
		IcariaBlockModelProvider.tappedBarrel(pBlockModelGenerators);
		IcariaBlockModelProvider.tinderFungusTreeShrooms(pBlockModelGenerators);
		IcariaBlockModelProvider.tintedCross(pBlockModelGenerators);
		IcariaBlockModelProvider.tintedFlowerPotCross(pBlockModelGenerators);
		IcariaBlockModelProvider.towelHolder(pBlockModelGenerators);
		IcariaBlockModelProvider.trapdoor(pBlockModelGenerators);
		IcariaBlockModelProvider.tripleBarrelRack(pBlockModelGenerators);
		IcariaBlockModelProvider.trough(pBlockModelGenerators);
		IcariaBlockModelProvider.turkeyTailTreeShrooms(pBlockModelGenerators);
		IcariaBlockModelProvider.twigs(pBlockModelGenerators);
		IcariaBlockModelProvider.unnamedTreeShrooms(pBlockModelGenerators);
		IcariaBlockModelProvider.vase(pBlockModelGenerators);
		IcariaBlockModelProvider.vaseCupboard(pBlockModelGenerators);
		IcariaBlockModelProvider.vine(pBlockModelGenerators);
		IcariaBlockModelProvider.wall(pBlockModelGenerators);
		IcariaBlockModelProvider.water(pBlockModelGenerators);
		IcariaBlockModelProvider.wiltedElm(pBlockModelGenerators);
		IcariaBlockModelProvider.wood(pBlockModelGenerators);
		IcariaBlockModelProvider.zirconCrystal(pBlockModelGenerators);
	}

	public static void template(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.amphoraModel(pBlockModelGenerators);
		IcariaBlockModelProvider.anthraciteTorchModel(pBlockModelGenerators);
		IcariaBlockModelProvider.anthraciteWallTorchModel(pBlockModelGenerators);
		IcariaBlockModelProvider.barrelModel(pBlockModelGenerators);
		IcariaBlockModelProvider.barsInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.basinsCountertopModel(pBlockModelGenerators);
		IcariaBlockModelProvider.bathtubInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.bathtubModel(pBlockModelGenerators);
		IcariaBlockModelProvider.bolbosModel(pBlockModelGenerators);
		IcariaBlockModelProvider.bromeliaModel(pBlockModelGenerators);
		IcariaBlockModelProvider.brownGroundShroomsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.cakeModel(pBlockModelGenerators);
		IcariaBlockModelProvider.calciteCrystalModel(pBlockModelGenerators);
		IcariaBlockModelProvider.cardonCactusInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.cardonCactusModel(pBlockModelGenerators);
		IcariaBlockModelProvider.checkersModel(pBlockModelGenerators);
		IcariaBlockModelProvider.chessModel(pBlockModelGenerators);
		IcariaBlockModelProvider.chimneyModel(pBlockModelGenerators);
		IcariaBlockModelProvider.chimneyBrickCrownModel(pBlockModelGenerators);
		IcariaBlockModelProvider.chimneyGrateCrownModel(pBlockModelGenerators);
		IcariaBlockModelProvider.chimneySlabModel(pBlockModelGenerators);
		IcariaBlockModelProvider.countertopModel(pBlockModelGenerators);
		IcariaBlockModelProvider.cupboardModel(pBlockModelGenerators);
		IcariaBlockModelProvider.cuttingBoardModel(pBlockModelGenerators);
		IcariaBlockModelProvider.dathullaModel(pBlockModelGenerators);
		IcariaBlockModelProvider.deadLogModel(pBlockModelGenerators);
		IcariaBlockModelProvider.deadVineModel(pBlockModelGenerators);
		IcariaBlockModelProvider.dishesCupboardModel(pBlockModelGenerators);
		IcariaBlockModelProvider.firewoodModel(pBlockModelGenerators);
		IcariaBlockModelProvider.firewoodWedgeModel(pBlockModelGenerators);
		IcariaBlockModelProvider.flasksCupboardModel(pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCountertopModel(pBlockModelGenerators);
		IcariaBlockModelProvider.forgeInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.forgeModel(pBlockModelGenerators);
		IcariaBlockModelProvider.grateFireplaceInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.grateFireplaceModel(pBlockModelGenerators);
		IcariaBlockModelProvider.greenGroundShroomsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.grinderInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.grinderModel(pBlockModelGenerators);
		IcariaBlockModelProvider.grinderShaftModel(pBlockModelGenerators);
		IcariaBlockModelProvider.grinderStoneModel(pBlockModelGenerators);
		IcariaBlockModelProvider.haliteCrystalModel(pBlockModelGenerators);
		IcariaBlockModelProvider.herbHolderModel(pBlockModelGenerators);
		IcariaBlockModelProvider.horizontalBarsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.horizontalPaneModel(pBlockModelGenerators);
		IcariaBlockModelProvider.jasperCrystalModel(pBlockModelGenerators);
		IcariaBlockModelProvider.kettleInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.kettleModel(pBlockModelGenerators);
		IcariaBlockModelProvider.kilnInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.kilnModel(pBlockModelGenerators);
		IcariaBlockModelProvider.kitchenTableInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.kitchenTableModel(pBlockModelGenerators);
		IcariaBlockModelProvider.klineInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.klineModel(pBlockModelGenerators);
		IcariaBlockModelProvider.largeBowlsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.largeBrownGroundShroomsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.layerModel(pBlockModelGenerators);
		IcariaBlockModelProvider.ligniteTorchModel(pBlockModelGenerators);
		IcariaBlockModelProvider.ligniteWallTorchModel(pBlockModelGenerators);
		IcariaBlockModelProvider.lootVaseModel(pBlockModelGenerators);
		IcariaBlockModelProvider.mondanosModel(pBlockModelGenerators);
		IcariaBlockModelProvider.mortarCountertopModel(pBlockModelGenerators);
		IcariaBlockModelProvider.mothAgaricModel(pBlockModelGenerators);
		IcariaBlockModelProvider.namdrakeModel(pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureBlockModel(pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCrossModel(pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCrossModel(pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureVineModel(pBlockModelGenerators);
		IcariaBlockModelProvider.palmFernModel(pBlockModelGenerators);
		IcariaBlockModelProvider.panHolderModel(pBlockModelGenerators);
		IcariaBlockModelProvider.paneInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.physalisCropModel(pBlockModelGenerators);
		IcariaBlockModelProvider.platesModel(pBlockModelGenerators);
		IcariaBlockModelProvider.portalModel(pBlockModelGenerators);
		IcariaBlockModelProvider.potModel(pBlockModelGenerators);
		IcariaBlockModelProvider.potCountertopModel(pBlockModelGenerators);
		IcariaBlockModelProvider.potFireplaceInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.potFireplaceModel(pBlockModelGenerators);
		IcariaBlockModelProvider.potHolderModel(pBlockModelGenerators);
		IcariaBlockModelProvider.potsCupboardModel(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedBromeliaModel(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedBrownGroundShroomsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedCardonCactusModel(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedGreenGroundShroomsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedLargeBrownGroundShroomsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.pottedPalmFernModel(pBlockModelGenerators);
		IcariaBlockModelProvider.psilocybosModel(pBlockModelGenerators);
		IcariaBlockModelProvider.rackModel(pBlockModelGenerators);
		IcariaBlockModelProvider.raisedBasinsCountertopModel(pBlockModelGenerators);
		IcariaBlockModelProvider.rowanModel(pBlockModelGenerators);
		IcariaBlockModelProvider.rubbleModel(pBlockModelGenerators);
		IcariaBlockModelProvider.simpleRackModel(pBlockModelGenerators);
		IcariaBlockModelProvider.smallBowlsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.spoonHolderModel(pBlockModelGenerators);
		IcariaBlockModelProvider.stoolModel(pBlockModelGenerators);
		IcariaBlockModelProvider.storageVaseModel(pBlockModelGenerators);
		IcariaBlockModelProvider.strawberryBushModel(pBlockModelGenerators);
		IcariaBlockModelProvider.strippedDeadLogModel(pBlockModelGenerators);
		IcariaBlockModelProvider.surfaceBonesModel(pBlockModelGenerators);
		IcariaBlockModelProvider.surfaceChertModel(pBlockModelGenerators);
		IcariaBlockModelProvider.suspiciousSubstanceModel(pBlockModelGenerators);
		IcariaBlockModelProvider.tappedBarrelModel(pBlockModelGenerators);
		IcariaBlockModelProvider.tinderFungusTreeShroomsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.towelHolderModel(pBlockModelGenerators);
		IcariaBlockModelProvider.tripleBarrelRackInventoryModel(pBlockModelGenerators);
		IcariaBlockModelProvider.tripleBarrelRackModel(pBlockModelGenerators);
		IcariaBlockModelProvider.troughModel(pBlockModelGenerators);
		IcariaBlockModelProvider.turkeyTailTreeShroomsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.twigsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.unnamedTreeShroomsModel(pBlockModelGenerators);
		IcariaBlockModelProvider.vaseModel(pBlockModelGenerators);
		IcariaBlockModelProvider.vaseCupboardModel(pBlockModelGenerators);
		IcariaBlockModelProvider.wiltedElmModel(pBlockModelGenerators);
		IcariaBlockModelProvider.zirconCrystalModel(pBlockModelGenerators);
	}

	public static void amphora(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.amphora(IcariaBlocks.AMPHORA.get(), pBlockModelGenerators);
	}

	public static void anthraciteTorch(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.anthraciteTorch(IcariaBlocks.ANTHRACITE_TORCH.get(), pBlockModelGenerators);
	}

	public static void anthraciteWallTorch(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.anthraciteWallTorch(IcariaBlocks.ANTHRACITE_WALL_TORCH.get(), pBlockModelGenerators);
	}

	public static void axis(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.axis(IcariaBlocks.DOLOMITE_PILLAR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.RELICSTONE_PILLAR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.SPELT_BALE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.DROUGHTROOT_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.STRIPPED_FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.STRIPPED_OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.STRIPPED_PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.POPULUS_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.axis(IcariaBlocks.STRIPPED_POPULUS_LOG.get(), pBlockModelGenerators);
	}

	public static void barrel(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.barrel(IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.barrel(IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.barrel(IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.barrel(IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.barrel(IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.barrel(IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.barrel(IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void bars(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.bars(IcariaBlocks.VANADIUMSTEEL_BARS.get(), pBlockModelGenerators);
	}

	public static void basinsCountertop(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.basinsCountertop(IcariaBlocks.CYPRESS_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.basinsCountertop(IcariaBlocks.DROUGHTROOT_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.basinsCountertop(IcariaBlocks.FIR_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.basinsCountertop(IcariaBlocks.LAUREL_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.basinsCountertop(IcariaBlocks.OLIVE_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.basinsCountertop(IcariaBlocks.PLANE_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.basinsCountertop(IcariaBlocks.POPULUS_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
	}

	public static void bathtub(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.bathtub(IcariaBlocks.CYPRESS_BATHTUB.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.bathtub(IcariaBlocks.DROUGHTROOT_BATHTUB.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.bathtub(IcariaBlocks.FIR_BATHTUB.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.bathtub(IcariaBlocks.LAUREL_BATHTUB.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.bathtub(IcariaBlocks.OLIVE_BATHTUB.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.bathtub(IcariaBlocks.PLANE_BATHTUB.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.bathtub(IcariaBlocks.POPULUS_BATHTUB.get(), pBlockModelGenerators);
	}

	public static void block(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.block(IcariaBlocks.MARL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.MARL_CHERT.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.MARL_BONES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.MARL_LIGNITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.COARSE_MARL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.DRY_LAKE_BED.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.MARL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.LOAM.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.LOAM_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.DOLOMITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SMOOTH_DOLOMITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.DOLOMITE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHISELED_DOLOMITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.GRAINEL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.GRAINEL_CHERT.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.GRAINITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.GRAINITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.GRAINITE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHISELED_GRAINITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.YELLOWSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.COBBLED_YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.YELLOWSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHISELED_YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SILKSAND.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SILKSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.COBBLED_SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SILKSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHISELED_SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SUNSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.COBBLED_SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SUNSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHISELED_SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.VOIDSHALE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.COBBLED_VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.VOIDSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHISELED_VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BAETYL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.COBBLED_BAETYL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BAETYL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BAETYL_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHISELED_BAETYL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SMOOTH_RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.MOSSY_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHISELED_RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.PLATOSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.PLATOSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHISELED_PLATOSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.LIGNITE_ORE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHALKOS_ORE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.KASSITEROS_ORE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.DOLOMITE_ORE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.VANADIUM_ORE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SLIVER_ORE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SIDEROS_ORE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.ANTHRACITE_ORE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.MOLYBDENUM_ORE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.HYLIASTRUM_ORE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CALCITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BUDDING_CALCITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.HALITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BUDDING_HALITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.JASPER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BUDDING_JASPER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.ZIRCON.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BUDDING_ZIRCON.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.PACKED_ARISTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.WHITE_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.GRAY_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BLACK_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BROWN_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.RED_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.ORANGE_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.YELLOW_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.LIME_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.GREEN_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CYAN_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BLUE_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.PURPLE_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.MAGENTA_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.PINK_ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.VINE_REED_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.ROTTEN_BONES_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.RAW_CHALKOS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.RAW_KASSITEROS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.RAW_VANADIUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.RAW_SIDEROS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.JASPER_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHERT_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.LIGNITE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CHALKOS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.KASSITEROS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.ORICHALCUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.VANADIUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SLIVER_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.VANADIUMSTEEL_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.SIDEROS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.ANTHRACITE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.MOLYBDENUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.BLURIDIUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CYPRESS_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.DROUGHTROOT_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.FIR_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.LAUREL_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.PLANE_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.POPULUS_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.block(IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void blockCutout(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.blockCutout(IcariaBlocks.GRAINGLASS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockCutout(IcariaBlocks.SILKGLASS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockCutout(IcariaBlocks.ARACHNE_SPAWNER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockCutout(IcariaBlocks.REVENANT_SPAWNER.get(), pBlockModelGenerators);
	}

	public static void blockTranslucent(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.blockTranslucent(IcariaBlocks.ARISTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockTranslucent(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockTranslucent(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockTranslucent(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockTranslucent(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockTranslucent(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockTranslucent(IcariaBlocks.CALCITE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockTranslucent(IcariaBlocks.HALITE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.blockTranslucent(IcariaBlocks.ZIRCON_BLOCK.get(), pBlockModelGenerators);
	}

	public static void bloomyVine(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.bloomyVine(IcariaBlocks.BLOOMY_VINE.get(), pBlockModelGenerators);
	}

	public static void bolbos(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.bolbos(IcariaBlocks.BOLBOS.get(), pBlockModelGenerators);
	}

	public static void bromelia(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.bromelia(IcariaBlocks.WHITE_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.bromelia(IcariaBlocks.ORANGE_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.bromelia(IcariaBlocks.PINK_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.bromelia(IcariaBlocks.PURPLE_BROMELIA.get(), pBlockModelGenerators);
	}

	public static void brownGroundShrooms(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.brownGroundShrooms(IcariaBlocks.BROWN_GROUND_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void brushyVine(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.brushyVine(IcariaBlocks.BRUSHY_VINE.get(), pBlockModelGenerators);
	}

	public static void button(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.button(IcariaBlocks.CYPRESS_BUTTON.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.button(IcariaBlocks.DROUGHTROOT_BUTTON.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.button(IcariaBlocks.FIR_BUTTON.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.button(IcariaBlocks.LAUREL_BUTTON.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.button(IcariaBlocks.OLIVE_BUTTON.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.button(IcariaBlocks.PLANE_BUTTON.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.button(IcariaBlocks.POPULUS_BUTTON.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void cake(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.cake(IcariaBlocks.LAUREL_CHERRY_CAKE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cake(IcariaBlocks.STRAWBERRY_CAKE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cake(IcariaBlocks.PHYSALIS_CAKE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cake(IcariaBlocks.VINE_BERRY_CAKE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cake(IcariaBlocks.VINE_SPROUT_CAKE.get(), pBlockModelGenerators);
	}

	public static void calciteCrystal(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.calciteCrystal(IcariaBlocks.CALCITE_CRYSTAL.get(), pBlockModelGenerators);
	}

	public static void cardonCactus(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.cardonCactus(IcariaBlocks.CARDON_CACTUS.get(), pBlockModelGenerators);
	}

	public static void carpet(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.carpet(IcariaBlocks.ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.WHITE_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.LIGHT_GRAY_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.GRAY_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.BLACK_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.BROWN_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.RED_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.ORANGE_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.YELLOW_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.LIME_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.GREEN_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.CYAN_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.LIGHT_BLUE_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.BLUE_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.PURPLE_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.MAGENTA_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.carpet(IcariaBlocks.PINK_ARACHNE_STRING_CARPET.get(), pBlockModelGenerators);
	}

	public static void chain(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.chain(IcariaBlocks.VANADIUMSTEEL_CHAIN.get(), pBlockModelGenerators);
	}

	public static void checkers(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.checkers(IcariaBlocks.CHECKERS.get(), pBlockModelGenerators);
	}

	public static void chess(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.chess(IcariaBlocks.CHESS.get(), pBlockModelGenerators);
	}

	public static void chimney(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.chimney(IcariaBlocks.CHIMNEY.get(), pBlockModelGenerators);
	}

	public static void chimneyBrickCrown(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.chimneyBrickCrown(IcariaBlocks.CHIMNEY_BRICK_CROWN.get(), pBlockModelGenerators);
	}

	public static void chimneyGrateCrown(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.chimneyGrateCrown(IcariaBlocks.CHIMNEY_GRATE_CROWN.get(), pBlockModelGenerators);
	}

	public static void chimneySlab(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.chimneySlab(IcariaBlocks.CHIMNEY_SLAB.get(), pBlockModelGenerators);
	}

	public static void countertop(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.countertop(IcariaBlocks.CYPRESS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.countertop(IcariaBlocks.DROUGHTROOT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.countertop(IcariaBlocks.FIR_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.countertop(IcariaBlocks.LAUREL_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.countertop(IcariaBlocks.OLIVE_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.countertop(IcariaBlocks.PLANE_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.countertop(IcariaBlocks.POPULUS_COUNTERTOP.get(), pBlockModelGenerators);
	}

	public static void craftingTable(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.craftingTable(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.craftingTable(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.craftingTable(IcariaBlocks.FIR_CRAFTING_TABLE.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.craftingTable(IcariaBlocks.LAUREL_CRAFTING_TABLE.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.craftingTable(IcariaBlocks.OLIVE_CRAFTING_TABLE.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.craftingTable(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.craftingTable(IcariaBlocks.POPULUS_CRAFTING_TABLE.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void crop(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.crop(IcariaBlocks.SPELT_CROP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.crop(IcariaBlocks.ONION_CROP.get(), pBlockModelGenerators);
	}

	public static void cross(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.cross(IcariaBlocks.CYPRESS_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cross(IcariaBlocks.DROUGHTROOT_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cross(IcariaBlocks.FIR_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cross(IcariaBlocks.LAUREL_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cross(IcariaBlocks.OLIVE_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cross(IcariaBlocks.PLANE_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cross(IcariaBlocks.POPULUS_SAPLING.get(), pBlockModelGenerators);
	}

	public static void cupboard(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.cupboard(IcariaBlocks.CYPRESS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cupboard(IcariaBlocks.DROUGHTROOT_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cupboard(IcariaBlocks.FIR_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cupboard(IcariaBlocks.LAUREL_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cupboard(IcariaBlocks.OLIVE_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cupboard(IcariaBlocks.PLANE_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cupboard(IcariaBlocks.POPULUS_CUPBOARD.get(), pBlockModelGenerators);
	}

	public static void cuttingBoard(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.cuttingBoard(IcariaBlocks.CYPRESS_CUTTING_BOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cuttingBoard(IcariaBlocks.DROUGHTROOT_CUTTING_BOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cuttingBoard(IcariaBlocks.FIR_CUTTING_BOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cuttingBoard(IcariaBlocks.LAUREL_CUTTING_BOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cuttingBoard(IcariaBlocks.OLIVE_CUTTING_BOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cuttingBoard(IcariaBlocks.PLANE_CUTTING_BOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.cuttingBoard(IcariaBlocks.POPULUS_CUTTING_BOARD.get(), pBlockModelGenerators);
	}

	public static void dathulla(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.dathulla(IcariaBlocks.DATHULLA.get(), pBlockModelGenerators);
	}

	public static void deadDroughtrootLog(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.deadDroughtrootLog(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), pBlockModelGenerators);
	}

	public static void deadLog(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.deadLog(IcariaBlocks.DEAD_CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), IcariaBlocks.STEPPE_MOSS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.deadLog(IcariaBlocks.DEAD_FIR_LOG.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.STRIPPED_FIR_LOG.get(), IcariaBlocks.FOREST_MOSS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.deadLog(IcariaBlocks.DEAD_LAUREL_LOG.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get(), IcariaBlocks.SCRUBLAND_MOSS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.deadLog(IcariaBlocks.DEAD_OLIVE_LOG.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get(), IcariaBlocks.STEPPE_MOSS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.deadLog(IcariaBlocks.DEAD_PLANE_LOG.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get(), IcariaBlocks.SCRUBLAND_MOSS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.deadLog(IcariaBlocks.DEAD_POPULUS_LOG.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get(), IcariaBlocks.FOREST_MOSS.get(), pBlockModelGenerators);
	}

	public static void dishesCupboard(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.dishesCupboard(IcariaBlocks.CYPRESS_DISHES_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.dishesCupboard(IcariaBlocks.DROUGHTROOT_DISHES_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.dishesCupboard(IcariaBlocks.FIR_DISHES_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.dishesCupboard(IcariaBlocks.LAUREL_DISHES_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.dishesCupboard(IcariaBlocks.OLIVE_DISHES_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.dishesCupboard(IcariaBlocks.PLANE_DISHES_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.dishesCupboard(IcariaBlocks.POPULUS_DISHES_CUPBOARD.get(), pBlockModelGenerators);
	}

	public static void dolomitePillarHead(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.dolomitePillarHead(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get(), pBlockModelGenerators);
	}

	public static void door(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.door(IcariaBlocks.CYPRESS_DOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.door(IcariaBlocks.DROUGHTROOT_DOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.door(IcariaBlocks.FIR_DOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.door(IcariaBlocks.LAUREL_DOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.door(IcariaBlocks.OLIVE_DOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.door(IcariaBlocks.PLANE_DOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.door(IcariaBlocks.POPULUS_DOOR.get(), pBlockModelGenerators);
	}

	public static void fallenLeaves(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.fallenLeaves(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), IcariaBlocks.CYPRESS_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fallenLeaves(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fallenLeaves(IcariaBlocks.FALLEN_FIR_LEAVES.get(), IcariaBlocks.FIR_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fallenLeaves(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fallenLeaves(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), IcariaBlocks.OLIVE_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fallenLeaves(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), IcariaBlocks.PLANE_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fallenLeaves(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), IcariaBlocks.POPULUS_LEAVES.get(), pBlockModelGenerators);
	}

	public static void farmland(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.farmland(IcariaBlocks.FARMLAND.get(), pBlockModelGenerators);
	}

	public static void fence(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.fence(IcariaBlocks.CYPRESS_FENCE.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fence(IcariaBlocks.DROUGHTROOT_FENCE.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fence(IcariaBlocks.FIR_FENCE.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fence(IcariaBlocks.LAUREL_FENCE.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fence(IcariaBlocks.OLIVE_FENCE.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fence(IcariaBlocks.PLANE_FENCE.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fence(IcariaBlocks.POPULUS_FENCE.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void fenceGate(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.fenceGate(IcariaBlocks.CYPRESS_FENCE_GATE.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fenceGate(IcariaBlocks.DROUGHTROOT_FENCE_GATE.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fenceGate(IcariaBlocks.FIR_FENCE_GATE.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fenceGate(IcariaBlocks.LAUREL_FENCE_GATE.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fenceGate(IcariaBlocks.OLIVE_FENCE_GATE.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fenceGate(IcariaBlocks.PLANE_FENCE_GATE.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.fenceGate(IcariaBlocks.POPULUS_FENCE_GATE.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void fertilizedFarmland(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.fertilizedFarmland(IcariaBlocks.FERTILIZED_FARMLAND.get(), pBlockModelGenerators);
	}

	public static void fire(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.fire(IcariaBlocks.GREEK_FIRE.get(), pBlockModelGenerators);
	}

	public static void firewood(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.firewood(IcariaBlocks.CYPRESS_FIREWOOD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewood(IcariaBlocks.DROUGHTROOT_FIREWOOD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewood(IcariaBlocks.FIR_FIREWOOD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewood(IcariaBlocks.LAUREL_FIREWOOD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewood(IcariaBlocks.OLIVE_FIREWOOD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewood(IcariaBlocks.PLANE_FIREWOOD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewood(IcariaBlocks.POPULUS_FIREWOOD.get(), pBlockModelGenerators);
	}

	public static void firewoodWedge(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.firewoodWedge(IcariaBlocks.CYPRESS_FIREWOOD_WEDGE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewoodWedge(IcariaBlocks.DROUGHTROOT_FIREWOOD_WEDGE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewoodWedge(IcariaBlocks.FIR_FIREWOOD_WEDGE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewoodWedge(IcariaBlocks.LAUREL_FIREWOOD_WEDGE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewoodWedge(IcariaBlocks.OLIVE_FIREWOOD_WEDGE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewoodWedge(IcariaBlocks.PLANE_FIREWOOD_WEDGE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.firewoodWedge(IcariaBlocks.POPULUS_FIREWOOD_WEDGE.get(), pBlockModelGenerators);
	}

	public static void flasksCupboard(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.flasksCupboard(IcariaBlocks.CYPRESS_FLASKS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flasksCupboard(IcariaBlocks.DROUGHTROOT_FLASKS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flasksCupboard(IcariaBlocks.FIR_FLASKS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flasksCupboard(IcariaBlocks.LAUREL_FLASKS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flasksCupboard(IcariaBlocks.OLIVE_FLASKS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flasksCupboard(IcariaBlocks.PLANE_FLASKS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flasksCupboard(IcariaBlocks.POPULUS_FLASKS_CUPBOARD.get(), pBlockModelGenerators);
	}

	public static void flowerPotCountertop(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.flowerPotCountertop(IcariaBlocks.CYPRESS_FLOWER_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCountertop(IcariaBlocks.DROUGHTROOT_FLOWER_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCountertop(IcariaBlocks.FIR_FLOWER_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCountertop(IcariaBlocks.LAUREL_FLOWER_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCountertop(IcariaBlocks.OLIVE_FLOWER_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCountertop(IcariaBlocks.PLANE_FLOWER_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCountertop(IcariaBlocks.POPULUS_FLOWER_POT_COUNTERTOP.get(), pBlockModelGenerators);
	}

	public static void flowerPotCross(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.flowerPotCross(IcariaBlocks.POTTED_CYPRESS_SAPLING.get(), IcariaBlocks.CYPRESS_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCross(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get(), IcariaBlocks.DROUGHTROOT_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCross(IcariaBlocks.POTTED_FIR_SAPLING.get(), IcariaBlocks.FIR_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCross(IcariaBlocks.POTTED_LAUREL_SAPLING.get(), IcariaBlocks.LAUREL_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCross(IcariaBlocks.POTTED_OLIVE_SAPLING.get(), IcariaBlocks.OLIVE_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCross(IcariaBlocks.POTTED_PLANE_SAPLING.get(), IcariaBlocks.PLANE_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.flowerPotCross(IcariaBlocks.POTTED_POPULUS_SAPLING.get(), IcariaBlocks.POPULUS_SAPLING.get(), pBlockModelGenerators);
	}

	public static void forge(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.forge(IcariaBlocks.FORGE.get(), pBlockModelGenerators);
	}

	public static void grassyMarl(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.grassyMarl(IcariaBlocks.GRASSY_MARL.get(), pBlockModelGenerators);
	}

	public static void grateFireplace(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.grateFireplace(IcariaBlocks.GRATE_FIREPLACE.get(), pBlockModelGenerators);
	}

	public static void greenGroundShrooms(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.greenGroundShrooms(IcariaBlocks.GREEN_GROUND_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void grinder(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.grinder(IcariaBlocks.GRINDER.get(), pBlockModelGenerators);
	}

	public static void grinderShaft(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.grinderShaft(IcariaBlocks.GRINDER_SHAFT.get(), pBlockModelGenerators);
	}

	public static void grinderStone(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.grinderStone(IcariaBlocks.GRINDER_STONE.get(), pBlockModelGenerators);
	}

	public static void groundFlowers(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.groundFlowers(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.groundFlowers(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.groundFlowers(IcariaBlocks.PINK_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.groundFlowers(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.groundFlowers(IcariaBlocks.RED_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.groundFlowers(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), pBlockModelGenerators);
	}

	public static void haliteCrystal(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.haliteCrystal(IcariaBlocks.HALITE_CRYSTAL.get(), pBlockModelGenerators);
	}

	public static void herbHolder(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.herbHolder(IcariaBlocks.CYPRESS_HERB_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.herbHolder(IcariaBlocks.DROUGHTROOT_HERB_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.herbHolder(IcariaBlocks.FIR_HERB_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.herbHolder(IcariaBlocks.LAUREL_HERB_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.herbHolder(IcariaBlocks.OLIVE_HERB_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.herbHolder(IcariaBlocks.PLANE_HERB_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.herbHolder(IcariaBlocks.POPULUS_HERB_HOLDER.get(), pBlockModelGenerators);
	}

	public static void horizontalBars(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.horizontalBars(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get(), IcariaBlocks.VANADIUMSTEEL_BARS.get(), pBlockModelGenerators);
	}

	public static void horizontalPane(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.horizontalPane(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get(), IcariaBlocks.GRAINGLASS_PANE.get(), IcariaBlocks.GRAINGLASS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.horizontalPane(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get(), IcariaBlocks.SILKGLASS_PANE.get(), IcariaBlocks.SILKGLASS.get(), pBlockModelGenerators);
	}

	public static void jasperCrystal(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.jasperCrystal(IcariaBlocks.JASPER_CRYSTAL.get(), pBlockModelGenerators);
	}

	public static void kettle(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.kettle(IcariaBlocks.KETTLE.get(), pBlockModelGenerators);
	}

	public static void kiln(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.kiln(IcariaBlocks.KILN.get(), pBlockModelGenerators);
	}

	public static void kitchenTable(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.kitchenTable(IcariaBlocks.CYPRESS_KITCHEN_TABLE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kitchenTable(IcariaBlocks.DROUGHTROOT_KITCHEN_TABLE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kitchenTable(IcariaBlocks.FIR_KITCHEN_TABLE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kitchenTable(IcariaBlocks.LAUREL_KITCHEN_TABLE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kitchenTable(IcariaBlocks.OLIVE_KITCHEN_TABLE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kitchenTable(IcariaBlocks.PLANE_KITCHEN_TABLE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kitchenTable(IcariaBlocks.POPULUS_KITCHEN_TABLE.get(), pBlockModelGenerators);
	}

	public static void kline(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.kline(IcariaBlocks.CYPRESS_KLINE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kline(IcariaBlocks.DROUGHTROOT_KLINE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kline(IcariaBlocks.FIR_KLINE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kline(IcariaBlocks.LAUREL_KLINE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kline(IcariaBlocks.OLIVE_KLINE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kline(IcariaBlocks.PLANE_KLINE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.kline(IcariaBlocks.POPULUS_KLINE.get(), pBlockModelGenerators);
	}

	public static void ladder(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.ladder(IcariaBlocks.BONE_LADDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.ladder(IcariaBlocks.CYPRESS_LADDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.ladder(IcariaBlocks.DROUGHTROOT_LADDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.ladder(IcariaBlocks.FIR_LADDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.ladder(IcariaBlocks.LAUREL_LADDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.ladder(IcariaBlocks.OLIVE_LADDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.ladder(IcariaBlocks.PLANE_LADDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.ladder(IcariaBlocks.POPULUS_LADDER.get(), pBlockModelGenerators);
	}

	public static void largeBowls(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.largeBowls(IcariaBlocks.LARGE_BOWLS.get(), pBlockModelGenerators);
	}

	public static void largeBrownGroundShrooms(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.largeBrownGroundShrooms(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void ligniteTorch(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.ligniteTorch(IcariaBlocks.LIGNITE_TORCH.get(), pBlockModelGenerators);
	}

	public static void ligniteWallTorch(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.ligniteWallTorch(IcariaBlocks.LIGNITE_WALL_TORCH.get(), pBlockModelGenerators);
	}

	public static void loadedBarrel(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.loadedBarrel(IcariaBlocks.LOADED_CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.loadedBarrel(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.loadedBarrel(IcariaBlocks.LOADED_FIR_BARREL.get(), IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.loadedBarrel(IcariaBlocks.LOADED_LAUREL_BARREL.get(), IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.loadedBarrel(IcariaBlocks.LOADED_OLIVE_BARREL.get(), IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.loadedBarrel(IcariaBlocks.LOADED_PLANE_BARREL.get(), IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.loadedBarrel(IcariaBlocks.LOADED_POPULUS_BARREL.get(), IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void lootVase(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.lootVase(IcariaBlocks.RED_LOOT_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.lootVase(IcariaBlocks.LOST_LOOT_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.lootVase(IcariaBlocks.CYAN_LOOT_VASE.get(), pBlockModelGenerators);
	}

	public static void mondanos(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.mondanos(IcariaBlocks.MONDANOS.get(), pBlockModelGenerators);
	}

	public static void mortarCountertop(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.mortarCountertop(IcariaBlocks.CYPRESS_MORTAR_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.mortarCountertop(IcariaBlocks.DROUGHTROOT_MORTAR_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.mortarCountertop(IcariaBlocks.FIR_MORTAR_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.mortarCountertop(IcariaBlocks.LAUREL_MORTAR_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.mortarCountertop(IcariaBlocks.OLIVE_MORTAR_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.mortarCountertop(IcariaBlocks.PLANE_MORTAR_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.mortarCountertop(IcariaBlocks.POPULUS_MORTAR_COUNTERTOP.get(), pBlockModelGenerators);
	}

	public static void moss(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.moss(IcariaBlocks.FOREST_MOSS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.moss(IcariaBlocks.SCRUBLAND_MOSS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.moss(IcariaBlocks.STEPPE_MOSS.get(), pBlockModelGenerators);
	}

	public static void mothAgaric(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.mothAgaric(IcariaBlocks.MOTH_AGARIC.get(), pBlockModelGenerators);
	}

	public static void namdrake(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.namdrake(IcariaBlocks.NAMDRAKE.get(), pBlockModelGenerators);
	}

	public static void oliveLeaves(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.oliveLeaves(IcariaBlocks.OLIVE_LEAVES.get(), pBlockModelGenerators);
	}

	public static void overlayTextureBlock(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.overlayTextureBlock(IcariaBlocks.BLURRED_PLATOSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureBlock(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get(), pBlockModelGenerators);
	}

	public static void overlayTextureCross(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.SMALL_MIXED_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.MEDIUM_MIXED_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.MEDIUM_BROWN_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.MEDIUM_WHITE_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.LARGE_BROWN_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.BLINDWEED.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.CHAMEOMILE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.CHARMONDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.CLOVER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.FIREHILT.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.BLUE_HYDRACINTH.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.PURPLE_HYDRACINTH.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.LIONFANGS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.SPEARDROPS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.PURPLE_STAGHORN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.YELLOW_STAGHORN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.BLUE_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.PINK_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.PURPLE_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.SUNKETTLE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.SUNSPONGE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureCross(IcariaBlocks.VOIDLILY.get(), pBlockModelGenerators);
	}

	public static void overlayTextureFlowerPotCross(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_BLINDWEED.get(), IcariaBlocks.BLINDWEED.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_CHAMEOMILE.get(), IcariaBlocks.CHAMEOMILE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_CHARMONDER.get(), IcariaBlocks.CHARMONDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_CLOVER.get(), IcariaBlocks.CLOVER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_FIREHILT.get(), IcariaBlocks.FIREHILT.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), IcariaBlocks.BLUE_HYDRACINTH.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), IcariaBlocks.PURPLE_HYDRACINTH.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_LIONFANGS.get(), IcariaBlocks.LIONFANGS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_SPEARDROPS.get(), IcariaBlocks.SPEARDROPS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), IcariaBlocks.PURPLE_STAGHORN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), IcariaBlocks.YELLOW_STAGHORN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), IcariaBlocks.BLUE_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), IcariaBlocks.PINK_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), IcariaBlocks.PURPLE_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_SUNKETTLE.get(), IcariaBlocks.SUNKETTLE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_SUNSPONGE.get(), IcariaBlocks.SUNSPONGE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureFlowerPotCross(IcariaBlocks.POTTED_VOIDLILY.get(), IcariaBlocks.VOIDLILY.get(), pBlockModelGenerators);
	}

	public static void overlayTextureVine(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.overlayTextureVine(IcariaBlocks.BRANCHY_VINE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.overlayTextureVine(IcariaBlocks.REEDY_VINE.get(), pBlockModelGenerators);
	}

	public static void palmFern(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.palmFern(IcariaBlocks.PALM_FERN.get(), pBlockModelGenerators);
	}

	public static void panHolder(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.panHolder(IcariaBlocks.CYPRESS_PAN_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.panHolder(IcariaBlocks.DROUGHTROOT_PAN_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.panHolder(IcariaBlocks.FIR_PAN_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.panHolder(IcariaBlocks.LAUREL_PAN_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.panHolder(IcariaBlocks.OLIVE_PAN_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.panHolder(IcariaBlocks.PLANE_PAN_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.panHolder(IcariaBlocks.POPULUS_PAN_HOLDER.get(), pBlockModelGenerators);
	}

	public static void pane(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.pane(IcariaBlocks.GRAINGLASS_PANE.get(), IcariaBlocks.GRAINGLASS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.pane(IcariaBlocks.SILKGLASS_PANE.get(), IcariaBlocks.SILKGLASS.get(), pBlockModelGenerators);
	}

	public static void path(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.path(IcariaBlocks.MARL_PATH.get(), IcariaBlocks.MARL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.path(IcariaBlocks.LOAM_PATH.get(), IcariaBlocks.LOAM.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.path(IcariaBlocks.GRAINEL_PATH.get(), IcariaBlocks.GRAINEL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.path(IcariaBlocks.SILKSAND_PATH.get(), IcariaBlocks.SILKSAND.get(), pBlockModelGenerators);
	}

	public static void particle(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.particle(IcariaBlocks.CHEST.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.TRAPPED_CHEST.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.CYPRESS_SIGN.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.CYPRESS_WALL_SIGN.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.CYPRESS_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.DROUGHTROOT_SIGN.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.FIR_SIGN.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.FIR_WALL_SIGN.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.FIR_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.FIR_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.LAUREL_SIGN.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.LAUREL_WALL_SIGN.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.LAUREL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.OLIVE_SIGN.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.OLIVE_WALL_SIGN.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.OLIVE_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.PLANE_SIGN.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.PLANE_WALL_SIGN.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.PLANE_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.PLANE_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.POPULUS_SIGN.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.POPULUS_WALL_SIGN.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.POPULUS_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.particle(IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get(), pBlockModelGenerators);
	}

	public static void physalisCrop(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.physalisCrop(IcariaBlocks.PHYSALIS_CROP.get(), pBlockModelGenerators);
	}

	public static void plates(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.plates(IcariaBlocks.PLATES.get(), pBlockModelGenerators);
	}

	public static void portal(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.portal(IcariaBlocks.ICARIA_PORTAL.get(), pBlockModelGenerators);
	}

	public static void pot(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.pot(IcariaBlocks.POT.get(), pBlockModelGenerators);
	}

	public static void potCountertop(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.potCountertop(IcariaBlocks.CYPRESS_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potCountertop(IcariaBlocks.DROUGHTROOT_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potCountertop(IcariaBlocks.FIR_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potCountertop(IcariaBlocks.LAUREL_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potCountertop(IcariaBlocks.OLIVE_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potCountertop(IcariaBlocks.PLANE_POT_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potCountertop(IcariaBlocks.POPULUS_POT_COUNTERTOP.get(), pBlockModelGenerators);
	}

	public static void potFireplace(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.potFireplace(IcariaBlocks.POT_FIREPLACE.get(), pBlockModelGenerators);
	}

	public static void potHolder(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.potHolder(IcariaBlocks.CYPRESS_POT_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potHolder(IcariaBlocks.DROUGHTROOT_POT_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potHolder(IcariaBlocks.FIR_POT_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potHolder(IcariaBlocks.LAUREL_POT_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potHolder(IcariaBlocks.OLIVE_POT_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potHolder(IcariaBlocks.PLANE_POT_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potHolder(IcariaBlocks.POPULUS_POT_HOLDER.get(), pBlockModelGenerators);
	}

	public static void potsCupboard(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.potsCupboard(IcariaBlocks.CYPRESS_POTS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potsCupboard(IcariaBlocks.DROUGHTROOT_POTS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potsCupboard(IcariaBlocks.FIR_POTS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potsCupboard(IcariaBlocks.LAUREL_POTS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potsCupboard(IcariaBlocks.OLIVE_POTS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potsCupboard(IcariaBlocks.PLANE_POTS_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.potsCupboard(IcariaBlocks.POPULUS_POTS_CUPBOARD.get(), pBlockModelGenerators);
	}

	public static void pottedBromelia(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.pottedBromelia(IcariaBlocks.POTTED_WHITE_BROMELIA.get(), IcariaBlocks.WHITE_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.pottedBromelia(IcariaBlocks.POTTED_ORANGE_BROMELIA.get(), IcariaBlocks.ORANGE_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.pottedBromelia(IcariaBlocks.POTTED_PINK_BROMELIA.get(), IcariaBlocks.PINK_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.pottedBromelia(IcariaBlocks.POTTED_PURPLE_BROMELIA.get(), IcariaBlocks.PURPLE_BROMELIA.get(), pBlockModelGenerators);
	}

	public static void pottedBrownGroundShrooms(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.pottedBrownGroundShrooms(IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get(), IcariaBlocks.BROWN_GROUND_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void pottedCardonCactus(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.pottedCardonCactus(IcariaBlocks.POTTED_CARDON_CACTUS.get(), IcariaBlocks.CARDON_CACTUS.get(), pBlockModelGenerators);
	}

	public static void pottedGreenGroundShrooms(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.pottedGreenGroundShrooms(IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get(), IcariaBlocks.GREEN_GROUND_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void pottedLargeBrownGroundShrooms(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.pottedLargeBrownGroundShrooms(IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get(), IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void pottedPalmFern(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.pottedPalmFern(IcariaBlocks.POTTED_PALM_FERN.get(), IcariaBlocks.PALM_FERN.get(), pBlockModelGenerators);
	}

	public static void pressurePlate(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.pressurePlate(IcariaBlocks.CYPRESS_PRESSURE_PLATE.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.pressurePlate(IcariaBlocks.DROUGHTROOT_PRESSURE_PLATE.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.pressurePlate(IcariaBlocks.FIR_PRESSURE_PLATE.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.pressurePlate(IcariaBlocks.LAUREL_PRESSURE_PLATE.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.pressurePlate(IcariaBlocks.OLIVE_PRESSURE_PLATE.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.pressurePlate(IcariaBlocks.PLANE_PRESSURE_PLATE.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.pressurePlate(IcariaBlocks.POPULUS_PRESSURE_PLATE.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void psilocybos(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.psilocybos(IcariaBlocks.PSILOCYBOS.get(), pBlockModelGenerators);
	}

	public static void quartzPillarHead(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.quartzPillarHead(IcariaBlocks.QUARTZ_PILLAR_HEAD.get(), pBlockModelGenerators);
	}

	public static void quartzWall(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.quartzWall(IcariaBlocks.QUARTZ_WALL.get(), pBlockModelGenerators);
	}

	public static void rack(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.rack(IcariaBlocks.CYPRESS_RACK.get(), IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.LOADED_CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rack(IcariaBlocks.DROUGHTROOT_RACK.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rack(IcariaBlocks.FIR_RACK.get(), IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.LOADED_FIR_BARREL.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rack(IcariaBlocks.LAUREL_RACK.get(), IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LOADED_LAUREL_BARREL.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rack(IcariaBlocks.OLIVE_RACK.get(), IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.LOADED_OLIVE_BARREL.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rack(IcariaBlocks.PLANE_RACK.get(), IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.LOADED_PLANE_BARREL.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rack(IcariaBlocks.POPULUS_RACK.get(), IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.LOADED_POPULUS_BARREL.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void raisedBasinsCountertop(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.raisedBasinsCountertop(IcariaBlocks.CYPRESS_RAISED_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.raisedBasinsCountertop(IcariaBlocks.DROUGHTROOT_RAISED_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.raisedBasinsCountertop(IcariaBlocks.FIR_RAISED_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.raisedBasinsCountertop(IcariaBlocks.LAUREL_RAISED_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.raisedBasinsCountertop(IcariaBlocks.OLIVE_RAISED_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.raisedBasinsCountertop(IcariaBlocks.PLANE_RAISED_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.raisedBasinsCountertop(IcariaBlocks.POPULUS_RAISED_BASINS_COUNTERTOP.get(), pBlockModelGenerators);
	}

	public static void relicstonePillarHead(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.relicstonePillarHead(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get(), pBlockModelGenerators);
	}

	public static void rottenBoneLadder(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.rottenBoneLadder(IcariaBlocks.ROTTEN_BONE_LADDER.get(), pBlockModelGenerators);
	}

	public static void rowan(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.rowan(IcariaBlocks.ROWAN.get(), pBlockModelGenerators);
	}

	public static void rubble(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.rubble(IcariaBlocks.SURFACE_LIGNITE.get(), IcariaBlocks.LIGNITE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rubble(IcariaBlocks.GRAINITE_RUBBLE.get(), IcariaBlocks.GRAINITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rubble(IcariaBlocks.YELLOWSTONE_RUBBLE.get(), IcariaBlocks.YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rubble(IcariaBlocks.SILKSTONE_RUBBLE.get(), IcariaBlocks.SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rubble(IcariaBlocks.SUNSTONE_RUBBLE.get(), IcariaBlocks.SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rubble(IcariaBlocks.VOIDSHALE_RUBBLE.get(), IcariaBlocks.VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rubble(IcariaBlocks.BAETYL_RUBBLE.get(), IcariaBlocks.BAETYL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.rubble(IcariaBlocks.RELICSTONE_RUBBLE.get(), IcariaBlocks.RELICSTONE.get(), pBlockModelGenerators);
	}

	public static void scrollshelf(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.scrollshelf(IcariaBlocks.CYPRESS_SCROLLSHELF.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.scrollshelf(IcariaBlocks.DROUGHTROOT_SCROLLSHELF.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.scrollshelf(IcariaBlocks.FIR_SCROLLSHELF.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.scrollshelf(IcariaBlocks.LAUREL_SCROLLSHELF.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.scrollshelf(IcariaBlocks.OLIVE_SCROLLSHELF.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.scrollshelf(IcariaBlocks.PLANE_SCROLLSHELF.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.scrollshelf(IcariaBlocks.POPULUS_SCROLLSHELF.get(), pBlockModelGenerators);
	}

	public static void simpleRack(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.simpleRack(IcariaBlocks.SIMPLE_CYPRESS_RACK.get(), IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.LOADED_CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.simpleRack(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.simpleRack(IcariaBlocks.SIMPLE_FIR_RACK.get(), IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.LOADED_FIR_BARREL.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.simpleRack(IcariaBlocks.SIMPLE_LAUREL_RACK.get(), IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LOADED_LAUREL_BARREL.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.simpleRack(IcariaBlocks.SIMPLE_OLIVE_RACK.get(), IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.LOADED_OLIVE_BARREL.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.simpleRack(IcariaBlocks.SIMPLE_PLANE_RACK.get(), IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.LOADED_PLANE_BARREL.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.simpleRack(IcariaBlocks.SIMPLE_POPULUS_RACK.get(), IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.LOADED_POPULUS_BARREL.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void slab(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.slab(IcariaBlocks.MARL_ADOBE_SLAB.get(), IcariaBlocks.MARL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.LOAM_BRICK_SLAB.get(), IcariaBlocks.LOAM_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.DOLOMITE_ADOBE_SLAB.get(), IcariaBlocks.DOLOMITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get(), IcariaBlocks.SMOOTH_DOLOMITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.GRAINITE_ADOBE_SLAB.get(), IcariaBlocks.GRAINITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.GRAINITE_SLAB.get(), IcariaBlocks.GRAINITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.GRAINITE_BRICK_SLAB.get(), IcariaBlocks.GRAINITE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.YELLOWSTONE_ADOBE_SLAB.get(), IcariaBlocks.YELLOWSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.COBBLED_YELLOWSTONE_SLAB.get(), IcariaBlocks.COBBLED_YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.YELLOWSTONE_SLAB.get(), IcariaBlocks.YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.YELLOWSTONE_BRICK_SLAB.get(), IcariaBlocks.YELLOWSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.SILKSTONE_ADOBE_SLAB.get(), IcariaBlocks.SILKSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.COBBLED_SILKSTONE_SLAB.get(), IcariaBlocks.COBBLED_SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.SILKSTONE_SLAB.get(), IcariaBlocks.SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.SILKSTONE_BRICK_SLAB.get(), IcariaBlocks.SILKSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.SUNSTONE_ADOBE_SLAB.get(), IcariaBlocks.SUNSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.COBBLED_SUNSTONE_SLAB.get(), IcariaBlocks.COBBLED_SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.SUNSTONE_SLAB.get(), IcariaBlocks.SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.SUNSTONE_BRICK_SLAB.get(), IcariaBlocks.SUNSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.VOIDSHALE_ADOBE_SLAB.get(), IcariaBlocks.VOIDSHALE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.COBBLED_VOIDSHALE_SLAB.get(), IcariaBlocks.COBBLED_VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.VOIDSHALE_SLAB.get(), IcariaBlocks.VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.VOIDSHALE_BRICK_SLAB.get(), IcariaBlocks.VOIDSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.BAETYL_ADOBE_SLAB.get(), IcariaBlocks.BAETYL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.COBBLED_BAETYL_SLAB.get(), IcariaBlocks.COBBLED_BAETYL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.BAETYL_SLAB.get(), IcariaBlocks.BAETYL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.BAETYL_BRICK_SLAB.get(), IcariaBlocks.BAETYL_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.RELICSTONE_SLAB.get(), IcariaBlocks.RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.SMOOTH_RELICSTONE_SLAB.get(), IcariaBlocks.SMOOTH_RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.RELICSTONE_BRICK_SLAB.get(), IcariaBlocks.RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.CRACKED_RELICSTONE_BRICK_SLAB.get(), IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.MOSSY_RELICSTONE_BRICK_SLAB.get(), IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.RELICSTONE_TILE_SLAB.get(), IcariaBlocks.RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.CRACKED_RELICSTONE_TILE_SLAB.get(), IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.MOSSY_RELICSTONE_TILE_SLAB.get(), IcariaBlocks.MOSSY_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.PLATOSHALE_SLAB.get(), IcariaBlocks.PLATOSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.PLATOSHALE_BRICK_SLAB.get(), IcariaBlocks.PLATOSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.CYPRESS_SLAB.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.DROUGHTROOT_SLAB.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.FIR_SLAB.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.LAUREL_SLAB.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.OLIVE_SLAB.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.PLANE_SLAB.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.slab(IcariaBlocks.POPULUS_SLAB.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void smallBowls(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.smallBowls(IcariaBlocks.SMALL_BOWLS.get(), pBlockModelGenerators);
	}

	public static void spoonHolder(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.spoonHolder(IcariaBlocks.CYPRESS_SPOON_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.spoonHolder(IcariaBlocks.DROUGHTROOT_SPOON_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.spoonHolder(IcariaBlocks.FIR_SPOON_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.spoonHolder(IcariaBlocks.LAUREL_SPOON_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.spoonHolder(IcariaBlocks.OLIVE_SPOON_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.spoonHolder(IcariaBlocks.PLANE_SPOON_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.spoonHolder(IcariaBlocks.POPULUS_SPOON_HOLDER.get(), pBlockModelGenerators);
	}

	public static void stairs(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.stairs(IcariaBlocks.MARL_ADOBE_STAIRS.get(), IcariaBlocks.MARL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.LOAM_BRICK_STAIRS.get(), IcariaBlocks.LOAM_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.DOLOMITE_ADOBE_STAIRS.get(), IcariaBlocks.DOLOMITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.SMOOTH_DOLOMITE_STAIRS.get(), IcariaBlocks.SMOOTH_DOLOMITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.GRAINITE_ADOBE_STAIRS.get(), IcariaBlocks.GRAINITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.GRAINITE_STAIRS.get(), IcariaBlocks.GRAINITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.GRAINITE_BRICK_STAIRS.get(), IcariaBlocks.GRAINITE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.YELLOWSTONE_ADOBE_STAIRS.get(), IcariaBlocks.YELLOWSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.COBBLED_YELLOWSTONE_STAIRS.get(), IcariaBlocks.COBBLED_YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.YELLOWSTONE_STAIRS.get(), IcariaBlocks.YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.YELLOWSTONE_BRICK_STAIRS.get(), IcariaBlocks.YELLOWSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.SILKSTONE_ADOBE_STAIRS.get(), IcariaBlocks.SILKSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.COBBLED_SILKSTONE_STAIRS.get(), IcariaBlocks.COBBLED_SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.SILKSTONE_STAIRS.get(), IcariaBlocks.SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.SILKSTONE_BRICK_STAIRS.get(), IcariaBlocks.SILKSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.SUNSTONE_ADOBE_STAIRS.get(), IcariaBlocks.SUNSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.COBBLED_SUNSTONE_STAIRS.get(), IcariaBlocks.COBBLED_SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.SUNSTONE_STAIRS.get(), IcariaBlocks.SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.SUNSTONE_BRICK_STAIRS.get(), IcariaBlocks.SUNSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.VOIDSHALE_ADOBE_STAIRS.get(), IcariaBlocks.VOIDSHALE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.COBBLED_VOIDSHALE_STAIRS.get(), IcariaBlocks.COBBLED_VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.VOIDSHALE_STAIRS.get(), IcariaBlocks.VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.VOIDSHALE_BRICK_STAIRS.get(), IcariaBlocks.VOIDSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.BAETYL_ADOBE_STAIRS.get(), IcariaBlocks.BAETYL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.COBBLED_BAETYL_STAIRS.get(), IcariaBlocks.COBBLED_BAETYL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.BAETYL_STAIRS.get(), IcariaBlocks.BAETYL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.BAETYL_BRICK_STAIRS.get(), IcariaBlocks.BAETYL_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.RELICSTONE_STAIRS.get(), IcariaBlocks.RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.SMOOTH_RELICSTONE_STAIRS.get(), IcariaBlocks.SMOOTH_RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.RELICSTONE_BRICK_STAIRS.get(), IcariaBlocks.RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.CRACKED_RELICSTONE_BRICK_STAIRS.get(), IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.MOSSY_RELICSTONE_BRICK_STAIRS.get(), IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.RELICSTONE_TILE_STAIRS.get(), IcariaBlocks.RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.CRACKED_RELICSTONE_TILE_STAIRS.get(), IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.MOSSY_RELICSTONE_TILE_STAIRS.get(), IcariaBlocks.MOSSY_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.PLATOSHALE_STAIRS.get(), IcariaBlocks.PLATOSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.PLATOSHALE_BRICK_STAIRS.get(), IcariaBlocks.PLATOSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.CYPRESS_STAIRS.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.DROUGHTROOT_STAIRS.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.FIR_STAIRS.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.LAUREL_STAIRS.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.OLIVE_STAIRS.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.PLANE_STAIRS.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stairs(IcariaBlocks.POPULUS_STAIRS.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void stool(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.stool(IcariaBlocks.CYPRESS_STOOL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stool(IcariaBlocks.DROUGHTROOT_STOOL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stool(IcariaBlocks.FIR_STOOL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stool(IcariaBlocks.LAUREL_STOOL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stool(IcariaBlocks.OLIVE_STOOL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stool(IcariaBlocks.PLANE_STOOL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.stool(IcariaBlocks.POPULUS_STOOL.get(), pBlockModelGenerators);
	}

	public static void storageVase(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.storageVase(IcariaBlocks.STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.WHITE_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.GRAY_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.BLACK_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.BROWN_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.RED_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.ORANGE_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.YELLOW_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.LIME_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.GREEN_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.CYAN_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.BLUE_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.PURPLE_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.MAGENTA_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.storageVase(IcariaBlocks.PINK_STORAGE_VASE.get(), pBlockModelGenerators);
	}

	public static void strawberryBush(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.strawberryBush(IcariaBlocks.STRAWBERRY_BUSH.get(), pBlockModelGenerators);
	}

	public static void strawberryCrop(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.strawberryCrop(IcariaBlocks.STRAWBERRY_CROP.get(), pBlockModelGenerators);
	}

	public static void strippedDeadLog(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), IcariaBlocks.STRIPPED_FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get(), pBlockModelGenerators);
	}

	public static void surfaceBones(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.surfaceBones(IcariaBlocks.SURFACE_BONES.get(), pBlockModelGenerators);
	}

	public static void surfaceChert(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.surfaceChert(IcariaBlocks.SURFACE_CHERT.get(), pBlockModelGenerators);
	}

	public static void suspiciousSand(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.suspiciousSand(IcariaBlocks.SUSPICIOUS_GRAINEL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.suspiciousSand(IcariaBlocks.SUSPICIOUS_SILKSAND.get(), pBlockModelGenerators);
	}

	public static void suspiciousSubstance(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.suspiciousSubstance(IcariaBlocks.SUSPICIOUS_SUBSTANCE.get(), pBlockModelGenerators);
	}

	public static void tappedBarrel(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.tappedBarrel(IcariaBlocks.TAPPED_CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tappedBarrel(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tappedBarrel(IcariaBlocks.TAPPED_FIR_BARREL.get(), IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tappedBarrel(IcariaBlocks.TAPPED_LAUREL_BARREL.get(), IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tappedBarrel(IcariaBlocks.TAPPED_OLIVE_BARREL.get(), IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tappedBarrel(IcariaBlocks.TAPPED_PLANE_BARREL.get(), IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tappedBarrel(IcariaBlocks.TAPPED_POPULUS_BARREL.get(), IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void tinderFungusTreeShrooms(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.tinderFungusTreeShrooms(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void tintedCross(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.tintedCross(IcariaBlocks.FERN.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tintedCross(IcariaBlocks.SMALL_GRASS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tintedCross(IcariaBlocks.MEDIUM_GRASS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tintedCross(IcariaBlocks.LARGE_GRASS.get(), pBlockModelGenerators);
	}

	public static void tintedFlowerPotCross(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.tintedFlowerPotCross(IcariaBlocks.POTTED_FERN.get(), IcariaBlocks.FERN.get(), pBlockModelGenerators);
	}

	public static void towelHolder(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.towelHolder(IcariaBlocks.CYPRESS_TOWEL_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.towelHolder(IcariaBlocks.DROUGHTROOT_TOWEL_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.towelHolder(IcariaBlocks.FIR_TOWEL_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.towelHolder(IcariaBlocks.LAUREL_TOWEL_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.towelHolder(IcariaBlocks.OLIVE_TOWEL_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.towelHolder(IcariaBlocks.PLANE_TOWEL_HOLDER.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.towelHolder(IcariaBlocks.POPULUS_TOWEL_HOLDER.get(), pBlockModelGenerators);
	}

	public static void trapdoor(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.trapdoor(IcariaBlocks.CYPRESS_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trapdoor(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trapdoor(IcariaBlocks.FIR_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trapdoor(IcariaBlocks.LAUREL_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trapdoor(IcariaBlocks.OLIVE_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trapdoor(IcariaBlocks.PLANE_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trapdoor(IcariaBlocks.POPULUS_TRAPDOOR.get(), pBlockModelGenerators);
	}

	public static void tripleBarrelRack(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get(), IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_DROUGHTROOT_BARREL_RACK.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_FIR_BARREL_RACK.get(), IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get(), IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_OLIVE_BARREL_RACK.get(), IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_PLANE_BARREL_RACK.get(), IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get(), IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void trough(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.trough(IcariaBlocks.CYPRESS_TROUGH.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trough(IcariaBlocks.DROUGHTROOT_TROUGH.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trough(IcariaBlocks.FIR_TROUGH.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trough(IcariaBlocks.LAUREL_TROUGH.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trough(IcariaBlocks.OLIVE_TROUGH.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trough(IcariaBlocks.PLANE_TROUGH.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.trough(IcariaBlocks.POPULUS_TROUGH.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void turkeyTailTreeShrooms(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.turkeyTailTreeShrooms(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void twigs(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.twigs(IcariaBlocks.CYPRESS_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.twigs(IcariaBlocks.DROUGHTROOT_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.twigs(IcariaBlocks.FIR_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.twigs(IcariaBlocks.LAUREL_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.twigs(IcariaBlocks.OLIVE_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.twigs(IcariaBlocks.PLANE_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.twigs(IcariaBlocks.POPULUS_TWIGS.get(), pBlockModelGenerators);
	}

	public static void unnamedTreeShrooms(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.unnamedTreeShrooms(IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void vase(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.vase(IcariaBlocks.VASE.get(), pBlockModelGenerators);
	}

	public static void vaseCupboard(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.vaseCupboard(IcariaBlocks.CYPRESS_VASE_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.vaseCupboard(IcariaBlocks.DROUGHTROOT_VASE_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.vaseCupboard(IcariaBlocks.FIR_VASE_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.vaseCupboard(IcariaBlocks.LAUREL_VASE_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.vaseCupboard(IcariaBlocks.OLIVE_VASE_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.vaseCupboard(IcariaBlocks.PLANE_VASE_CUPBOARD.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.vaseCupboard(IcariaBlocks.POPULUS_VASE_CUPBOARD.get(), pBlockModelGenerators);
	}

	public static void vine(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.vine(IcariaBlocks.DRY_VINE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.vine(IcariaBlocks.SWIRLY_VINE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.vine(IcariaBlocks.THORNY_VINE.get(), pBlockModelGenerators);
	}

	public static void wall(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.wall(IcariaBlocks.MARL_ADOBE_WALL.get(), IcariaBlocks.MARL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.LOAM_BRICK_WALL.get(), IcariaBlocks.LOAM_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.DOLOMITE_ADOBE_WALL.get(), IcariaBlocks.DOLOMITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.SMOOTH_DOLOMITE_WALL.get(), IcariaBlocks.SMOOTH_DOLOMITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.GRAINITE_ADOBE_WALL.get(), IcariaBlocks.GRAINITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.GRAINITE_WALL.get(), IcariaBlocks.GRAINITE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.GRAINITE_BRICK_WALL.get(), IcariaBlocks.GRAINITE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.YELLOWSTONE_ADOBE_WALL.get(), IcariaBlocks.YELLOWSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.COBBLED_YELLOWSTONE_WALL.get(), IcariaBlocks.COBBLED_YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.YELLOWSTONE_WALL.get(), IcariaBlocks.YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.YELLOWSTONE_BRICK_WALL.get(), IcariaBlocks.YELLOWSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.SILKSTONE_ADOBE_WALL.get(), IcariaBlocks.SILKSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.COBBLED_SILKSTONE_WALL.get(), IcariaBlocks.COBBLED_SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.SILKSTONE_WALL.get(), IcariaBlocks.SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.SILKSTONE_BRICK_WALL.get(), IcariaBlocks.SILKSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.SUNSTONE_ADOBE_WALL.get(), IcariaBlocks.SUNSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.COBBLED_SUNSTONE_WALL.get(), IcariaBlocks.COBBLED_SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.SUNSTONE_WALL.get(), IcariaBlocks.SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.SUNSTONE_BRICK_WALL.get(), IcariaBlocks.SUNSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.VOIDSHALE_ADOBE_WALL.get(), IcariaBlocks.VOIDSHALE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.COBBLED_VOIDSHALE_WALL.get(), IcariaBlocks.COBBLED_VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.VOIDSHALE_WALL.get(), IcariaBlocks.VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.VOIDSHALE_BRICK_WALL.get(), IcariaBlocks.VOIDSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.BAETYL_ADOBE_WALL.get(), IcariaBlocks.BAETYL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.COBBLED_BAETYL_WALL.get(), IcariaBlocks.COBBLED_BAETYL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.BAETYL_WALL.get(), IcariaBlocks.BAETYL.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.BAETYL_BRICK_WALL.get(), IcariaBlocks.BAETYL_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.RELICSTONE_WALL.get(), IcariaBlocks.RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.SMOOTH_RELICSTONE_WALL.get(), IcariaBlocks.SMOOTH_RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.RELICSTONE_BRICK_WALL.get(), IcariaBlocks.RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.CRACKED_RELICSTONE_BRICK_WALL.get(), IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.MOSSY_RELICSTONE_BRICK_WALL.get(), IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.RELICSTONE_TILE_WALL.get(), IcariaBlocks.RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.CRACKED_RELICSTONE_TILE_WALL.get(), IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.MOSSY_RELICSTONE_TILE_WALL.get(), IcariaBlocks.MOSSY_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.PLATOSHALE_WALL.get(), IcariaBlocks.PLATOSHALE.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wall(IcariaBlocks.PLATOSHALE_BRICK_WALL.get(), IcariaBlocks.PLATOSHALE_BRICKS.get(), pBlockModelGenerators);
	}

	public static void water(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.water(IcariaBlocks.MEDITERRANEAN_WATER.get(), pBlockModelGenerators);
	}

	public static void wiltedElm(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.wiltedElm(IcariaBlocks.WILTED_ELM.get(), pBlockModelGenerators);
	}

	public static void wood(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.wood(IcariaBlocks.CYPRESS_WOOD.get(), IcariaBlocks.CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.DROUGHTROOT_WOOD.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.FIR_WOOD.get(), IcariaBlocks.FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.STRIPPED_FIR_WOOD.get(), IcariaBlocks.STRIPPED_FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.LAUREL_WOOD.get(), IcariaBlocks.LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.OLIVE_WOOD.get(), IcariaBlocks.OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.PLANE_WOOD.get(), IcariaBlocks.PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.STRIPPED_PLANE_WOOD.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.POPULUS_WOOD.get(), IcariaBlocks.POPULUS_LOG.get(), pBlockModelGenerators);
		IcariaBlockModelProvider.wood(IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get(), pBlockModelGenerators);
	}

	public static void zirconCrystal(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockModelProvider.zirconCrystal(IcariaBlocks.ZIRCON_CRYSTAL.get(), pBlockModelGenerators);
	}

	public static void amphora(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_amphora_single")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "single"), new TextureMapping()
				.putForced(IcariaTextureSlots.GRAY_STORAGE_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "gray_storage_vase"))
				.putForced(IcariaTextureSlots.LIGHT_GRAY_STORAGE_VASE_LITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_storage_vase_lite"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_storage_vase_lite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_amphora_double")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "double"), new TextureMapping()
				.putForced(IcariaTextureSlots.BROWN_STORAGE_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "brown_storage_vase"))
				.putForced(IcariaTextureSlots.GRAY_STORAGE_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "gray_storage_vase"))
				.putForced(IcariaTextureSlots.LIGHT_GRAY_STORAGE_VASE_LITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_storage_vase_lite"))
				.putForced(IcariaTextureSlots.ORANGE_STORAGE_VASE_LITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "orange_storage_vase_lite"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_storage_vase_lite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_amphora_triple")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "triple"), new TextureMapping()
				.putForced(IcariaTextureSlots.BLACK_STORAGE_VASE_LITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "black_storage_vase_lite"))
				.putForced(IcariaTextureSlots.BROWN_STORAGE_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "brown_storage_vase"))
				.putForced(IcariaTextureSlots.GRAY_STORAGE_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "gray_storage_vase"))
				.putForced(IcariaTextureSlots.LIGHT_GRAY_STORAGE_VASE_LITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_storage_vase_lite"))
				.putForced(IcariaTextureSlots.ORANGE_STORAGE_VASE_LITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "orange_storage_vase_lite"))
				.putForced(IcariaTextureSlots.RED_STORAGE_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_storage_vase"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_storage_vase_lite")), pBlockModelGenerators.modelOutput);
	}

	public static void anthraciteTorch(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_anthracite_torch")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TORCH_BONE, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_bone"))
				.putForced(IcariaTextureSlots.TORCH_COAL, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_coal"))
				.putForced(IcariaTextureSlots.TORCH_METAL, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_metal"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_bone")), pBlockModelGenerators.modelOutput);
	}

	public static void anthraciteWallTorch(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_anthracite_wall_torch")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TORCH_BONE, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_bone"))
				.putForced(IcariaTextureSlots.TORCH_COAL, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_coal"))
				.putForced(IcariaTextureSlots.TORCH_METAL, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_metal"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_bone")), pBlockModelGenerators.modelOutput);
	}

	public static void axis(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_column")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.END, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_column_horizontal")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "horizontal"), new TextureMapping()
				.putForced(IcariaTextureSlots.END, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void barrel(Block pBarrel, Block pPlanks, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_barrel")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBarrel), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pBarrel, "front"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_standing_barrel")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("standing", pBarrel), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pBarrel, "front"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
	}

	public static void bars(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bars_inventory")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "iron_bars_cap")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "cap"), new TextureMapping()
				.putForced(IcariaTextureSlots.BARS, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.EDGE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "iron_bars_cap_alt")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "cap_alt"), new TextureMapping()
				.putForced(IcariaTextureSlots.BARS, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.EDGE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "iron_bars_post")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "post"), new TextureMapping()
				.putForced(IcariaTextureSlots.BARS, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "iron_bars_post_ends")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "post_ends"), new TextureMapping()
				.putForced(IcariaTextureSlots.EDGE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "iron_bars_side")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "side"), new TextureMapping()
				.putForced(IcariaTextureSlots.BARS, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.EDGE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "iron_bars_side_alt")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "side_alt"), new TextureMapping()
				.putForced(IcariaTextureSlots.BARS, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.EDGE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void basinsCountertop(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_basins_countertop")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.LEAVES, IcariaModelProvider.blockFile(pBlock, "basins_countertop", "leaves"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "basins_countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "basins_countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "basins_countertop", "log"))
				.putForced(IcariaTextureSlots.TRAPDOOR, IcariaModelProvider.blockFile(pBlock, "basins_countertop", "trapdoor"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "basins_countertop", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void bathtub(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bathtub_inventory")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "bathtub", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "bathtub", "planks"))
				.putForced(IcariaTextureSlots.SKULL, IcariaModelProvider.blockFile(IcariaIdents.ID, "skull"))
				.putForced(IcariaTextureSlots.SURFACE_BONES, IcariaModelProvider.blockFile(IcariaIdents.ID, "surface_bones"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bathtub", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bathtub_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "bathtub", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "bathtub", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bathtub", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bathtub_head_remains")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "head_remains"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "bathtub", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "bathtub", "planks"))
				.putForced(IcariaTextureSlots.SKULL, IcariaModelProvider.blockFile(IcariaIdents.ID, "skull"))
				.putForced(IcariaTextureSlots.SURFACE_BONES, IcariaModelProvider.blockFile(IcariaIdents.ID, "surface_bones"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bathtub", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bathtub_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "bathtub", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "bathtub", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bathtub", "planks")), pBlockModelGenerators.modelOutput);
	}

	public static void block(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_all")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void blockCutout(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_all")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void blockTranslucent(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_all")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void bloomyVine(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("blooming", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile("blooming", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("blooming", pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("dead", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile("dead", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("dead", pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("growing", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile("growing", pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile("growing", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("growing", pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("ripe", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile("ripe", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("ripe", pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void bolbos(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bolbos")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void bromelia(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bromelia")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "overlay")), pBlockModelGenerators.modelOutput);
	}

	public static void brownGroundShrooms(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_brown_ground_shrooms_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_brown_ground_shrooms_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_brown_ground_shrooms_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void brushyVine(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("dead", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile("dead", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("dead", pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("growing", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile("growing", pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile("growing", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("growing", pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("ripe", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile("ripe", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("ripe", pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void button(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "button")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "button_inventory")).build()
			.create(IcariaModelProvider.blockFile(pName, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "button_pressed")).build()
			.create(IcariaModelProvider.blockFile(pName, "pressed"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void cake(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "candle_cake")).build()
			.create(IcariaModelProvider.blockFile("candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "white_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("white_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "white_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("white_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "light_gray_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("light_gray_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "light_gray_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "gray_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("gray_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "gray_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("gray_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "black_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("black_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "black_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("black_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "brown_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("brown_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "brown_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("brown_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "red_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("red_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "red_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("red_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "orange_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("orange_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "orange_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("orange_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "yellow_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("yellow_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "yellow_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("yellow_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "lime_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("lime_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "lime_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("lime_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "green_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("green_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "green_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("green_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cyan_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("cyan_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cyan_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("cyan_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "light_blue_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("light_blue_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "light_blue_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "blue_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("blue_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "blue_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("blue_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "purple_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("purple_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "purple_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("purple_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "magenta_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("magenta_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "magenta_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("magenta_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "pink_candle_cake")).build()
			.create(IcariaModelProvider.blockFile("pink_candle", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "pink_candle_cake_lit")).build()
			.create(IcariaModelProvider.blockFile("pink_candle", pBlock, "lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cake_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.CAKE_BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.CAKE_SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.CAKE_TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cake_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CAKE_BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.CAKE_INSIDE, IcariaModelProvider.blockFile(pBlock, "inside"))
				.putForced(IcariaTextureSlots.CAKE_SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.CAKE_TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cake_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CAKE_BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.CAKE_INSIDE, IcariaModelProvider.blockFile(pBlock, "inside"))
				.putForced(IcariaTextureSlots.CAKE_SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.CAKE_TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cake_3")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CAKE_BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "cake_bottom"))
				.putForced(IcariaTextureSlots.CAKE_INSIDE, IcariaModelProvider.blockFile(pBlock, "inside"))
				.putForced(IcariaTextureSlots.CAKE_SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.CAKE_TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
	}

	public static void calciteCrystal(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_calcite_crystal")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void cardonCactus(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cardon_cactus_inventory")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pBlock, "bottom"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cardon_cactus_cube")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "cube"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cardon_cactus_stem")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "stem"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "side")), pBlockModelGenerators.modelOutput);
	}

	public static void carpet(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "carpet")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.WOOL, IcariaModelProvider.blockFile(pBlock, "carpet", "block"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "carpet", "block")), pBlockModelGenerators.modelOutput);
	}

	public static void chain(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "chain")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void checkers(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_checkers_played")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "played"), new TextureMapping()
				.putForced(IcariaTextureSlots.CHESSBOARD, IcariaModelProvider.blockFile(IcariaIdents.ID, "chessboard"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "chessboard_particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_checkers_set")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "set"), new TextureMapping()
				.putForced(IcariaTextureSlots.CHESSBOARD, IcariaModelProvider.blockFile(IcariaIdents.ID, "chessboard"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "chessboard_particle")), pBlockModelGenerators.modelOutput);
	}

	public static void chess(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chess_played")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "played"), new TextureMapping()
				.putForced(IcariaTextureSlots.CHESSBOARD, IcariaModelProvider.blockFile(IcariaIdents.ID, "chessboard"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "chessboard_particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chess_set")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "set"), new TextureMapping()
				.putForced(IcariaTextureSlots.CHESSBOARD, IcariaModelProvider.blockFile(IcariaIdents.ID, "chessboard"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "chessboard_particle")), pBlockModelGenerators.modelOutput);
	}

	public static void chimney(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chimney")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void chimneyBrickCrown(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chimney_brick_crown")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.CHIMNEY, IcariaModelProvider.blockFile(IcariaIdents.ID, "chimney"))
				.putForced(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_grainite_bricks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "chimney")), pBlockModelGenerators.modelOutput);
	}

	public static void chimneyGrateCrown(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chimney_grate_crown")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.CHALKOS_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "chalkos_mesh_block"))
				.putForced(IcariaTextureSlots.CHIMNEY, IcariaModelProvider.blockFile(IcariaIdents.ID, "chimney"))
				.putForced(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_chalkos_block"))
				.putForced(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_sideros_block"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "chimney")), pBlockModelGenerators.modelOutput);
	}

	public static void chimneySlab(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chimney_slab_bottom")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(IcariaIdents.ID, "chimney"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "chimney")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chimney_slab_top")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "top"), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(IcariaIdents.ID, "chimney"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "chimney")), pBlockModelGenerators.modelOutput);
	}

	public static void countertop(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("white_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("white_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("white_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("white_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("white_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("white_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("white_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("white_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_gray_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_gray_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_gray_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_gray_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_gray_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_gray_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_gray_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_gray_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("gray_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "gray_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("gray_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "gray_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("gray_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "gray_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("gray_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "gray_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("gray_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "gray_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("gray_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "gray_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("gray_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "gray_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("gray_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "gray_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("black_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "black_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("black_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "black_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("black_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "black_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("black_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "black_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("black_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "black_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("black_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "black_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("black_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "black_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("black_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "black_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("brown_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "brown_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("brown_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "brown_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("brown_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "brown_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("brown_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "brown_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("brown_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "brown_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("brown_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "brown_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("brown_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "brown_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("brown_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "brown_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("red_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "red_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("red_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "red_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("red_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "red_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("red_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "red_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("red_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "red_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("red_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "red_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("red_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "red_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("red_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "red_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("orange_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "orange_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("orange_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "orange_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("orange_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "orange_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("orange_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "orange_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("orange_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "orange_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("orange_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "orange_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("orange_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "orange_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("orange_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "orange_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("yellow_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "yellow_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("yellow_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "yellow_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("yellow_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "yellow_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("yellow_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "yellow_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("yellow_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "yellow_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("yellow_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "yellow_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("yellow_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "yellow_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("yellow_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "yellow_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("lime_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "lime_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("lime_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "lime_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("lime_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "lime_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("lime_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "lime_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("lime_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "lime_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("lime_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "lime_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("lime_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "lime_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("lime_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "lime_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("green_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "green_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("green_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "green_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("green_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "green_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("green_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "green_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("green_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "green_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("green_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "green_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("green_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "green_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("green_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "green_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("cyan_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "cyan_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("cyan_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "cyan_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("cyan_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "cyan_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("cyan_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "cyan_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("cyan_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "cyan_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("cyan_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "cyan_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("cyan_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "cyan_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("cyan_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "cyan_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_blue_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_blue_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_blue_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_blue_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_blue_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_blue_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_blue_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "light_blue_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("blue_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "blue_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("blue_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "blue_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("blue_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "blue_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("blue_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "blue_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("blue_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "blue_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("blue_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "blue_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("blue_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "blue_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("blue_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "blue_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("purple_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "purple_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("purple_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "purple_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("purple_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "purple_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("purple_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "purple_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("purple_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "purple_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("purple_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "purple_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("purple_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "purple_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("purple_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "purple_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("magenta_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "magenta_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("magenta_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "magenta_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("magenta_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "magenta_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("magenta_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "magenta_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("magenta_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "magenta_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("magenta_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "magenta_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("magenta_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "magenta_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("magenta_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "magenta_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("pink_candle", pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "pink_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1")).build()
			.create(IcariaModelProvider.blockFile("pink_candle", pBlock, "lit_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "pink_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("pink_candle", pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "pink_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2")).build()
			.create(IcariaModelProvider.blockFile("pink_candle", pBlock, "lit_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "pink_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("pink_candle", pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "pink_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3")).build()
			.create(IcariaModelProvider.blockFile("pink_candle", pBlock, "lit_3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "pink_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("pink_candle", pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "pink_candle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4")).build()
			.create(IcariaModelProvider.blockFile("pink_candle", pBlock, "lit_4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CANDLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "pink_candle_lit"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "countertop", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void craftingTable(Block pBlock, Block pPlanks, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.NORTH, IcariaModelProvider.blockFile(pBlock, "front"))
				.putForced(IcariaTextureSlots.EAST, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.SOUTH, IcariaModelProvider.blockFile(pBlock, "side"))
				.putForced(IcariaTextureSlots.WEST, IcariaModelProvider.blockFile(pBlock, "front"))
				.putForced(IcariaTextureSlots.UP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.DOWN, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "front")), pBlockModelGenerators.modelOutput);
	}

	public static void crop(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "crop")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.CROP, IcariaModelProvider.blockFile(pBlock, "0"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "0")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "crop")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CROP, IcariaModelProvider.blockFile(pBlock, "1"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "1")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "crop")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CROP, IcariaModelProvider.blockFile(pBlock, "2"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "2")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "crop")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CROP, IcariaModelProvider.blockFile(pBlock, "3"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "3")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "crop")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.CROP, IcariaModelProvider.blockFile(pBlock, "4"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "4")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "crop")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "5"), new TextureMapping()
				.putForced(IcariaTextureSlots.CROP, IcariaModelProvider.blockFile(pBlock, "5"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "5")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "crop")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "6"), new TextureMapping()
				.putForced(IcariaTextureSlots.CROP, IcariaModelProvider.blockFile(pBlock, "6"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "6")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "crop")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "7"), new TextureMapping()
				.putForced(IcariaTextureSlots.CROP, IcariaModelProvider.blockFile(pBlock, "7"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "7")), pBlockModelGenerators.modelOutput);
	}

	public static void cross(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cross")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.CROSS, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void cupboard(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cupboard")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.CUPBOARD, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "cupboard", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "cupboard", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "cupboard", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "cupboard", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "cupboard", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void cuttingBoard(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cutting_board")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "cutting_board", "log"))
				.putForced(IcariaTextureSlots.TRAPDOOR, IcariaModelProvider.blockFile(pBlock, "cutting_board", "trapdoor"))
				.putForced(IcariaTextureSlots.TWIGS, IcariaModelProvider.blockFile(pBlock, "cutting_board", "twigs"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "cutting_board", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void dathulla(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dathulla")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void deadDroughtrootLog(Block pName, Block pLog, Block pStrippedLog, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_0")).build()
			.create(IcariaModelProvider.blockFile(pName, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pLog, "top"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_horizontal_0")).build()
			.create(IcariaModelProvider.blockFile(pName, "horizontal_0"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pLog, "top"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pLog)), pBlockModelGenerators.modelOutput);
	}

	public static void deadLog(Block pName, Block pLog, Block pStrippedLog, Block pMoss, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_0")).build()
			.create(IcariaModelProvider.blockFile(pName, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pLog, "top"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_horizontal_0")).build()
			.create(IcariaModelProvider.blockFile(pName, "horizontal_0"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pLog, "top"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_1")).build()
			.create(IcariaModelProvider.blockFile(pName, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.BROWN_GROUND_SHROOMS, IcariaModelProvider.blockFile(IcariaIdents.ID, "brown_ground_shrooms"))
				.putForced(IcariaTextureSlots.STEM_GROUND_SHROOMS, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pLog, "top"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.MARL, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_horizontal_1")).build()
			.create(IcariaModelProvider.blockFile(pName, "horizontal_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.BROWN_GROUND_SHROOMS, IcariaModelProvider.blockFile(IcariaIdents.ID, "brown_ground_shrooms"))
				.putForced(IcariaTextureSlots.STEM_GROUND_SHROOMS, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pLog, "top"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.MARL, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_2")).build()
			.create(IcariaModelProvider.blockFile(pName, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pLog, "top"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.MARL, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.MOSS, IcariaModelProvider.blockFile(pMoss))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_horizontal_2")).build()
			.create(IcariaModelProvider.blockFile(pName, "horizontal_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pLog, "top"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.MARL, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.MOSS, IcariaModelProvider.blockFile(pMoss))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pLog)), pBlockModelGenerators.modelOutput);
	}

	public static void dishesCupboard(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dishes_cupboard")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.CUPBOARD, IcariaModelProvider.blockFile(pBlock, "dishes_cupboard", "cupboard"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "dishes_cupboard", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "dishes_cupboard", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOAM, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "dishes_cupboard", "log"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "dishes_cupboard", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "dishes_cupboard", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void dolomitePillarHead(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_bottom_top")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "dolomite_pillar_top"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(IcariaIdents.ID, "dolomite_pillar_head"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_dolomite"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "dolomite_pillar_head")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_bottom_top")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inverted"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "dolomite_pillar_top"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(IcariaIdents.ID, "dolomite_pillar_head_inverted"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_dolomite"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "dolomite_pillar_head_inverted")), pBlockModelGenerators.modelOutput);
	}

	public static void door(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "door_bottom_left")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "bottom_left"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pBlock, "bottom"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bottom")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "door_bottom_left_open")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "bottom_left_open"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pBlock, "bottom"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bottom")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "door_bottom_right")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "bottom_right"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pBlock, "bottom"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bottom")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "door_bottom_right_open")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "bottom_right_open"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pBlock, "bottom"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bottom")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "door_top_left")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "top_left"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pBlock, "bottom"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bottom")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "door_top_left_open")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "top_left_open"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pBlock, "bottom"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bottom")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "door_top_right")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "top_right"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pBlock, "bottom"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bottom")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "door_top_right_open")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "top_right_open"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pBlock, "bottom"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pBlock, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "bottom")), pBlockModelGenerators.modelOutput);
	}

	public static void fallenLeaves(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_1")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_2")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_3")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_4")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_5")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "5"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_6")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "6"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_7")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "7"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_8")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "8"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void farmland(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "farmland")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "dry"), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "farmland_dry"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "farmland")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "wet"), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "farmland_wet"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl")), pBlockModelGenerators.modelOutput);
	}

	public static void fence(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "fence_inventory")).build()
			.create(IcariaModelProvider.blockFile(pName, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "fence_post")).build()
			.create(IcariaModelProvider.blockFile(pName, "post"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "fence_side")).build()
			.create(IcariaModelProvider.blockFile(pName, "side"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void fenceGate(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_fence_gate")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_fence_gate_open")).build()
			.create(IcariaModelProvider.blockFile(pName, "open"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_fence_gate_wall")).build()
			.create(IcariaModelProvider.blockFile(pName, "wall"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_fence_gate_wall_open")).build()
			.create(IcariaModelProvider.blockFile(pName, "wall_open"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void fertilizedFarmland(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "farmland")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "fertilized_farmland"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl")), pBlockModelGenerators.modelOutput);
	}

	public static void fire(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_fire_floor")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "floor_0"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIRE, IcariaModelProvider.blockFile(pBlock, "0"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "0")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_fire_floor")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "floor_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIRE, IcariaModelProvider.blockFile(pBlock, "1"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "1")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_fire_side")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "side_0"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIRE, IcariaModelProvider.blockFile(pBlock, "0"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "0")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_fire_side")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "side_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIRE, IcariaModelProvider.blockFile(pBlock, "1"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "1")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_fire_side_alt")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "side_alt_0"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIRE, IcariaModelProvider.blockFile(pBlock, "0"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "0")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_fire_side_alt")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "side_alt_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIRE, IcariaModelProvider.blockFile(pBlock, "1"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "1")), pBlockModelGenerators.modelOutput);
	}

	public static void firewood(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_firewood")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.FIREWOOD, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "firewood", "log"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "firewood", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "firewood", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void firewoodWedge(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_firewood_wedge_jagged")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "jagged"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIREWOOD, IcariaModelProvider.blockFile(pBlock, "firewood_wedge", "firewood"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "firewood_wedge", "log"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "firewood_wedge", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "firewood_wedge", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_firewood_wedge_smooth")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "smooth"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIREWOOD, IcariaModelProvider.blockFile(pBlock, "firewood_wedge", "firewood"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "firewood_wedge", "log"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "firewood_wedge", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "firewood_wedge", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void flasksCupboard(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_flasks_cupboard")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.CUPBOARD, IcariaModelProvider.blockFile(pBlock, "flasks_cupboard", "cupboard"))
				.putForced(IcariaTextureSlots.KETTLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "kettle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "flasks_cupboard", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "flasks_cupboard", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "flasks_cupboard", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "flasks_cupboard", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "flasks_cupboard", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void flowerPotCountertop(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_flower_pot_countertop_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.CHERT_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "chert_block"))
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.MC, "dirt"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "flower_pot_countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "flower_pot_countertop", "planks"))
				.putForced(IcariaTextureSlots.FLOWER_POT, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "flower_pot_countertop", "log"))
				.putForced(IcariaTextureSlots.TRAPDOOR, IcariaModelProvider.blockFile(pBlock, "flower_pot_countertop", "trapdoor"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "flower_pot_countertop", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_flower_pot_countertop_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CHERT_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "chert_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "flower_pot_countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "flower_pot_countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "flower_pot_countertop", "log"))
				.putForced(IcariaTextureSlots.TRAPDOOR, IcariaModelProvider.blockFile(pBlock, "flower_pot_countertop", "trapdoor"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "flower_pot_countertop", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void flowerPotCross(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot_cross")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.PLANT, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot")), pBlockModelGenerators.modelOutput);
	}

	public static void forge(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_inventory")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.FORGE, IcariaModelProvider.blockFile(IcariaIdents.ID, "forge"))
				.putForced(IcariaTextureSlots.GRAINITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite"))
				.putForced(IcariaTextureSlots.GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite_bricks"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.STRIPPED_CYPRESS_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "stripped_cypress_log"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_bottom_back_left")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "bottom_back_left"), new TextureMapping()
				.putForced(IcariaTextureSlots.GRAINITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite"))
				.putForced(IcariaTextureSlots.GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite_bricks"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_bottom_back_right")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "bottom_back_right"), new TextureMapping()
				.putForced(IcariaTextureSlots.GRAINITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite"))
				.putForced(IcariaTextureSlots.GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite_bricks"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_bottom_front_left")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "bottom_front_left"), new TextureMapping()
				.putForced(IcariaTextureSlots.FORGE, IcariaModelProvider.blockFile(IcariaIdents.ID, "forge"))
				.putForced(IcariaTextureSlots.GRAINITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite"))
				.putForced(IcariaTextureSlots.GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite_bricks"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_bottom_front_right")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "bottom_front_right"), new TextureMapping()
				.putForced(IcariaTextureSlots.FORGE, IcariaModelProvider.blockFile(IcariaIdents.ID, "forge"))
				.putForced(IcariaTextureSlots.GRAINITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite"))
				.putForced(IcariaTextureSlots.GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite_bricks"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_bottom_front_right_lit")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "bottom_front_right_lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.LAVA_FLOW, IcariaModelProvider.blockFile(IcariaIdents.MC, "lava_flow"))
				.putForced(IcariaTextureSlots.LAVA_STILL, IcariaModelProvider.blockFile(IcariaIdents.MC, "lava_still"))
				.putForced(IcariaTextureSlots.FORGE, IcariaModelProvider.blockFile(IcariaIdents.ID, "forge"))
				.putForced(IcariaTextureSlots.GRAINITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite"))
				.putForced(IcariaTextureSlots.GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite_bricks"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_top_back_left")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "top_back_left"), new TextureMapping()
				.putForced(IcariaTextureSlots.GRAINITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite"))
				.putForced(IcariaTextureSlots.GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite_bricks"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_top_back_right")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "top_back_right"), new TextureMapping()
				.putForced(IcariaTextureSlots.FORGE, IcariaModelProvider.blockFile(IcariaIdents.ID, "forge"))
				.putForced(IcariaTextureSlots.GRAINITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite"))
				.putForced(IcariaTextureSlots.GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite_bricks"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_top_front_left")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "top_front_left"), new TextureMapping()
				.putForced(IcariaTextureSlots.FORGE, IcariaModelProvider.blockFile(IcariaIdents.ID, "forge"))
				.putForced(IcariaTextureSlots.GRAINITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite"))
				.putForced(IcariaTextureSlots.GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite_bricks"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_top_front_right")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "top_front_right"), new TextureMapping()
				.putForced(IcariaTextureSlots.FORGE, IcariaModelProvider.blockFile(IcariaIdents.ID, "forge"))
				.putForced(IcariaTextureSlots.GRAINITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite"))
				.putForced(IcariaTextureSlots.GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite_bricks"))
				.putForced(IcariaTextureSlots.STRIPPED_CYPRESS_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "stripped_cypress_log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grainite")), pBlockModelGenerators.modelOutput);
	}

	public static void grassyMarl(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "grass_block")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(IcariaIdents.ID, "grassy_marl_side"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "grassy_marl_top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_bottom_top")).build()
			.create(IcariaModelProvider.blockFile(IcariaIdents.ID, "forest_moss_marl"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(IcariaIdents.ID, "forest_moss_marl"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "forest_moss"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_bottom_top")).build()
			.create(IcariaModelProvider.blockFile(IcariaIdents.ID, "scrubland_moss_marl"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(IcariaIdents.ID, "scrubland_moss_marl"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "scrubland_moss"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_bottom_top")).build()
			.create(IcariaModelProvider.blockFile(IcariaIdents.ID, "steppe_moss_marl"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(IcariaIdents.ID, "steppe_moss_marl"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "steppe_moss"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "marl")), pBlockModelGenerators.modelOutput);
	}

	public static void grateFireplace(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grate_fireplace_inventory")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.CHALKOS_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "chalkos_mesh_block"))
				.putForced(IcariaTextureSlots.DROUGHTROOT_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "droughtroot_log"))
				.putForced(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_chalkos_block"))
				.putForced(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_grainite_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_sideros_block"))
				.putForced(IcariaTextureSlots.SURFACE_CHERT, IcariaModelProvider.blockFile(IcariaIdents.ID, "surface_chert"))
				.putForced(IcariaTextureSlots.VANADIUMSTEEL_CHAIN, IcariaModelProvider.blockFile(IcariaIdents.ID, "vanadiumsteel_chain"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grate_fireplace_lower")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "lower"), new TextureMapping()
				.putForced(IcariaTextureSlots.DROUGHTROOT_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "droughtroot_log"))
				.putForced(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_chalkos_block"))
				.putForced(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_grainite_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.SURFACE_CHERT, IcariaModelProvider.blockFile(IcariaIdents.ID, "surface_chert"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grate_fireplace_lower_lit")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "lower_lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIREWOOD, IcariaModelProvider.blockFile(IcariaIdents.ID, "firewood"))
				.putForced(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_chalkos_block"))
				.putForced(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_grainite_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.SURFACE_CHERT, IcariaModelProvider.blockFile(IcariaIdents.ID, "surface_chert"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grate_fireplace_upper")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "upper"), new TextureMapping()
				.putForced(IcariaTextureSlots.CHALKOS_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "chalkos_mesh_block"))
				.putForced(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_chalkos_block"))
				.putForced(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_sideros_block"))
				.putForced(IcariaTextureSlots.VANADIUMSTEEL_CHAIN, IcariaModelProvider.blockFile(IcariaIdents.ID, "vanadiumsteel_chain"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks")), pBlockModelGenerators.modelOutput);
	}

	public static void greenGroundShrooms(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_green_ground_shrooms_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_green_ground_shrooms_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_green_ground_shrooms_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void grinder(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grinder_inventory")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANTHRACITE_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "anthracite_block"))
				.putForced(IcariaTextureSlots.GRINDER, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder"))
				.putForced(IcariaTextureSlots.GRINDER_ENGINE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder_engine"))
				.putForced(IcariaTextureSlots.GRINDER_FEEDER, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder_feeder"))
				.putForced(IcariaTextureSlots.GRINDER_STONE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder_stone"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.STATIC_LEFT_GRINDER_CHAIN, IcariaModelProvider.blockFile(IcariaIdents.ID, "static_left_grinder_chain"))
				.putForced(IcariaTextureSlots.STATIC_RIGHT_GRINDER_CHAIN, IcariaModelProvider.blockFile(IcariaIdents.ID, "static_right_grinder_chain"))
				.putForced(IcariaTextureSlots.SUNSTONE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "sunstone_bricks"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "sunstone_bricks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grinder_left")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "left"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANTHRACITE_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "anthracite_block"))
				.putForced(IcariaTextureSlots.GRINDER, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder"))
				.putForced(IcariaTextureSlots.GRINDER_FEEDER, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder_feeder"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.SUNSTONE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "sunstone_bricks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "sunstone_bricks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grinder_right")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "right"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANTHRACITE_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "anthracite_block"))
				.putForced(IcariaTextureSlots.GRINDER, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder"))
				.putForced(IcariaTextureSlots.GRINDER_ENGINE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder_engine"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.SUNSTONE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "sunstone_bricks"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "sunstone_bricks")), pBlockModelGenerators.modelOutput);
	}

	public static void grinderShaft(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grinder_shaft")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder")), pBlockModelGenerators.modelOutput);
	}

	public static void grinderStone(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grinder_stone")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.GRINDER_STONE, IcariaModelProvider.blockFile(IcariaIdents.ID, "grinder_stone"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale")), pBlockModelGenerators.modelOutput);
	}

	public static void groundFlowers(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "flowerbed_1")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.FLOWERBED, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "ground_flowers_stem"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "flowerbed_2")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.FLOWERBED, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "ground_flowers_stem"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "flowerbed_3")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.FLOWERBED, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "ground_flowers_stem"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "flowerbed_4")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.FLOWERBED, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "ground_flowers_stem"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void haliteCrystal(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_halite_crystal")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void herbHolder(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_herb_holder")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.HERB_HOLDER, IcariaModelProvider.blockFile(IcariaIdents.ID, "herb_holder"))
				.putForced(IcariaTextureSlots.HERB_HOLDER_OVERLAY, IcariaModelProvider.blockFile(IcariaIdents.ID, "herb_holder_overlay"))
				.putForced(IcariaTextureSlots.LEAVES, IcariaModelProvider.blockFile(pBlock, "herb_holder", "leaves"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "herb_holder", "planks"))
				.putForced(IcariaTextureSlots.VANADIUMSTEEL_CHAIN, IcariaModelProvider.blockFile(IcariaIdents.ID, "vanadiumsteel_chain"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "herb_holder", "planks")), pBlockModelGenerators.modelOutput);
	}

	public static void horizontalBars(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_horizontal_bars")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void horizontalPane(Block pName, Block pEdge, Block pPane, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_horizontal_pane")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.EDGE, IcariaModelProvider.blockFile(pEdge))
				.putForced(IcariaTextureSlots.PANE, IcariaModelProvider.blockFile(pPane))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPane)), pBlockModelGenerators.modelOutput);
	}

	public static void jasperCrystal(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_jasper_crystal")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void kettle(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kettle_inventory")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.DROUGHTROOT_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "droughtroot_log"))
				.putForced(IcariaTextureSlots.KETTLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "kettle"))
				.putForced(IcariaTextureSlots.LAUREL_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_log"))
				.putForced(IcariaTextureSlots.LAUREL_PLANKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_planks"))
				.putForced(IcariaTextureSlots.RED_LOOT_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_loot_vase"))
				.putForced(IcariaTextureSlots.YELLOWSTONE, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellowstone"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kettle_lower")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "lower"), new TextureMapping()
				.putForced(IcariaTextureSlots.DROUGHTROOT_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "droughtroot_log"))
				.putForced(IcariaTextureSlots.KETTLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "kettle"))
				.putForced(IcariaTextureSlots.LAUREL_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_log"))
				.putForced(IcariaTextureSlots.LAUREL_PLANKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_planks"))
				.putForced(IcariaTextureSlots.RED_LOOT_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_loot_vase"))
				.putForced(IcariaTextureSlots.YELLOWSTONE, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellowstone"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kettle_lower_lit")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "lower_lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIREWOOD, IcariaModelProvider.blockFile(IcariaIdents.ID, "firewood"))
				.putForced(IcariaTextureSlots.KETTLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "kettle"))
				.putForced(IcariaTextureSlots.LAUREL_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_log"))
				.putForced(IcariaTextureSlots.LAUREL_PLANKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_planks"))
				.putForced(IcariaTextureSlots.RED_LOOT_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_loot_vase"))
				.putForced(IcariaTextureSlots.YELLOWSTONE, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellowstone"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kettle_upper")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock, "upper"), new TextureMapping()
				.putForced(IcariaTextureSlots.KETTLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "kettle"))
				.putForced(IcariaTextureSlots.LAUREL_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_log"))
				.putForced(IcariaTextureSlots.LAUREL_PLANKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_log")), pBlockModelGenerators.modelOutput);
	}

	public static void kiln(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kiln_inventory")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.KILN, IcariaModelProvider.blockFile(IcariaIdents.ID, "kiln"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.LAUREL_PLANKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_planks"))
				.putForced(IcariaTextureSlots.YELLOWSTONE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellowstone_bricks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellowstone_bricks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kiln_lower")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "lower"), new TextureMapping()
				.putForced(IcariaTextureSlots.KILN, IcariaModelProvider.blockFile(IcariaIdents.ID, "kiln"))
				.putForced(IcariaTextureSlots.LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "loam_bricks"))
				.putForced(IcariaTextureSlots.YELLOWSTONE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellowstone_bricks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellowstone_bricks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kiln_upper")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "upper"), new TextureMapping()
				.putForced(IcariaTextureSlots.KILN, IcariaModelProvider.blockFile(IcariaIdents.ID, "kiln"))
				.putForced(IcariaTextureSlots.LAUREL_PLANKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "laurel_planks"))
				.putForced(IcariaTextureSlots.YELLOWSTONE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellowstone_bricks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellowstone_bricks")), pBlockModelGenerators.modelOutput);
	}

	public static void kitchenTable(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kitchen_table_inventory")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kitchen_table", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kitchen_table", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kitchen_table", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kitchen_table", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kitchen_table", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kitchen_table_head")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kitchen_table", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kitchen_table", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kitchen_table", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kitchen_table", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kitchen_table", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kitchen_table_foot")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kitchen_table", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kitchen_table", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kitchen_table", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kitchen_table", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kitchen_table", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void kline(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_inventory")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("white", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "white_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "white_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("white", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "white_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "white_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("light_gray", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("light_gray", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("gray", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "gray_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "gray_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("gray", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "gray_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "gray_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("black", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "black_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "black_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("black", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "black_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "black_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("brown", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "brown_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "brown_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("brown", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "brown_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "brown_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("red", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("red", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("orange", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "orange_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "orange_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("orange", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "orange_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "orange_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("yellow", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellow_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellow_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("yellow", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellow_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellow_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("lime", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "lime_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "lime_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("lime", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "lime_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "lime_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("green", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "green_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "green_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("green", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "green_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "green_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("cyan", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("cyan", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("light_blue", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_blue_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_blue_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("light_blue", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_blue_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_blue_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("blue", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "blue_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "blue_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("blue", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "blue_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "blue_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("purple", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "purple_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "purple_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("purple", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "purple_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "purple_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("magenta", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "magenta_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "magenta_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("magenta", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "magenta_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "magenta_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("pink", pBlock, "head"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "pink_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "pink_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("pink", pBlock, "foot"), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "pink_arachne_string_block"))
				.putForced(IcariaTextureSlots.ARACHNE_STRING_MESH_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "pink_arachne_string_mesh_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "kline", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "kline", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "kline", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void ladder(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "ladder")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void largeBowls(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_large_bowls")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.SMOOTH_LOAM, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molibos_block"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam")), pBlockModelGenerators.modelOutput);
	}

	public static void largeBrownGroundShrooms(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_large_brown_ground_shrooms_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_large_brown_ground_shrooms_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_large_brown_ground_shrooms_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void ligniteTorch(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_lignite_torch")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TORCH_BONE, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_bone"))
				.putForced(IcariaTextureSlots.TORCH_COAL, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_coal"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_bone")), pBlockModelGenerators.modelOutput);
	}

	public static void ligniteWallTorch(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_lignite_wall_torch")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TORCH_BONE, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_bone"))
				.putForced(IcariaTextureSlots.TORCH_COAL, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_coal"))
				.putForced(IcariaTextureSlots.TORCH_METAL, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_metal"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "torch_bone")), pBlockModelGenerators.modelOutput);
	}

	public static void loadedBarrel(Block pLoadedBarrel, Block pBarrel, Block pPlanks, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_barrel")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pLoadedBarrel), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pLoadedBarrel, "front"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_standing_barrel")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("standing", pLoadedBarrel), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pLoadedBarrel, "front"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
	}

	public static void lootVase(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_3")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_4")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_5")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "5"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_6")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "6"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_7")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "7"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_8")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "8"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_9")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "9"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "particle")), pBlockModelGenerators.modelOutput);
	}

	public static void mondanos(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_mondanos")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void mortarCountertop(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_mortar_countertop")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "arachne_string_block"))
				.putForced(IcariaTextureSlots.CHALKOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "chalkos_block"))
				.putForced(IcariaTextureSlots.LEAVES, IcariaModelProvider.blockFile(pBlock, "mortar_countertop", "leaves"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "mortar_countertop", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "mortar_countertop", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOAM, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "mortar_countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "mortar_countertop", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void moss(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_3")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_4")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_5")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "5"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_6")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "6"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_7")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "7"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_8")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "8"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void mothAgaric(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_moth_agaric")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void namdrake(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_namdrake")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void oliveLeaves(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_all")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_all")).build()
			.create(IcariaModelProvider.blockFile("black", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile("black", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("black", pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_all")).build()
			.create(IcariaModelProvider.blockFile("green", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile("green", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("green", pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void overlayTextureBlock(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_block")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void overlayTextureCross(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_cross")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "overlay")), pBlockModelGenerators.modelOutput);
	}

	public static void overlayTextureFlowerPotCross(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_flower_pot_cross")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.MC, "dirt"))
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pFile, "overlay"))
				.putForced(IcariaTextureSlots.FLOWER_POT, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot")), pBlockModelGenerators.modelOutput);
	}

	public static void overlayTextureVine(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("dead", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile("dead", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("dead", pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("growing", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile("growing", pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile("growing", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("growing", pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void palmFern(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_palm_fern")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pBlock, "overlay"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "overlay")), pBlockModelGenerators.modelOutput);
	}

	public static void panHolder(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pan_holder")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "pan_holder", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.VANADIUMSTEEL_CHAIN, IcariaModelProvider.blockFile(IcariaIdents.ID, "vanadiumsteel_chain"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "pan_holder", "planks")), pBlockModelGenerators.modelOutput);
	}

	public static void pane(Block pEdge, Block pPane, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pane_inventory")).build()
			.create(IcariaModelProvider.blockFile(pEdge, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.EDGE, IcariaModelProvider.blockFile(pEdge))
				.putForced(IcariaTextureSlots.PANE, IcariaModelProvider.blockFile(pPane))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPane)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_glass_pane_noside")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pEdge, "noside"), new TextureMapping()
				.putForced(IcariaTextureSlots.PANE, IcariaModelProvider.blockFile(pPane))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPane)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_glass_pane_noside_alt")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pEdge, "noside_alt"), new TextureMapping()
				.putForced(IcariaTextureSlots.PANE, IcariaModelProvider.blockFile(pPane))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPane)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_glass_pane_post")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pEdge, "post"), new TextureMapping()
				.putForced(IcariaTextureSlots.EDGE, IcariaModelProvider.blockFile(pEdge))
				.putForced(IcariaTextureSlots.PANE, IcariaModelProvider.blockFile(pPane))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPane)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_glass_pane_side")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pEdge, "side"), new TextureMapping()
				.putForced(IcariaTextureSlots.EDGE, IcariaModelProvider.blockFile(pEdge))
				.putForced(IcariaTextureSlots.PANE, IcariaModelProvider.blockFile(pPane))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPane)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_glass_pane_side_alt")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pEdge, "side_alt"), new TextureMapping()
				.putForced(IcariaTextureSlots.EDGE, IcariaModelProvider.blockFile(pEdge))
				.putForced(IcariaTextureSlots.PANE, IcariaModelProvider.blockFile(pPane))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPane)), pBlockModelGenerators.modelOutput);
	}

	public static void path(Block pPath, Block pBase, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "farmland")).build()
			.create(IcariaModelProvider.blockFile(pPath), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(pBase))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pPath))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBase)), pBlockModelGenerators.modelOutput);
	}

	public static void particle(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void physalisCrop(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_0")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "0"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "0")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_1")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "1"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "1")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_1")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "1"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "1")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_2")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "2"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "2")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_2")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "2"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "2")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_3")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "5"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "3"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "3")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_3")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "6"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "3"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "3")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_4")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "7"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "4"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "4")), pBlockModelGenerators.modelOutput);
	}

	public static void plates(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_plates")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molibos_block"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block")), pBlockModelGenerators.modelOutput);
	}

	public static void portal(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_portal_x")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock, "x"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_portal_z")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock, "z"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void pot(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUM_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenum_block"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block")), pBlockModelGenerators.modelOutput);
	}

	public static void potCountertop(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_countertop")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.KETTLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "kettle"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "pot_countertop", "log"))
				.putForced(IcariaTextureSlots.MEDITERRANEAN_WATER, IcariaModelProvider.blockFile(IcariaIdents.ID, "mediterranean_water"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "pot_countertop", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "pot_countertop", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "pot_countertop", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void potFireplace(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_fireplace_inventory")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.DROUGHTROOT_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "droughtroot_log"))
				.putForced(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_chalkos_block"))
				.putForced(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_grainite_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_sideros_block"))
				.putForced(IcariaTextureSlots.SURFACE_CHERT, IcariaModelProvider.blockFile(IcariaIdents.ID, "surface_chert"))
				.putForced(IcariaTextureSlots.VANADIUMSTEEL_CHAIN, IcariaModelProvider.blockFile(IcariaIdents.ID, "vanadiumsteel_chain"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_fireplace_lower")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "lower"), new TextureMapping()
				.putForced(IcariaTextureSlots.DROUGHTROOT_LOG, IcariaModelProvider.blockFile(IcariaIdents.ID, "droughtroot_log"))
				.putForced(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_chalkos_block"))
				.putForced(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_grainite_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.SURFACE_CHERT, IcariaModelProvider.blockFile(IcariaIdents.ID, "surface_chert"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_fireplace_lower_lit")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "lower_lit"), new TextureMapping()
				.putForced(IcariaTextureSlots.FIREWOOD, IcariaModelProvider.blockFile(IcariaIdents.ID, "firewood"))
				.putForced(IcariaTextureSlots.SMOOTH_CHALKOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_chalkos_block"))
				.putForced(IcariaTextureSlots.SMOOTH_GRAINITE_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_grainite_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOAM_BRICKS, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.SURFACE_CHERT, IcariaModelProvider.blockFile(IcariaIdents.ID, "surface_chert"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_fireplace_upper")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "upper"), new TextureMapping()
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.SMOOTH_SIDEROS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_sideros_block"))
				.putForced(IcariaTextureSlots.VANADIUMSTEEL_CHAIN, IcariaModelProvider.blockFile(IcariaIdents.ID, "vanadiumsteel_chain"))
				.putForced(IcariaTextureSlots.VOIDSHALE, IcariaModelProvider.blockFile(IcariaIdents.ID, "voidshale"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam_bricks")), pBlockModelGenerators.modelOutput);
	}

	public static void potHolder(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_holder")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "pot_holder", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.VANADIUMSTEEL_CHAIN, IcariaModelProvider.blockFile(IcariaIdents.ID, "vanadiumsteel_chain"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "pot_holder", "planks")), pBlockModelGenerators.modelOutput);
	}

	public static void potsCupboard(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pots_cupboard")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.CUPBOARD, IcariaModelProvider.blockFile(pBlock, "pots_cupboard", "cupboard"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "pots_cupboard", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "pots_cupboard", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "pots_cupboard", "log"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "pots_cupboard", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "pots_cupboard", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void pottedBromelia(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_bromelia")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.MC, "dirt"))
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pFile, "overlay"))
				.putForced(IcariaTextureSlots.FLOWER_POT, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot")), pBlockModelGenerators.modelOutput);
	}

	public static void pottedBrownGroundShrooms(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_brown_ground_shrooms")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.MC, "dirt"))
				.putForced(IcariaTextureSlots.FLOWER_POT, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot"))
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot")), pBlockModelGenerators.modelOutput);
	}

	public static void pottedCardonCactus(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_cardon_cactus")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.MC, "dirt"))
				.putForced(IcariaTextureSlots.FLOWER_POT, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot"))
				.putForced(IcariaTextureSlots.CACTUS, IcariaModelProvider.blockFile(pFile, "side"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot")), pBlockModelGenerators.modelOutput);
	}

	public static void pottedGreenGroundShrooms(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_green_ground_shrooms")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.MC, "dirt"))
				.putForced(IcariaTextureSlots.FLOWER_POT, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot"))
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot")), pBlockModelGenerators.modelOutput);
	}

	public static void pottedLargeBrownGroundShrooms(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_large_brown_ground_shrooms")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.MC, "dirt"))
				.putForced(IcariaTextureSlots.FLOWER_POT, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot"))
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_ground_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot")), pBlockModelGenerators.modelOutput);
	}

	public static void pottedPalmFern(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_palm_fern")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.DIRT, IcariaModelProvider.blockFile(IcariaIdents.MC, "dirt"))
				.putForced(IcariaTextureSlots.OVERLAY, IcariaModelProvider.blockFile(pFile, "overlay"))
				.putForced(IcariaTextureSlots.FLOWER_POT, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot"))
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot")), pBlockModelGenerators.modelOutput);
	}

	public static void pressurePlate(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "pressure_plate_up")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "pressure_plate_down")).build()
			.create(IcariaModelProvider.blockFile(pName, "down"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void psilocybos(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_psilocybos")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void quartzPillarHead(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_bottom_top")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.MC, "quartz_pillar_top"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(IcariaIdents.ID, "quartz_pillar_head"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.MC, "chiseled_quartz_block_top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "quartz_pillar_head")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_bottom_top")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inverted"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.MC, "quartz_pillar_top"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(IcariaIdents.ID, "quartz_pillar_head_inverted"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.MC, "chiseled_quartz_block_top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "quartz_pillar_head_inverted")), pBlockModelGenerators.modelOutput);
	}

	public static void quartzWall(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "wall_inventory")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.WALL, IcariaModelProvider.blockFile(IcariaIdents.MC, "quartz_block_side"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "quartz_block_side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_wall_post")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "post"), new TextureMapping()
				.putForced(IcariaTextureSlots.WALL, IcariaModelProvider.blockFile(IcariaIdents.MC, "quartz_block_side"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "quartz_block_side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_wall_side")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "side"), new TextureMapping()
				.putForced(IcariaTextureSlots.WALL, IcariaModelProvider.blockFile(IcariaIdents.MC, "quartz_block_side"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "quartz_block_side")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_wall_side_tall")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "side_tall"), new TextureMapping()
				.putForced(IcariaTextureSlots.WALL, IcariaModelProvider.blockFile(IcariaIdents.MC, "quartz_block_side"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "quartz_block_side")), pBlockModelGenerators.modelOutput);
	}

	public static void rack(Block pName, Block pBarrel, Block pLoadedBarrel, Block pLog, Block pPlanks, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rack")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_barrel_rack")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "rack", "barrel_rack"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pBarrel, "front"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_barrel_rack")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("loaded", pName, "rack", "barrel_rack"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pLoadedBarrel, "front"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_tapped_barrel_rack")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("tapped", pName, "rack", "barrel_rack"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
	}

	public static void raisedBasinsCountertop(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_raised_basins_countertop")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.HALITE_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "halite_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "raised_basins_countertop", "log"))
				.putForced(IcariaTextureSlots.MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "raised_basins_countertop", "planks"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "raised_basins_countertop", "log"))
				.putForced(IcariaTextureSlots.TRAPDOOR, IcariaModelProvider.blockFile(pBlock, "raised_basins_countertop", "trapdoor"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "raised_basins_countertop", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void relicstonePillarHead(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_bottom_top")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "relicstone_pillar_top"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(IcariaIdents.ID, "relicstone_pillar_head"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "relicstone_pillar_head_top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "relicstone_pillar_head")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_bottom_top")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inverted"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(IcariaIdents.ID, "relicstone_pillar_top"))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(IcariaIdents.ID, "relicstone_pillar_head_inverted"))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(IcariaIdents.ID, "relicstone_pillar_head_top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "relicstone_pillar_head_inverted")), pBlockModelGenerators.modelOutput);
	}

	public static void rottenBoneLadder(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "ladder")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "ladder")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "cracked"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "cracked"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "cracked")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "ladder")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "damaged"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock, "damaged"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "damaged")), pBlockModelGenerators.modelOutput);
	}

	public static void rowan(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rowan")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void rubble(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rubble_0")).build()
			.create(IcariaModelProvider.blockFile(pName, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rubble_1")).build()
			.create(IcariaModelProvider.blockFile(pName, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rubble_2")).build()
			.create(IcariaModelProvider.blockFile(pName, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rubble_3")).build()
			.create(IcariaModelProvider.blockFile(pName, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rubble_4")).build()
			.create(IcariaModelProvider.blockFile(pName, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void scrollshelf(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_column")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.NORTH, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.EAST, IcariaModelProvider.blockFile(pBlock, "scrollshelf", "planks"))
				.putForced(IcariaTextureSlots.SOUTH, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.WEST, IcariaModelProvider.blockFile(pBlock, "scrollshelf", "planks"))
				.putForced(IcariaTextureSlots.UP, IcariaModelProvider.blockFile(pBlock, "scrollshelf", "planks"))
				.putForced(IcariaTextureSlots.DOWN, IcariaModelProvider.blockFile(pBlock, "scrollshelf", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "scrollshelf", "planks")), pBlockModelGenerators.modelOutput);
	}

	public static void simpleRack(Block pName, Block pBarrel, Block pLoadedBarrel, Block pLog, Block pPlanks, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_simple_rack")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_simple_barrel_rack")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "rack", "barrel_rack"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pBarrel, "front"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_simple_barrel_rack")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "simple", "simple_loaded", "rack", "barrel_rack"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pLoadedBarrel, "front"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_simple_tapped_barrel_rack")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName, "simple", "simple_tapped", "rack", "barrel_rack"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
	}

	public static void slab(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "slab")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "slab_top")).build()
			.create(IcariaModelProvider.blockFile(pName, "top"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void smallBowls(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_small_bowls")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.MEDITERRANEAN_WATER, IcariaModelProvider.blockFile(IcariaIdents.ID, "mediterranean_water"))
				.putForced(IcariaTextureSlots.SMOOTH_LOAM, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molibos_block"))
				.putForced(IcariaTextureSlots.SMOOTH_MOLYBDENUMSTEEL_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_molybdenumsteel_block"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "smooth_loam")), pBlockModelGenerators.modelOutput);
	}

	public static void spoonHolder(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_spoon_holder")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "spoon_holder", "planks"))
				.putForced(IcariaTextureSlots.TRAPDOOR, IcariaModelProvider.blockFile(pBlock, "spoon_holder", "trapdoor"))
				.putForced(IcariaTextureSlots.VANADIUMSTEEL_CHAIN, IcariaModelProvider.blockFile(IcariaIdents.ID, "vanadiumsteel_chain"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "spoon_holder", "planks")), pBlockModelGenerators.modelOutput);
	}

	public static void stairs(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "stairs")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "inner_stairs")).build()
			.create(IcariaModelProvider.blockFile(pName, "inner"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "outer_stairs")).build()
			.create(IcariaModelProvider.blockFile(pName, "outer"), new TextureMapping()
				.putForced(IcariaTextureSlots.BOTTOM, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.TOP, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void stool(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("white", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "white_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("light_gray", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("gray", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "gray_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("black", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "black_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("brown", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "brown_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("red", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("orange", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "orange_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("yellow", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellow_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("lime", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "lime_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("green", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "green_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("cyan", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("light_blue", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_blue_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("blue", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "blue_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("purple", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "purple_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("magenta", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "magenta_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool")).build()
			.create(IcariaModelProvider.blockFile("pink", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "pink_arachne_string_block"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("stripped", pBlock, "stool", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void storageVase(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_storage_vase")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.DARK, IcariaModelProvider.blockFile(pBlock, "dark"))
				.putForced(IcariaTextureSlots.LITE, IcariaModelProvider.blockFile(pBlock, "lite"))
				.putForced(IcariaTextureSlots.NECK, IcariaModelProvider.blockFile(pBlock, "neck"))
				.putForced(IcariaTextureSlots.VASE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "dark")), pBlockModelGenerators.modelOutput);
	}

	public static void strawberryBush(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.BUSH, IcariaModelProvider.blockFile(pBlock, "0"))
				.putForced(IcariaTextureSlots.BUSH_HORIZONTAL, IcariaModelProvider.blockFile(pBlock, "horizontal_0"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "horizontal_0")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.BUSH, IcariaModelProvider.blockFile(pBlock, "1"))
				.putForced(IcariaTextureSlots.BUSH_HORIZONTAL, IcariaModelProvider.blockFile(pBlock, "horizontal_1"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "horizontal_1")), pBlockModelGenerators.modelOutput);
	}

	public static void strawberryCrop(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.BUSH, IcariaModelProvider.blockFile(pBlock, "0"))
				.putForced(IcariaTextureSlots.BUSH_HORIZONTAL, IcariaModelProvider.blockFile(pBlock, "horizontal_0"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "horizontal_0")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.BUSH, IcariaModelProvider.blockFile(pBlock, "1"))
				.putForced(IcariaTextureSlots.BUSH_HORIZONTAL, IcariaModelProvider.blockFile(pBlock, "horizontal_1"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "horizontal_1")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.BUSH, IcariaModelProvider.blockFile(pBlock, "1"))
				.putForced(IcariaTextureSlots.BUSH_HORIZONTAL, IcariaModelProvider.blockFile(pBlock, "horizontal_1"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "horizontal_1")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.BUSH, IcariaModelProvider.blockFile(pBlock, "2"))
				.putForced(IcariaTextureSlots.BUSH_HORIZONTAL, IcariaModelProvider.blockFile(pBlock, "horizontal_2"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "horizontal_2")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.BUSH, IcariaModelProvider.blockFile(pBlock, "2"))
				.putForced(IcariaTextureSlots.BUSH_HORIZONTAL, IcariaModelProvider.blockFile(pBlock, "horizontal_2"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "horizontal_2")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "5"), new TextureMapping()
				.putForced(IcariaTextureSlots.BUSH, IcariaModelProvider.blockFile(pBlock, "3"))
				.putForced(IcariaTextureSlots.BUSH_HORIZONTAL, IcariaModelProvider.blockFile(pBlock, "horizontal_3"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "horizontal_3")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "6"), new TextureMapping()
				.putForced(IcariaTextureSlots.BUSH, IcariaModelProvider.blockFile(pBlock, "3"))
				.putForced(IcariaTextureSlots.BUSH_HORIZONTAL, IcariaModelProvider.blockFile(pBlock, "horizontal_3"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "horizontal_3")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "7"), new TextureMapping()
				.putForced(IcariaTextureSlots.BUSH, IcariaModelProvider.blockFile(pBlock, "4"))
				.putForced(IcariaTextureSlots.BUSH_HORIZONTAL, IcariaModelProvider.blockFile(pBlock, "horizontal_4"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "horizontal_4")), pBlockModelGenerators.modelOutput);
	}

	public static void strippedDeadLog(Block pName, Block pStrippedLog, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_0")).build()
			.create(IcariaModelProvider.blockFile(pName, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pStrippedLog, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pStrippedLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_horizontal_0")).build()
			.create(IcariaModelProvider.blockFile(pName, "horizontal_0"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pStrippedLog, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pStrippedLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_1")).build()
			.create(IcariaModelProvider.blockFile(pName, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pStrippedLog, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pStrippedLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_horizontal_1")).build()
			.create(IcariaModelProvider.blockFile(pName, "horizontal_1"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pStrippedLog, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pStrippedLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_2")).build()
			.create(IcariaModelProvider.blockFile(pName, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pStrippedLog, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pStrippedLog)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_horizontal_2")).build()
			.create(IcariaModelProvider.blockFile(pName, "horizontal_2"), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pStrippedLog))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pStrippedLog, "top"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pStrippedLog)), pBlockModelGenerators.modelOutput);
	}

	public static void surfaceBones(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_surface_bones")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void surfaceChert(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_surface_chert")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void suspiciousSand(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_all")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(pBlock, "0"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "0")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_all")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(pBlock, "1"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "1")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_all")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(pBlock, "2"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "2")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_all")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.ALL, IcariaModelProvider.blockFile(pBlock, "3"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "3")), pBlockModelGenerators.modelOutput);
	}

	public static void suspiciousSubstance(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_suspicious_substance_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.CALCITE, IcariaModelProvider.blockFile(IcariaIdents.MC, "calcite"))
				.putForced(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_arachne_string_block"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_concrete_powder")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_suspicious_substance_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.CALCITE, IcariaModelProvider.blockFile(IcariaIdents.MC, "calcite"))
				.putForced(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_arachne_string_block"))
				.putForced(IcariaTextureSlots.WHITE_CONCRETE_POWDER, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_concrete_powder"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_concrete_powder")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_suspicious_substance_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.CALCITE, IcariaModelProvider.blockFile(IcariaIdents.MC, "calcite"))
				.putForced(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_arachne_string_block"))
				.putForced(IcariaTextureSlots.WHITE_CONCRETE_POWDER, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_concrete_powder"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_concrete_powder")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_suspicious_substance_3")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.CALCITE, IcariaModelProvider.blockFile(IcariaIdents.MC, "calcite"))
				.putForced(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_arachne_string_block"))
				.putForced(IcariaTextureSlots.WHITE_CONCRETE_POWDER, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_concrete_powder"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "white_concrete_powder")), pBlockModelGenerators.modelOutput);
	}

	public static void tappedBarrel(Block pTappedBarrel, Block pBarrel, Block pPlanks, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_tapped_barrel")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pTappedBarrel), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_standing_tapped_barrel")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("standing", pTappedBarrel), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pBarrel, "front"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
	}

	public static void tinderFungusTreeShrooms(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_tinder_fungus_tree_shrooms_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_tinder_fungus_tree_shrooms_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_tinder_fungus_tree_shrooms_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void tintedCross(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "tinted_cross")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.CROSS, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void tintedFlowerPotCross(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "tinted_flower_pot_cross")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.PLANT, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.MC, "flower_pot")), pBlockModelGenerators.modelOutput);
	}

	public static void towelHolder(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("white", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "white_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("light_gray", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_gray_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("gray", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "gray_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("black", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "black_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("brown", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "brown_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("red", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "red_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("orange", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "orange_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("yellow", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "yellow_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("lime", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "lime_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("green", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "green_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("cyan", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("light_blue", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "light_blue_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("blue", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "blue_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("purple", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "purple_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("magenta", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "magenta_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder")).build()
			.create(IcariaModelProvider.blockFile("pink", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.ARACHNE_STRING_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "pink_arachne_string_block"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log"))
				.putForced(IcariaTextureSlots.LOG_TOP, IcariaModelProvider.blockFile(pBlock, "towel_holder", "log_top"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock, "towel_holder", "planks")), pBlockModelGenerators.modelOutput);
	}

	public static void trapdoor(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_orientable_trapdoor_bottom")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "bottom"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_orientable_trapdoor_open")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "open"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_orientable_trapdoor_top")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "top"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void tripleBarrelRack(Block pBlock, Block pBarrel, Block pLog, Block pPlanks, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_triple_barrel_rack_inventory")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pBarrel, "front"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_triple_barrel_rack_top_left")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "top_left"), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.BARREL_BACK, IcariaModelProvider.blockFile(pBarrel, "back"))
				.putForced(IcariaTextureSlots.BARREL_FRONT, IcariaModelProvider.blockFile(pBarrel, "front"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_triple_barrel_rack_top_right")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock, "top_right"), new TextureMapping()
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
	}

	public static void trough(Block pName, Block pLog, Block pPlanks, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_trough")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.ANVIL, IcariaModelProvider.blockFile(IcariaIdents.MC, "anvil"))
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pLog))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pPlanks))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pPlanks)), pBlockModelGenerators.modelOutput);
	}

	public static void turkeyTailTreeShrooms(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_turkey_tail_tree_shrooms_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_turkey_tail_tree_shrooms_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_turkey_tail_tree_shrooms_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void twigs(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_twigs_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_twigs_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_twigs_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_twigs_3")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "3"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_twigs_4")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "4"), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void unnamedTreeShrooms(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_unnamed_tree_shrooms_0")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_tree_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_unnamed_tree_shrooms_1")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_tree_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_unnamed_tree_shrooms_2")).build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.SHROOM, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.STEM, IcariaModelProvider.blockFile(IcariaIdents.ID, "stem_tree_shrooms"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void vase(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_vase_0")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock, "0"), new TextureMapping()
				.putForced(IcariaTextureSlots.HALITE_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "halite_block"))
				.putForced(IcariaTextureSlots.LOOT_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_loot_vase"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_loot_vase_particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_vase_1")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock, "1"), new TextureMapping()
				.putForced(IcariaTextureSlots.HALITE_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "halite_block"))
				.putForced(IcariaTextureSlots.LOOT_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_loot_vase"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_loot_vase_particle")), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_vase_2")).renderType("translucent").build()
			.create(IcariaModelProvider.blockFile(pBlock, "2"), new TextureMapping()
				.putForced(IcariaTextureSlots.HALITE_BLOCK, IcariaModelProvider.blockFile(IcariaIdents.ID, "halite_block"))
				.putForced(IcariaTextureSlots.LOOT_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_loot_vase"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(IcariaIdents.ID, "cyan_loot_vase_particle")), pBlockModelGenerators.modelOutput);
	}

	public static void vaseCupboard(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_vase_cupboard")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.LOG, IcariaModelProvider.blockFile(pBlock, "vase_cupboard", "log"))
				.putForced(IcariaTextureSlots.PLANKS, IcariaModelProvider.blockFile(pBlock, "vase_cupboard", "planks"))
				.putForced(IcariaTextureSlots.SMOOTH_LOG, IcariaModelProvider.blockFile("smooth", pBlock, "vase_cupboard", "log"))
				.putForced(IcariaTextureSlots.STORAGE_VASE, IcariaModelProvider.blockFile(IcariaIdents.ID, "storage_vase"))
				.putForced(IcariaTextureSlots.STORAGE_VASE_DARK, IcariaModelProvider.blockFile(IcariaIdents.ID, "storage_vase_dark"))
				.putForced(IcariaTextureSlots.STORAGE_VASE_LITE, IcariaModelProvider.blockFile(IcariaIdents.ID, "storage_vase_lite"))
				.putForced(IcariaTextureSlots.STORAGE_VASE_NECK, IcariaModelProvider.blockFile(IcariaIdents.ID, "storage_vase_neck"))
				.putForced(IcariaTextureSlots.STRIPPED_LOG, IcariaModelProvider.blockFile("stripped", pBlock, "vase_cupboard", "log"))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("smooth", pBlock, "vase_cupboard", "log")), pBlockModelGenerators.modelOutput);
	}

	public static void vine(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.VINE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("dead", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.VINE, IcariaModelProvider.blockFile("dead", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("dead", pBlock)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "vine")).renderType("cutout").build()
			.create(IcariaModelProvider.blockFile("growing", pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.VINE, IcariaModelProvider.blockFile("growing", pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile("growing", pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void wall(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "wall_inventory")).build()
			.create(IcariaModelProvider.blockFile(pName, "inventory"), new TextureMapping()
				.putForced(IcariaTextureSlots.WALL, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_wall_post")).build()
			.create(IcariaModelProvider.blockFile(pName, "post"), new TextureMapping()
				.putForced(IcariaTextureSlots.WALL, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_wall_side")).build()
			.create(IcariaModelProvider.blockFile(pName, "side"), new TextureMapping()
				.putForced(IcariaTextureSlots.WALL, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "template_wall_side_tall")).build()
			.create(IcariaModelProvider.blockFile(pName, "side_tall"), new TextureMapping()
				.putForced(IcariaTextureSlots.WALL, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void water(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void wiltedElm(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_wilted_elm")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void wood(Block pName, Block pFile, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_column")).build()
			.create(IcariaModelProvider.blockFile(pName), new TextureMapping()
				.putForced(IcariaTextureSlots.END, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "cube_column_horizontal")).build()
			.create(IcariaModelProvider.blockFile(pName, "horizontal"), new TextureMapping()
				.putForced(IcariaTextureSlots.END, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.SIDE, IcariaModelProvider.blockFile(pFile))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pFile)), pBlockModelGenerators.modelOutput);
	}

	public static void zirconCrystal(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_zircon_crystal")).build()
			.create(IcariaModelProvider.blockFile(pBlock), new TextureMapping()
				.putForced(IcariaTextureSlots.TEXTURE, IcariaModelProvider.blockFile(pBlock))
				.putForced(IcariaTextureSlots.PARTICLE, IcariaModelProvider.blockFile(pBlock)), pBlockModelGenerators.modelOutput);
	}

	public static void amphoraModel(BlockModelGenerators pBlockModelGenerators) {
		AmphoraModel.singleAmphora().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_amphora_single"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		AmphoraModel.doubleAmphora().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_amphora_double"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		AmphoraModel.tripleAmphora().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_amphora_triple"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void anthraciteTorchModel(BlockModelGenerators pBlockModelGenerators) {
		AnthraciteTorchModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_anthracite_torch"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void anthraciteWallTorchModel(BlockModelGenerators pBlockModelGenerators) {
		AnthraciteWallTorchModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_anthracite_wall_torch"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void barrelModel(BlockModelGenerators pBlockModelGenerators) {
		BarrelModel.barrel().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_barrel"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		BarrelModel.standingBarrel().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_standing_barrel"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void barsInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		BarsInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bars_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void basinsCountertopModel(BlockModelGenerators blockModels) {
		BasinsCountertopModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_basins_countertop"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void bathtubInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		BathtubInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bathtub_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void bathtubModel(BlockModelGenerators pBlockModelGenerators) {
		BathtubModel.head().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bathtub_head"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		BathtubModel.headRemains().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bathtub_head_remains"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		BathtubModel.foot().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bathtub_foot"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void bolbosModel(BlockModelGenerators pBlockModelGenerators) {
		BolbosModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bolbos"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void bromeliaModel(BlockModelGenerators pBlockModelGenerators) {
		BromeliaModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_bromelia"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void brownGroundShroomsModel(BlockModelGenerators pBlockModelGenerators) {
		BrownGroundShroomsModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_brown_ground_shrooms_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		BrownGroundShroomsModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_brown_ground_shrooms_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		BrownGroundShroomsModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_brown_ground_shrooms_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void cakeModel(BlockModelGenerators pBlockModelGenerators) {
		CakeModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cake_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		CakeModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cake_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		CakeModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cake_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		CakeModel.template3().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cake_3"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void calciteCrystalModel(BlockModelGenerators pBlockModelGenerators) {
		CalciteCrystalModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_calcite_crystal"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void cardonCactusInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		CardonCactusInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cardon_cactus_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void cardonCactusModel(BlockModelGenerators blockModels) {
		CardonCactusModel.cube().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cardon_cactus_cube"), new TextureMapping(), blockModels.modelOutput);
		CardonCactusModel.stem().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cardon_cactus_stem"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void checkersModel(BlockModelGenerators blockModels) {
		CheckersModel.played().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_checkers_played"), new TextureMapping(), blockModels.modelOutput);
		CheckersModel.set().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_checkers_set"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void chessModel(BlockModelGenerators blockModels) {
		ChessModel.played().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chess_played"), new TextureMapping(), blockModels.modelOutput);
		ChessModel.set().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chess_set"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void chimneyModel(BlockModelGenerators pBlockModelGenerators) {
		ChimneyModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chimney"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void chimneyBrickCrownModel(BlockModelGenerators pBlockModelGenerators) {
		ChimneyBrickCrownModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chimney_brick_crown"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void chimneyGrateCrownModel(BlockModelGenerators pBlockModelGenerators) {
		ChimneyGrateCrownModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chimney_grate_crown"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void chimneySlabModel(BlockModelGenerators pBlockModelGenerators) {
		ChimneySlabModel.bottom().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chimney_slab_bottom"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		ChimneySlabModel.top().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_chimney_slab_top"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void countertopModel(BlockModelGenerators blockModels) {
		CountertopModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_0"), new TextureMapping(), blockModels.modelOutput);
		CountertopModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_1"), new TextureMapping(), blockModels.modelOutput);
		CountertopModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_2"), new TextureMapping(), blockModels.modelOutput);
		CountertopModel.template3().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_3"), new TextureMapping(), blockModels.modelOutput);
		CountertopModel.template4().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_countertop_4"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void cupboardModel(BlockModelGenerators blockModels) {
		CupboardModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cupboard"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void cuttingBoardModel(BlockModelGenerators blockModels) {
		CuttingBoardModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_cutting_board"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void dathullaModel(BlockModelGenerators pBlockModelGenerators) {
		DathullaModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dathulla"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void deadLogModel(BlockModelGenerators pBlockModelGenerators) {
		DeadLogModel.log0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		DeadLogModel.log1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		DeadLogModel.log2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		DeadLogModel.logHorizontal0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_horizontal_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		DeadLogModel.logHorizontal1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_horizontal_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		DeadLogModel.logHorizontal2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_log_horizontal_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void deadVineModel(BlockModelGenerators pBlockModelGenerators) {
		DeadVineModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dead_vine"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void dishesCupboardModel(BlockModelGenerators blockModels) {
		DishesCupboardModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_dishes_cupboard"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void grateFireplaceInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		GrateFireplaceInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grate_fireplace_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void grateFireplaceModel(BlockModelGenerators pBlockModelGenerators) {
		GrateFireplaceModel.lower().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grate_fireplace_lower"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		GrateFireplaceModel.lowerLit().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grate_fireplace_lower_lit"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		GrateFireplaceModel.upper().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grate_fireplace_upper"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void firewoodModel(BlockModelGenerators blockModels) {
		FirewoodModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_firewood"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void firewoodWedgeModel(BlockModelGenerators blockModels) {
		FirewoodWedgeModel.jagged().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_firewood_wedge_jagged"), new TextureMapping(), blockModels.modelOutput);
		FirewoodWedgeModel.smooth().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_firewood_wedge_smooth"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void flasksCupboardModel(BlockModelGenerators blockModels) {
		FlasksCupboardModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_flasks_cupboard"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void flowerPotCountertopModel(BlockModelGenerators blockModels) {
		FlowerPotCountertopModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_flower_pot_countertop_0"), new TextureMapping(), blockModels.modelOutput);
		FlowerPotCountertopModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_flower_pot_countertop_1"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void forgeInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		ForgeInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void forgeModel(BlockModelGenerators pBlockModelGenerators) {
		ForgeModel.bottomFrontLeft().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_bottom_front_left"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		ForgeModel.bottomFrontRight().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_bottom_front_right"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		ForgeModel.bottomFrontRightLit().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_bottom_front_right_lit"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		ForgeModel.bottomBackLeft().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_bottom_back_left"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		ForgeModel.bottomBackRight().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_bottom_back_right"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		ForgeModel.topFrontLeft().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_top_front_left"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		ForgeModel.topFrontRight().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_top_front_right"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		ForgeModel.topBackLeft().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_top_back_left"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		ForgeModel.topBackRight().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_forge_top_back_right"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void greenGroundShroomsModel(BlockModelGenerators pBlockModelGenerators) {
		GreenGroundShroomsModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_green_ground_shrooms_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		GreenGroundShroomsModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_green_ground_shrooms_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		GreenGroundShroomsModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_green_ground_shrooms_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void grinderInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		GrinderInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grinder_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void grinderModel(BlockModelGenerators pBlockModelGenerators) {
		GrinderModel.left().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grinder_left"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		GrinderModel.right().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grinder_right"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void grinderShaftModel(BlockModelGenerators pBlockModelGenerators) {
		GrinderShaftModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grinder_shaft"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void grinderStoneModel(BlockModelGenerators pBlockModelGenerators) {
		GrinderStoneModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_grinder_stone"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void haliteCrystalModel(BlockModelGenerators pBlockModelGenerators) {
		HaliteCrystalModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_halite_crystal"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void herbHolderModel(BlockModelGenerators pBlockModelGenerators) {
		HerbHolderModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_herb_holder"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void horizontalBarsModel(BlockModelGenerators pBlockModelGenerators) {
		HorizontalBarsModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_horizontal_bars"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void horizontalPaneModel(BlockModelGenerators pBlockModelGenerators) {
		HorizontalPaneModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_horizontal_pane"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void jasperCrystalModel(BlockModelGenerators pBlockModelGenerators) {
		JasperCrystalModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_jasper_crystal"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void kettleInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		KettleInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kettle_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void kettleModel(BlockModelGenerators pBlockModelGenerators) {
		KettleModel.lower().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kettle_lower"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		KettleModel.lowerLit().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kettle_lower_lit"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		KettleModel.upper().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kettle_upper"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void kilnInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		KilnInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kiln_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void kilnModel(BlockModelGenerators pBlockModelGenerators) {
		KilnModel.lower().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kiln_lower"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		KilnModel.upper().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kiln_upper"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void kitchenTableInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		KitchenTableInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kitchen_table_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void kitchenTableModel(BlockModelGenerators pBlockModelGenerators) {
		KitchenTableModel.head().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kitchen_table_head"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		KitchenTableModel.foot().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kitchen_table_foot"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void klineInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		KlineInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void klineModel(BlockModelGenerators pBlockModelGenerators) {
		KlineModel.head().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_head"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		KlineModel.foot().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_kline_foot"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void largeBowlsModel(BlockModelGenerators pBlockModelGenerators) {
		LargeBowlsModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_large_bowls"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void largeBrownGroundShroomsModel(BlockModelGenerators pBlockModelGenerators) {
		LargeBrownGroundShroomsModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_large_brown_ground_shrooms_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LargeBrownGroundShroomsModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_large_brown_ground_shrooms_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LargeBrownGroundShroomsModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_large_brown_ground_shrooms_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void layerModel(BlockModelGenerators pBlockModelGenerators) {
		LayerModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LayerModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LayerModel.template3().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_3"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LayerModel.template4().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_4"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LayerModel.template5().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_5"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LayerModel.template6().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_6"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LayerModel.template7().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_7"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LayerModel.template8().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_layer_8"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void ligniteTorchModel(BlockModelGenerators pBlockModelGenerators) {
		LigniteTorchModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_lignite_torch"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void ligniteWallTorchModel(BlockModelGenerators pBlockModelGenerators) {
		LigniteWallTorchModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_lignite_wall_torch"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void lootVaseModel(BlockModelGenerators pBlockModelGenerators) {
		LootVaseModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LootVaseModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LootVaseModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LootVaseModel.template3().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_3"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LootVaseModel.template4().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_4"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LootVaseModel.template5().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_5"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LootVaseModel.template6().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_6"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LootVaseModel.template7().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_7"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LootVaseModel.template8().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_8"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		LootVaseModel.template9().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_loot_vase_9"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void mondanosModel(BlockModelGenerators pBlockModelGenerators) {
		MondanosModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_mondanos"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void mortarCountertopModel(BlockModelGenerators blockModels) {
		MortarCountertopModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_mortar_countertop"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void mothAgaricModel(BlockModelGenerators pBlockModelGenerators) {
		MothAgaricModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_moth_agaric"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void namdrakeModel(BlockModelGenerators pBlockModelGenerators) {
		NamdrakeModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_namdrake"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void overlayTextureBlockModel(BlockModelGenerators pBlockModelGenerators) {
		OverlayTextureBlockModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_block"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void overlayTextureCrossModel(BlockModelGenerators pBlockModelGenerators) {
		OverlayTextureCrossModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_cross"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void overlayTextureFlowerPotCrossModel(BlockModelGenerators pBlockModelGenerators) {
		OverlayTextureFlowerPotCrossModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_flower_pot_cross"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void overlayTextureVineModel(BlockModelGenerators pBlockModelGenerators) {
		OverlayTextureVineModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_overlay_texture_vine"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void palmFernModel(BlockModelGenerators pBlockModelGenerators) {
		PalmFernModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_palm_fern"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void panHolderModel(BlockModelGenerators pBlockModelGenerators) {
		PanHolderModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pan_holder"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void paneInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		PaneInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pane_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void physalisCropModel(BlockModelGenerators pBlockModelGenerators) {
		PhysalisCropModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		PhysalisCropModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		PhysalisCropModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		PhysalisCropModel.template3().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_3"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		PhysalisCropModel.template4().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_physalis_crop_4"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void platesModel(BlockModelGenerators pBlockModelGenerators) {
		PlatesModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_plates"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void portalModel(BlockModelGenerators pBlockModelGenerators) {
		PortalModel.x().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_portal_x"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		PortalModel.z().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_portal_z"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void potModel(BlockModelGenerators blockModels) {
		PotModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void potCountertopModel(BlockModelGenerators blockModels) {
		PotCountertopModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_countertop"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void potFireplaceInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		PotFireplaceInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_fireplace_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void potFireplaceModel(BlockModelGenerators pBlockModelGenerators) {
		PotFireplaceModel.lower().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_fireplace_lower"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		PotFireplaceModel.lowerLit().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_fireplace_lower_lit"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		PotFireplaceModel.upper().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_fireplace_upper"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void potHolderModel(BlockModelGenerators pBlockModelGenerators) {
		PotHolderModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pot_holder"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void potsCupboardModel(BlockModelGenerators blockModels) {
		PotsCupboardModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_pots_cupboard"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void pottedBromeliaModel(BlockModelGenerators pBlockModelGenerators) {
		PottedBromeliaModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_bromelia"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void pottedBrownGroundShroomsModel(BlockModelGenerators pBlockModelGenerators) {
		PottedBrownGroundShroomsModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_brown_ground_shrooms"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void pottedCardonCactusModel(BlockModelGenerators pBlockModelGenerators) {
		PottedCardonCactusModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_cardon_cactus"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void pottedGreenGroundShroomsModel(BlockModelGenerators pBlockModelGenerators) {
		PottedGreenGroundShroomsModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_green_ground_shrooms"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void pottedLargeBrownGroundShroomsModel(BlockModelGenerators pBlockModelGenerators) {
		PottedLargeBrownGroundShroomsModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_large_brown_ground_shrooms"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void pottedPalmFernModel(BlockModelGenerators pBlockModelGenerators) {
		PottedPalmFernModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_potted_palm_fern"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void psilocybosModel(BlockModelGenerators pBlockModelGenerators) {
		PsilocybosModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_psilocybos"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void rackModel(BlockModelGenerators pBlockModelGenerators) {
		RackModel.simple().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rack"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		RackModel.barrel().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_barrel_rack"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		RackModel.tapped().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_tapped_barrel_rack"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void raisedBasinsCountertopModel(BlockModelGenerators blockModels) {
		RaisedBasinsCountertopModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_raised_basins_countertop"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void rowanModel(BlockModelGenerators pBlockModelGenerators) {
		RowanModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rowan"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void rubbleModel(BlockModelGenerators pBlockModelGenerators) {
		RubbleModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rubble_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		RubbleModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rubble_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		RubbleModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rubble_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		RubbleModel.template3().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rubble_3"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		RubbleModel.template4().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_rubble_4"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void simpleRackModel(BlockModelGenerators pBlockModelGenerators) {
		SimpleRackModel.simple().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_simple_rack"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		SimpleRackModel.barrel().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_simple_barrel_rack"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		SimpleRackModel.tapped().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_simple_tapped_barrel_rack"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void smallBowlsModel(BlockModelGenerators pBlockModelGenerators) {
		SmallBowlsModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_small_bowls"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void spoonHolderModel(BlockModelGenerators pBlockModelGenerators) {
		SpoonHolderModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_spoon_holder"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void stoolModel(BlockModelGenerators pBlockModelGenerators) {
		StoolModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stool"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void storageVaseModel(BlockModelGenerators pBlockModelGenerators) {
		StorageVaseModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_storage_vase"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void strawberryBushModel(BlockModelGenerators pBlockModelGenerators) {
		StrawberryBushModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_strawberry_bush"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void strippedDeadLogModel(BlockModelGenerators pBlockModelGenerators) {
		StrippedDeadLogModel.log0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		StrippedDeadLogModel.log1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		StrippedDeadLogModel.log2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		StrippedDeadLogModel.logHorizontal0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_horizontal_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		StrippedDeadLogModel.logHorizontal1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_horizontal_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		StrippedDeadLogModel.logHorizontal2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_stripped_dead_log_horizontal_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void surfaceBonesModel(BlockModelGenerators pBlockModelGenerators) {
		SurfaceBonesModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_surface_bones"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void surfaceChertModel(BlockModelGenerators pBlockModelGenerators) {
		SurfaceChertModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_surface_chert"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void suspiciousSubstanceModel(BlockModelGenerators pBlockModelGenerators) {
		SuspiciousSubstanceModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_suspicious_substance_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		SuspiciousSubstanceModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_suspicious_substance_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		SuspiciousSubstanceModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_suspicious_substance_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		SuspiciousSubstanceModel.template3().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_suspicious_substance_3"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void tappedBarrelModel(BlockModelGenerators pBlockModelGenerators) {
		TappedBarrelModel.barrel().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_tapped_barrel"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		TappedBarrelModel.standingBarrel().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_standing_tapped_barrel"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void tinderFungusTreeShroomsModel(BlockModelGenerators pBlockModelGenerators) {
		TinderFungusTreeShroomsModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_tinder_fungus_tree_shrooms_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		TinderFungusTreeShroomsModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_tinder_fungus_tree_shrooms_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		TinderFungusTreeShroomsModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_tinder_fungus_tree_shrooms_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void towelHolderModel(BlockModelGenerators pBlockModelGenerators) {
		TowelHolderModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_towel_holder"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void tripleBarrelRackInventoryModel(BlockModelGenerators pBlockModelGenerators) {
		TripleBarrelRackInventoryModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_triple_barrel_rack_inventory"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void tripleBarrelRackModel(BlockModelGenerators pBlockModelGenerators) {
		TripleBarrelRackModel.topLeft().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_triple_barrel_rack_top_left"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		TripleBarrelRackModel.topRight().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_triple_barrel_rack_top_right"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void troughModel(BlockModelGenerators pBlockModelGenerators) {
		TroughModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_trough"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void turkeyTailTreeShroomsModel(BlockModelGenerators pBlockModelGenerators) {
		TurkeyTailTreeShroomsModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_turkey_tail_tree_shrooms_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		TurkeyTailTreeShroomsModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_turkey_tail_tree_shrooms_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		TurkeyTailTreeShroomsModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_turkey_tail_tree_shrooms_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void twigsModel(BlockModelGenerators pBlockModelGenerators) {
		TwigsModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_twigs_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		TwigsModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_twigs_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		TwigsModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_twigs_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		TwigsModel.template3().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_twigs_3"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		TwigsModel.template4().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_twigs_4"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void unnamedTreeShroomsModel(BlockModelGenerators pBlockModelGenerators) {
		UnnamedTreeShroomsModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_unnamed_tree_shrooms_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		UnnamedTreeShroomsModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_unnamed_tree_shrooms_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		UnnamedTreeShroomsModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_unnamed_tree_shrooms_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void vaseModel(BlockModelGenerators pBlockModelGenerators) {
		VaseModel.template0().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_vase_0"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		VaseModel.template1().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_vase_1"), new TextureMapping(), pBlockModelGenerators.modelOutput);
		VaseModel.template2().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_vase_2"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void vaseCupboardModel(BlockModelGenerators blockModels) {
		VaseCupboardModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_vase_cupboard"), new TextureMapping(), blockModels.modelOutput);
	}

	public static void wiltedElmModel(BlockModelGenerators pBlockModelGenerators) {
		WiltedElmModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_wilted_elm"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}

	public static void zirconCrystalModel(BlockModelGenerators pBlockModelGenerators) {
		ZirconCrystalModel.template().create(IcariaModelProvider.blockFile(IcariaIdents.ID, "template_zircon_crystal"), new TextureMapping(), pBlockModelGenerators.modelOutput);
	}
}
