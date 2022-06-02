package lesson_15_classwork_lambdas;

@FunctionalInterface
interface MyFuncInterfaceVoidTwoGenerics<T> {
    void print(T someObject1 , T someObject2);
}
