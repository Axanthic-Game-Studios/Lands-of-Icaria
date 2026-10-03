package com.axanthic.icaria.annotation;

import java.lang.annotation.ElementType;

import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

@Nonnull
@TypeQualifierDefault(ElementType.PARAMETER)

public @interface ParametersAreNonnullByDefault {}
