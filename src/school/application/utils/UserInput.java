package school.application.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        System.out.println("Вы ввели не целоe число. Повторите ввод");
        scanner.next();
        return getInt();
    }

    public static String getStr() {
        return scanner.next();
    }

    public static List<Integer> getListInteger(){
        List<Integer> integers  = new ArrayList<>();
        System.out.println("Введите значение[0 - конец ввода]");
        while (true){
            int integer =getInt();
            if (integer==0)break;
            integers.add(integer);
            System.out.println("Ведите еще оценку");
        }
        return integers;
    }
}

