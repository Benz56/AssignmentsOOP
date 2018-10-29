/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class ScannerUtil {

    public static int getInteger(Scanner scanner) {
        return getInteger(scanner, "Please input an integer value!");
    }

    public static int getInteger(Scanner scanner, String inputMessage) {
        if (!inputMessage.isEmpty()) {
            System.out.print(inputMessage);
        }
        Integer value = null;
        do {
            try {
                value = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please input an integer value!");
                scanner.next();
            }
        } while (value == null);
        return value;
    }
    
    public static long getLong(Scanner scanner) {
        return getLong(scanner, "Please input a long value!");
    }

    public static long getLong(Scanner scanner, String inputMessage) {
        if (!inputMessage.isEmpty()) {
            System.out.print(inputMessage);
        }
        Long value = null;
        do {
            try {
                value = scanner.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please input a long value!");
                scanner.next();
            }
        } while (value == null);
        return value;
    }

    public static double getDouble(Scanner scanner) {
        return getDouble(scanner, "Please input a double or integer value!");
    }

    public static double getDouble(Scanner scanner, String inputMessage) {
        if (!inputMessage.isEmpty()) {
            System.out.println(inputMessage);
        }
        Double value = null;
        do {
            try {
                value = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please input a double or integer value!");
                scanner.next();
            }
        } while (value == null);
        return value;
    }
}
