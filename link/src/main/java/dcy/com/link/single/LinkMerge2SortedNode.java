package dcy.com.link.single;

/**
 * @author dingchengyun
 * @date 2020/6/30
 * @description
 */
public class LinkMerge2SortedNode {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n12 = new Node(3);
        Node n13 = new Node(7);
        Node n14 = new Node(9);
        n1.next = n12;
        n12.next = n13;
        n13.next = n14;

        Node n2 = new Node(2);
        Node n22 = new Node(4);
        Node n23 = new Node(5);
        Node n24 = new Node(113);
        n2.next = n22;
        n22.next = n23;
        n23.next = n24;

        Node newN = merge2SortedNode(n1, n2);

        while (newN != null) {
            System.out.println(newN.getDate());
            newN = newN.next;
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
