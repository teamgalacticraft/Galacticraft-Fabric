/*
 * Copyright (c) 2020 Team Galacticraft
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

package dev.galacticraft.mod.block.entity;

import alexiil.mc.lib.attributes.fluid.amount.FluidAmount;
import dev.galacticraft.mod.api.block.entity.MachineBlockEntity;
import dev.galacticraft.mod.api.machine.MachineStatus;
import dev.galacticraft.mod.entity.GalacticraftBlockEntities;
import dev.galacticraft.mod.screen.OxygenStorageModuleScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author <a href="https://github.com/TeamGalacticraft">TeamGalacticraft</a>
 */
public class OxygenStorageModuleBlockEntity extends MachineBlockEntity {
    private static final int OXYGEN_TANK = 0;
    public static final FluidAmount MAX_CAPACITY = FluidAmount.ofWhole(50);

    public OxygenStorageModuleBlockEntity() {
        super(GalacticraftBlockEntities.OXYGEN_STORAGE_MODULE_TYPE);
    }

    @Override
    public FluidAmount getFluidTankCapacity() {
        return MAX_CAPACITY;
    }

    @Override
    protected MachineStatus getStatusById(int index) {
        return MachineStatus.NULL;
    }

    @Override
    public void updateComponents() {
        super.updateComponents();
        this.trySpreadFluids(OXYGEN_TANK);
    }

    @Override
    public @NotNull MachineStatus updateStatus() {
        return MachineStatus.NULL;
    }

    @Override
    public void tickWork() {
    }

    @Override
    public int getEnergyCapacity() {
        return 0;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        if (this.getSecurity().hasAccess(player)) return new OxygenStorageModuleScreenHandler(syncId, player, this);
        return null;
    }
}
