/*
 * Copyright (c) 2019-2021 Team Galacticraft
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
 */

package dev.galacticraft.mod.client.model;

import dev.galacticraft.mod.Constants;
import dev.galacticraft.mod.api.block.SideOption;
import dev.galacticraft.mod.api.block.entity.ConfigurableMachineBlockEntity;
import dev.galacticraft.mod.api.block.util.BlockFace;
import dev.galacticraft.mod.block.GalacticraftBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author <a href="https://github.com/TeamGalacticraft">TeamGalacticraft</a>
 */
@Environment(EnvType.CLIENT)
public enum GCGeneratedMachineModels implements FabricBakedModel, BakedModel {
    INSTANCE;

    public static final Identifier MACHINE_MARKER = new Identifier(Constants.MOD_ID, "autogenerated/machine");
    public static final Identifier MACHINE = new Identifier(Constants.MOD_ID, "block/machine");
    public static final Identifier MACHINE_SIDE = new Identifier(Constants.MOD_ID, "block/machine_side");
    public static final Identifier MACHINE_POWER_IN = new Identifier(Constants.MOD_ID, "block/machine_power_input");
    public static final Identifier MACHINE_POWER_OUT = new Identifier(Constants.MOD_ID, "block/machine_power_output");
    public static final Identifier MACHINE_FLUID_IN = new Identifier(Constants.MOD_ID, "block/machine_fluid_input");
    public static final Identifier MACHINE_FLUID_OUT = new Identifier(Constants.MOD_ID, "block/machine_fluid_output");
    public static final Identifier MACHINE_ITEM_IN = new Identifier(Constants.MOD_ID, "block/machine_item_input");
    public static final Identifier MACHINE_ITEM_OUT = new Identifier(Constants.MOD_ID, "block/machine_item_output");

    private static Function<Identifier, Sprite> atlas;
    private static final Map<Block, ModelTextureProvider> TEXTURE_PROVIDERS = new HashMap<>();

    public static void register(Block block, ModelTextureProvider provider) {
        TEXTURE_PROVIDERS.put(block, provider);
    }

