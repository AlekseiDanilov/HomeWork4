package com.epam.javauniversity.hw4;

import java.util.Arrays;

public class Matrix {
    private int[][] elements;

    public Matrix() {
        elements = new int[][]{};
    }

    public int getNumberCol() {
        return elements.length;
    }

    public int getNumberRow() {
        return elements[0].length;
    }

    public int[][] getElements(){
        return elements.clone();
    }

    public Matrix(int[][] elements) {
        if (isMatrix(elements)) {
            this.elements = copyElements(elements);
        } else {
            this.elements = new int[][]{};
        }
    }

    public int getElement(int row, int col) {
        if (checkCorrectCoordinate(row, col)) {
            System.out.println("Incorrect row and/or col");
            return 0;
        }
        return elements[row][col];
    }

    private boolean checkCorrectCoordinate(int row, int col) {
        return (row >= getNumberRow() || col >= getNumberCol() || row < 0 || col < 0);
    }

    public void setElement(int row, int col, int value) {
        if (checkCorrectCoordinate(row, col)) {
            return;
        }
        elements[row][col] = value;

    }

    public Matrix add(Matrix matrix) {
        if (this.getNumberRow() != matrix.getNumberRow() || this.getNumberCol() != matrix.getNumberCol()) {
            return new Matrix();
        }
        Matrix result = new Matrix(new int[this.getNumberRow()][this.getNumberCol()]);
        for (int row = 0; row < this.getNumberRow(); row++) {
            for (int col = 0; col < this.getNumberCol(); col++) {
                result.elements[row][col] = this.elements[row][col] + matrix.elements[row][col];
            }
        }
        return result;
    }

    public Matrix mul(Matrix matrix) {
        if (this.getNumberCol() != matrix.getNumberRow()) {
            return new Matrix();
        }
        Matrix result = new Matrix(new int[this.getNumberRow()][matrix.getNumberCol()]);
        for (int row = 0; row < this.getNumberRow(); row++) {
            for (int col = 0; col < matrix.getNumberCol(); col++) {
                for (int k = 0; k < matrix.getNumberRow(); k++) {
                    result.elements[row][col] += this.elements[row][k] * matrix.elements[k][col];
                }
            }
        }
        return result;
    }

    public boolean isMatrix(int[][] elements) {
        if (elements == null) {
            return false;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                return false;
            }
        }
        int numberElementFirstLine = elements[0].length;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].length != numberElementFirstLine) {
                return false;
            }
        }
        return true;
    }
    /*
    Описание алгоритма по рассчету детерминанта методом Гаусса с выбором главного элемента
    по столбцу.
    Примечания: при обмене строк местами детерминант умножается на -1;
    при умножении строки или столбца на некоторое число детерминант умножается на число обратное некоторому.
    Шаг 1. Приводим поэтапно матрицу к верхнеугольному виду, проводя преобразования внутри миноров порядка i, т.е элементы
    (i не больше кол-ва строк) находящиеся ниже главной диагонали должны равняться 0.
        Этап 1. Выбираем максимальный элемент первого столбца рассматриваемого минора,
        если он не первый, то меняем местами с первым.
        Этап 2. Преобразовываем массив таким образом, чтобы после преобразования в первом столбце
        рассматриваемого минора остался только первый элемент.
    (Шаг 1 повторяем до тех пор, пока не приведем матрицу к верхнеугольному виду)
    Шаг 2. Перемножаем получившиеся элементы главной диагонали
     */
    public double calcDeterminant() {
        if (getNumberCol()!= getNumberRow()) {
            System.out.println("For matrix not exist determinant");
            return 0;
        }
        double[][] copyElements = copyElementsDouble(elements);
        double determinant = 1.0;
        for (int row = 0; row < getNumberRow() - 1; row++) {
            int indexRow = row;
            determinant *= swapRowAndReturnCoef(copyElements, indexRow);
            determinant = conversion(copyElements, indexRow, determinant);
        }


        for (int row = 0; row < getNumberRow(); row++) {
            determinant *= copyElements[row][row];
        }
        return determinant;
    }

    private double[][] copyElementsDouble(int[][] elements) {
        double[][] copyElements = new double[elements.length][elements[0].length];
        for (int row = 0; row < elements.length; row++) {
            for (int col = 0; col < elements[0].length; col++) {
                copyElements[row][col] = elements[row][col];
            }
        }
        return copyElements;
    }

    private int[][] copyElements(int[][] elements) {
        int[][] copyElements = new int[elements.length][elements[0].length];
        for (int row = 0; row < elements.length; row++) {
            for (int col = 0; col < elements[0].length; col++) {
                copyElements[row][col] = elements[row][col];
            }
        }
        return copyElements;
    }

    private int calcMaxElementRow(int ord) {
        int indexRowMaxElement = ord;
        int maxElement = elements[ord][ord];
        for (int col = ord; col < getNumberRow(); col++) {
            if (Math.abs(elements[0][col]) > maxElement) {
                maxElement = elements[0][col];
                indexRowMaxElement = col;
            }
        }
        return indexRowMaxElement;
    }

    private double swapRowAndReturnCoef(double[][] copyElements, int indexRow) {
        int indexRowMaxElement = calcMaxElementRow(indexRow);
        if (indexRow == indexRowMaxElement) {
            return 1.0;
        }
        double[] tempRow = copyElements[indexRow];
        copyElements[indexRow] = copyElements[indexRowMaxElement];
        copyElements[indexRowMaxElement] = tempRow;
        return -1.0;
    }

    private double conversion(double[][] copyElements, int indexRow, double previousDeterminant) {
        double ret = previousDeterminant;
        for (int row = indexRow; row < getNumberRow() - 1; row++) {
            if (!(copyElements[row + 1][indexRow] == 0)) {
                double coef = copyElements[indexRow][indexRow] / copyElements[row + 1][indexRow];
                ret *= (-1.0) / coef;
                for (int k = 0; k < getNumberRow(); k++) {
                    copyElements[row + 1][k] *= (-coef);
                }
                for (int g = 0; g < getNumberRow(); g++) {
                    copyElements[row + 1][g] += copyElements[indexRow][g];
                }
            }
        }
        return ret;
    }
}