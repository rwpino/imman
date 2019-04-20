package com.mobiosd.functions;

import com.mobiosd.entity.Attribute;
import com.mobiosd.entity.AttributeResult;

public class Entropies {
    double boltzmann_constant = 1.3806488 * Math.pow(10, -23);

    public static int[] getValueDistribution(Attribute attribute, int bin) {
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



    public static double[] getProbabilityDistribution(Attribute attribute, int bin) {
        int valueDistribution[] = getValueDistribution(attribute, bin);
        double probabilityDistribution[] = new double[valueDistribution.length];
        for (int i = 0; i < valueDistribution.length; i++) {
            probabilityDistribution[i] = (double) valueDistribution[i] / attribute.size();

        }

        return probabilityDistribution;
    }

    public static AttributeResult ShannonEntropy(Attribute attribute, int bin, boolean k ) {
        if(bin == 0 ) {
            bin = attribute.size();
        }
        AttributeResult result = null;
        return  result;
    }


}
