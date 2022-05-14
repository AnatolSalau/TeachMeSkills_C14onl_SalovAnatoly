package Lesson10_HomeWork;

import java.util.Arrays;
import java.lang.System;

abstract class AbstractDirector extends AbstractEmployee implements AddingEmployee,GetArrayAbstractEmployees{
    AbstractEmployee[] arrayAbstractEmployees;
    int quantityEmployees;
    final int moneyForOneEmployee = 100;

    public AbstractDirector(String name, String secondName, double workExperience, Position position) {
        super(name, secondName, workExperience, position);
        this.arrayAbstractEmployees = null;
        this.quantityEmployees = 0;
    }

    public AbstractDirector(String name, String secondName, double workExperience, Position position,
                            AbstractEmployee... arrayAbstractEmployees) {
        super(name, secondName, workExperience, position);
        this.arrayAbstractEmployees = arrayAbstractEmployees;
        this.quantityEmployees = this.arrayAbstractEmployees.length;
    }

    @Override
    public void addEmployee(AbstractEmployee... abstractEmployees) {
        if (this.arrayAbstractEmployees == null) {
            this.arrayAbstractEmployees = abstractEmployees;
            this.quantityEmployees = this.arrayAbstractEmployees.length;
            this.salary = countingSalary();
        }
        else {
            AbstractEmployee[] newAbstractEmployee = new AbstractEmployee[this.arrayAbstractEmployees.length + abstractEmployees.length];
            System.arraycopy(this.arrayAbstractEmployees,0,newAbstractEmployee,0,this.arrayAbstractEmployees.length);
            System.arraycopy(abstractEmployees,0,newAbstractEmployee,this.arrayAbstractEmployees.length,abstractEmployees.length);
            this.arrayAbstractEmployees = newAbstractEmployee;
            this.quantityEmployees = this.arrayAbstractEmployees.length;
            this.salary = countingSalary();
        }

    }

    @Override
    public double countingSalary() {
        if (arrayAbstractEmployees == null) {
            return super.countingSalary();
        }
        else {
            return super.countingSalary() + arrayAbstractEmployees.length*moneyForOneEmployee;
        }

    }

    @Override
    public String toString() {
        return "\nDirector{\n" +
                "His Employees:\n" + Arrays.toString(arrayAbstractEmployees) +
                "\nquantityEmployees=" + quantityEmployees +
                ", moneyForOneEmployee=" + moneyForOneEmployee +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", workExperience=" + workExperience +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }

    public AbstractEmployee[] getArrayAbstractEmployees() {
        return arrayAbstractEmployees;
    }

    public int getQuantityEmployees() {
        return quantityEmployees;
    }

    public int getMoneyForOneEmployee() {
        return moneyForOneEmployee;
    }
}
