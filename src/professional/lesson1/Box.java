package professional.lesson1;

import java.util.ArrayList;

public class Box<F extends Fruit> {

    ArrayList<F> fruits;

    public Box(ArrayList<F> fruits) {
        this.fruits = fruits;
    }

    public float getWeight() {
        float sumWeight = 0.0f;
        for (F f:fruits) {
            sumWeight+=f.getWeight();
        }
        return sumWeight;
    }

    public boolean compare(Box<F> toCompareBox) {
        if (Math.abs(this.getWeight() - toCompareBox.getWeight()) < 0.00001) {
            return true;
        }
        return false;
    }

    public void pourInto(Box<F> box) {
        box.fruits.addAll(this.fruits);
        this.fruits.removeAll(fruits);
    }

    public void addFruitInBox(F fruit) {
        fruits.add(fruit);
    }


}
