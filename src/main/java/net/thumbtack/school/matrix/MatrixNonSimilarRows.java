package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private int[][] matrix;
    public int[][] getMatrix() {
        return matrix;
    }
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public MatrixNonSimilarRows(int[][] matrix) {
        super();
        setMatrix(matrix);
    }

    public List<int[]> getNonSimilarRows() {
        List<int[]> result = new ArrayList<>();
        // В соответствии с arrayNum(List<Set> list)  выбираются и записываются в результирующий массив нужные массивы чисел
        Set<Integer> resNum = arrayNum(arrayToListSet(getMatrix()));
        for (int i = 0; i < getMatrix().length; i++) {
            if (resNum.contains(i)) result.add((getMatrix()[i]));
        }
        return result;
    }

    // Метод делает из массива массивов чисел, массив множеств
    public List<Set> arrayToListSet(int[][] matrix) {
        List<Set> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                set.add(matrix[i][j]);
            }
            list.add(set);
        }
        return list;
    }

    // Метод выбирает порядковые номера элементов, которые удовлетворяют условию задачи
    public Set<Integer> arrayNum(List<Set> list) {
        Set<Integer> resNum = new HashSet<>();
        for(int i = 0; i < list.size(); i++) {
            int num = 0;
            for(int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) num=j;
            }
            resNum.add(num);
        }
        return resNum;
    }
}