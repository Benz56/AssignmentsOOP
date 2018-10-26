/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module011;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class ProductDatabase {

    // List for storing all products.
    private final List<Product> inventory = new ArrayList<>();

    /**
     * A method used to return all the list.
     *
     * @return the list.
     */
    public List<Product> getProductList() {
        return this.inventory;
    }

    /**
     * Adds a product to the database.
     *
     * @param product is the product to be added.
     * @return true if an item was added; false if it wasn't.
     */
    public boolean addProduct(final Product product) {
        final boolean hasProduct = this.inventory.contains(product);
        if (!hasProduct) {
            this.inventory.add(product);
        }
        return !hasProduct;
    }

    /**
     * Removes a product from the list.
     *
     * @param number is the productNumber to be removed.
     * @return true if an item was removed; false if it wasn't.
     */
    public boolean removeProductByNumber(final int number) {
        for (final Product product : this.inventory) {
            if (product.getProductNumber() == number) {
                return this.removeProduct(product);
            }
        }
        return false;
    }

    /**
     * Removes a product from the list.
     *
     * @param product is the product to be removed.
     * @return true if an item was removed; false if it wasn't.
     */
    public boolean removeProduct(final Product product) {
        final boolean hasProduct = this.inventory.contains(product);
        if (hasProduct) {
            this.inventory.remove(product);
        }
        return hasProduct;
    }

    /**
     * Calculates the total value of all the products in the list.
     *
     * @return the total value of all products in the map.
     */
    public double getInventoryValuation() {
        double inventoryValuation = 0;
        for (final Product product : this.inventory) {
            inventoryValuation += product.getPrice();
        }
        return inventoryValuation;
        
        // One-liner:
        // return this.inventory.stream().mapToDouble(Product::getPrice).sum();
    }
}
