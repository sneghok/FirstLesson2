package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number");
        int firstNumber = scanner.nextInt();

        System.out.println("Enter symbol");
        String symbol = scanner.next();

        System.out.println("Enter second number");
        int secondNumber = scanner.nextInt();

        switch (symbol) {
            case "+":
                System.out.println("Result: " + (firstNumber + secondNumber));
                break;
            case "-":
                System.out.println("Result: " + (firstNumber - secondNumber));
                break;
            case "/":
                System.out.println("Result: " + (firstNumber / secondNumber));
                break;
            case "*":
                System.out.println("Result: " + (firstNumber * secondNumber));
                break;
            case "%":
                System.out.println("Result: " + (firstNumber % secondNumber));
                break;
            default:
                System.out.println("Не вводи бред");
        }
    }
}