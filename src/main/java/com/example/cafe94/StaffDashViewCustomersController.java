package com.example.cafe94;

import com.example.cafe94.entities.Customer;
import com.example.cafe94.utils.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StaffDashViewCustomersController extends Page{


    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Customer> table;
    @FXML
    private TableColumn<Customer, Integer> id;

    @FXML
    private TableColumn<Customer, String> firstName;
    @FXML
    private TableColumn<Customer, String> lastName;
    @FXML
    private TableColumn<Customer, String> email;


    public void initialize() {
        welcomeText.setText("Welcome");

        ObservableList<Customer> data = FXCollections.observableArrayList(App.getRestaurant().getCustomerDB().values());
        id.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        email.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));

        table.setItems(data);

    }
}