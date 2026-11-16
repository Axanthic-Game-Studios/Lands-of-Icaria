package com.axanthic.icaria.client.outline;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import java.util.*;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.BlockOutlineRenderState;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OutlineManager extends SimpleJsonResourceReloadListener<Outline> {
	/**
	 * Holds the weighted models of every possible state of every block that has outlines,
	 * built once on every resource reload.
	 */
	public static final Map<BlockState, WeightedList<List<List<Float>>>> CACHE = new HashMap<>();

	/**
	 * Provides the random source for picking a model, which is reused
	 * so nothing has to be allocated while playing.
	 */
	public static final RandomSource RANDOM = RandomSource.create();

	/**
	 * Creates the manager, which reads every JSON file in the outlines folder
	 * with the codec of the outline.
	 */
	public OutlineManager() {
		super(Outline.CODEC, FileToIdConverter.json("outlines"));
	}

	/**
	 * Replaces the cache with the outlines of all files that belong to a block,
	 * once on every resource reload.
	 */
	@Override
	public void apply(Map<Identifier, Outline> pOutlines, ResourceManager pResourceManager, ProfilerFiller pProfilerFiller) {
		OutlineManager.CACHE.clear();
		pOutlines.forEach(OutlineManager::load);
	}

	/**
	 * Bakes the outlines of a single file for the block with the same identifier,
	 * and skips files that do not belong to a block.
	 */
	public static void load(Identifier pIdentifier, Outline pOutline) {
		BuiltInRegistries.BLOCK.getOptional(pIdentifier).ifPresent(block -> OutlineManager.bake(block, pOutline.variants()));
	}

	/**
	 * Resolves every possible state of the block to its weighted models,
	 * so nothing has to be looked up while playing.
	 */
	public static void bake(Block pBlock, Map<String, WeightedList<List<List<Float>>>> pVariants) {
		var variants = OutlineManager.sort(pVariants);
		pBlock.getStateDefinition().getPossibleStates().forEach(blockState -> variants.entrySet().stream().filter(entry -> OutlineManager.matches(blockState, entry.getKey())).findFirst().ifPresent(entry -> OutlineManager.CACHE.put(blockState, entry.getValue())));
	}

	/**
	 * Orders the variants by the number of properties in their condition, most specific first,
	 * so the catch-all only applies when nothing else matches.
	 */
	public static Map<String, WeightedList<List<List<Float>>>> sort(Map<String, WeightedList<List<List<Float>>>> pVariants) {
		var variants = new LinkedHashMap<String, WeightedList<List<List<Float>>>>();
		pVariants.keySet().stream().sorted(Comparator.comparingInt(OutlineManager::specificity).reversed()).forEach(key -> variants.put(key, pVariants.get(key)));
		return variants;
	}

	/**
	 * Counts the properties a condition lists,
	 * which is 0 for the catch-all.
	 */
	public static int specificity(String pKey) {
		return pKey.isEmpty() ? 0 : pKey.split(",").length;
	}

	/**
	 * Checks if a state fulfills a condition. Every listed property must equal the state's,
	 * other properties are ignored, and the catch-all matches every state.
	 */
	public static boolean matches(BlockState pBlockState, String pKey) {
		return Arrays.stream(pKey.split(",")).filter(part -> part.indexOf('=') > 0).allMatch(part -> OutlineManager.has(pBlockState, part));
	}

	/**
	 * Checks a single property of a condition against the state,
	 * by its name and its expected value.
	 */
	public static boolean has(BlockState pBlockState, String pPart) {
		var index = pPart.indexOf('=');
		var property = pBlockState.getBlock().getStateDefinition().getProperty(pPart.substring(0, index).trim());
		return property != null && property.getValue(pPart.substring(index + 1).trim()).equals(Optional.of(pBlockState.getValue(property)));
	}

	/**
	 * Picks one of the weighted models of a state, seeded from the block position,
	 * so the same block always gets the same model.
	 */
	public static List<List<Float>> choose(BlockPos pBlockPos, BlockState pBlockState, WeightedList<List<List<Float>>> pModels) {
		var seed = pBlockState.getSeed(pBlockPos);
		OutlineManager.RANDOM.setSeed(seed);
		return pModels.getRandomOrThrow(OutlineManager.RANDOM);
	}

	/**
	 * Draws the outlines at the position of the block relative to the camera
	 * and cancels the vanilla outline.
	 */
	public static boolean draw(BlockOutlineRenderState pBlockOutlineRenderState, BlockPos pBlockPos, LevelRenderState pLevelRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, List<List<Float>> pLines) {
		var gameRenderer = Minecraft.getInstance().gameRenderer;
		var vec3 = pLevelRenderState.cameraRenderState.pos;
		pPoseStack.pushPose();
		pPoseStack.translate(pBlockPos.getX() - vec3.x(), pBlockPos.getY() - vec3.y(), pBlockPos.getZ() - vec3.z());
		OutlineManager.submit(pPoseStack, pSubmitNodeCollector, pLines, pBlockOutlineRenderState.highContrast(), gameRenderer.useImprovedTransparency(), gameRenderer.gameRenderState().windowRenderState.appropriateLineWidth);
		pPoseStack.popPose();
		return true;
	}

	/**
	 * Submits the outlines in the look the player has set. In high contrast that is
	 * an opaque underlay with a bright line on top, otherwise one translucent line.
	 */
	public static void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, List<List<Float>> pLines, boolean pHighContrast, boolean pImprovedTransparency, float pWidth) {
		if (pHighContrast) {
			pSubmitNodeCollector.submitCustomGeometry(pPoseStack, RenderTypes.secondaryBlockOutline(), (pose, vertexConsumer) -> OutlineManager.vertices(pose, vertexConsumer, pLines, 7.0F, 0xFF000000));
			pSubmitNodeCollector.submitCustomGeometry(pPoseStack, RenderTypes.linesDepthBias(), (pose, vertexConsumer) -> OutlineManager.vertices(pose, vertexConsumer, pLines, pWidth, 0xFF57FFE1));
		} else {
			pSubmitNodeCollector.submitCustomGeometry(pPoseStack, pImprovedTransparency ? RenderTypes.linesTranslucentNoDepthWrite() : RenderTypes.linesTranslucent(), (pose, vertexConsumer) -> OutlineManager.vertices(pose, vertexConsumer, pLines, pWidth, 0x66000000));
		}
	}

	/**
	 * Adds the two vertices of every outline, each outline being six numbers
	 * for the start and the end point in block space. Outlines without a length are skipped.
	 */
	public static void vertices(PoseStack.Pose pPose, VertexConsumer pVertexConsumer, List<List<Float>> pLines, float pWidth, int pColor) {
		for (var line : pLines) {
			var x0 = line.get(0);
			var y0 = line.get(1);
			var z0 = line.get(2);
			var x1 = line.get(3);
			var y1 = line.get(4);
			var z1 = line.get(5);
			var dx = x1 - x0;
			var dy = y1 - y0;
			var dz = z1 - z0;
			var length = Mth.sqrt(dx * dx + dy * dy + dz * dz);
			if (length > 0.0F) {
				dx /= length;
				dy /= length;
				dz /= length;
				pVertexConsumer.addVertex(pPose, x0, y0, z0).setColor(pColor).setNormal(pPose, dx, dy, dz).setLineWidth(pWidth);
				pVertexConsumer.addVertex(pPose, x1, y1, z1).setColor(pColor).setNormal(pPose, dx, dy, dz).setLineWidth(pWidth);
			}
		}
	}
}
