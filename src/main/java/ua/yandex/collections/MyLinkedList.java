package ua.yandex.collections;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLinkedList implements MyList {

    class Node {

        Node next;
        Node last;
        Object data;

        Node() {
            data = new Object();
        }
    }

    Node head;
    Node tail;

    MyLinkedList() {
        head = new Node();
        tail = head;
        head.data = null;
    }

    @Override
    public int size() {
        if (head.data == null) {
            return 0;
        }
        Node temp = head;
        int i;
        for (i = 1; temp != tail; i++) {
            temp = temp.next;
        }
        return i;
    }

    @Override
    public void add(int index, Object e) {
        if (this.size() < index || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
        if (index == 0) {
            this.addFirst(e);
            return;
        }
        if (size() == index) {
            this.addLast(e);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node temp1 = new Node();
        temp1.last = temp;
        temp1.next = temp.next;
        temp1.data = e;
        temp.next = temp1;
    }

    public void addFirst(Object e) {
        if (head.data == null) {
            head.data = new Object();
            head.data = e;
            return;
        }
        Node temp = new Node();
        temp.last = null;
        temp.next = head;
        temp.data = e;
        head.last = temp;
        head = temp;
    }

    public void addLast(Object e) {
        this.add(e);
    }

    @Override
    public void add(Object e) {
        if (head.data == null) {
            head.data = e;
            return;
        }
        Node temp = new Node();
        temp.next = null;
        temp.data = e;
        temp.last = tail;
        tail.next = temp;
        tail = temp;
    }

    public Object getFirst() {
        if (head.data == null) {
            throw new MyException("ReferenceToUncreatedElement");
        }
        return head.data;
    }

    public Object getLast() {
        if (head.data == null) {
            throw new MyException("ReferenceToUncreatedElement");
        }
        return tail.data;
    }

    @Override
    public Object get(int index) {
        if (this.size() - 1 < index || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
        if (index == 0) {
            return getFirst();
        }
        if (index == size() - 1) {
            return getLast();
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public void clear() {
        head.next = null;
        head.data = null;
        tail = head;
    }

    @Override
    public boolean isEmpty() {
        return head.data == null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node temp = head;
        for (int i = 0; i < size(); i++) {
            array[i] = temp.data;
            temp = temp.next;
        }
        return array;
    }

    @Override
    public String toString() {
        String s = new String();
        Node temp = head;
        for (int i = 0; i < size(); i++) {
            s += temp.data;
            if (i < size() - 1) {
                s += ',';
            }
            temp = temp.next;
        }
        return s;
    }

    public Object removeFirst() {
        if (head.data == null) {
            throw new MyException("ReferenceToUncreatedElement");
        }
        Object temp = head.data;
        head = head.next;
        head.last = null;
        return temp;

    }

    public Object removeLast() {
        if (head.data == null) {
            throw new MyException("ReferenceToUncreatedElement");
        }
        Object temp = tail.data;
        tail = tail.last;
        tail.next = null;
        return temp;
    }

    @Override
    public Object remove(int index) {
        if (index >= size() || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size() - 1) {
            return removeLast();
        }
        Node willDelete = head;
        for (int i = 0; i < index; i++) {
            willDelete = willDelete.next;
        }
        willDelete.next.last = willDelete.last;
        willDelete.last.next = willDelete.next;
        return willDelete.data;
    }

    @Override
    public void set(int index, Object e) {
        if (index >= this.size() || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = e;
    }

    @Override
    public int indexOf(Object o) {
        Node temp = head;
        for (int i = 0; i < size(); i++) {
            if (temp.data == o) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public void addAll(Object[] c) {
        for (Object added : c) {
            this.add(added);
        }
    }

    @Override
    public void addAll(int index, Object[] c) {
        if (index > this.size() || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
        if (index == size()) {
            addAll(c);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node twoPart = temp.next;
        if (index == 0) {
            twoPart = head;
        }
        for (Object c1 : c) {
            Node temp1 = new Node();
            temp1.last = temp;
            temp.next = temp1;
            temp1.data = c1;
            temp = temp1;
        }
        temp.next = twoPart;
        twoPart.last = temp;
    }
}
