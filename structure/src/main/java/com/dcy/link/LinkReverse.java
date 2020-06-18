package com.dcy.link;

/**
 * @author dingchengyun
 * @date 2020/6/17
 * @description
 */
public class LinkReverse {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printNode(n1);

        Node nx = reverse(n1);

        printNode(nx);

        printNode(n4);
    }

    public static Node reverse(Node node) {
        if (node == null) {
            return null;
        }

        Node temp = node.next;
        Node newNode = reverse(temp);

        temp.next = node;
        node.next = null;

        return newNode;
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.getDate());
            node = node.next;
        }
    }


   static class Node {
        public Node next;

        private int date;

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public Node(int data) {
            this.date = data;
        }
    }
}


