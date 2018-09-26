/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module007;

import assignments.modules.AbstractComplexTask;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module007_1 extends AbstractComplexTask {

    public Module007_1(final Scanner scanner) {
        super(scanner);
    }

    /**
     * This method acts as the main method in the assignment description.
     */
    @Override
    public void runAssignment() {
        // Instantiate a new customer object for Jeff Bezos giving him the id 1 and a balance of 157.3 Billion (his estimated net worth)
        final Customer aCustomer = new Customer("Jeff Bezos", 1, 157_300_000_000D);

        // Deposit a billion more.
        aCustomer.deposit(1_000_000_000);

        // Withdraw 5.000.
        aCustomer.withdraw(5_000);

        // Print the info of the Customer Object.
        System.out.println("Customer " + aCustomer.getName() + " with the id " + aCustomer.getId() + " has " + aCustomer.getBalance() + "$");
    }
}
