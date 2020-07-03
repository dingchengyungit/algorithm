package com.dcy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dingchengyun
 * @date 2020/6/27
 * @description
 */
public class ArrayTwoAdd {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] x = twoSum(nums, 5);

        int[] y = twoSumMap(nums, 5);
        Arrays.stream(x).forEach(i -> System.out.println(i));
        Arrays.stream(y).forEach(i -> System.out.println(i));
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
        if (nums == null || nums.length <= 1) {
            return null;
        }

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (numMap.get(n) != null) {
                return new int[]{numMap.get(n), i};
            }
            numMap.put(nums[i],i);
        }
        return null;
    }
}
