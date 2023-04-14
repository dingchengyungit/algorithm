package dcy.com.link.single;

/**
 * @author dingchengyun
 * @date 2020/6/18
 * @description
 */
public class LinkLength {

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
//        System.out.println(getLength(n11));
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



}
