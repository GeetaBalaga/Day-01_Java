import java.util.*;

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Item> cartItems = new ArrayList<>();

    public void addToCart(Item item) {
        cartItems.add(item);
    }

    public void removeFromCart(Item item) {
        cartItems.remove(item);
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Item item : cartItems) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
        return totalAmount;
    }

    public double getPayableAmount() {
        // Let's assume there are no discounts or taxes for simplicity
        return getTotalAmount();
    }

    public void applyCoupon(String couponCode) {
        // Implement the coupon code logic here (not provided in the initial code)
    }

    public void printInvoice() {
        System.out.println("Invoice:");
        for (Item item : cartItems) {
            System.out.println(item.getName() + " - " + item.getQuantity() + " x $" + item.getPrice());
        }
        System.out.println("Total Amount: $" + getTotalAmount());
        System.out.println("Payable Amount: $" + getPayableAmount());
        System.out.println();
    }

    public void showCart() {
        System.out.println("Shopping Cart:");
        for (Item item : cartItems) {
            System.out.println(item.getName() + " - " + item.getQuantity() + " x $" + item.getPrice());
        }
        System.out.println();
    }
}

public class ShoppingCartTest {
    public static void main(String[] args) {

        Item i1 = new Item("Rice", 1, 1000);
        Item i2 = new Item("Dal", 2, 150);
        Item i3 = new Item("Chocolate", 4, 50);
        Item i4 = new Item("Oil", 2, 200);
        Item i5 = new Item("Soap", 5, 80);

        ShoppingCart cart = new ShoppingCart();

        /*
         * 8. Add all the items to the cart
         */

        cart.addToCart(i1);
        cart.addToCart(i2);
        cart.addToCart(i3);
        cart.addToCart(i4);
        cart.addToCart(i5);

        cart.showCart();

        /* remove the item sent as an argument from the cart */
        cart.removeFromCart(i3);

        cart.showCart();

        double totalAmount = cart.getTotalAmount();
        System.out.println("Total Amount: $" + totalAmount);

        double payableAmount = cart.getPayableAmount();
        System.out.println("Payable Amount: $" + payableAmount);

        /* apply a coupon code */
        cart.applyCoupon("Geeta20");

        cart.printInvoice();

        cart.applyCoupon("Geeta10");

        cart.printInvoice();

        cart.addToCart(new Item("Sugar", 5, 60));

        cart.printInvoice();
    }
}
