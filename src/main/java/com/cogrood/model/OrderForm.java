package com.cogrood.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrderForm {
    @Id
    private String orderID;

    //TODO
//    private Map<String, Map<String, Double>> participants;

    private Date createDate;

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getOrderID() {
        return orderID;
    }
}
