package com.hrznstudio.galacticraft.util;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.ArrayList;

public class ConnectingBlockUtils {
    private ConnectingBlockUtils() {
    }

    public static final BooleanProperty ATTACHED_NORTH = BooleanProperty.of("attached_north");
    public static final BooleanProperty ATTACHED_EAST = BooleanProperty.of("attached_east");
    public static final BooleanProperty ATTACHED_SOUTH = BooleanProperty.of("attached_south");
    public static final BooleanProperty ATTACHED_WEST = BooleanProperty.of("attached_west");
    public static final BooleanProperty ATTACHED_UP = BooleanProperty.of("attached_up");
    public static final BooleanProperty ATTACHED_DOWN = BooleanProperty.of("attached_down");

    public static BooleanProperty getBooleanProperty(Direction dir, BooleanProperty attachedSouth, BooleanProperty attachedEast, BooleanProperty attachedWest, BooleanProperty attachedNorth, BooleanProperty attachedUp, BooleanProperty attachedDown) {
        switch (dir) {
            case SOUTH:
                return attachedSouth;
            case EAST:
                return attachedEast;
            case WEST:
                return attachedWest;
            case NORTH:
                return attachedNorth;
            case UP:
                return attachedUp;
            case DOWN:
                return attachedDown;
            default:
                throw new IllegalArgumentException("cannot be null");
        }
    }

    public static VoxelShape getVoxelShape(BlockState blockState, VoxelShape north, VoxelShape south, VoxelShape east, VoxelShape west, VoxelShape up, VoxelShape down, VoxelShape none) {
        VoxelShape shape = none;

        if (blockState.get(ATTACHED_NORTH)) {
            shape = VoxelShapes.combineAndSimplify(shape, north, BooleanBiFunction.OR);
        }
        if (blockState.get(ATTACHED_SOUTH)) {
            shape = VoxelShapes.combineAndSimplify(shape, south, BooleanBiFunction.OR);
        }
        if (blockState.get(ATTACHED_EAST)) {
            shape = VoxelShapes.combineAndSimplify(shape, east, BooleanBiFunction.OR);
        }
        if (blockState.get(ATTACHED_WEST)) {
            shape = VoxelShapes.combineAndSimplify(shape, west, BooleanBiFunction.OR);
        }
        if (blockState.get(ATTACHED_UP)) {
            shape = VoxelShapes.combineAndSimplify(shape, up, BooleanBiFunction.OR);
        }
        if (blockState.get(ATTACHED_DOWN)) {
            shape = VoxelShapes.combineAndSimplify(shape, down, BooleanBiFunction.OR);
        }
        return shape;
    }
}
