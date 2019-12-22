package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        int count = 11;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Количество спичек на столе - " + count);
            System.out.println("Ход первого игрока от 1 до 3-х");
            int numberUser1 = Integer.valueOf(input.nextLine());
            count -= numberUser1;
            if (count <= 0) {
                System.out.println("Первый игрок выиграл!");
                break;
            }
            System.out.println("Количество спичек на столе - " + count);
            System.out.println("Ход второго игрока от 1 до 3-х");
            int numberUser2 = Integer.valueOf(input.nextLine());
            count -= numberUser2;
            if (count <= 0) {
                System.out.println("Второй игрок выиграл!");
                break;
            }
        }
    }
}
