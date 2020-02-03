package javaLevel2.lesson2;

public class TestClass {


    private void myArray(String[][] srtArr) throws MyArraySizeException, MyArrayDataException {

        if (srtArr.length != 4 || srtArr[0].length != 4) throw new MyArraySizeException();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (srtArr[i][j].matches("^-?\\d+$")) {
                    sum += Integer.parseInt(srtArr[i][j]);
                } else {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

    }
}
