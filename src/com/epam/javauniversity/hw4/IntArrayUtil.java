package com.epam.javauniversity.hw4;

import java.util.Arrays;
import java.util.Random;

public final class IntArrayUtil {

    private IntArrayUtil() {
    }

    public static int[] editLength(int[] array, int newLength) {
        if (array == null) {
            throw new NullPointerException("array is null");
        }
        int[] newArray = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            if (i < array.length) {
                newArray[i] = array[i];
            }
        }
        return newArray;
    }

    public static boolean equals(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) {
            throw new NullPointerException("one array of equals is null");
        }
        for (int i = 0; i < firstArray.length; i++) {
            if (!IntArrayUtil.contains(firstArray, secondArray[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean contains(int[] array, int value) {
        if (array == null) {
            throw new NullPointerException("array is null");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static int[] mix(int[] array) {
        if (array == null) {
            throw new NullPointerException("array is null");
        }
        int [] newArray = Arrays.copyOf(array, array.length);
        Random r = new Random();
        for (int i = 0; i < newArray.length; i++) {
            int randomIndex = i + r.nextInt(newArray.length - i);
            int temp = newArray[i];
            newArray[i] = newArray[randomIndex];
            newArray[randomIndex] = temp;
        }
        return newArray;
    }

    public static int[] filter(int[] array, Predicate predicate) {
        if (array == null) {
            throw new NullPointerException("array is null");
        }
        if (predicate == null) {
            throw new NullPointerException("predicate is null");
        }
        int[] temp = new int[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (predicate.apply(array[i])) {
                temp[count] = array[i];
                count++;
            }
        }
        return Arrays.copyOf(temp, count);
    }

    public static void print(int[] array) {
        if (array == null) {
            System.out.println("elements is null");
            return;
        }
        if (array.length == 0) {
            System.out.println("elements is empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
