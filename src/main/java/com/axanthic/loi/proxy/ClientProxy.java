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
import com.axanthic.loi.entity.EntityAeternae;
import com.axanthic.loi.entity.EntityArachne;
import com.axanthic.loi.entity.EntityArachneDrone;
import com.axanthic.loi.entity.EntityArganHound;
import com.axanthic.loi.entity.EntityBident;
import com.axanthic.loi.entity.EntityCatoblepas;
import com.axanthic.loi.entity.EntityCerver;
import com.axanthic.loi.entity.EntityFallingVase;
import com.axanthic.loi.entity.EntityForestHagCypress;
import com.axanthic.loi.entity.EntityForestHagDroughtroot;
import com.axanthic.loi.entity.EntityForestHagFir;
import com.axanthic.loi.entity.EntityForestHagLaurel;
import com.axanthic.loi.entity.EntityForestHagOlive;
import com.axanthic.loi.entity.EntityForestHagPlane;
import com.axanthic.loi.entity.EntityForestHagPopulus;
import com.axanthic.loi.entity.EntityGrenade;
import com.axanthic.loi.entity.EntityJellyfish;
import com.axanthic.loi.entity.EntityLight;
import com.axanthic.loi.entity.EntityMyrmeke;
import com.axanthic.loi.entity.EntityRevenantCaptain;
import com.axanthic.loi.entity.EntityRevenantCivilian;
import com.axanthic.loi.entity.EntityRevenantCrawler;
import com.axanthic.loi.entity.EntityRevenantOvergrown;
import com.axanthic.loi.entity.EntityRevenantPyromancer;
import com.axanthic.loi.entity.EntityRevenantSoldier;
import com.axanthic.loi.entity.EntitySiren;
import com.axanthic.loi.entity.EntitySnull;
import com.axanthic.loi.entity.EntitySow;
import com.axanthic.loi.items.IItemCustomReach;
import com.axanthic.loi.items.IItemMeta;
import com.axanthic.loi.items.ItemBlockMeta;
import com.axanthic.loi.items.ItemConcoctionVial;
import com.axanthic.loi.items.ItemCustomArmor;
import com.axanthic.loi.items.ItemScroll;
import com.axanthic.loi.items.ItemSpell;
import com.axanthic.loi.render.BakedModelEmissive;
import com.axanthic.loi.render.BakedModelScroll;
import com.axanthic.loi.render.RenderAeternae;
import com.axanthic.loi.render.RenderArachne;
import com.axanthic.loi.render.RenderArachneDrone;
import com.axanthic.loi.render.RenderArganHound;
import com.axanthic.loi.render.RenderBident;
import com.axanthic.loi.render.RenderCatoblepas;
import com.axanthic.loi.render.RenderCerver;
import com.axanthic.loi.render.RenderForestHagCypress;
import com.axanthic.loi.render.RenderForestHagDroughtroot;
import com.axanthic.loi.render.RenderForestHagFir;
import com.axanthic.loi.render.RenderForestHagLaurel;
import com.axanthic.loi.render.RenderForestHagOlive;
import com.axanthic.loi.render.RenderForestHagPlane;
import com.axanthic.loi.render.RenderForestHagPopulus;
import com.axanthic.loi.render.RenderGrenade;
import com.axanthic.loi.render.RenderJellyfish;
import com.axanthic.loi.render.RenderLight;
import com.axanthic.loi.render.RenderMyrmeke;
import com.axanthic.loi.render.RenderRevenantCaptain;
import com.axanthic.loi.render.RenderRevenantCivilian;
import com.axanthic.loi.render.RenderRevenantCrawler;
import com.axanthic.loi.render.RenderRevenantOvergrown;
import com.axanthic.loi.render.RenderRevenantPyromancer;
import com.axanthic.loi.render.RenderRevenantSoldier;
import com.axanthic.loi.render.RenderSiren;
import com.axanthic.loi.render.RenderSnull;
import com.axanthic.loi.render.RenderSow;
import com.axanthic.loi.tileentity.TileEntityColoredLight;
import com.axanthic.loi.tileentity.TileEntityGrinder;
import com.axanthic.loi.tileentity.TileEntityKettle;
import com.axanthic.loi.tileentity.TileEntityMobHead;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererColoredLight;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererGrinder;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererKettle;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererMobHead;
import com.axanthic.loi.utils.LOIItemStackRenderer;
import com.axanthic.loi.utils.MessageCustomReachAttack;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.entity.Entity;
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
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	public static final ResourceLocation SOUND_GRIND = new ResourceLocation(ModInformation.ID, "block.grinder.grind");
	public static final SoundEvent GRIND = new SoundEvent(SOUND_GRIND).setRegistryName(SOUND_GRIND);
	public static final ResourceLocation SOUND_CERAMIC_BREAK = new ResourceLocation(ModInformation.ID, "block.ceramic.break");
	public static final SoundEvent CERAMIC_BREAK = new SoundEvent(SOUND_CERAMIC_BREAK).setRegistryName(SOUND_CERAMIC_BREAK);
	public static Map<String, String[]> emissiveTextures = new HashMap<String, String[]>();
	public static ModelManager modelManager;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityBident.class, RenderBident::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, RenderGrenade::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFallingVase.class, RenderFallingBlock::new);
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
		RenderingRegistry.registerEntityRenderingHandler(EntityRevenantCrawler.class, RenderRevenantCrawler::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRevenantOvergrown.class, RenderRevenantOvergrown::new);
		RenderingRegistry.registerEntityRenderingHandler(EntitySiren.class, RenderSiren::new);

		emissiveTextures.put("calcite", new String[]{ ModInformation.ID + ":blocks/gem_calcite_model" });
		emissiveTextures.put("jasper", new String[]{ ModInformation.ID + ":blocks/gem_jasper_model" });
		emissiveTextures.put("zircon", new String[]{ ModInformation.ID + ":blocks/gem_zircon_model" });
		emissiveTextures.put("block_gem", new String[]{ ModInformation.ID + ":blocks/mineral_calcite_block", ModInformation.ID + ":blocks/mineral_jasper_block", ModInformation.ID + ":blocks/mineral_zircon_block" });
		emissiveTextures.put("block_metal", new String[]{ ModInformation.ID + ":blocks/metal_bluridium_block" });
		emissiveTextures.put("ore", new String[]{ ModInformation.ID + ":blocks/rock_baetyl_ore_bluridium_overlay" });
		emissiveTextures.put("icaria_portal", new String[]{ ModInformation.ID + ":blocks/icaria_portal" });
		//emissiveTextures.put("crafting_forge", new String[]{ ModInformation.ID + ":blocks/crafting_forge_fire" });
		//emissiveTextures.put("crafting_kiln", new String[]{ ModInformation.ID + ":blocks/crafting_kiln_fire" });

		LOIItemStackRenderer.LOIInstance = new LOIItemStackRenderer();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrinder.class, new TileEntitySpecialRendererGrinder());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKettle.class, new TileEntitySpecialRendererKettle());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHead.class, new TileEntitySpecialRendererMobHead());
		if (LOIConfig.render.lights)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityColoredLight.class, new TileEntitySpecialRendererColoredLight());
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	@Override
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
			} else if (item instanceof ItemConcoctionVial) {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), "concoction_vial_filled"), "inventory"));
			} else
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}

		//register special item renderers here
		Resources.grinder.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
		Resources.healSpell.scroll.setTileEntityItemStackRenderer(LOIItemStackRenderer.LOIInstance);
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
	}

	@Override
	public void onModelBake(ModelBakeEvent event) {
		for (ModelResourceLocation resource : event.getModelRegistry().getKeys()) {
			if (LOIConfig.render.emissiveTextures && resource.getResourceDomain().equals(ModInformation.ID) && emissiveTextures.containsKey(resource.getResourcePath())) {
				event.getModelRegistry().putObject(resource, new BakedModelEmissive(event.getModelRegistry().getObject(resource), emissiveTextures.get(resource.getResourcePath())));
			}
			if (resource.getResourceDomain().equals(ModInformation.ID) && resource.getResourcePath().contains("spell_scroll")) {
				event.getModelRegistry().putObject(resource, new BakedModelScroll(event.getModelRegistry().getObject(resource)));
			}
		}
		modelManager = event.getModelManager();
	}

	@Override
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

	@Override
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
				return tintIndex > 0 ? -1 : ((ItemConcoctionVial) stack.getItem()).getColor();
			}
		}, Resources.concoctions.toArray(new Item[Resources.concoctions.size()]));
	}

	public int reduceGreen(int color) {
		Color col = new Color(color);
		return new Color(Math.min(col.getRed() + 30, 255), Math.max(col.getGreen() - 10, 0), col.getBlue()).getRGB();
	}

	@Override
	public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().register(GRIND);
		event.getRegistry().register(CERAMIC_BREAK);
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
}
