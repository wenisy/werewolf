package com.cogrood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orderID;

    //TODO
//    private Map<String, Map<String, Double>> participants;

    private Date createDate;
}
