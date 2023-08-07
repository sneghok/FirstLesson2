package Lesson3;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    //    Домашнє завдання ускладнене
//- створити масив з 10000 різних чисел менших за 100
//            - вивести в консоль скільки разів в масиві зустрілось число 5
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        int hand = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 5) {
                hand++;
            }
        }
        System.out.println(hand);
    }
}
