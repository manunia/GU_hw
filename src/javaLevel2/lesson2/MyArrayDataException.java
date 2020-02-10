package javaLevel2.lesson2;

public class MyArrayDataException extends Exception {
    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "Invalid data in sell " + i + " " + j;
    }
}
