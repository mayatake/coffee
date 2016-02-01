package com.example.repository;

import com.example.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByDoneFalse();
    //@Query("SELECT x FROM Customer x ORDER BY x.firstName")
    //List<Order> findAllOrderByName();

    //@Query("SELECT x FROM Customer x ORDER BY x.firstName")
    //Page<Order> findAllOrderByName(Pageable pageable);
}
