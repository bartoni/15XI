package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {

    private final SimpleStringProperty name;
    private final SimpleStringProperty surname;
    private final SimpleIntegerProperty age;
    private final SimpleStringProperty pesel;
    private final SimpleIntegerProperty height;

    public Person(String name, String surname, Integer age, String pesel, Integer height) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.age = new SimpleIntegerProperty(age);
        this.pesel = new SimpleStringProperty(pesel);
        this.height = new SimpleIntegerProperty(height);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String n) {
        name.set(n);
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String s) {
        surname.set(s);
    }

    public Integer getAge() {
        return age.get();
    }

    public void setAge(Integer a) {
        age.set(a);
    }

    public String getPesel() {
        return pesel.get();
    }

    public void setPesel(String p) {
        pesel.set(p);
    }

    public Integer getHeight() {
        return height.get();
    }

    public void setHeight(Integer h) {
        height.set(h);
    }

}