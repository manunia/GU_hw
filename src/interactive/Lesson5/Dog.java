package interactive.Lesson5;

public class Dog extends Animal {

    public Dog(String name, int runLimit, int jumpLimit, int swimLimit) {
        super("Dog " + name);
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
        this.runLimit = runLimit;
    }



}
