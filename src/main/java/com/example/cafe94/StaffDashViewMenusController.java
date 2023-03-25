package com.example.cafe94;

import com.example.cafe94.entities.Menu;
import com.example.cafe94.entities.Order;
import com.example.cafe94.utils.App;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class StaffDashViewMenusController extends Page{


    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Menu> table;
    @FXML
    private TableColumn<Menu, Integer> id;

    @FXML
    private TableColumn<Menu, String> name;

    public void initialize() {
        welcomeText.setText("Welcome");



        ObservableList<Menu> data = FXCollections.observableArrayList(App.getRestaurant().getMenuDB().values());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));


        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.setItems(data);


}


}