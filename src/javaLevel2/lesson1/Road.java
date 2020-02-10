package javaLevel2.lesson1;

public class Road extends Obstacle {
    private int lenght;

    public Road(int lenght) {
        super(lenght);
        this.lenght = lenght;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    @Override
    void result() {
        System.out.println("result = " + lenght);
    }
}
