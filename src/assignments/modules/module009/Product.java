/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module009;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
class Product {
    
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
        return productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}
