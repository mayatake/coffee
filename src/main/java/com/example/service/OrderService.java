package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Order;
import com.example.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> findAll() {
		//return orderRepository.findAllOrderByName();
		return orderRepository.findAll();
	}
	
	//public Page<Order> findAll(Pageable pageable) {
		//return orderRepository.findAllOrderByName(pageable);
		
	//}
	
	public Order findOne(Integer id) {
		return orderRepository.findOne(id);
	}
	
	public List<Order> findByDoneFalse() {
		return orderRepository.findByDoneFalse();
	}
	
	public Order create(Order customer) {
		return orderRepository.save(customer);
	}
	
	public Order update(Order customer) {
		return orderRepository.save(customer);
	}
	
	public void delete(Integer id) {
		orderRepository.delete(id);
	}
}
