package dcy.com.link;

import java.util.Stack;

/**
 * @author dingchengyun
 * @date 2020/6/18
 * @description
 */
public class LinkTest {

    public static void main(String[] args) throws InterruptedException {

        Node n11 = new Node(1);
        Node n12 = new Node(2);
        Node n13 = new Node(7);
        Node n14 = new Node(10);

        n11.next = n12;
        n12.next = n13;
        n13.next = n14;


        Node n21 = new Node(4);
        Node n22 = new Node(5);
        Node n23 = new Node(8);
        Node n24 = new Node(11);

        n21.next = n22;
        n22.next = n23;
        n23.next = n24;

        // 1
//        System.out.println(getLength(n1));

        // 2
//        System.out.println(getReverseKNode(n1,2).getDate());
//        System.out.println(getReverseKNode2(n1,2).getDate());


        // 3

//        printReverseNode(n1);

        // 4
        Node x = merge2SortedNode(n11, n21);
        System.out.println(x);

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
           System.out.println(stackNode.pop().getDate());
       }
    }

    /**
     *  4 合并两个有序的单链表，合并后依然有序
      */
    public static Node merge2SortedNode(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }

        if (n2 == null) {
            return n1;
        }


        Node head;
        Node cur;

        if (n1.getDate() <= n2.getDate()) {
            head = n1;
            cur = n1;
            n1 = n1.next;
        } else {
            head = n2;
            cur = n2;
            n2 = n2.next;
        }

        while (n1 != null && n2 != null) {
            if (n1.getDate() < n2.getDate()) {
                cur.next = n1;
                n1 = n1.next;
                cur = cur.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
                cur = cur.next;
            }
        }

        if (n1 != null) {
            cur.next = n1;
        }
        if (n2 != null) {
            cur.next = n2;
        }

        return head;
    }

}
