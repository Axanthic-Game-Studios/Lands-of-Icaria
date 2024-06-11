package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.KilnBlock;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnRedirectorBlockEntity extends BlockEntity {
    public KilnBlockEntity original;

    public KilnRedirectorBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntityTypes.KILN_REDIRECTOR.get(), pPos, pState);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (this.level instanceof ServerLevel serverLevel) {
            if (serverLevel.getBlockEntity(KilnBlock.getBlockEntityPosition(serverLevel.getBlockState(this.getBlockPos()), this.getBlockPos())) instanceof KilnBlockEntity blockEntity) {
                this.original = blockEntity;
            }
        }
    }

    //@Override
    //public <T> LazyOptional<T> getCapability(Capability<T> pCapability, @Nullable Direction pDirection) {
    //    return this.original != null ? this.original.getCapabilityForPos(pCapability, pDirection, this.getBlockPos()) : LazyOptional.empty();
    //}
}
