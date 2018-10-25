/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module014;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     * Removes all expired products in the current inventory.
     * 
     * @return The number of products removed.
     */
    public int removeExpiredFoods() {
        int removedProducts = 0;  // To keep track of how Products are removed.
       
        /* Iterate over the inventories products. The assignment doesn't mention this
         * but just iterating "this.inventory" will result in a ConcurrentModificationException.
         * This happens when you remove something from a collection you're currently iterating.
         * By creating a new ArrayList with the inventories content we can avoid this.
         * Another solution is using an Iterator though we haven't been introduced to that.*/
        for (final Product product : new ArrayList<>(this.inventory)) {
            // try-catch. Success if the product has overriden the isExpired() method in Product.
            try {
                // Remove the product if it is expired.
                if (product.isExpired()) {
                    removedProducts++;
                    this.inventory.remove(product);
                }
            } catch (UnsupportedOperationException e) {
                //Not a FoodProduct.
            }
        }
        
        return removedProducts; // Return the number of items removed.

        /* Below is a fancy way to do this in three lines.
        
        int removedProducts = this.inventory.size();
        this.inventory.removeAll(this.inventory.stream().filter(product -> product instanceof FoodProduct).collect(Collectors.toList()));
        return removedProducts - this.inventory.size();
        
        */
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
    }
}
