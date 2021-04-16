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

package dev.galacticraft.mod.item;

import dev.galacticraft.mod.Constants;
import dev.galacticraft.mod.block.GalacticraftBlocks;
import dev.galacticraft.mod.entity.GalacticraftEntityTypes;
import dev.galacticraft.mod.fluid.GalacticraftFluids;
import dev.galacticraft.mod.sound.GalacticraftSounds;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="https://github.com/TeamGalacticraft">TeamGalacticraft</a>
 */
@SuppressWarnings("unused")
public class GalacticraftItems {
    public static final List<Item> HIDDEN_ITEMS = new LinkedList<>();

    public static final Item GLOWSTONE_TORCH = registerItem(Constants.Blocks.GLOWSTONE_TORCH, new WallStandingBlockItem(GalacticraftBlocks.GLOWSTONE_TORCH, GalacticraftBlocks.GLOWSTONE_WALL_TORCH, (new Item.Settings())/*.group(GalacticraftBlocks.BLOCKS_GROUP)*/));
    public static final Item UNLIT_TORCH = registerItem(Constants.Blocks.UNLIT_TORCH, new WallStandingBlockItem(GalacticraftBlocks.UNLIT_TORCH, GalacticraftBlocks.UNLIT_WALL_TORCH, (new Item.Settings())/*.group(GalacticraftBlocks.BLOCKS_GROUP)*/));

    public static final ItemGroup ITEMS_GROUP = FabricItemGroupBuilder.create(
            new Identifier(Constants.MOD_ID, Constants.Item.ITEM_GROUP))
            .icon(() -> new ItemStack(GalacticraftItems.CANVAS))
            .build();

