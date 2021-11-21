package net.tutorialsbykaupenjoe.tutorialmod.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;
import net.tutorialsbykaupenjoe.tutorialmod.block.ModBlocks;
import net.tutorialsbykaupenjoe.tutorialmod.entity.ModEntityTypes;
import net.tutorialsbykaupenjoe.tutorialmod.fluid.ModFluids;
import net.tutorialsbykaupenjoe.tutorialmod.item.custom.*;
import net.tutorialsbykaupenjoe.tutorialmod.util.ModSoundEvents;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);


    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
            () -> new Item(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",
            () -> new Firestone(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP).maxDamage(8)));


    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
            () -> new SwordItem(ModItemTier.AMETHYST, 2, 3f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe",
            () -> new PickaxeItem(ModItemTier.AMETHYST, 0, -1f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
            () -> new ShovelItem(ModItemTier.AMETHYST, 0, -1f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe",
            () -> new AxeItem(ModItemTier.AMETHYST, 4, -6f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
            () -> new HoeItem(ModItemTier.AMETHYST, 0, 0f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));


    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new ModArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));


    public static final RegistryObject<Item> OATS = ITEMS.register("oats",
            () -> new BlockItem(ModBlocks.OATS.get(), new Item.Properties()
                    .food(new Food.Builder().hunger(1).saturation(0.1f).fastToEat().build())
                    .group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> AMETHYST_HORSE_ARMOR = ITEMS.register("amethyst_horse_armor",
            () -> new HorseArmorItem(9, "amethyst",
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> REDWOOD_SIGN = ITEMS.register("redwood_sign",
            () -> new SignItem(new Item.Properties().maxStackSize(16).group(ModItemGroup.TUTORIAL_GROUP),
                    ModBlocks.REDWOOD_SIGN.get(), ModBlocks.REDWOOD_WALL_SIGN.get()));


    public static final RegistryObject<Item> OIL_BUCKET = ITEMS.register("oil_bucket",
            () -> new BucketItem(() -> ModFluids.OIL_FLUID.get(),
                    new Item.Properties().maxStackSize(1).group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<ModSpawnEggItem> BUFF_ZOMBIE_SPAWN_EGG = ITEMS.register("buff_zombie_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.BUFF_ZOMBIE, 0x464F56, 0x1D6336,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<ModSpawnEggItem> PIGEON_SPAWN_EGG = ITEMS.register("pigeon_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.PIGEON, 0x879995, 0x576ABC,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));


    public static final RegistryObject<Item> KAUPENBOW = ITEMS.register("kaupenbow",
            () -> new BowItem(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP).maxStackSize(1)));

    public static final RegistryObject<Item> KAUPENSTAFF = ITEMS.register("kaupen_staff",
            () -> new StaffItem(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP).maxStackSize(1)));

    public static final RegistryObject<Item> REDWOOD_BOAT = ITEMS.register("redwood_boat",
            () -> new ModBoatItem(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP), "redwood"));


    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new MusicDiscItem(1, () -> ModSoundEvents.BAR_BRAWL.get(),
                    new Item.Properties().maxStackSize(1).group(ModItemGroup.TUTORIAL_GROUP)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
