package com.cogrood.controller;

import com.cogrood.model.Order;
import com.cogrood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderFoodController {

    private final OrderService orderService;

    @Autowired
    public OrderFoodController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/orders")
    public ResponseEntity getOrder(@RequestParam("orderID") String[] orderID) {
        //TODO
        List<String> orders = orderService.getOrder(orderID);
        if (null != orders && !orders.isEmpty()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body(orderID);
        }
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity saveOrder(Order order) {
        //TODO
        boolean saveFlag = orderService.saveOrder(order);
        if (saveFlag) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
