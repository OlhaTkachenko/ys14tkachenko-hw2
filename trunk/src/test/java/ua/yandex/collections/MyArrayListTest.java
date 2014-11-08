package ua.yandex.collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTest {

    public MyArrayListTest() {
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
    public void testMyArrayList() {
        System.out.println("MyArrayList");
        MyArrayList instance = new MyArrayList(5);
        int expResult = 5;
        int result = instance.arrayListMaxSize();
        assertEquals(expResult, result);
    }

    @Test
    public void testEnsureCapacity() {
        System.out.println("ensureCapacity");
        int newCapacity = 5;
        MyArrayList instance = new MyArrayList();
        instance.ensureCapacity(newCapacity);
        int expResult = 5;
        int result = instance.arrayListMaxSize();
        assertEquals(expResult, result);
    }

    @Test
    public void testAdd_Object() {
        System.out.println("add");
        Object[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MyArrayList instance = new MyArrayList();
        instance.addAll(array);
        instance.add(4);
        Object[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = MyException.class)
    public void testAddException_int_Object() {
        System.out.println("AddException");
        MyArrayList instance = new MyArrayList();
        instance.add(1);
        instance.add(2, 2);
    }

    @Test
    public void testAdd_int_Object() {
        System.out.println("add");
        Object[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MyArrayList instance = new MyArrayList();
        instance.addAll(array);
        instance.add(1, '2');
        Object[] expectedResult = {1, '2', 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddAllWithEnsureCapacity_Object() {
        System.out.println("add");
        Object[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MyArrayList instance = new MyArrayList();
        instance.addAll(array);
        instance.addAll(array);
        Object[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddAllWithEnsureCapacity_int_Object() {
        System.out.println("add");
        Object[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MyArrayList instance = new MyArrayList();
        instance.addAll(array);
        instance.addAll(10, array);
        Object[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddAll_ObjectArr() {
        System.out.println("addAll");
        Object[] c = {1, 2, 3};
        MyArrayList instance = new MyArrayList();
        instance.addAll(c);
        instance.add(4);
        Object[] expectedResult = {1, 2, 3, 4};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = MyException.class)
    public void testAddAllException_int_ObjectArr() {
        System.out.println("addAll_Exeception");
        int index = 10;
        Object[] c = {1, 2, 3};
        MyArrayList instance = new MyArrayList();
        instance.addAll(index, c);
    }

    @Test
    public void testAddAll_int_ObjectArr() {
        System.out.println("addAll");
        MyArrayList instance = new MyArrayList();
        int index = 2;
        instance.add(4);
        instance.add(4);
        Object[] c = {1, 2, 3};
        instance.addAll(index, c);
        Object[] expectedResult = {4, 4, 1, 2, 3};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = MyException.class)
    public void testGetException() {
        System.out.println("get");
        int index = 10;
        MyArrayList instance = new MyArrayList();
        Object result = instance.get(index);

    }

    @Test
    public void testGet() {
        System.out.println("get");
        int index = 1;
        MyArrayList instance = new MyArrayList();
        instance.add(3);
        instance.add(2);
        instance.add(4);
        Object expResult = 2;
        Object result = instance.get(index);
        assertEquals(expResult, result);
    }

    @Test(expected = MyException.class)
    public void testRemoveExeception() {
        System.out.println("removeLastExeception");
        MyArrayList instance = new MyArrayList();
        Object result = instance.remove(100);
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        MyArrayList instance = new MyArrayList();
        int index = 1;
        instance.add(4);
        instance.add(6);
        instance.add(4);
        Object expResult = 6;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testSet() {
        System.out.println("set");
        int index = 1;
        Object e = 100;
        MyArrayList instance = new MyArrayList();
        instance.add(12);
        instance.add(12);
        instance.set(index, e);
        Object[] expectedResult = {12, 100};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = MyException.class)
    public void testSetExeception() {
        System.out.println("SetExeception");
        MyArrayList instance = new MyArrayList();
        instance.add(2);
        instance.set(1, '4');
    }

    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        MyArrayList instance = new MyArrayList();
        instance.add(1);
        instance.add(12);
        int expResult = 1;
        int result = instance.indexOf(12);
        assertEquals(expResult, result);
    }

    @Test
    public void testIndexOfNotFind() {
        System.out.println("indexOf");
        MyArrayList instance = new MyArrayList();
        instance.add(1);
        instance.add(12);
        int expResult = -1;
        int result = instance.indexOf(13);
        assertEquals(expResult, result);
    }

    @Test
    public void testSize() {
        System.out.println("size");
        MyArrayList instance = new MyArrayList();
        instance.add(5);
        instance.add(5);
        int expResult = 2;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testClear() {
        System.out.println("clear");
        MyArrayList instance = new MyArrayList();
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
        MyArrayList instance = new MyArrayList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsEmptyNo() {
        System.out.println("isEmpty");
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        instance.add(2);
        instance.add(3);
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testToArray() {
        System.out.println("toArray");
        MyArrayList instance = new MyArrayList();
        instance.add(3);
        Object[] expectedResult = {3};
        Object[] actualResult = instance.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        MyArrayList instance = new MyArrayList();
        instance.add("hh");
        instance.add("hh");
        String expResult = "hh,hh";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test(expected = MyException.class)
    public void testcheckBorderForAdd() {
        System.out.println("toArray");
        MyArrayList instance = new MyArrayList();
        instance.add(3);
        instance.add(3);
        instance.checkBorderForAdd(3);
    }

    @Test(expected = MyException.class)
    public void testcheckBorderForAccess() {
        System.out.println("toArray");
        MyArrayList instance = new MyArrayList();
        instance.add(3);
        instance.add(3);
        instance.checkBorderForAccess(2);
    }
}
