package com.mobiosd.entity;
import java.util.HashMap;



public class AttributeResult {

    private String name;

    private int index;

    private HashMap<String, Double> values;

    public AttributeResult(String name,int index) {

        this.name = name;
        this.index = index;
        this.values = new HashMap<>() ;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public void addValue(String name, double value) {
        this.values.put(name, value);
    }

    @Override
    public String toString() {
        String result = String.format("%s \t", this.name);
        Double [] values = new Double[this.values.size()];
        values =  this.values.values().toArray(values);
        for (double v:values) {
            result += String.format("%s\t", v);
        }
        return result;
    }
}
