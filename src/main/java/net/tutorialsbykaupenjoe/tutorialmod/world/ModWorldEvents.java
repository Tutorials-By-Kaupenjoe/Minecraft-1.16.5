package net.tutorialsbykaupenjoe.tutorialmod.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;
import net.tutorialsbykaupenjoe.tutorialmod.world.gen.ModTreeGeneration;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModTreeGeneration.generateTrees(event);
    }
}
