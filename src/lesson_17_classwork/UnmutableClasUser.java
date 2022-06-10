package lesson_17_classwork;
//Unmutable class
final class UnmutableClasUser {
    private final String name;
    private final int age;

    public UnmutableClasUser(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        UnmutableClasUser user = new UnmutableClasUser("Anatoly", 32);
        UnmutableRecordUser recordUser = new UnmutableRecordUser("Anatoly", 32);

    }
    //We can create unmutable classes through record
    record UnmutableRecordUser (String name, int age) {}
}
