// Base class: Product
class Product {
     String name;
      double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
    }
}

// Subclass: Electronics
class Electronics extends Product {
     int warrantyPeriod; // in months

    public Electronics(String name, double price, int warrantyPeriod) {
        super(name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Warranty Period: " + warrantyPeriod + " months");
    }
}

// Subclass: Clothing
class Clothing extends Product {
     String size;
     String material;

    public Clothing(String name, double price, String size, String material) {
        super(name, price);
        this.size = size;
        this.material = material;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
    }
}

// Subclass: Grocery
class Grocery extends Product {
     String expiryDate;

    public Grocery(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Expiry Date: " + expiryDate);
    }
    
}

// Main class to demonstrate
public class ProductCatalog {
    public static void main(String[] args) {
        Product p1 = new Electronics("Smart TV", 499.99, 24);
        Product p2 = new Clothing("T-Shirt", 19.99, "L", "Cotton");
        Product p3 = new Grocery("Milk", 2.49, "2025-01-01");
    
        System.out.println("--- Electronics ---");
        p1.displayDetails();

        System.out.println("\n--- Clothing ---");
        p2.displayDetails();

        System.out.println("\n--- Grocery ---");
        p3.displayDetails();
    }
}

