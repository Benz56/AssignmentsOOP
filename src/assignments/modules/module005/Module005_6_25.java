/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module005;

import assignments.ScannerUtil;
import assignments.modules.AbstractComplexTask;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module005_6_25 extends AbstractComplexTask {

    public Module005_6_25(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runAssignment() {
        long millis = ScannerUtil.getLong(scanner, "Please input a millisecond value: ");               // Take a long input.
        System.out.println(millis + " converted to hours:minuts:seconds is " + converMillis(millis));   // Print the converted millis.
    }

    public String converMillis(long millis) {
        int hours, minutes, seconds;                    // Declare variables.
        seconds = (int) (millis / 1000) % 60;           // Convert millis to seconds and get the remainder of the number divided by 60. (60 seconds to a minute)
        minutes = (int) ((millis / (1000 * 60)) % 60);  // Convert millis to minutes and get the remainder of the number divided by 60. (60 minutes to an hour)
        hours = (int) (millis / (1000 * 60 * 60));      // Convert millis to hours.
        return hours + ":" + minutes + ":" + seconds;   // Return the colon separated values as a String.
    }
}
