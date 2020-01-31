package interactive;
/*
Maria L
 */
public class Lesson2 {

    public static void main(String[] args) {
        int[] a1 = {1,1,0,0,1,0,1,1,0,0};
        oneToZero(a1);
        printArr(a1);
        fillArr();
        multiplyElem();
        onesDiag(5);
        minAndMax();
        int[] a2 = {2,1,1,2,1};
        System.out.println(checkBalance(a2,0));
        displaceElem(a1,2);

    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static void oneToZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else if (arr[i] == 1) arr[i] = 0;
        }
    }

    //2. Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    private static void fillArr() {
        int[] arr = new int[8];
        for (int i = 0, j = 0; i < arr.length; i++, j+=3) {
            arr[i] = j;
        }
        printArr(arr);
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом,
    // и числа, меньшие 6, умножить на 2;
    private static void multiplyElem() {
        int[] arr = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i]*=2;
        }
        printArr(arr);
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    private static void onesDiag(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || j == (size - i - 1)) {
                    arr[i][j] = 1;
                }
            }
        }
        printMatrix(arr);
    }

    //5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    private static void minAndMax() {
        int arr[] = new int[(int) (Math.random()*100)];
        //fill array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*15);
        }
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) max = arr[i];
        }
        printArr(arr);
        System.out.println("MIN = " + min + "; MAX = " + max);
    }

    //6. Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true,
    // граница показана символами ||, эти символы в массив не входят;
    private static boolean checkBalance(int[] arr, int border) {
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < border; i++) {
            leftSum+=arr[i];
        }
        for (int i = border; i < arr.length; i++) {
            rightSum+=arr[i];
        }
        if (leftSum == rightSum) return true;
        else return false;
    }

    //7. *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или
    // отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    // Нельзя пользоваться вспомогательными массивами.
    private static void displaceElem(int[] arr, int n) {
        printArr(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = n; j >= 0 ; j--) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;

            }
        }
        printArr(arr);
    }

    //print array to terminal
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    private static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
