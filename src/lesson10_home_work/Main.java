package lesson10_home_work;

class Main {
    public static void main(String[] args) {
        /*
        * 1) Необходимо создать 3 работника и 1 директора.
        * Для каждого сотрудника распечатать полное имя сотрудника и его з/п.
         */
        Worker workerOne = new Worker("Ivan","Ivanov",1);
        Worker workerTwo = new Worker("Petr","Petrov",2);
        Worker workerThree = new Worker("Vasya","Vasyliev",3);

        Director directorOne = new Director("Sidr","Sidorov",4);

//       PrintInformation.printTostring(workerOne,workerTwo,workerThree,directorOne);

       /*
       *2) Назначить двух созданных сотрудников под управление директора.
       * Распечатать сведения о директоре (инфо о директоре и об его подчинении).
        */
        directorOne.addOneOrMoreEmployees(workerOne,workerTwo);
  //      PrintInformation.printTostring(directorOne);
        /*
        * 3) Создать нового директора с одним сотрудником (под управлением)
        *  и добавить его под управления существующего директора.
        * 4) Убедиться, что сведения о первом директоре теперь включают сведения о втором,
        *  который так же добавлен к нему (и т.д.).

         */
        Director directorTwo = new Director("Nikolay","Nikolayev",5);
        directorTwo.addOneOrMoreEmployees(workerThree);
        directorOne.addOneOrMoreEmployees(directorTwo);
        PrintInformation.printTostring(directorTwo);
        /*
        * 5) Создать сервис, который определяет есть ли у данного директора в подчинении (прямом или косвенном)
        *  сотрудник с указанным именем (поиск вглубь)
        * */
        Worker workerForSearchHisName = new Worker("Search","Searchevich",10);
        Director directorThree = new Director("Dima", "Dim",3,workerForSearchHisName);
        directorTwo.addOneOrMoreEmployees(directorThree);

        boolean haveName = SearchingInformation.isNameInEmployeesDirector(directorOne, "Tolya");
        System.out.println(haveName);
        //false
        haveName = SearchingInformation.isNameInEmployeesDirector(directorOne, "Search");
        System.out.println(haveName);
        //true
     }

}
