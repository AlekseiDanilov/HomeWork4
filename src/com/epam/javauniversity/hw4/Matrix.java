package com.epam.javauniversity.hw4;

public class Matrix {
    int[][] matrix;
    int n;
    int m;

    public Matrix() {
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        n = numberLine(matrix);
        m = numberColumns(matrix);
    }

    public int getElement(int i, int j) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return 0;
        }
        return matrix[i][j];
    }

    public void setElement(int i, int j, int value) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return;
        }
        matrix[i][j] = value;

    }

    private int numberLine(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        if (matrix.length == 0) {
            return 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                return 0;
            }
        }
        return matrix.length;
    }

    private int numberColumns(int[][] matrix) {
        int numberColumns = 0;
        if (numberLine(matrix) > 0) {
            numberColumns = matrix[0].length;
        } else {
            return 0;
        }
        for (int i = 1; i < numberLine(matrix); i++) {
            if (matrix[i].length != numberColumns) {
                return 0;
            }
        }
        return numberColumns;
    }
}
