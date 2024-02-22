import java.util.*;


public class ATM {

    private  static double balance = 20000;
    private  static String pin = "1234";



    public static boolean verifyCardDetails(String cardNumber, int expiryMonth, int expiryYear, String cardType)
      {

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

        return cardType.equals("Master") || cardType.equals("Visa") || cardType.equals("Debit") || cardType.equals("Credit");

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


    public static void checkBalance( double balance) {
        System.out.println("Your balance is: $" + balance);

    }


    public static double withdraw( double balance ,double withdrawAmount) {

        if (withdrawAmount> balance) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            balance -= withdrawAmount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        }
        return balance;
    }


    public static double deposit(double balance ,double depositAmount) {

        balance += depositAmount;
        System.out.println("Deposit successful. Current balance: $" + balance);
        return balance;

    }


    public static String changePin(String pin) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your old PIN: ");

        String oldPin = scanner.nextLine();

        if (pin.equals(oldPin)) {

            System.out.print("Enter new PIN: ");

            pin = scanner.nextLine();


            System.out.println("PIN changed successfully.");


        } else {
            System.out.println("Incorrect old PIN. PIN change failed.");
        }



        scanner.close();
        return pin;
    }



    public static void displayMenu(Scanner scanner) {
          while(true) {
              System.out.println("\nMain Menu:");
              System.out.println("1. Check Balance");
              System.out.println("2. Withdraw");
              System.out.println("3. Deposit");
              System.out.println("4. Change PIN");
              System.out.println("5. Exit");
              System.out.print("Enter your choice: ");
              int choice = scanner.nextInt();
              scanner.nextLine();

              switch (choice) {
                  case 1:
                      checkBalance(getBalance());
                      break;
                  case 2:
                      System.out.print("Enter amount to withdraw: $");
                      double withdrawAmount = scanner.nextDouble();
                      withdraw(getBalance(), withdrawAmount);
                      break;
                  case 3:
                      System.out.print("Enter amount to deposit: $");
                      double depositAmount = scanner.nextDouble();
                      deposit(getBalance(), depositAmount);
                      break;
                  case 4:
                       pin =changePin(getPin());
                      break;
                  case 5:
                      System.out.println("Thank you for using the Apna ATM. Please Visite Again!");
                      System.exit(0);
                  default:
                      System.out.println("Invalid choice. Please try again.");
              }
          }
    }






    public static void setBalance(double newBalance) {

        balance = newBalance;
    }


    public static double getBalance() {
        return balance;
    }



    public static void setPin(String newPin) {
        pin = newPin;
    }



    public static String getPin() {
        return pin;
    }






    public static void main(String [] args)
    {

   Scanner scanner = new Scanner(System.in);
   displayMenu(scanner);


    }

}
