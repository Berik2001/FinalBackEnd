package com.example.finaldiploma.controllers;

import com.example.finaldiploma.dto.OrderRequest;
import com.example.finaldiploma.model.Order;
import com.example.finaldiploma.model.Product;
import com.example.finaldiploma.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    private List<Order> getAll() {
        List<Order> orders= orderService.getOrders();
        return orders;
    }
    @GetMapping("/{id}")
    private List<Order> findAllOrderByUserId(@PathVariable("id") Long id) {
        return orderService.findAllOrderByUserId(id);
    }

    @PostMapping("/create")
    private Order createOrder(@RequestBody OrderRequest order) {
        return orderService.createOrder(order);
    }


    @PutMapping
    private ResponseEntity<Order> updateOrder(@RequestBody OrderRequest order) {
        Order newOrder = orderService.updateOrder(order);
        return ResponseEntity.ok(newOrder);
    }


    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("deleted");
    }

    @DeleteMapping("/delete/user/{id}")
    private ResponseEntity<String> deleteOrderByUserId(@PathVariable("id") Long id) {
        orderService.deleteOrderByUserId(id);
        return ResponseEntity.ok("deleted");
    }

}
