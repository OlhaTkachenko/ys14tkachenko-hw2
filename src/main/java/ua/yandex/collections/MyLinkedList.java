package ua.yandex.collections;

public class MyLinkedList implements MyList {

    static private class Node {

        private Node next;
        private Node last;
        private Object data;

        Node() {
            data = new Object();
        }
    }

    private Node head;
    private Node tail;

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
        checkBorderForAdd(index);
        if (index == 0) {
            this.addFirst(e);
            return;
        }
        if (size() == index) {
            this.addLast(e);
            return;
        }
        Node placeWhereAdd = head;
        for (int i = 1; i < index; i++) {
            placeWhereAdd = placeWhereAdd.next;
        }
        Node temp = new Node();
        temp.last = placeWhereAdd;
        temp.next = placeWhereAdd.next;
        temp.data = e;
        placeWhereAdd.next = temp;
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
        add(e);
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
        checkBorderForAccess(0);
        return head.data;
    }

    public Object getLast() {
        checkBorderForAccess(0);
        return tail.data;
    }

    @Override
    public Object get(int index) {
        checkBorderForAccess(index);
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
        StringBuilder buf = new StringBuilder();
        Node temp = head;
        for (int i = 0; i < size(); i++) {
            buf.append(temp.data);
            if (i < size() - 1) {
                buf.append(',');
            }
            temp = temp.next;
        }
        return buf.toString();
    }

    public Object removeFirst() {
        checkBorderForAccess(0);
        Object temp = head.data;
        head = head.next;
        head.last = null;
        return temp;

    }

    public Object removeLast() {
        checkBorderForAccess(0);
        Object temp = tail.data;
        tail = tail.last;
        tail.next = null;
        return temp;
    }

    @Override
    public Object remove(int index) {
        checkBorderForAccess(index);
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
        checkBorderForAccess(index);
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
        checkBorderForAdd(index);
        if (index == size()) {
            addAll(c);
            return;
        }
        if (index == 0) {
            Node oldHead = head;
            Node now = new Node();
            now.data = c[0];
            head = now;
            for (int i = 1; i < c.length; i++) {
                Node temp = new Node();
                temp.last = now;
                now.next = temp;
                temp.data = c[i];
                now = temp;
            }
            now.next = oldHead;
            oldHead.last = now;
            return;
        }
        Node placeWhereAdd = head;
        for (int i = 1; i < index; i++) {
            placeWhereAdd = placeWhereAdd.next;
        }
        Node twoPart = placeWhereAdd.next;
        for (Object addNow : c) {
            Node temp = new Node();
            temp.last = placeWhereAdd;
            placeWhereAdd.next = temp;
            temp.data = addNow;
            placeWhereAdd = temp;
        }
        placeWhereAdd.next = twoPart;
        twoPart.last = placeWhereAdd;
    }

    public void checkBorderForAdd(int index) {
        if (size() < index || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
    }

    public void checkBorderForAccess(int index) {
        if (size() <= index || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
    }
}
