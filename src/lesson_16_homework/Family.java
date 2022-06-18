package lesson_16_homework;



import java.util.List;
import java.util.Objects;

class Family {
    private String surName;
    private String address;
    private double averageSalary;
    private List<Child> children;

    public Family(String surName, String address, double averageSalary, List<Child> children) {
        this.surName = surName;
        this.address = address;
        this.averageSalary = averageSalary;
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Double.compare(family.averageSalary, averageSalary) == 0 && Objects.equals(surName, family.surName) && Objects.equals(address, family.address) && Objects.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surName, address, averageSalary, children);
    }

    @Override
    public String toString() {
        return "Family{" +
                "surName='" + surName + '\'' +
                ", address='" + address + '\'' +
                ", averageSalary=" + averageSalary +
                ", children=" + children +
                '}';
    }

    public String getSurName() {
        return surName;
    }

    public String getAddress() {
        return address;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public List<Child> getChildren() {
        return children;
    }
}
