package com.mobiosd.functions;

import com.mobiosd.entity.Attribute;

public class Entropy {


    public static double I(Attribute attribute, int bin, boolean k ) {
        if(bin == 0 ) {
            bin = attribute.size();
        }
        double constant = k ? Common.boltzmann_constant : 1;

        double result = Common.entropy(attribute, bin);

        return  k? (-1)*constant*result: Common.round( (-1)*constant*result);
    }

    public static double I(double [] values, int bin, boolean k ) {
        if(bin == 0 ) {
            bin = values.length;
        }
        double constant = k ? Common.boltzmann_constant : 1;

        double result = Common.entropy(values, bin);

        return  k? (-1)*constant*result: Common.round( (-1)*constant*result);
    }

    public static double I(double [] probDist, boolean k ) {

        double constant = k ? Common.boltzmann_constant : 1;

        double result = Common.entropy(probDist);

        return  k? (-1)*constant*result: Common.round( (-1)*constant*result);
    }

    public static double I(int [] dist, boolean k ) {

        double constant = k ? Common.boltzmann_constant : 1;

        double result = Common.entropy(dist);

        return  k? (-1)*constant*result: Common.round( (-1)*constant*result);
    }

    public static double I(int [] dist, boolean k , int total) {

        double constant = k ? Common.boltzmann_constant : 1;

        double result = Common.entropy(dist, total);

        return  k? (-1)*constant*result: Common.round( (-1)*constant*result);
    }


    public static double IG(Attribute attribute, int bin, boolean k ) {
        if(bin == 0 ) {
            bin = attribute.size();
        }
        return  attribute.size()*I(attribute,bin,k);
    }

    public static double IG(double [] values, int bin, boolean k ) {
        if(bin == 0 ) {
            bin = values.length;
        }
        return  values.length*I(values,bin,k);
    }

    public static double IG(double [] probDist,boolean k ,int total) {
        return  total*I(probDist,k);
    }

    public static double IG(int [] dist, boolean k ) {
        int total = Common.sum(dist);
        return  total*I(dist,k,  total);
    }


}
