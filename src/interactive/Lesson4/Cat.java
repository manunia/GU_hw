package interCourse.Lesson4;

public class Cat extends Animal {

    private int maxRun = 200;
    private double maxJump = 2.0;

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void run(int lenght) {
        if (lenght <= maxRun && lenght > 0) {
            System.out.println(this.getName() + " run " + lenght + " m.");
        }
    }

    @Override
    public void swim(int lenght) {
        System.out.println("Cat can't swim");
    }

    @Override
    public void jump(double height) {
        if (height <= maxJump && height >= 0) {
            System.out.println(this.getName() + " jump " + height + " m.");
        }
    }
}
