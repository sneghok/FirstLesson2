package shops;

import shops.product.PurchasedProduct;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {
    private List<PurchasedProduct> purchases = new ArrayList<>();

    public Buyer(String email, String name, String password) {
        super(email, name, password);
        this.walletBalance = 0;
    }

    public void makePurchase(String shopName, String itemName, int quantity) {
        Shop shop = enterShopByName(shopName);
        double payment = shop.getPriceOfProduct(itemName) * quantity;
        transferMoney(payment, shop);
        shop.sellItem(itemName, quantity);
        addToPurchases(itemName, shop.getPriceOfProduct(itemName), quantity, shop.getDeliveryTimeOfProduct(itemName));
        System.out.println(quantity + " units of " + itemName + " bought from the shop.");
    }

    private void addToPurchases(String nameOfProduct, double priceOfProduct, int quantity, int deliveryTimeOfProduct) {
        purchases.add(PurchasedProduct.builder()
                .name(nameOfProduct)
                .purchasedPrice(priceOfProduct)
                .quantity(quantity)
                .deliveryTime(deliveryTimeOfProduct)
                .build());
    }

    public void displayPurchases() {
        System.out.println("Purchases made by " + name + ":");
        purchases.forEach(System.out::println);
    }

    public void displayShops() {
        System.out.println("Available shops:");
        for (Shop shop : ShopRegistry.shops) {
            System.out.println(shop.getNameOfShop());
        }
    }

    public Shop enterShopByName(String shopName) {
        for (Shop shop : ShopRegistry.shops) {
            if (shop.getNameOfShop().equals(shopName)) {
                return shop;
            }
        }
        throw new RuntimeException("No shop available with such name: " + shopName);
    }

    public void sellFeetPics() {
        walletBalance += 3000;
    }
}
