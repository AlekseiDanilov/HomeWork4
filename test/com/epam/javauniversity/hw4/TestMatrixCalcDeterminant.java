package com.epam.javauniversity.hw4;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestMatrixCalcDeterminant {

    @Test
    public void testMatrixCalcDeterminantTrueNegativ() {
        assertTrue((new Matrix(new int[][] {{3, 2, 1},
                                            {2, 5, 3},
                                            {0, 4, 2}}).calcDeterminant() - (-6.0)) < 1e-10);

    }

    @Test
    public void testMatrixCalcDeterminantTruePozitiv() {
        assertTrue((new Matrix(new int[][] {{2, 1, 3},
                                            {5, 3, 2},
                                            {1, 4, 3}}).calcDeterminant() - 40.0) < 1e-10);

    }

    @Test
    public void testMatrixCalcDeterminantTrueZero() {
        assertTrue((new Matrix(new int[][] {{1, 2, 3},
                                            {4, 5, 6},
                                            {7, 8, 9}}).calcDeterminant() - 0.0) < 1e-10);

    }


}