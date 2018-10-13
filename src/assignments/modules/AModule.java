/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public abstract class AModule {

    private final Map<String, Consumer<Scanner>> assignmentMap = new LinkedHashMap<>();
    private final int moduleNumber;
    private final String name;

    public AModule(final int moduleNumber) {
        this.moduleNumber = moduleNumber;
        this.name = String.valueOf(moduleNumber);
    }

    public boolean isModule(final String name) {
        return this.name.equalsIgnoreCase(name);
    }

    public Consumer<Scanner> addAssignment(final String name, final Consumer<Scanner> assignment) {
        return assignmentMap.put(name, assignment);
    }

    public Map<String, Consumer<Scanner>> getAssignmentMap() {
        return assignmentMap;
    }

    public int getModuleNumber() {
        return moduleNumber;
    }

    public String getName() {
        return name;
    }

    public abstract void loadModuleTasks();
}
