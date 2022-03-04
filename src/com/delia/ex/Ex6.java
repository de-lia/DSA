package com.delia.ex;

import java.util.Scanner;

public class Ex6 {

    static int a;
    static int b;
    static int c;

    public static void run() {
        Ex6 arithmeticFormula = new Ex6();
        arithmeticFormula.getTheNumber();
        float value = 1;
        int oper2Range;
        for (int i = 0; i < 4; i++) {
            if (i < 2)
                oper2Range = 4;
            else
                oper2Range = 2;
            for (int j = 0; j < oper2Range; j++)
                if ((value = valueOf(a, b, c, i, j)) == 0) {
                    System.out.print("Your inputs can form the equation: ");
                    displayEquation(i, j);
                    break;
                }
        }
        if (value != 0)
            System.out.println("Your inputs can't form any equation.");
    }

    private static float valueOf(int a, int b, int c, int oper1, int oper2) {
        if (oper2 == 2 || oper2 == 3)
            return calculate(a, calculate(b, c, oper2), oper1);
        else
            return calculate(c, calculate(a, b, oper1), oper2);
    }

    private static float calculate(float x, float y, int oper) {
        switch (oper) {
            case 0:
                return x + y;
            case 1:
                return x - y;
            case 2:
                return x * y;
            default:
                return (float) x / y;
        }
    }

    private static void displayEquation(int oper1, int oper2) {
        if (oper1 == 0 || oper1 == 1)
            // a +- b */ c = 0 -> a = -+ b * c
            if (oper2 == 2 || oper2 == 3)
                System.out.printf("a = %cb %c c\n",
                        (toChar(oper1) == '+') ? '-' : '\u0000', toChar(oper2));
                // a +- b +- c = 0 -> a +- b = -+ c
            else
                System.out.printf("a %c b = %cc\n", toChar(oper1),
                        (toChar(oper2) == '+') ? '-' : '\u0000');
            // a */ b +- c = 0 -> a */b = -+ c
        else
            System.out.printf("a %c b = %cc\n", toChar(oper1),
                    (toChar(oper2) == '+') ? '-' : '\u0000');
    }


    private static char toChar(int operator) {
        switch (operator) {
            case 0:
                return '+';
            case 1:
                return '-';
            case 2:
                return '*';
            default:
                return '/';
        }
    }

    public void getTheNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number a: ");
        a = scanner.nextInt();
        System.out.println("enter number b: ");
        b = scanner.nextInt();
        System.out.println("enter number c: ");
        c = scanner.nextInt();
        scanner.close();
    }

}