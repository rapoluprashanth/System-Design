package SOLID_DESIGN_PRINCIPLES.LiskovSubstitutionPrinciple.LSPRules.SignatureRules;

// Return Type Rule : 
// Subtype overridden method return type should be either identical 
// or narrower than the parent method's return type.
// This is also called return type covariance.

class Animal { // Broader

}

class Dog extends Animal { // Narrower

}

class Parent {

    public Animal getAnimal() {
        System.out.println("Parent : Returning Animal instance");
        return new Animal(); // return type
    }
}

class Child extends Parent {

    public Animal getAnimal() {
        System.out.println("Child : Returning Dog instance");
        return new Dog(); // return type is Narrower of Parentclass return type of Broader class i.e
                          // Animal
    }
}

class Client {
    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void f() {
        p.getAnimal();
    }
}

public class MethodReturnTypeRule {
    public static void main(String[] args) {

        Parent parent = new Parent();
        Child child = new Child();

        Client obj1 = new Client(parent);
        obj1.f();

        Client obj2 = new Client(child);
        obj2.f();
    }

}
