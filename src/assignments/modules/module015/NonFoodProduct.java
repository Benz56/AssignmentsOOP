/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module015;

import java.util.Arrays;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class NonFoodProduct extends Product {

    // Data field containing the materials used in the NonFoodProduct.
    private final String[] materials;

    /**
     * Constructor taking four arguments. Three for the superclass and one for
     * the material list.
     *
     * @param productNumber is the number of the product.
     * @param productName is the name of the product.
     * @param price is the price of the product.
     * @param materials is the materials used in the product,
     */
    public NonFoodProduct(final int productNumber, final String productName, final double price, final String[] materials) {
        super(productNumber, productName, price);
        this.materials = materials;
    }

    //Simple getter for the material array.
    public String[] getMaterials() {
        return materials;
    }

    /**
     * Overridden from Object class.
     *
     * @return the product name and the materials.
     */
    @Override
    public String toString() {
        return super.getProductName() + " contains: " + Arrays.toString(this.materials);
    }

    /**
     * Overridden from Object class. Checks if the products have the same
     * product number. If they do they are equal.
     *
     * @param obj the Object being compared.
     * @return whether or not this instance is equal to the Object passed to the
     * method.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof NonFoodProduct && super.getProductNumber() == ((NonFoodProduct) obj).getProductNumber();
    }
}
