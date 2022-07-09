package com.Lib;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArr {

    /**
     * 
     * @param the       original array
     * @param implement the new array you want to merge with the previous one
     * @returns the new emerged array (int)
     */
    public static int[] mergeArray(int original[], int implement[]) {
        int newLength = original.length + implement.length;
        int newArr[] = Arrays.copyOf(original, newLength);
        for (int i = 0; i < implement.length; i++) {
            newArr[original.length + i] = implement[i];
        }
        return newArr;
    }

    /**
     * 
     * @param <T>
     * @param original
     * @param implement
     * @return the new implement obj array
     */
    public static <T> T[] mergeArray(T original[], T implement[]) {
        int newLength = original.length + implement.length;
        T[] newArr = Arrays.copyOf(original, newLength);
        for (int i = 0; i < implement.length; i++) {
            newArr[original.length + i] = implement[i];
        }
        return newArr;
    }

    /**
     * 
     * @param <T>
     * @param arr
     * @return the random obj selected
     */
    public static <T> T getRndValueArr(T arr[]) {
        // Store the index in a variable
        // int rnd = (int) (Math.random() * arr.length);
        int rnd = (Util.r).nextInt(arr.length);
        // Then access it using another variable
        T random = (arr[rnd]);
        return random;
    }

    public static <T> Object[] mergeObj(Object[] eggs, Object[] perls) {
        int newLength = eggs.length + perls.length;
        Object[] newArr = Arrays.copyOf(eggs, newLength);
        try {
            for (int i = 0; i < perls.length; i++) {
                newArr[eggs.length + i] = perls[i];
            }
        } catch (ArrayStoreException ase) {
            ase.printStackTrace();
        }
        return newArr;
    }

    public String getRandom(ArrayList<String> array) {
        int index = 0;
        index = Util.r.nextInt(array.size());
        System.out.println("This is the index " + index);
        // array.remove(index);
        return array.get(index);

    }

}
