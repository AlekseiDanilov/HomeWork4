package com.epam.javauniversity.hw4;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestIntArrayUtilEditLength {
    @Test
    public void testIntArrayUtilEditLengthSub() {
        assertArrayEquals(IntArrayUtil.editLength(new int[]{1, 2, 3, 4, 5}, 3), new int[]{1, 2, 3});
    }

    @Test
    public void testIntArrayUtilEditLengthAdd() {
        assertArrayEquals(IntArrayUtil.editLength(new int[]{1, 2, 3}, 5), new int[]{1, 2, 3, 0, 0});
    }

    @Test
    public void testIntArrayUtilEditLengthNull() {
        assertArrayEquals(IntArrayUtil.editLength(null, 5), new int[]{0, 0, 0, 0, 0});
        assertArrayEquals(IntArrayUtil.editLength(null, 0), new int[]{});
        assertArrayEquals(IntArrayUtil.editLength(new int[]{},0), new int[]{});
        assertFalse(IntArrayUtil.editLength(null,0).equals(null));
    }
}