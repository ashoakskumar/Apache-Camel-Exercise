package com.ashok.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.ashok.example.dto.Order;

@Service
public class OrderService {

	private List<Order> orderList = new ArrayList<>();
	
	@PostConstruct
	public void initDB() {
		orderList.add(new Order(67,"Mobile",5000));
		orderList.add(new Order(89,"Book",400));
		orderList.add(new Order(45,"AC",15000));
		orderList.add(new Order(67,"Shoes",1000));
	}
	
	public Order addOrder(Order order) {
		orderList.add(order);
		return order;
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}
}
