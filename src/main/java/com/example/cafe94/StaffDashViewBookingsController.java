package com.example.cafe94;

import com.example.cafe94.entities.Booking;
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

public class StaffDashViewBookingsController extends Page{


    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Booking> table;
    @FXML
    private TableColumn<Booking, Integer> id;

    @FXML
    private TableColumn<Booking, String> customerName;
    @FXML
    private TableColumn<Booking, String> tableId;
    @FXML
    private TableColumn<Booking, String> tableSeats;
    @FXML
    private TableColumn<Booking, String> date;

    @FXML
    private TableColumn<Booking, String> time;
    @FXML
    private TableColumn<Booking, Boolean> approved;



    public void f(MouseEvent t) {
    TableCell c = (TableCell) t.getSource();
    int index = c.getIndex();
    System.out.println(index);
    }
    public void initialize() {
        welcomeText.setText("Welcome");



        Callback<TableColumn<Booking,String>, TableCell<Booking,String>> stringCellFactory =
                new Callback<TableColumn<Booking,String>, TableCell<Booking,String>>() {
                    @Override
                    public TableCell call(TableColumn p) {
                        MyStringTableCell3 cell = new MyStringTableCell3();
                        cell.addEventFilter(MouseEvent.MOUSE_CLICKED, new MyEventHandler3());
                        return cell;
                    }
                };


        ObservableList<Booking> data = FXCollections.observableArrayList(App.getRestaurant().getBookingDB().values());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));


        customerName.setCellValueFactory((TableColumn.CellDataFeatures<Booking,String> x) -> {

            ObservableValue<String> f =  new SimpleStringProperty(App.getCustomerById(x.getValue().getCustomerId()).getFirstName() + " " + App.getCustomerById(x.getValue().getCustomerId()).getLastName() );
            return f;
        });
        tableId.setCellValueFactory(new PropertyValueFactory<>("tableId"));
        tableSeats.setCellValueFactory((TableColumn.CellDataFeatures<Booking,String> x) -> {

            ObservableValue<String> f =  new SimpleStringProperty(App.getRestaurant().getTableDB().get(x.getValue().getTableId()).getTotalCapacity()+"") ;
            return f;
        });
        date.setCellValueFactory((TableColumn.CellDataFeatures<Booking,String> x) -> {
            String str = String.format("%s/%s/%s",x.getValue().getDate().getDayOfMonth(), x.getValue().getDate().getMonthValue(),x.getValue().getDate().getYear());
            ObservableValue<String> f =  new SimpleStringProperty(str) ;
            return f;
        });
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        approved.setCellValueFactory(new PropertyValueFactory<>("approved"));
       // action.setCellFactory(stringCellFactory);
        table.setItems(data);

    }
}

class MyStringTableCell3 extends TableCell<Booking, String> {

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(empty ? null : getString());
        setGraphic(null);
    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }



}

class MyEventHandler3 implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent t) {
        TableCell c = (TableCell) t.getSource();
        int index = c.getIndex();
        System.out.println(index);
    }
}