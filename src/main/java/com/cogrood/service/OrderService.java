package com.cogrood.service;

import com.cogrood.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderService {
    boolean saveOrder(Order order);

    List<String> getOrder(String[] orderID);
}
