package lesson_17_classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //try with resources
        Scanner scanner = new Scanner(System.in);
        try(scanner) {
            //String str = scanner.nextLine();
            // var
            //var string = scanner.nextInt();
        }
        //List.of
        List<Integer> arrayList = List.of(1,2,3,4);
        //Switch
        int number = 1;
        String text = switch (number) {
            case 0 -> "0";

            default -> {
                System.out.println("error");
                yield "error";
            }
        };
        System.out.println(text);
    }
}
