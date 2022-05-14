package Lesson10_HomeWork;

abstract class AbstractWorker extends AbstractEmployee{

    public AbstractWorker(String name, String secondName, double workExperience, Position position) {
        super(name, secondName, workExperience, position);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", workExperience=" + workExperience +
                ", position=" + position +
                ", salary=" + salary +
                "}";
    }
}
