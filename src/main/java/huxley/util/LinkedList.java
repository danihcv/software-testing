package huxley.util;

public class LinkedList<T extends Comparable<T>> {
    public LinkedListNode<T> head;
    public LinkedListNode<T> tail;

    public LinkedList() {}

    LinkedList(LinkedListNode<T> head) {
        this.head = head;
        this.tail = head;
        if (this.head != null) {
            this.head.index = 0;
        }
    }

    public String toString(String separator) {
        StringBuilder str = new StringBuilder();
        LinkedListNode<T> head = this.head;

        if (head == null) {
            return "VAZIO";
        } else {
            for (boolean separate = false; head != null; head = head.next) {
                if (separate) {
                    str.append(separator);
                }

                if (head.next == null) {
                    str.append(head.item);
                } else if (head.item != head.next.item) {
                    str.append(head.item);
                }
                separate = true;
            }
        }

        return str.toString();
    }

    public LinkedListNode<T> addToBegin(T newItem) {
        LinkedListNode<T> newNode = new LinkedListNode<>(newItem, this.head);
        if (head == null) {
            this.tail = newNode;
        }
        this.head = newNode;

        int i = 0;
        for (LinkedListNode<T> aux = this.head; aux != null; aux = aux.next, i++) {
            aux.index = i;
        }
        return this.head;
    }

    public LinkedListNode<T> addToEnd(T newItem) {
        LinkedListNode<T> newNode = new LinkedListNode<>(newItem);
        if (tail == null) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail.next.index = this.tail.index + 1;
            this.tail = this.tail.next;
        }
        return this.tail;
    }

    public LinkedList sort() {
        LinkedListNode<T> outterHead = head;
        //bubble sort:
        for(; outterHead != null; outterHead = outterHead.next){
            LinkedListNode<T> innerHead = outterHead.next;
            for(; innerHead != null; innerHead = innerHead.next){
                if(outterHead.item.compareTo(innerHead.item) > 0){
                    T aux = outterHead.item;
                    outterHead.item = innerHead.item;
                    innerHead.item = aux;
                }
            }
        }
        return this;
    }

    public boolean contains(T n) {
        LinkedListNode<T> head = this.head;
        for(; head != null; head = head.next){
            if(head.item.equals(n)) {
                return true;
            }
        }
        return false;
    }

    public LinkedListNode<T> destroy(){
        return this.head = this.tail = null;
    }
}