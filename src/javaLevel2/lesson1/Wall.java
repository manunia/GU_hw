package javaLevel2.lesson1;

public class Wall extends Obstacle{

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    void result() {
        System.out.println("result = " + height);
    }
}
