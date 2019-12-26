package com.axanthic.loi;

import java.util.ArrayList;
import java.util.List;

import com.axanthic.loi.blocks.BlockAristone;
import com.axanthic.loi.blocks.BlockBasic;
import com.axanthic.loi.blocks.BlockBasicVineDead;
import com.axanthic.loi.blocks.BlockBasicVineGrowing;
import com.axanthic.loi.blocks.BlockBromelia;
import com.axanthic.loi.blocks.BlockCardonCactus;
import com.axanthic.loi.blocks.BlockCustomDoor;
import com.axanthic.loi.blocks.BlockCustomFence;
import com.axanthic.loi.blocks.BlockCustomFenceGate;
import com.axanthic.loi.blocks.BlockCustomPane;
import com.axanthic.loi.blocks.BlockCustomSlab;
import com.axanthic.loi.blocks.BlockCustomStairs;
import com.axanthic.loi.blocks.BlockCustomTrapdoor;
import com.axanthic.loi.blocks.BlockCustomWall;
import com.axanthic.loi.blocks.BlockCustomWorkbench;
import com.axanthic.loi.blocks.BlockFarmLand;
import com.axanthic.loi.blocks.BlockFarmLandFertilized;
import com.axanthic.loi.blocks.BlockFlower;
import com.axanthic.loi.blocks.BlockFlower2;
import com.axanthic.loi.blocks.BlockFluidCustom;
import com.axanthic.loi.blocks.BlockFluidUpwards;
import com.axanthic.loi.blocks.BlockForge;
import com.axanthic.loi.blocks.BlockGem;
import com.axanthic.loi.blocks.BlockGlassy;
import com.axanthic.loi.blocks.BlockGrainelStone;
import com.axanthic.loi.blocks.BlockGravity;
import com.axanthic.loi.blocks.BlockGrinder;
import com.axanthic.loi.blocks.BlockHerb;
import com.axanthic.loi.blocks.BlockKiln;
import com.axanthic.loi.blocks.BlockLeaf;
import com.axanthic.loi.blocks.BlockLeafOlives;
import com.axanthic.loi.blocks.BlockLog;
import com.axanthic.loi.blocks.BlockLootVase;
import com.axanthic.loi.blocks.BlockMobHead;
import com.axanthic.loi.blocks.BlockMoss;
import com.axanthic.loi.blocks.BlockMushroomGround;
import com.axanthic.loi.blocks.BlockMushroomTree;
import com.axanthic.loi.blocks.BlockIcariaPortal;
import com.axanthic.loi.blocks.BlockKettle;
import com.axanthic.loi.blocks.BlockOre;
import com.axanthic.loi.blocks.BlockPillar;
import com.axanthic.loi.blocks.BlockPillarHead;
import com.axanthic.loi.blocks.BlockPlanks;
import com.axanthic.loi.blocks.BlockRelicstone;
import com.axanthic.loi.blocks.BlockRock;
import com.axanthic.loi.blocks.BlockSapling;
import com.axanthic.loi.blocks.BlockSoil;
import com.axanthic.loi.blocks.BlockSoilGrass;
import com.axanthic.loi.blocks.BlockStorageGem;
import com.axanthic.loi.blocks.BlockStorageMetal;
import com.axanthic.loi.blocks.BlockStorageVase;
import com.axanthic.loi.blocks.BlockTallGrass;
import com.axanthic.loi.blocks.FluidCustom;
import com.axanthic.loi.blocks.BlockPlanks.WoodTypes;
import com.axanthic.loi.items.ItemBlockForge;
import com.axanthic.loi.items.ItemBlockMaterial;
import com.axanthic.loi.items.ItemBlockMaterialDoor;
import com.axanthic.loi.items.ItemBlockMaterialSlab;
import com.axanthic.loi.items.ItemBlockMeta;
import com.axanthic.loi.items.ItemBlockMetaMaterial;
import com.axanthic.loi.items.ItemBlockMobHead;
import com.axanthic.loi.items.ItemCustomArmor;
import com.axanthic.loi.items.ItemDimensionTeleporter;
import com.axanthic.loi.items.ItemFoods;
import com.axanthic.loi.items.ItemGear;
import com.axanthic.loi.items.ItemLaurelWreath;
import com.axanthic.loi.items.ItemMeta;
import com.axanthic.loi.items.ItemMetaMaterial;
import com.axanthic.loi.items.ItemResource;
import com.axanthic.loi.items.ItemResource2;
import com.axanthic.loi.items.ItemSharpBone;
import com.axanthic.loi.items.ToolAxe;
import com.axanthic.loi.items.ToolBident;
import com.axanthic.loi.items.ToolDagger;
import com.axanthic.loi.items.ToolPickaxe;
import com.axanthic.loi.items.ToolScythe;
import com.axanthic.loi.items.ToolShovel;
import com.axanthic.loi.items.ToolSword;
import com.axanthic.loi.proxy.ClientProxy;
import com.axanthic.loi.worldgen.feature.WorldGenCypressTree;
import com.axanthic.loi.worldgen.feature.WorldGenDroughtrootTree;
import com.axanthic.loi.worldgen.feature.WorldGenFirTree;
import com.axanthic.loi.worldgen.feature.WorldGenLOITree;
import com.axanthic.loi.worldgen.feature.WorldGenLaurelTree;
import com.axanthic.loi.worldgen.feature.WorldGenOliveTree;
import com.axanthic.loi.worldgen.feature.WorldGenPlaneTree;
import com.axanthic.loi.worldgen.feature.WorldGenPopulusTree;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidRegistry;

