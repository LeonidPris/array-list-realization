package myArrayList;

public class MyCollections {
    /**
     * Сортировка вернет новую отсортированную коллекцию
     * Буду разбираться как сделать сортировку передаваемой коллекции
     * */
    public static <T extends Comparable<? super T>> MyList<T> sort(MyList<T> list){
        if (list.size() < 2){
            return list;
        }
        MyList<T> pivot = new MyArrayList<>();
        pivot.add(list.getByIdx(0));
        MyList<T> less = new MyArrayList<>();
        MyList<T> greater = new MyArrayList<>();
        MyList<T> result = new MyArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            T toComp = list.getByIdx(i);
            if (pivot.getByIdx(0).compareTo(toComp) == 0){
                pivot.add(toComp);
            } else if (pivot.getByIdx(0).compareTo(toComp) < 0) {
                greater.add(toComp);
            } else {  //(pillar.getByIdx(0).compareTo(toComp) < 0)
                less.add(toComp);
            }
        }

        result.addAll(sort(less));
        result.addAll(pivot);
        result.addAll(sort(greater));

        return result;
    }
}
