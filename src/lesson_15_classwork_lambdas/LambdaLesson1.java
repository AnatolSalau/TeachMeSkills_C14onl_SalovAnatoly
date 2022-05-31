package lesson_15_classwork_lambdas;

class LambdaLesson1 {
    public static void main(String[] args) {
        //Функциональный интерфейс который не принимает
        User user1 = new User("Anatoly", 32);
        User user2 = new User("Vika", 31);
        MyFuncInterfaceVoid myFuncInterfaceVoid = () -> System.out.println("Hello");
        myFuncInterfaceVoid.print();
        //Лямбда с дженериком
        MyFuncInterfaceVoidGeneric myFuncInterfaceVoidGeneric = someObject -> System.out.println(someObject.toString());
        myFuncInterfaceVoidGeneric.print(user1);
        //Лямбда с двумя дженериками
        MyFuncInterfaceVoidTwoGenerics myFuncInterfaceVoidTwoGenerics = (someObject1, someObject2) -> {
            System.out.println(someObject1);
            System.out.println(someObject2);
        };
        myFuncInterfaceVoidTwoGenerics.print(user1,new User("Vika",32));
        //Слово return можно опустить если одна строчка кода
        MyFuncInterfaceSumAgeTwoUsers myFuncInterfaceSumAgeTwoUsers = (User someObject1, User someObject2) -> someObject1.getAge() + someObject2.getAge();
        System.out.println(myFuncInterfaceSumAgeTwoUsers.sum(user1,user2));
    }

}
