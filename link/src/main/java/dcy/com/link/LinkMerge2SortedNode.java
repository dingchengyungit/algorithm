package dcy.com.link;

/**
 * @author dingchengyun
 * @date 2020/6/30
 * @description
 */
public class LinkMerge2SortedNode {



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
