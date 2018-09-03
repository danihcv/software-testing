package huxley.util;

import huxley.util.LinkedList;
import huxley.util.LinkedListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    void init() {
        LinkedList<Integer> list = new LinkedList<>();
        assertNull(list.head);
        assertEquals("VAZIO", list.toString(""));
        assertFalse(list.contains(5));
        assertFalse(list.contains(null));

        list = new LinkedList<>(null);
        assertNull(list.head);
        assertEquals("VAZIO", list.toString(""));

        LinkedListNode<Integer> node = new LinkedListNode<>(1);
        list = new LinkedList<>(node);
        assertEquals(node, list.head);
        assertNull(list.head.next);
        assertEquals("1", list.toString(""));
        assertTrue(list.contains(1));
        assertFalse(list.contains(10));
        assertFalse(list.contains(5));
        assertFalse(list.contains(null));

        list.sort();
        assertEquals("1", list.toString(""));
    }


    @Test
    void addToBegin() {
        LinkedList<Integer> list = new LinkedList<>(new LinkedListNode<>(1));

        list.addToBegin(10);
        assertEquals(new Integer(10), list.head.item);
        assertEquals("10,1", list.toString(","));
        assertFalse(list.contains(2));
        assertTrue(list.contains(1));
        assertTrue(list.contains(10));
        assertEquals(new Integer(10), list.head.item);

        list.addToBegin(50);
        list.addToBegin(45);
        list.addToBegin(500000);
        assertEquals(new Integer(500000), list.head.item);
        list.addToBegin(60);
        assertEquals(new Integer(60), list.head.item);
        list.addToBegin(80);
        list.addToBegin(70);
        list.addToBegin(99);
        assertEquals(new Integer(99), list.head.item);
        assertEquals("99,70,80,60,500000,45,50,10,1", list.toString(","));
    }

    @Test
    void addToEnd() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addToEnd(5);
        assertEquals(list.head, list.tail);
        assertEquals(new Integer(5), list.tail.item);
        assertEquals("5", list.toString(""));

        list.addToEnd(10);
        list.addToEnd(15);
        list.addToEnd(20);
        list.addToEnd(25);
        list.addToEnd(30);
        assertEquals("5,10,15,20,25,30", list.toString(","));
    }

    @Test
    void sort() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addToBegin(1);
        list.sort();
        assertEquals(new Integer(1), list.head.item);

        list.addToBegin(10);
        list.sort();
        assertEquals("1,10", list.toString(","));

        list.addToBegin(2);
        list.addToBegin(9999999);
        list.addToEnd(777);
        list.addToEnd(123);
        list.addToBegin(0);
        list.sort();
        assertEquals("0,1,2,10,123,777,9999999", list.toString(","));
        assertTrue(list.contains(1));
        assertTrue(list.contains(10));
    }

    @Test
    void contains() {
        LinkedList<Integer> list = new LinkedList<>();
        assertFalse(list.contains(null));
        assertFalse(list.contains(1));

        list.addToBegin(1);
        assertTrue(list.contains(1));
        assertFalse(list.contains(null));

        list.addToBegin(2);
        list.addToEnd(3);
        list.addToBegin(4);
        list.addToEnd(5);
        assertTrue(list.contains(5));
        assertTrue(list.contains(2));

        list.addToEnd(9999999);
        assertTrue(list.contains(9999999));

        list.addToBegin(0);
        assertTrue(list.contains(9999999));
    }

    @Test
    void toStringTest() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addToBegin(1);
        list.addToEnd(2);
        list.addToBegin(3);
        list.addToBegin(4);
        list.addToEnd(5);
        list.addToEnd(6);
        list.addToEnd(7);
        list.addToBegin(10);

        assertEquals("10,4,3,1,2,5,6,7", list.toString(","));
    }

    @Test
    void destroy() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addToEnd(5);
        list.addToBegin(1);

        assertNotNull(list.head);
        assertNotNull(list.tail);

        list.destroy();
        assertNull(list.head);
        assertNull(list.tail);
    }
}
