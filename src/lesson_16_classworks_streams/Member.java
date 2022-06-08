package lesson_16_classworks_streams;

class Member {
    private String name;
    private int age;
    private SEX sex;
    private boolean isAdult;

    enum SEX {
        MAN, WOMAN
    }

    public Member(String name, int age, SEX sex, boolean isAdult) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.isAdult = isAdult;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", isAdult=" + isAdult +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public SEX getSex() {
        return sex;
    }

    public boolean isAdult() {
        return isAdult;
    }
}
