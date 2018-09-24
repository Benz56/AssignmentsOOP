/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module007;

import assignments.ScannerUtil;
import assignments.modules.AbstractComplexTask;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module007_2 extends AbstractComplexTask {

    public Module007_2(Scanner scanner) {
        super(scanner);
    }

    /**
     * This method acts as the main method in the assignment description.
     */
    @Override
    public void runAssignment() {
        // Instantiate a new CustomerDatabase.
        final CustomerDatabase customerDatabase = new CustomerDatabase();

        // Populate the database with a Customer object for each of the following names.
        final String[] names = {"Bob", "Jan", "Klaus", "Holger", "Myrna", "John"};
        for (int i = 0; i < 6; i++) {
            // Insert the Customers by name, and id, and an arbritrary balance.
            customerDatabase.insertCustomer(new Customer(names[i], i + 1, Math.random() * 1_000));
        }

        // Print the currently stored customers.
        System.out.println("Currently stored customers:");
        customerDatabase.printStoredCustomerNames();
        System.out.println("\n\n");

        // Take an integer input from the console.
        final Integer idToRemove = ScannerUtil.getInteger(scanner, "Please enter the id of a customer to remove: ");

        // Try to remove the customer.
        final boolean wasRemoved = customerDatabase.removeCustomerById(idToRemove);

        // Based on whether or not a customer was removed either print the stored customers or again or an error message.
        if (wasRemoved) {
            // Print the stored customers again.
            System.out.println("Currently stored customers:");
            customerDatabase.printStoredCustomerNames();
        } else {
            System.out.println("No Customer with the id " + idToRemove + " exists!");
        }
    }
}
