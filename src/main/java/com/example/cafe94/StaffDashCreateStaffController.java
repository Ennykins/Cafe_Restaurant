package com.example.cafe94;

import com.example.cafe94.entities.Staff;
import com.example.cafe94.enums.StaffType;
import com.example.cafe94.utils.App;
import com.example.cafe94.utils.SceneNode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;

public class StaffDashCreateStaffController extends Page{

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private DatePicker date;
    @FXML
    private TextField hoursToWork;

    @FXML
    private ComboBox<String> type  = new ComboBox<String>();



    public void initialize(){
        type.setPromptText("Choose Staff Type");
        type.getItems().add("CHEF");
        type.getItems().add("WAITER");
        type.getItems().add("DELIVERY DRIVER");
    }

    @FXML
    protected void create(ActionEvent event) throws IOException {


        try {
            Staff staff = new Staff();
            //  Staff.setPassword(password.getText());
            staff.setEmail(email.getText());
            staff.setFirstName(firstName.getText());
            staff.setLastName(lastName.getText());
            staff.setHoursToWork(Integer.parseInt(hoursToWork.getText()));


            switch (type.getValue()) {
                case "CHEF":
                    staff.setType(StaffType.CHEF);
                    break;
                case "WAITER":
                    staff.setType(StaffType.WAITER);
                    break;
                case "DELIVERY DRIVER":
                    staff.setType(StaffType.DELIVERY_DRIVER);
                    break;
            }

            App.registerStaff(staff);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setContentText("Successfully created Staff");
            alert.showAndWait();



back();


        } catch (Exception ex) {




        }
        }
}