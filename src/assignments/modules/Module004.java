/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules;

import assignments.ScannerUtil;
import assignments.modules.complextasks.GameOfLifeModule004;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module004 extends AModule {

    public Module004(int moduleNumber) {
        super(moduleNumber);
    }

    @Override
    public void loadModuleTasks() {
        addAssignment("7.3", scanner -> {
            System.out.println("Input a string of numbers e.g. 10 5 21 10. End with 0.");
            final Map<Integer, Integer> map = new TreeMap<>(); //Use a TreeMap to store keys in natural order.
            while (scanner.hasNext()) { //While the string still has more numbers
                String number = scanner.next(); //Store the input in a string.
                if (number.equalsIgnoreCase("0")) { //End the loop if the number is 0.
                    break;
                }
                try {
                    final int parsedNumber = Integer.parseInt(number); //Parse the number to an integer. Print error if NAN.
                    //Merge the value. If the does not contain the key then add it with 1 as default.
                    //If it does contain the key, then increment the value by 1.
                    map.merge(parsedNumber, 1, Integer::sum);
                } catch (Exception ignored) {
                    System.out.println("Input: " + number + " is not a number!");
                }
            }
            //Loop the entryset(keys and values) and print their values. The TreeMap will print in the natural order of numbers.
            map.forEach((key, value) -> System.out.println("The number " + key + " occurs " + value + " times."));
        });

        addAssignment("8.2", scanner -> {
            final int size = ScannerUtil.getInteger(scanner, "Please input the integer size of the matrix"); //Set the size of the Integer.
            final double[][] array = new double[size][size];  //Instantiate the array with the given size.
            for (int row = 0; row < size; row++) {      //Loop "size" times.
                int col = 0;                            //Set colum index of the row to 0.
                System.out.println("Please input row " + row);
                while (scanner.hasNext()) {             //Take scanner input.
                    try {
                        //Try setting the position of the array to the double value of the scanner.
                        //Increment col after each iteration.
                        array[row][col++] = scanner.nextDouble();
                    } catch (Exception ignored) {
                        //If the input is not a double the row is decremented to try again and scanner.next to avoid an infinite loop.
                        scanner.next();
                        row--;
                        System.out.println("Input contains invalid input. Please try again!");
                        break;
                    }
                    if (col == size) { //Break the loop if all columns are filled.
                        break;
                    }
                }
            }
            double majorDiagonal = 0; //Instantiate the major diagonal variable.
            for (int value = 0; value < size; value++) { //Loop the major diagonal of the array.
                majorDiagonal += array[value][value];    //Increment the major diagonal value using and augmented addition operator.
            }
            //Print the average by dividing with the size. Cast to double to avoid truncating decimals.
            System.out.println("The average on the major diagonal is " + majorDiagonal / (double) size);
        });

        addAssignment("C.1", scanner -> {
            System.out.println("Printing areas:");
            for (int radius = 1; radius <= 5; radius++) {
                System.out.println(" Radius " + radius + " equals an area of " + String.format("%.2f", Math.PI * Math.pow(radius, 2)));
            }
        });

        addAssignment("C.3", scanner -> {
            System.out.println("Printing temperature differences:");
            final List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
            final List<Double> temperatures = Arrays.asList(21.5, 23.7, 19.6, 22.5, 25.3, 21.7, 18.9);

            for (int today = 1; today < 7; today++) {
                final int yesterday = today - 1;
                System.out.println(" Temparture difference between " + days.get(yesterday) + " and " + days.get(today) + " is " + String.format("%.2f", Math.abs(temperatures.get(today) - temperatures.get(yesterday))));
            }
        });

        addAssignment("C.4", scanner -> {
            // Get an input from the console. If the value isn't between 1-12(inclusive) continue.
            Integer monthNumber;
            do {
                monthNumber = ScannerUtil.getInteger(scanner, "Please input a number between 1 and 12");
            } while (monthNumber < 1 || monthNumber > 12);

            final double[] months = {31, 28.25, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //Instantiate an array with days in each month.
            System.out.println(" There are " + months[monthNumber - 1] + " days in month " + monthNumber);
        });

        addAssignment("C.6", scanner -> {
            System.out.println("Input a string of max 100 different numbers e.g. 10 5 21 5. End with 0.");
            final double[] array = new double[100]; //Instantiate an array with 100 slots.
            int index = 0; //The index to store the value in.
            while (scanner.hasNext()) { //While the scanner has more numbers.
                String number = scanner.next(); //Store the input in a string.
                if (number.equalsIgnoreCase("0")) { //End the loop if the number is 0.
                    break;
                }
                try {
                    final int parsedNumber = Integer.parseInt(number); //Parse the number to an integer. Print error if NAN.
                    array[index++] = parsedNumber; //Set the index position to the value and increment the index.
                } catch (Exception ignored) {
                    System.out.println("Input: " + number + " is not a number!");
                }
            }

            index = 0; //Re-use the index value.
            double largestValue = 0; //Variable to store the largest value for comparison when looping.
            for (int i = 0; i < array.length; i++) { //Loop the array.
                double value = array[i]; //Store the value of index i in the value variable.
                if (value == 0) { //If the value is 0 then end. There are no more values stored.
                    break;
                }
                if (value > largestValue) { //If the value is larger than the currently stored largest values then:
                    largestValue = value;   //Update the largest value.
                    index = i;              //Update the index.
                }
            }
            //Print the result.
            System.out.println("The largest value in the array is " + largestValue + " and has an index of " + index);
        });

        addAssignment("C.7", scanner -> new GameOfLifeModule004(scanner).runTask());
    }
}
