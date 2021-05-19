package project.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.List;

public class Order {
    private int OrderNumber;
    private Date OrderDate;
    private int DeliveryTime;
    private User User;
    private Restaurant Restaurant;
    private Driver Driver;
    private List<Product> OrderedProducts;

    public Order() {
        this.OrderNumber = 0;
        this.OrderDate = null;
        this.DeliveryTime = 0;
        this.User = null;
        this.Restaurant = null;
        this.Driver = null;
        this.OrderedProducts = null;
    }
    public Order(int orderNumber, Date orderDate, int deliveryTime, project.models.User user, project.models.Restaurant restaurant, project.models.Driver driver, List<Product> orderedProducts) {
        this.OrderNumber = orderNumber;
        this.OrderDate = orderDate;
        this.DeliveryTime = deliveryTime;
        this.User = user;
        this.Restaurant = restaurant;
        this.Driver = driver;
        this.OrderedProducts = orderedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return OrderNumber == order.OrderNumber && DeliveryTime == order.DeliveryTime && Objects.equals(OrderDate, order.OrderDate) && Objects.equals(User, order.User) && Objects.equals(Restaurant, order.Restaurant) && Objects.equals(Driver, order.Driver) && Objects.equals(OrderedProducts, order.OrderedProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OrderNumber, OrderDate, DeliveryTime, User, Restaurant, Driver, OrderedProducts);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        return  "Order Number: " + OrderNumber + "\r\n" +
                "Order Date: " + formatter.format(OrderDate) + "\r\n" +
                "Delivery Time: " + DeliveryTime + "\r\n" +
                "Client: " + User.getFirstName() + " " + User.getLastName() + "\r\n" +
                "Restaurant: " + Restaurant.getRestaurantName() + "\r\n" +
                "Driver: " + Driver.getFirstName() + " " + Driver.getLastName() + " " + Driver.getPhoneNumber() + " " + Driver.getCarRegistrationNumber() + " \r\n" +
                "Products: " + OrderedProducts + " \r\n" ;
    }

    public int getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        OrderNumber = orderNumber;
    }

    public List<Product> getOrderedProducts() {
        return OrderedProducts;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        OrderedProducts = orderedProducts;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public int getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        DeliveryTime = deliveryTime;
    }

    public project.models.User getUser() {
        return User;
    }

    public void setUser(project.models.User user) {
        User = user;
    }

    public project.models.Restaurant getRestaurant() {
        return Restaurant;
    }

    public void setRestaurant(project.models.Restaurant restaurant) {
        Restaurant = restaurant;
    }

    public project.models.Driver getDriver() {
        return Driver;
    }

    public void setDriver(project.models.Driver driver) {
        Driver = driver;
    }
}
