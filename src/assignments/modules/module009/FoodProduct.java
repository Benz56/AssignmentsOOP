/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module009;

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
     */
    public FoodProduct(final int productNumber, final String productName, final double price, final Date expirationDate, final double storageTemperature) {
        super(productNumber, productName, price);
        this.expirationDate = expirationDate;
        this.storageTemperature = storageTemperature;
    }

    //Getters.
    public Date getExpirationDate() {
        return expirationDate;
    }

    public double getStorageTemperature() {
        return storageTemperature;
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
}
