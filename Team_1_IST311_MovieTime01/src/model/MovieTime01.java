package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;

public class MovieTime01 extends Application {

    private static final SimpleDateFormat FMT_YEAR = new SimpleDateFormat("yyyy");

    public static void main(String[] args) {
        System.out.println("Team #1");
        System.out.println("Your Name");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
