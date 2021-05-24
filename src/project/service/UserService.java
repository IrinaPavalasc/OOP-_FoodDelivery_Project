package project.service;
import project.csvService.Audit;
import project.csvService.ReadingFile;
import project.csvService.WritingFile;
import project.models.*;
import project.repository.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class UserService {
    private static List<User> registeredUsers = new ArrayList<>();
    private static List<Order> registeredOrders = new ArrayList<>();
    public WritingFile write = WritingFile.getInstance();
    public ReadingFile r = ReadingFile.getInstance();
    public Audit audit = Audit.getInstance();

    public void MenuContent(){
        System.out.println("--------------------------------User Services-----------------------------------");
        System.out.println("======================================================================================");
        System.out.println("1. Register a new user.");
        System.out.println("2. Login user");
        System.out.println("3. Show current user's info.");
        System.out.println("4. Edit current user.");
        System.out.println("5. Delete current user.");
        System.out.println("6. Show all local restaurants and place order.");
        System.out.println("7. Show all current user's orders.");
        System.out.println("8. Edit order by id.");
        System.out.println("9. Delete order by id.");
        System.out.println("10. Show all local drivers.");
        System.out.println("0. Exit.");
    }
    public void Menu(){
        int option = -1;
        User userCurent = null;
        Scanner read = new Scanner(System.in);
        Scanner readInt = new Scanner(System.in);
        ///Etapa 2:
        //User userT = new User();
        //Order orderT = new Order();
        //registeredUsers = r.Reading(userT);
        //registeredOrders = r.Reading(orderT);
        ///Etapa 3:
        UserRepository userRepository = new UserRepository();
        OrderRepository orderRepository = new OrderRepository();
        registeredUsers = userRepository.getAllUsers();
        registeredOrders = orderRepository.getAllOrders();
        while (option != 0) {
            MenuContent();
            System.out.println("Type the option number: ");
            option = readInt.nextInt();
            if (option == 1) {
                System.out.println("                     Register to FoodDelivery!                             ");
                System.out.println("===========================================================================");
                try {
                    System.out.println("Enter your first name: ");
                    String firstName = read.nextLine();
                    System.out.println("Enter your last name: ");
                    String lastName = read.nextLine();
                    System.out.println("Email: ");
                    String email = read.nextLine();
                    System.out.println("Age: ");
                    int age = readInt.nextInt();
                    System.out.println("Phone number: ");
                    String phoneNumber = read.nextLine();
                    System.out.println("---------------------------------");
                    System.out.println("Enter your main address!");
                    System.out.println("City: ");
                    String city = read.nextLine();
                    System.out.println("Street: ");
                    String street = read.nextLine();
                    System.out.println("Number : ");
                    int number = readInt.nextInt();
                    System.out.println("Apartment: ");
                    int apartment = readInt.nextInt();
                    System.out.println("---------------------------------");
                    System.out.println("Enter your card details!");
                    System.out.println("Card Number: ");
                    String cardNumber = read.nextLine();
                    System.out.println("Expiration date: ");
                    String expireDate = read.nextLine();
                    System.out.println("Security code: ");
                    int securityCode = readInt.nextInt();
                    Address address = new Address(city, street, number, apartment);
                    Card card = new Card(cardNumber, expireDate, securityCode);
                    User user = new User(firstName, lastName, email, age, phoneNumber, address, card);
//                    Etapa 2
//                    write.Writing(user);
//                    registeredUsers = r.Reading(user);
//                    Etapa 3
                    userRepository.insertUser(user);
                    registeredUsers =userRepository.getAllUsers();
                    System.out.println("Registration successful");
                }
                catch(InputMismatchException e){
                    System.out.println("Please make sure all fields are filled in correctly.");
                    readInt.next();
                }
                ///audit.auditMethod(option);
            }
            if (option == 2) {
                if (registeredUsers.size()==0) {
                    System.out.println("Please register first!");
                }
                else {

                    System.out.println("                     Login to FoodDelivery!                                ");
                    System.out.println("===========================================================================");
                    try {

                        System.out.println("User Id: ");
                        int iduser = readInt.nextInt();
//                        int ok = 0;
//                        for (User x : registeredUsers) {
//                            if (x.getFirstName().equals(firstName) && x.getLastName().equals(lastName) && x.getCard().getSecurityCode() == (securityCode)) {
//                                userCurent = x;
//                            }
//                        }
                        userCurent = userRepository.getUsersById(iduser);
                        System.out.println(userCurent.getAddress());
                        if(userCurent == null){
                            System.out.println("There are no registered users with this information");
                        }
                        else{
                            System.out.println("Login successfull!");
                        }
                    }
                    catch(InputMismatchException e){
                        System.out.println("Please make sure all fields are filled in correctly.");
                        readInt.next();
                    }
                }
                //audit.auditMethod(option);

            }
            if (option == 3) {
                if (userCurent==null) {
                    System.out.println("Please login");}
                else {
                    System.out.println("                      Your info:                               ");
                    System.out.println("===============================================================");
                    System.out.println(userCurent);
                }
//                audit.auditMethod(option);
            }
            if (option == 4) {
                if (userCurent==null) {
                    System.out.println("Please login");
                } else {
                    System.out.print("                     Edit your account!");
                    System.out.print(userCurent.getFirstName());
                    System.out.println("                ");
                    System.out.println("===========================================================================");
                    int edit = -1;
                    AddressRepository addressRepository = new AddressRepository();
                    CardRepository cardRepository = new CardRepository();
                    while (edit != 0) {
                        System.out.println("What do you want to edit?");
                        System.out.println("1.Email; 2.Age; 3.Phone number");
                        System.out.println("4.City; 5.Street; 6.Number; 7.Apartment");
                        System.out.println("8.Card Number; 9.Expiration Date; 10.Security Number; 0.Exit");
                        try {
                            edit = readInt.nextInt();
                            if (edit == 1) {
                                System.out.println("Email: ");
                                String email = read.nextLine();
                                int id = userCurent.getId();
                                userRepository.updateUserEmail(email,id);

                            }
                            if (edit == 2) {
                                System.out.println("Age: ");
                                int age = readInt.nextInt();
                                int id = userCurent.getId();
                                userRepository.updateUserAge(age,id);
                            }
                            if (edit == 3) {
                                System.out.println("Phone number: ");
                                String phoneNumber = read.nextLine();
                                int id = userCurent.getId();
                                userRepository.updateUserPhoneNumber(phoneNumber,id);
                            }
                            if (edit == 4) {
                                System.out.println("City: ");
                                String city = read.nextLine();
                                int id = userCurent.getAddress().getId();
                                addressRepository.updateAddressCity(city,id);
                            }
                            if (edit == 5) {
                                System.out.println("Street: ");
                                String street = read.nextLine();
                                int id = userCurent.getAddress().getId();
                                addressRepository.updateAddressStreet(street,id);
                            }
                            if (edit == 6) {
                                System.out.println("Number : ");
                                int number = readInt.nextInt();
                                int id = userCurent.getAddress().getId();
                                addressRepository.updateAddressNumber(number,id);
                            }
                            if (edit == 7) {
                                System.out.println("Apartment: ");
                                int apartment = readInt.nextInt();
                                int id = userCurent.getAddress().getId();
                                addressRepository.updateAddressApartment(apartment,id);
                            }
                            if (edit == 8) {
                                System.out.println("Card Number: ");
                                String cardNumber = read.nextLine();
                                int id = userCurent.getCard().getId();
                                cardRepository.updateCardNumber(cardNumber,id);
                            }
                            if (edit == 9) {
                                System.out.println("Expiration date: ");
                                String expireDate = read.nextLine();
                                int id = userCurent.getCard().getId();
                                cardRepository.updateExpireDate(expireDate,id);

                            }
                            if (edit == 10) {
                                System.out.println("Security code: ");
                                int securityCode = readInt.nextInt();
                                int id = userCurent.getCard().getId();
                                cardRepository.updateCardSecurityCode(securityCode,id);
                            }
                            System.out.println("Edit successful!");
                        }
                        catch(InputMismatchException e){
                            System.out.println("Please make sure all fields are filled in correctly.");
                            readInt.next();
                        }
                    }
                }
//                audit.auditMethod(option);

            }
            if (option == 5) {
                if (userCurent==null) {
                    System.out.println("Please login");
                } else {
                    System.out.println("Are you sure? Type 1 if yes, 0 if no.");
                    int ok = readInt.nextInt();
                    if(ok == 1){
                        userRepository.deleteUserbyId(userCurent.getId());
                        registeredUsers= userRepository.getAllUsers();
                     }
                }
            }
            if (option == 6) {
                if (userCurent == null) {
                    System.out.println("Please login");
                } else {
                    Order order = new Order();
                    order.setUser(userCurent);
                    int randomOrderNr = ThreadLocalRandom.current().nextInt(1, 100);
                    order.setOrderNumber(randomOrderNr);
                    Date date = new Date(System.currentTimeMillis());
                    order.setOrderDate(date);
                    List<Restaurant> localRestaurants = new ArrayList<>();
                    System.out.println("                          Place order!                                ");
                    System.out.println("======================================================================");
                    List<Restaurant> registeredRestaurants = new ArrayList<>();
                    List<Driver> registeredDrivers = new ArrayList<>();
                    RestaurantRepository restaurantRepository = new RestaurantRepository();
                    DriverRepository driverRepository = new DriverRepository();
                    registeredRestaurants = restaurantRepository.getAllRestaurants();
                    registeredDrivers = driverRepository.getAllDrivers();

                    for (Restaurant r : registeredRestaurants) {
                        if (r.getCity().equals(userCurent.getAddress().getCity())) {
                            localRestaurants.add(r);
                            System.out.println(r);
                        }
                    }
                    try {
                        if (localRestaurants.isEmpty())
                            throw new Exception();
                    } catch (Exception e1) {
                        System.out.println("There are no local restaurants. Try again later!");
                    }
                    System.out.println("Please write the name of the restaurant you want to order from.");
                    String restaurantName = read.nextLine();
                    List<Product> listProducts = new ArrayList<>();
                    int ok = 0;
                    for (Restaurant r : localRestaurants) {
                        if (r.getRestaurantName().equals(restaurantName)) {
                            ok = 1;
                            order.setRestaurant(r);
                            System.out.println("           Pick products!         ");
                            System.out.println("Write the product name and then 'done'");
                            System.out.println("====================================== ");
                            System.out.println(r.getDrinkMeniu());
                            System.out.println(r.getFoodMeniu());

                            String prod = read.nextLine();
                            while (!(prod.equals("done"))) {

                                for (Drink d : r.getDrinkMeniu()) {
                                    if (prod.equals(d.getName())) {
                                        listProducts.add(d);
                                    }
                                }
                                for (List<Food> l : r.getFoodMeniu().values()) {
                                    for (Food f : l) {
                                        if (prod.equals(f.getName())) {
                                            listProducts.add(f);
                                        }
                                    }
                                }
                                prod = read.nextLine();

                            }
                            order.setRestaurant(r);
                        }
                    }
                    if(ok==0){
                        System.out.println("There are no restaurants with this name.");
                    }
                    order.setOrderedProducts(listProducts);
                    order.setDeliveryTime(CalcTime(order));
                    List<Driver> localDrivers = new ArrayList<>();
                    for (Driver d : registeredDrivers) {
                        if (d.getCity().equals(userCurent.getAddress().getCity())) {
                            localDrivers.add(d);
                        }
                    }
                    try {
                        if (localDrivers.isEmpty())
                            throw new Exception();
                        int randomDriver = ThreadLocalRandom.current().nextInt(0, localDrivers.size());
                        order.setDriver(localDrivers.get(randomDriver));
//                        Etapa 2
//                        write.Writing(order);
//                        Etapa 3
//                        registeredOrders = r.Reading(order);
                        orderRepository.insertOrder(order);
                        registeredOrders = orderRepository.getAllOrders();

                    } catch (Exception e1) {
                        System.out.println("There are no local drivers. Try again later!");
                    }
                }
                registeredOrders = orderRepository.getAllOrders();
//              audit.auditMethod(option);
            }
            if (option == 7) {
                if (userCurent==null) {
                    System.out.println("Please login");}
                else {
                    System.out.println("                      Your Orders:                             ");
                    System.out.println("===============================================================");
                    for (Order o : registeredOrders) {
                        if (o.getUser().equals(userCurent)) {
                            System.out.println(o);
                        }
                    }

                }
//                audit.auditMethod(option);
            }
            if (option == 8) {
                System.out.print("-----------------------------Edit an order!-----------------------------");
                System.out.println("===========================================================================");
                int edit = -1;
                System.out.println("Enter the id of the order you want tp edit: ");
                int id = readInt.nextInt();
                while (edit != 0) {
                    System.out.println("What do you want to edit?");
                    System.out.println("1.Order Date; 2.Delivery Time; 0.Exit");
                    try {
                        edit = readInt.nextInt();
                        if (edit == 1) {
                            System.out.println("Order Date: ");
                            String orderDate = read.nextLine();
                            try {
                                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(orderDate);
                                java.sql.Date newDate = new java.sql.Date(date.getTime());
                                orderRepository.updateOrderDate(newDate, id);
                            }
                            catch(Exception e){}

                        }
                        if (edit == 2) {
                            System.out.println("DeliveryTime: ");
                            int deliveryTime = readInt.nextInt();
                            orderRepository.updateDeliveryTime(deliveryTime,id);
                        }
                        System.out.println("Edit successful!");
                    }
                    catch(InputMismatchException e){
                        System.out.println("Please make sure all fields are filled in correctly.");
                        readInt.next();
                    }
                }
                registeredOrders = orderRepository.getAllOrders();
                ///audit.auditMethod(option);
            }
            if (option == 9) {
                System.out.println("Enter the id of the order you want to delete: ");
                int id = readInt.nextInt();
                orderRepository.deleteOrdersbyId(id);
                registeredOrders = orderRepository.getAllOrders();
            }
            if (option == 10) {

                if (userCurent==null) {
                    System.out.println("Please login");
                } else {
                    System.out.println("                          Show all local drivers!                                ");
                    System.out.println("=================================================================================");
                    List<Driver> registeredDrivers = new ArrayList<>();
                    DriverRepository driverRepository = new DriverRepository();
                    registeredDrivers = driverRepository.getAllDrivers();
                    List<Driver> localDrivers = new ArrayList<>();
                    for (Driver d : registeredDrivers) {
                        if (d.getCity().equals(userCurent.getAddress().getCity())) {
                            localDrivers.add(d);
                        }
                    }
                    System.out.println(localDrivers);
                }
//                audit.auditMethod(option);
            }

        }
    }

    public int CalcTime(Order order){
        int DeliveryTotal = 0;
        for(Product f : order.getOrderedProducts()) {
            if(f instanceof Food) {
                Food f2 = (Food) f;
                DeliveryTotal = DeliveryTotal + f2.getPreparationTime();
            }
        }
        DeliveryTotal = DeliveryTotal + order.getDriver().getAverageTime();
        return DeliveryTotal;
    }

    public void printOrders(){
        System.out.println(registeredOrders);
    }
    public void printUsers(){
        System.out.println(registeredUsers);
    }
    public static List<User> getRegisteredUsers() {
        return registeredUsers;
    }

}
