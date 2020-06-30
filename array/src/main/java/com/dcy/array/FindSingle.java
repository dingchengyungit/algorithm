package com.dcy.array;

import java.util.Arrays;

/**
 * @author dingchengyun
 * @date 2020/6/29
 * @description
 */
public class FindSingle {

    public static void main(String[] args) {
        System.out.println(1 ^ 1 ^ 2 ^ 2 ^ 3 ^ 4);
        System.out.println(5 ^ 2);

        int[] x = new int[]{1, 1, 2, 2, 3, 5};

        Arrays.stream(findSingleOne(x)).forEach(i -> System.out.println(i));
        Arrays.stream(findSingleTwo(x)).forEach(i -> System.out.println(i));
    }

    public static int[] findSingleOne(int[] arr) {
        if (arr.length <= 0) {
            return null;
        }

        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            x = x ^ arr[i];
        }

        return new int[]{x};
    }

    public static int[] findSingleMuti(int[] arr) {
        return null;
    }

    public static int[] findSingleTwo(int[] arr) {
        if (arr == null || arr.length <= 1)
            return arr;

        int len = arr.length;
        int tmp = arr[0];

        for (int i = 1; i < len; i++) {
            tmp ^= arr[i];
        }


        int num1 = 0;
        int num2 = 0;

        int index = findFirstOne(tmp);

        for (int i = 0; i < len; i++) {
            if (isOne(arr[i], index)) {
                num1 ^= arr[i];
            } else {
                num2 ^= arr[i];
            }
        }

        return new int[]{num1, num2};
    }

    public static int findFirstOne(int n) {
        int i = 0;
        while ((n & 1) == 0) {
            i++;
            n = n >> 1;
        }
        return i;
    }

    public static boolean isOne(int num, int index) {
        if (((num >> index) & 1) == 1)
            return true;
        return false;
    }
}
