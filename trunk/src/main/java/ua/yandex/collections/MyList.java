package ua.yandex.collections;

public interface MyList {

    void add(Object e); 

    void add(int index, Object e); 

    void addAll(Object[] c); 

    void addAll(int index, Object[] c); 

    Object get(int index); 

    Object remove(int index); 

    void set(int index, Object e); 

    int indexOf(Object o); 

    int size(); 

    void clear(); 

    boolean isEmpty();

    Object[] toArray(); 

    @Override
    String toString();
}
