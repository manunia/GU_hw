package interactive.Lesson7.game;

import javax.swing.*;

public class Game {
    private GameBoard board;    //ссылка на игровое поле
    private GamePlayer [] gamePlayers = new GamePlayer[2];  //МАССИВ ИГРОКОВ
    private int playersTurn = 0; //индекс текущего поля

    public final  boolean SILLY_MODE = false;
    public Game(){
        this.board = new GameBoard(this);
    }
    public void initGame(){
        gamePlayers[0] = new GamePlayer(true,'X');
        gamePlayers[1] = new GamePlayer(false,'O');
    }

    /**
     * Метод передачи хода
     */
    void passTurn(){
        if(playersTurn ==0)
            playersTurn =1;
        else
            playersTurn =0;
    }

    /**
     * получение объекта текущего игрока
     * @return GamePlayer объект игрока
     */
    GamePlayer getCurrentPlayer(){
        return gamePlayers[playersTurn];
    }
    GamePlayer getNotCurrentPlayer(){
        int notPlayersTurn = (playersTurn==0)?1:0;
        return gamePlayers[notPlayersTurn];
    }

    /**
     * Метод показа popup-a для пользователя
     * @param messageText - текст сообщения
     */
    void showMessage(String messageText){
        JOptionPane.showMessageDialog(board, messageText);
    }
}
