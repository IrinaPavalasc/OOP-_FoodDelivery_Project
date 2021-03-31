package project.classes;

import java.util.Objects;

public class Driver extends Person{
    private int EmployeeId;
    private String CarRegistrationNumber;
    private String City;
    static int AverageTime = 20;

    //constructor fara parametrii
    public Driver() {
        this.EmployeeId = 0;
        this.CarRegistrationNumber = "";
        this.City = "";
    }

    //constructor cu parametrii
    public Driver(int employeeId,String FirstName, String LastName, String Email, int Age, String PhoneNumber, String carRegistrationNumber, String city) {
        super(FirstName, LastName, Email, Age, PhoneNumber);
        this.EmployeeId = employeeId;
        this.CarRegistrationNumber = carRegistrationNumber;
        this.City = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return EmployeeId == driver.EmployeeId && Objects.equals(CarRegistrationNumber, driver.CarRegistrationNumber) && Objects.equals(City, driver.City);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), EmployeeId, CarRegistrationNumber, City);
    }

    @Override
    public String toString() {
        return  "Employee Id: " + EmployeeId + "\r\n" +
                "Car Registration Number: " + CarRegistrationNumber + "\r\n" +
                "Name: " + FirstName + LastName + "\r\n" +
                "Phone Number: " + PhoneNumber + "\r\n";
    }

    public static int getAverageTime() {
        return AverageTime;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCarRegistrationNumber() {
        return CarRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        CarRegistrationNumber = carRegistrationNumber;
    }
}
