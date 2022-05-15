package Lesson10_HomeWork;

class SearchingInformation {

        public static boolean haveNameRecursion(String name, AbstractEmployee... abstractEmployees) {
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
                            if (haveNameRecursion(name,newEmployees)) {
                                haveName = true;
                                break;
                            }
                        }
                    }
                }
                return haveName;
            }

/*            public static boolean haveNameIterable(String name, AbstractEmployee... abstractEmployees) {

            }*/


}





