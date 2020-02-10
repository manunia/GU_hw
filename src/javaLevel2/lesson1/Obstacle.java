package javaLevel2.lesson1;

public abstract class Obstacle {
    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Obstacle(int size) {
        this.size = size;
    }

    abstract void result();
}
