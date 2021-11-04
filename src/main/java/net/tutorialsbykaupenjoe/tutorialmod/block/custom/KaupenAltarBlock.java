package net.tutorialsbykaupenjoe.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.tutorialsbykaupenjoe.tutorialmod.world.dimension.KJTeleporter;
import net.tutorialsbykaupenjoe.tutorialmod.world.dimension.ModDimensions;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class KaupenAltarBlock extends HorizontalBlock {
    public KaupenAltarBlock(Properties builder) {
        super(builder);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(5, 11, 5, 6, 13, 11),
            Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
            Block.makeCuboidShape(5, 1, 5, 11, 2, 11),
            Block.makeCuboidShape(6, 2, 6, 10, 10, 10),
            Block.makeCuboidShape(5, 10, 4, 11, 11, 12),
            Block.makeCuboidShape(5, 11, 4, 11, 12, 5),
            Block.makeCuboidShape(5, 11, 11, 11, 14, 12),
            Block.makeCuboidShape(10, 11, 5, 11, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(5, 11, 5, 11, 13, 6),
            Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
            Block.makeCuboidShape(5, 1, 5, 11, 2, 11),
            Block.makeCuboidShape(6, 2, 6, 10, 10, 10),
            Block.makeCuboidShape(4, 10, 5, 12, 11, 11),
            Block.makeCuboidShape(11, 11, 5, 12, 12, 11),
            Block.makeCuboidShape(4, 11, 5, 5, 14, 11),
            Block.makeCuboidShape(5, 11, 10, 11, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(10, 11, 5, 11, 13, 11),
            Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
            Block.makeCuboidShape(5, 1, 5, 11, 2, 11),
            Block.makeCuboidShape(6, 2, 6, 10, 10, 10),
            Block.makeCuboidShape(5, 10, 4, 11, 11, 12),
            Block.makeCuboidShape(5, 11, 11, 11, 12, 12),
            Block.makeCuboidShape(5, 11, 4, 11, 14, 5),
            Block.makeCuboidShape(5, 11, 5, 6, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(5, 11, 10, 11, 13, 11),
            Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
            Block.makeCuboidShape(5, 1, 5, 11, 2, 11),
            Block.makeCuboidShape(6, 2, 6, 10, 10, 10),
            Block.makeCuboidShape(4, 10, 5, 12, 11, 11),
            Block.makeCuboidShape(4, 11, 5, 5, 12, 11),
            Block.makeCuboidShape(11, 11, 5, 12, 14, 11),
            Block.makeCuboidShape(5, 11, 5, 11, 13, 6)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();

                if (server != null) {
                    if (worldIn.getDimensionKey() == ModDimensions.KJDim) {
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null) {
                            player.changeDimension(overWorld, new KJTeleporter(pos, false));
                        }
                    } else {
                        ServerWorld kjDim = server.getWorld(ModDimensions.KJDim);
                        if (kjDim != null) {
                            player.changeDimension(kjDim, new KJTeleporter(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(HORIZONTAL_FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
}
