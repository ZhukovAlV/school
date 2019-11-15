package net.thumbtack.school.introduction;

import java.util.stream.IntStream;

public class FirstSteps {
    public int sum(int x, int y) {
        return x+y;
    }
    public int mul(int x, int y) {
        return x*y;
    }
    public int div(int x, int y) {
        checknull (x,y);
        return x/y;
    }
    public int mod(int x, int y) {
        checknull (x,y);
        return x%y;
    }
    private void checknull (int x, int y) {
        try {
            int z = x/y;
        } catch (ArithmeticException e) {
            System.out.print("Ошибка деления на 0");
        }
    }
    public boolean isEqual(int x, int y) {
        return x==y;
    }
    public boolean isGreater(int x, int y) {
        return x>y;
    }
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return xLeft<=x && x<=xRight && yTop<=y && y<=yBottom ;
    }
    public int sum(int[] array) {
        int sum = 0;
        for (int anArray : array) {
            sum += anArray;
        }
        return sum;
    }
    public int mul(int[] array) {
        int sum = 0;
        if (array.length>0) {
            sum = 1;
            for (int anArray : array) {
                sum *= anArray;
            }
        }
        return sum;
    }
    public int min(int[] array) {
        int min=Integer.MAX_VALUE;
        if (array.length>0) {
            min = array[0];
            for (int anArray : array) {
                if (anArray < min) {
                    min = anArray;
                }
            }
        }
        return min;
    }
    public int max(int[] array) {
        int max=Integer.MIN_VALUE;
        if (array.length>0) {
            max = array[0];
            for (int anArray : array) {
                if (anArray > max) {
                    max = anArray;
                }
            }
        }
        return max;
    }
    public double average(int[] array) {
        double average = 0;
        if (array.length>0) {
            for (int anArray : array) {
                average += anArray;
            }
            average = average/array.length;
        }
        return average;
    }
    public boolean isSortedDescendant(int[] array) {
        if ((array.length == 0) || (array.length == 1)) {
            return true;
        } else {
            for(int i = 0; i < array.length - 1; i++){
                if (array[i] <= array[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    }
    public void cube(int[]array) {
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) Math.pow(array[i], 3);
            }
        }
    }
    public boolean find(int[]array, int value) {
        if (array.length>0) {
            for (int anArray : array) {
                if (anArray == value) return true;
            }
            return false;
        } else return false;
    }

    public void reverse(int[]array) {
        if (array.length>0) {
            IntStream.range(0, array.length / 2).forEach(i -> {
                int temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            });
        }
    }
    public boolean isPalindrome(int[]array) {
        for (int i = 0; i < array.length / 2; ++i)
            if (array[i] != array[array.length - 1 - i])
                return false;
        return true;
    }
    public int sum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum += matrix[0][i];
            for (int j = 1; j <  matrix.length; j++) {
                sum += matrix[j][i];
            }
        }
        return sum;
    }
    public int max(int[][] matrix) {
        if ((matrix.length == 0) || (matrix.length == 1))
            return Integer.MIN_VALUE;;
        int max = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (max <= (matrix[0][i])) max=(matrix[0][i]);
            for (int j = 1; j <  matrix.length; j++) {
                if (max <= (matrix[j][i])) max=(matrix[j][i]);
            }
        }
        return max;
    }
    public int diagonalMax(int[][] matrix) {
        if ((matrix.length == 0) || (matrix.length == 1))
            return Integer.MIN_VALUE;;
        int diagonalMax = 0;
        for (int i = 0, j = 0; i < matrix[0].length-1 || j < matrix.length-1; i++,j++) {
            if ((matrix[i][j]) <= (matrix[i+1][j+1])) diagonalMax=(matrix[i+1][j+1]);
        }
        return diagonalMax;
    }
    public boolean isSortedDescendant(int[][] matrix) {
        if ((matrix.length == 0) || (matrix.length == 1)) {
            return true;
        } else {
            for (int j = 0; j < matrix.length; j++) {
                return isSortedDescendant(matrix[j]);
            }
            return true;
        }
    }
}
