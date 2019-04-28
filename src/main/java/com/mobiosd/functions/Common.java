package com.mobiosd.functions;

import com.mobiosd.entity.Attribute;

public class Common {
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

    public static double[] maxmin(double[] values) {
        double minimun = Double.POSITIVE_INFINITY;
        double maximun = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < values.length; i++) {
            double val = values[i];
            if(val <= minimun) {
                minimun = val;
            }

            if(val >= maximun) {
                maximun = val;
            }
        }
        return new double[]{minimun, maximun};

    }

    public static int[] dist(double[] values,  int bin) {
        int valueDistribution[] = new int[bin];

        int size = values.length;
        double maxmin[] = maxmin(values);
        double max = maxmin[1];
        double min = maxmin[0];
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

    public static double[] probdist(int[] dist, int total) {
        double probDistArr[] = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            probDistArr[i] = (double) dist[i] / total;

        }
        return probDistArr;
    }

    public static double[] probdist(double[] values, int bin) {
        int [] dist = dist(values, bin);
        return probdist(dist, values.length);
    }

    public static  double entropy(Attribute attribute, int bin) {
        double result = 0;
        double [] probDist = probdist(attribute,bin);
        for (int i = 0; i <probDist.length ; i++) {
            result += probDist[i]!=0 ? probDist[i]*Math.log10(probDist[i]): 0;
        }
        return result;
    }

    public static  double entropy(double [] values, int bin) {
        double result = 0;
        double [] probDist = probdist(values,bin);
        for (int i = 0; i <probDist.length ; i++) {
            result += probDist[i]!=0 ? probDist[i]*Math.log10(probDist[i]): 0;
        }
        return result;
    }

    public static  double entropy(double [] probDist) {
        double result = 0;
        for (int i = 0; i <probDist.length ; i++) {
            result += probDist[i]!=0 ? probDist[i]*Math.log10(probDist[i]): 0;
        }
        return result;
    }

    public static  double entropy(int[] dist) {
        double result = 0;
        double  [] probDist = probdist(dist,sum(dist));
        for (int i = 0; i <probDist.length ; i++) {
            result += probDist[i]!=0 ? probDist[i]*Math.log10(probDist[i]): 0;
        }
        return result;
    }

    public static  double entropy(int[] dist, int total) {
        double result = 0;
        double  [] probDist = probdist(dist,total);
        for (int i = 0; i <probDist.length ; i++) {
            result += probDist[i]!=0 ? probDist[i]*Math.log10(probDist[i]): 0;
        }
        return result;
    }

    public static int sum(int[] dist) {
        int total = 0;
        for (int i = 0; i < dist.length; i++) {
            total +=dist[i];
        }
        return total;
    }


}
