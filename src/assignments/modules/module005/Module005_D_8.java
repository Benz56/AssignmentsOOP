/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module005;

import assignments.modules.AbstractComplexTask;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module005_D_8 extends AbstractComplexTask {

    private static final int[][] SUDOKU_GRID = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    public Module005_D_8(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runAssignment() {
        System.out.println("The current grid is solved " + (gridIsValid() ? "correctly." : "incorrectly."));
    }

    /**
     * Loops all positions in the grid and cross checks the value.
     *
     * @return whether or not the grid is correctly solved.
     */
    private boolean gridIsValid() {
        for (int row = 0; row < SUDOKU_GRID.length; row++) {
            for (int col = 0; col < SUDOKU_GRID.length; col++) {
                int value = SUDOKU_GRID[row][col];
                if (!crossCheck(row, col, value)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This metod will check the current row and column. The row and column is
     * checked for occurences of the value passed. If either of the two has more
     * than one occurence of the value the grid is invalid.
     *
     * @param row is the row being checked.
     * @param col is the column being checked.
     * @param value is the value being cross checked for.
     * @return whether or not the value occured more than once in either the row
     * or the column.
     */
    private boolean crossCheck(int row, int col, int value) {
        int horizontalCount = 0;
        for (int gridValue : SUDOKU_GRID[row]) {
            horizontalCount += gridValue == value ? 1 : 0;
        }

        int verticalCount = 0;
        for (int[] gridRow : SUDOKU_GRID) {
            verticalCount = gridRow[col] == value ? 1 : 0;
        }

        return horizontalCount < 2 && verticalCount < 2;
    }
}
