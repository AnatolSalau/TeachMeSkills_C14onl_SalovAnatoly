package Lesson10_HomeWork;

class Main {
    public static void main(String[] args) {
        /*
        * 1) Необходимо создать 3 работника и 1 директора.
        * Для каждого сотрудника распечатать полное имя сотрудника и его з/п.
         */
        Worker workerOne = new Worker("Ivan","Ivanov",1,Position.WORKER);
        Worker workerTwo = new Worker("Petr","Petrov",2,Position.WORKER);
        Worker workerThree = new Worker("Vasya","Vasyliev",3,Position.WORKER);

        Director directorOne = new Director("Sidr","Sidorov",4,Position.DIRECTOR);
        Director directorTwo = new Director("Dima","Dmitryevich",5,Position.DIRECTOR,workerOne);

       PrintInformation.printTostring(workerOne,workerTwo,workerThree,directorOne);

        directorOne.addEmployee(workerOne,workerTwo);
        System.out.println(directorOne.getQuantityEmployees());
        directorOne.addEmployee(workerOne,workerTwo);
        System.out.println(directorOne.getQuantityEmployees());

        directorTwo.addEmployee(workerOne,workerTwo,directorOne);

        PrintInformation.printTostring(directorTwo);
     }

}
