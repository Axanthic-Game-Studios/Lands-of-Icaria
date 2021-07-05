package com.axanthic.loi;

import com.axanthic.loi.blocks.BlockVineBloomy;
import com.axanthic.loi.blocks.BlockVineBloomyBlooming;
import com.axanthic.loi.blocks.BlockVineBloomyDead;
import com.axanthic.loi.blocks.BlockVineBloomyFruit;
import com.axanthic.loi.blocks.BlockVineBloomyGrowing;
import com.axanthic.loi.blocks.BlockVineBranch;
import com.axanthic.loi.blocks.BlockVineBranchDead;
import com.axanthic.loi.blocks.BlockVineBranchGrowing;
import com.axanthic.loi.blocks.BlockVineBrushy;
import com.axanthic.loi.blocks.BlockVineBrushyDead;
import com.axanthic.loi.blocks.BlockVineBrushyGrowing;
import com.axanthic.loi.blocks.BlockVineBrushyRoot;
import com.axanthic.loi.blocks.BlockVineDry;
import com.axanthic.loi.blocks.BlockVineDryDead;
import com.axanthic.loi.blocks.BlockVineDryGrowing;
import com.axanthic.loi.blocks.BlockVineReedy;
import com.axanthic.loi.blocks.BlockVineReedyDead;
import com.axanthic.loi.blocks.BlockVineReedyGrowing;
import com.axanthic.loi.blocks.BlockVineSwirly;
import com.axanthic.loi.blocks.BlockVineSwirlyDead;
import com.axanthic.loi.blocks.BlockVineSwirlyGrowing;
import com.axanthic.loi.blocks.BlockVineThorny;
import com.axanthic.loi.blocks.BlockVineThornyDead;
import com.axanthic.loi.blocks.BlockVineThornyGrowing;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

@EventBusSubscriber(modid = ModInformation.ID)
public class LOIVines
{
    public static BlockVineBloomyDead vineBloomyDead;
    public static BlockVineBloomyGrowing vineBloomyGrowing;
    public static BlockVineBloomy vineBloomy;
    public static BlockVineBloomyBlooming vineBloomyBlooming;
    public static BlockVineBloomyFruit vineBloomyFruit;
    public static BlockVineBranchDead vineBranchDead;
    public static BlockVineBranchGrowing vineBranchGrowing;
    public static BlockVineBranch vineBranch;
    public static BlockVineBrushyDead vineBrushyDead;
    public static BlockVineBrushyGrowing vineBrushyGrowing;
    public static BlockVineBrushy vineBrushy;
    public static BlockVineBrushyRoot vineBrushyRoot;
    public static BlockVineDryDead vineDryDead;
    public static BlockVineDryGrowing vineDryGrowing;
    public static BlockVineDry vineDry;
    public static BlockVineReedyDead vineReedyDead;
    public static BlockVineReedyGrowing vineReedyGrowing;
    public static BlockVineReedy vineReedy;
    public static BlockVineSwirlyDead vineSwirlyDead;
    public static BlockVineSwirlyGrowing vineSwirlyGrowing;
    public static BlockVineSwirly vineSwirly;
    public static BlockVineThornyDead vineThornyDead;
    public static BlockVineThornyGrowing vineThornyGrowing;
    public static BlockVineThorny vineThorny;

