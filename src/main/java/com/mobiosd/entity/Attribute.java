package com.mobiosd.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Attribute implements Iterable<Double> {

    private String name = null;
    private ArrayList<Double> values = new ArrayList<Double>();
    private double minimun;
    private double maximun;

    Attribute( String name ) {
    this.name = name;
    }

    public void addValue(double val){
        if(val < this.minimun) {
            this.minimun = val;
        }

        if(val > this.maximun) {
            this.maximun = val;
        }

        this.values.add(val);
    }

    public double getValue(int index) {
        return this.values.get(index);
    }

    public int size() {
        return this.values.size();
    }

    public double getMaximun() {
        return maximun;
    }

    public double getMinimun() {
        return minimun;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    @Override
    public Iterator<Double> iterator() {
        return values.iterator();
    }

    @Override
    public void forEach(Consumer<? super Double> action) {
        this.values.forEach(action);
    }

    @Override
    public Spliterator<Double> spliterator() {
        return this.values.spliterator();
    }
}
