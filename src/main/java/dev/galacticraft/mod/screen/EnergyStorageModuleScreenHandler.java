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

package dev.galacticraft.mod.screen;

import dev.galacticraft.mod.block.entity.EnergyStorageModuleBlockEntity;
import dev.galacticraft.mod.screen.slot.AutoFilteredSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;

/**
 * @author <a href="https://github.com/TeamGalacticraft">TeamGalacticraft</a>
 */
public class EnergyStorageModuleScreenHandler extends MachineScreenHandler<EnergyStorageModuleBlockEntity> {
    public EnergyStorageModuleScreenHandler(int syncId, PlayerEntity player, EnergyStorageModuleBlockEntity machine) {
        super(syncId, player, machine, GalacticraftScreenHandlerTypes.ENERGY_STORAGE_MODULE_HANDLER);
        this.addSlot(new AutoFilteredSlot(machine, 0, 18 * 6 - 6, 18 + 6));
        this.addSlot(new AutoFilteredSlot(machine, 1, 18 * 6 - 6, 18 * 2 + 12));
        this.addPlayerInventorySlots(0, 84);
    }

    public EnergyStorageModuleScreenHandler(int syncId, PlayerInventory inv, PacketByteBuf buf) {
        this(syncId, inv.player, (EnergyStorageModuleBlockEntity) inv.player.world.getBlockEntity(buf.readBlockPos()));
    }
}