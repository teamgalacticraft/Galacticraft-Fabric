/*
 * Copyright (c) 2019-2021 HRZN LTD
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

package com.hrznstudio.galacticraft.block.entity;

import com.hrznstudio.galacticraft.Galacticraft;
import com.hrznstudio.galacticraft.api.block.entity.MachineBlockEntity;
import com.hrznstudio.galacticraft.api.machine.MachineStatus;
import com.hrznstudio.galacticraft.entity.GalacticraftBlockEntities;
import com.hrznstudio.galacticraft.screen.EnergyStorageModuleScreenHandler;
import com.hrznstudio.galacticraft.screen.slot.SlotType;
import com.hrznstudio.galacticraft.util.EnergyUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.Tickable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author <a href="https://github.com/StellarHorizons">StellarHorizons</a>
 */
public class EnergyStorageModuleBlockEntity extends MachineBlockEntity implements Tickable {
    public static final int CHARGE_BATTERY_SLOT = 0;
    public static final int DRAIN_BATTERY_SLOT = 1;

    public EnergyStorageModuleBlockEntity() {
        super(GalacticraftBlockEntities.ENERGY_STORAGE_MODULE_TYPE);
        this.setStatus(MachineStatus.NULL);
        this.getInventory().addSlot(SlotType.CHARGE, EnergyUtils.IS_EXTRACTABLE, 102, 24);
        this.getInventory().addSlot(SlotType.CHARGE, EnergyUtils.IS_INSERTABLE, 102, 48);
    }

    @Override
    public boolean canExtractEnergy() {
        return true;
    }

    @Override
    public boolean canInsertEnergy() {
        return true;
    }

    @Override
    public int getEnergyCapacity() {
        return Galacticraft.CONFIG_MANAGER.get().energyStorageModuleStorageSize();
    }

    @Override
    protected MachineStatus getStatusById(int index) {
        return MachineStatus.NULL;
    }

    @Override
    protected int getBatteryTransferRate() {
        return 100;
    }

    @Override
    public @NotNull MachineStatus updateStatus() {
        return MachineStatus.NULL;
    }

    @Override
    public void tickWork() {
    }

    @Override
    public void updateComponents() {
        super.updateComponents();
        this.attemptChargeFromStack(DRAIN_BATTERY_SLOT);
        this.attemptDrainPowerToStack(CHARGE_BATTERY_SLOT);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        if (this.getSecurity().hasAccess(player)) return new EnergyStorageModuleScreenHandler(syncId, player, this);
        return null;
    }
}
