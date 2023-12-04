package shops;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import shops.product.ProductInShop;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shop {
    String nameOfShop;
    ShopType typeOfShop;
    double walletBalance = 0;
    List<ProductInShop> inventory = new ArrayList<>();

    public Shop(String nameOfShop, ShopType typeOfShop) {
        this.nameOfShop = nameOfShop;
        this.typeOfShop = typeOfShop;
    }

    public void receivePayment(double amount) {
        walletBalance += amount;
    }

    public void sellItem(String itemName, int quantity) {
        ProductInShop productInShop = getProductByName(itemName);
        if (productInShop.getQuantity() >= quantity) {
            productInShop.reduceQuantityByNumber(quantity);
        } else {
            throw new RuntimeException("Insufficient quantity of product");
        }
    }

    public void buyItemFromWarehouse(String name, double price, int quantity) {
        if (walletBalance >= price * quantity) {
            inventory.add(ProductInShop.builder()
                    .name(name)
                    .priceAtWarehouse(price)
                    .sellingPrice(price * 1.2)
                    .deliveryTime(typeOfShop.getDeliveryTime())
                    .quantity(quantity)
                    .build());
            walletBalance -= price * quantity;
            System.out.println("Bought " + quantity + " units of " + name);
        } else {
            throw new RuntimeException("Not enough funds");
        }
    }

    public void getInfoAboutAvailableProducts() {
        System.out.println("Available products:");
        inventory.forEach(productInShop -> System.out.println("name: " + productInShop.getName()
                + "; price: " + productInShop.getSellingPrice()
                + "; quantity: " + productInShop.getQuantity()));
    }

    private ProductInShop getProductByName(String name) {
        return inventory.stream()
                .filter(productInShop -> productInShop.getName().equals(name))
                .findFirst()
                .get();
    }

    public double getPriceOfProduct(String nameOfProduct) {
        return getProductByName(nameOfProduct).getSellingPrice();
    }

    public int getDeliveryTimeOfProduct(String nameOfProduct) {
        return getProductByName(nameOfProduct).getDeliveryTime();
    }

    public void changeNameOfProduct(String productName, String newName) {
        getProductByName(productName).setName(newName);
    }

    public void changePriceOfProduct(String productName, double newPrice) {
        getProductByName(productName).setSellingPrice(newPrice);
    }

    public void removeProductFromStore(String productName) {
        inventory.remove(getProductByName(productName));
    }
}
