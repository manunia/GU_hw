package javaLevel2.lesson1;

public class Robot implements Competitable{

    private String robotName;
    private int jumpLimit;
    private int runLimit;

    public Robot(String robotName, int jumpLimit, int runLimit) {
        this.robotName = robotName;
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    public String getRobotName() {
        return robotName;
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
            System.out.println("Робот" + robotName + " не может пробежать " + length);
            System.out.println("Робот" + robotName + " пробежал " + runLimit);
        } else {
            System.out.println("Робот" + robotName + " пробежал " + length);
        }

    }

    @Override
    public void jump(int height) {
        if (height > jumpLimit) {
            System.out.println("Робот" + robotName + " не может прыгнуть " + height);
            System.out.println("Робот" + robotName + " прыгнул " + jumpLimit);
        } else {
            System.out.println("Робот" + robotName + " прыгнул " + height);
        }
    }
}
