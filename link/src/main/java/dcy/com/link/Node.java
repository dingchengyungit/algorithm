package dcy.com.link;

/**
 * @author dingchengyun
 * @date 2020/6/18
 * @description
 */
public class Node {
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
