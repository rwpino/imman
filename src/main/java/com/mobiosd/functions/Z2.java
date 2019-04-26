package com.mobiosd.functions;

import com.mobiosd.entity.Attribute;

public class Z2 {

    public static double Z2(Attribute attribute, int bin ) {

        double result = 0;
        int [] dist = Common.dist(attribute,bin );
        for (int i = 0; i <dist.length ; i++) {
            result += Math.pow(dist[i],2);
        }
        return  result/attribute.size();
    }

    public static double Z2(int [] dist, int total ) {

        double result = 0;
        for (int i = 0; i <dist.length ; i++) {
            result += Math.pow(dist[i],2);
        }
        return  result/total;
    }

    public static double Z2(int [] dist) {
        int total = Common.sum(dist);
        double result = 0;
        for (int i = 0; i <dist.length ; i++) {
            result += Math.pow(dist[i],2);
        }
        return  result/total;
    }
}
