package project.classes;

import java.util.Objects;

public abstract class Product {
    protected String Name;
    protected float Price;
    protected int Weight;


    //constructor fara parametrii
    public Product() {
        this.Name = "";
        this.Price = 0;
        this.Weight = 0;
    }
    //constructor cu parametrii
    public Product(String name, float price, int weight) {
        this.Name = name;
        this.Price = price;
        this.Weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.Price, Price) == 0 && Weight == product.Weight && Objects.equals(Name, product.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Price, Weight);
    }

    @Override
    public String toString() {
        return "Product{" + "Name: " + Name + ", Price: " + Price + ", Weight: " + Weight + '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }
}
