package com.ehome.controllers;

import com.ehome.entities.Order;
import com.ehome.entities.Product;
import com.ehome.payload.OrderDto;
import com.ehome.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/auth/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = service.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(service.createOrder(orderDto));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Integer orderId) {
        return ResponseEntity.ok(service.getOrderById(orderId));
    }
  


}