import java.util.*;


public class ATM {


    public static boolean verifyCardDetails(String cardNumber, int expiryMonth, int expiryYear, String cardType) {

        if (cardNumber.length() != 16) {
            System.out.println("Invalid card number length.");
            return false;
        }


        if (expiryMonth < 1 || expiryMonth > 12) {
            System.out.println("Invalid expiry month.");
            return false;
        }


        int currentYear = java.time.Year.now().getValue();


        if (expiryYear < currentYear) {
            System.out.println("Card has expired.");
            return false;
        }



        if (isValidCardType(cardType)) {
            System.out.println("Invalid card type.");
            return false;
        }


        System.out.println("Valid card details.");
        return true;
    }



    public static boolean isValidCardType(String cardType) {

        if(cardType.equals("Master") || cardType.equals("Visa") || cardType.equals("Debit")  || cardType.equals("Credit"))
        {
            return true;
        }



        return false;
    }



    public static boolean checkPin(Scanner scanner, String correctPin) {
        int pinAttempts = 0;
        while (pinAttempts < 3) {
            System.out.print("Enter your PIN: ");
            String enteredPin = scanner.nextLine();

            if (enteredPin.equals(correctPin)) {
                return true;
            } else {
                pinAttempts++;
                System.out.println("Incorrect PIN. Please try again.");
            }
        }
        return false;
    }



    public static void checkBalance( double totalBalance) {
        System.out.println("Your balance is: $" + totalBalance);

    }


    public static double withdraw( double totalBalance ,double withdrawAmount) {

        if (withdrawAmount> totalBalance) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            totalBalance -= withdrawAmount;
            System.out.println("Withdrawal successful. Remaining balance: $" + totalBalance);
        }
        return totalBalance;
    }


    public static double deposit(double totalBalance ,double depositAmount) {

        totalBalance += depositAmount;
        System.out.println("Deposit successful. Current balance: $" + totalBalance);
        return totalBalance;

    }








    private static void changePin() {
        System.out.print("Enter new PIN: ");
        pin = scanner.nextLine();
        System.out.println("PIN changed successfully.");
    }















    public static void displayMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. View Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    checkBalance(45678);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(totalBalance,withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    deposit( totalBalance,depositAmount);
                    break;
                case 4:
                    changePin();
                    break;
                case 5:
                    System.out.println("Thank you for using the Apna ATM. Please Visite Again!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }




















    public static void main(String [] args)
    {

        double totalBalance =800000;


    }

}
