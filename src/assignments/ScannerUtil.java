/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments;

import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class ScannerUtil {

    public static int getInteger(Scanner scanner) {
        return getInteger(scanner, "Please input an integer value!");
    }
    
    public static int getInteger(Scanner scanner, String errorMessage) {
        System.out.println(errorMessage);
        Integer value = null;
        do {
            try {
                value = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please input an integer value!");
                scanner.next();
            }
        } while (value == null);
        return value;
    }

    public static double getDouble(Scanner scanner) {
        return getDouble(scanner, "Please input a double or integer value!");
    }
    
    public static double getDouble(Scanner scanner, String errorMessage) {
        System.out.println(errorMessage);
        Double value = null;
        do {
            try {
                value = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input. Please input a double or integer value!");
                scanner.next();
            }
        } while (value == null);
        return value;
    }
}
