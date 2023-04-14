package dcy.com.link.doub;

import java.util.AbstractList;

/**
 * @author dingchengyun
 * @date 2023/2/10
 * @description
 */
public class LinkList<E> extends AbstractList<E> {
    private int size;
    Node<E> first;
    Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public E get(int index) {
        return null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    private Node<E> node(int index) {
        return null;
    }

}
