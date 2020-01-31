package interactive.Lesson7.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    static int dimension = 3;   //размерность
    static int cellSize = 150;  //размер одной клетки
    private char[][] gameField;   //матрица игры
    private GameButton[] gameButtons;  //массив кнопок

    private Game game; //ссылка на игру

    static char nullSymbol = '\u0000'; //null символ

    public GameBoard(Game currentGame) {
        this.game = currentGame;
        initField();
    }

    /**
     * Метолд инициации и отрисовки игрового поля
     */
    private void initField() {
        //задаем основные настройки окна игры
        setBounds(cellSize * dimension, cellSize * dimension, 400, 300);
        setTitle("Крестики - нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();//Панель управления игрой
        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellSize * dimension, 150);


        JPanel gameFieldPanel = new JPanel();//панель самой игры
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellSize * dimension, cellSize * dimension);

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        //инициализируем игровое поле
        for (int i = 0; i < (dimension * dimension); i++) {
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * Метод очистки поля и матрицы игры
     */
    public void emptyField() {
        for (int i = 0; i < (dimension * dimension); i++) {

            gameButtons[i].setText("");

            int row = i / GameBoard.dimension;
            int cell = i % GameBoard.dimension;

            gameField[row][cell] = nullSymbol;
        }
    }

    Game getGame() {
        return game;
    }

    /**
     * Метод проверки доступности клетки для хода
     *
     * @param x - по горизонтали
     * @param y - по вертикали
     */
    boolean isTurnable(int x, int y) {
        boolean result = false;

        if (gameField[y][x] == nullSymbol) result = true;

        return result;
    }

    /**
     * Обновление матрицы игры после хода
     *
     * @param x - по горизонтали
     * @param y - по вертикали
     */
    void updateGameField(int x, int y) {
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }

    /**
     * Проверка победы по столбцам и линиям
     *
     * @return
     */
    boolean checkWin(char playerSymbol) {
        boolean result = false;
        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)) {
            result = true;
        }
        return result;
    }

    private boolean checkWinLines(char playerSymbol) {
        boolean cols, rows, result;
        result = false;

        for (int col = 0; col < dimension; col++) {
            cols = true;
            rows = true;

            for (int row = 0; row < dimension; row++) {
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol);
            }
            if (cols || rows) {
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean checkWinDiagonals(char playerSymbol) {
        boolean leftRight, rightLeft, result;

        leftRight = true;
        rightLeft = true;
        result = false;

        for (int i = 0; i < dimension; i++) {
            leftRight &= (gameField[i][i] == playerSymbol);//оптимизация кода, чтобы не было через if/else
            rightLeft &= (gameField[dimension - i - 1][i] == playerSymbol);
        }
        if (leftRight || rightLeft) {
            result = true;
        }
        return result;
    }

    /**
     * Метод проверки заполненности поля
     *
     * @return
     */
    boolean isFull() {
        boolean result = true;

        exitForI:
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (gameField[i][j] == nullSymbol) {
                    result = false;
                    break exitForI;
                }
            }
            //System.out.println();
        }
        return result;
    }

    public GameButton getButton(int buttonIndex) {
        return gameButtons[buttonIndex];
    }

    //Та самая логика более умного ПК с алгоритмом подсчета очков для каждой клетки
    //Анализирует самый лучший ход для ПК и выполняет его
    //Это непобедимый ИИ!!! ))))))
    //Возвращает номер кнопки
    public int bestOfBestHod() {
        //Инициирую массив, в котором буду хранить рейтинги возможных ходов
        int[][] arrVesCellDOT_EMPTY = new int[dimension][dimension];
        //Анализ возможных ходов:
        int maxVal = 0;//по максимуму я буду искать ходы с самым высоким рейтингом
        int counMax = 0; //будет использоваться для случайного выбора хода, между несколькими одинаково значимыми ходами
        int cellIndex=0;    //Хранит индекс кнопки расположенная на координатах игрового поля
        exitForX:
        for (int row = 0; row < dimension; row++) {
            for (int cell = 0; cell < dimension; cell++) {
                if (!isTurnable(row, cell)) continue;
                //оценка и фиксация весомости данного хода:
                int val = getVesCell(row, cell);
                if (val == 10) {//10 - значит победа! быстро ставим знак и стебемся над соперником))
                    return GameBoard.dimension * row + cell;
                }
                arrVesCellDOT_EMPTY[row][cell] = val;//Записываю вес хода в копию карты
                if (val > maxVal) {
                    maxVal = val;
                    counMax = 1;
                } else if (maxVal == val) {
                    counMax++;
                }
            }
        }
        //тут код по выбору сомого значимого хода
        //если значимость одинаковая, то случайным образом выбираю ход
        java.util.Random random = new java.util.Random();
        int firsNum = random.nextInt(counMax);
        int kolRepeat = 0;
        exitForX:
        for (int row = 0; row < dimension; row++) {
            for (int cell = 0; cell < dimension; cell++) {
                if (arrVesCellDOT_EMPTY[row][cell] == maxVal) {
                    kolRepeat++;
                }
                if (arrVesCellDOT_EMPTY[row][cell] == maxVal && kolRepeat == firsNum + 1) {
                    cellIndex = GameBoard.dimension * row + cell;
                    break exitForX;
                }
            }
        }

        return  cellIndex;
    }

    //Возвращает вес (рейтинг) для текущего хода!
    int getVesCell(int row, int cell){
        int result=1;//варианты 1,3,4,5,10
        //приоритеты:
        //Главное совершить ход приводящий к выигрышу
        //главное не дать человеку выиграть!
        //ставим временно в эту ячейку крестик и проверяем, явл. это решающим ходом еловека или нет
        char curCharPK = game.getCurrentPlayer().getPlayerSign();
        char curCharHuman = game.getNotCurrentPlayer().getPlayerSign();
        gameField[cell][row] =curCharPK ;
        if(checkWin(curCharPK)){//Это может быть решающим ходом ПК!
            //ставим максимальный вес:
            result=(result<10)?10:result;
        }
        gameField[cell][row] = curCharHuman;
        if(checkWin(curCharHuman)){//Это может быть решающим ходом человека!
            //ставим вес:
            result=(result<5)?5:result;
        }

        if(row==1 && cell==1){//Приоритетное место на поле - центр
            //ставим вес:
            result=(result<4)?4:result;
        }
        //Угловые позиции имеют вес поменьше:
        if((row==0 && cell==0) || (row==dimension-1 && cell==0) ||(row==0 && cell==dimension-1)|| (row== dimension-1 && cell==dimension-1)){
            //ставим вес:
            result=(result<3)?3:result;
        }

        gameField[cell][row] = nullSymbol;//откатываем изменения
        return  result;
    }
}
