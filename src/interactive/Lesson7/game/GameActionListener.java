package interactive.Lesson7.game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {


    private  GameButton button;
    public GameActionListener(GameButton gButton) {

        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        int row = button.getButtonIndex()/GameBoard.dimension;
        int cell = button.getButtonIndex()%GameBoard.dimension;
        if (board.isTurnable(row,cell)){
            board.getGame().getCurrentPlayer().updateByPlayerData(button);

            if(board.isFull()){
                board.getGame().showMessage("Ничья!");
                board.emptyField();
            }else if(!board.getGame().getCurrentPlayer().isRealPlayer()){
                board.getGame().getCurrentPlayer().updateByAiData(button);
            }
        }else {
            board.getGame().showMessage("Некорректный ход!");
        }
    }

}
