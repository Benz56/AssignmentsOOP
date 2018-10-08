/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module009;

import assignments.modules.AModule;
import java.util.Date;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module009 extends AModule {

    public Module009(int moduleNumber) {
        super(moduleNumber);
    }

    @Override
    public void loadModuleTasks() {
        addAssignment("showcase", scanner -> {
            // Create a ProductDatabase object.
            final ProductDatabase productDatabase = new ProductDatabase();

            // Create one of each of the Product sub classes. (31536000000L is 1 year in milliseconds)
            final FoodProduct foodProduct = new FoodProduct(1, "Noodles", 7.5, new Date(System.currentTimeMillis() + 31_536_000_000L), 22);
            final NonFoodProduct nonFoodProduct = new NonFoodProduct(2, "TV", 12000, new String[]{"Frame", "Screen", "Power cord", "Whatever else"});
           
            System.out.println(""); // Spacing.

            //Print their overridden toString methods.
            System.out.println("Printing toString methods:");
            System.out.println(foodProduct);
            System.out.println(nonFoodProduct);

            System.out.println(""); // Spacing.

            //Add both items to the database and print a success message if added correctly.
            if (productDatabase.addProductByNumber(foodProduct)) {
                System.out.println(foodProduct.getProductName() + " was succesfully added to the database!");
            }
            if (productDatabase.addProductByNumber(nonFoodProduct)) {
                System.out.println(nonFoodProduct.getProductName() + " was succesfully added to the database!");
            }

            System.out.println(""); // Spacing.

            // Print the product list by getting the list from the databse and looping it using an enhanced for loop.
            System.out.println("Product List:");
            for (Product product : productDatabase.getProductList()) {
                System.out.println(product.getProductNumber() + ". " + product.getProductName());
            }

            System.out.println(""); // Spacing.

            // Print the total value of all products in the database.
            System.out.println("Inventory valuation: " + productDatabase.getInventoryValuation());
        });
    }
}
