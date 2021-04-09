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

package com.hrznstudio.galacticraft.screen.slot;

import com.hrznstudio.galacticraft.Constants;
import com.hrznstudio.galacticraft.api.block.AutomationType;
import com.hrznstudio.galacticraft.util.ColorUtils;
import com.mojang.serialization.Lifecycle;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;

import java.util.Objects;

public class SlotType implements StringIdentifiable {
    public static final Registry<SlotType> SLOT_TYPES = new SimpleRegistry<>(RegistryKey.ofRegistry(new Identifier(Constants.MOD_ID, "slot_type")), Lifecycle.experimental());
//    public static final SlotType WILDCARD = new SlotType(new Identifier(Constants.MOD_ID, "any"), TextColor.fromRgb(ColorUtils.rgb(0, 160, 7)), new TranslatableText("ui.galacticraft-rewoven.io_config.any"), AutomationType.ANY);
    public static final SlotType INPUT = new SlotType(new Identifier(Constants.MOD_ID, "input"), TextColor.fromRgb(ColorUtils.rgb(0, 160, 7)), new TranslatableText("ui.galacticraft-rewoven.io_config.input"), AutomationType.ITEM_INPUT);
    public static final SlotType FLUID_TANK_INPUT = new SlotType(new Identifier(Constants.MOD_ID, "fluid_input"), TextColor.fromRgb(ColorUtils.rgb(2, 121, 3)), new TranslatableText("ui.galacticraft-rewoven.io_config.fluid_input"), AutomationType.ITEM_INPUT);
    public static final SlotType OUTPUT = new SlotType(new Identifier(Constants.MOD_ID, "output"), TextColor.fromRgb(ColorUtils.rgb(187, 16, 18)), new TranslatableText("ui.galacticraft-rewoven.io_config.output"), AutomationType.ITEM_OUTPUT);
    public static final SlotType FLUID_TANK_OUTPUT = new SlotType(new Identifier(Constants.MOD_ID, "fluid_output"), TextColor.fromRgb(ColorUtils.rgb(149, 8, 9)), new TranslatableText("ui.galacticraft-rewoven.io_config.fluid_output"), AutomationType.ITEM_OUTPUT);
    public static final SlotType CHARGE = new SlotType(new Identifier(Constants.MOD_ID, "charge"), TextColor.fromRgb(ColorUtils.rgb(220, 196, 57)), new TranslatableText("ui.galacticraft-rewoven.io_config.charge"), AutomationType.ITEM_IO);
    public static final SlotType OXYGEN_TANK = new SlotType(new Identifier(Constants.MOD_ID, "oxygen_tank"), TextColor.fromRgb(ColorUtils.rgb(57, 119, 207)), new TranslatableText("ui.galacticraft-rewoven.io_config.oxygen_tank"), AutomationType.ITEM_IO);
    public static final SlotType OTHER = new SlotType(new Identifier(Constants.MOD_ID, "other"), TextColor.fromRgb(ColorUtils.rgb(141, 50, 199)), new TranslatableText("ui.galacticraft-rewoven.io_config.other"), AutomationType.ITEM_IO);

    public static final SlotType WILDCARD_ITEM = new SlotType(new Identifier(Constants.MOD_ID, "wildcard_item"), TextColor.fromRgb(ColorUtils.rgb(141, 50, 199)), new TranslatableText("ui.galacticraft-rewoven.io_config.wildcard_item"), AutomationType.ITEM_IO);
    public static final SlotType WILDCARD_FLUID = new SlotType(new Identifier(Constants.MOD_ID, "wildcard_fluid"), TextColor.fromRgb(ColorUtils.rgb(141, 50, 199)), new TranslatableText("ui.galacticraft-rewoven.io_config.wildcard_fluid"), AutomationType.ITEM_IO);

