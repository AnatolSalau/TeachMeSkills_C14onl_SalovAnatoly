package Lesson10_HomeWork;

import java.util.Arrays;
import java.lang.System;

abstract class AbstractDirector extends AbstractEmployee implements AddingEmployee{
    AbstractEmployee[] abstractEmployees;
    int quantityEmployees;
    final int moneyForOneEmployee = 100;

    public AbstractDirector(String name, String secondName, double workExperience, Position position) {
        super(name, secondName, workExperience, position);
        this.abstractEmployees = null;
        this.quantityEmployees = 0;
    }

    public AbstractDirector(String name, String secondName, double workExperience, Position position,
                            AbstractEmployee... abstractEmployees) {
        super(name, secondName, workExperience, position);
        this.abstractEmployees = abstractEmployees;
        this.quantityEmployees = this.abstractEmployees.length;
    }

    @Override
    public void addEmployee(AbstractEmployee... abstractEmployees) {
        if (this.abstractEmployees == null) {
            this.abstractEmployees = abstractEmployees;
            this.quantityEmployees = this.abstractEmployees.length;
            this.salary = countingSalary();
            System.out.println("if (this.abstractEmployees == null) WORK IF");

        }
        else {
            System.out.println("if (this.abstractEmployees != null) WORK ELSE");

            AbstractEmployee[] newAbstractEmployee = new AbstractEmployee[this.abstractEmployees.length + abstractEmployees.length];
            System.arraycopy(this.abstractEmployees,0,newAbstractEmployee,0,this.abstractEmployees.length);
            System.out.println(Arrays.toString(newAbstractEmployee));
            System.arraycopy(abstractEmployees,0,newAbstractEmployee,this.abstractEmployees.length,abstractEmployees.length);
            System.out.println(Arrays.toString(newAbstractEmployee));
            this.abstractEmployees = newAbstractEmployee;
            this.quantityEmployees = this.abstractEmployees.length;
            this.salary = countingSalary();
        }

    }

    @Override
    public double countingSalary() {
        if (abstractEmployees == null) {
            return super.countingSalary();
        }
        else {
            return super.countingSalary() + abstractEmployees.length*moneyForOneEmployee;
        }

    }

    @Override
    public String toString() {
        return "AbstractDirector{" +
                "abstractEmployees=" + Arrays.toString(abstractEmployees) +
                ", quantityEmployees=" + quantityEmployees +
                ", moneyForOneEmployee=" + moneyForOneEmployee +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", workExperience=" + workExperience +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }

    public AbstractEmployee[] getAbstractEmployees() {
        return abstractEmployees;
    }

    public int getQuantityEmployees() {
        return quantityEmployees;
    }

    public int getMoneyForOneEmployee() {
        return moneyForOneEmployee;
    }
}