public class Resources {

	public static final SoundType SILENCE = new SoundType(-10.0F, 1.0F, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL);
	public static final SoundType SLICK = new SoundType(1.0F, 1.0F, SoundEvents.BLOCK_GLASS_BREAK, SoundEvents.BLOCK_SLIME_PLACE, SoundEvents.BLOCK_GLASS_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_SLIME_FALL);
	public static final SoundType CERAMIC = new SoundType(1.0F, 1.0F, ClientProxy.CERAMIC_BREAK, SoundEvents.BLOCK_GLASS_STEP, SoundEvents.BLOCK_GLASS_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_GLASS_FALL);

	public static final ResourceLocation LOOT_AETERNAE = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/aeternae"));
	public static final ResourceLocation LOOT_CATOBLEPAS = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/catoblepas"));
	public static final ResourceLocation LOOT_SNULL = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/snull"));
	public static final ResourceLocation LOOT_SOW = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/sow"));
	public static final ResourceLocation LOOT_JELLYFISH = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/jellyfish"));
	public static final ResourceLocation LOOT_REVENANT = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/revenant"));
	public static final ResourceLocation LOOT_ARACHNE_DRONE = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/arachne_drone"));
	public static final ResourceLocation LOOT_ARACHNE = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/arachne"));
	public static final ResourceLocation LOOT_MYRMEKE = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/myrmeke"));
	public static final ResourceLocation LOOT_CERVER = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/cerver"));
	public static final ResourceLocation LOOT_ARGAN_HOUND = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/argan_hound"));
	public static final ResourceLocation LOOT_HAG_PLANE = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/forest_hag/plane"));
	public static final ResourceLocation LOOT_HAG_POPULUS = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/forest_hag/populus"));
	public static final ResourceLocation LOOT_HAG_CYPRESS = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/forest_hag/cypress"));
	public static final ResourceLocation LOOT_HAG_FIR = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/forest_hag/fir"));
	public static final ResourceLocation LOOT_HAG_OLIVE = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/forest_hag/olive"));
	public static final ResourceLocation LOOT_HAG_LAUREL = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/forest_hag/laurel"));
	public static final ResourceLocation LOOT_HAG_DROUGHTROOT = LootTableList.register(new ResourceLocation(ModInformation.ID, "entities/forest_hag/droughtroot"));
	public static final ResourceLocation LOOT_VASE = LootTableList.register(new ResourceLocation(ModInformation.ID, "loot/loot_vase"));

	public static List<Item> items = new ArrayList<Item>();
	public static List<ItemBlock> blocks = new ArrayList<ItemBlock>();

	public static Item dimensionTp = new ItemDimensionTeleporter().setUnlocalizedName("dimension_teleporter").setRegistryName("dimension_teleporter");
	public static ItemMeta resource = new ItemResource();
	public static ItemMeta resource2 = new ItemResource2();
	public static ItemFoods food = new ItemFoods();
	public static ItemMeta gear = new ItemGear();
	public static Item sharpBone = new ItemSharpBone();
	public static Item laurelWreath = new ItemLaurelWreath();
	public static ItemMeta ingot = new ItemMetaMaterial("ingot", BlockStorageMetal.MetalTypes.getNames());
	public static ItemMeta nugget = new ItemMetaMaterial("nugget", BlockStorageMetal.MetalTypes.getNames());

	public static ToolSet chalkos = new ToolSet(new CompleteToolMaterial("chalkos", -1.0F, 1, 174, 5.0F, 1.0F, 15, new ItemStack(Resources.ingot, 1, 0)));
	public static ToolSet kassiteros = new ToolSet(new CompleteToolMaterial("kassiteros", -1.1F, 2, 234, 5.0F, 1.5F, 15, new ItemStack(Resources.ingot, 1, 1)));
	public static ToolSet orichalcum = new ToolSet(new CompleteToolMaterial("orichalcum", -0.8F, 3, 385, 6.0F, 2.0F, 19, new ItemStack(Resources.ingot, 1, 3)));
	public static ToolSet vanadiumsteel = new ToolSet(new CompleteToolMaterial("vanadiumsteel", -1.0F, 3, 424, 4.0F, 3.0F, 11, new ItemStack(Resources.ingot, 1, 6)));
	public static ToolSet sideros = new ToolSet(new CompleteToolMaterial("sideros", -1.1F, 4, 528, 7.0F, 2.5F, 14, new ItemStack(Resources.ingot, 1, 7)));
	public static ToolSet molybdenumsteel = new ToolSet(new CompleteToolMaterial("molybdenumsteel", -1.2F, 5, 673, 7.5F, 2.0F, 12, new ItemStack(Resources.ingot, 1, 9)));

