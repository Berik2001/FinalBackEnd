package com.example.finaldiploma.service;

import com.example.finaldiploma.dto.OrderRequest;
import com.example.finaldiploma.model.Order;
import com.example.finaldiploma.model.Product;
import com.example.finaldiploma.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
    public List<Order> findAllOrderByUserId(Long orderId) {
        return orderRepository.findAllByUserId(orderId);

    }

    public Order updateOrder(OrderRequest order) {
        Order old = orderRepository.getById(order.getId());
        old.setProductName(order.getProductName());
        LocalDate startDate = LocalDate.parse(order.getStartDate());
        old.setStartDate(Date.valueOf(startDate));
        LocalDate endDate = LocalDate.parse(order.getEndDate());
        old.setEndDate(Date.valueOf(endDate));
        old.setTotalPrice(order.getTotalPrice());
        old.setUsername(order.getUsername());
        old.setPhone(order.getPhone());
        orderRepository.save(old);
        return old;
    }

    public Order createOrder(OrderRequest order) {
        Order newOrder = new Order();
        newOrder.setProductName(order.getProductName());
        LocalDate startDate = LocalDate.parse(order.getStartDate());
        newOrder.setStartDate(Date.valueOf(startDate));
        LocalDate endDate = LocalDate.parse(order.getEndDate());
        newOrder.setEndDate(Date.valueOf(endDate));
        newOrder.setTotalPrice(order.getTotalPrice());
        newOrder.setUsername(order.getUsername());
         newOrder.setPhone(order.getPhone());

        orderRepository.save(newOrder);
        return newOrder;
    }


    public void deleteOrder(int id) {
        orderRepository.deleteById(Long.valueOf(id));
    }
    public void deleteOrderByUserId(Long id) {
        orderRepository.deleteById(Long.valueOf(id));
    }

}
