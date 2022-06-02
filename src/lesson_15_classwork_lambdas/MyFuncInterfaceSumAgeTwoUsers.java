package lesson_15_classwork_lambdas;

@FunctionalInterface
interface MyFuncInterfaceSumAgeTwoUsers<T extends User> {
    int sum(T someObject1 , T someObject2);
}
