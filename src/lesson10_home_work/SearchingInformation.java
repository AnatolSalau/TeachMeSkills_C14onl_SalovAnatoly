package lesson10_home_work;

class SearchingInformation {
/*
* Добавил еще один метод для поиска имени только у директора,
* и переименовал старый метод с  haveNameRecursion на isNameInArrayEmployees */
        public static boolean isNameInArrayEmployees(String name, Employee... employees) {
                boolean haveName = false;
                for (Employee employee : employees) {
                    if (employee instanceof Worker) {
                        if (employee.getName().equals(name)) {
                            haveName = true;
                            break;
                        }
                    }
                    if (employee instanceof Director) {
                        if (employee.getName().equals(name)) {
                            haveName = true;
                            break;
                        }
                        else {
                            Employee[] newEmployees = ((Director) employee).getArrayEmployees();
                            if (isNameInArrayEmployees(name,newEmployees)) {
                                haveName = true;
                                break;
                            }
                        }
                    }
                }
                return haveName;
            }

/*    новый метод согласно замечанию "принимает директора (ну или сотрудника) и имя"
*/
        public static boolean isNameInEmployeesDirector(Director director, String name) {
            boolean haveName = false;
// Проверяем есть ли у директора сотрудники
            if (director.getArrayEmployees() == null) {
                return haveName;
            }
// Перебираем все  имена сотрудников не лезя в глубь
            for (Employee employee: director.getArrayEmployees()) {
                if(employee.getName().equals(name)) {
                    haveName = true;
                    return haveName;
                }
            }
// Проверяем есть ли в подчинение директора если есть используем рекурсию и лезем в каждого директора
            for (Employee employee: director.getArrayEmployees()) {
                if (employee instanceof Director) {
                    return isNameInEmployeesDirector((Director) employee, name);
                }
            }
            return haveName;
        }
}





