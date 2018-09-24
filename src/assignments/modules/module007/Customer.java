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
public class Customer {

    // Fields are private to follow the principle of encapsulation. One of the four fundamental OOP concepts.
    private final String name;
    private final int id;
    private double balance;

    /**
     * Constructor taking only the name and id of the customer and setting the
     * balance to 10. Using the this keyword to call another constructor is
     * known as explicit constructor invocation.
     *
     * @param name is the name of the customer.
     * @param id is the id of the customer.
     */
    public Customer(final String name, final int id) {
        this(name, id, 10);
    }

    /**
     * Constructor taking name, id, and balance as arguments.
     *
     * @param name is the name of the customer.
     * @param id is the id of the customer.
     * @param balance is the initial balance of the customer.
     */
    public Customer(final String name, final int id, final double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    /**
     * Method used to deposit an arbritrary amount to your current balance.
     *
     * @param amount is the amount to deposit.
     */
    public void deposit(final double amount) {
        balance += amount;
    }

    /**
     * Method used to withdraw an arbritrary amount from your balance only if
     * the balance is greater than the amount being withdrawn.
     *
     * @param amount is the amount to withdraw.
     */
    public void withdraw(final double amount) {
        balance -= balance > amount ? amount : 0;
    }

    /**
     * Simple getter method.
     *
     * @return the name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Simple getter method.
     *
     * @return the id of the customer.
     */
    public int getId() {
        return id;
    }

    /**
     * Simple getter method.
     *
     * @return the balance of the customer.
     */
    public double getBalance() {
        return balance;
    }
}
