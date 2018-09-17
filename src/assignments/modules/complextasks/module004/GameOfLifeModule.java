/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.complextasks.module004;

import assignments.modules.complextasks.AbstractComplexTask;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameOfLifeModule extends AbstractComplexTask {

    private final static char CELL = 'O';     //The char represeting a live cell.
    private final static char EMPTY = '-';    //The char representing a dead cell.
    private final static long INTERVAL = 350; //The interval in miliseconds between each iteration.
    private int[][] world = { //The default world map.
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final int HEIGHT = world.length;   //The height of the world/number of rows.
    private final int WIDTH = world[0].length; //The width of the world/number of colums.

    public GameOfLifeModule(final Scanner scanner) {
        super(scanner);
    }

    /**
     * Start the Game of Life loop.
     */
    @Override
    public void runTask() {
        while (true) {
            try {
                Thread.sleep(INTERVAL); //Sleep for INTERVAL miliseconds.
            } catch (InterruptedException ex) {
                Logger.getLogger(GameOfLifeModule.class.getName()).log(Level.SEVERE, null, ex);
            }
            calculateIteration(); //Calculate the new iteration.
            printWorld();         //Print the newly generated world.
        }
    }

    private void printWorld() {
        //Loop 2D array printing the character associated with either a dead or a live cell.
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[0].length; col++) {
                System.out.print(world[row][col] == 0 ? EMPTY : CELL);
            }
            System.out.println("");
        }
        //Print a few lines of spacing.
        for (int i = 0; i < 3; i++) {
            System.out.println("");
        }
    }

    /**
     * Calculates the next iteration based on the rules of the game.
     */
    private void calculateIteration() {
        final int[][] copy = getWorldCopy();                     //Get a copy of the current world.
        for (int row = 0; row < world.length; row++) {           //Loop the current world.
            for (int col = 0; col < world[0].length; col++) {
                boolean hasCell = world[row][col] == 1;          //Check if the position has a cell.
                final int neighbours = calculateNeighbours(row, col); //Calculate the number of neighbours this cell has.
                if (hasCell) {
                    if (neighbours < 2) { //1. Any live cell with fewer than two live neighbors dies, as if by under population.
                        hasCell = false;
                    } else if (neighbours > 3) { //3. Any live cell with more than three live neighbors dies, as if by overpopulation.
                        hasCell = false;
                    } // else 2. Any live cell with two or three live neighbors lives on to the next generation.
                } else {
                    if (neighbours == 3) { //4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                        hasCell = true;
                    }
                }
                copy[row][col] = hasCell ? 1 : 0; //Update the cell in the copy of the world.
            }
        }
        world = copy; //Update the world
    }

    /**
     * Check the amount of neighbours around a position in the world.
     *
     * @param row is the cell's row.
     * @param col is the cell's column.
     * @return the amount of neighbours.
     */
    private int calculateNeighbours(final int row, final int col) {
        int neighbours = 0;
        //Loop offsets from -1 to +1 and check if the position has a live cell or a dead cell.
        for (int offsetHeight = -1; offsetHeight <= 1; offsetHeight++) {
            for (int offsetWidth = -1; offsetWidth <= 1; offsetWidth++) {
                //  The cell being checked.                  Height is outside of the world.                          Width is outside of the world.
                if (offsetHeight == 0 && offsetWidth == 0 || row + offsetHeight < 0 || row + offsetHeight >= HEIGHT || col + offsetWidth < 0 || col + offsetWidth >= WIDTH) {
                    continue;
                }
                neighbours += world[row + offsetHeight][col + offsetWidth] == 0 ? 0 : 1; //Check if the position has a cell. Increment if it has.
            }
        }
        return neighbours;
    }

    /**
     * Copy the current world map.
     *
     * @return a copy of the world map.
     */
    private int[][] getWorldCopy() {
        final int[][] copy = new int[world.length][world[0].length];
        for (int row = 0; row < world.length; row++) {
            System.arraycopy(world[row], 0, copy[row], 0, world[row].length);
        }
        return copy;
    }
}
