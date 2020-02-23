package javaLevel2.lesson4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    Scene scene;

    public Scene getScene() {
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("messageView.fxml"));
        primaryStage.setTitle("Message View");
        scene = new Scene(root, 850, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
