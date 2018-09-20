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
public class Module005_6_02 extends AbstractComplexTask {

    public Module005_6_02(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runAssignment() {
        System.out.print("Please input an Integer value to sum the digits of: ");
        int sumDigits = sumDigits(ScannerUtil.getInteger(scanner, "")); // Invoke the sumDigits method with an input from the console.
        System.out.println("The sum of the digits is: " + sumDigits);
    }

    /**
     * A method used to sum the digits of a long value.
     * 
     * @param n is the number to sum the digits of.
     * @return the summed digits of the number.
     */
    public int sumDigits(long n) {
        int sum = 0;                                        // Declare a sum varible initialized with the value 0.
        for (char c : String.valueOf(n).toCharArray()) {    // Loop the chars/digits of the value.
            sum += Character.getNumericValue(c);            // Add the characters value to the sum varible using an augmented addition assignment statement.
        }
        return sum;                                         // Return the sum of the digits.
    }
}
