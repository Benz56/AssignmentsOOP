/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module015.liang;

import assignments.modules.AbstractComplexTask;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module015_12_3 extends AbstractComplexTask {

    private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static final int[] DOM = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Module015_12_3(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runAssignment() {
        // Get the next integer input from the Scanner. Subtract 1 as arrays as 0 indexed.
        System.out.print("Please input an integer between 1 and 12: ");
        int monthIndex;

        // If the input value isn't an integer an error message is printed and the method is recursively retried.
        try {
            monthIndex = scanner.nextInt() - 1;
        } catch (InputMismatchException e) {
            scanner.next(); // Skip the token to avoid an infinite recursion loop resulting in a StackOverFlowError.
            System.out.println("The value has to be an Integer. Try again...");
            runAssignment(); // Recursively retry. Not optimal (bad practice) but it works in accordance with the assignments guidelines.
            return; // <- Only to prevent compile error.
        }

        // If the input value isn't between 1 and 12 an error message is printed and the method is recursively retried.
        try {
            System.out.println(MONTHS[monthIndex] + " has " + DOM[monthIndex] + " days.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The value has to be between 1 and 12. Try again...");
            runAssignment(); // Recursively retry. Not optimal (bad practice) but it works in accordance with the assignments guidelines.
        }
    }
}
