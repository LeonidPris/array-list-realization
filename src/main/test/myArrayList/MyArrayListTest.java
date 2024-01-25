package myArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyArrayList<String> arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new MyArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");

    }

    @Test
    void length() {
        assertEquals(6, arrayList.length());
    }

    @Test
    void getByIdx() {
        assertEquals("1",arrayList.getByIdx(0));
    }

    // имена методов не информативны
    // не используется given when then
    @Test
    void add() {
        assertEquals(6, arrayList.length());
        arrayList.add("7");
        assertEquals(7, arrayList.length());
        assertEquals("7", arrayList.getByIdx(6));
    }

    @Test
    void addByIdx() {
        arrayList.addByIdx("99",0);
        assertEquals("99", arrayList.getByIdx(0));
    }


    @Test
    void removeFirst() {
        assertEquals("1", arrayList.removeFirst());
        assertEquals(5, arrayList.length());
    }

    @Test
    void removeAll() {
        arrayList.removeAll();
        assertEquals(0, arrayList.length());
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
           arrayList.addByIdx("123", 5);
        });
    }


}