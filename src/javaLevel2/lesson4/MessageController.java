package javaLevel2.lesson4;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MessageController implements Initializable {
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField messageField;

    public String message = "";

    Main main;

    public MessageController() {

    }



    public void setMain(Main main) {
        this.main = main;


    }

    @FXML
    public void sendMessage() {
        message += messageField.getText() + "\n";
        messageArea.setText(message);
        messageField.clear();
        messageField.requestFocus();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messageField.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode().equals(KeyCode.ENTER)) {
                String text = messageField.getText().trim() + "\n";
                if (!text.isEmpty()) {
                    message+=text;
                    messageArea.setText(message);
                    messageField.clear();
                    messageField.requestFocus();
                }
                event.consume();
            }
        });

    }
}
