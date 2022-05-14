package Lesson10_HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

class SearchingInformation {

public boolean searchName(String name, AbstractEmployee... abstractEmployees) {
        boolean haveName = false;
        for (AbstractEmployee abstractEmployee : abstractEmployees) {
            if (abstractEmployee instanceof AbstractWorker) {
                if (abstractEmployee.getName().equals(name)) {
                    haveName = true;
                    break;
                }
            }
            if (abstractEmployee instanceof  AbstractDirector) {
                if (abstractEmployee.getName().equals(name)) {
                    haveName = true;
                    break;
                }
                else {
                    AbstractEmployee[] newEmployees = ((AbstractDirector) abstractEmployee).getArrayAbstractEmployees();
                    if (searchName(name,newEmployees)) {
                        haveName = true;
                        break;
                    }
                }
            }
        }
        return haveName;
    }
}



