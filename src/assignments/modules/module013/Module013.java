/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module013;

import assignments.ScannerUtil;
import assignments.modules.AModule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        addAssignment("1", scanner -> {
            final String input = "1,2,red,blue";

            final File csvFile;
            try {
                csvFile = getFile();
            } catch (IOException ex) {
                System.out.println("Something terrible went wrong! Aborting");  // Print error message.
                return;                                                         // Return i.e. abort the rest.
            }

            if (csvFile.length() == 0) {                                            // Check if the file is empty.
                try {
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

        addAssignment("2", scanner -> {
            final File csvFile;
            try {
                csvFile = getFile();
            } catch (IOException ex) {
                System.out.println("Something terrible went wrong! Aborting");
                return;
            }

            if (csvFile.length() == 0) {
                System.out.println("The File is empty...");
                return;
            }

            final Scanner csvScanner;
            try {
                csvScanner = new Scanner(csvFile).useDelimiter(",");
            } catch (FileNotFoundException ex) {
                System.out.println("Something terrible went wrong! Aborting");
                return;
            }

            List<String> entries = new ArrayList<>();
            int i = 0;
            while (csvScanner.hasNext()) {
                i++;
                String entry = csvScanner.next();
                entries.add(entry);
                System.out.printf("%d%-3s%s", i, ".", entry);
                System.out.println("");
            }
            csvScanner.close();

            System.out.println("Which entry would you like to delete?");
            int index;
            do {
                index = ScannerUtil.getInteger(scanner, "Please input a number between 1 and " + i + " (both inclusive)");
            } while (index < 1 || index > i);

            entries.remove(index - 1);

            try {
                final PrintWriter printWriter = new PrintWriter(csvFile);
                printWriter.print(String.join(",", entries));
                printWriter.close();
            } catch (IOException ex) {
                System.out.println("Something terrible went wrong! Aborting");
                return;
            }
        });

        addAssignment("3", scanner -> {
            final File csvFile;
            try {
                csvFile = getFile();
            } catch (IOException ex) {
                System.out.println("Something terrible went wrong! Aborting");
                return;
            }

            final Scanner csvScanner;
            try {
                csvScanner = new Scanner(csvFile).useDelimiter(",");
            } catch (FileNotFoundException ex) {
                System.out.println("Something terrible went wrong! Aborting");
                return;
            }

            List<String> entries = new ArrayList<>();
            int i = 0;
            while (csvScanner.hasNext()) {
                i++;
                String entry = csvScanner.next();
                entries.add(entry);
                System.out.printf("%d%-3s%s", i, ".", entry);
                System.out.println("");
            }
            csvScanner.close();

            System.out.println("Where would you like to add your entry?");
            int index;
            do {
                index = ScannerUtil.getInteger(scanner, "Please input a number between 1 and " + i + " (both inclusive)");
            } while (index < 1 || index > i);

            System.out.println("Please input what you would like to add to the CSV file. (Leave out the comma)");
            String input = scanner.next();

            entries.add(index - 1, input);

            try {
                final PrintWriter printWriter = new PrintWriter(csvFile);
                printWriter.print(String.join(",", entries));
                printWriter.close();
            } catch (IOException ex) {
                System.out.println("Something terrible went wrong! Aborting");
            }
        });
    }

    /**
     * Returns the CSV File. If it doesn't exist it is created.
     *
     * @return the CSV File.
     * @throws IOException if the File couldn't be created.
     */
    public File getFile() throws IOException {
        final File csvFile = new File("C:\\Users\\bemma\\Desktop\\Uni\\OOP\\twocolors.csv");  // Create the File Object.
        if (!csvFile.exists()) {                                                              // If the file doesn't exist, create it.
            csvFile.createNewFile();                                                          // Create the file.
        }
        return csvFile;
    }
}
