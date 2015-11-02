package com.epam.javauniversity.hw4;

import java.util.Random;

public final class IntArrayUtil {

    private IntArrayUtil() {
    }

    public static int[] editLength(int[] array, int newLength) {
        if (array == null) {
            return new int[newLength];
        }
        int[] newArray = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            if (i >= array.length) {
                newArray[i] = 0;
            } else {
                newArray[i] = array[i];
            }
        }
        return newArray;
    }

    public static boolean equals(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) {
            return false;
        }
        if (firstArray.length != secondArray.length) {
            return false;
        }
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] mix(int[] array) {
        if (array == null) {
            return new int[]{};
        }
        int[] newArray = array;
        for (int i = 0; i < newArray.length; i++) {
            int tmp = newArray[i];
            int rndIndex = new Random().nextInt() % newArray.length;
            newArray[i] = newArray[rndIndex];
            newArray[rndIndex] = tmp;
        }
        return newArray;
    }

    public static void print(int[] array) {
        if (array == null) {
            System.out.println("array is null");
            return;
        }
        if (array.length == 0) {
            System.out.println("array is empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
