package javaLevel2.lesson4;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MessageController {
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField messageField;

    public String message = "";

    Main main;

    public MessageController() {

    }

    public MessageController(String message, Main main) {
        this.message = message;
        this.main = main;

    }

    public void setMain(Main main) {
        this.main = main;


    }

    @FXML
    public void sendMessage() {
        message += messageField.getText() + "\n";
        messageArea.setText(message);
        messageField.setText("");
    }




}
