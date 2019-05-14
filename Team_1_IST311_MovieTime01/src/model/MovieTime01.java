package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;

/**
 * @author Phil O'Connell <pxo4@psu.edu>
 */
public class MovieTime01 extends Application
{
    private static final SimpleDateFormat FMT_YEAR = new SimpleDateFormat("yyyy");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO Put your own team number and names here
        System.out.println("Team #1");
        System.out.println("Brian Johnston (bjj5172@psu.edu)");
        System.out.println("Mostafa Apu (mja5612@psu.edu)");
        System.out.println("Aleksandra Lee (ajl6215@psu.edu)");
        System.out.println("Junyu Ren (jxr5525@psu.edu)");

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
