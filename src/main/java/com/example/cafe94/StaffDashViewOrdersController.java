package com.example.cafe94;

import com.example.cafe94.entities.Booking;
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

public class StaffDashViewOrdersController extends Page{


    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Order> table;
    @FXML
    private TableColumn<Order, Integer> id;

    @FXML
    private TableColumn<Order, String> customerName;
    @FXML
    private TableColumn<Order, String> menu;
    @FXML
    private TableColumn<Order, String> type;
    @FXML
    private TableColumn<Order, Integer> address;
    @FXML
    private TableColumn<Order, String> action;



    public void f(MouseEvent t) {
    TableCell c = (TableCell) t.getSource();
    int index = c.getIndex();
    System.out.println(index);
    }
    public void initialize() {
        welcomeText.setText("Welcome");



        Callback<TableColumn<Order,String>, TableCell<Order,String>> stringCellFactory =
                new Callback<TableColumn<Order,String>, TableCell<Order,String>>() {
                    @Override
                    public TableCell call(TableColumn p) {
                        MyStringTableCell4 cell = new MyStringTableCell4();
                        cell.addEventFilter(MouseEvent.MOUSE_CLICKED, new MyEventHandler3());
                        return cell;
                    }
                };


        ObservableList<Order> data = FXCollections.observableArrayList(App.getRestaurant().getOrderDB().values());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerName.setCellValueFactory((TableColumn.CellDataFeatures<Order,String> x) -> {

            ObservableValue<String> f =  new SimpleStringProperty(App.getCustomerById(x.getValue().getCustomerId()).getFirstName() + " " + App.getCustomerById(x.getValue().getCustomerId()).getLastName() );
            return f;
        });

        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        menu.setCellValueFactory(new PropertyValueFactory<>("menu"));
        action.setCellValueFactory((TableColumn.CellDataFeatures<Order,String> x) -> {
            System.out.println(x.getValue().getId());

            ObservableValue<String> f =  new SimpleStringProperty("approve") ;
            return f;
        });
        action.setCellFactory(stringCellFactory);
        table.setItems(data);

    }
}

class MyStringTableCell4 extends TableCell<Order, String> {

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

class MyEventHandler4 implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent t) {
        TableCell c = (TableCell) t.getSource();
        int index = c.getIndex();
        System.out.println(index);
    }
}