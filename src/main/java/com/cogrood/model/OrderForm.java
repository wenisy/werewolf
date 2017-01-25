package com.cogrood.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OrderForm {
    @Id
    private String orderId;

    private Date createDate;

    public OrderForm(String orderId, Date createDate) {
        this.orderId = orderId;
        this.createDate = createDate;
    }

    public OrderForm() {
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getOrderId() {
        return orderId;
    }
}
