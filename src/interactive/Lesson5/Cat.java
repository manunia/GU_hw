package interactive.Lesson5;

public class Cat extends Animal {

    private int appetite;
    private boolean satiety = false;

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, int runLimit, int jumpLimit) {
        super("Cat " + name);
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public void eat(Bowl bowl, int appetite) {
        this.appetite = appetite;
        if (bowl.getCount() < appetite) {
            satiety = false;
            return;
        }
        while (appetite > 0 || bowl.getCount() > 0) {
            bowl.setCount(appetite);
            --appetite;
        }
        satiety = true;
    }

    public boolean isSatiety() {
        return satiety;
    }

    @Override
    public void swim(int lenght) {
        System.out.println("Cat can't swim");
    }

}
