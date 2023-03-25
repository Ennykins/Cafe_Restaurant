package com.example.cafe94;

import com.example.cafe94.utils.App;
import com.example.cafe94.utils.SceneNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label welcomeText;

    @FXML
    protected void switchToCustomerLogin(ActionEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("customer-login.fxml"));
        stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();

        App.getSceneHistory().add(new SceneNode(this.stage,"home.fxml" ));
    }
    @FXML
    protected void switchToManagerLogin(ActionEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("staff-dash.fxml"));
        stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        App.getSceneHistory().add(new SceneNode(this.stage,"home.fxml" ));
    }
}