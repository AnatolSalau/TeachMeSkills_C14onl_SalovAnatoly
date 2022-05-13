package Lesson10_HomeWork;

enum Position {
    DIRECTOR(1.5,1000),
    WORKER(1,1000);

    private double coefficient;
    private double baseSalary;

    Position(double coefficient, double baseSalary) {
        this.coefficient = coefficient;
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

}
