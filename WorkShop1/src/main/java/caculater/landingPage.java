package caculater;

import java.util.Scanner;

import static caculater.caculater1.calc1;
import static caculater.caculater3.calc3;
import static caculater.caculator2.calc2;

public class landingPage {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which calculator would you like to use: (1 - 3)");
        int calcNum = scanner.nextInt();

       switch (calcNum) {
           case 1:
               calc1();
               break;
           case 2:
             calc2();
            break;
           case 3:
              calc3();
            break;
           default:
       }

        }

    }

