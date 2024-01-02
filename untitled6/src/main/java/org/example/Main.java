package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class {@code Main} is the main class of the program.
 * The program starts from method main of {@code Main} class.
 *
 * @author Yulia Demir
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a count of numbers less than 10: ");
        try {
            int countOfNumbers = scanner.nextInt();
            if (countOfNumbers >= 10)
                throw new IllegalArgumentException("");
            scanner.nextLine();

            String[] numbers = new String[countOfNumbers];
            String number;
            String shortNumber = null, longNumber = null;
            for (int i = 0; i < countOfNumbers; i++) {
                number = scanner.nextLine();
                try {
                    Double.parseDouble(number.trim());
                }
                catch (Exception e) {
                    System.err.println("It is not number!");
                    System.exit(1);
                }
                numbers[i] = number;
                shortNumber = shortNumber == null ? number :
                        shortNumber.length() > number.length() ? number : shortNumber;
                longNumber = longNumber == null ? number :
                        longNumber.length() < number.length() ? number : longNumber;
            }
            System.out.println("Numbers: " + Arrays.toString(numbers));
            System.out.println("The shortest number is " + shortNumber);
            System.out.println("The longest number is " + longNumber);
        }
        catch (Exception e) {
            System.out.println("The incorrect count of numbers were entered!");
        }
    }
}