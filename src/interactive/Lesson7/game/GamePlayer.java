package interactive.Lesson7.game;

import java.util.Random;

public class GamePlayer {
    private char playerSign;
    private boolean realPlayer = true;

    public GamePlayer(boolean isRealPlayer, char playerSign){
        this.realPlayer = isRealPlayer;
        this.playerSign = playerSign;
    }
    public boolean isRealPlayer(){return  realPlayer;}
    public char getPlayerSign(){
        return playerSign;
    }

    public void updateByAiData(GameButton button) {
        //Индекс кнопки
        int cellIndex;
        //координаты поля на игровом поле
        int row, cell;
        if (button.getBoard().getGame().SILLY_MODE) {
            Random rnd = new Random();
            //Генерация координат хода компьютера
            do {
                row = rnd.nextInt(GameBoard.dimension);
                cell = rnd.nextInt(GameBoard.dimension);
            } while (!button.getBoard().isTurnable(row, cell));


            cellIndex= GameBoard.dimension * row + cell;
        } else {//подключаем ИИ
            cellIndex = button.getBoard().bestOfBestHod();
            row = cellIndex / GameBoard.dimension;
            cell = cellIndex % GameBoard.dimension;
        }

        //Обновить матрицу игры
        button.getBoard().updateGameField(row, cell);
        //обновить содержимое кнопки
        char curPlayerChar = button.getBoard().getGame().getCurrentPlayer().getPlayerSign();
        button.getBoard().getButton(cellIndex).setText(Character.toString(curPlayerChar));

        //проверть победу
        if (button.getBoard().checkWin(curPlayerChar)) {
            button.getBoard().getGame().showMessage("ПК выиграл");
            //button.getBoard().emptyField();
        } else {
            //передать ход
            button.getBoard().getGame().passTurn();
        }
    }

    /**
     * Ход человека
     * @param button GameButton - ссылка на кнопку
     */
    public void updateByPlayerData(GameButton button) {
        int row = button.getButtonIndex() / button.getBoard().dimension;
        int cell = button.getButtonIndex() % button.getBoard().dimension;

        //Обновить матрицу игры
        button.getBoard().updateGameField(row,cell);
        //Обновить содержимое кнопки
        char curPlayerChar = button.getBoard().getGame().getCurrentPlayer().getPlayerSign();
        button.setText(Character.toString(curPlayerChar));
        if(button.getBoard().checkWin(curPlayerChar)){
            button.getBoard().getGame().showMessage("Вы выиграли");
            //button.getBoard().emptyField();
        }else {
            button.getBoard().getGame().passTurn();
        }
    }
}
