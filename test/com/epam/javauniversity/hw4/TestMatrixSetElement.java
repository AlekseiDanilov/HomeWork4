package com.epam.javauniversity.hw4;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestMatrixSetElement {
    @Test
    public void testMatrixSetElement() {
        Matrix testMatrix = new Matrix(new int[][] {{1, 2},
                                                    {3, 4}});
        testMatrix.setElement(1, 1, 99);
        assertArrayEquals(testMatrix.getElements(), new int[][] {{1, 2},
                                                                 {3, 99}});
    }

}