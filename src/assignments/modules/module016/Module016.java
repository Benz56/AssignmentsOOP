/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module016;

import assignments.modules.AModule;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module016 extends AModule {

    public Module016(int moduleNumber) {
        super(moduleNumber);
    }

    @Override
    public void loadModuleTasks() {
        addAssignment("test", scanner -> {
            // Create a ProductDatabase object.
            final ProductDatabase productDatabase = new ProductDatabase();

            // Add some arbritrary products with differing name length and price.
            productDatabase.addProduct(new NonFoodProduct(2, "TvXX", 1009, new String[]{}));
            productDatabase.addProduct(new NonFoodProduct(6, "TvXXXXXX", 1007, new String[]{}));
            productDatabase.addProduct(new NonFoodProduct(4, "TvXXXX", 1003, new String[]{}));
            productDatabase.addProduct(new NonFoodProduct(9, "TvXXXXXXXXX", 1005, new String[]{}));
            productDatabase.addProduct(new NonFoodProduct(1, "TvX", 1001, new String[]{}));
            productDatabase.addProduct(new NonFoodProduct(8, "TvXXXXXXXX", 1006, new String[]{}));
            productDatabase.addProduct(new NonFoodProduct(3, "TvXXX", 1004, new String[]{}));
            productDatabase.addProduct(new NonFoodProduct(5, "TvXXXXX", 1008, new String[]{}));
            productDatabase.addProduct(new NonFoodProduct(7, "TvXXXXXXX", 1002, new String[]{}));

            // Print out. Foreach is essentially just a normal for loop.
            System.out.println("Print non-sorted/by insertion:");
            productDatabase.getProductList().forEach(product -> System.out.println(product.toString()));

            System.out.println("");
            System.out.println("Print sorted by name length:");
            productDatabase.sortedByNameLength().forEach(product -> System.out.println(product.getProductName()));

            System.out.println("");
            System.out.println("Print sorted by price:");
            productDatabase.sortedByPrice().forEach(product -> System.out.println(product.getPrice()));
        });
    }
}
