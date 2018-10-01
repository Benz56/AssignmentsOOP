/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class ProductDatabase {

    // Map for storing products referenced by their product number.
    private final Map<Integer, Product> inventory = new HashMap<>();

    /**
     * A method used to return all the values in the map as a list.
     *
     * @return all the mapped values as a list.
     */
    public List<Product> getProductList() {
        return new ArrayList<>(this.inventory.values());
    }

    /**
     * Removes a product from the database.
     *
     * @param number is the key/productNumber to be removed.
     * @return whether or not an item was removed.
     */
    public boolean removeProductByNumber(final int number) {
        // If the map contains a product at the given key remove() will return the Product. If it isn't null something was removed.
        return this.inventory.remove(number) != null;
    }

    /**
     * Adds a product to the database.
     *
     * @param product is the product to be added.
     * @return whether or not it was possible to add an item with the given
     * product number.
     */
    public boolean addProductByNumber(final Product product) {
        // If the map did not already contain the number puIfAbsent returns null. If it returns null a product was added.
        return this.inventory.putIfAbsent(product.getProductNumber(), product) == null;
    }

    /**
     * Calculates the total value of all the products in the map.
     *
     * @return the total value of all products in the map.
     */
    public double getInventoryValuation() {
        // Using fancy streams to sum all of the currently stored products getPrice methods.
        return inventory.values().stream().mapToDouble(Product::getPrice).sum();
    }
}
