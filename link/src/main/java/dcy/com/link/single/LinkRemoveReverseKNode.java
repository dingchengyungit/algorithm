package dcy.com.link.single;

/**
 * @author dingchengyun
 * @date 2020/6/30
 * @description
 */
public class LinkRemoveReverseKNode {



    /**
     * 删除倒数第K个节点
     *  获取链表长度
     *  倒数第k个的index
     *  找到第k个节点，把k的前一个节点的next指向k节点的next
     */
    public static Node removeReverseKNode(Node head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        // 获取链表长度
        int nodeLen = 0;
        Node lenNode = head;
        while (lenNode != null) {
            nodeLen++;
            lenNode = lenNode.next;
        }

        // 倒数第k个的index
        int kIndex = nodeLen - k;
        if (kIndex < 0) {
            return null;
        }

        if (kIndex == 0) {
            head = head.next;
            return head;
        }

        // 找到第k个节点，把k的前一个节点的next指向k节点的next
        int i = 1;
        Node pre = head;
        Node cur = head.next;

        while (cur != null) {
            if (i == kIndex) {
                pre.next = cur.next;
                break;
            }
            pre = pre.next;
            cur = cur.next;
            i++;
        }

        return head;
    }
}
