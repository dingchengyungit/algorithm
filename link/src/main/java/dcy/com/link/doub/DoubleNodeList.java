package dcy.com.link.doub;

/**
 * @author dingchengyun
 * @date 2023/2/10
 * @description
 */
public class DoubleNodeList {

    /**
     * 遍历列表 向后
     * @param head
     */
    public void list(DoubleNode head) {
        if (head == null || head.next == null) {
            return;
        }

        DoubleNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 从尾部添加一个节点
     * @param head
     * @param add
     */
    public void addTail(DoubleNode head,DoubleNode add) {
        DoubleNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = add;
        add.pre = temp;
    }

    /**
     * 替换date属性相同的节点
     * @param head
     * @param update
     */
    public void update(DoubleNode head, DoubleNode update) {
        if (head.next == null) {
            return;
        }
        // 找到date相同的节点
        DoubleNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.getDate() == update.getDate()) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        // 属性值替换一下
        if (flag) {
            temp.setDate(update.getDate());
//            temp.setxxx(update.getxxx());
            return;
        }
        System.out.println("找不到替换的节点");
    }

    /**
     * 删除date值相同的节点
     * @param head
     * @param del
     */
    public void remove(DoubleNode head, DoubleNode del) {
        DoubleNode temp = head;
        boolean flag = false;

        while (temp != null) {
            if (temp.getDate() == del.getDate()) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }
    }
}
