package com.mobiosd.functions;

public class Helmholtz {

    public static double A(double I , double U, double t ) {
        return I - t * U;
    }


    public static double AG(double A , int total ) {
        return A*total;
    }

}
