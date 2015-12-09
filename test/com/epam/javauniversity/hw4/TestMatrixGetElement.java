package com.epam.javauniversity.hw4;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestMatrixGetElement {

    @Test
    public void testMatrixGetElement() {
        assertEquals(new Matrix(new int[][] {{1, 2},
                                             {3, 4}}).getElement(1, 1), 4);
    }
}