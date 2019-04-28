package com.mobiosd.functions;

public class Enthalpy {
    public static double H(double entropy, double z , boolean k, double t ) {
        double constant = k ? Common.boltzmann_constant : 1;
        double temp = t!=0 ? t: 1;

        return (-1)*constant*temp*(entropy+z-1);
    }

    public static double HG(double G , int total ) {
        return G*total;
    }
}
