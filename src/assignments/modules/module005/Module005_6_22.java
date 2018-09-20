/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module005;

import assignments.ScannerUtil;
import assignments.modules.AbstractComplexTask;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module005_6_22 extends AbstractComplexTask {

    public Module005_6_22(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runAssignment() {
        long input = ScannerUtil.getLong(scanner, "Please input a long value to square: ");
        double acceptableDiffernce = ScannerUtil.getDouble(scanner, "Please input the precision. E.g. 0,0001: ");
        System.out.println("The square root of " + input + " with a precision of " + acceptableDiffernce + " is " + sqrt(input, acceptableDiffernce));
    }

    /**
     * Get the square root of a number.
     *
     * @param number is the number to get the square root of.
     * @param acceptableDifference the precision of the result. A lower value
     * equals a more precise result.
     * @return the square root of the number.
     */
    public double sqrt(long number, double acceptableDifference) {
        double lastGuess, nextGuess = 1; // Declare the two variables. The value assigned to nextGuess is indirectly assigned to lastGuess.
        do {
            lastGuess = nextGuess;                              // Set the value of lastGuess to nextGuess.
            nextGuess = (lastGuess + number / lastGuess) / 2;   // Calculate the next guess.
            // Continue if the difference of the two numbers is greater than 0.0001. 
            // Could have used Math.abs but this assignment is technically avoiding the use of the Math library.
        } while (nextGuess - lastGuess > acceptableDifference || lastGuess - nextGuess > acceptableDifference);
        return nextGuess;
    }
}
