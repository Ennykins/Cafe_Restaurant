package com.example.cafe94;

import com.example.cafe94.entities.Customer;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.stream.Collectors;

public class StaffDashController extends Page {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;



    public void initialize() {
        welcomeText.setText("Welcome");

    }



    @FXML
    protected void viewCustomers(ActionEvent event) throws IOException {
         root =  FXMLLoader.load(getClass().getResource("staff-dash-view-customers.fxml"));
         stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
         scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
        App.getSceneHistory().add(new SceneNode(this.stage,"staff-dash.fxml" ));

    }

    @FXML
    protected void viewStaffs(ActionEvent event) throws IOException {
         root =  FXMLLoader.load(getClass().getResource("staff-dash-view-staffs.fxml"));
         stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
         scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
        App.getSceneHistory().add(new SceneNode(this.stage,"staff-dash.fxml" ));
    }

    @FXML
    protected void createStaff(ActionEvent event) throws IOException {
         root =  FXMLLoader.load(getClass().getResource("staff-dash-create-staff.fxml"));
         stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();

        App.getSceneHistory().add(new SceneNode(stage,"staff-dash.fxml" ));
    }
    @FXML
    protected void createMenu(ActionEvent event) throws IOException {
         root =  FXMLLoader.load(getClass().getResource("staff-dash-create-menu.fxml"));
         stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();

        App.getSceneHistory().add(new SceneNode(stage,"staff-dash.fxml" ));
    }

    @FXML
    protected void viewOrders(ActionEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("staff-dash-view-orders.fxml"));
        stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
        App.getSceneHistory().add(new SceneNode(this.stage,"staff-dash.fxml" ));

    }

    @FXML
    protected void viewMenus(ActionEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("staff-dash-view-menus.fxml"));
        stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
        App.getSceneHistory().add(new SceneNode(this.stage,"staff-dash.fxml" ));

    }

    @FXML
    protected void viewBookings(ActionEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("staff-dash-view-bookings.fxml"));
        stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
        App.getSceneHistory().add(new SceneNode(this.stage,"staff-dash.fxml" ));

    }


}