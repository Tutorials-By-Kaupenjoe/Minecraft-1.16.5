package net.tutorialsbykaupenjoe.tutorialmod.block;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;

public class ModPaintings {
    public static final DeferredRegister<PaintingType> PAINTING_TYPES = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, TutorialMod.MOD_ID);

    /*
    * REMINDER: If you want to make a painting of 20 blocks, you will have to multiply 20 by 16.
    * This is because each block is 16 pixels, in fact if you do not follow the "rule" of multiplication by 16 you can also create paintings of a block and a half.
    */

    //In this case I create a painting of 1 block, so I put for height and width 16.
    public static final RegistryObject<PaintingType> KAUPEN_LOGO = PAINTING_TYPES.register("kaupen_logo",
            () -> new PaintingType(16, 16));

    public static void register(IEventBus eventBus) { PAINTING_TYPES.register(eventBus); }
}
