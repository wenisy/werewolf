package com.cogrood.controller;

import com.cogrood.model.OrderForm;
import com.cogrood.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFoodController {


    private final OrderRepository orderRepository;

    @Autowired
    public OrderFoodController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "/orders")
    public ResponseEntity getOrder(@RequestParam("orderID") String orderID) {
        //TODO
        OrderForm orderForm = orderRepository.getOne(orderID);
        if (null != orderForm) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body(orderID);
        }
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity saveOrder(OrderForm orderForm) {
        //TODO
        try {
            orderRepository.save(orderForm);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
