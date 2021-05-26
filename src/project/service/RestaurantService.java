package project.service;
import project.csvService.Audit;
import project.csvService.ReadingFile;
import project.csvService.WritingFile;
import project.models.*;
import project.repository.RestaurantRepository;

import java.util.*;
public class RestaurantService {
    private static List<Restaurant> registeredRestaurants = new ArrayList<>();
    public WritingFile write = WritingFile.getInstance();
    public ReadingFile r = ReadingFile.getInstance();
    public Audit audit = Audit.getInstance();

    public void MenuContent(){
        System.out.println("--------------------------------Restaurant Services-----------------------------------");
        System.out.println("======================================================================================");
        System.out.println("1. Add a new restaurant.");
        System.out.println("2. Add foods to a restaurant.");
        System.out.println("3. Add drinks to a restaurant.");
        System.out.println("4. Show all restaurants.");
        System.out.println("5. Edit a restaurant.");
        System.out.println("6. Delete a restaurant.");
        System.out.println("0. Exit.");
    }
    public void Menu(){
        int option = -1;
        Scanner read = new Scanner(System.in);
        Scanner readInt = new Scanner(System.in);
        ///Etapa 2:
        //Restaurant restaurantT = new Restaurant();
        //registeredRestaurants = r.Reading(restaurantT);
        ///Etapa 3:
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        registeredRestaurants = restaurantRepository.getAllRestaurants();
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
//                    Etapa 2
//                    write.Writing(restaurant);
//                    registeredRestaurants = r.Reading(restaurant);
//                    Etapa 3
                    restaurantRepository.insertRestaurant(restaurant);
                    registeredRestaurants = restaurantRepository.getAllRestaurants();
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
            ///audit.auditMethod(option);
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
                ///audit.auditMethod(option);
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

                ///audit.auditMethod(option);
            }
            if (option == 4) {
                 registeredRestaurants.clear();
                 registeredRestaurants = restaurantRepository.getAllRestaurants();
                 printRestaurants();
                 ///audit.auditMethod(option);
            }
            if (option == 5) {
                    System.out.print("-----------------------------Edit a Restaurant!-----------------------------");
                    System.out.println("===========================================================================");
                    int edit = -1;
                System.out.println("Enter the id of the restaurant you want to edit: ");
                int id = readInt.nextInt();
                    while (edit != 0) {
                        System.out.println("What do you want to edit?");
                        System.out.println("1.Restaurant Name; 2.Restaurant Category; 3.Minimum Order");
                        System.out.println("4.Score; 5.City;  0.Exit");
                        try {
                            edit = readInt.nextInt();
                            if (edit == 1) {
                                System.out.println("Restaurant Name: ");
                                String restaurantName = read.nextLine();
                                restaurantRepository.updateRestaurantName(restaurantName,id);

                            }
                            if (edit == 2) {
                                System.out.println("Restaurant Category: ");
                                String category = read.nextLine();
                                restaurantRepository.updateRestaurantCategory(category,id);
                            }
                            if (edit == 3) {
                                System.out.println("Minimum Order: ");
                                int minimumOrder = readInt.nextInt();
                                restaurantRepository.updateRestaurantMinimumOrder(minimumOrder,id);
                            }
                            if (edit == 4) {
                                System.out.println("Score: ");
                                Double score = readInt.nextDouble();
                                restaurantRepository.updateRestaurantScore(score,id);
                            }
                            if (edit == 5) {
                                System.out.println("City: ");
                                String street = read.nextLine();
                                restaurantRepository.updateRestaurantCity(street,id);
                            }

                            System.out.println("Edit successful!");
                        }
                        catch(InputMismatchException e){
                            System.out.println("Please make sure all fields are filled in correctly.");
                            readInt.next();
                        }
                    }
                registeredRestaurants = restaurantRepository.getAllRestaurants();
                ///audit.auditMethod(option);
                }

            if (option == 6) {
                System.out.println("Enter the id of the restaurant you want to delete: ");
                int id = readInt.nextInt();
                restaurantRepository.deleteRestaurantbyId(id);
                registeredRestaurants = restaurantRepository.getAllRestaurants();
            }
        }
    }

    public void printRestaurants() {
        System.out.println(registeredRestaurants);
    }
    public static List<Restaurant> getRegisteredRestaurants() {
        return registeredRestaurants;
    }
}
