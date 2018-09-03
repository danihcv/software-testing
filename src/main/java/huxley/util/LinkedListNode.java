package huxley.util;

public class LinkedListNode<T> {
    public T item;
    public int index;
    public LinkedListNode<T> next;

    LinkedListNode(T item) {
        this.item = item;
    }

    LinkedListNode(T item, LinkedListNode<T> next) {
        this.item = item;
        this.next = next;
    }
}
