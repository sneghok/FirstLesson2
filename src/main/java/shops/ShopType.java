package shops;

import lombok.Getter;

@Getter
public enum ShopType {
    GROCERY(0), ELECTRONICS(1), APPLIANCES(3), BUILDING_MATERIALS(7);

    private final int deliveryTime;

    ShopType(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

}
