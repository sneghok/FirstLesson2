package shops;

public class Main {
    private static UserPool userPool = new UserPool();

    public static void main(String[] args) {
        // Регистрация и действия для продавца
        userPool.registerSeller("seller1@gmail.com", "Seller1", "password1");
        Seller seller = userPool.loginAsSeller("seller1@gmail.com", "password1");
        seller.createShop("Computers", ShopType.ELECTRONICS);
        seller.transferMoney(500, seller.getShopByName("Computers"));
        seller.createShop("Cat shop", ShopType.GROCERY);
        seller.transferMoney(500, seller.getShopByName("Cat shop"));
        seller.getShopByName("Computers").buyItemFromWarehouse("flash drive", 22, 5);
        seller.getShopByName("Cat shop").buyItemFromWarehouse("cat food", 5, 25);

        userPool.registerSeller("seller2@gmail.com", "Seller2", "password2");
        Seller seller2 = userPool.loginAsSeller("seller2@gmail.com", "password2");
        seller2.createShop("Epicenter", ShopType.BUILDING_MATERIALS);
        seller2.transferMoney(500, seller2.getShopByName("Epicenter"));
        seller2.createShop("Atlante", ShopType.BUILDING_MATERIALS);
        seller2.transferMoney(500, seller2.getShopByName("Atlante"));
        seller2.getShopByName("Epicenter").buyItemFromWarehouse("paint", 11, 11);
        seller2.getShopByName("Epicenter").buyItemFromWarehouse("shampoo", 3, 10);
        seller2.getShopByName("Atlante").buyItemFromWarehouse("big lizard", 50, 2);
        seller2.getShopByName("Atlante").buyItemFromWarehouse("plate", 2, 20);

        // Регистрация и действия для покупателя
        userPool.registerBuyer("buyer1@gmail.com", "Buyer1", "password1");
        Buyer buyer = userPool.loginAsBuyer("buyer1@gmail.com", "password1");
        buyer.sellFeetPics();
        buyer.displayShops();
        buyer.enterShopByName("Computers").getInfoAboutAvailableProducts();
        buyer.makePurchase("Computers", "flash drive", 2);
        buyer.enterShopByName("Atlante").getInfoAboutAvailableProducts();
        buyer.makePurchase("Atlante", "big lizard", 1);
        buyer.displayPurchases();
        buyer.checkWallet();

        userPool.registerBuyer("buyer2@gmail.com", "Buyer2", "password2");
        Buyer buyer2 = userPool.loginAsBuyer("buyer2@gmail.com", "password2");
        buyer2.sellFeetPics();
        buyer2.displayShops();
        buyer2.enterShopByName("Cat shop").getInfoAboutAvailableProducts();
        buyer2.makePurchase("Cat shop", "cat food", 5);
        buyer2.enterShopByName("Atlante").getInfoAboutAvailableProducts();
        buyer2.makePurchase("Atlante", "plate", 10);
        buyer2.enterShopByName("Epicenter").getInfoAboutAvailableProducts();
        buyer2.makePurchase("Epicenter", "shampoo", 1);
        buyer2.displayPurchases();
        buyer2.checkWallet();

        userPool.registerBuyer("buyer3@gmail.com", "Buyer3", "password3");
        Buyer buyer3 = userPool.loginAsBuyer("buyer3@gmail.com", "password3");
        buyer3.sellFeetPics();
        buyer3.displayShops();
        buyer3.enterShopByName("Atlante").getInfoAboutAvailableProducts();
        buyer3.makePurchase("Atlante", "big lizard", 1);
        buyer3.enterShopByName("Epicenter").getInfoAboutAvailableProducts();
        buyer3.makePurchase("Epicenter", "paint", 10);
        buyer3.displayPurchases();
        buyer3.checkWallet();

        seller.withdrawMoneyFromShop("Computers");
        seller.withdrawMoneyFromShop("Cat shop");
        seller.checkWallet();

        seller2.withdrawMoneyFromShop("Epicenter");
        seller2.withdrawMoneyFromShop("Atlante");
        seller2.checkWallet();

        seller.getShopByName("Computers").changeNameOfProduct("flash drive", "drive flash");
        seller2.getShopByName("Atlante").changePriceOfProduct("plate", 200);
    }
}

