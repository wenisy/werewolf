package com.cogrood.service;

import com.cogrood.model.Order;

import java.util.List;

public interface OrderService {
    boolean saveOrder(Order order);

    List<String> getOrder(String[] orderID);
}
