/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module015.liang;

import assignments.modules.AbstractComplexTask;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module015_12_5 extends AbstractComplexTask {

    public Module015_12_5(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runAssignment() {
        // Create a valid triangle using the no-args constructor.
        final Triangle validTriangle = new Triangle();

        // Create an invalid triangle and catch the exception.
        try {
            final Triangle invalidTriangle = new Triangle(1, 10, 1);
        } catch (final IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
