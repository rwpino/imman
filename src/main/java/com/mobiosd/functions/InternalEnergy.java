package com.mobiosd.functions;

import com.mobiosd.entity.Attribute;

public class InternalEnergy {

    public static double U(double entropy, double z , boolean k, double t ) {
        double constant = k ? Common.boltzmann_constant : 1;
        double temp = t!=0 ? t: 1;

        return (-1)*constant*temp*(entropy+z);
    }

    public static double UG(double u , int total ) {
        return u*total;
    }

    public static double U(Attribute attribute, int bin, boolean k, double t, double z ) {
        if(bin == 0 ) {
            bin = attribute.size();
        }
        double entropy = Common.entropy(attribute,bin);
        return U(entropy, z,k,t);
    }

    public static double U(double [] values, int bin, boolean k, double t, double z ) {
        if(bin == 0 ) {
            bin = values.length;
        }
        double entropy = Common.entropy(values,bin);
        return U(entropy, z,k,t);
    }

    public static double U(double [] probDist, boolean k, double t, int total,double z ) {
        double entropy = Common.entropy(probDist,total);
        return U(entropy, z,k,t);
    }

    public static double U(int [] dist, boolean k, double t, int total,double z ) {
        double entropy = Common.entropy(dist,total);
        return U(entropy, z,k,t);
    }

    public static double U(int [] dist, boolean k, double t,double z ) {
        double entropy = Common.entropy(dist);
        return U(entropy, z,k,t);
    }

    public static double UZ1(Attribute attribute, int bin, boolean k, double t, double entropy) {
        double z =  Z1.Z1(attribute, bin);
        return  U(entropy,z,k,t);
    }

    public static double UZ1(Attribute attribute, int bin, boolean k, double t) {
        int [] dist = Common.dist(attribute, bin);
        double z =  Z1.Z1(dist);
        double entropy = Common.entropy(dist);
        return  U(entropy,z,k,t);
    }

    public static double UZ2(Attribute attribute, int bin, boolean k, double t, double entropy) {
        double z =  Z2.Z2(attribute, bin);
        return  U(entropy,z,k,t);
    }
    public static double UZ2(Attribute attribute, int bin, boolean k, double t) {
        int [] dist = Common.dist(attribute, bin);
        double z =  Z2.Z2(dist,attribute.size());
        double entropy = Common.entropy(dist);
        return  U(entropy,z,k,t);
    }



}
