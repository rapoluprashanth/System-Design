package SOLID_DESIGN_PRINCIPLES.SingleResponsibilityPrinciple;

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
// Following OCP Principle by using Abstraction, Inheritance and Polymoprphism
// So in future if we want new DB simply we will respective class and points to 
// Persistence Parent class without breaking any existing class
abstract class Persistence {
    public abstract void save();
}

class SQLPersistence extends Persistence {
    private ShoppingCart cart;

    SQLPersistence(ShoppingCart cart) {
        this.cart = cart;
    }

    public void save() {
        System.out.println("Saving shopping cart to SQL DB...");
    }
}

class MongoDBPersistence extends Persistence {
    private ShoppingCart cart;

    MongoDBPersistence(ShoppingCart cart) {
        this.cart = cart;
    }

    public void save() {
        System.out.println("Saving shopping cart to MONGO DB...");
    }
}

class FileSystemPersistence extends Persistence {
    private ShoppingCart cart;

    FileSystemPersistence(ShoppingCart cart) {
        this.cart = cart;
    }

    public void save() {
        System.out.println("Saving shopping cart to FILE SYSTEM...");
    }
}

public class OCPFollowed {
    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(new Product("Laptop", 50000.0));
        sc.addProduct(new Product("Mouse", 1000.0));
        sc.addProduct(new Product("Bag", 2000.0));

        ShoppingCartInvoice sCartInvoice = new ShoppingCartInvoice(sc);
        sCartInvoice.printInvoice();

        Persistence saveToSQLDB = new SQLPersistence(sc);
        saveToSQLDB.save();

        Persistence saveToMongoDB = new MongoDBPersistence(sc);
        saveToMongoDB.save();

        Persistence saveToFileDB = new FileSystemPersistence(sc);
        saveToFileDB.save();
    }
}
