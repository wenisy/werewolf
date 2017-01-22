package com.cogrood.service;

import com.cogrood.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Override
    public boolean saveOrder(Order order) {
        return false;
    }

    @Override
    public List<String> getOrder(String[] orderID) {
        return null;
    }

}
