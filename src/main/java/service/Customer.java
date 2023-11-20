package service;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a customer.
 */
public class Customer {
    private static final int MULTIPLIER = 1250 * 142 + 2;

    private int count;
    private List<OrderLine> orderLines;

    /**
     * Constructs a new Customer object with the given orderLines.
     * The count of orderLines is also initialized.
     *
     * @param orderLines the list of products ordered by the customer.
     */
    public Customer(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        this.count = orderLines.size();
    }

    /**
     * @return the count of products ordered by the customer.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * @return the list of products ordered by the customer.
     */
    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    /**
     * Adds a new product to the customer's orderLines.
     * If the product already exists, its quantity is incremented.
     * If the product does not exist, it is added to the orderLines.
     * After adding the product, the count of orderLines is updated.
     *
     * @param newOrderLine the new product to be added.
     */
    public void addProduct(OrderLine newOrderLine) {
        boolean productExists = false;

        for (OrderLine orderLine : orderLines) {
            if (isSameProduct(orderLine, newOrderLine)) {
                incrementProductQuantity(orderLine);
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            orderLines.add(newOrderLine);
        }

        this.count = orderLines.size();
    }

    /**
     * Checks if two products are the same based on their name and code.
     *
     * @param orderLine the existing product.
     * @param newOrderLine the new product.
     * @return true if the products are the same, false otherwise.
     */
    private boolean isSameProduct(OrderLine orderLine, OrderLine newOrderLine) {
        return orderLine.getName().equals(newOrderLine.getName()) && orderLine.getCode().equals(newOrderLine.getCode());
    }

    /**
     * Increments the quantity of the given product by 1.
     *
     * @param orderLine the product whose quantity is to be incremented.
     */
    private void incrementProductQuantity(OrderLine orderLine) {
        orderLine.setQuantity(orderLine.getQuantity() + 1);
    }

    /**
     * Calculates the total price of all the products in the orderLines, excluding the product with the given name.
     *
     * @param productNameToAvoid the name of the product to be excluded.
     * @return the total price of all the products excluding the product with the given name.
     */
    public int calculateSum(String productNameToAvoid) {
        int sum = 0;

        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(productNameToAvoid)) {
                sum += orderLine.getPrice() * orderLine.getQuantity();
            }
        }

        return sum;
    }
}

/**
 * A class that represents a product ordered by a customer.
 */
class OrderLine {
    private String name;
    private String code;
    private int quantity;
    private int price;

    /**
     * @return the name of the product.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the quantity of the product.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param quantity the quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price of the product.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the price to set.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the code of the product.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets the code of the product.
     *
     * @param code the code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }
}