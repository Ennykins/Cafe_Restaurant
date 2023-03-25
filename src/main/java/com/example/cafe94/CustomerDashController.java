package com.example.cafe94;

import com.example.cafe94.utils.App;
import com.example.cafe94.utils.SceneNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerDashController extends Page{
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label welcomeText;

    public void initialize() {
     welcomeText.setText("Welcome " + App.getLoggedInCustomer().getFirstName() +" "+App.getLoggedInCustomer().getLastName());
    }




    @FXML
    protected void makeOrder(ActionEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("customer-dash-make-order.fxml"));
        stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
        App.getSceneHistory().add(new SceneNode(this.stage,"customer-dash.fxml" ));

    }


    @FXML
    protected void viewOrders(ActionEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("customer-dash-view-orders.fxml"));
        stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
        App.getSceneHistory().add(new SceneNode(this.stage,"customer-dash.fxml" ));

    }





    @FXML
    protected void makeBooking(ActionEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("customer-dash-make-booking.fxml"));
        stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
        App.getSceneHistory().add(new SceneNode(this.stage,"customer-dash.fxml" ));

    }


    @FXML
    protected void viewBookings(ActionEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("customer-dash-view-bookings.fxml"));
        stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
        App.getSceneHistory().add(new SceneNode(this.stage,"customer-dash.fxml" ));

    }








}