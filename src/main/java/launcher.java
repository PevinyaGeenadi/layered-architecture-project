import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class launcher extends Application {

    static public  void main(String[] args) { launch(args);}

    @Override
    public void start(Stage  stage) throws IOException {
        Parent parent =  FXMLLoader.load(getClass().getResource("/views/Homepage.fxml"));
        stage.setScene(new Scene(parent));
        stage.setTitle("ELEGANZE SALON");
        stage.centerOnScreen();

        stage.show();
    }
}