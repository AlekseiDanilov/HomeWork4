package com.epam.javauniversity.hw4;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestMatrixAdd {

    @Test
    public void testMatrixAddTrue() {
        assertArrayEquals(new Matrix(new int[][]{{1, 1},
                                                 {1, 1}}).add(
                          new Matrix(new int[][]{{5, 5},
                                                 {5, 5}})).getElements(),
                                     new int[][]{{6, 6},
                                                 {6, 6}});
    }

    @Test
    public void testMatrixAddDifferentSize() {
        assertArrayEquals(new Matrix(new int[][]{{1, 1},
                                                 {1, 1}}).add(
                          new Matrix(new int[][]{{5, 5}})).getElements(),
                                     new int[][]{});
    }
}