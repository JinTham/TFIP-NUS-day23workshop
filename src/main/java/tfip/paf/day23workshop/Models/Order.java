package tfip.paf.day23workshop.Models;

import java.sql.Date;

public class Order {
    
    private Integer orderId;
    private Date orderDate;
    private Integer customerId;
    private Float totalPrice;
    private Float costPrice;
    
    public Order() {
    }
    public Order(Integer orderId, Date orderDate, Integer customerId, Float totalPrice, Float costPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.costPrice = costPrice;
    }
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Float getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Float getCostPrice() {
        return costPrice;
    }
    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    

}
