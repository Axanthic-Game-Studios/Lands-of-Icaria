package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.handler.GrinderItemStackHandler;
import com.axanthic.icaria.common.item.GearItem;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.container.data.GrinderContainerData;
import com.axanthic.icaria.common.recipe.GrindingRecipe;

import com.google.common.collect.Lists;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderBlockEntity extends BlockEntity {
	public int lastSound = 6;
	public int maxFuel = 0;
	public int fuel = 0;
	public int maxProgress = 0;
	public int progress = 0;
	public int rotation = 0;
	public int size = 6;

	public ItemStackHandler stackHandler = new GrinderItemStackHandler(this.size, this);

	public LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> this.stackHandler);

	public Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

	public SimpleContainer simpleContainer = new SimpleContainer(this.size);

	public GrinderBlockEntity(BlockPos pPos, BlockState pState) {
		super(IcariaBlockEntityTypes.GRINDER.get(), pPos, pState);
	}

	public boolean canInsertCountIntoOutputSlot(SimpleContainer pContainer) {
		return pContainer.getItem(5).getMaxStackSize() > pContainer.getItem(5).getCount();
	}

	public boolean canInsertStackIntoOutputSlot(SimpleContainer pContainer, ItemStack pStack) {
		return pContainer.getItem(5).getItem() == pStack.getItem() || pContainer.getItem(5).isEmpty();
	}

	public boolean hasFuel() {
		return this.fuel > 0;
	}

	public boolean hasRecipe() {
		for (int i = 0; i < this.size; i++) {
			this.simpleContainer.setItem(i, this.stackHandler.getStackInSlot(i));
		}

		Optional<GrindingRecipe> recipe = Optional.empty();
		if (this.level != null) {
			recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.GRINDING.get(), this.simpleContainer, this.level);
		}

		int burnTime = 0;
		if (recipe.isPresent()) {
			burnTime = recipe.get().getBurnTime();
		}

		if (this.maxProgress != burnTime) {
			this.maxProgress = burnTime;
		}

		return recipe.isPresent() && this.canInsertCountIntoOutputSlot(this.simpleContainer) && this.canInsertStackIntoOutputSlot(this.simpleContainer, recipe.get().getResultItem(null));
	}

	public boolean shouldBreak(GrinderBlockEntity pBlockEntity) {
		var itemStack = pBlockEntity.stackHandler.getStackInSlot(2);
		return itemStack.getMaxDamage() - itemStack.getDamageValue() <= 0;
	}

	public int getComparatorInput() {
		return this.itemHandler.map(ItemHandlerHelper::calcRedstoneFromInventory).orElse(0);
	}

	public void awardUsedRecipesAndPopExperience(ServerPlayer pPlayer) {
		pPlayer.awardRecipes(this.getRecipesToAwardAndPopExperience(pPlayer.serverLevel(), pPlayer.position()));
		this.recipesUsed.clear();
	}

	public void craftItem() {
		for (int i = 0; i < this.size; i++) {
			this.simpleContainer.setItem(i, this.stackHandler.getStackInSlot(i));
		}

		Optional<GrindingRecipe> recipe = Optional.empty();
		if (this.level != null) {
			recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.GRINDING.get(), this.simpleContainer, this.level);
		}

		if (this.hasRecipe() && recipe.isPresent()) {
			this.stackHandler.extractItem(0, 1, false);
			if (this.simpleContainer.getItem(3).getMaxStackSize() > this.simpleContainer.getItem(3).getCount()) {
				this.stackHandler.setStackInSlot(3, new ItemStack(recipe.get().getResultItem(null).getItem(), recipe.get().getResultItem(null).getCount() + this.stackHandler.getStackInSlot(3).getCount()));
			} else if (this.simpleContainer.getItem(4).getMaxStackSize() > this.simpleContainer.getItem(4).getCount()) {
				this.stackHandler.setStackInSlot(4, new ItemStack(recipe.get().getResultItem(null).getItem(), recipe.get().getResultItem(null).getCount() + this.stackHandler.getStackInSlot(4).getCount()));
			} else if (this.simpleContainer.getItem(5).getMaxStackSize() > this.simpleContainer.getItem(5).getCount()) {
				this.stackHandler.setStackInSlot(5, new ItemStack(recipe.get().getResultItem(null).getItem(), recipe.get().getResultItem(null).getCount() + this.stackHandler.getStackInSlot(5).getCount()));
			}

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
		for (int i = 0; i < this.size; i++) {
			this.simpleContainer.setItem(i, this.stackHandler.getStackInSlot(i));
		}

		Containers.dropContents(pLevel, this.worldPosition, this.simpleContainer);
	}

	@Override
	public void load(CompoundTag pTag) {
		super.load(pTag);
		if (pTag.contains("Inventory")) {
			this.stackHandler.deserializeNBT(pTag.getCompound("Inventory"));
			this.maxFuel = pTag.getInt("TotalFuelTime");
			this.fuel = pTag.getInt("CurrentFuelTime");
			this.maxProgress = pTag.getInt("TotalProgressTime");
			this.progress = pTag.getInt("CurrentProgressTime");
			var compoundTag = pTag.getCompound("RecipesUsed");
			for(var string : compoundTag.getAllKeys()) {
				this.recipesUsed.put(new ResourceLocation(string), compoundTag.getInt(string));
			}
		}
	}

	public void resetProgress() {
		this.progress = 0;
		this.maxProgress = 0;
	}

	@Override
	public void saveAdditional(CompoundTag pTag) {
		super.saveAdditional(pTag);
		pTag.put("Inventory", this.stackHandler.serializeNBT());
		pTag.putInt("TotalFuelTime", this.maxFuel);
		pTag.putInt("CurrentFuelTime", this.fuel);
		pTag.putInt("TotalProgressTime", this.maxProgress);
		pTag.putInt("CurrentProgressTime", this.progress);
		var compoundTag = new CompoundTag();
		this.recipesUsed.forEach((resourceLocation, index) -> compoundTag.putInt(resourceLocation.toString(), index));
		pTag.put("RecipesUsed", compoundTag);
	}

	public void setRecipeUsed(Recipe<?> pRecipe) {
		this.recipesUsed.addTo(pRecipe.getId(), 1);
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		this.itemHandler.invalidate();
	}

	public static void tick(Level pLevel, BlockPos pPos, BlockState pState, GrinderBlockEntity pBlockEntity) {
		var stackHandler = pBlockEntity.stackHandler;
		var fuelSlot = stackHandler.getStackInSlot(1);
		var gearSlot = stackHandler.getStackInSlot(2);
		if (!pLevel.isClientSide()) {
			if (!pBlockEntity.hasFuel()) {
				if (fuelSlot.getItem() == IcariaItems.SLIVER.get()) {
					int fuelTime = 800;
					stackHandler.extractItem(1, 1, false);
					pBlockEntity.fuel = fuelTime;
					pBlockEntity.maxFuel = fuelTime;
					pBlockEntity.setChanged();
				} else if (fuelSlot.getItem() == IcariaItems.SLIVER_BLOCK.get()) {
					int fuelTime = 7200;
					stackHandler.extractItem(1, 1, false);
					pBlockEntity.fuel = fuelTime;
					pBlockEntity.maxFuel = fuelTime;
					pBlockEntity.setChanged();
				}
			}

			if (pBlockEntity.hasFuel() && pBlockEntity.hasRecipe()) {
				if (pBlockEntity.rotation >= 90) {
					pBlockEntity.rotation = 0;
				} else {
					pBlockEntity.rotation++;
				}

				if (IcariaConfig.GRINDER_SOUNDS.get()) {
					if (pBlockEntity.lastSound >= 6) {
						pBlockEntity.lastSound = 0;
						pLevel.playSound(null, pPos, IcariaSoundEvents.GRINDER_GRIND, SoundSource.BLOCKS, 1.0F, 1.0F);
					} else {
						pBlockEntity.lastSound++;
					}
				}

				if (pBlockEntity.progress >= pBlockEntity.maxProgress) {
					pBlockEntity.craftItem();
					pBlockEntity.setChanged();
					if (gearSlot.getItem() instanceof GearItem) {
						gearSlot.hurt(1, RandomSource.create(), null);
						pBlockEntity.setChanged();
						if (pBlockEntity.shouldBreak(pBlockEntity)) {
							stackHandler.extractItem(2, 1, false);
							pBlockEntity.setChanged();
						}
					}
				}

				pBlockEntity.progress++;
				pBlockEntity.fuel--;
				pBlockEntity.setChanged();
				pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.GRINDING, true).setValue(IcariaBlockStateProperties.GRINDER_ROTATION, pBlockEntity.rotation), 3);
			} else {
				pBlockEntity.resetProgress();
				pBlockEntity.setChanged();
				pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.GRINDING, false), 3);
			}
		}
	}

	@Override
	public CompoundTag getUpdateTag() {
		var compoundTag = new CompoundTag();
		compoundTag.put("Inventory", this.stackHandler.serializeNBT());
		compoundTag.putInt("TotalFuelTime", this.maxFuel);
		compoundTag.putInt("CurrentFuelTime", this.fuel);
		compoundTag.putInt("TotalProgressTime", this.maxProgress);
		compoundTag.putInt("CurrentProgressTime", this.progress);
		return compoundTag;
	}

	public ContainerData getData() {
		return new GrinderContainerData(this);
	}

	public ItemStack getGear() {
		return this.stackHandler.getStackInSlot(2);
	}

	public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel pLevel, Vec3 pPopVec) {
		List<Recipe<?>> list = Lists.newArrayList();
		for (var entry : this.recipesUsed.object2IntEntrySet()) {
			pLevel.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe) -> {
				list.add(recipe);
				if (recipe instanceof GrindingRecipe firingRecipe) {
					this.createExperience(pLevel, pPopVec, entry.getIntValue(), firingRecipe.getExperience());
				}
			});
		}

		return list;
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> pCapability, @Nullable Direction pDirection) {
		return pCapability == ForgeCapabilities.ITEM_HANDLER ? this.itemHandler.cast() : super.getCapability(pCapability, pDirection);
	}
}
