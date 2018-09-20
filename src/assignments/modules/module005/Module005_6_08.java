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
public class Module005_6_08 extends AbstractComplexTask {

    public Module005_6_08(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runAssignment() {
        System.out.println("Miles     Kilometers   |   Kilometers     Miles");
        System.out.println("-----------------------|-------------------------");
        for (int miles = 1; miles <= 10; miles++) { // Loop from 1 - 10(both inclusive)
            int kilometers = 15 + miles * 5;        // Start from 20, increment by 5 times the value of miles.
            // Print the formated table row.
            System.out.printf("%-9d %-12.3f |   %-14d %-8.3f %n", miles, mileToKilometer(miles), kilometers, kilometerToMile(kilometers));
        }
    }

    /**
     * Convert mile to kilometer.
     *
     * @param mile to be converted.
     * @return the kilometer value.
     */
    public double mileToKilometer(double mile) {
        return mile * 1.6D;
    }

    /**
     * Convert kilometer to mile.
     *
     * @param kilometer to be converted.
     * @return the mile value.
     */
    public double kilometerToMile(double kilometer) {
        return kilometer / 1.6D;
    }
}
