package SOLID_DESIGN_PRINCIPLES.LiskovSubstitutionPrinciple.LSPRules.SignatureRules;

// Child class methods can handle only exceptions of what parent class has exception and its subclasses, it should not handle outside the parent class exceptions

// └── java.lang.Exception                        // Conditions your application might want to catch
//     ├── java.io.IOException                    // Checked I/O failures
//     │   ├── java.io.FileNotFoundException
//     │   ├── java.io.EOFException
//     │   └── java.net.MalformedURLException
//     ├── java.lang.ClassNotFoundException       // Checked reflect/… failures
//     ├── java.lang.InterruptedException         // Checked thread interruption
//     ├── java.sql.SQLException                  // Checked SQL/database errors
//     ├── java.text.ParseException               // Checked parsing errors
//     └── java.lang.RuntimeException             // Unchecked; subclasses may be thrown anywhere
//         ├── java.lang.ArithmeticException      // e.g. divide by zero
//         ├── java.lang.NullPointerException
//         ├── java.lang.ArrayIndexOutOfBoundsException
//         ├── java.lang.StringIndexOutOfBoundsException
//         ├── java.lang.IllegalArgumentException
//         │    └── java.lang.NumberFormatException
//         ├── java.lang.IllegalStateException
//         ├── java.lang.UnsupportedOperationException
//         └── java.lang.IndexOutOfBoundsException

class Parent {
    public void getValue() throws RuntimeException {
        throw new RuntimeException("Parent Error");
    }
}

class Child extends Parent {
    public void getValue() throws ArithmeticException {
        throw new ArithmeticException("Child Error");
        // throw new Exception("child Error"); // This is wrong & not allowed
    }
}

class Client {
    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void get() {
        try {
            p.getValue();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}

public class MethodExceptionTypeRule {
    public static void main(String[] args) {
        Parent p = new Parent();
        Client obj1 = new Client(p);
        obj1.get();

        Child c = new Child();
        Client obj2 = new Client(c);
        obj2.get();

        Parent p1 = new Child();
        Client obj3 = new Client(p1);
        obj3.get();

    }
}
