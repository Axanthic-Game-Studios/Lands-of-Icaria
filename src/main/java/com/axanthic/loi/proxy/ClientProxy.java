package com.axanthic.loi.proxy;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.axanthic.loi.LOIConfig;
import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.blocks.BlockCustomWorkbench;
import com.axanthic.loi.blocks.BlockFlower;
import com.axanthic.loi.blocks.BlockFluidCustom;
import com.axanthic.loi.blocks.BlockHerb;
import com.axanthic.loi.blocks.BlockLeaf;
import com.axanthic.loi.blocks.BlockLeafOlives;
import com.axanthic.loi.blocks.BlockLog;
import com.axanthic.loi.blocks.BlockSapling;
import com.axanthic.loi.blocks.BlockTallGrass;
import com.axanthic.loi.blocks.IBlockMeta;
import com.axanthic.loi.entity.*;
import com.axanthic.loi.gui.GuiStatIndicator;
import com.axanthic.loi.items.IItemCustomReach;
import com.axanthic.loi.items.IItemMeta;
import com.axanthic.loi.items.ItemBlockMeta;
import com.axanthic.loi.items.ItemBlockMobHead;
import com.axanthic.loi.items.ItemConcoctionFlask;
import com.axanthic.loi.items.ItemCustomArmor;
import com.axanthic.loi.items.ItemScroll;
import com.axanthic.loi.items.ItemSpell;
import com.axanthic.loi.render.*;
import com.axanthic.loi.tileentity.TESignCypress;
import com.axanthic.loi.tileentity.TESignDroughtroot;
import com.axanthic.loi.tileentity.TESignFir;
import com.axanthic.loi.tileentity.TESignLaurel;
import com.axanthic.loi.tileentity.TESignOlive;
import com.axanthic.loi.tileentity.TESignPlane;
import com.axanthic.loi.tileentity.TESignPopulus;
import com.axanthic.loi.tileentity.TESRSignCypress;
import com.axanthic.loi.tileentity.TESRSignDroughtroot;
import com.axanthic.loi.tileentity.TESRSignFir;
import com.axanthic.loi.tileentity.TESRSignLaurel;
import com.axanthic.loi.tileentity.TESRSignOlive;
import com.axanthic.loi.tileentity.TESRSignPlane;
import com.axanthic.loi.tileentity.TESRSignPopulus;
import com.axanthic.loi.tileentity.TileEntityColoredLight;
import com.axanthic.loi.tileentity.TileEntityGrinder;
import com.axanthic.loi.tileentity.TileEntityIcariaChest;
import com.axanthic.loi.tileentity.TileEntityKettle;
import com.axanthic.loi.tileentity.TileEntityMobHead;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererColoredLight;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererGrinder;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererIcariaChest;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererKettle;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererMobHead;
import com.axanthic.loi.utils.IcariaSounds;
import com.axanthic.loi.utils.LOIItemStackRenderer;
import com.axanthic.loi.utils.MessageCustomReachAttack;
import com.axanthic.loi.utils.VanillaHandler;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;

