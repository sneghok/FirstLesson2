package MontyHall;

import java.util.Random;

public class MontyHall {

    public static void main(String[] args) {
        int totalGames = 1000000;
        int switchWins = 0;
        int stayWins = 0;

        Random random = new Random();

        for (int i = 0; i < totalGames; i++) {
            int carDoor = random.nextInt(3);
            int playerChoice = random.nextInt(3);
            int revealedGoatDoor;
            do {
                revealedGoatDoor = random.nextInt(3);
            } while (revealedGoatDoor == playerChoice || revealedGoatDoor == carDoor);

            if (playerChoice == carDoor) {
                stayWins++;
            } else {
                switchWins++;
            }
        }

        System.out.println("После " + totalGames + " игр:");
        System.out.println("Сменив выбор:");
        System.out.println("Выйгрыши: " + switchWins);
        System.out.println("Проигрыши: " + (totalGames - switchWins));
        System.out.println("Процент выйгрышей: " + ((double) switchWins / totalGames * 100) + "%");

        System.out.println("\nОставив выбор:");
        System.out.println("Выйгрыши: " + stayWins);
        System.out.println("Проигрыши: " + (totalGames - stayWins));
        System.out.println("Процент выйгрышей: " + ((double) stayWins / totalGames * 100) + "%");
    }
}