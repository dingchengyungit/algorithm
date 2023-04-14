package dcy.com.link.doub;

/**
 * @author dingchengyun
 * @date 2023/2/10
 * @description
 */
public class DoubleNode {
    public DoubleNode next;
    public DoubleNode pre;

    private int date;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public DoubleNode(int data) {
        this.date = data;
    }
}
