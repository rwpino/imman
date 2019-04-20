package com.mobiosd.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DataSet implements Iterable<Attribute> {
    private int attributes_count = 0;

    private int attribute_size = 0;

    private ArrayList<Attribute> attributes = new ArrayList<Attribute>();

    public void setNumberOfAttributes(int number) {
        this.attributes_count = number;
    }

    public void addAttribute(String name) {
        Attribute att = new Attribute(name);
        this.attributes.add(att);
    }

    public void increaseSize() {
        this.attribute_size++ ;
    }

    public void addValueToAttribute(int pos, double value) throws Exception {
        if(this.attributes.get(pos)==null) {
            throw new Exception("non existing attribute");
        }
        this.attributes.get(pos).addValue(value);

    }

    public int getAttribute_size() {
        return attribute_size;
    }

    public int getAttributes_count() {
        return attributes_count;
    }

    public Attribute getAttribute(int index) {
        return this.attributes.get(index);
    }

    @Override
    public Iterator iterator() {
        return this.attributes.iterator();
    }

    @Override
    public void forEach(Consumer action) {
        this.attributes.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return this.attributes.spliterator();
    }
}
