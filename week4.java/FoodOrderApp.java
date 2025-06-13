// Base class: FoodItem
class FoodItem {
    private String name;
    private double price;

    // Constructor
    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to override
    public void displayMenuItem() {
        System.out.println("Item: " + name + " | Price: $" + price);
    }
}

// Subclass: Pizza
class Pizza extends FoodItem {
    private String size;
    private String[] toppings;

    public Pizza(String name, double price, String size, String[] toppings) {
        super(name, price);
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public void displayMenuItem() {
        System.out.print("Pizza: " + getName() + " | Size: " + size + " | Toppings: ");
        for (String topping : toppings) {
            System.out.print(topping + " ");
        }
        System.out.println("| Price: $" + getPrice());
    }
}

// Subclass: Burger
class Burger extends FoodItem {
    private boolean cheese;
    private String pattyType;

    public Burger(String name, double price, boolean cheese, String pattyType) {
        super(name, price);
        this.cheese = cheese;
        this.pattyType = pattyType;
    }

    @Override
    public void displayMenuItem() {
        System.out.println("Burger: " + getName() +
                " | Patty: " + pattyType +
                " | Cheese: " + (cheese ? "Yes" : "No") +
                " | Price: $" + getPrice());
    }
}

// Subclass: Salad
class Salad extends FoodItem {
    private String[] ingredients;

    public Salad(String name, double price, String[] ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    @Override
    public void displayMenuItem() {
        System.out.print("Salad: " + getName() + " | Ingredients: ");
        for (String ingredient : ingredients) {
            System.out.print(ingredient + " ");
        }
        System.out.println("| Price: $" + getPrice());
    }
}

// Main class
public class FoodOrderApp {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("Pepperoni Pizza", 12.99, "Large", args);
        Burger burger = new Burger("Beef Burger", 8.99, true, "Beef");
        Salad salad = new Salad("Greek Salad", 6.49, args);

        pizza.displayMenuItem();
        burger.displayMenuItem();
        salad.displayMenuItem();
    }
}


