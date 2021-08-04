package net.tutorialsbykaupenjoe.tutorialmod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.tutorialsbykaupenjoe.tutorialmod.block.ModBlocks;

import javax.annotation.Nullable;

public class RedwoodLog extends RotatedPillarBlock {
    public RedwoodLog(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                           ItemStack stack, ToolType toolType) {
        boolean rightClickedWithAxe = toolType == ToolType.AXE;
        BlockState toReturn = ModBlocks.REDWOOD_LOG.get().getDefaultState();

        if(rightClickedWithAxe){
            toReturn = ModBlocks.STRIPPED_REDWOOD_LOG.get().getDefaultState();
        }

        return toReturn;
    }
}
