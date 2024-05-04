package com.likelion.lionshop.repository;

import com.likelion.lionshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
