package SOLID_DESIGN_PRINCIPLES.SingleResponsibilityPrincipleAndOpenClosePrinciple;

import java.util.*;

class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Violating SRP: ShoppingCart is handling multiple responsibilities
class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    // 1. Calculates total price in cart.
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.price;
        }
        return totalPrice;
    }

    // 2. Violating SRP - Prints invoice (Should be in a separate class)
    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : products) {
            System.out.println(p.name + " " + p.price);
        }
        System.out.println("The TotalPrice:" + calculateTotalPrice());
    }

    // 3. Violating SRP - Saves to DB (Should be in a separate class)
    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

public class SRPViolated {
    public static void main(String[] args) {
        ShoppingCart obj = new ShoppingCart();

        obj.addProduct(new Product("Laptop", 50000.0));
        obj.addProduct(new Product("Mouse", 1000.0));
        obj.addProduct(new Product("Bag", 2000.0));

        obj.printInvoice();
        obj.saveToDatabase();
    }
}