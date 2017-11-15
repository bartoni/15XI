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

    //ustawienia 'fabryki' dla konkretnych kolumn
    //latwiej pesel na razie przechowywać jako String, bo na int jest za wielki. Gdybysmy chcieli go jakos wykorzystac
    //to trzeba byloby uzyc albo typu Long albo zamieniac Stringa w int

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

    //tworzymy 'observableList' typu Person, ktorą bedzie sledzic nasza tabelka

    private final ObservableList<Person> data = FXCollections.observableArrayList();

    //index na potrzeby przycisku delete (zeby wybrac wiersz do wykasowania)

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

