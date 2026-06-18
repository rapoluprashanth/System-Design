package SOLID_DESIGN_PRINCIPLES.LiskovSubstitutionPrinciple;

import java.util.ArrayList;
import java.util.List;

abstract class Deposit {
    public abstract void deposit(double amount);
}

abstract class DepositAndWithDrawn extends Deposit {
    public abstract void withdraw(double amount);
}

class SavingAccount extends DepositAndWithDrawn {

    private double balance;

    public SavingAccount() {
        balance = 0;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
    }
}

class CurrentAccount extends DepositAndWithDrawn {
    private double balance;

    public CurrentAccount() {
        balance = 0;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }
}

class FixedTermAccount extends Deposit {
    private double balance;

    public FixedTermAccount() {
        balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }
}

class Client {
    private List<DepositAndWithDrawn> depAndWithDraw;
    private List<Deposit> depAccount;

    public Client(List<DepositAndWithDrawn> depAndWithDraw, List<Deposit> depAccount) {
        this.depAndWithDraw = depAndWithDraw;
        this.depAccount = depAccount;
    }

    public void processTransaction() {
        for (DepositAndWithDrawn acc : depAndWithDraw) {
            acc.deposit(1000);
            acc.withdraw(500);
        }
        for (Deposit acc : depAccount) {
            acc.deposit(1000);
        }
    }

}

public class LSPFollowed {
    public static void main(String[] args) {
        List<DepositAndWithDrawn> depAndWithDraw = new ArrayList<>();
        depAndWithDraw.add(new SavingAccount());
        depAndWithDraw.add(new CurrentAccount());

        List<Deposit> depAccount = new ArrayList<>();
        depAccount.add(new FixedTermAccount());

        Client obj = new Client(depAndWithDraw, depAccount);
        obj.processTransaction();

    }
}
