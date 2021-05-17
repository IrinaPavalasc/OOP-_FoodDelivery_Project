package project.service;
import project.classes.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ReadingFile {

    private static ReadingFile single_instance = null;

    private ReadingFile() {
    }

    public static ReadingFile getInstance() {
        if (single_instance == null)
            single_instance = new ReadingFile();

        return single_instance;
    }

    public <T> List Reading(T obj){
        List<Restaurant> registeredRestaurants = new ArrayList<>();
        if(obj instanceof Restaurant){
        try {
            FileReader f = new FileReader("src/project/Files/RestaurantsCSV.csv");
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                Restaurant restaurant = new Restaurant();
                String data = read.nextLine();
                String[] r = data.split(",");
                restaurant.setRestaurantName(r[0]);
                restaurant.setCategory(r[1]);
                restaurant.setMinimumOrder(Integer.parseInt(r[2]));
                restaurant.setScore(Double.parseDouble(r[3]));
                restaurant.setCity(r[4]);
                registeredRestaurants.add(restaurant);
            }
            read.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return registeredRestaurants;

    }

        if(obj instanceof Driver){
            List<Driver> registeredDrivers = new ArrayList<>();
        try {
            FileReader f = new FileReader("src/project/Files/DriversCSV.csv");

            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                Driver driver = new Driver();
                String data = read.nextLine();
                String[] d = data.split(",");
                driver.setFirstName(d[0]);
                driver.setLastName(d[1]);
                driver.setEmail(d[2]);
                driver.setAge(Integer.parseInt(d[3]));
                driver.setPhoneNumber(d[4]);
                driver.setEmployeeId(Integer.parseInt(d[5]));
                driver.setCarRegistrationNumber(d[6]);
                driver.setCity(d[7]);
                registeredDrivers.add(driver);
            }

            read.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return registeredDrivers;
    }

        if(obj instanceof User){
        List<User> registeredUsers = new ArrayList<>();
        try {
            FileReader f = new FileReader("src/project/Files/UsersCSV.csv");

            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                User user = new User();
                String data = read.nextLine();
                String[] u = data.split(",");
                user.setFirstName(u[0]);
                user.setLastName(u[1]);
                user.setEmail(u[2]);
                user.setAge(Integer.parseInt(u[3]));
                user.setPhoneNumber(u[4]);
                Address address = new Address(u[5], u[6], Integer.parseInt(u[7]), Integer.parseInt(u[8]));
                user.setAddress(address);
                Card card = new Card(u[9], u[10], Integer.parseInt(u[11]));
                user.setCard(card);
                registeredUsers.add(user);
            }

            read.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return registeredUsers;
    }
        if(obj instanceof Order) {
            List<Order> registeredOrders = new ArrayList<>();
            try {
                FileReader f = new FileReader("src/project/Files/OrdersCSV.csv");
                Scanner read = new Scanner(f);
                while (read.hasNextLine()) {
                    Order order = new Order();
                    String data = read.nextLine();
                    String[] o = data.split(",");
                    // + d.getFirstName() + ',' + d.getLastName() + ',' + d.getEmail() + ',' + d.getAge()+ ',' + d.getPhoneNumber()+ ','+ d.getEmployeeId() + ',' + d.getCarRegistrationNumber() + ',' + d.getCity() + ','+ u.getFirstName() + ',' + u.getLastName() + ',' + u.getEmail() + ',' + u.getAge()+ ',' + u.getPhoneNumber()+ ',' + u.getAddress().getCity() +',' + u.getAddress().getStreet() + ',' + u.getAddress().getNumber() + ',' + u.getAddress().getApartment() + ',' + u.getCard().getCardNumber() + ',' + u.getCard().getExpireDate() + ',' + u.getCard().getSecurityCode()+'\n';
                    order.setOrderNumber(Integer.parseInt(o[0]));
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(o[1]);
                    order.setOrderDate(date1);
                    order.setDeliveryTime(Integer.parseInt(o[2]));
                    Restaurant restaurant = new Restaurant(o[3], o[4], Integer.parseInt(o[5]), Double.parseDouble(o[6]), o[7], null, null);
                    order.setRestaurant(restaurant);
                    Address address = new Address(o[15], o[16], Integer.parseInt(o[17]), Integer.parseInt(o[18]));
                    Card card = new Card(o[19], o[20], Integer.parseInt(o[21]));
                    User user = new User(o[10], o[11], o[12], Integer.parseInt(o[13]), o[14], address, card);
                    Driver driver = new Driver(Integer.parseInt(o[22]), o[23], o[24], o[25], Integer.parseInt(o[26]), o[27], o[28], o[29]);
                    order.setUser(user);
                    order.setDriver(driver);
                    registeredOrders.add(order);
                }

                read.close();
            } catch (Exception e) {
                System.out.println("Error");
            }
            return registeredOrders;
        }
        return null;
    }
}