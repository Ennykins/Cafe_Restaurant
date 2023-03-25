package com.example.cafe94;

import com.example.cafe94.entities.Customer;
import com.example.cafe94.entities.Menu;
import com.example.cafe94.utils.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {



        try{
            //defaults
            Customer c = new Customer();

            c.setFirstName("Eniola");
            c.setLastName("Ayokunle");
            c.setEmail("email");
            c.setPassword("email");

            App.registerCustomer( c);

var arr =  new String[]{"rice", "gggg"};
            for(int i =0; i <arr.length; i++){
                App.getRestaurant().getMenuDB().put(i+1, new Menu(arr[i]));
            }


        }catch (Exception e){}




        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setHeight(400);
        stage.setWidth(620);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}