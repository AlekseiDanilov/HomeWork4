package com.epam.javauniversity.hw4;

public class Matrix {
    int[][] array;
    int n;
    int m;

    public Matrix() {
    }

    public Matrix(int[][] array) {
        if (isMatrix(array)) {
            this.array = array;
            n = numberLine(array);
            m = numberColumns(array);
        }
    }

    public int getElement(int i, int j) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return 0xFFFF;
        }
        return array[i][j];
    }

    public void setElement(int i, int j, int value) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return;
        }
        array[i][j] = value;

    }

    public void addition(Matrix matrix) {
        if (this.n == matrix.n && this.m == matrix.m) {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++) {
                    this.array[i][j] += matrix.array[i][j];
                }
            }
        }
    }
    public boolean isMatrix(int[][] array) {
        if (array == null) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return false;
            }
        }
        if (array[0].length == 0) {
            return false;
        }
        int numberElementInLine = array[0].length;
        for (int i = 1; i < array.length; i++) {
            if (array[i].length != numberElementInLine) {
                return false;
            }
        }
        return true;
    }

    private int numberLine(int[][] matrix) {
        return matrix.length;
    }

    private int numberColumns(int[][] array) {
        return array[0].length;
    }
}
