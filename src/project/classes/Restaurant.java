package project.classes;
import project.service.*;

import java.util.*;

public class Restaurant {
       private String RestaurantName;
       private String Category;
       private int MinimumOrder;
       private double score;
       private String City;
       private HashMap<String,List<Food>> FoodMeniu;
       private List<Drink> DrinkMeniu;

    //constructor fara parametrii
    public Restaurant() {
        this.RestaurantName = "";
        this.Category = "";
        this.MinimumOrder = 0;
        this.score = 0;
        this.City = "";
        this.FoodMeniu = new HashMap<>();
        this.DrinkMeniu = new ArrayList<>();
    }
    //constructor cu parametrii
    public Restaurant(String restaurantName, String category,int MinimumOrder, double score, String city,HashMap<String,List<Food>> foodMeniu, List<Drink> drinkMeniu) {
        this.RestaurantName = restaurantName;
        this.Category = category;
        this.MinimumOrder = MinimumOrder;
        this.score = score;
        this.City = city;
        this.FoodMeniu = foodMeniu;
        this.DrinkMeniu = drinkMeniu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return MinimumOrder == that.MinimumOrder && Double.compare(that.score, score) == 0 && Objects.equals(RestaurantName, that.RestaurantName) && Objects.equals(Category, that.Category) && Objects.equals(City, that.City) && Objects.equals(FoodMeniu, that.FoodMeniu) && Objects.equals(DrinkMeniu, that.DrinkMeniu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RestaurantName, Category, MinimumOrder, score, City, FoodMeniu, DrinkMeniu);
    }

    @Override
    public String toString() {
        return  RestaurantName + "\r\n" +
                "======================================\r\n" +
                " Category: " + Category + "\r\n" +
                " Minimim Order Price: " + MinimumOrder + "   ***** " + score + "\r\n";
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getMinimumOrder() {
        return MinimumOrder;
    }

    public void setMinimumOrder(int MinimumOrder) {
        MinimumOrder = MinimumOrder;
    }

    public double getscore() {
        return score;
    }

    public void setscore(double score) {
        score = score;
    }

    public HashMap<String,List<Food>> getFoodMeniu() {
        return FoodMeniu;
    }

    public void setFoodMeniu(HashMap<String,List<Food>> foodMeniu) {
        FoodMeniu = foodMeniu;
    }

    public List<Drink> getDrinkMeniu() {
        return DrinkMeniu;
    }

    public void setDrinkMeniu(List<Drink> drinkMeniu) {
        DrinkMeniu = drinkMeniu;
    }

}
