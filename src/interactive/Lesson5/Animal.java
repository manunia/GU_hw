package interactive.Lesson5;

public abstract class Animal {

    protected String name;
    protected int runLimit = 0;
    protected double jumpLimit = 0;
    protected int swimLimit = 0;

    public Animal() {
        this.name = "Animal";
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run(int lenght) {
        if (runLimit > 0 && lenght <= runLimit) {
            System.out.println(this.name + " run " + lenght + " m.");
        } else {
            System.out.println(this.name + " can't run more then " + runLimit + " m.");
        }
    }
    public void swim(int lenght) {
        if (swimLimit > 0 && lenght <= swimLimit) {
            System.out.println(this.name + " swem " + lenght + " m.");
        } else {
            System.out.println(this.name + " can't swim more then " + swimLimit + " m.");
        }
    }
    public void jump(double height) {
        if (jumpLimit > 0 && height <= jumpLimit) {
            System.out.println(this.name + " jumped " + height + " m.");
        } else {
            System.out.println(this.name + " can't jump more then " + jumpLimit + " m.");
        }
    }
}
