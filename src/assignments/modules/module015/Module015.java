/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module015;

import assignments.modules.AModule;
import assignments.modules.module015.liang.*;
import java.util.Date;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module015 extends AModule {

    public Module015(int moduleNumber) {
        super(moduleNumber);
    }

    @Override
    public void loadModuleTasks() {
        addAssignment("database", scanner -> {
            // Create a ProductDatabase object.
            final ProductDatabase productDatabase = new ProductDatabase();

            // Try to add an expired FoodProduct.
            try {
                productDatabase.addProduct(new FoodProduct(1, "Old Noodles", 15, new Date(System.currentTimeMillis() - 1), 22)); // Creates an already expired Product.
            } catch (final ExpiredProductAddedException e) {
                System.out.println(e.getMessage());
            }

            // Add a non-expired FoodProduct.
            try {
                productDatabase.addProduct(new FoodProduct(1, "Fresh Noodles", 15, new Date(System.currentTimeMillis() + 1000), 22)); // Creates an already expired Product.
            } catch (final ExpiredProductAddedException ex) {
                System.out.println(ex.getMessage());
            }
        });

        addAssignment("12.2", scanner -> new Module015_12_2(scanner).runAssignment());

        addAssignment("12.3", scanner -> new Module015_12_3(scanner).runAssignment());

        addAssignment("12.5", scanner -> new Module015_12_5(scanner).runAssignment());
    }
}
