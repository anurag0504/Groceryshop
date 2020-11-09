package com.groceryshop.demo.service;

import java.util.List;

import com.groceryshop.demo.entitites.OrderEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;

public interface OrderServiceInt {

public long add(OrderEntity bean) throws DuplicateRecordException;
	
	public void update(OrderEntity bean);
	
	public void delete(OrderEntity bean);
	
	public OrderEntity findByName(String name);
	
	public OrderEntity findByPk(long id);
	
	public List<OrderEntity> search(OrderEntity bean, long pageNo, int pageSize);
	
	public List<OrderEntity> search(OrderEntity bean);
}
