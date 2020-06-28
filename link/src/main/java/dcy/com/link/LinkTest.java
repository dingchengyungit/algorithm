package dcy.com.link;

import java.util.Stack;

/**
 * @author dingchengyun
 * @date 2020/6/18
 * @description
 */
public class LinkTest {

    public static void main(String[] args) throws InterruptedException {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // 1
//        System.out.println(getLength(n1));

        // 2
//        System.out.println(getReverseKNode(n1,2).getDate());
//        System.out.println(getReverseKNode2(n1,2).getDate());


        // 3

        printReverseNode(n1);

//        long x = TimeUnit.MILLISECONDS.toNanos(2000);
//        System.out.println(x);
    }

    /**
     * 1. 求单链表中有效节点的个数
     * @param head
     * @return
     */
    public static int getLength(Node head) {
        int length = 0;
        if (head == null || head.next == null) {
            return length;
        }

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }


    /**
     * 2. 获取倒数第k个节点
     * @param k
     * @return
     */
    public static Node getReverseKNode(Node head, int k) {
        Node node = head;

        if (head == null || k < 0) {
            return null;
        }

        int length = getLength(head);

        int kIndex = length - k;
        if (kIndex < 0) {
            return null;
        }

        int index = 0;
        while (node != null) {
            if (index == kIndex) {
                return node;
            }
            index++;
            node = node.next;
        }

        return null;
    }

    /**
     * 2. 获取倒数第k个节点
     * @param k
     * @return
     */
    public static Node getReverseKNode2(Node head, int k) {
        Node first = head;
        Node second = head;

        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    /**
     * 3.1 从尾到头打印链表
     * @param head
     */
    public static void printReverseNode(Node head) {
        if (head == null) {
            return;
        }

        if (head.next != null) {
            printReverseNode(head.next);
        }

        System.out.println(head.getDate());
    }

    /**
     * 3.2 从尾到头打印链表
     * @param head
     */
    public static void pringReverseNode2(Node head) {
       Stack<Node> stackNode = new Stack<>();
       stackNode.push(head);
       while (head != null) {
           stackNode.push(head.next);
           head = head.next;
       }

       while (!stackNode.isEmpty()) {
           Node print = stackNode.pop();
           System.out.println(print.getDate());
       }
    }

    // 合并两个有序的单链表，合并后依然有序

    public static Node merge2SortedNode(Node n1, Node n2) {

//        ClassLoader
        return null;
    }

}
