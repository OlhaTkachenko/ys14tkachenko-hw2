package ua.yandex.collections;

public class MyArrayList implements MyList {

    
    public MyArrayList() {
        arrayList = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        arrayList = new Object[initialCapacity];
        size = 0;
    }

    public int arrayListMaxSize() {
        return arrayList.length;
    }

    public void ensureCapacity(int newCapacity) {
        Object[] tempList = new Object[arrayList.length];
        System.arraycopy(arrayList, 0, tempList, 0, size);
        arrayList = new Object[newCapacity];
        System.arraycopy(tempList, 0, arrayList, 0, size);
    }

    @Override
    public void add(Object e) {
        if (size == arrayList.length) {
            ensureCapacity(size + DEFAULT_INCREASE);
        }
        arrayList[size] = e;
        size++;
    }

    @Override
    public void add(int index, Object e) {
        checkBorderForAdd(index);
        if (size == arrayList.length) {
            ensureCapacity(size + DEFAULT_INCREASE);
        }
        size++;
        for (int ind = size - 1; ind >= index; ind--) {
            arrayList[ind] = arrayList[ind - 1];
        }
        arrayList[index] = e;
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
        if (size + c.length > arrayList.length) {
            ensureCapacity(size + c.length);
        }
        for (int ind = size - 1; ind >= index; ind--) {
            arrayList[ind + c.length] = arrayList[ind];
        }
        System.arraycopy(c, 0, arrayList, index, c.length);
        size += c.length;
    }

    @Override
    public Object get(int index) {
        checkBorderForAccess(index);
        return arrayList[index];
    }

    @Override
    public Object remove(int index) {
        checkBorderForAccess(index);
        Object result = get(index);
        for (int ind = index; ind < size; ind++) {
            arrayList[ind - 1] = arrayList[ind];
        }
        size--;
        ensureCapacity(size);
        return result;
    }

    @Override
    public void set(int index, Object e) {
        checkBorderForAccess(index);
        arrayList[index] = e;

    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        arrayList = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(arrayList, 0, result, 0, size);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < size; i++) {
            buf.append(arrayList[i]);
            if (i < size - 1) {
                buf.append(',');
            }
        }
        return buf.toString();
    }

    public void checkBorderForAdd(int index) {
        if (size < index || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
    }

    public void checkBorderForAccess(int index) {
        if (size <= index || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
    } 
    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_INCREASE = 1;
    private Object[] arrayList;
    private int size;
}
