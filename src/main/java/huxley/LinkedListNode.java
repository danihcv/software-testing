package huxley;

public class LinkedListNode<T> {
    public T item;
    public LinkedListNode<T> next;

    LinkedListNode() {}

    LinkedListNode(T item) {
        this.item = item;
    }

    LinkedListNode(T item, LinkedListNode<T> next) {
        this.item = item;
        this.next = next;
    }
}
