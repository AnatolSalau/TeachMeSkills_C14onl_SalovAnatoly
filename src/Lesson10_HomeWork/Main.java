package Lesson10_HomeWork;

import java.util.Arrays;

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

//       PrintInformation.printTostring(workerOne,workerTwo,workerThree,directorOne);

       /*
       *2) Назначить двух созданных сотрудников под управление директора.
       * Распечатать сведения о директоре (инфо о директоре и об его подчинении).
        */
        directorOne.addEmployee(workerOne,workerTwo);
  //      PrintInformation.printTostring(directorOne);
        /*
        * 3) Создать нового директора с одним сотрудником (под управлением)
        *  и добавить его под управления существующего директора.
        * 4) Убедиться, что сведения о первом директоре теперь включают сведения о втором,
        *  который так же добавлен к нему (и т.д.).

         */
        Director directorTwo = new Director("Nikolay","Nikolayev",5,Position.DIRECTOR,workerThree);
        directorOne.addEmployee(directorTwo);
        PrintInformation.printTostring(directorOne);
        /*
        * 5) Создать сервис, который определяет есть ли у данного директора в подчинении (прямом или косвенном)
        *  сотрудник с указанным именем (поиск вглубь)
        * */
        SearchingInformation searchingInformation = new SearchingInformation();
        searchingInformation.searchAllNames(workerOne,directorOne);
        searchingInformation.printAllNames();
     }

}
