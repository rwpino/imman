package com.mobiosd.entity;

public class Commands {
    private String path = null;
    private int bin = 1;
    private double temperature = 1;

    /**
     * @return the bin
     */
    public int getBin() {
        return bin;
    }

    /**
     * @param bin the bin to set
     */
    public void setBin(int bin) {
        this.bin = bin;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return String.format("temperature: %s \n bin: %s \n path: %s \n", this.temperature, this.bin, this.path);
    }
}
