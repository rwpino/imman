package com.mobiosd.functions;

public class Gibbs {

    public static double G(double I , double H, double t ) {
        return I - t * H;
    }


    public static double GG(double H , int total ) {
        return H*total;
    }
}
