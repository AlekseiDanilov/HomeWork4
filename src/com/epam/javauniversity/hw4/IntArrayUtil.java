package com.epam.javauniversity.hw4;

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
}
