package com.mobiosd.entity;

public class AttributeResult {

    AttributeResult(String name, double value) {
        this.name = name;
        this.value = value;
    }
    private String name;
    private double value;

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
