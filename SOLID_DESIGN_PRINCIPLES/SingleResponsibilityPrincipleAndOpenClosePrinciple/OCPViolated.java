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

// 1. ShoppingCart: Only responsible for Cart(total Price) related logic.
class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.price;
        }
        return totalPrice;
    }
}

// 2. ShoppingCartInvoice: Only responsible for printing Invoices logic.
class ShoppingCartInvoice {
    private ShoppingCart cart;

    public ShoppingCartInvoice(ShoppingCart cart) {
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " " + p.price);
        }
        System.out.println("The TotalPrice:" + cart.calculateTotalPrice());
    }

}

// 3(i). ShoppingCartSaveToDB: Only responsible for Saving DB Operations logic.
// 3(ii). ShoppingCartSaveToDB has manyDB Methods so in future if we are adding
// other DB we are breaking existing class logic which violated OCP
class ShoppingCartSaveToDB {
    private ShoppingCart cart;

    public ShoppingCartSaveToDB(ShoppingCart cart) {
        this.cart = cart;
    }

    void saveToSQLDatabase() {
        System.out.println("Saving shopping cart to SQL DB...");
    }

    void saveToMongoDatabase() {
        System.out.println("Saving shopping cart to Mongo DB...");
    }

    void saveToFile() {
        System.out.println("Saving shopping cart to File...");
    }
}

public class OCPViolated {
    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(new Product("Laptop", 50000.0));
        sc.addProduct(new Product("Mouse", 1000.0));
        sc.addProduct(new Product("Bag", 2000.0));

        ShoppingCartInvoice sCartInvoice = new ShoppingCartInvoice(sc);
        sCartInvoice.printInvoice();

        ShoppingCartSaveToDB saveToDB = new ShoppingCartSaveToDB(sc);
        saveToDB.saveToSQLDatabase();
    }
}
