package com.epam.javauniversity.hw4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestIntArrayUtilMix {

    @Test
    public void testIntArrayUtilMix() {
        int array[] = {1, 2, 3, 4, 5};
        assertTrue(IntArrayUtil.equals(array,IntArrayUtil.mix(array)));
    }

    @Test
    public void testIntArrayUtilMixLength() {
        int array[] = {1, 2, 3, 4, 5};
        assertTrue(array.length == IntArrayUtil.mix(array).length);
    }

    @Test
    public void testIntArraysUtilMixNull() {
        assertTrue(IntArrayUtil.equals(IntArrayUtil.mix(null),new int[]{}));
    }
}