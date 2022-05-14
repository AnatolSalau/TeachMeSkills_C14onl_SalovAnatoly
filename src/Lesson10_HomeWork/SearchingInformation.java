package Lesson10_HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

class SearchingInformation {
    ArrayList<String> allNames = new ArrayList<>();


    public void searchAllNames(GetName... employeesWithNames) {
        for (GetName employeeWithName : employeesWithNames) {
            recurionSearchAllNames(employeeWithName);

        }
    }

    private void recurionSearchAllNames(GetName employeeWithName) {
        if (employeeWithName instanceof GetArrayAbstractEmployees) {
                allNames.add(employeeWithName.getName());
                ((GetArrayAbstractEmployees) employeeWithName).getArrayAbstractEmployees();
        }
        else{
            allNames.add(employeeWithName.getName());
        }

    }

    public void printAllNames() {
        System.out.println(Arrays.toString(allNames.toArray()));
    }
    public ArrayList<String> getAllNames() {
        return allNames;
    }
}



