/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments;

import assignments.modules.AModule;
import assignments.modules.module004.Module004;
import assignments.modules.module005.Module005;
import assignments.modules.module007.Module007;
import assignments.modules.module008.Module008;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Assignments {

    private List<AModule> modules = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Assignments assignments = new Assignments();
        assignments.loadModules();
        assignments.run();
    }

    private void run() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Please input a module to show the assignments for.");
        System.out.println("Modules: " + moduleValues());
        while (true) {
            String input = scanner.next();
            AModule aModule = isModule(input);
            if (aModule != null) {
                System.out.println("Module " + aModule.getModuleNumber() + " selected. Choose an assignment:");
                System.out.println("Assignments: " + moduleAssignments(aModule));
                input = scanner.next();
                while (!aModule.getAssignmentMap().keySet().contains(input)) {
                    System.out.println("Invalid assignment. Please choose one of the following:");
                    System.out.println(" - " + moduleAssignments(aModule));
                    input = scanner.next();
                }
                aModule.getAssignmentMap().get(input).accept(scanner);
                Stream.of("", "", "", "Input another module to show the assignments:", "Modules: " + moduleValues()).forEach(s -> System.out.println(s));
            } else {
                System.out.println("Invalid module. Please choose one of the following:");
                System.out.println(" - " + moduleValues());
            }
        }
    }

    private void loadModules() {
        modules.addAll(Arrays.asList(
                new Module004(4),
                new Module005(5),
                new Module007(7),
                new Module008(8)
        ));
        modules.forEach(module -> module.loadModuleTasks());
    }

    private AModule isModule(final String input) {
        return modules.stream().filter(module -> Arrays.asList(module.getNames()).contains(input.toLowerCase())).findFirst().orElse(null);
    }

    private String moduleAssignments(AModule aModule) {
        List<String> keyList = new ArrayList<>(aModule.getAssignmentMap().keySet());
        StringBuilder stringBuilder = new StringBuilder(keyList.get(0));
        for (int i = 1; i < keyList.size(); i++) {
            stringBuilder.append(", ").append(keyList.get(i));
        }
        return stringBuilder.toString();
    }

    private String moduleValues() {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(modules.get(0).getModuleNumber()));
        for (int i = 1; i < modules.size(); i++) {
            stringBuilder.append(", ").append(modules.get(i).getModuleNumber());
        }
        return stringBuilder.toString();
    }
}
