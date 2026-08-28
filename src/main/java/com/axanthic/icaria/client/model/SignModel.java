package com.axanthic.icaria.client.model;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.Model;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record SignModel(Model.Simple modelStanding, Model.Simple modelWall) {}
