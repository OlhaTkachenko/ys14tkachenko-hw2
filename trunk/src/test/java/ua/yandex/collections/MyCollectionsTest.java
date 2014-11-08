package ua.yandex.collections;

import java.util.Comparator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyCollectionsTest {

    public MyCollectionsTest() {
    }

    public class MyComparator implements Comparator {

        @Override
        public int compare(Object a, Object b) {
            return (((Comparable) a).compareTo(b));
        }
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testReverseForLinkedList() {
        System.out.println("reverse");
        MyList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        MyCollections.reverse(list);
        Object[] expectedResult = {3, 2, 1};
        Object[] actualResult = list.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverseForArrayList() {
        System.out.println("reverse");
        MyList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        MyCollections.reverse(list);
        Object[] expectedResult = {4, 3, 2, 1};
        Object[] actualResult = list.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testBinarySearchNotFind_MyList_Object() {
        System.out.println("binarySearch");
        MyList list = new MyLinkedList();
        Object key = 2;
        list.add(1);
        list.add(3);
        int expResult = -2;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearchEmpty_MyList_Object() {
        System.out.println("binarySearch");
        MyList list = new MyLinkedList();
        Object key = 2;
        int expResult = -1;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearchNotFindInTheEnd_MyList_Object() {
        System.out.println("binarySearch");
        MyList list = new MyLinkedList();
        Object key = 100;
        Object[] array = {1, 2, 3, 4, 50};
        list.addAll(array);
        int expResult = -6;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearchFind_MyList_Object() {
        System.out.println("binarySearch");
        MyList list = new MyLinkedList();
        Object key = 3;
        Object[] array = {1, 2, 3, 4, 50};
        list.addAll(array);
        int expResult = 2;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_4args() {
        System.out.println("binarySearch");
        MyList list = new MyArrayList();
        Object key = 3;
        Object[] array = {1, 2, 3, 4, 50};
        list.addAll(array);
        int expResult = 2;
        int result = MyCollections.binarySearch(list, key, 0, list.size() - 1);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_3args() {
        System.out.println("binarySearch");
        MyList list = new MyLinkedList();
        Object key = 50;
        MyComparator cp = new MyComparator();
        Object[] array = {1, 2, 3, 4, 50};
        list.addAll(array);
        int expResult = 4;
        int result = MyCollections.binarySearch(list, key, cp);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearchNotFindInBegining_4args() {
        System.out.println("binarySearch");
        MyList list = new MyLinkedList();
        Object key = 0;
        Object[] array = {2, 3, 4, 5, 6, 7, 8, 9};
        list.addAll(array);
        int expResult = -1;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearchFindInBegining_4args() {
        System.out.println("binarySearch");
        MyList list = new MyLinkedList();
        Object key = 3;
        Object[] array = {2, 3, 4, 5, 6, 7, 8, 9};
        list.addAll(array);
        int expResult = 1;
        int result = MyCollections.binarySearch(list, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearchNotFind_3args() {
        System.out.println("binarySearch");
        MyList list = new MyLinkedList();
        Object key = 5.5;
        MyComparator cp = new MyComparator();
        Object[] array = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
        list.addAll(array);
        int expResult = -6;
        int result = MyCollections.binarySearch(list, key, cp);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearch_5args() {
        System.out.println("binarySearch");
        MyList list = new MyArrayList();
        Object key = 3;
        Object[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        list.addAll(array);
        MyComparator cp = new MyComparator();
        int indexOfBegin = 2;
        int indexOfEnd = 6;
        int expResult = 2;
        int result = MyCollections.binarySearch(list, key, cp, indexOfBegin, indexOfEnd);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearchIsEmpty_3args() {
        System.out.println("binarySearch");
        MyList list = new MyArrayList();
        Object key = 3;
        MyComparator cp = new MyComparator();
        int expResult = -1;
        int result = MyCollections.binarySearch(list, key, cp);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearchNotFindInTheEnd_3argsMyList_Object() {
        System.out.println("binarySearch");
        MyList list = new MyLinkedList();
        Object key = 100;
        Object[] array = {1, 2, 3, 4, 50};
        MyComparator cp = new MyComparator();
        list.addAll(array);
        int expResult = -6;
        int result = MyCollections.binarySearch(list, key, cp);
        assertEquals(expResult, result);
    }

    @Test
    public void testBinarySearchNotFind_5args() {
        System.out.println("binarySearch");
        MyList list = new MyArrayList();
        Object key = 0;
        Object[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        list.addAll(array);
        MyComparator cp = new MyComparator();
        int indexOfBegin = 0;
        int indexOfEnd = 6;
        int expResult = -1;
        int result = MyCollections.binarySearch(list, key, cp, indexOfBegin, indexOfEnd);
        assertEquals(expResult, result);
    }

}
