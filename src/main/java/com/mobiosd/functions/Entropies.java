package com.mobiosd.functions;

import com.mobiosd.entity.Attribute;

public class Entropies {
    static double boltzmann_constant = 1.3806487999999998E-23;

    public static double round(double num) {
        return (double) Math.rint(num * 1000000) / 1000000;

    }

    public static int[] dist(Attribute attribute, int bin) {
        int valueDistribution[] = new int[bin];
        double max = attribute.getMaximun();
        double min = attribute.getMinimun();
        int size = attribute.size();

        double intervalo = max - min;

        double razon = intervalo / bin;

        for (int i = 0; i <size; i++) {
            double minTemp = min;
            int contadorBin = 0;
            double value = attribute.getValue(i);
            while (minTemp <= max && contadorBin != bin) {

                if (value >= minTemp && value < minTemp + razon) {
                    valueDistribution[contadorBin]++;
                    break;
                } else if (value == max) {
                    valueDistribution[valueDistribution.length - 1]++;
                    break;
                }
                minTemp = minTemp + razon;
                contadorBin++;
            }

        }
        return valueDistribution;
    }

    public static int[] dist(double[] values, double max, double min, int bin) {
        int valueDistribution[] = new int[bin];

        int size = values.length;
        double intervalo = max - min;

        double razon = intervalo / bin;

        for (int i = 0; i <size; i++) {
            double minTemp = min;
            int contadorBin = 0;
            double value = values[i];
            while (minTemp <= max && contadorBin != bin) {

                if (value >= minTemp && value < minTemp + razon) {
                    valueDistribution[contadorBin]++;
                    break;
                } else if (value == max) {
                    valueDistribution[valueDistribution.length - 1]++;
                    break;
                }
                minTemp = minTemp + razon;
                contadorBin++;
            }

        }
        return valueDistribution;
    }


    public static double[] probdist(Attribute attribute, int bin) {
        int valueDistribution[] = dist(attribute, bin);
        return probdist(valueDistribution,attribute.size());
    }

    public static double[] probdist(int[] dist, int length) {
        double probDistArr[] = new double[length];
        for (int i = 0; i < dist.length; i++) {
            probDistArr[i] = (double) dist[i] / length;

        }
        return probDistArr;
    }

    public static double I(Attribute attribute, int bin, boolean k ) {
        if(bin == 0 ) {
            bin = attribute.size();
        }
        double constant = k ? boltzmann_constant : 1;

        double result = 0;
        double [] probDist = probdist(attribute,bin);
        for (int i = 0; i <probDist.length ; i++) {
            result += probDist[i]!=0 ? probDist[i]*Math.log10(probDist[i]): 0;
        }

        return  k? (-1)*constant*result: round( (-1)*constant*result);
    }

    public static double IG(Attribute attribute, int bin, boolean k ) {
        if(bin == 0 ) {
            bin = attribute.size();
        }
        double I = I(attribute,bin,k);

        double result = attribute.size()*I;
        return  result;
    }

    public static double Z1(Attribute attribute, int bin ) {

        double result = 1;
        int [] dist = dist(attribute,bin );
        for (int i = 0; i <dist.length ; i++) {
            result *= dist[i]!=0 ? dist[i]: 1;
        }
        return  Math.pow(result, 1/bin);
    }
    public static double Z2(Attribute attribute, int bin ) {

        double result = 0;
        int [] dist = dist(attribute,bin );
        for (int i = 0; i <dist.length ; i++) {
            result += Math.pow(dist[i],2);
        }
        return  result/attribute.size();
    }

}
