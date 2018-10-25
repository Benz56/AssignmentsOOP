/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module014;

import assignments.modules.AModule;
import java.util.Date;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module014 extends AModule {

    public Module014(int moduleNumber) {
        super(moduleNumber);
    }

    @Override
    public void loadModuleTasks() {
        addAssignment("showcase", scanner -> {
            // Create a ProductDatabase object.
            final ProductDatabase productDatabase = new ProductDatabase();

            // Array containing a few products.
            String[] products = {"Noodles", "Chocolate", "Meat", "TV", "Computer", "Phone"};

            // Add three FoodProduct's to our database.
            for (int productId = 1; productId <= 3; productId++) {
                productDatabase.addProduct(new FoodProduct(productId, products[productId - 1], Math.random() * 20, new Date(System.currentTimeMillis() - 1), 22)); // Creates already expired Products.
            }

            // Add three NonFoodProduct's to our database.
            for (int productId = 4; productId <= 6; productId++) {
                productDatabase.addProduct(new NonFoodProduct(productId, products[productId - 1], Math.random() * 1000, new String[]{"Electronics", "Other Components"}));
            }

            // Print all products toString method.
            for (Product product : productDatabase.getProductList()) {
                System.out.println(product.toString());
            }

            // Remove expired products.
            System.out.println("");
            System.out.println("Removed " + productDatabase.removeExpiredFoods() + " expired FoodProducts.");
            System.out.println("");

            // Print all products toString method.
            for (Product product : productDatabase.getProductList()) {
                System.out.println(product.toString());
            }
        });
    }
}
