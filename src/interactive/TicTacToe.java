package interactive;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    //объявляем переменные
    public static char[][] map;//массив для игрового поля
    public static final int SIZE = 5;//размер поля
    public static final int DOTTS_TO_WIN = 4;//количество фишек для победы

    public static final char DOT_EMPTY = '*';//символ пустого поля
    public static final char DOT_X = 'X';//символ крестика
    public static final char DOT_O = 'O';//символ нолика
    //создадим сканер для хода игрока
    public static Scanner sc = new Scanner(System.in);
    //генератор случайных чисел для хода компьютера
    public static Random rand = new Random();

    public static int scoreH = 0, scoreC = 0;//очки для человека и ИИ

    public static void main(String[] args) {
        initMap();//при запуске программы инициализируем поле
        printMap();//печатаем массив в консоль
        //основной игровой цикл
        while (true) {
            humanTum();
            scoreH++;
            printMap();
            if (checkWin0(DOT_X)) {
                System.out.println("Победил человек.");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья.");
                break;
            }
            aiTum();
            scoreC++;
            printMap();
            if (checkWin0(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект.");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья.");
                break;
            }
        }
        System.out.println("Игра закончена. Человек заработал " + scoreH + " очков, ИИ заработал " + scoreC + " очков.");
    }
    //создаем поле
    public static void initMap() {
        map = new char[SIZE][SIZE];//инициализируем массив поля
        for (int i = 0; i < SIZE; i++)//заполняем массив
            for (int j=0; j<SIZE; j++) map[i][j] = DOT_EMPTY;//символами пустого поля
    }
    //печатем поле в консоль
    public static void printMap() {
        for (int i = 0; i <= SIZE ; i++) System.out.print(i + " ");//напечатаем номера столбцов
        System.out.println();//пустая строка
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1));//печатаем номера строк
            for (int j = 0; j < SIZE; j++) System.out.print(" " + map[i][j]);//печатаем элементы массива
            System.out.println();
        }
        System.out.println();
    }
    //метод, отвечающий за ход игрока
    public static void humanTum(){
        int x, y;//координаты хода
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;//координаты от 0 до 3
            y = sc.nextInt() - 1;
        } while (!isCellValid(x,y));//проверяем правильность ввода координат
        map[y][x] = DOT_X;
    }
    //проверяем свободна ли ячейка
    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;//если введенные координаты выходят за пределы
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    //метод хода компьютера
    public static void aiTum(){
        int x, y;
        x=0;y=0;
        //аналогично проверке выигрыша будем проверять наличие рядом стоящих символов
        for (int i = 0; i < 3; i++) {//будем проверять перемещение квадрата в поле
            for (int j = 0; j < 3; j++) {
                do {//проверяем, может ли он победить за один ход или помешать игроку победить
                    if (checkDiagonal(DOT_O, i, j, DOTTS_TO_WIN-1) || checkDiagonal(DOT_X, i, j, DOTTS_TO_WIN-1)) {
                        x = rand.nextInt(DOTTS_TO_WIN-1);
                        y = rand.nextInt(DOTTS_TO_WIN-1);
                        break;
                    }
                    if (checkLines(DOT_O, i, j, DOTTS_TO_WIN-1) || checkLines(DOT_O, i, j, DOTTS_TO_WIN-1)) {
                        x = rand.nextInt(DOTTS_TO_WIN-1);
                        y = rand.nextInt(DOTTS_TO_WIN-1);
                        break;
                    } else {
                        x = rand.nextInt(SIZE);
                        y = rand.nextInt(SIZE);
                        break;
                    }
                } while (!isCellValid(x,y));

            }
        }
        System.out.println("Компьютер походил в точку " + ( x + 1 ) + " " + ( y + 1 ));
        map[y][x] = DOT_O;
    }
    //проверка победы
    public static boolean checkWin0 ( char symb ) {
        for (int col = 0; col < 2; col++) {//будем проверять перемещение квадрата 4х4 в поле
            for (int row = 0; row < 2; row++) {
                if (checkDiagonal(symb, col, row, DOTTS_TO_WIN) || checkLines(symb, col, row, DOTTS_TO_WIN)) return true;//делаем проверку диагонали или линий квадрата
            }
        }
        return false ;
    }
    //проверка линий квадрата размером с число победных фишек
    private static boolean checkLines(char symb, int dx, int dy, int len) {
        boolean cols, rows;//введем булевы переменные проверки столбцов и строк
        for (int col = dx; col < len + dx; col++){
            cols = true;
            rows = true;
            for (int row = dy; row < len + dy; row++){//сравниваем каждую клетку с символом
                cols = cols & (map[col][row] == symb);
                rows = rows & (map[row][col] == symb);
            }
            if (cols || rows) return true;
        }
        return false;
    }

    private static boolean checkDiagonal(char symb, int dx, int dy, int len) {
        boolean toright, toleft;//логические переманные проверки прямой и обратной диагоналей
        toright = true;
        toleft = true;
        for (int i = 0; i < len; i++) {
            toright = toright & (map[i + dx][i + dy] == symb);//сравниваем каждую клетку с символом, при этом учитываем смещение квадрата внутри поля
            toleft = toleft & (map[(len - i - 1) + dx][i + dy] == symb);
        }
        if (toright || toleft) return true;
        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; i < SIZE; i++) if (map[i][j] == DOT_EMPTY) return false;
        }
        return true;
    }
}
