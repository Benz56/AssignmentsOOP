/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules;

import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public abstract class AbstractComplexTask {

    protected final Scanner scanner;
    
    public AbstractComplexTask(final Scanner scanner) {
        this.scanner = scanner;
    }
    
    public abstract void runAssignment();
}
