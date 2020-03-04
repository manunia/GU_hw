package professional.lesson1;

public class Orange extends Fruit {
    private final String name = "orange";
    private final float orangeWeight = 1.5f;
    public Orange() {
        super.setWeight(orangeWeight);
        super.setName(name);
    }
}
