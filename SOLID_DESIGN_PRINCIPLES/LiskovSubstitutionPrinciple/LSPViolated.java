package SOLID_DESIGN_PRINCIPLES.LiskovSubstitutionPrinciple;

import java.util.ArrayList;
import java.util.List;

abstract class Account {
    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);
}

class SavingAccount extends Account {

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

class CurrentAccount extends Account {
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

class FixedTermAccount extends Account {
    private double balance;

    public FixedTermAccount() {
        balance = 0;
    }

    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawal not allowed in Fixed Term Account!");
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }
}

class Client {
    private List<Account> accounts;

    public Client(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void processTransaction() {
        for (Account acc : accounts) {
            acc.deposit(1000); // All accounts allow deposits

            // Assuming all accounts support withdrawal (LSP Violation)
            try {
                acc.withdraw(500);
            } catch (UnsupportedOperationException e) {
                System.err.println(e);
            }
        }
    }

}

public class LSPViolated {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedTermAccount());

        Client obj = new Client(accounts);
        obj.processTransaction();
    }
}
