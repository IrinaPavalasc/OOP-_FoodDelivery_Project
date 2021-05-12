package project.service;
import project.classes.*;
import project.service.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ServiceUser {
    private static List<User> registeredUsers = new ArrayList<>();
    private static List<Order> registeredOrders = new ArrayList<>();
    private static List<Driver> registeredDrivers= new ArrayList<>();
    private static List<Restaurant> registeredRestaurants = new ArrayList<>();
    public WritingFile write = WritingFile.getInstance();
    public ReadingFile r = ReadingFile.getInstance();
    public Audit audit = Audit.getInstance();

//    public void registerDrivers(int employeeId, String firstName, String lastName, String email, int age, String phoneNumber, String carRegistrationNumber, String city) {
//        Driver driver = new Driver(employeeId,firstName,lastName,email,age,phoneNumber,carRegistrationNumber, city);
//        registeredDrivers.add(driver);
//    }
//    public void registerUser() {
//
//        System.out.println("                     Register to FoodDelivery!                             ");
//        System.out.println("===========================================================================");
//        Scanner read = new Scanner(System.in);
//        Scanner readInt = new Scanner(System.in);
//        System.out.println("Enter your first and last name: ");
//        String firstName = read.nextLine();
//        String lastName = read.nextLine();
//        System.out.println("Email: ");
//        String email = read.nextLine();
//        System.out.println("Age: ");
//        int age = readInt.nextInt();
//        System.out.println("Phone number: ");
//        String phoneNumber = read.nextLine();
//        System.out.println("---------------------------------");
//        System.out.println("Enter your main address!");
//        System.out.println("City: ");
//        String city = read.nextLine();
//        System.out.println("Street: ");
//        String street = read.nextLine();
//        System.out.println("Nr. : ");
//        int number = readInt.nextInt();
//        System.out.println("Apartment: ");
//        int apartment = readInt.nextInt();
//        System.out.println("---------------------------------");
//        System.out.println("Enter your card details!");
//        System.out.println("Card Number: ");
//        String cardNumber = read.nextLine();
//        System.out.println("Expiration date: ");
//        String expireDate = read.nextLine();
//        System.out.println("Security code: ");
//        int securityCode = readInt.nextInt();
//        Address address = new Address(city, street, number, apartment);
//        Card card = new Card(cardNumber,expireDate,securityCode);
//        User user = new User(firstName, lastName,email,age,phoneNumber,address,card);
//        registeredUsers.add(user);
//    }
//    public void registerRestaurants(String restaurantName, String category,int MinimumOrder, double score, String city) {
//        HashMap<String,List<Food>> foodMeniu = new HashMap<>();
//        List<Drink> drinkMeniu = new ArrayList<>();
//        Restaurant restaurant = new Restaurant(restaurantName, category,MinimumOrder,score,city,foodMeniu,drinkMeniu);
//        registeredRestaurants.add(restaurant);
//        Collections.sort(registeredRestaurants, new Comparator<Restaurant>() {
//            @Override
//            public int compare(final Restaurant object1, final Restaurant object2) {
//                return object1.getCategory().compareTo(object2.getCategory());
//            }
//        });
//    }
//
//    public void addDrink(String restaurantName, String name, int price, int weight, Boolean alcoholic){
//        Drink drink = new Drink(name, price, weight, alcoholic);
//        for(Restaurant r : registeredRestaurants){
//            if(r.getRestaurantName().equals( restaurantName))
//                r.getDrinkMeniu().add(drink);
//        }
//
//    }
//    public void addFood(String restaurantName, String foodCategory, String name, int price, int weight, String ingredients, int prepTime){
//        Food food = new Food(name, price, weight, ingredients, prepTime);
//        List<Food> foodList = new ArrayList<>();
//        for(Restaurant r : registeredRestaurants){
//            if(r.getRestaurantName().equals(restaurantName)) {
//                if (r.getFoodMeniu().containsKey(foodCategory)) {
//                    foodList = r.getFoodMeniu().get(foodCategory);
//                    foodList.add(food);
//                    r.getFoodMeniu().put(foodCategory, foodList);
//                }
//                else{
//                    foodList.add(food);
//                    r.getFoodMeniu().put(foodCategory, foodList);
//                }
//            }
//
//        }
//
//    }
//
//    public void PlaceOrder(User user) {
//        Order order = new Order();
//        order.setUser(user);
//        int randomOrderNr = ThreadLocalRandom.current().nextInt(1, 100);
//        order.setOrderNumber(randomOrderNr);
//        Date date = new Date(System.currentTimeMillis());
//        order.setOrderDate(date);
//        List<Restaurant> localRestaurants = new ArrayList<>();
//        System.out.println("           Pick a restaurant!         ");
//        System.out.println("====================================== ");
//        Scanner read = new Scanner(System.in);
//        for (Restaurant r : registeredRestaurants) {
//            if (r.getCity().equals(user.getAddress().getCity())) {
//                localRestaurants.add(r);
//                System.out.println(r);
//            }
//        }
//        try {
//            if(localRestaurants.isEmpty())
//                throw new Exception();
//        } catch (Exception e1) {
//            System.out.println("There are no local restaurants. Try again later!");
//        }
//        String restaurantName = read.nextLine();
//        List<Product> listProducts = new ArrayList<>();
//        for (Restaurant r : localRestaurants) {
//            if (r.getRestaurantName().equals(restaurantName)) {
//                order.setRestaurant(r);
//                System.out.println("           Pick products!         ");
//                System.out.println("Write the product name and then 'done'");
//                System.out.println("====================================== ");
//                System.out.println(r.getDrinkMeniu());
//                System.out.println(r.getFoodMeniu());
//
//                String prod = read.nextLine();
//                while (!(prod.equals("done"))) {
//
//                    for (Drink d : r.getDrinkMeniu()) {
//                        if (prod.equals(d.getName())) {
//                            listProducts.add(d);
//                        }
//                    }
//                    for (List<Food> l : r.getFoodMeniu().values()) {
//                        for(Food f : l) {
//                            if (prod.equals(f.getName())) {
//                                listProducts.add(f);
//                            }
//                        }
//                    }
//                    prod = read.nextLine();
//
//                }
//                order.setRestaurant(r);
//            }
//
//        }
//        order.setOrderedProducts(listProducts);
//        order.setDeliveryTime(CalcTime(order));
//        List<Driver> localDrivers = new ArrayList<>();
//        for (Driver d : registeredDrivers) {
//            if (d.getCity().equals(user.getAddress().getCity())) {
//                localDrivers.add(d);
//            }
//        }
//        try {
//            if(localDrivers.isEmpty())
//                throw new Exception();
//            int randomDriver = ThreadLocalRandom.current().nextInt(0, localDrivers.size());
//            order.setDriver(localDrivers.get(randomDriver));
//            registeredOrders.add(order);
//        } catch (Exception e1) {
//                System.out.println("There are no local drivers. Try again later!");
//        }
//    }
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


    public void MenuContent(){
        System.out.println("---------------------------------Actions----------------------------------");
        System.out.println("======================================================================================");
        System.out.println("1. Add restaurants.");
        System.out.println("2. Add foods to a restaurant.");
        System.out.println("3. Add drinks to a restaurant.");
        System.out.println("4. Add drivers.");
        System.out.println("5. Register users.");
        System.out.println("6. Login user.");
        System.out.println("7. Edit current user.");
        System.out.println("8. Show all local restaurants and place order.");
        System.out.println("9. Show all local drivers.");
        System.out.println("10. Show all current user's orders.");
        System.out.println("11. Show current user info.");
        System.out.println("12. Show all restaurants.");
        System.out.println("0. Exit.");
    }
    public void Menu() {
        int option = -1;
        User userCurent = null;
        Scanner read = new Scanner(System.in);
        Scanner readInt = new Scanner(System.in);
        Restaurant restaurantT = new Restaurant();
        Driver driverT = new Driver();
        User userT = new User();
        Order orderT = new Order();
        registeredRestaurants = r.Reading(restaurantT);
        registeredDrivers = r.Reading(driverT);
        registeredUsers = r.Reading(userT);
        registeredOrders = r.Reading(orderT);
        while (option != 0) {
            MenuContent();
            System.out.println("Type the option number: ");
            option = readInt.nextInt();
            if (option == 1) {
                System.out.println("                        Register a new restaurant!                         ");
                System.out.println("===========================================================================");
                try {
                    System.out.println("Restaurant Name: ");
                    String restaurantName = read.nextLine();
                    System.out.println("Restaurant Category: ");
                    String category = read.nextLine();
                    System.out.println("Minimum Order: ");
                    int minimumOrder = readInt.nextInt();
                    System.out.println("Score: ");
                    double score = readInt.nextDouble();
                    System.out.println("City: ");
                    String city = read.nextLine();

                    HashMap<String, List<Food>> foodMeniu = new HashMap<>();
                    List<Drink> drinkMeniu = new ArrayList<>();
                    Restaurant restaurant = new Restaurant(restaurantName, category, minimumOrder, score, city, foodMeniu, drinkMeniu);
                    write.Writing(restaurant);
                    registeredRestaurants = r.Reading(restaurant);
                    System.out.println("Restaurant registered succesfully!");
                    Collections.sort(registeredRestaurants, new Comparator<Restaurant>() {
                        @Override
                        public int compare(final Restaurant object1, final Restaurant object2) {
                            return object1.getCategory().compareTo(object2.getCategory());
                        }
                    });
                }
                catch(InputMismatchException e){
                    System.out.println("Please make sure all fields are filled in correctly.");
                    readInt.next();
                }
            audit.auditMethod(option);
            }
            if (option == 2) {
                System.out.println("                   Add new food to your restaurant menu!                ");
                System.out.println("===========================================================================");
                printRestaurants();
                try{
                System.out.println("Restaurant name: ");
                String restaurantName = read.nextLine();
                System.out.println("Food category: ");
                String foodCategory = read.nextLine();
                System.out.println("Food name: ");
                String name = read.nextLine();
                System.out.println("Price: ");
                int price = readInt.nextInt();
                System.out.println("Weight: ");
                int weight = readInt.nextInt();
                System.out.println("Ingredients: ");
                String ingredients = read.nextLine();
                System.out.println("Preparation Time: ");
                int prepTime = readInt.nextInt();
                Food food = new Food(name, price, weight, ingredients, prepTime);
                List<Food> foodList = new ArrayList<>();
                for (Restaurant r : registeredRestaurants) {
                    if (r.getRestaurantName().equals(restaurantName)) {
                        if (r.getFoodMeniu().containsKey(foodCategory)) {
                            foodList = r.getFoodMeniu().get(foodCategory);
                            foodList.add(food);
                            r.getFoodMeniu().put(foodCategory, foodList);
                        } else {
                            foodList.add(food);
                            r.getFoodMeniu().put(foodCategory, foodList);
                        }
                    }

                }
                System.out.println("Food added succesfully!");
                }
                catch(InputMismatchException e){
                    System.out.println("Please make sure all fields are filled in correctly.");
                    readInt.next();
                }
                audit.auditMethod(option);
            }
            if (option == 3) {
                System.out.println("                   Add a new drink to your restaurant menu!                ");
                System.out.println("===========================================================================");
                printRestaurants();
                try {
                    System.out.println("Restaurant name: ");
                    String restaurantName = read.nextLine();
                    System.out.println("Drink name: ");
                    String name = read.nextLine();
                    System.out.println("Price: ");
                    int price = readInt.nextInt();
                    System.out.println("Weight: ");
                    int weight = readInt.nextInt();
                    System.out.println("Contains Alcohol: ");
                    Boolean alcoholic = readInt.nextBoolean();
                    Drink drink = new Drink(name, price, weight, alcoholic);
                    for (Restaurant r : registeredRestaurants) {
                        if (r.getRestaurantName().equals(restaurantName))
                            r.getDrinkMeniu().add(drink);
                    }
                    System.out.println("Drink added successfully!");
                }
                catch(InputMismatchException e){
                    System.out.println("Please make sure all fields are filled in correctly.");
                    readInt.next();
                }
                audit.auditMethod(option);
            }
            if (option == 4) {
                System.out.println("                     Register a new Driver!                                ");
                System.out.println("===========================================================================");
                try {
                    System.out.println("Employee Id: ");
                    int employeeId = readInt.nextInt();
                    System.out.println("First name: ");
                    String firstName = read.nextLine();
                    System.out.println("Last name: ");
                    String lastName = read.nextLine();
                    System.out.println("Email: ");
                    String email = read.nextLine();
                    System.out.println("Age: ");
                    int age = readInt.nextInt();
                    System.out.println("Phone number: ");
                    String phoneNumber = read.nextLine();
                    System.out.println("Car Registration Number: ");
                    String carRegistrationNumber = read.nextLine();
                    System.out.println("City: ");
                    String city = read.nextLine();
                    Driver driver = new Driver(employeeId, firstName, lastName, email, age, phoneNumber, carRegistrationNumber, city);
                    write.Writing(driver);
                    registeredDrivers = r.Reading(driver);
                    System.out.println("Driver registered successfully!");
                }
                catch(InputMismatchException e){
                    System.out.println("Please make sure all fields are filled in correctly.");
                    readInt.next();
                }
                audit.auditMethod(option);
            }
            if (option == 5) {
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
                    write.Writing(user);
                    registeredUsers = r.Reading(user);
                    System.out.println("Registration successful");
                }
                catch(InputMismatchException e){
                    System.out.println("Please make sure all fields are filled in correctly.");
                    readInt.next();
                }
                audit.auditMethod(option);
            }
            if (option == 6) {
                if (registeredUsers.size()==0) {
                    System.out.println("Please register first!");
                }
                else {

                    System.out.println("                     Login to FoodDelivery!                                ");
                    System.out.println("===========================================================================");
                    try {
                        System.out.println("Enter your first name: ");
                        String firstName = read.nextLine();
                        System.out.println("Enter your last name: ");
                        String lastName = read.nextLine();
                        System.out.println("Security code: ");
                        int securityCode = readInt.nextInt();
                        int ok = 0;
                        for (User x : registeredUsers) {
                            if (x.getFirstName().equals(firstName) && x.getLastName().equals(lastName) && x.getCard().getSecurityCode() == (securityCode)) {
                                userCurent = x;
                            }
                        }
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
                audit.auditMethod(option);
            }
            if (option == 7) {
                if (userCurent==null) {
                    System.out.println("Please login");
                } else {
                    System.out.print("                     Edit your account!");
                    System.out.print(userCurent.getFirstName());
                    System.out.println("                ");
                    System.out.println("===========================================================================");
                    int edit = -1;
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
                                userCurent.setEmail(email);
                            }
                            if (edit == 2) {
                                System.out.println("Age: ");
                                int age = readInt.nextInt();
                                userCurent.setAge(age);
                            }
                            if (edit == 3) {
                                System.out.println("Phone number: ");
                                String phoneNumber = read.nextLine();
                                userCurent.setPhoneNumber(phoneNumber);
                            }
                            if (edit == 4) {
                                System.out.println("City: ");
                                String city = read.nextLine();
                                userCurent.getAddress().setCity(city);
                            }
                            if (edit == 5) {
                                System.out.println("Street: ");
                                String street = read.nextLine();
                                userCurent.getAddress().setStreet(street);
                            }
                            if (edit == 6) {
                                System.out.println("Number : ");
                                int number = readInt.nextInt();
                                userCurent.getAddress().setNumber(number);
                            }
                            if (edit == 7) {
                                System.out.println("Apartment: ");
                                int apartment = readInt.nextInt();
                                userCurent.getAddress().setApartment(apartment);
                            }
                            if (edit == 8) {
                                System.out.println("Card Number: ");
                                String cardNumber = read.nextLine();
                                userCurent.getCard().setCardNumber(cardNumber);
                            }
                            if (edit == 9) {
                                System.out.println("Expiration date: ");
                                String expireDate = read.nextLine();
                                userCurent.getCard().setExpireDate(expireDate);
                            }
                            if (edit == 10) {
                                System.out.println("Security code: ");
                                int securityCode = readInt.nextInt();
                                userCurent.getCard().setSecurityCode(securityCode);
                            }
                            System.out.println("Edit successful!");
                        }
                        catch(InputMismatchException e){
                            System.out.println("Please make sure all fields are filled in correctly.");
                            readInt.next();
                        }
                    }
                }
                audit.auditMethod(option);
            }
            if (option == 8) {
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
                        write.Writing(order);
                        registeredOrders = r.Reading(order);
                    } catch (Exception e1) {
                        System.out.println("There are no local drivers. Try again later!");
                    }
                }
                audit.auditMethod(option);
            }
            if (option == 9) {
                if (userCurent==null) {
                    System.out.println("Please login");
                } else {
                    System.out.println("                          Show all local drivers!                                ");
                    System.out.println("=================================================================================");
                    List<Driver> localDrivers = new ArrayList<>();
                    for (Driver d : registeredDrivers) {
                        if (d.getCity().equals(userCurent.getAddress().getCity())) {
                            localDrivers.add(d);
                        }
                    }
                    System.out.println(localDrivers);
                }
                audit.auditMethod(option);
            }
            if (option == 10) {
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
                audit.auditMethod(option);
            }
            if (option == 11) {
                if (userCurent==null) {
                    System.out.println("Please login");}
                else {
                    System.out.println("                      Your info:                            ");
                    System.out.println("===============================================================");
                    System.out.println(userCurent);
                }
                audit.auditMethod(option);
            }
            if (option == 12) {

                printRestaurants();
                audit.auditMethod(option);
            }
        }
    }


    public void printOrders(){
        System.out.println(registeredOrders);
    }
    public void printUsers() {
        System.out.println(registeredUsers);
    }
    public void printDrivers() {
        System.out.println(registeredDrivers);
    }
    public void printRestaurants() {
        System.out.println(registeredRestaurants);
    }

    public static List<User> getRegisteredUsers() {
        return registeredUsers;
    }
    public static List<Driver> getRegisteredDrivers() {
        return registeredDrivers;
    }
    public static List<Restaurant> getRegisteredRestaurants() {
        return registeredRestaurants;
    }


}
