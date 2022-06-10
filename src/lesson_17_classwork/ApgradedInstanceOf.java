package lesson_17_classwork;

public class ApgradedInstanceOf {
    public static void main(String[] args) {
        Animal dog = new Dog("Dog", 5);
        //We can create variable in instanceof
        if (dog instanceof Dog castedDog ) {
            System.out.println(castedDog.type);
        }
    }
}
