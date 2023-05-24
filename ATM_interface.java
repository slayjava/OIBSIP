import java.util.*;

public class ATM_interface {
    static double balance;
    static int pin;

    static void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs." + amount);
        System.out.println("Current Balance: Rs." + balance);
    }

    static void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Not enough Balance to withdraw");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
            System.out.println("Current Balance: Rs." + balance);
        }
    }

    static void transfer(double amount,int accno) {
        if (amount > balance) {
            System.out.println("Not enough Balance to transfer");
        } else {
            balance -= amount;
            System.out.println("Successfully transferred to: "+accno);
            System.out.println("Current Balance: Rs." + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = 1234, acno;
        String name;
        System.out.println("Enter Account Holder name");
        name = sc.nextLine();
        System.out.println("Enter Account number");
        acno = sc.nextInt();
        System.out.println("Enter PIN: ");
        int pin = sc.nextInt();
        if (pin != p) {
            System.out.println("You have entered the wrong Pin\nTry again....");
        } else {
            System.out.println("Enter balance amount");
            balance = sc.nextDouble();
            while (true) {
                System.out.println("\n----- ATM Menu -----");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Account Holder name=" + name + "\nAccount number=" + acno
                                + "\nCurrent Balance: Rs." + balance);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: Rs.");
                        double depositAmt = sc.nextDouble();
                        deposit(depositAmt);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: Rs.");
                        double withdrawAmt = sc.nextDouble();
                        withdraw(withdrawAmt);
                        break;
                    case 4:
                        System.out.print("Enter the account number where you want to transfer: ");
                        int n = sc.nextInt();
                        System.out.println("Enter the amount: Rs.");
                        double transferAmt = sc.nextDouble();
                        transfer(transferAmt,n);
                        break;
                    case 5:
                        System.out.println("See you again next time");
                        return;
                    default:
                        System.out.println("Invalid input.");
                }
            }
        }
        sc.close();
    }
}
