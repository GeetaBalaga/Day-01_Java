import java.util.*;

class Item {

	private String productName;
	private int quantity;
	private double unitPrice;

	/*
	 * 1. Implement the constructor
	 */
	Item(String productName, int quantity, double unitPrice) {
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String toString() {
		String s = this.productName + ":";
		s = s + this.quantity + "\n";
		return s;
	}

	/*
	 * 2. Implement this method
	 */
	public String getProductName() {
		return this.productName;
	}

	/*
	 * 3. Implement this method
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/*
	 * 4. Implement this method
	 */
	public double getUnitPrice() {
		return this.unitPrice;
	}
}
