package com.dcy.tree;

import java.util.Arrays;

/**
 * @author dingchengyun
 * @date 2023/2/13
 * @description
 */
public class TreeNodeArray {
    public static void main(String[] args) {
//        1
//        11
//        111
//        112
//        12
//        121
//        122

        int[] arr = new int[]{1, 11, 12, 111, 112, 121, 122};
        arrToTreePrintPre(arr, 0);


        //               1;
//        11,         12;
//        111 112,   121,122
        TreeNode t = new TreeNode();
        t.id = 1;

        TreeNode t11 = new TreeNode();
        t11.id = 11;
        TreeNode t12 = new TreeNode();
        t12.id = 12;

        TreeNode t111 = new TreeNode();
        t111.id = 111;
        TreeNode t112 = new TreeNode();
        t112.id = 112;

        TreeNode t121 = new TreeNode();
        t121.id = 121;
        TreeNode t122 = new TreeNode();
        t122.id = 122;

        t.left = t11;
        t.right = t12;

        t11.left = t111;
        t11.right = t112;

        t12.left = t121;
        t12.right = t122;

        int[] a = new int[7];
        treeToArr(a, t, 0);
        System.out.println(Arrays.asList(a));

        System.out.println(treeNodeCount(t));
    }

    // 前序遍历数组转二叉树打印
    public static void arrToTreePrintPre(int[] arr, int index) {
        System.out.println(arr[index]);

        if (index * 2 + 1 < arr.length) {
            arrToTreePrintPre(arr, index * 2 + 1);
        }

        if (index * 2 + 2 < arr.length) {
            arrToTreePrintPre(arr, index * 2 + 2);
        }
    }

    // 二叉树转数组
    public static void treeToArr(int[] arr, TreeNode tree, int index) {
        arr[index] = tree.id;

        if (tree.left != null) {
            treeToArr(arr, tree.left, index * 2 + 1);
        }

        if (tree.right != null) {
            treeToArr(arr, tree.right, index * 2 + 2);
        }
    }

    // 统计树的节点数
    public static int treeNodeCount(TreeNode tree) {
        int count = 0;
        if (tree == null) {
            return count;
        }
        count = 1+ treeNodeCount(tree.left) + treeNodeCount(tree.right);
        return count;
    }
}
