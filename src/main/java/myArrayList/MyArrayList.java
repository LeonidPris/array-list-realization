package myArrayList;

import java.util.Arrays;
import java.util.Objects;

// Хорошо, что подробно задокументировал, ведь такое и было задание
// но не забывай, что на практике комменты должны быть сжаты, и должны создаваться только в тех местах,
// где они действительно необходимы
/**
 * Реализация интерфейса MyList. Является коллекцией элементов способной хранить элементы указанного типа <Т>
 * @author LeonidPris
 */
public class MyArrayList<T> implements MyList<T> {
    /**
     * Поле arr являющеяся массивом элементов. Предназначаено для заполнения элементами.
     * */
    private T[] arr;
    /**
     * Поле length является счетчиком длинны коллекции
     * */
    private int length = 0;

    /**
     * По умолчанию, без параметров, новый массив содержит 10 элементов
     * */
    public MyArrayList() {
        this.arr = (T[]) new Object[10];
    }

    /**
     * @param length отвечает за длинну коллекции при ее инициалицации
     * */
    public MyArrayList(int length) {
        this.arr = (T[]) new Object[length];
    }


    /**
     *  Метод добавляет, переданный к качестве параметра, элемент в конец коллекции.
     * @param item элемент, который должен быть помещен в коллекцию
     * */
    public void add(T item) {
        if (arr.length > length) {
            arr[length++] = item;
        }
        increaseAndCopyArray(); // можно так упростить
        arr[length++] = item;
    }


    /**
     * Метод добавляет, переданный к качестве аргумента, элемент в коллекцию по указанному индексу.
     * При этом элементы с большим индексом, чем переданный будут смещены относительно него.
     * Если в процессе добавления места в массиве arr не хватит, он будет расширен.
     * @param item элемент, который должен быть помещен в коллекцию
     * @param idx индекс заменяемого на item элемента
     * @throws ArrayIndexOutOfBoundsException будет выброшен, если idx для вставки будет превышать размер коллекции
     * */
    public void addByIdx(T item, int idx) {
        if (idx >= length) throw new ArrayIndexOutOfBoundsException();
        if (arr.length == length + 1) increaseAndCopyArray(); // плохая практика использовать if без {}

        T oldItem;
        for (int i = idx; i < length + 1; i++) { // может copyOfRange + stream? вполне, но так быстрее, поэтому хорошо
            oldItem = arr[i];
            arr[i] = item;
            item = oldItem;
        }
        length++;
    }
    /**
     * Метод возвращает элемент по указанному индексу
     * @param idx интекс искомого элемента
     * @throws ArrayIndexOutOfBoundsException будет выброшен, если idx для вставки будет превышать размер коллекции
     * */
    public T getByIdx(int idx) {
        if (idx >= length) throw new ArrayIndexOutOfBoundsException();
        return arr[idx];
    }

    /**
     * Метод возвращает первый элемент и удаляет его из коллекции.
     * Длинна коллекции при этом так-же уменьшается.
     * @throws ArrayIndexOutOfBoundsException будет выброшен, если коллекция пуста
     * */
    public T removeFirst() {
        if (length == 0) throw new ArrayIndexOutOfBoundsException("Empty collection");// тут больше подойдет IllegalState
        T removedItem = arr[0];
        arr = Arrays.copyOfRange(arr, 1, length--);
        return removedItem;
    }

    /**
     * Метод очищает коллекцию, задавая ей значения по умончанию
     * */
    public void removeAll() {
        arr = (T[]) new Object[10];
        length = 0;
    }

    /**
     * Метод возвращает длинну коллекции
     * */
    public int length() {
        return length;
    }
    /**
     * Метод toString() переопределен таким образом, чтоб возвращать все элементы коллекции, но не массива arr
     * */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(arr, 0, length));
    }

    /**
     * Если в процессе добавления нового элемента в массиве arr не хватит места,
     * он будет расширен по формуле length*3/2+1.
     * */
    private void increaseAndCopyArray() {
        arr = Arrays.copyOf(arr, (length * 3) / 2 + 1);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return length == that.length && Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }
}
