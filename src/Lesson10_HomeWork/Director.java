package Lesson10_HomeWork;

class Director extends AbstractDirector{

    public Director(String name, String secondName, double workExperience, Position position) {
        super(name, secondName, workExperience, position);
    }

    public Director(String name, String secondName, double workExperience, Position position, AbstractEmployee[] abstractEmployees) {
        super(name, secondName, workExperience, position, abstractEmployees);
    }

}
