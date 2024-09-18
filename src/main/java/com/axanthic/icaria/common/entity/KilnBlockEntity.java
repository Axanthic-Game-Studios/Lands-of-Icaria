package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.container.data.KilnContainerData;
import com.axanthic.icaria.common.handler.stack.KilnFuelItemStackHandler;
import com.axanthic.icaria.common.handler.stack.KilnInputItemStackHandler;
import com.axanthic.icaria.common.handler.stack.KilnOutputItemStackHandler;
import com.axanthic.icaria.common.recipe.FiringRecipe;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import com.google.common.collect.Lists;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnBlockEntity extends BlockEntity {
	public int fuel = 0;
	public int maxFuel = 0;
	public int progress = 0;
	public int maxProgress = 0;
	public int size = 3;

	public ItemStackHandler fuelHandler = new KilnFuelItemStackHandler(1, this);
	public ItemStackHandler inputHandler = new KilnInputItemStackHandler(1, this);
	public ItemStackHandler outputHandler = new KilnOutputItemStackHandler(1, this);

	public Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

	public SimpleContainer simpleContainer = new SimpleContainer(this.size);

	public KilnBlockEntity(BlockPos pPos, BlockState pState) {
		super(IcariaBlockEntityTypes.KILN.get(), pPos, pState);
	}

	public boolean canInsertInSlot(SimpleContainer pContainer, FiringRecipe pRecipe, int pSlot) {
		return (pContainer.getItem(pSlot).getItem() == pRecipe.getResultItem(null).getItem() || pContainer.getItem(pSlot).isEmpty()) && pContainer.getItem(pSlot).getCount() + pRecipe.getResultItem(null).getCount() <= 64;
	}

	public boolean hasFuel() {
		return this.fuel > 0;
	}

	public boolean hasRecipe() {
		this.simpleContainer.setItem(0, this.fuelHandler.getStackInSlot(0));
		this.simpleContainer.setItem(1, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(2, this.outputHandler.getStackInSlot(0));

		Optional<RecipeHolder<FiringRecipe>> recipe = Optional.empty();
		if (this.level != null) {
			recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.FIRING.get(), this.getRecipeInput(), this.level);
		}

		int burnTime = 0;
		if (recipe.isPresent()) {
			burnTime = recipe.get().value().getBurnTime();
		}

		if (this.maxProgress != burnTime) {
			this.maxProgress = burnTime;
		}

		return recipe.isPresent() && this.canInsertInSlot(this.simpleContainer, recipe.get().value(), 2);
	}

	public int getComparatorInput() {
		int i = (this.fuelHandler.getStackInSlot(0).getCount() * 15) / 64;
		int j = (this.inputHandler.getStackInSlot(0).getCount() * 15) / 64;
		int k = (this.outputHandler.getStackInSlot(0).getCount() * 15) / 64;
		return (i + j + k) / this.size;
	}

	public void awardUsedRecipesAndPopExperience(ServerPlayer player) {
		player.awardRecipes(this.getRecipesToAwardAndPopExperience(player.serverLevel(), player.position()));
		this.recipesUsed.clear();
	}

	public void craftItem() {
		this.simpleContainer.setItem(0, this.fuelHandler.getStackInSlot(0));
		this.simpleContainer.setItem(1, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(2, this.outputHandler.getStackInSlot(0));

		Optional<RecipeHolder<FiringRecipe>> recipe = Optional.empty();
		if (this.level != null) {
			recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.FIRING.get(), this.getRecipeInput(), this.level);
		}

		if (this.hasRecipe() && recipe.isPresent()) {
			this.inputHandler.extractItem(0, 1, false);
			this.outputHandler.setStackInSlot(0, new ItemStack(recipe.get().value().getResultItem(null).getItem(), recipe.get().value().getResultItem(null).getCount() + this.outputHandler.getStackInSlot(0).getCount()));
			this.resetProgress();
			this.setRecipeUsed(recipe.get());
		}
	}

	public void createExperience(ServerLevel pLevel, Vec3 pPopVec, int pRecipeIndex, float pExperience) {
		float f = Mth.frac(pRecipeIndex * pExperience);
		int i = Mth.floor(pRecipeIndex * pExperience);
		if (f != 0.0F && Math.random() < f) {
			++i;
		}

		ExperienceOrb.award(pLevel, pPopVec, i);
	}

	public void drops(Level pLevel) {
		this.simpleContainer.setItem(0, this.fuelHandler.getStackInSlot(0));
		this.simpleContainer.setItem(1, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(2, this.outputHandler.getStackInSlot(0));
		Containers.dropContents(pLevel, this.worldPosition, this.simpleContainer);
	}

	@Override
	public void loadAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
		super.loadAdditional(pTag, pProvider);
		this.fuelHandler.deserializeNBT(pProvider, pTag.getCompound("FuelInventory"));
		this.inputHandler.deserializeNBT(pProvider, pTag.getCompound("InputInventory"));
		this.outputHandler.deserializeNBT(pProvider, pTag.getCompound("OutputInventory"));
		this.fuel = pTag.getInt("CurrentFuelTime");
		this.maxFuel = pTag.getInt("TotalFuelTime");
		this.progress = pTag.getInt("CurrentProgressTime");
		this.maxProgress = pTag.getInt("TotalProgressTime");
		var compoundTag = pTag.getCompound("RecipesUsed");
		for (var string : compoundTag.getAllKeys()) {
			this.recipesUsed.put(ResourceLocation.parse(string), compoundTag.getInt(string));
		}
	}

	public void resetFuel() {
		this.fuel = 0;
		this.maxFuel = 0;
	}

	public void resetProgress() {
		this.progress = 0;
		this.maxProgress = 0;
	}

	@Override
	public void saveAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
		super.saveAdditional(pTag, pProvider);
		pTag.put("FuelInventory", this.fuelHandler.serializeNBT(pProvider));
		pTag.put("InputInventory", this.inputHandler.serializeNBT(pProvider));
		pTag.put("OutputInventory", this.outputHandler.serializeNBT(pProvider));
		pTag.putInt("CurrentFuelTime", this.fuel);
		pTag.putInt("TotalFuelTime", this.maxFuel);
		pTag.putInt("CurrentProgressTime", this.progress);
		pTag.putInt("TotalProgressTime", this.maxProgress);
		var compoundTag = new CompoundTag();
		this.recipesUsed.forEach((resourceLocation, index) -> compoundTag.putInt(resourceLocation.toString(), index));
		pTag.put("RecipesUsed", compoundTag);
	}

	public void setRecipeUsed(RecipeHolder<?> pRecipe) {
		this.recipesUsed.addTo(pRecipe.id(), 1);
	}

	public static void tick(Level pLevel, BlockPos pPos, BlockState pState, KilnBlockEntity pBlockEntity) {
		var fuelSlot = pBlockEntity.fuelHandler.getStackInSlot(0);
		var fuelTime = fuelSlot.getBurnTime(IcariaRecipeTypes.FIRING.get());
		if (!pLevel.isClientSide()) {
			pBlockEntity.update(pPos, pState);
			if (!pBlockEntity.hasFuel() && pBlockEntity.hasRecipe() && fuelTime > 0) {
				pBlockEntity.fuelHandler.extractItem(0, 1, false);
				pBlockEntity.fuel = fuelTime + 1;
				pBlockEntity.maxFuel = fuelTime;
			}

			if (pBlockEntity.hasFuel()) {
				pBlockEntity.fuel--;
				pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, true), 3);
				pLevel.setBlock(pPos.above(), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.LIT, true), 3);
			} else {
				pBlockEntity.resetFuel();
				pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, false), 3);
				pLevel.setBlock(pPos.above(), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.LIT, false), 3);
			}

			if (pBlockEntity.hasRecipe() && pState.getValue(BlockStateProperties.LIT)) {
				pBlockEntity.progress++;
				if (pBlockEntity.progress >= pBlockEntity.maxProgress) {
					pBlockEntity.craftItem();
				}
			} else {
				pBlockEntity.resetProgress();
			}
		}
	}

	public void update(BlockPos pPos, BlockState pState) {
		if (this.getLevel() != null) {
			this.getLevel().sendBlockUpdated(pPos, pState, pState, 3);
			this.getLevel().updateNeighbourForOutputSignal(pPos.above(), pState.getBlock());
			this.setChanged();
		}
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
		var compoundTag = new CompoundTag();
		compoundTag.put("FuelInventory", this.fuelHandler.serializeNBT(pProvider));
		compoundTag.put("InputInventory", this.inputHandler.serializeNBT(pProvider));
		compoundTag.put("OutputInventory", this.outputHandler.serializeNBT(pProvider));
		compoundTag.putInt("CurrentFuelTime", this.fuel);
		compoundTag.putInt("TotalFuelTime", this.maxFuel);
		compoundTag.putInt("CurrentProgressTime", this.progress);
		compoundTag.putInt("TotalProgressTime", this.maxProgress);
		return compoundTag;
	}

	public ContainerData getData() {
		return new KilnContainerData(this);
	}

	public static @Nullable IItemHandler getCapability(KilnBlockEntity pBlockEntity, Direction pDirection) {
		if (pDirection == pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite()) {
			return pBlockEntity.fuelHandler;
		} else if (pDirection == Direction.DOWN) {
			return pBlockEntity.outputHandler;
		}

		return null;
	}

	public ItemStack getFuel() {
		return this.fuelHandler.getStackInSlot(0);
	}

	public ItemStack getInput() {
		return this.inputHandler.getStackInSlot(0);
	}

	public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel pLevel, Vec3 pPopVec) {
		List<RecipeHolder<?>> list = Lists.newArrayList();
		for (var entry : this.recipesUsed.object2IntEntrySet()) {
			pLevel.getRecipeManager().byKey(entry.getKey()).ifPresent(
				(recipe) -> {
					list.add(recipe);
					if (recipe.value() instanceof FiringRecipe firingRecipe) {
						this.createExperience(pLevel, pPopVec, entry.getIntValue(), firingRecipe.getExperience());
					}
				}
			);
		}

		return list;
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public RecipeInput getRecipeInput() {
		return new SingleRecipeInput(this.inputHandler.getStackInSlot(0));
	}
}
