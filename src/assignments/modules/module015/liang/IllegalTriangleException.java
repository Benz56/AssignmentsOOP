/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module015.liang;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class IllegalTriangleException extends Exception {

    public IllegalTriangleException() {
        super("Illegal Triangle. In a triangle, the sum of any two sides is greater than the other side!");
    }
}
