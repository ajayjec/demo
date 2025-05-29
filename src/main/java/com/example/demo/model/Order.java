package com.example.demo.model;

public class Order {
    private Long id;
    private String customerName;
    private String pizzaType;
    private int quantity;
    private String status;

    public Order() {}

    public Order(Long id, String customerName, String pizzaType, int quantity, String status) {
        this.id = id;
        this.customerName = customerName;
        this.pizzaType = pizzaType;
        this.quantity = quantity;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getPizzaType() { return pizzaType; }
    public void setPizzaType(String pizzaType) { this.pizzaType = pizzaType; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
