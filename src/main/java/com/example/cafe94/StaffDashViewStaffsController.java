package com.example.cafe94;

import com.example.cafe94.entities.Customer;
import com.example.cafe94.entities.Staff;
import com.example.cafe94.utils.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class StaffDashViewStaffsController extends Page{


    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Staff> table;
    @FXML
    private TableColumn<Staff, Integer> id;

    @FXML
    private TableColumn<Staff, String> firstName;
    @FXML
    private TableColumn<Staff, String> lastName;
    @FXML
    private TableColumn<Staff, String> email;
    @FXML
    private TableColumn<Staff, String> type;

    @FXML
    private TableColumn<Staff, Integer> hoursWorked;
    @FXML
    private TableColumn<Staff, Integer> hoursToWork;


    public void initialize() {
        welcomeText.setText("Welcome");

        ObservableList<Staff> data = FXCollections.observableArrayList(App.getRestaurant().getStaffDB().values());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        hoursWorked.setCellValueFactory(new PropertyValueFactory<>("hoursWorked"));
        hoursToWork.setCellValueFactory(new PropertyValueFactory<>("hoursToWork"));

        table.setItems(data);

    }
}