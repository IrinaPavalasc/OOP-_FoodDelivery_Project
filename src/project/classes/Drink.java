package project.classes;

import java.util.Objects;

public class Drink extends Product{

    private Boolean Alcoholic;

    //constructor fara parametrii
    public Drink() {
        super();
        this.Alcoholic = false;
    }

    //constructor cu parametrii
    public Drink(String name, float price, int weight, Boolean alcoholic) {
        super(name, price, weight);
        this.Alcoholic = alcoholic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drink drink = (Drink) o;
        return Objects.equals(Alcoholic, drink.Alcoholic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Alcoholic);
    }

    @Override
    public String toString() {
        return  "Name: " + Name + ", " + Price + "lei, " + Weight + "g" + ", Alcoholic? : " + Alcoholic + "\r\n";
    }

    public Boolean getAlcoholic() {
        return Alcoholic;
    }

    public void setAlcoholic(Boolean alcoholic) {
        Alcoholic = alcoholic;
    }
}
