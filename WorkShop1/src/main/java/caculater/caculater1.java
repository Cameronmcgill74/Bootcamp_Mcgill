package caculater;

import java.util.Scanner;

public class caculater1 {
    public static void calc1() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter loan amount: ");
        double loanAmount = scanner.nextDouble();

        System.out.println("Interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.println("Enter loan term: ");
        int loanTerm = scanner.nextInt();

        double principal = loanAmount;
        double rate = interestRate/ 100;
        int term = loanTerm;

        int numberOfPayments = term * 12;
        double monthlyInterestRate = rate / 12;

        System.out.println(principal);
        System.out.println(interestRate);
        System.out.println(term);

        double interestPow = Math.pow(1 + monthlyInterestRate, numberOfPayments);
        double top = monthlyInterestRate * interestPow;
        double bottom = interestPow - 1;
        double monthlyPayment = principal * (top / bottom);

        double totalInterest = (monthlyPayment * numberOfPayments) - principal;

        System.out.println("monthly payment: $" + monthlyPayment);
        System.out.println("Total Interest: $" + totalInterest);


     }





    }




            //principal = large
            //AnnualInterestRate = double
            //loanTerm - int
            //numMonthlyPayout = int
            //monthlyInterestRate = double







