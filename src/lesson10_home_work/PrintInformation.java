package lesson10_home_work;

class PrintInformation {

    static void printTostring (Employee... employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        System.out.println();
    }

}
