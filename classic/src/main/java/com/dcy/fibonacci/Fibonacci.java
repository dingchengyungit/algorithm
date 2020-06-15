package com.dcy.fibonacci;

/**
 * @author dingchengyun
 * @date 2020/6/16
 * @description
 */
public class Fibonacci {

    public static void main(String[] args) {

    }

    public static int fibRecursion(int n) {
        if (n <= 1) return n;

        return fibRecursion(n-1) + fibRecursion(n-2);
    }

    public static int fibFor(int n) {
        if (n <= 1) return n;

        int n1 = 0;
        int n2 = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = n1 + n2;

            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
