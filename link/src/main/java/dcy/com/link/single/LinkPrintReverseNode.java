package dcy.com.link.single;

import java.util.Stack;

/**
 * @author dingchengyun
 * @date 2020/6/30
 * @description
 */
public class LinkPrintReverseNode {
    public static void main(String[] args) {

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
        Stack<Node> stackNode = new Stack<Node>();
        stackNode.push(head);
        while (head != null) {
            stackNode.push(head.next);
            head = head.next;
        }

        while (!stackNode.isEmpty()) {
            System.out.println(stackNode.pop().getDate());
        }
    }
}