    public static void registerDefaults() {
        register(GalacticraftBlocks.ADVANCED_SOLAR_PANEL, (face, spriteFunction, view, state, pos) -> {
            switch (face) {
                case FRONT:
                case BACK:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/advanced_solar_panel"));
                default:
                    return spriteFunction.apply(MACHINE);
            }
        });

        register(GalacticraftBlocks.BASIC_SOLAR_PANEL, (face, spriteFunction, view, state, pos) -> {
            switch (face) {
                case FRONT:
                case BACK:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/basic_solar_panel"));
                default:
                    return spriteFunction.apply(MACHINE);
            }
        });

        register(GalacticraftBlocks.BUBBLE_DISTRIBUTOR, (face, spriteFunction, view, state, pos) -> spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/oxygen_bubble_distributor")));

        register(GalacticraftBlocks.CIRCUIT_FABRICATOR, (face, spriteFunction, view, state, pos) -> {
            switch (face) {
                case FRONT:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/circuit_fabricator"));
                case LEFT:
                case RIGHT:
                case BACK:
                    return spriteFunction.apply(MACHINE_SIDE);
                default:
                    return spriteFunction.apply(MACHINE);
            }
        });

        register(GalacticraftBlocks.COAL_GENERATOR, (face, spriteFunction, view, state, pos) -> {
            switch (face) {
                case FRONT:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/coal_generator"));
                case LEFT:
                case RIGHT:
                case BACK:
                    return spriteFunction.apply(MACHINE_SIDE);
                default:
                    return spriteFunction.apply(MACHINE);
            }
        });

        register(GalacticraftBlocks.ENERGY_STORAGE_MODULE, (face, spriteFunction, view, state, pos) -> {
            ConfigurableMachineBlockEntity entity = (ConfigurableMachineBlockEntity)view.getBlockEntity(pos);
            switch (face) {
                case FRONT:
                case BACK:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/energy_storage_module_" + (int) (((double) entity.getCapacitor().getEnergy() / (double) entity.getEnergyCapacity()) * 8.0D)));
                default:
                    return spriteFunction.apply(MACHINE);
            }
        });

        register(GalacticraftBlocks.OXYGEN_COLLECTOR, (face, spriteFunction, view, state, pos) -> spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/oxygen_collector")));

        register(GalacticraftBlocks.OXYGEN_COMPRESSOR, (face, spriteFunction, view, state, pos) -> {
            switch (face) {
                case FRONT:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/oxygen_compressor"));
                case BACK:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/oxygen_compressor_back"));
                case LEFT:
                case RIGHT:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/machine_side"));
                default:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/machine"));
            }
        });

        register(GalacticraftBlocks.OXYGEN_DECOMPRESSOR, (face, spriteFunction, view, state, pos) -> {
            switch (face) {
                case FRONT:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/oxygen_decompressor"));
                case BACK:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/oxygen_compressor_back"));
                case LEFT:
                case RIGHT:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/machine_side"));
                default:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/machine"));
            }
        });

        register(GalacticraftBlocks.OXYGEN_STORAGE_MODULE, (face, spriteFunction, view, state, pos) -> {
            switch (face) {
                case FRONT:
                case BACK:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/oxygen_storage_module_" + (int)(((ConfigurableMachineBlockEntity) view.getBlockEntity(pos)).getFluidTank().getInvFluid(0).getAmount_F().div(((ConfigurableMachineBlockEntity) view.getBlockEntity(pos)).getFluidTank().getMaxAmount_F(0)).asInt(8, RoundingMode.DOWN))));
                default:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/machine"));
            }
        });

        register(GalacticraftBlocks.REFINERY, (face, spriteFunction, view, state, pos) -> {
            switch (face) {
                case FRONT:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/refinery_front"));
                case LEFT:
                case RIGHT:
                    return spriteFunction.apply(MACHINE_SIDE);
                case BACK:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/refinery_back"));
                default:
                    return spriteFunction.apply(MACHINE);
            }
        });

        register(GalacticraftBlocks.OXYGEN_SEALER, (face, spriteFunction, view, state, pos) -> {
            if (face == BlockFace.TOP) {
                return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/oxygen_sealer_top"));
            }
            return spriteFunction.apply(MACHINE_SIDE);
        });

        register(GalacticraftBlocks.ELECTRIC_FURNACE, (face, spriteFunction, view, state, pos) -> {
            switch (face) {
                case FRONT:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/electric_furnace"));
                case LEFT:
                case RIGHT:
                case BACK:
                    return spriteFunction.apply(MACHINE_SIDE);
                default:
                    return spriteFunction.apply(MACHINE);
            }
        });

        register(GalacticraftBlocks.ELECTRIC_ARC_FURNACE, (face, spriteFunction, view, state, pos) -> {
            switch (face) {
                case FRONT:
                    return spriteFunction.apply(new Identifier(Constants.MOD_ID, "block/electric_furnace"));
                case LEFT:
                case RIGHT:
                case BACK:
                    return spriteFunction.apply(MACHINE_SIDE);
                default:
                    return spriteFunction.apply(MACHINE);
            }
        });
    }

    @ApiStatus.Internal
    public static void setAtlas(Function<Identifier, Sprite> function) {
        atlas = function;
    }

    @Override
    public boolean isVanillaAdapter() {
        return false;
    }

    @Override
    public void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context) {
        ConfigurableMachineBlockEntity blockEntity = ((ConfigurableMachineBlockEntity) blockView.getBlockEntity(pos));
        if (blockEntity == null) throw new RuntimeException("Failed to grab block entity!");
        if (atlas == null) {
            setAtlas(MinecraftClient.getInstance().getSpriteAtlas(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE));
        }
        context.pushTransform(quad -> {
            SideOption option = blockEntity.getSideConfiguration().get(BlockFace.toFace(state.get(Properties.HORIZONTAL_FACING), quad.nominalFace())).getOption();
            switch (option) {
                case DEFAULT:
                    Sprite sprite = TEXTURE_PROVIDERS.getOrDefault(state.getBlock(), ModelTextureProvider.DEFAULT).getSpritesForState(BlockFace.toFace(state.get(Properties.HORIZONTAL_FACING), quad.nominalFace()), atlas, blockView, state, pos);
                    quad.spriteBake(0, sprite, MutableQuadView.BAKE_LOCK_UV);
                    break;
                case FLUID_INPUT:
                    quad.spriteBake(0, atlas.apply(MACHINE_FLUID_IN), MutableQuadView.BAKE_LOCK_UV);
                    break;
                case POWER_INPUT:
                    quad.spriteBake(0, atlas.apply(MACHINE_POWER_IN), MutableQuadView.BAKE_LOCK_UV);
                    break;
                case POWER_OUTPUT:
                    quad.spriteBake(0, atlas.apply(MACHINE_POWER_OUT), MutableQuadView.BAKE_LOCK_UV);
                    break;
                case FLUID_OUTPUT:
                    quad.spriteBake(0, atlas.apply(MACHINE_FLUID_OUT), MutableQuadView.BAKE_LOCK_UV);
                    break;
                case ITEM_INPUT:
                    quad.spriteBake(0, atlas.apply(MACHINE_ITEM_IN), MutableQuadView.BAKE_LOCK_UV);
                    break;
                case ITEM_OUTPUT:
                    quad.spriteBake(0, atlas.apply(MACHINE_ITEM_OUT), MutableQuadView.BAKE_LOCK_UV);
                    break;
            }
            quad.spriteColor(0, 16777215, 16777215, 16777215, 16777215);
            return true;
        });
        context.getEmitter()
                .square(Direction.NORTH, 0, 0, 1, 1, 0).emit()
                .square(Direction.SOUTH, 0, 0, 1, 1, 0).emit()
                .square(Direction.EAST, 0, 0, 1, 1, 0).emit()
                .square(Direction.WEST, 0, 0, 1, 1, 0).emit()
                .square(Direction.UP, 0, 0, 1, 1, 0).emit()
                .square(Direction.DOWN, 0, 0, 1, 1, 0).emit();
        context.popTransform();
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context) {
        throw new RuntimeException("This shouldn't be called"); //todo - actually render item dynamically
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
        return Collections.emptyList();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean hasDepth() {
        return false;
    }

    @Override
    public boolean isSideLit() {
        return false;
    }

    @Override
    public boolean isBuiltin() {
        return false;
    }

    @Override
    public Sprite getSprite() {
        if (atlas == null) {
            atlas = MinecraftClient.getInstance().getSpriteAtlas(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE);
        }
        return atlas.apply(MACHINE);
    }

    @Override
    public ModelTransformation getTransformation() {
        return ModelTransformation.NONE;
    }

    @Override
    public ModelOverrideList getOverrides() {
        return ModelOverrideList.EMPTY;
    }

    @FunctionalInterface
    public interface ModelTextureProvider {
        ModelTextureProvider DEFAULT = (dir, func, view, state, pos) -> func.apply(MACHINE);

        @NotNull Sprite getSpritesForState(@NotNull BlockFace face, @NotNull Function<Identifier, Sprite> spriteFunction, @NotNull BlockRenderView view, @NotNull BlockState state, @NotNull BlockPos pos);
    }
}
