package com.example.cafe94;

import com.example.cafe94.entities.Customer;
import com.example.cafe94.utils.App;
import com.example.cafe94.utils.SceneNode;
import javafx.beans.DefaultProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;

@DefaultProperty(value = "extension")
public class CustomerAuthController extends  Page {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;

    @FXML
    protected void onLogin(ActionEvent event) throws IOException {


        try {
            App.loginCustomer(email.getText(), password.getText());



              root =  FXMLLoader.load(getClass().getResource("customer-dash.fxml"));
              stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
               scene = new Scene(root);
            stage.setTitle("Cafe94");
            stage.setScene(scene);
            stage.show();
            App.getSceneHistory().add(new SceneNode(this.stage,"customer-login.fxml" ));
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }





    }

    @FXML
    protected void onRegister(ActionEvent event) throws IOException {
        try {


              root =  FXMLLoader.load(getClass().getResource("customer-register.fxml"));
              stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
               scene = new Scene(root);
            stage.setTitle("Cafe94");
            stage.setScene(scene);
            stage.show();
            App.getSceneHistory().add(new SceneNode(this.stage,"customer-login.fxml" ));
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }


    @FXML
    protected void register(ActionEvent event) throws IOException {
        try {
            Customer customer = new Customer();
            customer.setPassword(password.getText());
            customer.setEmail(email.getText());
            customer.setFirstName(firstName.getText());
            customer.setLastName(lastName.getText());

            App.registerCustomer(customer);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setContentText("Successfully registered. You can proceed to login");
            alert.showAndWait();



            back();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }


}