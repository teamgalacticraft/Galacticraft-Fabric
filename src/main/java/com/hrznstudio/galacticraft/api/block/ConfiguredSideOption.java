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

package com.hrznstudio.galacticraft.api.block;

import com.hrznstudio.galacticraft.attribute.Automatable;
import com.hrznstudio.galacticraft.attribute.fluid.MachineFluidInv;
import com.hrznstudio.galacticraft.screen.slot.SlotType;
import com.mojang.datafixers.util.Either;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.IntStream;

public class ConfiguredSideOption {
    private AutomationType automationType; //input, output, fluid
    private Either<Integer, SlotType> matching;

    public ConfiguredSideOption(@NotNull AutomationType automationType) {
        this.automationType = automationType;
        this.matching = null;
    }

    public void setOption(@NotNull AutomationType option, @Nullable Either<Integer, SlotType> matching) {
        this.automationType = option;
        this.matching = matching;
    }

    public void setMatching(@Nullable Either<Integer, SlotType> matching) {
        this.matching = matching;
    }

    public @NotNull AutomationType getAutomationType() {
        return automationType;
    }

    public int[] getMatchingFluid(MachineFluidInv machineFluidInv, AutomationType automationType) {
        assert this.automationType.isFluid();
        if (matching.left().isPresent()) {
            return new int[]{matching.left().get()};
        }
        SlotType type = matching.right().orElseThrow(RuntimeException::new);

        if (type == null) {
            IntList intList = new IntArrayList();
            for (int i = 0; i < machineFluidInv.getTankCount(); i++) {
                if (machineFluidInv.getTypes().get(i).getType().canPassAs(automationType)) {
                    intList.add(i);
                }
            }
            return intList.toIntArray();
        }

    }

    public int[] getMatching(Automatable automatable) {
        if (matching.left().isPresent()) {
            return new int[]{matching.left().get()};
        }
        SlotType type = matching.right().orElseThrow(RuntimeException::new);
        if (type == null) {
            return IntStream.range(0, automatable.getTypes().size() - 1).toArray();
        }
        if (type.getType() == AutomationType.NONE) return new int[0];

        IntList intList = new IntArrayList(1);
        for (int i = 0; i < automatable.getTypes().size(); i++) {
            if (automatable.getTypes().get(i) == type) intList.add(i);
        }
        return intList.toIntArray();
    }

    public CompoundTag toTag(CompoundTag tag) {
        tag.putString("option", automationType.name());
        tag.putBoolean("left", this.matching.left().isPresent());
        if (this.matching.left().isPresent()) {
            tag.putInt("value", this.matching.left().get());
        } else {
            tag.putString("value", this.matching.right().orElseThrow(RuntimeException::new).getId().toString());
        }
        return tag;
    }

    public void fromTag(CompoundTag tag) {
        this.automationType = AutomationType.valueOf(tag.getString("option"));
        if (tag.getBoolean("left")) {
            this.matching = Either.left(tag.getInt("value"));
        } else {
            this.matching = Either.right(SlotType.SLOT_TYPES.get(new Identifier(tag.getString("value"))));
        }
    }

}
