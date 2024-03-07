package project;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        HashMap<Integer,Integer> users = new HashMap<Integer,Integer>();
        users.put(1234,123);
        users.put(9876, 121);

        AtmOperationInterf op = new AtmOperationImpl();
       // int atmnumber = 12345;
      //  int atmpin = 123;
        Scanner in = new Scanner(System.in);

        try {
        
        System.out.println("\t\t\t---Welcome to ATM Machine---\t\t\t");
        System.out.print("\t\t\tEnter Atm Number : ");
        int atmNumber = in.nextInt();
        System.out.print("\t\t\tEnter Pin: ");
        int pin = in.nextInt();

        if (users.get(atmNumber) == null) {
            System.out.println("wrong password");
            System.exit(0);
        }

      //  if ((atmnumber == atmNumber) && (atmpin == pin)) {
        if (users.get(atmNumber) == pin) {
            while (true) {
                System.out.println("\n||Welcome User||");
                System.out.print(
                        "\n1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit");
                System.out.print("\n\nEnter Choice : ");
                int ch = in.nextInt();
                if (ch == 1) {
                    op.viewBalance();

                } else if (ch == 2) {
                    System.out.println("Enter amount to withdraw ");
                    double withdrawAmount = in.nextDouble();
                    op.withdrawAmount(withdrawAmount);

                } else if (ch == 3) {
                    System.out.println("Enter Amount to Deposit :");
                    double depositAmount = in.nextDouble();
                    op.depositAmount(depositAmount);

                } else if (ch == 4) {
                    op.viewMiniStatement();

                } else if (ch == 5) {
                    System.out.println("Collect your ATM Card\n Thank you for using ATM Machine!!");
                    System.exit(0);
                } else {
                    System.out.println("Please enter correct choice");
                }
            }
        } else {
            System.out.println("Incorrect Atm Number or pin");
            System.exit(0);
        }
    } catch (Exception e) {
        System.out.println("Invalid input");
    }

    }
}
