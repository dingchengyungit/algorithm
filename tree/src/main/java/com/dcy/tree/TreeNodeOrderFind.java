package com.dcy.tree;

/**
 * @author dingchengyun
 * @date 2023/2/13
 * @description
 */
public class TreeNodeOrderFind {

    public static void main(String[] args) {
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

        preOrder(t);
        System.out.println("-----------------");
//        midOrder(t);
//        System.out.println("-----------------");
//        postOrder(t);
//        System.out.println("-----------------");


//        TreeNode preFind = preFind(t, 112);
//        System.out.println("preFind=" + preFind.id + "-----------------");
//        TreeNode mid = midFind(t, 112);
//        System.out.println("preFind=" + mid.id + "-----------------");
//        TreeNode post = postFind(t, 112);
//
//        System.out.println("preFind=" + post.id + "-----------------");
//        TreeNode t = new TreeNode();
//        t.id = 1;
//        TreeNode t = new TreeNode();
//        t.id = 1;
    }

    /**
     * 前序遍历
     * 1. 输出当前节点
     * 2. 左子节点不为空则递归
     * 3. 右子节点不为空则递归
     */
    public static void preOrder(TreeNode tree) {
        System.out.println(tree.id);
        if (tree.left != null) {
            preOrder(tree.left);
        }
        if (tree.right != null) {
            preOrder(tree.right);
        }
    }

    /**
     * 中序遍历
     * 1. 左子节点不为空则递归
     * 2. 输出当前节点
     * 3. 右子节点不为空则递归
     * @param tree
     */
    public static void midOrder(TreeNode tree) {
        if (tree.left != null) {
            midOrder(tree.left);
        }
        System.out.println(tree.id);
        if (tree.right != null) {
            midOrder(tree.right);
        }
    }

    /**
     * 后序遍历
     * 1. 左子节点不为空则递归
     * 2. 右子节点不为空则递归
     * 3. 输出当前节点
     * @param tree
     */
    public static void postOrder(TreeNode tree) {
        if (tree.left != null) {
            postOrder(tree.left);
        }
        if (tree.right != null) {
            postOrder(tree.right);
        }
        System.out.println(tree.id);
    }

    /**
     * 前序查找
     * 1. 比较当前节点，是目标节点，则返回
     * 2. 左子节点不为空则递归,判断返回值，是目标节点，则返回
     * 3. 右子节点不为空则递归,返回结果（可能为空）
     */
    public static TreeNode preFind(TreeNode tree, int id) {

        System.out.println(tree.id);
        if (tree.id == id) {
            return tree;
        }

        TreeNode t = null;
        if (tree.left != null) {
            t = preFind(tree.left, id);
        }
        if (t != null) {
            return t;
        }

        if (tree.right != null) {
            t = preFind(tree.right, id );
        }

        return t;
    }

    /**
     * 中序查找
     * 1. 左子节点不为空则递归，判断返回结果，是目标节点则返回
     * 2. 比较当前节点，是目标节点，则返回
     * 3. 右子节点不为空则递归，返回结果
     * @param tree
     */
    public static TreeNode midFind(TreeNode tree, int id) {
        TreeNode t = null;
        if (tree.left != null) {
            t = midFind(tree.left, id);
        }
        if (t != null) {
            return t;
        }
        System.out.println(tree.id);
        if (tree.id == id) {
            return tree;
        }
        if (tree.right != null) {
            t = midFind(tree.right, id);
        }
        return t;
    }

    /**
     * 后序查找
     * 1. 左子节点不为空则递归，判断返回结果，是目标节点则返回
     * 2. 右子节点不为空则递归，判断返回结果，是目标节点则返回
     * 3. 比较当前节点，是目标节点，则返回
     * @param tree
     */
    public static TreeNode postFind(TreeNode tree, int id) {
        TreeNode t = null;
        if (tree.left != null) {
            t = postFind(tree.left, id);
        }
        if (t != null) {
            return t;
        }
        if (tree.right != null) {
            t = postFind(tree.right, id);
        }
        if (t != null) {
            return t;
        }
        System.out.println(tree.id);
        if (tree.id == id) {
            return tree;
        }
        return t;
    }
}
