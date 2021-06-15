package com.lirui.demo.algorithm;

/**
 * @author Ryan
 */
public class HealthCurve {

    /**
     * y = tanh(x)
     */
    public static double tanh(double param) {
        //param = -100 + 10 * param;
        double ex = Math.exp(param);
        double ey = Math.exp(-param);
        double sinhx = ex-ey;
        double coshx = ex+ey;
        double result = (1 - sinhx/coshx) / 2;
        return result;
    }

    /**
     * y = arccot(x)
     * */
    public static double arccot(double param) {
        return (Math.PI/2 - Math.atan(param)) / Math.PI;
    }

    /**
     * y = sigmoid(x) = 1 / (1 + e^-x)
     * */
    public static double sigmoid(double param) {
        double ey = Math.exp(10 - param);
        double result = 1 - 1 / (1 + ey);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(tanh(0));
        System.out.println(arccot(-100));
        System.out.println("----------------------- sigmoid ---------------------");
        for (int i = 0; i < 21; i++) {
            System.out.println(sigmoid(i));
        }

    }
}