import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

	public static Map<String, String[]> emissiveTextures = new HashMap<String, String[]>();
	public static ModelManager modelManager;
	public static ModelBiped orichalcumModel = new ModelArmorOrichalcum();
	public static IRenderHandler skyRenderer = new IcariaSkyRenderer();

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new VanillaHandler());

		RenderingRegistry.registerEntityRenderingHandler(EntityBident.class, RenderBident::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFallingVase.class, RenderFallingBlock::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, RenderGrenade::new);
		RenderingRegistry.registerEntityRenderingHandler(EntitySpellWisp.class, RenderSpellWisp::new);
		RenderingRegistry.registerEntityRenderingHandler(EntitySpellBubble.class, RenderSpellBubble::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFloatingBlock.class, RenderFallingBlock::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityAeternae.class, RenderAeternae::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityCatoblepas.class, RenderCatoblepas::new);
		RenderingRegistry.registerEntityRenderingHandler(EntitySnull.class, RenderSnull::new);
		RenderingRegistry.registerEntityRenderingHandler(EntitySow.class, RenderSow::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, RenderJellyfish::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityLight.class, RenderLight::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityForestHagPlane.class, RenderForestHagPlane::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityForestHagPopulus.class, RenderForestHagPopulus::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityForestHagCypress.class, RenderForestHagCypress::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityForestHagFir.class, RenderForestHagFir::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityForestHagOlive.class, RenderForestHagOlive::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityForestHagLaurel.class, RenderForestHagLaurel::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityForestHagDroughtroot.class, RenderForestHagDroughtroot::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityArachneDrone.class, RenderArachneDrone::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityArachne.class, RenderArachne::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityMyrmeke.class, RenderMyrmeke::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityCerver.class, RenderCerver::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityArganHound.class, RenderArganHound::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRevenantCivilian.class, RenderRevenantCivilian::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRevenantSoldier.class, RenderRevenantSoldier::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRevenantCaptain.class, RenderRevenantCaptain::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRevenantPyromancer.class, RenderRevenantPyromancer::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRevenantPyromancerNether.class, RenderRevenantPyromancerNether::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRevenantCrawler.class, RenderRevenantCrawler::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRevenantOvergrown.class, RenderRevenantOvergrown::new);
		RenderingRegistry.registerEntityRenderingHandler(EntitySiren.class, RenderSiren::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class, RenderScorpion::new);
		RenderingRegistry.registerEntityRenderingHandler(EntitySolifugae.class, RenderSolifugae::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityVinegaroon.class, RenderVinegaroon::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityVinegar.class, RenderVinegar::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityWhipSpider.class, RenderWhipSpider::new);

		emissiveTextures.put("calcite", new String[]{ ModInformation.ID + ":blocks/gem_calcite_model" });
		emissiveTextures.put("halite", new String[]{ ModInformation.ID + ":blocks/gem_halite_model" });
		emissiveTextures.put("jasper", new String[]{ ModInformation.ID + ":blocks/gem_jasper_model" });
		emissiveTextures.put("zircon", new String[]{ ModInformation.ID + ":blocks/gem_zircon_model" });
		emissiveTextures.put("block_gem", new String[]{ ModInformation.ID + ":blocks/mineral_calcite_block", ModInformation.ID + ":blocks/mineral_halite_block", ModInformation.ID + ":blocks/mineral_jasper_block", ModInformation.ID + ":blocks/mineral_zircon_block" });
		emissiveTextures.put("block_metal", new String[]{ ModInformation.ID + ":blocks/metal_bluridium_block" });
		emissiveTextures.put("ore", new String[]{ ModInformation.ID + ":blocks/rock_baetyl_ore_bluridium_overlay" });
		emissiveTextures.put("icaria_portal", new String[]{ ModInformation.ID + ":blocks/icaria_portal" });
		//emissiveTextures.put("crafting_forge", new String[]{ ModInformation.ID + ":blocks/crafting_forge_fire" });
		//emissiveTextures.put("crafting_kiln", new String[]{ ModInformation.ID + ":blocks/crafting_kiln_fire" });

		LOIItemStackRenderer.LOIInstance = new LOIItemStackRenderer();
		if (LOIConfig.hud.indicatorEnabled)
			MinecraftForge.EVENT_BUS.register(new GuiStatIndicator());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrinder.class, new TileEntitySpecialRendererGrinder());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKettle.class, new TileEntitySpecialRendererKettle());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHead.class, new TileEntitySpecialRendererMobHead());

		//signs
		ClientRegistry.bindTileEntitySpecialRenderer(TESignPlane.class, new TESRSignPlane());
		ClientRegistry.bindTileEntitySpecialRenderer(TESignPopulus.class, new TESRSignPopulus());
		ClientRegistry.bindTileEntitySpecialRenderer(TESignCypress.class, new TESRSignCypress());
		ClientRegistry.bindTileEntitySpecialRenderer(TESignFir.class, new TESRSignFir());
		ClientRegistry.bindTileEntitySpecialRenderer(TESignOlive.class, new TESRSignOlive());
		ClientRegistry.bindTileEntitySpecialRenderer(TESignLaurel.class, new TESRSignLaurel());
		ClientRegistry.bindTileEntitySpecialRenderer(TESignDroughtroot.class, new TESRSignDroughtroot());

		//chests
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIcariaChest.class, new TileEntitySpecialRendererIcariaChest());

		if (LOIConfig.render.lights)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityColoredLight.class, new TileEntitySpecialRendererColoredLight());
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event) {
		for (ItemBlock block : Resources.blocks) {
			if (block.getBlock() instanceof BlockFlower || block.getBlock() instanceof BlockTallGrass || block.getBlock() instanceof BlockHerb) {
				for (int i = 0; i < ((IBlockMeta) block.getBlock()).getNames().length; i++) {
					ModelLoader.setCustomModelResourceLocation(block, i, new ModelResourceLocation(block.getRegistryName() + "_inv", "type=" + ((IBlockMeta) block.getBlock()).getNames()[i]));
				}
			} else if (block.getBlock() instanceof BlockLeafOlives) { //olive leaves are weird
				ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(block.getRegistryName(), "check_decay=false,decayable=false,type=" + ((IBlockMeta) block.getBlock()).getNameForMeta(0)));
				ModelLoader.setCustomModelResourceLocation(block, 1, new ModelResourceLocation(block.getRegistryName(), "check_decay=false,decayable=false,type=" + ((IBlockMeta) block.getBlock()).getNameForMeta(1)));
			}  else if (block instanceof ItemBlockMeta) {
				ModelLoader.setCustomMeshDefinition(block, new ItemMeshDefinition() {
					@Override
					public ModelResourceLocation getModelLocation(ItemStack stack) {
						return new ModelResourceLocation(block.getRegistryName(), "type=" + ((IBlockMeta) block.getBlock()).getNameForMeta(stack.getMetadata()));
					}});
			} else if (block.getBlock() instanceof BlockLeaf || block.getBlock() instanceof BlockSapling || block.getBlock() instanceof BlockCustomWorkbench) {
				String[] path = block.getRegistryName().getResourcePath().split("_");
				if (block.getBlock() instanceof BlockSapling)
					ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]), "inv_" + path[0]));
				else
					ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]), path[0]));
				ModelLoader.setCustomStateMapper(block.getBlock(), new StateMapperBase() {
					@Override
					public ModelResourceLocation getModelResourceLocation(IBlockState state) {
						return new ModelResourceLocation(new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]), path[0]);
					}});
			} else if (block.getBlock() instanceof BlockLog) {
				String[] path = block.getRegistryName().getResourcePath().split("_");
				ResourceLocation loc = new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]);
				ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(loc, path[0] + "_y"));
				ModelLoader.setCustomStateMapper(block.getBlock(), new StateMapperBase() {
					@Override
					public ModelResourceLocation getModelResourceLocation(IBlockState state) {
						String axis = "bark";
						int meta = ((BlockLog) block.getBlock()).getMetaFromState(state);
						if (meta == 0) {
							axis = "y";
						} else if (meta == 4) {
							axis = "x";
						} else if (meta == 8) {
							axis = "z";
						}
						return new ModelResourceLocation(loc, path[0] + "_" + axis);
					}});
			}  else if (block.getBlock() instanceof BlockFluidCustom) {
				ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(block.getRegistryName(), "normal"));
				ModelLoader.setCustomStateMapper(block.getBlock(), new StateMapperBase() {
					@Override
					public ModelResourceLocation getModelResourceLocation(IBlockState state) {
						return new ModelResourceLocation(block.getRegistryName(), "normal");
					}});
			} else
				ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}

		for (Item item : Resources.items) {
			if (item instanceof IItemMeta) {
				for (int i = 0; i < ((IItemMeta) item).getNames().length; i++) {
					ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), "type=" + ((IItemMeta) item).getNames()[i]));
				}
			} else if (item instanceof ItemTool || item instanceof ItemSword || item instanceof ItemCustomArmor) {
				String[] path = item.getRegistryName().getResourcePath().split("_");
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), "tool_" + path[1]), path[0]));
			} else if (item instanceof ItemSpell) {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), "spell"), ((ItemSpell) item).getName()));
			} else if (item instanceof ItemScroll) {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), "spell_scroll"), ((ItemScroll) item).getName()));
			} else if (item instanceof ItemConcoctionFlask) {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), "concoction_flask_filled"), "inventory"));
			} else
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}

		//register special item renderers here
		Resources.saltedFood.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.grinder.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadRevenant.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadArachne.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadArachneDrone.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadMyrmeke.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadCerver.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadArganHound.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadForesthagPlane.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadForesthagPopulus.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadForesthagCypress.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadForesthagFir.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadForesthagOlive.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadForesthagLaurel.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadForesthagDroughtroot.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadAeternae.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadCatoblepas.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.mobHeadSow.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		for (ItemScroll scroll : Resources.scrolls)
			scroll.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
	}

	@SubscribeEvent
	public void onModelBake(ModelBakeEvent event) {
		for (ModelResourceLocation resource : event.getModelRegistry().getKeys()) {
			if (LOIConfig.render.emissiveTextures && resource.getResourceDomain().equals(ModInformation.ID) && emissiveTextures.containsKey(resource.getResourcePath())) {
				event.getModelRegistry().putObject(resource, new BakedModelEmissive(event.getModelRegistry().getObject(resource), emissiveTextures.get(resource.getResourcePath())));
			}
			if (resource.getResourceDomain().equals(ModInformation.ID) && resource.getResourcePath().contains("spell_scroll")) {
				event.getModelRegistry().putObject(resource, new BakedModelScroll(event.getModelRegistry().getObject(resource)));
			}
			if (resource.getResourceDomain().equals(ModInformation.ID) && resource.getResourcePath().contains("salted_food")) {
				event.getModelRegistry().putObject(resource, new BakedModelBuiltInParticle(event.getModelRegistry().getObject(resource), Minecraft.getMinecraft().getTextureMapBlocks().registerSprite(new ResourceLocation(ModInformation.ID, "items/mineral_halite_powder"))));
			}
		}
		modelManager = event.getModelManager();
	}

	@SubscribeEvent
	public void registerBlockColors(ColorHandlerEvent.Block event) {
		event.getBlockColors().registerBlockColorHandler(new IBlockColor() {
			@Override
			public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) {
				return reduceGreen(worldIn != null && pos != null ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : ColorizerGrass.getGrassColor(0.5D, 1.0D));
			}
		}, Resources.grass.getBlock(), Resources.tallGrass.getBlock(), Resources.herb.getBlock(), Resources.vineDry.getBlock(), Resources.vineThorny.getBlock(), Resources.vineDryDead.getBlock(), Resources.vineThornyDead.getBlock());

		event.getBlockColors().registerBlockColorHandler(new IBlockColor() {
			@Override
			public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) {
				return worldIn != null && pos != null ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : ColorizerGrass.getGrassColor(0.5D, 1.0D);
			}
		}, Resources.flower.getBlock(), Resources.flower2.getBlock(), Resources.bromelia.getBlock(), Resources.vineBloomy.getBlock(), Resources.vineBranch.getBlock(), Resources.vineBrushy.getBlock(), Resources.vineReedy.getBlock(), Resources.vineSwirly.getBlock(), Resources.vineBloomyDead.getBlock(), Resources.vineBranchDead.getBlock(), Resources.vineBrushyDead.getBlock(), Resources.vineReedyDead.getBlock(), Resources.vineSwirlyDead.getBlock());
	}

	@SubscribeEvent
	public void registerItemColors(ColorHandlerEvent.Item event) {
		event.getItemColors().registerItemColorHandler(new IItemColor() {
			@Override
			public int colorMultiplier(ItemStack stack, int tintIndex) {
				return tintIndex > 0 ? -1 : reduceGreen(ColorizerGrass.getGrassColor(0.5D, 1.0D));
			}
		}, Resources.grass, Resources.tallGrass, Resources.herb, Resources.vineDry, Resources.vineThorny);

		event.getItemColors().registerItemColorHandler(new IItemColor() {
			@Override
			public int colorMultiplier(ItemStack stack, int tintIndex) {
				return tintIndex > 0 ? -1 : ColorizerGrass.getGrassColor(0.5D, 1.0D);
			}
		}, Resources.flower, Resources.flower2, Resources.bromelia, Resources.vineBloomy, Resources.vineBranch, Resources.vineBrushy, Resources.vineReedy, Resources.vineSwirly);

		event.getItemColors().registerItemColorHandler(new IItemColor() {
			@Override
			public int colorMultiplier(ItemStack stack, int tintIndex) {
				return tintIndex > 0 ? -1 : ((ItemConcoctionFlask) stack.getItem()).getColor();
			}
		}, Resources.concoctions.toArray(new Item[Resources.concoctions.size()]));
	}

	public int reduceGreen(int color) {
		Color col = new Color(color);
		return new Color(Math.min(col.getRed() + 30, 255), Math.max(col.getGreen() - 10, 0), col.getBlue()).getRGB();
	}

	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().register(IcariaSounds.SCORPION_IDLE);
		event.getRegistry().register(IcariaSounds.SCORPION_HURT);
		event.getRegistry().register(IcariaSounds.SCORPION_DEATH);
		event.getRegistry().register(IcariaSounds.GRIND);
		event.getRegistry().register(IcariaSounds.CERAMIC_BREAK);
	}

	@Override
	public void onMouseEvent(MouseEvent event) {
		if (event.getButton() == 0 && event.isButtonstate()) {
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer thePlayer = mc.player;
			if (thePlayer != null) {
				ItemStack itemstack = thePlayer.getHeldItemMainhand();
				IItemCustomReach ieri = null;
				if (itemstack != null) {
					if (itemstack.getItem() instanceof IItemCustomReach) {
						ieri = (IItemCustomReach) itemstack.getItem();
					}
					if (ieri != null) {
						float reach = ieri.getReach();
						RayTraceResult mov = getMouseOverExtended(reach);
						if (mov != null && mov.entityHit != null) {
							if (mov.entityHit.hurtResistantTime == 0) {
								if (mov.entityHit != thePlayer) {
									LandsOfIcaria.network.sendToServer(new MessageCustomReachAttack(mov.entityHit.getEntityId()));
								}
							}
						}
					}
				}
			}
		}
	}

	public static RayTraceResult getMouseOverExtended(float dist) {
		Minecraft mc = FMLClientHandler.instance().getClient();
		Entity theRenderViewEntity = mc.getRenderViewEntity();
		RayTraceResult returnRTR = null;
		if (mc.world != null) {
			returnRTR = theRenderViewEntity.rayTrace(dist, 0);
			Vec3d pos = theRenderViewEntity.getPositionEyes(0);
			Vec3d lookvec = theRenderViewEntity.getLook(0);
			Vec3d var8 = pos.addVector(lookvec.x * dist, lookvec.y * dist, lookvec.z * dist);
			Entity pointedEntity = null;
			float var9 = 1.0F;
			List<Entity> list = mc.world.getEntitiesInAABBexcluding(theRenderViewEntity, theRenderViewEntity.getEntityBoundingBox().expand(lookvec.x * dist, lookvec.y * dist, lookvec.z * dist).grow(var9, var9, var9), Predicates.and(EntitySelectors.NOT_SPECTATING, new Predicate<Entity>() {
				public boolean apply(@Nullable Entity entity) {
					return entity != null && entity.canBeCollidedWith();
				}
			}));
			double d = dist;

			for (Entity entity : list) {
				AxisAlignedBB aabb = entity.getEntityBoundingBox().grow((double)entity.getCollisionBorderSize());
				RayTraceResult mop0 = aabb.calculateIntercept(pos, var8);

				if (mop0 != null) {
					double d1 = pos.distanceTo(mop0.hitVec);
					if (d1 < d) {
						pointedEntity = entity;
						d = d1;
					}
				}
			}
			if (pointedEntity != null && (d < dist )) {
				returnRTR = new RayTraceResult(pointedEntity);
			}
		}
		return returnRTR;
	}

	public AttributeModifier frozenModifier = Resources.frozenEffect.getAttributeModifierMap().get(SharedMonsterAttributes.MOVEMENT_SPEED);

	@SubscribeEvent
	public void entityRenderPre(RenderLivingEvent.Pre event) {
		if (event.getEntity().getAttributeMap().getAttributeInstance(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(frozenModifier)) {
			GlStateManager.color(0.5686F, 0.8862F, 1.0F);
		}
		if (event.getRenderer().getMainModel() instanceof ModelBiped) {
			for (ItemStack stack : event.getEntity().getArmorInventoryList()) {
				if (stack.getItem() instanceof ItemBlockMobHead) {
					((ModelBiped) event.getRenderer().getMainModel()).bipedHead.isHidden = true;
					return;
				}
			}
			((ModelBiped) event.getRenderer().getMainModel()).bipedHead.isHidden = false;
		}
	}

	@SubscribeEvent
	public void entityRenderPost(RenderLivingEvent.Post event) {
		if (event.getEntity().getAttributeMap().getAttributeInstance(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(frozenModifier)) {
			GlStateManager.color(1, 1, 1);
		}
		//maybe I can make this work someday
		/*if (event.getRenderer().getMainModel() instanceof ModelBiped) {
			ModelBiped model = (ModelBiped) event.getRenderer().getMainModel();
			model.bipedHead.isHidden = false;
			for (ItemStack stack : event.getEntity().getArmorInventoryList()) {
				if (stack.getItem() instanceof ItemBlockMobHead) {
					GlStateManager.pushMatrix();
					GlStateManager.disableCull();
					GlStateManager.color(1.0F, 1.0F, 1.0F);
					model.bipedHead.postRender(0.0625F);
					TileEntitySpecialRendererMobHead.instance.renderSkull(0.0F, 0.1F, 0.0F, EnumFacing.DOWN, 0.0F, ((BlockMobHead) ((ItemBlock) stack.getItem()).getBlock()).name, -1, 1.6F);
					GlStateManager.enableCull();
					GlStateManager.popMatrix();
				}
			}
		}*/
	}
}
