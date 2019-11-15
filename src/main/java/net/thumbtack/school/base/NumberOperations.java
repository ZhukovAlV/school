package net.thumbtack.school.base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberOperations {
    public static Integer find(int[] array, int value) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == value) return i;
        return null;
    }

    public static Integer find(double[] array, double value, double eps) {
        for (int i = 0; i < array.length; i++) {
            double absValue = Math.abs(array[i]);
            if (absValue == value || (absValue <= (value+eps) && absValue > value) || (absValue >= (value-eps) && absValue < value)) return i;
        }
        return null;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        if ((weight/volume) >= min && (weight/volume) <= max) return weight/volume;
        return null;
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        for (int i = 0; i < array.length; i++)
            if (array[i].equals(value)) return i;
        return null;
    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        if (weight.divide(volume).floatValue() > min.floatValue() && weight.divide(volume).floatValue() < max.floatValue()) return weight.divide(volume);
        return null;
    }
}
