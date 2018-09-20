/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module005;

import assignments.modules.AModule;
import assignments.modules.module004.GameOfLife;
import java.util.stream.Stream;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module005 extends AModule {

    public Module005(int moduleNumber) {
        super(moduleNumber);
    }

    @Override
    public void loadModuleTasks() {
        addAssignment("6.2", scanner -> new Module005_6_02(scanner).runAssignment());
        addAssignment("6.3", scanner -> new Module005_6_03(scanner).runAssignment());
        addAssignment("6.8", scanner -> new Module005_6_08(scanner).runAssignment());
        addAssignment("6.22", scanner -> new Module005_6_22(scanner).runAssignment());
        addAssignment("6.25", scanner -> new Module005_6_25(scanner).runAssignment());
        addAssignment("6.28", scanner -> new Module005_6_28(scanner).runAssignment());

        addAssignment("D.2", scanner -> System.out.printf("The sum of the circumferences is %.2f", Stream.of(3, 7).mapToDouble(radius -> Math.PI * Math.pow(radius, 2)).sum()));

        addAssignment("D.5", scanner -> new Module005_D_5(scanner).runAssignment());

        addAssignment("D.7", scanner -> new GameOfLife(scanner).runAssignment());

        addAssignment("D.8", scanner -> new Module005_D_8(scanner).runAssignment());
    }
}
