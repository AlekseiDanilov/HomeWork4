package com.epam.javauniversity.hw4;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestMatrixIsMatrix {
    @Test
    public void testMatrixIsMatrixTrue() {
        assertTrue(new Matrix().isMatrix(new int[][]{{1, 2},
                                                     {3, 4}}));
    }

    @Test
    public void testMatrixIsMatrixNull() {
        assertFalse(new Matrix().isMatrix(null));
    }

    @Test
    public void testMatrixIsMatrixFirstLineNull() {
        assertFalse(new Matrix().isMatrix(new int[][]{null,
                                                     {1, 2}}));
    }

    @Test
    public void testMatrixIsMatrixLineNull() {
        assertFalse(new Matrix().isMatrix(new int[][]{{1, 2},
                                                       null,
                                                      {5, 9}}));
    }

    @Test
    public void testMatrixIsMatrixEmpty() {
        assertTrue(new Matrix().isMatrix(new int[][]{{},
                                                     {},
                                                     {}}));
    }
}