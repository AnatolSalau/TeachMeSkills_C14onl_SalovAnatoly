/*
* убрал все заглавные буквы в названиях пакетов*/
package lesson10_home_work;

import java.util.Arrays;
import java.lang.System;

/*
* Убрал лишний уровень абстракции, оставил только один абстрактный класс Employee
* Abstact Director стал сразу реализацией Director*/
class Director extends Employee implements AddingEmployee{
    private Employee[] arrayEmployees;
    private int quantityEmployees;
    private final int moneyForOneEmployee = 100;

/*
* Убрал Position в параметрах конструктора, теперь директор создается только директором,
*  а рабочий только рабочим*/
    public Director(String name, String secondName, double workExperience) {
        super(name, secondName, workExperience, Position.DIRECTOR);
        this.arrayEmployees = null;
        this.quantityEmployees = 0;
    }

    public Director(String name, String secondName, double workExperience,
                    Employee... arrayEmployees) {
        super(name, secondName, workExperience, Position.DIRECTOR);
        this.arrayEmployees = arrayEmployees;
        this.quantityEmployees = this.arrayEmployees.length;
    }

/*
* Изменил название метода с addEmployee на addOneOrMoreEmployees
* */
    @Override
    public void addOneOrMoreEmployees(Employee... employees) {
        if (this.arrayEmployees == null) {
            this.arrayEmployees = employees;
            this.quantityEmployees = this.arrayEmployees.length;
/*            this.salary = countingSalary();
              убрал вызов метода подсчета зп в методе добавления сотрудника
* */
        }
        else {
            Employee[] newEmployee = new Employee[this.arrayEmployees.length + employees.length];
            System.arraycopy(this.arrayEmployees,0, newEmployee,0,this.arrayEmployees.length);
            System.arraycopy(employees,0, newEmployee,this.arrayEmployees.length, employees.length);
            this.arrayEmployees = newEmployee;
            this.quantityEmployees = this.arrayEmployees.length;
/*            this.salary = countingSalary();
              убрал вызов метода подсчета зп в методе добавления сотрудника
* */
        }

    }

    /* Извините, тут немогу понять(((
    "убери if для вызова метода предка - ты его в любом случае вызывешь"

    Идея была такая чтобы считать зарплату по разному:
    Случай IF: У директора нет сотрудников
    Случай ELSE: У директора есть сотрудники
    Согласно заданию: "Для директора переопределить метод расчета з/п,
    в котором предусмотреть влияние количества сотрудников"
    * */
    @Override
    public double countingSalary() {
        if (arrayEmployees == null) {
/*            Случай IF: У директора нет сотрудников*/
            return super.countingSalary();

        }
        else {
/*            Случай ELSE: У директора есть сотрудники*/
            return super.countingSalary() + arrayEmployees.length*moneyForOneEmployee;
        }

    }

    @Override
    public String toString() {
        return "\nDirector{\n" +
                "His Employees:\n" + Arrays.toString(arrayEmployees) +
                "\nquantityEmployees=" + quantityEmployees +
                ", moneyForOneEmployee=" + moneyForOneEmployee +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", workExperience=" + workExperience +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }

    public Employee[] getArrayEmployees() {
        return arrayEmployees;
    }

    public int getQuantityEmployees() {
        return quantityEmployees;
    }

    public int getMoneyForOneEmployee() {
        return moneyForOneEmployee;
    }
}
