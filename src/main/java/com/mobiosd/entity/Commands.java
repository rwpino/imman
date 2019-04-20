package com.mobiosd.entity;

public class Commands {
    private String path = null;
    private int bin  = 0;
    private double temperature = 1;
    private boolean ignoreFirst = false;
    private boolean k = false;
    private boolean z = false;

    public boolean getZ() {
        return z;
    }

    public void setZ(boolean z) {
        this.z = z;
    }

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

    public void setIgnoreFirst(boolean ignoreFirst) {
        this.ignoreFirst = ignoreFirst;
    }

    public boolean getK() {
        return k;
    }

    public void setK(boolean k) {
        this.k = k;
    }

    public boolean getIgnoreFirst() { return ignoreFirst; }


}
