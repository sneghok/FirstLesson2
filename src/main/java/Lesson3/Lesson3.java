package Lesson3;

import java.util.Arrays;
import java.util.Random;

public class Lesson3 {
    //    Домашнє завдання:
//    створити масив з 10 різних чисел менших за 100 (не обов'язково але бажано використовуючи клас Random, як ним користуватись пошукаєте в інтернеті)
////    вивести в консоль всі числа які діляться за 2 без остачі
    public static void main(String[] args) {
        Random number = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = number.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i]+" ");
            }
        }
    }
}
