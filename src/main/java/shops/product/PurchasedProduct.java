package shops.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchasedProduct {
    private String name;
    private double purchasedPrice;
    private int quantity;
    private int deliveryTime;
}
