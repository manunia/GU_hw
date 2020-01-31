package interCourse.Lesson4;

public abstract class Animal {

    public String name;
    public int age;


    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public abstract void run(int lenght);
    public abstract void swim(int lenght);
    public abstract void jump(double height);
}
