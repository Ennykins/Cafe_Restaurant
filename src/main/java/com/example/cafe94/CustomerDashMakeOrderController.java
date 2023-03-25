package com.example.cafe94;

import com.example.cafe94.entities.Order;
import com.example.cafe94.enums.OrderType;
import com.example.cafe94.utils.App;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.stream.Collectors;

public class CustomerDashMakeOrderController extends Page{

    private Stage stage;
    private Scene scene;
    private Parent root;



    private DatePicker date;

    @FXML
    private ComboBox<String> orderType = new ComboBox<String>();
    @FXML
    private ComboBox<String> menu = new ComboBox<String>();
    @FXML
    private VBox addressContainer;
    @FXML
    private TextField address;

    @FXML
    private Label menusString;

    private StringBuilder menuSb = new StringBuilder();


    public void initialize(){
        addressContainer.setVisible(false);
        orderType.setPromptText("Choose Order Type");
        orderType.getItems().add("EAT IN");
        orderType.getItems().add("TAKEAWAY");
        orderType.getItems().add("DELIVERY");


        menu.setPromptText("Choose Menu");
        App.getRestaurant().getMenuDB().values().forEach(s -> menu.getItems().add(s.getName()));



    }
    @FXML
    private void orderTypeChange(ActionEvent event) {

        if(orderType.getValue().equals("DELIVERY") ) addressContainer.setVisible(true) ;else addressContainer.setVisible(false);

    }    @FXML
    private void menuChange(ActionEvent event) {


        menuSb.append((menuSb.length() != 0 ? "," : "") +  menu.getValue());

        menusString.setText(menuSb.toString());

       // menu.setItems(FXCollections.observableArrayList(menu.getItems().stream().filter(s -> !s.equals(menu.getValue())).collect(Collectors.toList())));
    }

    @FXML
    protected void create(ActionEvent event) throws IOException {


        try {
            Order order = new Order();
            order.setCustomerId(App.getLoggedInCustomer().getId());



            switch (orderType.getValue()) {
                case "EAT IN":
                    order.setType(OrderType.EAT_IN);
                    break;
                case "DELIVERY":
                    order.setType(OrderType.DELIVERY);
                    order.setAddress(address.getText());
                    break;
                case "TAKEAWAY":
                    order.setType(OrderType.TAKEAWAY);
                    break;
            }
order.setMenu(menuSb.toString());

            App.createOrder(order);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setContentText("Successfully created Order");
            alert.showAndWait();
back();


        } catch (Exception ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();


        }
        }
}