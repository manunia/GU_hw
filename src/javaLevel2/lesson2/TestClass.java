package javaLevel2.lesson2;

public class TestClass {


    private void myArray(String[][] srtArr) throws MyArraySizeException {

        if (srtArr.length != 4) throw new MyArraySizeException();

    }
}
