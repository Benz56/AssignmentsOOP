/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module013;

import assignments.modules.AModule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module013 extends AModule {

    public Module013(int moduleNumber) {
        super(moduleNumber);
    }

    @Override
    public void loadModuleTasks() {
        addAssignment("run", scanner -> {
            final String input = "1,2,red,blue";
            
            final File csvFile = new File("C:\\Users\\bemma\\Desktop\\Uni\\OOP\\twocolors.csv"); // Create the File Object.
            if (!csvFile.exists()) {                                                // If the file doesn't exist, create it.
                try {
                    csvFile.createNewFile();                                        // Create the file. (Throws IOException)
                    
                    final PrintWriter printWriter = new PrintWriter(csvFile);       // Create the PrintWriter Object. (Throws FileNotFoundException; subclass of IOException)
                    printWriter.println(input);                                     // Print/write the String to the File.
                    printWriter.close();                                            // Close the resource.
                } catch (IOException ex) {                                          // Catch the IOException and FileNotFoundException.
                    System.out.println("Something terrible went wrong! Aborting");  // Print error message.
                    return;                                                         // Return i.e. abort the rest.
                }
            }

            final Scanner fileScanner;                                              // Declare a Scanner variable. Declared here to be able to close it later in this scope.
            try {
                fileScanner = new Scanner(csvFile).useDelimiter(",");               // Instantiate a new Scanner Object with the csvFile and set "," as the delimiter.
            } catch (FileNotFoundException e) {                                     // Catch the FileNotFoundException.
                System.out.println("Something terrible went wrong! Aborting");      // Print error message.
                return;                                                             // Return i.e. abort the rest.
            }

            while (fileScanner.hasNext()) {              // While the scanner has more tokens in its input do:
                System.out.println(fileScanner.next());  // Print the next token.
            }

            fileScanner.close();  // Close the scanner.
        });
    }
}
