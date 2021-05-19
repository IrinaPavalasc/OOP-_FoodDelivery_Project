package project.models;

import java.util.Objects;

public class User extends Person {

    private Address Address;
    private Card Card;

    //constructor fara parametrii
    public User() {
        super();
        Address = null;
        Card = null;
    }

    //constructor cu parametrii
    public User(String FirstName, String LastName, String Email, int Age, String PhoneNumber, Address address, Card card) {
        super(FirstName, LastName, Email, Age, PhoneNumber);
        this.Address = address;
        this.Card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(Address, user.Address) && Objects.equals(Card, user.Card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Address, Card);
    }

    @Override
    public String toString() {
        return "User{" +
                "Name: " + FirstName + LastName +
                ", Email: " + Email +
                ", Age: " + Age +
                ", Phone Number: " + PhoneNumber  +
                ", Card: " + Card +
                ", Address: " + Address +
                '}';
    }

    public project.models.Address getAddress() {
        return Address;
    }

    public void setAddress(project.models.Address address) {
        Address = address;
    }

    public project.models.Card getCard() {
        return Card;
    }

    public void setCard(project.models.Card card) {
        Card = card;
    }
}
