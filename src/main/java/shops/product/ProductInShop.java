package shops.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductInShop {
    private String name;
    private double priceAtWarehouse;
    private double sellingPrice;
    private int quantity;
    private int deliveryTime;

    public void reduceQuantityByNumber(int amount) {
        quantity -= amount;
    }
}
