package project.models;

import java.util.Objects;

public class Food extends Product{
    private String Ingredients;
    private int PreparationTime;

    //constructor fara parametrii
    public Food() {
        super();
        this.Ingredients = "";
        this.PreparationTime = 0;
    }

    //constructor cu parametrii
    public Food(String name, float price, int weight, String ingredients, int preparationTime) {
        super(name, price, weight);
        this.Ingredients = ingredients;
        this.PreparationTime = preparationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Food food = (Food) o;
        return PreparationTime == food.PreparationTime  && Objects.equals(Ingredients, food.Ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Ingredients, PreparationTime);
    }

    @Override
    public String toString() {
        return  "Name: " + Name +
                ", (" + Ingredients + ")" +
                ", " + Price + "lei, " +
                ", " + Weight + 'g' + "\r\n";
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public int getPreparationTime() {
        return PreparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        PreparationTime = preparationTime;
    }
}
