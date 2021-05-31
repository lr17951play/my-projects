package com.lirui.demo.algorithm;

import java.math.BigDecimal;

public class TanhDemo {

    /**
     * y = tanh(x)
     */
    public static double test1(double param) {
        param = -100 + 10 * param;
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
    public static double test3(double param) {
        return (Math.PI/2 - Math.atan(param)) / Math.PI;
    }

    public static double test2(int value){
        BigDecimal e = new BigDecimal(Math.E);
        // e^x
        BigDecimal ex = e.pow(value);
        //e^(-x)
        BigDecimal ey = BigDecimal.ONE.divide(e.pow(value));
        BigDecimal sinhx = ex.subtract(ey);
        BigDecimal coshx = ex.add(ey);
        BigDecimal result = sinhx.divide(coshx).multiply(BigDecimal.valueOf(-1));
        return result.doubleValue();
    }



    public static void main(String[] args) {
        System.out.println(test1(-100));
        System.out.println(test3(-100));
    }
}
