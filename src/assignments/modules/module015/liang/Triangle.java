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
public class Triangle {

    public final double side1, side2, side3;

    public Triangle() {
        this.side1 = this.side2 = this.side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1) {
            throw new IllegalTriangleException();
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        final double semiPerimiter = getPerimeter() / 2.0;
        return Math.sqrt(semiPerimiter * (semiPerimiter - this.side1) * (semiPerimiter - this.side2) * (semiPerimiter - this.side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = 2 " + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3;
    }
}
