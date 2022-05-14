package Lesson10_HomeWork;

abstract class AbstractEmployee implements CountingSalary, GettingNamePosition {
    String name;
    String secondName;
    double workExperience;
    Position position;
    double salary;

    public AbstractEmployee(String name, String secondName, double workExperience, Position position) {
        this.name = name;
        this.secondName = secondName;
        this.workExperience = workExperience;
        this.position = position;
        this.salary = countingSalary();
    }

    @Override
    public double countingSalary() {
        return this.position.getBaseSalary() * this.position.getCoefficient()
                * this.workExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", workExperience=" + workExperience +
                ", position=" + position +
                ", salary=" + salary +
                "}\n";
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public double getWorkExperience() {
        return workExperience;
    }

    public Position getPosition() {
        return position;
    }
}
