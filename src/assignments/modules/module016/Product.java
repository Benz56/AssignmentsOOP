/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module016;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
abstract class Product implements Expireable, Comparable<Product> {

    // Private data fields with some basic product info.
    private final int productNumber;
    private final String productName;
    private final double price;

    /**
     * Product constructor taking three arguments.
     *
     * @param productNumber is the number of the product.
     * @param productName is the name of the product.
     * @param price is the price of the product.
     */
    public Product(final int productNumber, final String productName, final double price) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.price = price;
    }

    //Getters for all of the data fields.
    public int getProductNumber() {
        return this.productNumber;
    }

    public String getProductName() {
        return this.productName;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean isExpired() {
        throw new UnsupportedOperationException("Product does not support this operation");
    }

    @Override
    public int compareTo(Product o) {
        // Since price is a double and we have to return an int directly subtracting could result in incorrect results.
        // Therefore we simply compare the values to each other using == and > and returns the appropriate value.
        return this.price != o.getPrice() ? this.price > o.getPrice() ? 1 : -1 : 0;
    }
}
