package com.example.cafe94;

import com.example.cafe94.entities.Menu;
import com.example.cafe94.entities.Staff;
import com.example.cafe94.enums.StaffType;
import com.example.cafe94.utils.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StaffDashCreateMenuController extends Page{

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField name;



    public void initialize(){

    }

    @FXML
    protected void create(ActionEvent event) throws IOException {


        try {
          Menu menu = new Menu();
            //  Staff.setPassword(password.getText());
            menu.setName(name.getText());


            App.createMenu(menu);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setContentText("Successfully created Menu");
            alert.showAndWait();



back();


        } catch (Exception ex) {




        }
        }
}