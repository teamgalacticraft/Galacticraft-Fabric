/*
 * Copyright (c) 2020 HRZN LTD
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.hrznstudio.galacticraft.api.block;

import com.hrznstudio.galacticraft.api.block.entity.ConfigurableMachineBlockEntity;
import com.hrznstudio.galacticraft.api.block.util.BlockFace;
import com.hrznstudio.galacticraft.api.wire.WireConnectable;
import com.hrznstudio.galacticraft.api.wire.WireConnectionType;
import io.github.cottonmc.component.item.impl.SimpleInventoryComponent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="https://github.com/StellarHorizons">StellarHorizons</a>
 */
public abstract class ConfigurableMachineBlock extends BlockWithEntity implements WireConnectable {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ConfigurableMachineBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    public abstract ConfigurableMachineBlockEntity createBlockEntity(BlockView var1);

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite());
    }

    @NotNull
    @Override
    public WireConnectionType canWireConnect(WorldAccess world, Direction opposite, BlockPos connectionSourcePos, BlockPos connectionTargetPos) {
        BlockState state = world.getBlockState(connectionTargetPos);
        SideOption option = ((ConfigurableMachineBlockEntity) world.getBlockEntity(connectionTargetPos)).getSideConfigInfo().get(BlockFace.toFace(state.get(FACING), opposite)).getOption();

        if (option == SideOption.POWER_INPUT) {
            return WireConnectionType.ENERGY_INPUT;
        } else if (option == SideOption.POWER_OUTPUT) {
            return WireConnectionType.ENERGY_OUTPUT;
        }

        return WireConnectionType.NONE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public final void appendTooltip(ItemStack stack, BlockView view, List<Text> lines, TooltipContext context) {
        Text text = machineInfo(stack, view, context);
        if (text != null) {
            List<Text> info = new ArrayList<>();
            char[] line = text instanceof TranslatableText ? I18n.translate(((TranslatableText) text).getKey()).toCharArray() : text.getString().toCharArray();
            int len = 0;
            final int maxLength = 175;
            StringBuilder builder = new StringBuilder();
            for (char c : line) {
                len += MinecraftClient.getInstance().textRenderer.getWidth(String.valueOf(c));
                if (c == ' ' && len >= maxLength) {
                    len = 0;
                    info.add(new LiteralText(builder.toString()).setStyle(text.getStyle()));
                    builder = new StringBuilder();
                    continue;
                }
                builder.append(c);
            }
            info.add(new LiteralText(builder.toString()).setStyle(text.getStyle()));
            if (Screen.hasShiftDown()) {
                lines.addAll(info);
            } else {
                lines.add(new TranslatableText("tooltip.galacticraft-rewoven.press_shift").setStyle(Style.EMPTY.withColor(Formatting.DARK_GRAY)));
            }
        }

        if (stack != null && stack.getTag() != null && stack.getTag().contains("BlockEntityTag")) {
            CompoundTag tag = stack.getTag().getCompound("BlockEntityTag");
            lines.add(new LiteralText(""));
            lines.add(new TranslatableText("ui.galacticraft-rewoven.machine.current_energy", tag.getInt("Energy")).setStyle(Style.EMPTY.withColor(Formatting.AQUA)));
            lines.add(new TranslatableText("ui.galacticraft-rewoven.tabs.security_config.owner", tag.getString("OwnerUsername")).setStyle(Style.EMPTY.withColor(Formatting.BLUE)));
            if (tag.getBoolean("Public")) {
                lines.add(new TranslatableText("ui.galacticraft-rewoven.tabs.security_config_2").setStyle(Style.EMPTY
                        .withColor(Formatting.GRAY)).append(new TranslatableText("ui.galacticraft-rewoven.tabs.security_config.public_2")
                        .setStyle(Style.EMPTY.withColor(Formatting.GREEN))));

            } else if (tag.getBoolean("Party")) {
                lines.add(new TranslatableText("ui.galacticraft-rewoven.tabs.security_config_2").setStyle(Style.EMPTY
                        .withColor(Formatting.GRAY)).append(new TranslatableText("ui.galacticraft-rewoven.tabs.security_config.space_race_2")
                        .setStyle(Style.EMPTY.withColor(Formatting.DARK_GRAY))));

            } else {
                lines.add(new TranslatableText("ui.galacticraft-rewoven.tabs.security_config_2").setStyle(Style.EMPTY
                        .withColor(Formatting.GRAY)).append(new TranslatableText("ui.galacticraft-rewoven.tabs.security_config.private_2")
                        .setStyle(Style.EMPTY.withColor(Formatting.DARK_RED))));

            }

            if (tag.getString("Redstone").equals("DISABLED")) {
                lines.add(new TranslatableText("ui.galacticraft-rewoven.tabs.redstone_activation_config_2").setStyle(Style.EMPTY.withColor(Formatting.RED)).append(new TranslatableText("ui.galacticraft-rewoven.tabs.redstone_activation_config.ignore_2").setStyle(Style.EMPTY.withColor(Formatting.GRAY))));
            } else if (tag.getString("Redstone").equals("OFF")) {
                lines.add(new TranslatableText("ui.galacticraft-rewoven.tabs.redstone_activation_config_2").setStyle(Style.EMPTY.withColor(Formatting.RED)).append(new TranslatableText("ui.galacticraft-rewoven.tabs.redstone_activation_config.redstone_means_off_2").setStyle(Style.EMPTY.withColor(Formatting.DARK_RED))));
            } else {
                lines.add(new TranslatableText("ui.galacticraft-rewoven.tabs.redstone_activation_config_2").setStyle(Style.EMPTY.withColor(Formatting.RED)).append(new TranslatableText("ui.galacticraft-rewoven.tabs.redstone_activation_config.redstone_means_on_2").setStyle(Style.EMPTY.withColor(Formatting.DARK_RED))));
            }

        }
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.BLOCK;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        BlockEntity entity = world.getBlockEntity(pos);
        if (entity instanceof ConfigurableMachineBlockEntity) {
            for (ItemStack stack : ((ConfigurableMachineBlockEntity) entity).getInventory().getStacks()) {
                if (stack != null) {
                    world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY() + 1, pos.getZ(), stack));
                }
            }
            ((ConfigurableMachineBlockEntity) entity).getInventory().clear();
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public ItemStack getPickStack(BlockView view, BlockPos pos, BlockState state) {
        ItemStack stack = super.getPickStack(view, pos, state);
        CompoundTag tag = (stack.getTag() != null ? stack.getTag() : new CompoundTag());
        if (view.getBlockEntity(pos) != null) {
            tag.put("BlockEntityTag", view.getBlockEntity(pos).toTag(new CompoundTag()));
        }

        stack.setTag(tag);
        return stack;
    }

    public abstract Text machineInfo(ItemStack stack, BlockView view, TooltipContext context);
}