    public static final SlotType OIL = new SlotType(new Identifier(Constants.MOD_ID, "oil"), TextColor.fromRgb(ColorUtils.rgb(0, 0, 0)), new TranslatableText("ui.galacticraft-rewoven.io_config.oil"), AutomationType.FLUID_INPUT);
    public static final SlotType OXYGEN_IN = new SlotType(new Identifier(Constants.MOD_ID, "oxygen_in"), TextColor.fromRgb(ColorUtils.rgb(57, 119, 207)), new TranslatableText("ui.galacticraft-rewoven.io_config.oxygen_in"), AutomationType.FLUID_INPUT);
    public static final SlotType OXYGEN_OUT = new SlotType(new Identifier(Constants.MOD_ID, "oxygen_out"), TextColor.fromRgb(ColorUtils.rgb(57, 119, 207)), new TranslatableText("ui.galacticraft-rewoven.io_config.oxygen_out"), AutomationType.FLUID_OUTPUT);
    public static final SlotType OXYGEN = new SlotType(new Identifier(Constants.MOD_ID, "oxygen"), TextColor.fromRgb(ColorUtils.rgb(57, 119, 207)), new TranslatableText("ui.galacticraft-rewoven.io_config.oxygen"), AutomationType.FLUID_IO);
    public static final SlotType FUEL_OUT = new SlotType(new Identifier(Constants.MOD_ID, "fuel"), TextColor.fromRgb(ColorUtils.rgb(57, 119, 207)), new TranslatableText("ui.galacticraft-rewoven.io_config.fuel"), AutomationType.FLUID_OUTPUT);
    public static final SlotType COAL = new SlotType(new Identifier(Constants.MOD_ID, "coal"), TextColor.fromRgb(ColorUtils.rgb(2, 2, 2)), new TranslatableText("ui.galacticraft-rewoven.io_config.coal"), AutomationType.ITEM_INPUT);
    public static final SlotType NONE = new SlotType(new Identifier(Constants.MOD_ID, "none"), TextColor.fromRgb(ColorUtils.rgb(0, 0, 0)), new TranslatableText("ui.galacticraft-rewoven.io_config.none"), AutomationType.NONE);

    private final Identifier id;
    private final TextColor color;
    private final Text name;
    private final AutomationType type;

    public SlotType(Identifier id, TextColor color, TranslatableText name, AutomationType type) {
        this.id = id;
        this.color = color;
        this.name = name.setStyle(Style.EMPTY.withColor(color));
        this.type = type;
    }

    public Identifier getId() {
        return id;
    }

    public TextColor getColor() {
        return color;
    }

    public Text getName() {
        return name;
    }

    public AutomationType getType() {
        return type;
    }

    @Override
    public String asString() {
        return this.id.toString();
    }

    @Override
    public String toString() {
        return "SlotType{" +
                "id=" + id +
                ", color=" + color +
                ", name=" + name +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotType slotType = (SlotType) o;
        return getId().equals(slotType.getId()) && getColor().equals(slotType.getColor()) && getName().equals(slotType.getName()) && getType() == slotType.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getColor(), getName(), getType());
    }

    static {
        Registry.register(SLOT_TYPES, WILDCARD_ITEM.getId(), WILDCARD_ITEM);
        Registry.register(SLOT_TYPES, WILDCARD_FLUID.getId(), WILDCARD_FLUID);
        Registry.register(SLOT_TYPES, INPUT.getId(), INPUT);
        Registry.register(SLOT_TYPES, FLUID_TANK_INPUT.getId(), FLUID_TANK_INPUT);
        Registry.register(SLOT_TYPES, OUTPUT.getId(), OUTPUT);
        Registry.register(SLOT_TYPES, FLUID_TANK_OUTPUT.getId(), FLUID_TANK_OUTPUT);
        Registry.register(SLOT_TYPES, OXYGEN_TANK.getId(), OXYGEN_TANK);
        Registry.register(SLOT_TYPES, CHARGE.getId(), CHARGE);
        Registry.register(SLOT_TYPES, OTHER.getId(), OTHER);
        Registry.register(SLOT_TYPES, OIL.getId(), OIL);
        Registry.register(SLOT_TYPES, FUEL_OUT.getId(), FUEL_OUT);
    }
}
