import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Homepage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ELEGANZE SALON ");
        stage.resizableProperty().setValue(false);
        stage.show();
    }
}