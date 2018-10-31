/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module016;

import java.util.Comparator;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class ProductNameLengthComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getProductName().length() - o2.getProductName().length();
    }
}
