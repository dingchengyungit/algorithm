package dcy.com.link;

/**
 * @author dingchengyun
 * @date 2020/6/30
 * @description
 */
public class LinkGetReverseKNode {


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

        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

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
}
