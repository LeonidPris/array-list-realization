package myArrayList;

public class Main {
    public static void main(String[] args) {
        // Зачем, у тебя же тесты?
        MyArrayList<String> arrayList = new MyArrayList<>(12);
        System.out.println("Заполнение коллекции.");
        arrayList.add("1");
        System.out.println("Длинна коллекции после добавления 1го элемента: " + arrayList.length());
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        System.out.println("Длинна коллекции после добавления 4го элемента: " + arrayList.length());
        System.out.println("Вывод коллекции: " + arrayList + "\n");

        System.out.println("Добавление элемента '3.5' по индексу 3");
        arrayList.addByIdx("3.5",3);
        System.out.println("Получение элемента по индексу 0: " + arrayList.getByIdx(0));
        System.out.println("Вывод коллекции: " + arrayList + "\n");

        System.out.println("Удаление и вывод первого вхождения в коллекцию: " + arrayList.removeFirst());
        System.out.println("Вывод коллекции: " + arrayList + "\n");

        System.out.println("Очищение коллекции");
        arrayList.removeAll();
        System.out.println(arrayList);
    }
}
