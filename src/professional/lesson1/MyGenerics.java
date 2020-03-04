package professional.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyGenerics <T> {

    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5,6};
        Fruit[] fruits = {new Fruit("apple", 1.0f),
                new Fruit("grape", 17.8f),
                new Fruit("melon", 4.0f),
                new Fruit("pineapple", 1.5f),
                new Fruit("bananas", 2.9f)};

        MyGenerics<Integer> integerMyGenerics = new MyGenerics<>();
        MyGenerics<Fruit> fruitMyGenerics = new MyGenerics<>();
        System.out.println("Before swap: ");
        System.out.println("Integers " + Arrays.asList(integers));
        System.out.println("Fruits " + Arrays.asList(fruits));
        integerMyGenerics.swap(integers,3,5);
        fruitMyGenerics.swap(fruits,2,1);
        System.out.println("Before swap: ");
        System.out.println("Integers " + Arrays.asList(integers));
        System.out.println("Fruits " + Arrays.asList(fruits));
        System.out.println("Convert to Array List:");
        System.out.println("Integers " +integerMyGenerics.arrayToArrayList(integers));
        System.out.println("Fruits " +fruitMyGenerics.arrayToArrayList(fruits));
    }

    public void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public ArrayList<T> arrayToArrayList(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        return arrayList;
    }
}
