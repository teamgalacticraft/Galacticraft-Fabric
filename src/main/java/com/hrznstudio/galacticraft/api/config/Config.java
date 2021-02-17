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

package com.hrznstudio.galacticraft.api.config;

/**
 * @author <a href="https://github.com/StellarHorizons">StellarHorizons</a>
 */
public interface Config {

    static Config getInstance() {
        return ConfigManager.getInstance().get();
    }

    boolean isDebugLogEnabled();

    void setDebugLog(boolean flag);

    double wireTransferLimit();

    void setWireTransferLimit(double amount);

    double heavyWireTransferLimit();

    void setHeavyWireTransferLimit(double amount);

    double coalGeneratorEnergyProductionRate();

    void setCoalGeneratorEnergyProductionRate(double amount);

    double solarPanelEnergyProductionRate();

    void setSolarPanelEnergyProductionRate(double amount);

    double circuitFabricatorEnergyConsumptionRate();

    void setCircuitFabricatorEnergyConsumptionRate(double amount);

    double electricCompressorEnergyConsumptionRate();

    void setElectricCompressorEnergyConsumptionRate(double amount);

    double electricArcFurnaceEnergyConsumptionRate();

    void setElectricArcFurnaceEnergyConsumptionRate(double amount);

    double oxygenCollectorEnergyConsumptionRate();

    void setOxygenCollectorEnergyConsumptionRate(double amount);

    double refineryEnergyConsumptionRate();

    void setRefineryEnergyConsumptionRate(double amount);

    double electricFurnaceEnergyConsumptionRate();

    void setElectricFurnaceEnergyConsumptionRate(double amount);

    double energyStorageModuleStorageSize();

    void setEnergyStorageModuleStorageSize(double amount);

    double machineEnergyStorageSize();

    void setMachineEnergyStorageSize(double amount);

    double oxygenCompressorEnergyConsumptionRate();

    void setOxygenCompressorEnergyConsumptionRate(double amount);

    double oxygenDecompressorEnergyConsumptionRate();

    void setOxygenDecompressorEnergyConsumptionRate(double amount);
}
