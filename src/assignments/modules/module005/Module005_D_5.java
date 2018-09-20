/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module005;

import assignments.modules.AbstractComplexTask;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module005_D_5 extends AbstractComplexTask {

    public Module005_D_5(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runAssignment() {
        init();
    }

    private void init() {
        System.out.println("Printing prime numbers between 100 and 200 (both inclusive)");
        for (int i = 100; i <= 200; i++) { // Loop all values between 100 and 200.
            // Print whether or not the value is a prime number.
            System.out.println(i + " is " + (!isPrime(i) ? "not " : "") + "a prime number.");
        }
    }

    /**
     * Determine if the value is a prime number.
     *
     * @param value is the number to be checked.
     * @return whether or not the value is a prime number.
     */
    private boolean isPrime(int value) {
        //Algorithm for determining if the value is a prime number.
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
