package lesson_16_classworks_streams;

import java.util.ArrayList;
import java.util.List;

class Family {
    private String sname;
    private int age;
    private List<Member> members;

    public Family(String sname, int age, List<Member> members) {
        this.sname = sname;
        this.age = age;
        this.members = members;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
