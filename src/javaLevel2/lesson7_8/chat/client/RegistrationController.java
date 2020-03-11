package javaLevel2.lesson7_8.chat.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {
    @FXML
    public TextField loginField;
    @FXML
    public TextField nickField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField confirmPasswordField;
    Controller controller;

    public void clickOk(ActionEvent actionEvent) {
        controller.tryRegistr(loginField.getText(), nickField.getText(),
                passwordField.getText(), confirmPasswordField.getText());
    }
}
