package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaDataComponents;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CookieJarBlock extends JarBlock {
	public CookieJarBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.COOKIE_AMOUNT, 0).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Direction pDirection) {
		return pBlockState.getValue(IcariaBlockStateProperties.COOKIE_AMOUNT) * 2;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.COOKIE_AMOUNT, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var fluid = pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType();
		return this.defaultBlockState().setValue(IcariaBlockStateProperties.COOKIE_AMOUNT, pBlockPlaceContext.getItemInHand().getOrDefault(IcariaDataComponents.COOKIES, 0)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pItemStack.is(Items.COOKIE) && pBlockState.getValue(IcariaBlockStateProperties.COOKIE_AMOUNT) < 7) {
			pItemStack.consume(1, pPlayer);
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.COOKIE_JAR_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.COOKIE_AMOUNT, pBlockState.getValue(IcariaBlockStateProperties.COOKIE_AMOUNT) + 1));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.isEmpty() && pBlockState.getValue(IcariaBlockStateProperties.COOKIE_AMOUNT) > 0 && (pPlayer.getFoodData().needsFood() || pPlayer.isCreative())) {
			this.eat(pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.GENERIC_EAT.value(), SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.COOKIE_AMOUNT, pBlockState.getValue(IcariaBlockStateProperties.COOKIE_AMOUNT) - 1));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public void eat(Player pPlayer) {
		var itemStack = new ItemStack(Items.COOKIE);
		var foodProperties = itemStack.get(DataComponents.FOOD);
		if (foodProperties != null) {
			pPlayer.getFoodData().eat(foodProperties);
		}
	}

	@Override
	public ItemStack getCloneItemStack(LevelReader pLevelReader, BlockPos pBlockPos, BlockState pBlockState, boolean pIncludeData, Player pPlayer) {
		var itemStack = pBlockState.getCloneItemStack(pLevelReader, pBlockPos, pIncludeData);
		itemStack.set(IcariaDataComponents.COOKIES, pBlockState.getValue(IcariaBlockStateProperties.COOKIE_AMOUNT));
		return itemStack;
	}
}
