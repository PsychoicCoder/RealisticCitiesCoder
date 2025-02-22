package su.harbingers_of_chaos.realisticcitiescoder.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.WallShape;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class ConnectingRoad extends HorizontalFacingBlock {
    public static final EnumProperty<Connection> CONNECTION = EnumProperty.of("connection", Connection.class);
    public static final EnumProperty<Direction> FACING;

    public ConnectingRoad(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(CONNECTION, Connection.SINGLE)).with(FACING, Direction.NORTH));
    }

    boolean canConnect(BlockState blockState) {
        return blockState.getBlock() == this;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new EnumProperty[]{CONNECTION});
        builder.add(new EnumProperty[]{FACING});
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!direction.getAxis().isHorizontal()) {
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        } else {
            boolean north = this.canConnect(world.getBlockState(pos.north()));
            boolean east = this.canConnect(world.getBlockState(pos.east()));
            boolean west = this.canConnect(world.getBlockState(pos.west()));
            boolean south = this.canConnect(world.getBlockState(pos.south()));
            int neighbors = (north ? 1 : 0) + (east ? 1 : 0) + (west ? 1 : 0) + (south ? 1 : 0);
            if (neighbors == 4) {
                return (BlockState)state.with(CONNECTION, Connection.INTERSECTION);
            } else {
                BlockState s;
                if (neighbors == 3) {
                    s = (BlockState)state.with(CONNECTION, Connection.TEE);
                    if (!north) {
                        return (BlockState)s.with(FACING, Direction.SOUTH);
                    } else if (!east) {
                        return (BlockState)s.with(FACING, Direction.WEST);
                    } else {
                        return !west ? (BlockState)s.with(FACING, Direction.EAST) : (BlockState)s.with(FACING, Direction.NORTH);
                    }
                } else if (neighbors == 2) {
                    s = (BlockState)state.with(CONNECTION, Connection.MIDDLE);
                    if (north && south) {
                        return (BlockState)s.with(FACING, Direction.NORTH);
                    } else if (east && west) {
                        return (BlockState)s.with(FACING, Direction.EAST);
                    } else {
                        s = (BlockState)state.with(CONNECTION, Connection.CORNER);
                        if (north && east) {
                            return (BlockState)s.with(FACING, Direction.NORTH);
                        } else if (east && south) {
                            return (BlockState)s.with(FACING, Direction.EAST);
                        } else {
                            return south && west ? (BlockState)s.with(FACING, Direction.SOUTH) : (BlockState)s.with(FACING, Direction.WEST);
                        }
                    }
                } else if (neighbors == 1) {
                    s = (BlockState)state.with(CONNECTION, Connection.END);
                    if (north) {
                        return (BlockState)s.with(FACING, Direction.SOUTH);
                    } else if (east) {
                        return (BlockState)s.with(FACING, Direction.WEST);
                    } else {
                        return south ? (BlockState)s.with(FACING, Direction.NORTH) : (BlockState)s.with(FACING, Direction.EAST);
                    }
                } else {
                    return (BlockState)state.with(CONNECTION, Connection.SINGLE);
                }
            }
        }
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }
}
