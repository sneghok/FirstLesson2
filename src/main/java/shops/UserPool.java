package shops;

import java.util.ArrayList;
import java.util.List;

public class UserPool {
    private List<Seller> sellers;
    private List<Buyer> buyers;

    public UserPool() {
        this.sellers = new ArrayList<>();
        this.buyers = new ArrayList<>();
    }

    public Seller registerSeller(String email, String name, String password) {
        if (!isEmailUnique(email)) {
            throw new RuntimeException("Registration failed. User with email " + email + " already exists.");
        }

        Seller seller = new Seller(email, name, password);
        sellers.add(seller);
        System.out.println("Seller registered with email: " + email);
        return seller;
    }

    public Buyer registerBuyer(String email, String name, String password) {
        if (!isEmailUnique(email)) {
            throw new RuntimeException("Registration failed. User with email " + email + " already exists.");
        }

        Buyer buyer = new Buyer(email, name, password);
        buyers.add(buyer);
        System.out.println("Buyer registered with email: " + email);
        return buyer;
    }

    private boolean isEmailUnique(String email) {
        for (User user : getAllUsers()) {
            if (user.email.equals(email)) {
                return false;
            }
        }
        return true;
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        allUsers.addAll(sellers);
        allUsers.addAll(buyers);
        return allUsers;
    }

    public Seller loginAsSeller(String email, String password) {
        for (Seller seller : sellers) {
            if (seller.email.equals(email) && seller.password.equals(password)) {
                System.out.println(seller.name + " logged in as a seller.");
                return seller;
            }
        }
        throw new RuntimeException("Login failed.");
    }

    public Buyer loginAsBuyer(String email, String password) {
        for (Buyer buyer : buyers) {
            if (buyer.email.equals(email) && buyer.password.equals(password)) {
                System.out.println(buyer.name + " logged in as a buyer.");
                return buyer;
            }
        }
        throw new RuntimeException("Login failed.");
    }
}
