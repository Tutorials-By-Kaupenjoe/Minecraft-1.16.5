package net.tutorialsbykaupenjoe.tutorialmod.block.custom.trees;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.tutorialsbykaupenjoe.tutorialmod.world.gen.ModConfiguredFeatures;

import javax.annotation.Nullable;
import java.util.Random;

public class RedwoodTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return ModConfiguredFeatures.REDWOOD;
    }
}
