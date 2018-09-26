/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module007;

import assignments.modules.AModule;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Module007 extends AModule{

    public Module007(final int moduleNumber) {
        super(moduleNumber);
    }

    @Override
    public void loadModuleTasks() {
        addAssignment("opg1", scanner -> new Module007_1(scanner).runAssignment());
        addAssignment("opg2", scanner -> new Module007_2(scanner).runAssignment());
    }
}
