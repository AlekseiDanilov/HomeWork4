package com.epam.javauniversity.hw4;

public class Matrix {
    int[][] array;
    int numberRow;
    int numberCol;
    double determinant;

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
            this.array = new int[numberRow][numberCol];
            for (int i = 0; i < numberRow; i++) {
                for (int j = 0; j < numberCol; j++) {
                    this.array[i][j] = array[i][j];
                }
            }
        }
    }

    public int getElement(int i, int j) {
        if (i >= numberRow || j >= numberCol || i < 0 || j < 0) {
            System.out.println("Incorrect i and/or j");
            return 0;
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

    private int getNumberRow(int[][] array) {
        return array.length;
    }

    private int getNumberCol(int[][] array) {
        return array[0].length;
    }

    public double calcDeterminamt() {
        if (numberCol != numberRow) {
            System.out.println("For matrix not exist determinant");
            return 0;
        }
        double[][] arrayForCalcDet = new double[numberRow][numberCol];
        for (int i = 0; i < numberRow; i++) {
            for (int j = 0; j < numberCol; j++) {
                arrayForCalcDet[i][j] = array[i][j];
            }
        }
        determinant = 1.0;
        for (int i = 0; i < numberRow - 1; i++) {
            int indexRow = i;
            swapRowAndReturnCoef(arrayForCalcDet, indexRow);
            conversion(arrayForCalcDet, indexRow);
        }


        for (int i = 0; i < numberRow; i++) {
            determinant *= arrayForCalcDet[i][i];
        }
        System.out.println(determinant);
        return determinant;
    }

    private int calcMaxElementRow(int ord) {
        int indexRowMaxElement = ord;
        int maxElement = array[ord][ord];
        for (int j = ord; j < numberRow; j++) {
            if (Math.abs(array[0][j]) > maxElement) {
                maxElement = array[0][j];
                indexRowMaxElement = j;
            }
        }
        return indexRowMaxElement;
    }

    private void swapRowAndReturnCoef(double[][] arrayForCalcDet, int indexRow) {
        int indexRowMaxElement = calcMaxElementRow(indexRow);
        if (indexRow == indexRowMaxElement) {
            return;
        }
        double[] tempRow = arrayForCalcDet[indexRow];
        arrayForCalcDet[indexRow] = arrayForCalcDet[indexRowMaxElement];
        arrayForCalcDet[indexRowMaxElement] = tempRow;
        determinant *= (-1.0);
    }

    private void conversion(double[][] arrayForCalcDet, int indexRow) {
        for (int i = indexRow; i < numberRow - 1; i++) {
            if (!(arrayForCalcDet[i + 1][indexRow] == 0)) {
                double coef = arrayForCalcDet[indexRow][indexRow] / arrayForCalcDet[i + 1][indexRow];
                determinant *= (-1.0) / coef;
                for (int k = 0; k < numberRow; k++)
                    arrayForCalcDet[i + 1][k] *= (-coef);
                for (int g = 0; g < numberRow; g++)
                    arrayForCalcDet[i + 1][g] += arrayForCalcDet[indexRow][g];
            }
        }
    }
}