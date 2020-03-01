package professional.lesson1;

public class Fruit {

    private String name;
    private float weight;

    public Fruit(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public Fruit() {
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
