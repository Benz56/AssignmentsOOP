/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class ProductDatabase {

    // Map for storing products referenced by a UUID.
    private final Map<UUID, Product> inventory = new HashMap<>();

    /**
     * @return the values as an ArrayList.
     */
    public List<Product> getProductList() {
        return new ArrayList<>(this.inventory.values());
    }

    /**
     * Adds a product to the database with a random UUID as key. The method does
     * not check if the item was added since we're using a random UUID as the
     * key. The possibilities of duplicates occurring is negligible.
     *
     * @param product is the product to be added.
     */
    public void addProduct(final Product product) {
        this.inventory.put(UUID.randomUUID(), product);
    }

    /**
     * Removes a product from the list.
     *
     * @param number is the productNumber to be removed.
     * @return true if an item was removed; false if it wasn't.
     */
    public boolean removeProductByNumber(final int number) {
        for (final Map.Entry<UUID, Product> entrySet : this.inventory.entrySet()) { // Loop the EntrySets in the Map.
            if (entrySet.getValue().getProductNumber() == number) {                 // Check if the entrySet's value's productNumber is the desired.
                return this.inventory.remove(entrySet.getKey()) != null;            // Remove the product and return true.
            }
        }
        return false;

        /* Fancy implementation. Removes all products with the given number; not just the first.
        int initSize = this.inventory.size();
        this.inventory.entrySet().stream().filter(entrySet -> entrySet.getValue().getProductNumber() == number).map(entrySet -> entrySet.getKey()).collect(Collectors.toSet()).forEach(key -> this.inventory.remove(key));
        return initSize != this.inventory.size();*/
    }

    /**
     * Removes a product from the list.
     *
     * @param product is the product to be removed.
     * @return true if an item was removed; false if it wasn't.
     */
    public boolean removeProduct(final Product product) {
        for (final Map.Entry<UUID, Product> entrySet : this.inventory.entrySet()) {     // Loop the EntrySets in the Map.
            if (entrySet.getValue().getProductNumber() == product.getProductNumber()) { // Check if the entrySet's value's productNumber is the desired.
                return this.inventory.remove(entrySet.getKey()) != null;                // Remove the product and return true.
            }
        }
        return false;

        /* Fancy implementation. Removes all products with the given number; not just the first.
        int initSize = this.inventory.size();
        this.inventory.entrySet().stream().filter(entrySet -> entrySet.getValue().getProductNumber() == product.getProductNumber()).map(entrySet -> entrySet.getKey()).collect(Collectors.toSet()).forEach(key -> this.inventory.remove(key));
        return initSize != this.inventory.size();*/
    }

    /**
     * Calculates the total value of all the products in the list.
     *
     * @return the total value of all products in the map.
     */
    public double getInventoryValuation() {
        double inventoryValuation = 0;
        for (final Product product : this.inventory.values()) {
            inventoryValuation += product.getPrice();
        }
        return inventoryValuation;

        /* Fancy implementation
        return this.inventory.values().stream().mapToDouble(Product::getPrice).sum();*/
    }

    /**
     * Removes all expired products in the current inventory.
     *
     * @return The number of products removed.
     */
    public int removeExpiredFoods() {
        int removedProducts = 0;  // To keep track of how Products are removed.

        for (final Map.Entry<UUID, Product> entrySet : new HashMap<>(this.inventory).entrySet()) {
            // try-catch. Success if the product has overriden the isExpired() method in Product.
            try {
                // Remove the product if it is expired.
                if (entrySet.getValue().isExpired()) {
                    removedProducts++;
                    this.inventory.remove(entrySet.getKey());
                }
            } catch (final UnsupportedOperationException ignored) {
                //Not a FoodProduct.
            }
        }

        return removedProducts; // Return the number of items removed.

        /* Fancy implementation
        int initProductCount = this.inventory.size();
        this.inventory.entrySet().stream().filter(entrySet -> entrySet.getValue() instanceof FoodProduct && entrySet.getValue().isExpired()).map(entrySet -> entrySet.getKey()).collect(Collectors.toSet()).forEach(key -> this.inventory.remove(key));
        return initProductCount - this.inventory.size();*/
    }

    public List<Product> sortedByNameLength() {
        final List<Product> sorted = new ArrayList<>(this.inventory.values()); // Create an ArrayList from the values in the HashMap.
        Collections.sort(sorted, new ProductNameLengthComparator());           // Sort it.
        return sorted;                                                         // Return it.

        /* Fancy implementation. Doesn't even need the ProductNameLengthComparator class to be created!
        return this.inventory.values().stream().sorted((o1, o2) -> o1.getProductName().length() - o2.getProductName().length()).collect(Collectors.toList());*/
    }

    public List<Product> sortedByPrice() {
        final List<Product> sorted = new ArrayList<>(this.inventory.values()); // Create an ArrayList from the values in the HashMap.
        Collections.sort(sorted);                                              // Sort it.
        return sorted;                                                         // Return it.

        /* Fancy implementation. Doesn't even need the ProductNameLengthComparator class to be created!
        return this.inventory.values().stream().sorted().collect(Collectors.toList());*/
    }
}
