package project.models;

import java.util.Objects;

public abstract class Person {
    protected String FirstName;
    protected String LastName;
    protected String Email;
    protected int Age;
    protected String PhoneNumber;



    //constructor fara parametrii
    public Person() {
        this.FirstName = "";
        this.LastName = "";
        this.Email = "";
        this.Age = 0;
        this.PhoneNumber = "";
    }

    //constructor cu parametrii
    public Person(String FirstName , String LastName, String Email, int Age, String PhoneNumber) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Age = Age;
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Age == person.Age && Objects.equals(FirstName, person.FirstName) && Objects.equals(LastName, person.LastName) && Objects.equals(Email, person.Email) && Objects.equals(PhoneNumber, person.PhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, Email, Age, PhoneNumber);
    }

    @Override
    public String toString() {
        return  "Person{" + FirstName + " " + LastName + ", " + Age + ", Email Address : " + Email + ", Phone : " + PhoneNumber + '}';
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public int getAge() {
        return Age;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
