package javaLevel2.lesson1;

public class Cat implements Competitable {
    private String catName;
    private int jumpLimit;
    private int runLimit;

    public Cat(String catName, int jumpLimit, int runLimit) {
        this.catName = catName;
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    public String getCatName() {
        return catName;
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
            System.out.println("Кот" + catName + " не может пробежать " + length);
            System.out.println("Кот" + catName + " пробежал " + runLimit);
        } else {
            System.out.println("Кот" + catName + " пробежал " + length);
        }
    }

    @Override
    public void jump(int height) {
        if (height > jumpLimit) {
            System.out.println("Кот" + catName + " не может прыгнуть " + height);
            System.out.println("Кот" + catName + " прыгнул " + jumpLimit);
        } else {
            System.out.println("Кот" + catName + " прыгнул " + height);
        }
    }
}
