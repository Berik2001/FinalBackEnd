package com.example.finaldiploma.repository;

import com.example.finaldiploma.model.Order;
import com.example.finaldiploma.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserId(Long orderId);
    public void deleteOrderByUserId(Long userId);

}

