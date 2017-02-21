package com.werewolf.controller;

import com.werewolf.exception.DatabaseOperationException;
import com.werewolf.model.OrderForm;
import com.werewolf.repository.OrderFormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderFoodController {


    @Autowired
    private OrderFormRepository orderFormRepository;
    private final Logger logger = LoggerFactory.getLogger(OrderFoodController.class);

    @RequestMapping(value = "/orders")
    public ResponseEntity getOrder(@RequestParam("orderId") String orderId) {
        //TODO
        OrderForm orderForm = orderFormRepository.findOne(orderId);
        if (null != orderForm) {
            return ResponseEntity.ok(orderForm);
        } else {
            return ResponseEntity.badRequest().body(orderId);
        }
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity saveOrder(@RequestBody OrderForm orderForm) {
        try {
            if (!orderFormRepository.exists(orderForm.getOrderId())) {
                orderFormRepository.save(orderForm);
                return ResponseEntity.ok().build();
            } else {
                throw new DatabaseOperationException("this entity has already existed");
            }
        } catch (RuntimeException e) {
            logger.error("can not save to database {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
