package com.mobiosd.functions;

import com.mobiosd.entity.Attribute;

public class Z1 {

    public static double Z1(Attribute attribute, int bin ) {

        double result = 1;
        int [] dist = Common.dist(attribute,bin );
        for (int i = 0; i <dist.length ; i++) {
            result *= dist[i]!=0 ? dist[i]: 1;
        }
        return  Math.pow(result, 1/bin);
    }

    public static double Z1(int [] dist ) {

        double result = 1;
        for (int i = 0; i <dist.length ; i++) {
            result *= dist[i]!=0 ? dist[i]: 1;
        }
        return  Math.pow(result, 1/dist.length);
    }

}
