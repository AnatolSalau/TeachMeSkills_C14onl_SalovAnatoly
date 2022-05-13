package Lesson10_HomeWork;

import java.util.Arrays;

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
                            AbstractEmployee[] abstractEmployees) {
        super(name, secondName, workExperience, position);
        this.abstractEmployees = abstractEmployees;
        this.quantityEmployees = this.abstractEmployees.length;
    }

    @Override
    public void addEmployee(AbstractEmployee... abstractEmployees) {

        AbstractEmployee[] newAbstractEmployee;
        if (this.abstractEmployees == null) {
            newAbstractEmployee = new AbstractEmployee[ abstractEmployees.length];
        }
        else {
            newAbstractEmployee = new AbstractEmployee[this.abstractEmployees.length + abstractEmployees.length];
            System.arraycopy(this.abstractEmployees,
                    0,newAbstractEmployee,
                    0, this.abstractEmployees.length);

            System.arraycopy(abstractEmployees,
                    0,newAbstractEmployee,
                    this.abstractEmployees.length+1, abstractEmployees.length);
        }
        this.abstractEmployees = newAbstractEmployee;
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
