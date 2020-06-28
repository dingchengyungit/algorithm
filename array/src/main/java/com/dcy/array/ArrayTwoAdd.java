package com.dcy.array;

import java.util.Arrays;

/**
 * @author dingchengyun
 * @date 2020/6/27
 * @description
 */
public class ArrayTwoAdd {

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,5,11};
        int[] x = twoSum(nums, 10);

        Arrays.stream(x).forEach(i -> System.out.println(i));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }

    public static int[] twoSumMap(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {

        }
        return null;
    }
}
