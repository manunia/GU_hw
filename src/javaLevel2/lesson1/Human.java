package javaLevel2.lesson1;

public class Human implements Competitable {

    private String name;
    private int jumpLimit;
    private int runLimit;

    public Human(String name, int jumpLimit, int runLimit) {
        this.name = name;
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    public String getName() {
        return name;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    public int getRunLimit() {
        return runLimit;
    }

    @Override
    public void run(int length) {
        if (length > runLimit) {
            System.out.println("Человек " + name + "не может пробежать " + length);
            System.out.println("Человек " + name +  "пробежал " + runLimit);
        } else {
            System.out.println("Человек " + name +  " пробежал " + length);
        }

    }

    @Override
    public void jump(int height) {
        if (height > jumpLimit) {
            System.out.println("Человек " + name + " не может прыгнуть " + height);
            System.out.println("Человек " + name + " прыгнул " + jumpLimit);
        } else {
            System.out.println("Человек " + name + " прыгнул " + height);
        }
    }
}
