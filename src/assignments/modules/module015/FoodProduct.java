/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module015;

import java.util.Date;

public class FoodProduct extends Product {

    // Data fields unique for this type of product.
    private final Date expirationDate;
    private final double storageTemperature;

    /**
     * Constructor taking five arguments. Three for the superclass and two for
     * the expiration date and storage temperature.
     *
     * @param productNumber is the number of the product.
     * @param productName is the name of the product.
     * @param price is the price of the product.
     * @param expirationDate is the expiration date of the product.
     * @param storageTemperature is the storage temperature of the product.
     * @throws ExpiredProductAddedException
     */
    public FoodProduct(final int productNumber, final String productName, final double price, final Date expirationDate, final double storageTemperature) throws ExpiredProductAddedException {
        super(productNumber, productName, price);

        // If the product is already expired then throw an ExpiredProductAddedException.
        if (expirationDate.before(new Date())) {
            throw new ExpiredProductAddedException();
        }

        this.expirationDate = expirationDate;
        this.storageTemperature = storageTemperature;
    }

    //Getters.
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public double getStorageTemperature() {
        return this.storageTemperature;
    }

    /**
     * Overridden from Product.
     *
     * @return True if is has expired. False if it hasn't.
     */
    @Override
    public boolean isExpired() {
        // If expirationDate is before now/today then it is expired.
        return expirationDate.before(new Date());
    }

    /**
     * Overridden from Object class.
     *
     * @return the product name and the expiration date.
     */
    @Override
    public String toString() {
        return super.getProductName() + " expires " + this.expirationDate.toString();
    }

    /**
     * Overridden from Object class. Checks if the products have the same
     * product number. If they do they are equal.
     *
     * @param obj the Object being compared.
     * @return whether or not this instance is equal to the Object passed to the
     * method.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof FoodProduct && super.getProductNumber() == ((FoodProduct) obj).getProductNumber();
    }
}
