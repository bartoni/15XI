package sample;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    public TableView<Person> table;
    public TextField name;
    public TextField surname;
    public TextField age;
    public TextField pesel;
    public TextField height;
    public TableColumn nameCol;
    public TableColumn surnameCol;
    public TableColumn ageCol;
    public TableColumn peselCol;
    public TableColumn heightCol;


    /*public void initialize() {
        for (TableColumn<String, ?> column : table.getColumns()) {
            if ("nameCol".equals(column.getId())) {
                TableColumn<String, String> nameColumn = (TableColumn<String, String>) column;
                nameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()));
            } else if ("surnameCol".equals(column.getId())) {
                TableColumn<String, String> surnameColumn = (TableColumn<String, String>) column;
                surnameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()));
            } else if ("ageCol".equals(column.getId())) {
                TableColumn<String, String> ageColumn = (TableColumn<String, String>) column;
                ageColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()));
            } else if ("peselCol".equals(column.getId())) {
                TableColumn<String, String> peselColumn = (TableColumn<String, String>) column;
                peselColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()));
            } else if ("heightCol".equals(column.getId())) {
                TableColumn<String, String> heightColumn = (TableColumn<String, String>) column;
                heightColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()));
            }
        }
    }
    */

    public void initialize(){
        nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        peselCol.setCellValueFactory(new PropertyValueFactory<Person, String>("pesel"));
        heightCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("height"));

        table.setItems(data);

        table.getSelectionModel().selectedItemProperty().addListener((ChangeListener<Object>)
                (observable, oldValue, newValue) -> index.set(data.indexOf(newValue)));
    }


    private final ObservableList<Person> data = FXCollections.observableArrayList();

    private final SimpleIntegerProperty index =  new SimpleIntegerProperty();



    public void handleClick(ActionEvent actionEvent) {

        Person submit = new Person(name.getText(), surname.getText(), Integer.parseInt(age.getText()),
                pesel.getText(), Integer.parseInt(height.getText()));

        data.add(submit);
    }

    public void onDeleteItem (ActionEvent event) {
        int i = index.get();
        if (i > -1) {
            data.remove(i);
            table.getSelectionModel().clearSelection();
        }

    }
}