	public static ArmorSet aeternaeLeatherArmor = new ArmorSet(EnumHelper.addArmorMaterial(ModInformation.ID + ":" + "aeternae_leather", ModInformation.ID + ":" + "armor_aeternae_leather", 11, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F).setRepairItem(new ItemStack(Resources.resource, 1, 15)));
	public static ArmorSet chalkosArmor = new ArmorSet(EnumHelper.addArmorMaterial(ModInformation.ID + ":" + "chalkos", ModInformation.ID + ":" + "armor_chalkos", 11, new int[]{1, 3, 4, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F).setRepairItem(new ItemStack(Resources.ingot, 1, 0)));
	public static ArmorSet kassiterosArmor = new ArmorSet(EnumHelper.addArmorMaterial(ModInformation.ID + ":" + "kassiteros", ModInformation.ID + ":" + "armor_kassiteros", 15, new int[]{2, 3, 5, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F).setRepairItem(new ItemStack(Resources.ingot, 1, 1)));
	public static ArmorSet orichalcumArmor = new ArmorSet(EnumHelper.addArmorMaterial(ModInformation.ID + ":" + "orichalcum", ModInformation.ID + ":" + "armor_orichalcum", 24, new int[]{2, 4, 6, 2}, 19, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F).setRepairItem(new ItemStack(Resources.ingot, 1, 3)));
	public static ArmorSet vanadiumArmor = new ArmorSet(EnumHelper.addArmorMaterial(ModInformation.ID + ":" + "vanadiumsteel", ModInformation.ID + ":" + "armor_vanadiumsteel", 27, new int[]{3, 5, 7, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5F).setRepairItem(new ItemStack(Resources.ingot, 1, 6)));

	public static ItemBlockMeta soil = new ItemBlockMeta(new BlockSoil());
	public static ItemBlock grass = new ItemBlock(new BlockSoilGrass());
	public static ItemBlock farmLand = new ItemBlock(new BlockFarmLand());
	public static ItemBlock fertilizedFarmLand = new ItemBlock(new BlockFarmLandFertilized());
	public static ItemBlock moss = new ItemBlock(new BlockMoss());
	public static ItemBlockMeta tallGrass = new ItemBlockMeta(new BlockTallGrass());
	public static ItemBlockMeta flower = new ItemBlockMeta(new BlockFlower());
	public static ItemBlockMeta flower2 = new ItemBlockMeta(new BlockFlower2());
	public static ItemBlockMeta herb = new ItemBlockMeta(new BlockHerb());
	public static ItemBlockMeta bromelia = new ItemBlockMeta(new BlockBromelia());
	public static ItemBlock groundMushroom0 = new ItemBlock(new BlockMushroomGround("0"));
	public static ItemBlock groundMushroom1 = new ItemBlock(new BlockMushroomGround("1"));
	public static ItemBlock groundMushroom2 = new ItemBlock(new BlockMushroomGround("2"));
	public static ItemBlock treeMushroom0 = new ItemBlock(new BlockMushroomTree("0"));
	public static ItemBlock treeMushroom1 = new ItemBlock(new BlockMushroomTree("1"));
	public static ItemBlock treeMushroom2 = new ItemBlock(new BlockMushroomTree("2"));
	public static ItemBlock cardon = new ItemBlock(new BlockCardonCactus());
	public static ItemBlock vineBloomy = new ItemBlock(new BlockBasicVineGrowing("vine_bloomy"));
	public static ItemBlock vineBranch = new ItemBlock(new BlockBasicVineGrowing("vine_branch"));
	public static ItemBlock vineBrushy = new ItemBlock(new BlockBasicVineGrowing("vine_brushy"));
	public static ItemBlock vineDry = new ItemBlock(new BlockBasicVineGrowing("vine_dry"));
	public static ItemBlock vineReedy = new ItemBlock(new BlockBasicVineGrowing("vine_reedy"));
	public static ItemBlock vineSwirly = new ItemBlock(new BlockBasicVineGrowing("vine_swirly"));
	public static ItemBlock vineThorny = new ItemBlock(new BlockBasicVineGrowing("vine_thorny", true));
	public static ItemBlock vineBloomyDead = new ItemBlock(new BlockBasicVineDead("vine_bloomy").setGrowingVine(vineBloomy));
	public static ItemBlock vineBranchDead = new ItemBlock(new BlockBasicVineDead("vine_branch").setGrowingVine(vineBranch));
	public static ItemBlock vineBrushyDead = new ItemBlock(new BlockBasicVineDead("vine_brushy").setGrowingVine(vineBrushy));
	public static ItemBlock vineDryDead = new ItemBlock(new BlockBasicVineDead("vine_dry").setGrowingVine(vineDry));
	public static ItemBlock vineReedyDead = new ItemBlock(new BlockBasicVineDead("vine_reedy").setGrowingVine(vineReedy));
	public static ItemBlock vineSwirlyDead = new ItemBlock(new BlockBasicVineDead("vine_swirly").setGrowingVine(vineSwirly));
	public static ItemBlock vineThornyDead = new ItemBlock(new BlockBasicVineDead("vine_thorny", true).setGrowingVine(vineThorny));
	public static ItemBlockMeta planks = new ItemBlockMetaMaterial(new BlockPlanks());
	public static ItemBlock aristone = new ItemBlock(new BlockAristone("aristone"));
	public static ItemBlock aristonePacked = new ItemBlock(new BlockAristone("aristone_packed"));
	public static ItemBlockMeta rock = new ItemBlockMetaMaterial(new BlockRock("rock"));
	public static ItemBlockMeta brick = new ItemBlockMetaMaterial(new BlockRock("bricks"));
	public static ItemBlockMeta ore = new ItemBlockMetaMaterial(new BlockOre());
	public static ItemBlock silkstoneSand = new ItemBlock(new BlockGravity(Material.SAND, 1.2F, "silkstone_sand", MapColor.PINK_STAINED_HARDENED_CLAY).setSoundType(SoundType.SAND));
	public static ItemBlock grainelSand = new ItemBlock(new BlockGravity(Material.SAND, 1.2F, "grainel_sand", MapColor.WOOD).setSoundType(SoundType.SAND));
	public static ItemBlockMeta grainelStone = new ItemBlockMeta(new BlockGrainelStone());
	public static ItemBlock grainelGlass = new ItemBlock(new BlockGlassy(Material.GLASS, 0.3F, "grainel_glass", MapColor.WOOD));
	public static ItemBlock grainelGlassPane = new ItemBlock(new BlockCustomPane(Material.GLASS, 0.3F, "grainel_pane", false).setSoundType(SoundType.GLASS));
	public static ItemBlock loamBricks = new ItemBlock(new BlockBasic(Material.ROCK, 1.2F, "loam_bricks", MapColor.NETHERRACK).setSoundType(SoundType.STONE));
	public static ItemBlock dolomiteSmooth = new ItemBlock(new BlockBasic(Material.ROCK, 1.2F, "dolomite_smooth", MapColor.WHITE_STAINED_HARDENED_CLAY).setSoundType(SoundType.STONE));
	public static ItemBlock dolomiteBricks = new ItemBlock(new BlockBasic(Material.ROCK, 1.2F, "dolomite_bricks", MapColor.WHITE_STAINED_HARDENED_CLAY).setSoundType(SoundType.STONE));
	public static ItemBlock dolomitePillar = new ItemBlock(new BlockPillar(Material.ROCK, 1.2F, "dolomite_pillar", MapColor.WHITE_STAINED_HARDENED_CLAY).setSoundType(SoundType.STONE));
	public static ItemBlock dolomitePillarHead = new ItemBlock(new BlockPillarHead(Material.ROCK, 1.2F, "dolomite_pillar_head", MapColor.WHITE_STAINED_HARDENED_CLAY).setSoundType(SoundType.STONE));
	public static ItemBlock quartzPillarHead = new ItemBlock(new BlockPillarHead(Material.ROCK, 0.8F, "quartz_pillar_head", MapColor.QUARTZ).setSoundType(SoundType.STONE));
	public static ItemBlock calcite = new ItemBlock(new BlockGem("calcite"));
	public static ItemBlock jasper = new ItemBlock(new BlockGem("jasper"));
	public static ItemBlock zircon = new ItemBlock(new BlockGem("zircon"));
	public static ItemBlockMeta metalBlock = new ItemBlockMetaMaterial(new BlockStorageMetal());
	public static ItemBlockMeta gemBlock = new ItemBlockMetaMaterial(new BlockStorageGem());
	public static ItemBlockMeta relicstone = new ItemBlockMeta(new BlockRelicstone());
	public static ItemBlock pillar = new ItemBlock(new BlockPillar(Material.ROCK, 1.2F, "pillar_relicstone", MapColor.WOOD).setSoundType(SoundType.STONE));
	public static ItemBlock pillarHead = new ItemBlock(new BlockPillarHead(Material.ROCK, 1.2F, "pillar_head_relicstone", MapColor.WOOD).setSoundType(SoundType.STONE));
	public static ItemBlock mobHeadRevenant = new ItemBlockMobHead(new BlockMobHead("revenant"));
	public static ItemBlock mobHeadArachne = new ItemBlockMobHead(new BlockMobHead("arachne"));
	public static ItemBlock mobHeadArachneDrone = new ItemBlockMobHead(new BlockMobHead("arachne_drone"));
	public static ItemBlock mobHeadMyrmeke = new ItemBlockMobHead(new BlockMobHead("myrmeke"));
	public static ItemBlock mobHeadCerver = new ItemBlockMobHead(new BlockMobHead("cerver"));
	public static ItemBlock mobHeadArganHound = new ItemBlockMobHead(new BlockMobHead("argan_hound"));
	public static ItemBlock mobHeadForesthagPlane = new ItemBlockMobHead(new BlockMobHead("foresthag_plane"));
	public static ItemBlock mobHeadForesthagPopulus = new ItemBlockMobHead(new BlockMobHead("foresthag_populus"));
	public static ItemBlock mobHeadForesthagCypress = new ItemBlockMobHead(new BlockMobHead("foresthag_cypress"));
	public static ItemBlock mobHeadForesthagFir = new ItemBlockMobHead(new BlockMobHead("foresthag_fir"));
	public static ItemBlock mobHeadForesthagOlive = new ItemBlockMobHead(new BlockMobHead("foresthag_olive"));
	public static ItemBlock mobHeadForesthagLaurel = new ItemBlockMobHead(new BlockMobHead("foresthag_laurel"));
	public static ItemBlock mobHeadForesthagDroughtroot = new ItemBlockMobHead(new BlockMobHead("foresthag_droughtroot"));
	public static ItemBlock mobHeadAeternae = new ItemBlockMobHead(new BlockMobHead("aeternae"));
	public static ItemBlock mobHeadCatoblepas = new ItemBlockMobHead(new BlockMobHead("catoblepas"));
	public static ItemBlock mobHeadSow = new ItemBlockMobHead(new BlockMobHead("sow"));
	public static ItemBlock lootVase = new ItemBlock(new BlockLootVase());
	public static ItemBlock storageVase = new ItemBlock(new BlockStorageVase());
	public static ItemBlock kiln = new ItemBlock(new BlockKiln());
	public static ItemBlock grinder = new ItemBlock(new BlockGrinder());
	public static ItemBlock forge = new ItemBlockForge(new BlockForge());
	public static ItemBlock kettle = new ItemBlock(new BlockKettle());
	public static ItemBlock portal = new ItemBlock(new BlockIcariaPortal());

	public static final FluidCustom waterFluid = (FluidCustom) new FluidCustom("mediterranean_water", new ResourceLocation(ModInformation.ID,"blocks/fluid_mediterranean_water_still"), new ResourceLocation(ModInformation.ID, "blocks/fluid_mediterranean_water_flow")).setMaterial(Material.WATER).setDensity(1100).setGaseous(false).setViscosity(1000).setTemperature(300).setColor(0xFF51A18B);
	public static ItemBlock waterFluidBlock;

	public static final FluidCustom gasFluid = (FluidCustom) new FluidCustom("gas", new ResourceLocation(ModInformation.ID,"blocks/fluid_upwards_still"), new ResourceLocation(ModInformation.ID, "blocks/fluid_upwards_flow")).setMaterial(Material.WATER).setDensity(-1000).setGaseous(false).setLuminosity(15).setViscosity(1000).setTemperature(1300).setColor(0xFFF3BF61);
	public static ItemBlock gasFluidBlock;

	public static StairSlabPair yellowstoneStone = new StairSlabPair(rock, 0, "yellowstone", true);
	public static StairSlabPair silkstoneStone = new StairSlabPair(rock, 1, "silkstone", true);
	public static StairSlabPair sunstoneStone = new StairSlabPair(rock, 2, "sunstone", true);
	public static StairSlabPair voidshaleStone = new StairSlabPair(rock, 3, "voidshale", true);
	public static StairSlabPair baetylStone = new StairSlabPair(rock, 4, "baetyl", true);
	public static StairSlabPair relicstoneStone = new StairSlabPair(rock, 5, "relicstone", true);

	public static StairSlabPair yellowstoneBrick = new StairSlabPair(brick, 0, "yellowstone_bricks", true);
	public static StairSlabPair silkstoneBrick = new StairSlabPair(brick, 1, "silkstone_bricks", true);
	public static StairSlabPair sunstoneBrick = new StairSlabPair(brick, 2, "sunstone_bricks", true);
	public static StairSlabPair voidshaleBrick = new StairSlabPair(brick, 3, "voidshale_bricks", true);
	public static StairSlabPair baetylBrick = new StairSlabPair(brick, 4, "baetyl_bricks", true);
	public static StairSlabPair relicstoneBrick = new StairSlabPair(brick, 5, "relicstone_bricks", true);

	public static StairSlabPair relicstoneSmooth = new StairSlabPair(relicstone, 0, "relicstone_smooth", true);
	public static StairSlabPair relicstoneCrackBrick = new StairSlabPair(relicstone, 1, "relicstone_bricks_cracked", true);
	public static StairSlabPair relicstoneMossBrick = new StairSlabPair(relicstone, 2, "relicstone_bricks_mossy", true);
	public static StairSlabPair relicstoneDraftBrick = new StairSlabPair(relicstone, 3, "relicstone_bricks_draft", true);
	public static StairSlabPair relicstoneTile = new StairSlabPair(relicstone, 4, "relicstone_tile");
	public static StairSlabPair relicstoneCrackTile = new StairSlabPair(relicstone, 5, "relicstone_tile_cracked");
	public static StairSlabPair relicstoneMossTile = new StairSlabPair(relicstone, 6, "relicstone_tile_mossy");
	public static StairSlabPair relicstoneDraftTile = new StairSlabPair(relicstone, 7, "relicstone_tile_draft");

	public static StairSlabPair grainiteStone = new StairSlabPair(grainelStone, 0, "grainel_stone", true);
	public static StairSlabPair grainiteBricks = new StairSlabPair(grainelStone, 1, "grainel_stone_bricks", true);
	public static StairSlabPair loamBrick = new StairSlabPair(loamBricks, 0, "loam_bricks", true);
	public static StairSlabPair smoothDolomite = new StairSlabPair(dolomiteSmooth, 0, "dolomite_smooth");

	public static WoodSet plane = new WoodSet(BlockPlanks.WoodTypes.PLANE, new WorldGenPlaneTree(true));
	public static WoodSet populus = new WoodSet(BlockPlanks.WoodTypes.POPULUS, new WorldGenPopulusTree(true));
	public static WoodSet cypress = new WoodSet(BlockPlanks.WoodTypes.CYPRESS, new WorldGenCypressTree(true));
	public static WoodSet fir = new WoodSet(BlockPlanks.WoodTypes.FIR, new WorldGenFirTree(true));
	public static WoodSet olive = new WoodSet(BlockPlanks.WoodTypes.OLIVE, new WorldGenOliveTree(true));
	public static ItemBlockMeta oliveLeaves = new ItemBlockMeta(new BlockLeafOlives(BlockPlanks.WoodTypes.OLIVE));
	public static WoodSet laurel = new WoodSet(BlockPlanks.WoodTypes.LAUREL, new WorldGenLaurelTree(true));
	public static WoodSet droughtroot = new WoodSet(BlockPlanks.WoodTypes.DROUGHTROOT, new WorldGenDroughtrootTree(true));

	public static void registerItems() {
		Resources.items.add(Resources.dimensionTp);
		Resources.items.add(Resources.resource);
		Resources.items.add(Resources.resource2);
		Resources.items.add(Resources.food);
		Resources.items.add(Resources.gear);
		Resources.items.add(Resources.sharpBone);
		Resources.items.add(Resources.laurelWreath);
		Resources.items.add(Resources.ingot);
		Resources.items.add(Resources.nugget);

		Resources.chalkos.register();
		Resources.kassiteros.register();
		Resources.orichalcum.register();
		Resources.vanadiumsteel.register();
		Resources.sideros.register();
		Resources.molybdenumsteel.register();

		Resources.aeternaeLeatherArmor.register();
		Resources.chalkosArmor.register();
		Resources.kassiterosArmor.register();
		Resources.orichalcumArmor.register();
		Resources.vanadiumArmor.register();
	}

	public static void registerBlocks() {
		Resources.registerBlock(Resources.soil);
		Resources.registerBlock(Resources.grass);
		Resources.registerBlock(Resources.farmLand);
		Resources.registerBlock(Resources.fertilizedFarmLand);
		Resources.registerBlock(Resources.moss);
		Resources.registerBlock(Resources.tallGrass);
		Resources.registerBlock(Resources.flower);
		Resources.registerBlock(Resources.flower2);
		Resources.registerBlock(Resources.herb);
		Resources.registerBlock(Resources.bromelia);
		Resources.registerBlock(Resources.groundMushroom0);
		Resources.registerBlock(Resources.groundMushroom1);
		Resources.registerBlock(Resources.groundMushroom2);
		Resources.registerBlock(Resources.treeMushroom0);
		Resources.registerBlock(Resources.treeMushroom1);
		Resources.registerBlock(Resources.treeMushroom2);
		Resources.registerBlock(Resources.cardon);
		Resources.registerBlock(Resources.vineBloomy);
		Resources.registerBlock(Resources.vineBranch);
		Resources.registerBlock(Resources.vineBrushy);
		Resources.registerBlock(Resources.vineDry);
		Resources.registerBlock(Resources.vineReedy);
		Resources.registerBlock(Resources.vineSwirly);
		Resources.registerBlock(Resources.vineThorny);
		Resources.registerBlock(Resources.vineBloomyDead);
		Resources.registerBlock(Resources.vineBranchDead);
		Resources.registerBlock(Resources.vineBrushyDead);
		Resources.registerBlock(Resources.vineDryDead);
		Resources.registerBlock(Resources.vineReedyDead);
		Resources.registerBlock(Resources.vineSwirlyDead);
		Resources.registerBlock(Resources.vineThornyDead);
		Resources.registerBlock(Resources.planks);
		Resources.registerBlock(Resources.aristone);
		Resources.registerBlock(Resources.aristonePacked);
		Resources.registerBlock(Resources.rock);
		Resources.registerBlock(Resources.brick);
		Resources.registerBlock(Resources.ore);
		Resources.registerBlock(Resources.silkstoneSand);
		Resources.registerBlock(Resources.grainelSand);
		Resources.registerBlock(Resources.grainelStone);
		Resources.registerBlock(Resources.grainelGlass);
		Resources.registerBlock(Resources.grainelGlassPane);
		Resources.registerBlock(Resources.loamBricks);
		Resources.registerBlock(Resources.dolomiteSmooth);
		Resources.registerBlock(Resources.dolomiteBricks);
		Resources.registerBlock(Resources.dolomitePillar);
		Resources.registerBlock(Resources.dolomitePillarHead);
		Resources.registerBlock(Resources.quartzPillarHead);
		Resources.registerBlock(Resources.calcite);
		Resources.registerBlock(Resources.jasper);
		Resources.registerBlock(Resources.zircon);
		Resources.registerBlock(Resources.metalBlock);
		Resources.registerBlock(Resources.gemBlock);
		Resources.registerBlock(Resources.relicstone);
		Resources.registerBlock(Resources.pillar);
		Resources.registerBlock(Resources.pillarHead);
		Resources.registerBlock(Resources.mobHeadRevenant);
		Resources.registerBlock(Resources.mobHeadArachne);
		Resources.registerBlock(Resources.mobHeadArachneDrone);
		Resources.registerBlock(Resources.mobHeadMyrmeke);
		Resources.registerBlock(Resources.mobHeadCerver);
		Resources.registerBlock(Resources.mobHeadArganHound);
		Resources.registerBlock(Resources.mobHeadForesthagPlane);
		Resources.registerBlock(Resources.mobHeadForesthagPopulus);
		Resources.registerBlock(Resources.mobHeadForesthagCypress);
		Resources.registerBlock(Resources.mobHeadForesthagFir);
		Resources.registerBlock(Resources.mobHeadForesthagOlive);
		Resources.registerBlock(Resources.mobHeadForesthagLaurel);
		Resources.registerBlock(Resources.mobHeadForesthagDroughtroot);
		Resources.registerBlock(Resources.mobHeadAeternae);
		Resources.registerBlock(Resources.mobHeadCatoblepas);
		Resources.registerBlock(Resources.mobHeadSow);
		Resources.registerBlock(Resources.lootVase);
		Resources.registerBlock(Resources.storageVase);
		Resources.registerBlock(Resources.kiln);
		Resources.registerBlock(Resources.grinder);
		Resources.registerBlock(Resources.forge);
		Resources.registerBlock(Resources.kettle);
		Resources.registerBlock(Resources.portal);

		FluidRegistry.registerFluid(waterFluid);
		FluidRegistry.addBucketForFluid(waterFluid);
		waterFluidBlock = new ItemBlock(new BlockFluidCustom(waterFluid, Material.WATER).canCreateSources(true));
		waterFluid.setBlock(waterFluidBlock.getBlock());
		Resources.registerBlock(waterFluidBlock);

		FluidRegistry.registerFluid(gasFluid);
		FluidRegistry.addBucketForFluid(gasFluid);
		gasFluidBlock = new ItemBlock(new BlockFluidUpwards(gasFluid, Material.WATER));
		gasFluid.setBlock(gasFluidBlock.getBlock());
		Resources.registerBlock(gasFluidBlock);

		Resources.plane.register();
		Resources.populus.register();
		Resources.cypress.register();
		Resources.fir.register();
		Resources.olive.register();
		Resources.registerBlock(Resources.oliveLeaves);
		((BlockSapling) Resources.olive.sapling.getBlock()).generator.init();
		Resources.laurel.register();
		Resources.droughtroot.register();

		Resources.yellowstoneStone.register();
		Resources.silkstoneStone.register();
		Resources.sunstoneStone.register();
		Resources.voidshaleStone.register();
		Resources.baetylStone.register();
		Resources.relicstoneStone.register();

		Resources.yellowstoneBrick.register();
		Resources.silkstoneBrick.register();
		Resources.sunstoneBrick.register();
		Resources.voidshaleBrick.register();
		Resources.baetylBrick.register();
		Resources.relicstoneBrick.register();

		Resources.relicstoneSmooth.register();
		Resources.relicstoneCrackBrick.register();
		Resources.relicstoneMossBrick.register();
		Resources.relicstoneDraftBrick.register();
		Resources.relicstoneTile.register();
		Resources.relicstoneCrackTile.register();
		Resources.relicstoneMossTile.register();
		Resources.relicstoneDraftTile.register();

		Resources.grainiteStone.register();
		Resources.grainiteBricks.register();
		Resources.loamBrick.register();
		Resources.smoothDolomite.register();
	}

	public static void registerBlock(final ItemBlock block) {
		Resources.blocks.add((ItemBlock) block.setRegistryName(block.getBlock().getRegistryName()));
	}

	public static class CompleteToolMaterial {

		public ToolMaterial material;
		public float attackSpeed;

		public CompleteToolMaterial(final String name, final float attackSpeed, final int harvestLevel, final int maxUses, final float efficiency, final float damage, final int enchantability, final ItemStack repair) {
			this.material = EnumHelper.addToolMaterial(ModInformation.ID + ":" + name, harvestLevel, maxUses, efficiency, damage, enchantability).setRepairItem(repair);
			this.attackSpeed = attackSpeed;
		}
	}

	public static class ToolSet {

		public ToolAxe axe;
		public ToolPickaxe pickaxe;
		public ToolShovel shovel;
		public ToolSword sword;
		public ToolDagger dagger;
		public ToolBident bident;
		public ToolScythe scythe;

		public ToolSet(final CompleteToolMaterial material) {
			this.axe = new ToolAxe(material);
			this.pickaxe = new ToolPickaxe(material);
			this.shovel = new ToolShovel(material);
			this.sword = new ToolSword(material);
			this.dagger = new ToolDagger(material);
			this.bident = new ToolBident(material);
			this.scythe = new ToolScythe(material);
		}

		public void register() {
			Resources.items.add(this.axe);
			Resources.items.add(this.pickaxe);
			Resources.items.add(this.shovel);
			Resources.items.add(this.sword);
			Resources.items.add(this.dagger);
			Resources.items.add(this.bident);
			Resources.items.add(this.scythe);
		}
	}

	public static class ArmorSet {

		public ItemArmor.ArmorMaterial material;
		public Item helmet;
		public Item chestplate;
		public Item leggings;
		public Item boots;

		public ArmorSet(final ItemArmor.ArmorMaterial material) {
			this.material = material;
			this.helmet = new ItemCustomArmor(material, EntityEquipmentSlot.HEAD);
			this.chestplate = new ItemCustomArmor(material, EntityEquipmentSlot.CHEST);
			this.leggings = new ItemCustomArmor(material, EntityEquipmentSlot.LEGS);
			this.boots = new ItemCustomArmor(material, EntityEquipmentSlot.FEET);
		}

		public void register() {
			Resources.items.add(this.helmet);
			Resources.items.add(this.chestplate);
			Resources.items.add(this.leggings);
			Resources.items.add(this.boots);
		}
	}

	public static class StairSlabPair {

		public Item baseItem;
		public int baseMeta;
		public String name;
		public ItemBlockMaterialSlab slab;
		public ItemBlockMaterial stairs;
		public ItemBlockMaterial wall = null;

		public StairSlabPair(ItemBlock baseBlock, int meta, String name) {
			this.baseItem = baseBlock;
			this.baseMeta = meta;
			this.name = name;
			IBlockState baseState = baseBlock.getBlock().getStateFromMeta(meta);
			this.slab = new ItemBlockMaterialSlab(new BlockCustomSlab(baseState, null));
			this.stairs = new ItemBlockMaterial(new BlockCustomStairs(baseState, null));
		}

		public StairSlabPair(ItemBlock baseBlock, int meta, String name, boolean wall) {
			this(baseBlock, meta, name);
			if(wall) {
				IBlockState baseState = baseBlock.getBlock().getStateFromMeta(meta);
				this.wall = new ItemBlockMaterial(new BlockCustomWall(baseState, null));
			}
		}

		public void register() {
			Resources.registerBlock(slab);
			Resources.registerBlock(stairs);
			if (wall != null)
				Resources.registerBlock(wall);
		}
	}

	public static class WoodSet {

		public BlockPlanks.WoodTypes type;
		public ItemBlockMaterial log;
		public ItemBlockMaterial strippedLog;
		public ItemBlockMaterial sapling;
		public ItemBlockMaterial leaf;
		public ItemBlockMaterial fence;
		public ItemBlockMaterial fenceGate;
		public ItemBlockMaterialSlab slab;
		public ItemBlockMaterial stairs;
		public ItemBlockMaterialDoor door;
		public ItemBlockMaterial trapdoor;
		public ItemBlockMaterial workbench;
		public ResourceLocation hagLoot;

		public WoodSet(final BlockPlanks.WoodTypes type, WorldGenLOITree generator) {
			this.type = type;
			this.strippedLog = new ItemBlockMaterial(new BlockLog(type, type.mapColor, null));
			this.log = new ItemBlockMaterial(new BlockLog(type, type.logColor, strippedLog));
			this.leaf = new ItemBlockMaterial(new BlockLeaf(type));
			generator.TRUNK = this.log.getBlock().getDefaultState();
			generator.LEAF = this.leaf.getBlock().getDefaultState();
			this.sapling = new ItemBlockMaterial(new BlockSapling(type, generator));
			((BlockLeaf) this.leaf.getBlock()).sapling = this.sapling;
			IBlockState plankState = Resources.planks.getBlock().getDefaultState().withProperty(BlockPlanks.TYPES, type);
			String materialName = "material." + type.unlocalizedName + ".name";
			this.fence = new ItemBlockMaterial(new BlockCustomFence(plankState, materialName));
			this.fenceGate = new ItemBlockMaterial(new BlockCustomFenceGate(plankState, materialName));
			this.slab = new ItemBlockMaterialSlab(new BlockCustomSlab(plankState, materialName));
			this.stairs = new ItemBlockMaterial(new BlockCustomStairs(plankState, materialName));
			this.door = new ItemBlockMaterialDoor(new BlockCustomDoor(plankState, materialName));
			this.trapdoor = new ItemBlockMaterial(new BlockCustomTrapdoor(plankState, materialName));
			this.workbench = new ItemBlockMaterial(new BlockCustomWorkbench(plankState, materialName));
			this.hagLoot = new ResourceLocation(ModInformation.ID, "entities/forest_hag/" + type.unlocalizedName);
		}

		public void register() {
			Resources.registerBlock(log);
			Resources.registerBlock(strippedLog);
			Resources.registerBlock(sapling);
			Resources.registerBlock(leaf);
			Resources.registerBlock(fence);
			Resources.registerBlock(fenceGate);
			Resources.registerBlock(slab);
			Resources.registerBlock(stairs);
			Resources.registerBlock(door);
			Resources.registerBlock(trapdoor);
			Resources.registerBlock(workbench);
		}
	}

	public static WoodSet getWoodSetFromType(BlockPlanks.WoodTypes type) {
		if (type == WoodTypes.PLANE)
			return Resources.plane;
		if (type == WoodTypes.POPULUS)
			return Resources.populus;
		if (type == WoodTypes.CYPRESS)
			return Resources.cypress;
		if (type == WoodTypes.FIR)
			return Resources.fir;
		if (type == WoodTypes.OLIVE)
			return Resources.olive;
		if (type == WoodTypes.LAUREL)
			return Resources.laurel;
		if (type == WoodTypes.DROUGHTROOT)
			return Resources.droughtroot;
		return Resources.plane;
	}
}
