package com.groceryshop.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.groceryshop.demo.entitites.OrderEntity;
import com.groceryshop.demo.repository.OrderRepository;

	@Service
	public   class OrderServiceImp implements OrderServiceInt {
	    
	@Autowired
	public OrderRepository orderRepository;
	/**
     * addOrderEntity
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderRepsitory we are finding if the object sent is present in the database or not by using the
     * method add and saved in bean and returned getId
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */
	
	public long add(OrderEntity bean)  {
		OrderEntity order = orderRepository.save(bean);
		System.out.println(order);
		return order.getId();
	}
	/**
     * updateOrderEntity
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderRepsitory we are finding if the object sent is present in the database or not by using the
     * method update and saved in bean and returned getId
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */

	public long update(OrderEntity bean) {
		OrderEntity order = orderRepository.save(bean);
		return order.getId();
	}
	/**
     * deleteOrderEntity
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderRepsitory we are finding if the object sent is present in the database or not by using the
     * method delete in bean and returned bean
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */
	
	public OrderEntity delete(OrderEntity bean) {
		orderRepository.delete(bean);
		return bean;

	}
	/**
     * findByName
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderRepsitory we are finding if the object sent is present in the database or not by using the
     * method findByName in bean and returned name
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */

	public OrderEntity findByName(String name) {
		return orderRepository.findByName(name);
	}
	/**
     * findBypk
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderRepsitory we are finding if the object sent is present in the database or not by using the
     * method findByPk in bean and returned null.
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */

	

	public OrderEntity findByPk(long orderPk) {
		return orderRepository.findById ( orderPk).orElse(null);
	}
	/**
     * ListOrderEntity
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderRepsitory we are finding if the object sent is present in the database or not by using the
     * method checks in list in bean and returned name.
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */

	public List<OrderEntity> search(OrderEntity bean) {
     
		return (List<OrderEntity>) orderRepository.findByName(bean.getName());
	}
	/**
     * findByOrder
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderRepsitory we are finding if the object sent is present in the database or not by using the
     * method findByOrderId in bean and returned null.
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */

    public Object findByOrderId(int i) {
        // TODO Auto-generated method stub
        return null;
    }
	
	}

