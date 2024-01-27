package myArrayList;

public class Main {
    public static void main(String[] args) {
        // Зачем, у тебя же тесты?
        MyArrayList<String> arrayList = new MyArrayList<>(12);
        System.out.println("Заполнение коллекции."); // все "тесты" в main для наглядности
        arrayList.add("c");
        System.out.println("Длинна коллекции после добавления 1го элемента: " + arrayList.size());
        arrayList.add("a");
        arrayList.add("d");
        arrayList.add("b");
        arrayList.add("e");
        System.out.println("Длинна коллекции после добавления 4го элемента: " + arrayList.size());
        System.out.println("Вывод коллекции: " + arrayList + "\n");

        System.out.println("Добавление элемента '3.5' по индексу 3");
        arrayList.add("c",3);
        System.out.println("Получение элемента по индексу 0: " + arrayList.getByIdx(0));
        System.out.println("Вывод коллекции: " + arrayList + "\n");

        System.out.println("Sorted: " + MyCollections.sort(arrayList) + "\n");

        System.out.println("Удаление и вывод первого вхождения в коллекцию: " + arrayList.removeFirst());
        System.out.println("Вывод коллекции: " + arrayList + "\n");
        System.out.println("Очищение коллекции");
        arrayList.removeAll();
        System.out.println(arrayList);
    }
}
