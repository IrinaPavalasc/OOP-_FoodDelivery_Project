package project.classes;

import java.util.Objects;

public class Address {

    private String City;
    private String Street;
    private int Number;
    private int Apartment;


    //constructor fara parametrii
    public Address() {
        this.City = "";
        this.Street = "";
        this.Number = 0;
        this.Apartment = 0;
    }

    //constructor cu parametrii
    public Address(String city, String street, int number, int apartment) {
        this.City = city;
        this.Street = street;
        this.Number = number;
        this.Apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Number == address.Number && Apartment == address.Apartment && Objects.equals(City, address.City) && Objects.equals(Street, address.Street);
    }

    @Override
    public int hashCode() {
        return Objects.hash( City, Street, Number, Apartment);
    }

    @Override
    public String toString() {
        return "{ "  + City  + ", Str. " + Street + ", Nr. " + Number + ", Ap. " + Apartment + '}';
    }


    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getApartment() {
        return Apartment;
    }

    public void setApartment(int apartment) {
        Apartment = apartment;
    }
}
