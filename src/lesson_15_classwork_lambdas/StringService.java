package lesson_15_classwork_lambdas;

class StringService {
    void process (String text, StringInterface stringInterface) {
        stringInterface.doSomething(text);
    }
}
