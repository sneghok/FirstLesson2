package Flowers;

import java.util.Scanner;

public class Bouquet {
    static Flower rose = new Flower("Rose", 55, 50);
    static Flower lily = new Flower("Lily", 100, 30);
    static Flower peony = new Flower("Peony", 15, 20);
    static Flower popy = new Flower("Popy", 10, 15);
    static Flower orchid = new Flower("Orchid", 80, 50);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wallet = 1000;
        while (hasEnoughMoneyToBuyFlower(wallet) && hasEnoughQuantityOfFlowers()) {
            System.out.println("Choose flower");
            String nameOfFlower = scanner.nextLine();
            System.out.println(nameOfFlower);
            Flower[] array = {rose, lily, peony, popy, orchid};
            boolean found = false;
            for (Flower flower : array) {
                if (found) break;
                if (nameOfFlower.equals(flower.getName())) {
                    found = true;
                    if (flower.getQuantity() == 0) {
                        System.out.println("We ran out of " + nameOfFlower);
                    } else {
                        if (wallet >= flower.getPrice()) {
                            System.out.println("You have enough money to buy " + nameOfFlower);
                            wallet = wallet - flower.getPrice();
                            flower.setQuantity(flower.getQuantity() - 1);
                            System.out.println("Money left: " + wallet);
                        } else System.out.println("You have not enough money to buy " + nameOfFlower);
                    }
                }

            }
            if (!found) System.out.println("Flower with name " + nameOfFlower + " not found");
        }
    }

    private static boolean hasEnoughMoneyToBuyFlower(int wallet) {
        boolean canBuy = false;
        if (rose.getQuantity() > 0 && wallet > rose.getPrice()) canBuy = true;
        if (lily.getQuantity() > 0 && wallet > lily.getPrice()) canBuy = true;
        if (peony.getQuantity() > 0 && wallet > peony.getPrice()) canBuy = true;
        if (popy.getQuantity() > 0 && wallet > popy.getPrice()) canBuy = true;
        if (orchid.getQuantity() > 0 && wallet > orchid.getPrice()) canBuy = true;
        return canBuy;
    }

    private static boolean hasEnoughQuantityOfFlowers() {
        return rose.getQuantity() + lily.getQuantity() + peony.getQuantity() + popy.getQuantity() + orchid.getQuantity() > 0;
    }
}
