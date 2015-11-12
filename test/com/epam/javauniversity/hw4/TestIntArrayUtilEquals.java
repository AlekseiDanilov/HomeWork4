package com.epam.javauniversity.hw4;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestIntArrayUtilEquals {
    @Test
    public void testIntArrayUtilEqualsTrue() {
        assertTrue(IntArrayUtil.equalsArrays(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    @Test
    public void testIntArrayUtilEqualsFalse() {
        assertFalse(IntArrayUtil.equalsArrays(new int[]{1, 2, 3}, new int[]{1, 2, 4}));
    }

    @Test
    public void testIntArrayUtilEqualsNull() {
        assertFalse(IntArrayUtil.equalsArrays(null, new int[]{1, 2, 4}));
    }
}