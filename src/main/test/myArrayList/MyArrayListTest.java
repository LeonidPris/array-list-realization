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
    void Given_CorrectSize() {
        assertEquals(6, arrayList.size());
    }

    @Test
    void Given_CorrectElementByIdx() {
        assertEquals("1",arrayList.getByIdx(0));
    }

    @Test
    void Should_AddNewElementToTheEndOfCollection() {
        assertEquals(6, arrayList.size());
        arrayList.add("7");
        assertEquals(7, arrayList.size());
        assertEquals("7", arrayList.getByIdx(6));
    }

    @Test
    void Should_AddNewElementByIdx() {
        arrayList.add("99",0);
        assertEquals("99", arrayList.getByIdx(0));
    }


    @Test
    void Should_RemoveFirstElement_And_ReduceLength() {
        assertEquals("1", arrayList.removeFirst());
        assertEquals(5, arrayList.size());
    }

    @Test
    void When_IdxOutOfBounds_Then_ThrowException() {
        arrayList.removeAll();
        assertEquals(0, arrayList.size());
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
           arrayList.add("123", 5);
        });
    }


}