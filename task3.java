import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance = balance+amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void UserInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                checkBalance();
            } else if (choice == 2) {
                deposit(scanner);
            } else if (choice == 3) {
                withdraw(scanner);
            } else if (choice == 4) {
                System.out.println("Thank you.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: %.2f%n", account.checkBalance());
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.printf("%.2f has been deposited to your account.%n", amount);
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.printf("%.2f has been withdrawn from your account.%n", amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
public class task3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100000);  
        
        ATM atm = new ATM(account);
        atm.UserInput();
    }
}
    
       