    // MATERIALS
    public static final Item LEAD_INGOT = registerItem(Constants.Item.LEAD_INGOT, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item RAW_SILICON = registerItem(Constants.Item.RAW_SILICON, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item RAW_METEORIC_IRON = registerItem(Constants.Item.RAW_METEORIC_IRON, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item METEORIC_IRON_INGOT = registerItem(Constants.Item.METEORIC_IRON_INGOT, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item LUNAR_SAPPHIRE = registerItem(Constants.Item.LUNAR_SAPPHIRE, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item UNREFINED_DESH = registerItem(Constants.Item.UNREFINED_DESH, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item DESH_INGOT = registerItem(Constants.Item.DESH_INGOT, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item DESH_STICK = registerItem(Constants.Item.DESH_STICK, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item CARBON_FRAGMENTS = registerItem(Constants.Item.CARBON_FRAGMENTS, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item IRON_SHARD = registerItem(Constants.Item.IRON_SHARD, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TITANIUM_SHARD = registerItem(Constants.Item.TITANIUM_SHARD, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TITANIUM_INGOT = registerItem(Constants.Item.TITANIUM_INGOT, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TITANIUM_DUST = registerItem(Constants.Item.TITANIUM_DUST, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item SOLAR_DUST = registerItem(Constants.Item.SOLAR_DUST, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item BASIC_WAFER = registerItem(Constants.Item.BASIC_WAFER, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item ADVANCED_WAFER = registerItem(Constants.Item.ADVANCED_WAFER, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item BEAM_CORE = registerItem(Constants.Item.BEAM_CORE, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item CANVAS = registerItem(Constants.Item.CANVAS, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item COMPRESSED_ALUMINUM = registerItem(Constants.Item.COMPRESSED_ALUMINUM, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item COMPRESSED_TIN = registerItem(Constants.Item.COMPRESSED_TIN, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item COMPRESSED_BRONZE = registerItem(Constants.Item.COMPRESSED_BRONZE, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item COMPRESSED_COPPER = registerItem(Constants.Item.COMPRESSED_COPPER, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item COMPRESSED_IRON = registerItem(Constants.Item.COMPRESSED_IRON, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item COMPRESSED_STEEL = registerItem(Constants.Item.COMPRESSED_STEEL, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item COMPRESSED_METEORIC_IRON = registerItem(Constants.Item.COMPRESSED_METEORIC_IRON, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item COMPRESSED_DESH = registerItem(Constants.Item.COMPRESSED_DESH, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item COMPRESSED_TITANIUM = registerItem(Constants.Item.COMPRESSED_TITANIUM, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item FLUID_MANIPULATOR = registerItem(Constants.Item.FLUID_MANIPULATOR, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item OXYGEN_CONCENTRATOR = registerItem(Constants.Item.OXYGEN_CONCENTRATOR, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item OXYGEN_FAN = registerItem(Constants.Item.OXYGEN_FAN, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item OXYGEN_VENT = registerItem(Constants.Item.OXYGEN_VENT, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item SENSOR_LENS = registerItem(Constants.Item.SENSOR_LENS, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item BLUE_SOLAR_WAFER = registerItem(Constants.Item.BLUE_SOLAR_WAFER, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item SINGLE_SOLAR_MODULE = registerItem(Constants.Item.SINGLE_SOLAR_MODULE, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item FULL_SOLAR_PANEL = registerItem(Constants.Item.FULL_SOLAR_PANEL, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item SOLAR_ARRAY_WAFER = registerItem(Constants.Item.SOLAR_ARRAY_WAFER, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item STEEL_POLE = registerItem(Constants.Item.STEEL_POLE, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item COPPER_CANISTER = registerItem(Constants.Item.COPPER_CANISTER, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TIN_CANISTER = registerItem(Constants.Item.TIN_CANISTER, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item THERMAL_CLOTH = registerItem(Constants.Item.THERMAL_CLOTH, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item ISOTHERMAL_FABRIC = registerItem(Constants.Item.ISOTHERMAL_FABRIC, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item ORION_DRIVE = registerItem(Constants.Item.ORION_DRIVE, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item ATMOSPHERIC_VALVE = registerItem(Constants.Item.ATMOSPHERIC_VALVE, new Item(new Item.Settings().group(ITEMS_GROUP)));
    //FOOD
    public static final Item MOON_BERRIES = registerItem(Constants.Item.MOON_BERRIES, new Item(new Item.Settings().food(GalacticraftFoodComponents.MOON_BERRIES).group(ITEMS_GROUP)));
    public static final Item CHEESE_CURD = registerItem(Constants.Item.CHEESE_CURD, new Item(new Item.Settings().food(GalacticraftFoodComponents.CHEESE_CURD).group(ITEMS_GROUP)));
    public static final Item CHEESE_SLICE = registerItem(Constants.Item.CHEESE_SLICE, new Item(new Item.Settings().food(GalacticraftFoodComponents.CHEESE_SLICE).group(ITEMS_GROUP)));
    public static final Item BURGER_BUN = registerItem(Constants.Item.BURGER_BUN, new Item(new Item.Settings().food(GalacticraftFoodComponents.BURGER_BUN).group(ITEMS_GROUP)));
    public static final Item GROUND_BEEF = registerItem(Constants.Item.GROUND_BEEF, new Item(new Item.Settings().food(GalacticraftFoodComponents.GROUND_BEEF).group(ITEMS_GROUP)));
    public static final Item BEEF_PATTY = registerItem(Constants.Item.BEEF_PATTY, new Item(new Item.Settings().food(GalacticraftFoodComponents.BEEF_PATTY).group(ITEMS_GROUP)));
    public static final Item CHEESEBURGER = registerItem(Constants.Item.CHEESEBURGER, new Item(new Item.Settings().food(GalacticraftFoodComponents.CHEESEBURGER).group(ITEMS_GROUP)));
    public static final Item CANNED_DEHYDRATED_APPLE = registerItem(Constants.Item.CANNED_DEHYDRATED_APPLE, new CannedFoodItem(new Item.Settings().food(GalacticraftFoodComponents.DEHYDRATED_APPLE).group(ITEMS_GROUP)));
    public static final Item CANNED_DEHYDRATED_CARROT = registerItem(Constants.Item.CANNED_DEHYDRATED_CARROT, new CannedFoodItem(new Item.Settings().food(GalacticraftFoodComponents.DEHYDRATED_CARROT).group(ITEMS_GROUP)));
    public static final Item CANNED_DEHYDRATED_MELON = registerItem(Constants.Item.CANNED_DEHYDRATED_MELON, new CannedFoodItem(new Item.Settings().food(GalacticraftFoodComponents.DEHYDRATED_MELON).group(ITEMS_GROUP)));
    public static final Item CANNED_DEHYDRATED_POTATO = registerItem(Constants.Item.CANNED_DEHYDRATED_POTATO, new CannedFoodItem(new Item.Settings().food(GalacticraftFoodComponents.DEHYDRATED_POTATO).group(ITEMS_GROUP)));
    public static final Item CANNED_BEEF = registerItem(Constants.Item.CANNED_BEEF, new CannedFoodItem(new Item.Settings().food(GalacticraftFoodComponents.CANNED_BEEF).group(ITEMS_GROUP)));
    //ROCKET PARTS
    public static final Item TIER_1_HEAVY_DUTY_PLATE = registerItem(Constants.Item.TIER_1_HEAVY_DUTY_PLATE, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TIER_2_HEAVY_DUTY_PLATE = registerItem(Constants.Item.TIER_2_HEAVY_DUTY_PLATE, new Item(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TIER_3_HEAVY_DUTY_PLATE = registerItem(Constants.Item.TIER_3_HEAVY_DUTY_PLATE, new Item(new Item.Settings().group(ITEMS_GROUP)));
    //ARMOR
    public static final Item HEAVY_DUTY_HELMET = registerItem(Constants.Item.HEAVY_DUTY_HELMET, new ArmorItem(GalacticraftArmorMaterial.HEAVY_DUTY, EquipmentSlot.HEAD, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item HEAVY_DUTY_CHESTPLATE = registerItem(Constants.Item.HEAVY_DUTY_CHESTPLATE, new ArmorItem(GalacticraftArmorMaterial.HEAVY_DUTY, EquipmentSlot.CHEST, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item HEAVY_DUTY_LEGGINGS = registerItem(Constants.Item.HEAVY_DUTY_LEGGINGS, new ArmorItem(GalacticraftArmorMaterial.HEAVY_DUTY, EquipmentSlot.LEGS, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item HEAVY_DUTY_BOOTS = registerItem(Constants.Item.HEAVY_DUTY_BOOTS, new ArmorItem(GalacticraftArmorMaterial.HEAVY_DUTY, EquipmentSlot.FEET, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item DESH_HELMET = registerItem(Constants.Item.DESH_HELMET, new ArmorItem(GalacticraftArmorMaterial.DESH, EquipmentSlot.HEAD, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item DESH_CHESTPLATE = registerItem(Constants.Item.DESH_CHESTPLATE, new ArmorItem(GalacticraftArmorMaterial.DESH, EquipmentSlot.CHEST, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item DESH_LEGGINGS = registerItem(Constants.Item.DESH_LEGGINGS, new ArmorItem(GalacticraftArmorMaterial.DESH, EquipmentSlot.LEGS, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item DESH_BOOTS = registerItem(Constants.Item.DESH_BOOTS, new ArmorItem(GalacticraftArmorMaterial.DESH, EquipmentSlot.FEET, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item TITANIUM_HELMET = registerItem(Constants.Item.TITANIUM_HELMET, new ArmorItem(GalacticraftArmorMaterial.TITANIUM, EquipmentSlot.HEAD, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item TITANIUM_CHESTPLATE = registerItem(Constants.Item.TITANIUM_CHESTPLATE, new ArmorItem(GalacticraftArmorMaterial.TITANIUM, EquipmentSlot.CHEST, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item TITANIUM_LEGGINGS = registerItem(Constants.Item.TITANIUM_LEGGINGS, new ArmorItem(GalacticraftArmorMaterial.TITANIUM, EquipmentSlot.LEGS, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item TITANIUM_BOOTS = registerItem(Constants.Item.TITANIUM_BOOTS, new ArmorItem(GalacticraftArmorMaterial.TITANIUM, EquipmentSlot.FEET, (new Item.Settings().group(ITEMS_GROUP))));
    public static final Item SENSOR_GLASSES = registerItem(Constants.Item.SENSOR_GLASSES, new ArmorItem(GalacticraftArmorMaterial.SENSOR_GLASSES, EquipmentSlot.HEAD, new Item.Settings().group(ITEMS_GROUP)));
    //TOOLS + WEAPONS
    public static final Item HEAVY_DUTY_SWORD = registerItem(Constants.Item.HEAVY_DUTY_SWORD, new SwordItem(GalacticraftToolMaterial.STEEL, 3, -2.4F, new Item.Settings().group(ITEMS_GROUP)) {
        @Override
        public boolean postMine(ItemStack stack, World world, BlockState blockState, BlockPos blockPos, LivingEntity entityLiving) {
            //Stronger than vanilla
            if (blockState.getHardness(world, blockPos) > 0.2001F) {
                stack.damage(2, entityLiving, (livingEntity) -> livingEntity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            }
            return true;
        }
    });
    public static final Item HEAVY_DUTY_SHOVEL = registerItem(Constants.Item.HEAVY_DUTY_SHOVEL, new ShovelItem(GalacticraftToolMaterial.STEEL, -1.5F, -3.0F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item HEAVY_DUTY_PICKAXE = registerItem(Constants.Item.HEAVY_DUTY_PICKAXE, new PickaxeItem(GalacticraftToolMaterial.STEEL, 1, -2.8F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item HEAVY_DUTY_AXE = registerItem(Constants.Item.HEAVY_DUTY_AXE, new AxeItem(GalacticraftToolMaterial.STEEL, 6.0F, -3.1F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item HEAVY_DUTY_HOE = registerItem(Constants.Item.HEAVY_DUTY_HOE, new HoeItem(GalacticraftToolMaterial.STEEL, -2, -1.0F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item DESH_SWORD = registerItem(Constants.Item.DESH_SWORD, new SwordItem(GalacticraftToolMaterial.DESH, 3, -2.4F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item DESH_SHOVEL = registerItem(Constants.Item.DESH_SHOVEL, new ShovelItem(GalacticraftToolMaterial.DESH, -1.5F, -3.0F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item DESH_PICKAXE = registerItem(Constants.Item.DESH_PICKAXE, new PickaxeItem(GalacticraftToolMaterial.DESH, 1, -2.8F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item DESH_AXE = registerItem(Constants.Item.DESH_AXE, new AxeItem(GalacticraftToolMaterial.DESH, 6.0F, -3.1F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item DESH_HOE = registerItem(Constants.Item.DESH_HOE, new HoeItem(GalacticraftToolMaterial.DESH, -3, -1.0F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TITANIUM_SWORD = registerItem(Constants.Item.TITANIUM_SWORD, new SwordItem(GalacticraftToolMaterial.TITANIUM, 3, -2.4F, new Item.Settings().group(ITEMS_GROUP)) {
        @Override
        public boolean postMine(ItemStack stack, World world, BlockState blockState, BlockPos blockPos, LivingEntity entityLiving) {
            //Stronger than vanilla
            if (blockState.getHardness(world, blockPos) > 0.2001F) {
                stack.damage(2, entityLiving, (livingEntity) -> livingEntity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            }
            return true;
        }
    });
    public static final Item TITANIUM_SHOVEL = registerItem(Constants.Item.TITANIUM_SHOVEL, new ShovelItem(GalacticraftToolMaterial.TITANIUM, -1.5F, -3.0F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TITANIUM_PICKAXE = registerItem(Constants.Item.TITANIUM_PICKAXE, new PickaxeItem(GalacticraftToolMaterial.TITANIUM, 1, -2.8F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TITANIUM_AXE = registerItem(Constants.Item.TITANIUM_AXE, new AxeItem(GalacticraftToolMaterial.TITANIUM, 6.0F, -3.1F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TITANIUM_HOE = registerItem(Constants.Item.TITANIUM_HOE, new HoeItem(GalacticraftToolMaterial.TITANIUM, -3, -1.0F, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item STANDARD_WRENCH = registerItem(Constants.Item.STANDARD_WRENCH, new StandardWrenchItem(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item BATTERY = registerItem(Constants.Item.BATTERY, new BatteryItem(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item INFINITE_BATTERY = registerItem(Constants.Item.INFINITE_BATTERY, new InfiniteBatteryItem(new Item.Settings().group(ITEMS_GROUP).rarity(Rarity.EPIC)));
    //Fluid buckets
    public static final BucketItem CRUDE_OIL_BUCKET = registerItem(Constants.Item.CRUDE_OIL_BUCKET, new BucketItem(GalacticraftFluids.CRUDE_OIL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(ITEMS_GROUP)));
    public static final BucketItem FUEL_BUCKET = registerItem(Constants.Item.FUEL_BUCKET, new BucketItem(GalacticraftFluids.FUEL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(ITEMS_GROUP)));
    //GC INVENTORY
    private static final Item.Settings PARACHUTE_SETTINGS = new Item.Settings().group(ITEMS_GROUP).maxCount(1);
    public static final Item PARACHUTE = registerItem(Constants.Item.PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item ORANGE_PARACHUTE = registerItem(Constants.Item.ORANGE_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item MAGENTA_PARACHUTE = registerItem(Constants.Item.MAGENTA_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item LIGHT_BLUE_PARACHUTE = registerItem(Constants.Item.LIGHT_BLUE_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item YELLOW_PARACHUTE = registerItem(Constants.Item.YELLOW_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item LIME_PARACHUTE = registerItem(Constants.Item.LIME_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item PINK_PARACHUTE = registerItem(Constants.Item.PINK_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item GRAY_PARACHUTE = registerItem(Constants.Item.GRAY_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item LIGHT_GRAY_PARACHUTE = registerItem(Constants.Item.LIGHT_GRAY_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item CYAN_PARACHUTE = registerItem(Constants.Item.CYAN_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item PURPLE_PARACHUTE = registerItem(Constants.Item.PURPLE_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item BLUE_PARACHUTE = registerItem(Constants.Item.BLUE_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item BROWN_PARACHUTE = registerItem(Constants.Item.BROWN_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item GREEN_PARACHUTE = registerItem(Constants.Item.GREEN_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item RED_PARACHUTE = registerItem(Constants.Item.RED_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item BLACK_PARACHUTE = registerItem(Constants.Item.BLACK_PARACHUTE, new Item(PARACHUTE_SETTINGS));
    public static final Item OXYGEN_MASK = registerItem(Constants.Item.OXYGEN_MASK, new OxygenMaskItem(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item OXYGEN_GEAR = registerItem(Constants.Item.OXYGEN_GEAR, new OxygenGearItem(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item SHIELD_CONTROLLER = registerItem(Constants.Item.SHIELD_CONTROLLER, new GCAccessories(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item FREQUENCY_MODULE = registerItem(Constants.Item.FREQUENCY_MODULE, new GCAccessories(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item SMALL_OXYGEN_TANK = registerItem(Constants.Item.SMALL_OXYGEN_TANK, new OxygenTankItem(new Item.Settings().group(ITEMS_GROUP), 1620 * 10)); // 16200 ticks
    public static final Item MEDIUM_OXYGEN_TANK = registerItem(Constants.Item.MEDIUM_OXYGEN_TANK, new OxygenTankItem(new Item.Settings().group(ITEMS_GROUP), 1620 * 20)); //32400 ticks
    public static final Item LARGE_OXYGEN_TANK = registerItem(Constants.Item.LARGE_OXYGEN_TANK, new OxygenTankItem(new Item.Settings().group(ITEMS_GROUP), 1620 * 30)); //48600 ticks
    public static final Item INFINITE_OXYGEN_TANK = registerItem(Constants.Item.INFINITE_OXYGEN_TANK, new OxygenTankItem(new Item.Settings().group(ITEMS_GROUP), 0));
    public static final Item THERMAL_PADDING_HELMET = registerItem(Constants.Item.THERMAL_PADDING_HELMET, new ThermalArmorItem(new Item.Settings().group(ITEMS_GROUP), EquipmentSlot.HEAD));
    public static final Item THERMAL_PADDING_CHESTPIECE = registerItem(Constants.Item.THERMAL_PADDING_CHESTPIECE, new ThermalArmorItem(new Item.Settings().group(ITEMS_GROUP), EquipmentSlot.CHEST));
    public static final Item THERMAL_PADDING_LEGGINGS = registerItem(Constants.Item.THERMAL_PADDING_LEGGINGS, new ThermalArmorItem(new Item.Settings().group(ITEMS_GROUP), EquipmentSlot.LEGS));
    public static final Item THERMAL_PADDING_BOOTS = registerItem(Constants.Item.THERMAL_PADDING_BOOTS, new ThermalArmorItem(new Item.Settings().group(ITEMS_GROUP), EquipmentSlot.FEET));
    public static final Item TIER_2_ROCKET_SCHEMATIC = registerItem(Constants.Item.TIER_2_ROCKET_SCHEMATIC, new SchematicItem(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item CARGO_ROCKET_SCHEMATIC = registerItem(Constants.Item.CARGO_ROCKET_SCHEMATIC, new SchematicItem(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item MOON_BUGGY_SCHEMATIC = registerItem(Constants.Item.MOON_BUGGY_SCHEMATIC, new SchematicItem(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item TIER_3_ROCKET_SCHEMATIC = registerItem(Constants.Item.TIER_3_ROCKET_SCHEMATIC, new SchematicItem(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item ASTRO_MINER_SCHEMATIC = registerItem(Constants.Item.ASTRO_MINER_SCHEMATIC, new SchematicItem(new Item.Settings().group(ITEMS_GROUP)));
    // SPAWN EGGS
    public static final Item MOON_VILLAGER_SPAWN_EGG = registerItem(Constants.Item.MOON_VILLAGER_SPAWN_EGG, new SpawnEggItem(GalacticraftEntityTypes.MOON_VILLAGER, 0xC0C9C0, 0x5698D8, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item EVOLVED_ZOMBIE_SPAWN_EGG = registerItem(Constants.Item.EVOLVED_ZOMBIE_SPAWN_EGG, new SpawnEggItem(GalacticraftEntityTypes.EVOLVED_ZOMBIE, 0xC0CCC0, 0x99EE99, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item EVOLVED_EVOKER_SPAWN_EGG = registerItem(Constants.Item.EVOLVED_EVOKER_SPAWN_EGG, new SpawnEggItem(GalacticraftEntityTypes.EVOLVED_EVOKER, 0x888888, 0xDDDDDD, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item EVOLVED_VINDICATOR_SPAWN_EGG = registerItem(Constants.Item.EVOLVED_VINDICATOR_SPAWN_EGG, new SpawnEggItem(GalacticraftEntityTypes.EVOLVED_VINDICATOR, 0x888888, 0xDDDDDD, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item EVOLVED_CREEPER_SPAWN_EGG = registerItem(Constants.Item.EVOLVED_CREEPER_SPAWN_EGG, new SpawnEggItem(GalacticraftEntityTypes.EVOLVED_CREEPER, 0x6AFF8A, 0x99EE99, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item EVOLVED_SPIDER_SPAWN_EGG = registerItem(Constants.Item.EVOLVED_SPIDER_SPAWN_EGG, new SpawnEggItem(GalacticraftEntityTypes.EVOLVED_SPIDER, 0xEE9999, 0x99EE99, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item EVOLVED_PILLAGER_SPAWN_EGG = registerItem(Constants.Item.EVOLVED_PILLAGER_SPAWN_EGG, new SpawnEggItem(GalacticraftEntityTypes.EVOLVED_PILLAGER, 0x888888, 0xDDDDDD, new Item.Settings().group(ITEMS_GROUP)));
    public static final Item EVOLVED_SKELETON_SPAWN_EGG = registerItem(Constants.Item.EVOLVED_SKELETON_SPAWN_EGG, new SpawnEggItem(GalacticraftEntityTypes.EVOLVED_SKELETON, 0x888888, 0xDDDDDD, new Item.Settings().group(ITEMS_GROUP)));
    // THROWABLE METEOR CHUNKS
    public static final Item THROWABLE_METEOR_CHUNK = registerItem(Constants.Item.THROWABLE_METEOR_CHUNK, new ThrowableMeteorChunkItem(new Item.Settings().group(ITEMS_GROUP)));
    public static final Item HOT_THROWABLE_METEOR_CHUNK = registerItem(Constants.Item.HOT_THROWABLE_METEOR_CHUNK, new HotThrowableMeteorChunkItem(new Item.Settings().group(ITEMS_GROUP)));

    public static final Item LEGACY_MUSIC_DISC_MARS = registerItem(Constants.Item.LEGACY_MUSIC_DISC_MARS, new MusicDiscItem(15, GalacticraftSounds.MUSIC_LEGACY_MARS, new Item.Settings().maxCount(1).group(ITEMS_GROUP).rarity(Rarity.RARE)));
    public static final Item LEGACY_MUSIC_DISC_MIMAS = registerItem(Constants.Item.LEGACY_MUSIC_DISC_MIMAS, new MusicDiscItem(15, GalacticraftSounds.MUSIC_LEGACY_MIMAS, new Item.Settings().maxCount(1).group(ITEMS_GROUP).rarity(Rarity.RARE)));
    public static final Item LEGACY_MUSIC_DISC_ORBIT = registerItem(Constants.Item.LEGACY_MUSIC_DISC_ORBIT, new MusicDiscItem(15, GalacticraftSounds.MUSIC_LEGACY_ORBIT, new Item.Settings().maxCount(1).group(ITEMS_GROUP).rarity(Rarity.RARE)));
    public static final Item LEGACY_MUSIC_DISC_SPACERACE = registerItem(Constants.Item.LEGACY_MUSIC_DISC_SPACERACE, new MusicDiscItem(15, GalacticraftSounds.MUSIC_LEGACY_SPACERACE, new Item.Settings().maxCount(1).group(ITEMS_GROUP).rarity(Rarity.RARE)));

    private static <T extends Item> T registerItem(String id, T item) {
        return Registry.register(Registry.ITEM, new Identifier(Constants.MOD_ID, id), item);
    }
    
    public static void register() {
    }
}
