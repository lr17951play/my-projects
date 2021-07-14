package com.lirui.demo.algorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        BigDecimal result = BigDecimal.ONE.subtract(
                BigDecimal.ONE.divide(
                        BigDecimal.ONE.add(BigDecimal.valueOf(ey)), 20, RoundingMode.HALF_UP)
        );
        return result.doubleValue();
    }

    /**
     * @param factor (0, 1],参数切割的粒度，越接近于 0 则最终分数越高
     * @return param (0, 20]
     * */
    private static double processParam(int day, int days, float factor) {
        BigDecimal ratio = BigDecimal.valueOf(20).multiply(
                BigDecimal.valueOf(day).divide(BigDecimal.valueOf(days), 5, RoundingMode.HALF_UP)
        );
        BigDecimal param = ratio.multiply(BigDecimal.valueOf(factor));
        return param.doubleValue();
    }

    public static void main(String[] args) {
//        System.out.println(tanh(0));
//        System.out.println(arccot(-100));

        int year = 5;
        float factor = 0.5f;
        System.out.println("----------------------- sigmoid -----------------------");
        double param;
        int days = year * 365;
        for (int day = 0; day <= days; day++) {
            param = processParam(day, days, factor);
            System.out.printf("param: %1.5f, result: %1.20f \n",param, sigmoid(param));
        }

    }

}
