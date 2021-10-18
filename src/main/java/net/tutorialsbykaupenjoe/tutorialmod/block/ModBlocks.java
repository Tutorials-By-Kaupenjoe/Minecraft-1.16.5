package net.tutorialsbykaupenjoe.tutorialmod.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;
import net.tutorialsbykaupenjoe.tutorialmod.block.custom.*;
import net.tutorialsbykaupenjoe.tutorialmod.block.custom.trees.RedwoodTree;
import net.tutorialsbykaupenjoe.tutorialmod.item.ModItemGroup;
import net.tutorialsbykaupenjoe.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> AMETHYST_ORE = registerBlock("amethyst_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));

    public static final RegistryObject<Block> AMETHYST_BLOCK = registerBlock("amethyst_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(8f)));

    public static final RegistryObject<Block> FIRESTONE_BLOCK = registerBlock("firestone_block",
            () -> new FirestoneBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f)));


    public static final RegistryObject<Block> AMETHYST_STAIRS = registerBlock("amethyst_stairs",
            () -> new StairsBlock(() -> AMETHYST_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.IRON).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool()));

    public static final RegistryObject<Block> AMETHYST_FENCE = registerBlock("amethyst_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f)));

    public static final RegistryObject<Block> AMETHYST_FENCE_GATE = registerBlock("amethyst_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f)));

    public static final RegistryObject<Block> AMETHYST_SLAB = registerBlock("amethyst_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f)));

    public static final RegistryObject<Block> AMETHYST_BUTTON = registerBlock("amethyst_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f).doesNotBlockMovement()));

    public static final RegistryObject<Block> AMETHYST_PRESSURE_PLATE = registerBlock("amethyst_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f)));

    public static final RegistryObject<Block> AMETHYST_DOOR = registerBlock("amethyst_door",
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).setRequiresTool()
                    .harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f).notSolid()));

    public static final RegistryObject<Block> AMETHYST_TRAPDOOR = registerBlock("amethyst_trapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).setRequiresTool()
                    .harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f).notSolid()));

    public static final RegistryObject<Block> OATS = BLOCKS.register("oats_crop",
            () -> new OatsBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));


    public static final RegistryObject<Block> REDWOOD_LOG = registerBlock("redwood_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> REDWOOD_WOOD = registerBlock("redwood_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> REDWOOD_PLANKS = registerBlock("redwood_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));


    public static final RegistryObject<Block> REDWOOD_LEAVES = registerBlock("redwood_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f)
                .tickRandomly().sound(SoundType.PLANT).notSolid()));

    public static final RegistryObject<Block> REDWOOD_SAPLING = registerBlock("redwood_sapling",
            () -> new SaplingBlock(new RedwoodTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> HYACINTH = registerBlock("hyacinth",
            () -> new FlowerBlock(Effects.HASTE, 2, AbstractBlock.Properties.from(Blocks.DANDELION)));

    public static final RegistryObject<Block> LIGHTNING_CHANNELER = registerBlock("lightning_channeler",
            () -> new LightningChannelerBlock(AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> REDWOOD_SIGN = BLOCKS.register("redwood_sign",
            () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.IRON), ModWoodTypes.REDWOOD));

    public static final RegistryObject<Block> REDWOOD_WALL_SIGN = BLOCKS.register("redwood_wall_sign",
            () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.IRON), ModWoodTypes.REDWOOD));


    public static final RegistryObject<Block> KAUPEN_ALTAR = registerBlock("kaupen_altar",
            () -> new KaupenAltarBlock(AbstractBlock.Properties.create(Material.IRON).notSolid()));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
