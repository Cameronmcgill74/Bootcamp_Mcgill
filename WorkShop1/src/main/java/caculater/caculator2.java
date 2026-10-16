package caculater;

import java.util.Scanner;

public class caculator2 {
    public static void calc2 (){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter deposit amount: ");
        double deposit = scanner.nextDouble();

        System.out.println("Enter interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.println("Enter number of years: ");
        int years = scanner.nextInt();

        double principal = deposit;
        double rate = interestRate / 100;
        int dayPerYear = 365;
        int totalDays = dayPerYear * years;

        double dailyRate = rate / dayPerYear;
        double base = 1 + dailyRate;
        double interestpow = Math.pow(base, totalDays);
        double futureValue = principal * interestpow;

        double totalInterest = futureValue - principal;

        System.out.printf("Future value: $ %.2f%n" , futureValue);
        System.out.printf("Total Interest: $%.2f%n" , totalInterest);

        }



    }

