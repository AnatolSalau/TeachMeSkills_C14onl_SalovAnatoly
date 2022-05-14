package Lesson10_HomeWork;

class SearchingInformation {

    public static String searchAllNames(GetName... abstractEmployeesWithNames) {
        String resultWithAllNames = "";
        for (GetName currentAbstractEmployee : abstractEmployeesWithNames) {
            if (currentAbstractEmployee instanceof GetArrayAbstractEmployees) {
                resultWithAllNames += " " + currentAbstractEmployee.getName();
                GetArrayAbstractEmployees currentAbstractEmployeeWithEmployess =
                        (GetArrayAbstractEmployees) currentAbstractEmployee;
                searchAllNames(currentAbstractEmployeeWithEmployess.getArrayAbstractEmployees());
                continue;
            }
            else {
                resultWithAllNames += " " + currentAbstractEmployee.getName();
                continue;
            }
        }
        return resultWithAllNames;
    }


}
