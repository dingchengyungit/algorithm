package dcy.com.link.single;

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

        System.out.println("---------");
//        Node nx = reverse(n1);
//        printNode(nx);
//        System.out.println("---------");
//        printNode(n3);
//        System.out.println("---------");

        Node ny = reverseWhile(n1);
        printNode(ny);
    }
    // 单链表反转
    public static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node temp = node.next;
        Node newNode = reverse(temp);

        temp.next = node;
        node.next = null;

        return newNode;
    }

    public static Node reverseWhile(Node head) {
        Node cur = head.next;
        head.next = null;

        while (cur != null) {
            Node temp = cur.next;

            cur.next = head;
            head = cur;
            cur = temp;
        }

        return head;
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.getDate());
            node = node.next;
        }
    }


    public static Node v1(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node temp = node.next;
        Node newNode = v1(temp);

        temp.next = node;
        node.next = null;

        return newNode;
    }

    public static Node v2(Node node) {
        Node head = node;
        head.next = null;

        Node cur = node.next;

        while (cur != null) {
            Node temp = cur.next;
            cur.next = head;

            head = cur;
            cur = temp;
        }

        return head;
    }
}


