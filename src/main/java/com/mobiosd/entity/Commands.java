package com.mobiosd.entity;

public class Commands {
    private String path = null;
    private int bin = 1;
    private double temperature  = 1;

    /**
     * @param bin the bin to set
     */
    public void setBin(int bin) {
        this.bin = bin;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the bin
     */
    public int getBin() {
        return bin;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return String.format("temperature: %s \n bin: %s \n path: %s \n", this.temperature, this.bin, this.path);
    }
}
