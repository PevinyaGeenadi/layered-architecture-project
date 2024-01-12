package lk.ijse.salon.controller;

import javafx.event.ActionEvent;
import lk.ijse.salon.util.Navigation;


import java.io.IOException;

public class HomepageFormController {

    public void homeOnAction(ActionEvent actionEvent) {
        try {
            Navigation.switchNavigation("LoginUser.fxml",actionEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
