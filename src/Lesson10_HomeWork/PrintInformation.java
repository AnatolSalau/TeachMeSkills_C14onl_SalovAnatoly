package Lesson10_HomeWork;

class PrintInformation {

    static void printTostring (AbstractEmployee... abstractEmployees) {
        for (AbstractEmployee abstractEmployee:abstractEmployees) {
            System.out.println(abstractEmployee.toString());
        }
        System.out.println();
    }

}
