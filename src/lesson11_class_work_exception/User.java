package lesson11_class_work_exception;

class User {
    public String name;
    public int age;

    public User(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public User(String testUser) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
