/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public abstract class AModule {

    private final Map<String, Consumer<Scanner>> assignmentMap = new LinkedHashMap<>();
    private final String[] names;
    private final int moduleNumber;

    public AModule(final int moduleNumber) {
        this.moduleNumber = moduleNumber;
        this.names = new String[]{"module" + moduleNumber, "mod" + moduleNumber, "m" + moduleNumber, String.valueOf(moduleNumber)};
    }

    public boolean isModule(final String name) {
        return Stream.of(names).anyMatch(predicate -> predicate.equalsIgnoreCase(name));
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
    
    public String[] getNames() {
        return names;
    }

    public abstract void loadModuleTasks();
}
