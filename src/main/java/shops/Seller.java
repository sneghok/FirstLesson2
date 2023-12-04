package shops;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
    private List<Shop> shops;

    public Seller(String email, String name, String password) {
        super(email, name, password);
        this.walletBalance = 1000;
        this.shops = new ArrayList<>();
    }

    public void createShop(String shopName, ShopType type) {
        System.out.println(name + " is creating a shop: " + shopName);
        Shop shop = new Shop(shopName, type);
        shops.add(shop);
        ShopRegistry.shops.add(shop);
    }

    public void withdrawMoneyFromShop(String name) {
        Shop shop = getShopByName(name);
        System.out.println("Withdrawn from shop " + shop.getNameOfShop() + ": $" + shop.getWalletBalance());
        walletBalance += shop.getWalletBalance();
        shop.setWalletBalance(0);
    }

    public Shop getShopByName(String name) {
        return shops.stream()
                .filter(shop -> shop.getNameOfShop().equals(name))
                .findFirst()
                .get();
    }

    public void checkShopWallets() {
        shops.forEach(shop -> System.out.println(shop.getNameOfShop() + ": left in wallet $" + shop.getWalletBalance()));
    }
}
