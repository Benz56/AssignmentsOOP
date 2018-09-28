/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module008;

import assignments.modules.AModule;
import java.util.Date;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module008 extends AModule {

    public Module008(final int moduleNumber) {
        super(moduleNumber);
    }

    @Override
    public void loadModuleTasks() {
        addAssignment("9.3", scanner -> {
            // Create a new Date Object.
            final Date date = new Date();

            // Declare a new long array and initialize it with the given values in the assignment.
            final long[] elapsedTimes = {10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000, 10_000_000_000L, 100_000_000_000L};

            // Loop the long array using an enhanced for loop.
            for (final long elapsedTime : elapsedTimes) {
                // Set the elapsed time of the Date Object.
                date.setTime(elapsedTime);

                // Print the elapsed time and the string value of the date object.
                System.out.println("With an elapsed time of " + elapsedTime);
                System.out.println("The String value of the date object is: " + date.toString());
            }
        });

        addAssignment("9.8", scanner -> {
            // Fan examples:
            // Creating a Fan object and assigning the values stated in the assignemt.
            final Fan fanFoo = new Fan();
            fanFoo.setSpeed(Fan.FAST);
            fanFoo.setRadius(10);
            fanFoo.setColor("yellow");
            fanFoo.setOn(true);

            // Creating another Fan object and assigning the values stated in the assignemt.
            final Fan fanBar = new Fan();
            fanBar.setSpeed(Fan.MEDIUM);
            // Already radius 5 and color blue as per default.

            // Print their toString values.
            System.out.println("FanFoo >> " + fanFoo.toString());
            System.out.println("FanBar >> " + fanBar.toString());

            // Implementing a random example regarding a, b, and c extras.
            final Fan fanBaz = new Fan(Fan.SLOW, true, 15, "Atomic Pink");
            System.out.println("FanBaz >> " + fanBaz.toString(new Date()));
        });
    }
}
