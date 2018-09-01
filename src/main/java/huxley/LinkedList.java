package huxley;

public class LinkedList<T extends Comparable<T>> {
    public LinkedListNode<T> head;

    public LinkedList() {}

    public LinkedList(LinkedListNode<T> head) {
        this.head = head;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        LinkedListNode<T> head = this.head;

        if (head == null) {
            return "VAZIO";
        } else {
            for (boolean addColon = false; head != null; head = head.next) {
                if (addColon) {
                    str.append(',');
                }

                if (head.next == null) {
                    str.append(head.item);
                } else if (head.item != head.next.item) {
                    str.append(head.item);
                }
                addColon = true;
            }
        }

        return str.toString();
    }

    public LinkedListNode<T> addToBegin(T newItem) {
        this.head = new LinkedListNode<>(newItem, this.head);
        return this.head;
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
}