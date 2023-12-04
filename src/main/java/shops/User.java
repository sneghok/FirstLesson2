package shops;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PROTECTED)
public class User {
    String email;
    String name;
    String password;
    double walletBalance;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public void transferMoney(double amount, Shop shop) {
        if (walletBalance >= amount) {
            walletBalance -= amount;
            shop.receivePayment(amount);
        } else {
            throw new RuntimeException("Insufficient funds in the wallet.");
        }
    }

    public void checkWallet() {
        System.out.println(name + "'s wallet balance: $" + walletBalance);
    }
}
