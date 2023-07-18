import java.util.ArrayList;
import java.util.ListIterator;

class ShoppingCart {

    ArrayList<Item> item;
    double totalAmount;
    double payableAmount;
    double discount;
    double tax;
    String coupon;

    ShoppingCart() {
        this.item = new ArrayList<>();
        this.coupon = "";
        this.totalAmount = 0;
        this.payableAmount = 0;
        this.discount = 0;
        this.tax = 0;
    }

    /*
     * 5. Add parameter to cart
     * This method adds an item to the shopping cart.
     * @param item: The item to be added to the cart
     */
    void addToCart(Item item) {
        this.item.add(item);
    }

    /**
     * 6. Display the cart Items using iterator
     * This method displays the items in the shopping cart using an iterator.
     */
    public void showCart() {
        ListIterator<Item> iterator = item.listIterator();
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            System.out.println("Product: " + currentItem.getProductName() +
                    "\tQuantity: " + currentItem.getQuantity() +
                    "\tUnit Price: " + currentItem.getUnitPrice() +
                    "\tTotal Price: " + (currentItem.getUnitPrice() * currentItem.getQuantity()));
        }
    }

    /**
     * 7. Remove the item from cart
     * This method removes the specified item from the shopping cart.
     * @param i: The item to be removed from the cart
     */
    public void removeFromCart(Item i) {
        this.item.remove(i);
    }

    /*
     * Helper method to calculate the total amount of items in the cart.
     * This method iterates through the items and calculates the total amount by multiplying the unit price with quantity for each item.
     */
    public double getTotalAmount() {
        ListIterator<Item> iterator = item.listIterator();
        this.totalAmount = 0;
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            this.totalAmount += (currentItem.getUnitPrice() * currentItem.getQuantity());
        }
        return this.totalAmount;
    }

    /*
     * Helper method to apply a coupon to the cart.
     * If the coupon is "IND10", a discount of 10% is applied to the total amount.
     * The total amount is updated accordingly after applying the discount.
     */
    public void applyCoupon(String coupon) {
        this.coupon = coupon;
        if (coupon.equals("IND10")) {
            this.discount = this.getTotalAmount() * (0.1);
            this.totalAmount = this.totalAmount - this.discount;
        } else {
            this.totalAmount = this.totalAmount;
        }
    }

    /*
     * Helper method to calculate the payable amount.
     * This method calculates the tax (14% of the total amount) and adds it to the total amount.
     */
    public double getPayableAmount() {
        this.tax = this.totalAmount * (0.14);
        this.payableAmount = this.totalAmount + this.tax;
        return this.payableAmount;
    }

    /*
     * This method prints the invoice of the shopping cart.
     * It displays the individual items, total amount, discount (if coupon applied), tax, and payable amount.
     */
    public void printInvoice() {
        ListIterator<Item> iterator = item.listIterator();
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            System.out.print(currentItem.getProductName() + "\t");
            System.out.print(currentItem.getQuantity() + "\t");
            System.out.print(currentItem.getUnitPrice() + "\t");
            System.out.println(currentItem.getUnitPrice() * currentItem.getQuantity());
        }
        System.out.println("\t\t\t" + "Total    : " + this.getTotalAmount());
        this.applyCoupon(this.coupon);
        System.out.println("\t\t\t" + "Discount : " + this.discount);
        this.getPayableAmount();
        System.out.println("\t\t\t" + "Tax      : " + this.tax);
        System.out.println("\t\t\t" + "Total    : " + this.getPayableAmount());
    }
}
