package dcy.com.link.circle;

/**
 * @author dingchengyun
 * @date 2023/2/11
 * @description
 */
public class CircleLink {

    public static void main(String[] args) {
        CNode n = generate(7);
        // 已知单向循环列表中的个数，打印出元素
        for (int i = 1; i <=4; i++) {
            System.out.println(n.no);
            n = n.next;
        }

        // 统计单向循环列表中的元素个数
        int firstNo = n.no;

        int length = 1;
        n = n.next;
        while (true) {
            if (firstNo == n.no) {
                break;
            }
            length++;
            n = n.next;
        }
        System.out.println(length);

        // 每到3就出圈
        pop(n,3);
    }

    /**
     * 生成x个节点的单向循环链表
     * @param x
     * @return
     */
    public static CNode generate(int x) {
        if (x < 1) {
            return null;
        }
        CNode pre = null;

        // 处理后续节点
        for (int i = 1; i <=x; i++) {
            CNode nx = new CNode(i); // 创建新节点

            if (i == 1) {
                nx.next = nx;
                pre = nx;
                continue;
            }

            CNode temp = pre.next;
            pre.next = nx; // 前节点指向新节点
            nx.next = temp; // 新节点指向前节点曾经的下个节点（即成环状）

            pre = nx;
        }

        return pre;
    }

    /**
     * 数到n就出圈（并打印）
     * @param n
     */
    public static void pop(CNode node, int n) {
        if (n <=0) {
            return;
        }

        CNode head = node;
        CNode popNode = node.next;
        int i = 1;
        while (head != popNode) {
            head = head.next;
            popNode = popNode.next;
            i++;

            if (i == n) {
                System.out.println("i = " + i + " popNode= " + popNode.no);
                popNode = popNode.next;
                head.next = popNode;
                i = 1;
            }


        }

    }
}
