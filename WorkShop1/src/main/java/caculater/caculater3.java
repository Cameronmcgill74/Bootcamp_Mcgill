package caculater;

import java.util.Scanner;

public class caculater3 {
        public static void calc3 () {


            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter monthly payout: ");
            double monthlyPayout = scanner.nextDouble();

            System.out.println("Enter interest rate: ");
            double interestRate = scanner.nextDouble();

            System.out.println("Enter number of years: ");
            int years = scanner.nextInt();

            double rate = interestRate / 100;
            double monthlyRate = rate / 12;
            int numberOfPayments = years * 12;

            double interestPow = Math.pow(1 + monthlyRate, numberOfPayments);
            double top = 1 -(1 / interestPow);
            double presentValue = monthlyPayout * (top / monthlyRate);

            System.out.printf("Present value: $%.2f%n", presentValue);










        }
    }

