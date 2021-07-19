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

package dev.galacticraft.mod.block.environment;

import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

/**
 * @author <a href="https://github.com/TeamGalacticraft">TeamGalacticraft</a>
 */
public class BacterialSludgeBlock extends FluidBlock {
    public BacterialSludgeBlock(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }

    //TODO: Temporary, please change when Sludgeling is added
    @Override
    public void onEntityCollision(BlockState blockState, World world, BlockPos blockPos, Entity entity) {
        if (entity instanceof LivingEntity) {
            if (entity instanceof PlayerEntity) {
                if (((PlayerEntity) entity).isCreative()) {
                    return;
                }
            }
            if (entity.getType() == EntityType.SILVERFISH)
            {
                return;
            }

            int range = 5;
            List<SilverfishEntity> sludge = world.getEntitiesByType(EntityType.SILVERFISH, new Box(blockPos.getX() - range, blockPos.getY() - range, blockPos.getZ() - range, blockPos.getX() + range, blockPos.getY() + range, blockPos.getZ() + range), EntityPredicates.VALID_ENTITY);

            if (sludge.size() < 3)
            {
                SilverfishEntity sludgeling = EntityType.SILVERFISH.create(world);
                sludgeling.refreshPositionAndAngles(blockPos.getX() + world.random.nextInt(5) - 2, blockPos.getY(), blockPos.getZ() + world.random.nextInt(5) - 2, 0F, 0F);
                world.spawnEntity(sludgeling);
            }
        }
    }
}
