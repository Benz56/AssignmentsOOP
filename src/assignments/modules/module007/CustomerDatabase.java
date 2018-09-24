/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module007;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class CustomerDatabase {

    // Field for storing the customers. By default it is initialized as an empty array.
    private Customer[] customers = {};

    // All Java classes have an implicit public no-args constructor.
    // Since no logic has to be performed on Object creation it has been left out.
    /**
     * Insert a new Customer into the "database".
     *
     * @param customer is the customer to insert.
     */
    public void insertCustomer(Customer customer) {
        Customer[] copy = new Customer[customers.length + 1];       // Instantiate a new Customer array one larger than the current.
        System.arraycopy(customers, 0, copy, 0, customers.length);  // Copy the current array. This is the same as using a for loop.
        copy[copy.length - 1] = customer;                           // Assign the last empty slot to the new customer.
        customers = copy;                                           // Replace the current array with the new array.
    }

    /**
     * Remove a Customer in the currently stored array if their id matches the
     * argument provided.
     *
     * @param id is the id of the Customer you wish to remove.
     * @return whether or not a Customer with the given id was found and
     * removed.
     */
    public boolean removeCustomerById(int id) {
        Customer[] copy = new Customer[customers.length - 1];   // Instantiate a new Customer array one smaller than the current.
        int i = 0;                                              // Declare the int i and assign it to 0;
        for (Customer customer : customers) {                   // Loop all customers using an enhance for loop.
            if (customer.getId() != id) {                       // Check if the customers id does NOT equal the id of the customer to remove.
                if (i == copy.length) {                         // Check if i is equal to the length of the copy array.
                    return false;                               // If it is then no customer with the given id exists, therefore return false.
                }
                copy[i++] = customer;                           // Add the customer to the copy array and increment i using postfix incrementation.
            }
        }
        customers = copy;                                       // Replace the current customers with the updated array.
        return true;                                            // Return true as a customer with the given id was found and removed.
    }

    /**
     * Simple getter used to retrieve the stored customers.
     *
     * @return the currently stored customers.
     */
    public Customer[] getStoredCustomers() {
        return customers;
    }

    /**
     * Prints all of the stored customer and info about them formatted to the console.
     */
    public void printStoredCustomerNames() {
        for (Customer customer : customers) {
            System.out.printf(" Customer %-6s with the id %s has %-5.2f$%n", customer.getName(), customer.getId(), customer.getBalance());
        }
    }
}
