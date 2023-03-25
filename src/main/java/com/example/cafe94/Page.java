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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Page {



    @FXML
    protected void back() throws IOException {
SceneNode s = App.getSceneHistory().pop();



        Parent root =  FXMLLoader.load(getClass().getResource(s.fxml));
        Stage stage = s.stage;
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();




    }


}