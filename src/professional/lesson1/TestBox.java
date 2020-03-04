package professional.lesson1;

import java.util.ArrayList;

public class TestBox {
    public static void main(String[] args) {
        ArrayList<Orange> oranges = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            oranges.add(new Orange());
        }
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            apples.add(new Apple());
        }
        Box<Apple> appleBox = new Box<>(apples);
        Box<Orange> orangeBox = new Box<>(oranges);
        //test of method getWeight()
        System.out.println("Apple box weight " + appleBox.getWeight());
        System.out.println("Orange box weight " + orangeBox.getWeight());

        //test of method compare()
        ArrayList<Apple> apples2 = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            apples.add(new Apple());
        }
        Box<Apple> appleBox2 = new Box<>(apples2);
        System.out.println(appleBox.compare(appleBox2));

        //test of method pourInto
        appleBox2.pourInto(appleBox);
        System.out.println("Apple box weight after pour " + appleBox.getWeight());
        System.out.println("Apple box weight after pour " + appleBox2.getWeight());
        appleBox.pourInto(appleBox);
        //orangeBox.pourInto(appleBox);

        //test of method add
        appleBox.addFruitInBox(new Apple());
        System.out.println("Apple box weight after add " + appleBox.getWeight());
    }
}
