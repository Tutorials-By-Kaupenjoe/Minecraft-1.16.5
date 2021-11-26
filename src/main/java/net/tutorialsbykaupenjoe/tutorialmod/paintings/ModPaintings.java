package net.tutorialsbykaupenjoe.tutorialmod.paintings;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;

public class ModPaintings {
    public static final DeferredRegister<PaintingType> PAINTING_TYPES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<PaintingType> SUNSET =
            PAINTING_TYPES.register("sunset", () -> new PaintingType(32, 16));

    public static final RegistryObject<PaintingType> PLANT =
            PAINTING_TYPES.register("plant", () -> new PaintingType(16, 16));


    public static void register(IEventBus eventBus) {
        PAINTING_TYPES.register(eventBus);
    }
}
