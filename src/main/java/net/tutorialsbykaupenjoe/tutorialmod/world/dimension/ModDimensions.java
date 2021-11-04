package net.tutorialsbykaupenjoe.tutorialmod.world.dimension;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;

public class ModDimensions {
    public static RegistryKey<World> KJDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(TutorialMod.MOD_ID, "kjdim"));
}