    public static void registerVines()
    {
        vineBloomyDead = new BlockVineBloomyDead("vine_bloomy_dead");
        vineBloomyGrowing = new BlockVineBloomyGrowing("vine_bloomy_growing");
        vineBloomy = new BlockVineBloomy("vine_bloomy");
        vineBloomyBlooming = new BlockVineBloomyBlooming("vine_bloomy_blooming");
        vineBloomyFruit = new BlockVineBloomyFruit("vine_bloomy_fruit");
        vineBranchDead = new BlockVineBranchDead("vine_branch_dead");
        vineBranchGrowing = new BlockVineBranchGrowing("vine_branch_growing");
        vineBranch = new BlockVineBranch("vine_branch");
        vineBrushyDead = new BlockVineBrushyDead("vine_brushy_dead");
        vineBrushyGrowing = new BlockVineBrushyGrowing("vine_brushy_growing");
        vineBrushy = new BlockVineBrushy("vine_brushy");
        vineBrushyRoot = new BlockVineBrushyRoot("vine_brushy_root");
        vineDryDead = new BlockVineDryDead("vine_dry_dead");
        vineDryGrowing = new BlockVineDryGrowing("vine_dry_growing");
        vineDry = new BlockVineDry("vine_dry");
        vineReedyDead = new BlockVineReedyDead("vine_reedy_dead");
        vineReedyGrowing = new BlockVineReedyGrowing("vine_reedy_growing");
        vineReedy = new BlockVineReedy("vine_reedy");
        vineSwirlyDead = new BlockVineSwirlyDead("vine_swirly_dead");
        vineSwirlyGrowing = new BlockVineSwirlyGrowing("vine_swirly_growing");
        vineSwirly = new BlockVineSwirly("vine_swirly");
        vineThornyDead = new BlockVineThornyDead("vine_thorny_dead");
        vineThornyGrowing = new BlockVineThornyGrowing("vine_thorny_growing");
        vineThorny = new BlockVineThorny("vine_thorny");
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(vineBloomyDead);
        event.getRegistry().register(vineBloomyGrowing);
        event.getRegistry().register(vineBloomy);
        event.getRegistry().register(vineBloomyBlooming);
        event.getRegistry().register(vineBloomyFruit);
        event.getRegistry().register(vineBranchDead);
        event.getRegistry().register(vineBranchGrowing);
        event.getRegistry().register(vineBranch);
        event.getRegistry().register(vineBrushyDead);
        event.getRegistry().register(vineBrushyGrowing);
        event.getRegistry().register(vineBrushy);
        event.getRegistry().register(vineBrushyRoot);
        event.getRegistry().register(vineDryDead);
        event.getRegistry().register(vineDryGrowing);
        event.getRegistry().register(vineDry);
        event.getRegistry().register(vineReedyDead);
        event.getRegistry().register(vineReedyGrowing);
        event.getRegistry().register(vineReedy);
        event.getRegistry().register(vineSwirlyDead);
        event.getRegistry().register(vineSwirlyGrowing);
        event.getRegistry().register(vineSwirly);
        event.getRegistry().register(vineThornyDead);
        event.getRegistry().register(vineThornyGrowing);
        event.getRegistry().register(vineThorny);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(new ItemBlock(vineBloomyDead).setRegistryName(Objects.requireNonNull(vineBloomyDead.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBloomyGrowing).setRegistryName(Objects.requireNonNull(vineBloomyGrowing.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBloomy).setRegistryName(Objects.requireNonNull(vineBloomy.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBloomyBlooming).setRegistryName(Objects.requireNonNull(vineBloomyBlooming.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBloomyFruit).setRegistryName(Objects.requireNonNull(vineBloomyFruit.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBranchDead).setRegistryName(Objects.requireNonNull(vineBranchDead.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBranchGrowing).setRegistryName(Objects.requireNonNull(vineBranchGrowing.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBranch).setRegistryName(Objects.requireNonNull(vineBranch.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBrushyDead).setRegistryName(Objects.requireNonNull(vineBrushyDead.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBrushyGrowing).setRegistryName(Objects.requireNonNull(vineBrushyGrowing.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBrushy).setRegistryName(Objects.requireNonNull(vineBrushy.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineBrushyRoot).setRegistryName(Objects.requireNonNull(vineBrushyRoot.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineDryDead).setRegistryName(Objects.requireNonNull(vineDryDead.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineDryGrowing).setRegistryName(Objects.requireNonNull(vineDryGrowing.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineDry).setRegistryName(Objects.requireNonNull(vineDry.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineReedyDead).setRegistryName(Objects.requireNonNull(vineReedyDead.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineReedyGrowing).setRegistryName(Objects.requireNonNull(vineReedyGrowing.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineReedy).setRegistryName(Objects.requireNonNull(vineReedy.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineSwirlyDead).setRegistryName(Objects.requireNonNull(vineSwirlyDead.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineSwirlyGrowing).setRegistryName(Objects.requireNonNull(vineSwirlyGrowing.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineSwirly).setRegistryName(Objects.requireNonNull(vineSwirly.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineThornyDead).setRegistryName(Objects.requireNonNull(vineThornyDead.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineThornyGrowing).setRegistryName(Objects.requireNonNull(vineThornyGrowing.getRegistryName())));
        event.getRegistry().registerAll(new ItemBlock(vineThorny).setRegistryName(Objects.requireNonNull(vineThorny.getRegistryName())));
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event)
    {
        registerRender(Item.getItemFromBlock(vineBloomyDead));
        registerRender(Item.getItemFromBlock(vineBloomyGrowing));
        registerRender(Item.getItemFromBlock(vineBloomy));
        registerRender(Item.getItemFromBlock(vineBloomyBlooming));
        registerRender(Item.getItemFromBlock(vineBloomyFruit));
        registerRender(Item.getItemFromBlock(vineBranchDead));
        registerRender(Item.getItemFromBlock(vineBranchGrowing));
        registerRender(Item.getItemFromBlock(vineBranch));
        registerRender(Item.getItemFromBlock(vineBrushyDead));
        registerRender(Item.getItemFromBlock(vineBrushyGrowing));
        registerRender(Item.getItemFromBlock(vineBrushy));
        registerRender(Item.getItemFromBlock(vineBrushyRoot));
        registerRender(Item.getItemFromBlock(vineDryDead));
        registerRender(Item.getItemFromBlock(vineDryGrowing));
        registerRender(Item.getItemFromBlock(vineDry));
        registerRender(Item.getItemFromBlock(vineReedyDead));
        registerRender(Item.getItemFromBlock(vineReedyGrowing));
        registerRender(Item.getItemFromBlock(vineReedy));
        registerRender(Item.getItemFromBlock(vineSwirlyDead));
        registerRender(Item.getItemFromBlock(vineSwirlyGrowing));
        registerRender(Item.getItemFromBlock(vineSwirly));
        registerRender(Item.getItemFromBlock(vineThornyDead));
        registerRender(Item.getItemFromBlock(vineThornyGrowing));
        registerRender(Item.getItemFromBlock(vineThorny));
    }

    public static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
}