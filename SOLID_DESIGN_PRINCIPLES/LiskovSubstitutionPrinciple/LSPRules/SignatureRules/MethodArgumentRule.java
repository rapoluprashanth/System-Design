package SOLID_DESIGN_PRINCIPLES.LiskovSubstitutionPrinciple.LSPRules.SignatureRules;

//child classes should have same arguments what broader (parent) class have 

class Parent {
    public void print(String msg) {
        System.out.println("Parent: " + msg);
    }
}

class Child extends Parent {
    public void print(String msg) {
        System.out.println("Child: " + msg);
    }
}

class Client {
    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void printMsg() {
        p.print("Hello");
    }
}

public class MethodArgumentRule {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent child = new Child();

        // Client c1 = new Client(parent);
        // c1.printMsg();

        Client c2 = new Client(child);
        c2.printMsg();

    }
}
