package com.dcy.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dingchengyun
 * @date 2023/2/17
 * @description
 */
public class CatalogueTree {

    public static void main(String[] args) {
//    1
//    2,3
//    456,7
//    [1,2,3,4,5,6,7]
//        int[] result = new int[7];
        Node root = getTree();
        List<Integer> result = new ArrayList<Integer>();
        recursionTreeToList(result, root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    // 树转数组（列表）
    public static void recursionTreeToList(List<Integer> result, Node root) {
        result.add(root.value);
        if (root.children == null || root.children.length <= 0) {
            return;
        }
        for (Node child : root.children) {
            recursionTreeToList(result, child);
        }
    }

    // 列表转树
    public static Node recursionListToTree(List<Node> nodes) {
        Node root = null;
        for (Node n : nodes) {
            if (n.pid == 0) {
                root = n;
                List<Node> childList = buildChild(n.id, Arrays.asList(n.children));
                root.children = (Node[])childList.toArray();
            }
        }
        return root;
    }
    // 列表转树
    public static List<Node> buildChild(int pid, List<Node> nodes) {
        List<Node> result = new ArrayList<Node>();
        for (Node n : nodes) {
            if (n.pid == pid) {
                List<Node> children = buildChild(n.id, nodes);
                n.children = (Node[])children.toArray();
                result.add(n);
            }
        }
        return result;
    }

    public static class Node {
        int pid; // 父节点id
        int id; // 当前节点id
        int value; // 当前值
        Node[] children; // 子节点
    }

    public static Node getTree() {
        Node root = new Node();
        root.value = 1;

        Node t2 = new Node();
        t2.value = 2;

        Node t3 = new Node();
        t3.value = 3;

        Node t4 = new Node();
        t4.value = 4;

        Node t5 = new Node();
        t5.value = 5;

        Node t6 = new Node();
        t6.value = 6;

        Node t7 = new Node();
        t7.value = 7;

        root.children = new Node[] {t2, t3};
        t2.children = new Node[] {t4, t5, t6};
        t3.children = new Node[] {t7};
        return root;
    }
}


