/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments;

import assignments.modules.AModule;
import assignments.modules.module004.*;
import assignments.modules.module005.Module005;
import assignments.modules.module007.Module007;
import assignments.modules.module008.Module008;
import assignments.modules.module009.Module009;
import assignments.modules.module011.Module011;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class InputListener {

    /**
     * ArrayList storing all modules.
     */
    private final List<AModule> modules = new ArrayList<>();

    /**
     * This methods loads all current modules as well as adds each module to the
     * modules list above.
     */
    void loadModules() {
        Stream.of(new Module004(4), new Module005(5), new Module007(7), new Module008(8), new Module009(9), new Module011(11)).forEach(module -> {
            module.loadModuleTasks();
            modules.add(module);
        });
    }

    /**
     * An infinite loop taking input from the console and runs the given
     * assignment or prints a help message.
     */
    void run() {
        final Scanner scanner = new Scanner(System.in); // Declare and instantiate a new Scanner object taking input from the console.
        // Print a welcome message as well as showcase which modules are available.
        System.out.println("Hello! Please input a module to show the assignments for.");
        System.out.println("Modules: " + getModulesAsString());

        // Start the infinite loop.
        while (true) {
            String input = scanner.next();      // Take an input from the console.
            AModule aModule = getModule(input); // Get the module which name is the input.

            if (aModule != null) {              // Check if the module existed.
                // Help messages including the available assignment in the given modules.
                System.out.println("Module " + aModule.getModuleNumber() + " selected. Choose an assignment:");
                System.out.println("Assignments: " + getModuleAssignmentsAsString(aModule));

                input = scanner.next(); // Take a new input.

                // Check if the input matches any of the assignments in the given module. If it doesn't then try again.
                while (!aModule.getAssignmentMap().keySet().contains(input)) {
                    // Help messages including the available assignment in the given modules.
                    System.out.println("Invalid assignment. Please choose one of the following:");
                    System.out.println(" - " + getModuleAssignmentsAsString(aModule));
                    input = scanner.next(); // Take a new input.
                }

                // Call the given assignment.
                aModule.getAssignmentMap().get(input).accept(scanner);

                // Once the assignment ends print some spacing and the available modules.
                Stream.of("", "", "", "Input another module to show the assignments:", "Modules: " + getModulesAsString()).forEach(s -> System.out.println(s));
            } else {
                // Help messages including the available modules.
                System.out.println("Invalid module. Please choose one of the following:");
                System.out.println(" - " + getModulesAsString());
            }
        }
    }

    /**
     * A method used to get a module based on a String parameter.
     *
     * @param input is the module to be retrieved.
     * @return the module associated with the given input or null if none is
     * found.
     */
    private AModule getModule(final String input) {
        // Find the module which has a name that matches the input. Ignores case.
        return modules.stream().filter(module -> Arrays.asList(module.getNames()).contains(input.toLowerCase())).findFirst().orElse(null);
    }

    /**
     * Get a comma separated String containing all the assignments associated
     * with a given module.
     *
     * @param aModule is the module which assignments are to be "stringified".
     * @return the modules assignments as a comma separated String.
     */
    private String getModuleAssignmentsAsString(AModule aModule) {
        List<String> keyList = new ArrayList<>(aModule.getAssignmentMap().keySet());            // Convert the keySet to an ArrayList.
        StringBuilder stringBuilder = new StringBuilder(keyList.get(0));                        // Instantiate a new Stringbuiler with the first key as the String start.
        keyList.stream().skip(1).forEach(module -> stringBuilder.append(", ").append(module));  // Loop the rest. Append a comma and the assignment name.
        return stringBuilder.toString();                                                        // Return the StringBuiler as a String.
    }

    /**
     * Get a comma separated String containing all loaded modules.
     *
     * @return the modules as a comma separated String.
     */
    private String getModulesAsString() {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(modules.get(0).getModuleNumber()));       // Instantiate a new Stringbuiler with the first module number as the String start.
        modules.stream().skip(1).forEach(module -> stringBuilder.append(", ").append(module.getModuleNumber())); // Loop the rest. Append a comma and the module number.
        return stringBuilder.toString();                                                                         // Return the StringBuiler as a String.
    }
}
