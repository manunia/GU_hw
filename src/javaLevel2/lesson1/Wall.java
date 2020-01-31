package javaLevel2.lesson1;

public class Wall extends Obstacle{

    private int height;


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    void result(Competitable competitor) {
        System.out.println(competitor);
    }
}
