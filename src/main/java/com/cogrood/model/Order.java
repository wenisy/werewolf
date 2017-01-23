package com.cogrood.model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Map;

@Entity
public class Order {
    private String orderID;

    //TODO
    private Map<String, Map<String, Double>> participants;

    private Date createDate;
}
