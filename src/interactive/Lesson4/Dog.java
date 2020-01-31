package interCourse.Lesson4;

public class Dog extends Animal {

    private int maxRun;
    private double maxJump = 0.5;
    private int maxSwim = 10;

    public Dog(String name, int age, int maxRun) {
        super(name, age);
        this.maxRun = maxRun;
    }

    @Override
    public void run(int lenght) {
        if (lenght <= maxRun && lenght > 0) {
            System.out.println(this.getName() + " run " + lenght + " m.");
        }
    }

    @Override
    public void swim(int lenght) {
        if (lenght <= maxSwim && lenght > 0) {
            System.out.println(this.getName() + " swim " + lenght + " m.");
        }
    }

    @Override
    public void jump(double height) {
        if (height <= maxJump && height >= 0) {
            System.out.println(this.getName() + " jump " + height + " m.");
        }
    }

}
