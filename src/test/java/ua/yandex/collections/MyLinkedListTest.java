package ua.yandex.collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyLinkedListTest {

    public MyLinkedListTest() {
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
    public void testSizeifEmpty() {
        System.out.println("size");
        MyLinkedList instance = new MyLinkedList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSizeifNoEmpty() {
        System.out.println("size");
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        instance.add(1);
        instance.add(1);
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddInBegin_int_Object() {
        System.out.println("add");
        int index = 0;
        Object e = 5;
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        instance.add(1);
        instance.add(index, e);
        Object[] expectedResult = {5, 1, 1};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddInEnd_int_Object() {
        System.out.println("add");
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        int index = 1;
        instance.add(index, '8');
        Object[] expectedResult = {1, '8'};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddInMiddle_int_Object() {

        int index = 1;
        Object e = 5;
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        instance.add(1);
        instance.add(index, e);
        Object[] expectedResult = {1, 5, 1};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = MyException.class)
    public void testAddException_int_Object() {
        System.out.println("AddException");
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        instance.add(6, 2);
    }

    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Object e = "uuuu";
        Object a = "aaaaa";
        MyLinkedList instance = new MyLinkedList();
        instance.addFirst(a);
        instance.addFirst(e);
        String expectedResult = "uuuu,aaaaa";
        String actualResult = instance.toString();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddLast() {
        System.out.println("addLast");
        Object e = 4;
        MyLinkedList instance = new MyLinkedList();
        instance.addLast(1);
        instance.addLast(e);
        Object[] expectedResult = {1, 4};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAdd_Object() {
        System.out.println("add");
        Object e = 1;
        MyLinkedList instance = new MyLinkedList();
        instance.add(e);
        Object[] expectedResult = {1};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = MyException.class)
    public void testGetFirstException() {
        System.out.println("getFirst");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.getFirst();
    }

    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        MyLinkedList instance = new MyLinkedList();
        instance.add(3);
        instance.add(2);
        Object expectedResult = 3;
        Object actualResult = instance.getFirst();
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = MyException.class)
    public void testGetLastException() {
        System.out.println("getLast");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.getLast();
    }

    @Test
    public void testGetLast() {
        System.out.println("getLast");
        MyLinkedList instance = new MyLinkedList();
        instance.add(3);
        instance.add(2);
        Object expResult = 2;
        Object result = instance.getLast();
        assertEquals(expResult, result);
    }

    @Test(expected = MyException.class)
    public void testGetException() {
        System.out.println("get");
        int index = 0;
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.get(index);

    }

    @Test
    public void testGet_InBeginning() {
        System.out.println("get");
        int index = 0;
        MyLinkedList instance = new MyLinkedList();
        instance.add(3);
        instance.add(2);
        Object expResult = 3;
        Object result = instance.get(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testGet_inEnd() {
        System.out.println("get");
        int index = 1;
        MyLinkedList instance = new MyLinkedList();
        instance.add(3);
        instance.add(2);
        Object expResult = 2;
        Object result = instance.get(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testGet_inMiddle() {
        System.out.println("get");
        int index = 1;
        MyLinkedList instance = new MyLinkedList();
        instance.add(3);
        instance.add(2);
        instance.add(3);
        Object expResult = 2;
        Object result = instance.get(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testClear() {
        System.out.println("clear");
        MyLinkedList instance = new MyLinkedList();
        instance.add(3);
        instance.add(2);
        instance.add(3);
        instance.clear();
        Object[] expectedResult = {};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsEmptyYes() {
        System.out.println("isEmpty");
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsEmptyNo() {
        System.out.println("isEmpty");
        MyLinkedList instance = new MyLinkedList();
        boolean expResult = false;
        instance.add(2);
        instance.add(3);
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testToArray() {
        System.out.println("toArray");
        MyLinkedList instance = new MyLinkedList();
        instance.add(3);
        Object[] expectedResult = {3};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        MyLinkedList instance = new MyLinkedList();
        instance.add("hh");
        String expResult = "hh";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        MyLinkedList instance = new MyLinkedList();
        instance.add(6);
        instance.add(4);
        Object expResult = 6;
        Object result = instance.removeFirst();
        assertEquals(expResult, result);
    }

    @Test(expected = MyException.class)
    public void testRemoveFirstExeception() {
        System.out.println("removeFirstExeception");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.removeFirst();
    }

    @Test(expected = MyException.class)
    public void testRemoveLastExeception() {
        System.out.println("removeLastExeception");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.removeLast();
    }

    @Test
    public void testRemoveLast() {
        System.out.println("removeLast");
        MyLinkedList instance = new MyLinkedList();
        instance.add(6);
        instance.add(4);
        Object expResult = 4;
        Object result = instance.removeLast();
        assertEquals(expResult, result);
    }

    @Test(expected = MyException.class)
    public void testRemoveExeception() {
        System.out.println("removeLastExeception");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.remove(100);
    }

    @Test
    public void testRemoveInTheMiddle() {
        System.out.println("remove");
        MyLinkedList instance = new MyLinkedList();
        int index = 1;
        instance.add(4);
        instance.add(6);
        instance.add(4);
        Object expResult = 6;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveInTheBeginning() {
        System.out.println("remove");
        MyLinkedList instance = new MyLinkedList();
        int index = 0;
        instance.add(4);
        instance.add(6);
        instance.add(9);
        Object expResult = 4;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveInTheEnd() {
        System.out.println("remove");
        MyLinkedList instance = new MyLinkedList();
        int index = 2;
        instance.add(4);
        instance.add(6);
        instance.add(7);
        Object expResult = 7;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
    }

    @Test(expected = MyException.class)
    public void testSetException() {
        System.out.println("SetLastException");
        MyLinkedList instance = new MyLinkedList();
        Object result = instance.remove(0);
    }

    @Test
    public void testSet() {
        System.out.println("set");
        int index = 1;
        Object e = 100;
        MyLinkedList instance = new MyLinkedList();
        instance.add(12);
        instance.add(12);
        instance.set(index, e);
        Object[] expectedResult = {12, 100};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        instance.add(12);
        int expResult = 1;
        int result = instance.indexOf(12);
        assertEquals(expResult, result);
    }

    public void testIndexOfNotFind() {
        System.out.println("indexOf");
        MyLinkedList instance = new MyLinkedList();
        instance.add(1);
        instance.add(12);
        int expResult = -1;
        int result = instance.indexOf(13);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddAll_ObjectArr() {
        System.out.println("addAll");
        Object[] c = {1, 2, 3};
        MyLinkedList instance = new MyLinkedList();
        instance.addAll(c);
        instance.add(4);
        Object[] expectedResult = {1, 2, 3, 4};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = MyException.class)
    public void testAddAllException_int_ObjectArr() {
        System.out.println("addAll_Exeception");
        int index = -10;
        Object[] c = {1, 2, 3};
        MyLinkedList instance = new MyLinkedList();
        instance.addAll(index, c);
    }

    @Test
    public void testAddAll_int_ObjectArrInTheEnd() {
        System.out.println("addAll");
        MyLinkedList instance = new MyLinkedList();
        int index = 2;
        instance.add(4);
        instance.add(4);
        Object[] c = {1, 2, 3};
        instance.addAll(index, c);
        Object[] expectedResult = {4, 4, 1, 2, 3};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddAll_int_ObjectArrInTheMiddle() {
        System.out.println("addAll");
        MyLinkedList instance = new MyLinkedList();
        int index = 1;
        instance.add(4);
        instance.add(4);
        Object[] c = {1, 2, 3};
        instance.addAll(index, c);
        Object[] expectedResult = {4, 1, 2, 3, 4};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }
}
