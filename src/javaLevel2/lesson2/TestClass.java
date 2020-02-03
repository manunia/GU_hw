package javaLevel2.lesson2;

public class TestClass {

    public static void main(String[] args) {
        String[][] strings = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","+","3","4"}
        };
        try {
            myArray(strings);
        } catch (MyArraySizeException e) {
            System.out.println(e.toString());
        } catch (MyArrayDataException e) {
            System.out.println(e.toString());
        }

    }


    private static void myArray(String[][] srtArr) throws MyArraySizeException, MyArrayDataException {

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
        System.out.println(sum);

    }
}
