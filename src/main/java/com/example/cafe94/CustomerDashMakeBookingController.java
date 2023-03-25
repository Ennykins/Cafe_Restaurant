package com.example.cafe94;

import com.example.cafe94.entities.Booking;
import com.example.cafe94.entities.Order;
import com.example.cafe94.enums.OrderType;
import com.example.cafe94.utils.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

public class CustomerDashMakeBookingController extends Page{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox<Integer> noOfGuests = new ComboBox<>();

    @FXML
    private DatePicker date;
    @FXML
    private TextField time;




    public void initialize(){
        noOfGuests.setPromptText("Choose ONo Of Guests");
        noOfGuests.getItems().add(2);
        noOfGuests.getItems().add(4);
        noOfGuests.getItems().add(8);
        noOfGuests.getItems().add(10);





    }


    @FXML
    protected void create(ActionEvent event) throws IOException {


        try {

           Booking booking = new Booking();
            booking.setCustomerId(App.getLoggedInCustomer().getId());

booking.setDate(date.getValue());
booking.setTime(time.getText());
            // noOfGuests.getValue()



            App.createBooking(booking, noOfGuests.getValue());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setContentText("Successfully created Booking");
            alert.showAndWait();
back();


        } catch (Exception ex) {
System.out.println(ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();


        }
        }
}