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
public class Module005_6_03 extends AbstractComplexTask {

    public Module005_6_03(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runAssignment() {
        System.out.print("Please input an Integer to check if it is a Palindrome: ");
        int input = ScannerUtil.getInteger(scanner, ""); // Take an integer input from the console.
        boolean isPalindrome = isPalindrome(input);      // Invoke the isPalindrome method with an input from the console.
        System.out.println("The number " + input + " is " + (isPalindrome ? "" : "not ") + "a Palindrome");
    }

    /**
     * A method used to reverse an integer value.
     *
     * @param number is the number to reverse.
     * @return the reversed number.
     */
    public int reverse(int number) {
        int reversed = 0;               // Declare a variable to store the reversed value in. 
        while (number != 0) {           // Loop until the initial number equals 0.
            reversed *= 10;             // Multiply the reversed value by to 10 i.e. moving to the next digit.
            reversed += number % 10;    // Add the right most digit of the number to the reversed variable.
            number /= 10;               // Divide the number by 10 i.e. moving to the next digit.
        }
        return reversed;                // Return the reversed number.
    }

    /**
     * Check if a number is a palindrome i.e. equal to the reversed number of
     * itself.
     *
     * @param number to be checked if it as a palindrome.
     * @return whether or not the value is a palindrome.
     */
    public boolean isPalindrome(int number) {
        return number == reverse(number);
    }
}
