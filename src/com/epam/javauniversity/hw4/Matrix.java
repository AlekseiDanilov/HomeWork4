package com.epam.javauniversity.hw4;

public class Matrix {
    int[][] array;
    int numberRow;
    int numberCol;

    public Matrix() {
        array = new int[][]{};
    }

    public Matrix(Matrix matrix) {
        this.numberRow = matrix.numberRow;
        this.numberCol = matrix.numberCol;
        for (int i = 0; i < numberRow; i++) {
            for (int j = 0; j < numberCol; j++) {
                this.array[i][j] = matrix.array[i][j];
            }
        }
    }

    public Matrix(int[][] array) {
        if (isMatrix(array)) {
            numberRow = getNumberRow(array);
            numberCol = getNumberCol(array);
            for (int i = 0; i < numberRow; i++) {
                for (int j = 0; j < numberCol; j++) {
                    this.array[i][j] = array[i][j];
                }
            }
        }
    }

    public int getElement(int i, int j) {
        if (i >= numberRow || j >= numberCol || i < 0 || j < 0) {
            return 0xffff;
        }
        return array[i][j];
    }

    public void setElement(int i, int j, int value) {
        if (i >= numberRow || j >= numberCol || i < 0 || j < 0) {
            return;
        }
        array[i][j] = value;

    }

    public Matrix add(Matrix matrix) {
        if (this.numberRow != matrix.numberRow || this.numberCol != matrix.numberCol) {
            return new Matrix();
        }
        Matrix result = new Matrix(new int[this.numberRow][this.numberCol]);
        for (int i = 0; i < this.numberRow; i++) {
            for (int j = 0; j < this.numberCol; j++) {
                result.array[i][j] = this.array[i][j] + matrix.array[i][j];
            }
        }
        return result;
    }

    public Matrix mul(Matrix matrix) {
        if (this.numberCol != matrix.numberRow) {
            return new Matrix();
        }
        Matrix result = new Matrix(new int[this.numberRow][matrix.numberCol]);
        for (int i = 0; i < this.numberRow; i++) {
            for (int j = 0; j < matrix.numberCol; j++) {
                for (int k = 0; k < matrix.numberRow; k++) {
                    result.array[i][j] += this.array[i][k] * matrix.array[k][j];
                }
            }
        }
        return result;
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

    private int getNumberRow(int[][] matrix) {
        return matrix.length;
    }

    private int getNumberCol(int[][] array) {
        return array[0].length;
    }
}